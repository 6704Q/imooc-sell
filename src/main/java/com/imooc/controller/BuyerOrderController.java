package com.imooc.controller;

import com.imooc.VO.ResultVO;
import com.imooc.convert.OrderFormToOrderDTO;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import com.imooc.service.impl.OrderServiceImpl;
import com.imooc.utils.ResultVOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/15 0015
 * Time:14:09
 * Desc 订单controller层
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderServiceImpl orderService;



    /**
     * 创建订单
     * @param orderForm 前端表单对应数据对象
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】表单数据不正确 orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderFormToOrderDTO.convent(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO dto = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderid",dto.getOrderId());
        return ResultVOUtils.success(map);
    }

    /**
     * 订单列表
     * @param openid 用户微信ID
     * @param page 页数
     * @param size 数量
     * @return
     */
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size){
        if (StringUtils.isEmpty(openid)){
            log.error("【订单列表】openID为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid,pageRequest);
        return ResultVOUtils.success(orderDTOPage.getContent());
    }

    /**
     *获取订单详情
     * @param openid 用户微信ID
     * @param orderId 订单ID
     * @return
     */
    @GetMapping("/detil")
    public ResultVO<List<OrderDTO>> detil(@RequestParam("openid") String openid,
                                         @RequestParam("orderId") String orderId){
        orderIsUser(orderId,openid);
        OrderDTO orderDTO = orderService.findOne(orderId);
        return ResultVOUtils.success(orderDTO);
    }

    /**
     * 取消订单
     * @param openid 微信ID
     * @param orderId 订单ID
     * @return
     */
    @GetMapping("/cancel")
    public ResultVO<List<OrderDTO>> cancel(@RequestParam("openid") String openid,
                                          @RequestParam("orderId") String orderId){
        orderIsUser(orderId,openid);
        OrderDTO orderDTO = orderService.findOne(orderId);
        OrderDTO result = orderService.cancel(orderDTO);
        return ResultVOUtils.success(result);
    }

    /**
     * 判断该订单时候属于当前用户
     * @param orderid 订单ID
     * @param openid 微信ID
     */
    private void orderIsUser(String orderid,String openid){
        OrderDTO orderDTO = orderService.findOne(orderid);
        if (orderDTO == null){
            log.error("【订单信息】 没有该订单 orderid = {}",orderid );
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (!orderDTO.getBuyerOpenid().equals(openid)){
            log.error("【订单信息】 该订单不是当前用户的，无权操作 orderid = {},openid = {]",orderid,openid );
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
    }

}
