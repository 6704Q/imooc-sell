package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.entity.OrderDetail;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import com.imooc.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/13 0013
 * Time:15:10
 * Desc订单数据传输类
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)//为空的列前端不反回
public class OrderDTO {

    private String orderId;

    /*买家名字*/
    private String buyerName;

    /*买家电话*/
    private String buyerPhone;

    /*买家地址*/
    private String buyerAddress;

    /*买家微信Openid*/
    private String buyerOpenid;

    /*订单总金额*/
    private BigDecimal orderAmount;

    /*订单状态 默认=0 新下单*/
    private Integer orderStatus;

    /*支付状态 默认=0 未支付*/
    private Integer payStatus;

    /*订单创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /*订单更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList;

}
