package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.OrderServicer;
import com.imooc.service.PayService;
import com.imooc.utils.JsonUtil;
import com.imooc.utils.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.math.BigDecimal;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/24 0024
 * Time:21:22
 * Desc 支付接口实现类
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    private static final String ORDER_NAME ="微信点餐";

    @Autowired
    BestPayServiceImpl bestPayService;

    @Autowired
    OrderServicer orderServicer;

    /**
     * 微信生成预支付订单
     * @param orderDTO
     * @return
     */
    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【生成预支付结果】payRequest = {}", JsonUtil.toJson(payRequest));
        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【生成预支付结果】payResponse = {}",JsonUtil.toJson(payResponse));
        return payResponse;
    }

    /**
     * 微信异步通知
     * @param notify
     * @return
     */
    @Override
    public PayResponse notify(String notify) {
        //1.验证签名 验证是否是微信发来的请求
        //2. 支付状态判断
        //3. 支付金额验证 验证支付的金额是否与数据库金额相等
        //4. 支付人 （好友代支付）
        // 1 ，2  BestPay以做验证
        PayResponse payResponse = bestPayService.asyncNotify(notify);
        String orderId = payResponse.getOrderId();
        // 查询订单
        OrderDTO orderDTO = orderServicer.findOne(orderId);

        //判断订单是否存在
        if (orderDTO == null){
            log.error("【微信支付异步通知】订单不存在 订单ID = {}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //判断金额是否一致 (0.01  0.010)
        if (!MathUtil.equals(orderDTO.getOrderAmount().doubleValue(),payResponse.getOrderAmount())){
            log.error("【微信支付异步通知】订单金额不一致 订单ID = {} ，本地金额 = {} , 微信金额 = {}",orderId,orderDTO.getOrderAmount(),payResponse.getOrderAmount());
            throw new SellException(ResultEnum.ORDER_MONER_ERROR);
        }

        //修改订单支付状态
        orderServicer.pay(orderDTO);
        log.info("【微信异步通知】 payResponse = {}",JsonUtil.toJson(payResponse));
        return payResponse;
    }

    /**
     * 微信退款
     * @param orderDTO
     */
    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信退款】 refundRequest = {}",JsonUtil.toJson(refundRequest));
        RefundResponse refundResponse = bestPayService.refund(refundRequest);
        log.info("【微信退款】 refundResponse = {}",JsonUtil.toJson(refundResponse));
        return refundResponse;
    }
}
