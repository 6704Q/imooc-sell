package com.imooc.controller;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.OrderServicer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/25 0025
 * Time:15:44
 * Desc 卖家段订单
 */
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderServicer orderServicer;

    /**
     * 订单列表
     * @param page 当前页
     * @param size 每页数量
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map){
        PageRequest request = new PageRequest(page-1,size);
        Page<OrderDTO> orderDTOPage = orderServicer.findList(request);
        map.put("orderDTOPage",orderDTOPage);
        map.put("currentPage",page);
        map.put("size",size);
        Integer num = new Long(orderDTOPage.getTotalElements()).intValue();
        map.put("totalNum",num);
        log.info("【总数】 num ={}",num);
        return new ModelAndView("order/list",map);
    }

    /**
     * 订单列表
     * @param page 当前页
     * @param limit 每页数量
     * @return
     */
    @RequestMapping("/sellList")
    @ResponseBody
    public Map<String,Object> sellList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                             Map<String,Object> map){
        PageRequest request = new PageRequest(page-1,limit);
        Page<OrderDTO> orderDTOPage = orderServicer.findList(request);
        map.put("data",orderDTOPage);
        map.put("page",page);
        map.put("limit",limit);
        map.put("code",0);
        map.put("msg","成功");
        Integer num = new Long(orderDTOPage.getTotalElements()).intValue();
        map.put("count",num);
        log.info("【总数】 num ={}",num);
        return map;
    }


    /**
     * 取消订单
     * @param orderId 订单ID
     * @param map
     * @return
     */
    @GetMapping("cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,Map<String,Object> map){
           try {
               OrderDTO orderDTO = orderServicer.findOne(orderId);
               orderServicer.cancel(orderDTO);
           }catch (SellException e){
               log.error("【卖家段取消订单】 订单不存在 orderID = {}",orderId);
               map.put("msg",e.getMessage());
               map.put("url","/sell/seller/order/list");
               return new ModelAndView("common/error",map);
           }
                map.put("msg",ResultEnum.SUCCESS_MSG.getMessage());
                map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,Map<String,Object> map){
        try {
            OrderDTO orderDTO = orderServicer.findOne(orderId);
            orderServicer.finish(orderDTO);
        }catch (SellException e){
            log.error("【卖家段订单操作】 订单完结异常 {}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg",ResultEnum.SUCCESS_MSG.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }

    /**
     * 订单详情
     * @param orderId 订单ID
     * @param map
     * @return
     */
    @GetMapping("/detial")
    public ModelAndView detial(@RequestParam("orderId") String orderId,Map<String,Object> map){
        try {
            OrderDTO orderDTO = orderServicer.findOne(orderId);
            map.put("orderDTO",orderDTO);
        }catch (SellException e){
            log.error("【卖家端查询订单详情】 出现异常 {}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        return new ModelAndView("/order/detial",map);
    }

}
