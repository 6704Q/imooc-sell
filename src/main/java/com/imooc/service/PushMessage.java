package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/6/1 0001
 * Time:20:06
 * Desc 消息推送
 */
public interface PushMessage {

    /**
     * 订单状态消息推送
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);

}
