package com.imooc.service;

import com.imooc.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/24 0024
 * Time:21:21
 * Desc 支付接口
 */
public interface PayService {

        PayResponse create(OrderDTO orderDTO);

        PayResponse notify(String notify);

        RefundResponse refund(OrderDTO orderDTO);

}
