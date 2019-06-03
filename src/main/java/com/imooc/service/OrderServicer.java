package com.imooc.service;

import com.imooc.dto.OrderDTO;
import com.imooc.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/13 0013
 * Time:15:02
 * Desc订单service
 */
public interface OrderServicer {

    /**创建订单**/
    OrderDTO create(OrderDTO orderDTO);

    /**查询单个订单**/
    OrderDTO findOne(String orderId);

    /**查询用户订单列表**/
    Page<OrderDTO> findList(String byuerOpenid, Pageable pageable);

    /**查询所有订单列表**/
    Page<OrderDTO> findList(Pageable pageable);

    /**完结订单**/
    OrderDTO cancel(OrderDTO orderDTO);

    /**取消订单**/
    OrderDTO finish(OrderDTO orderDTO);

    /**支付订单**/
    OrderDTO pay(OrderDTO orderDTO);
}
