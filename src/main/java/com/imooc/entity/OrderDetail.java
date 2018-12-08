package com.imooc.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class OrderDetail {

    @Id
    /*主键ID*/
    private String detailId;

    /*订单ID*/
    private String orderId;

    /*商品ID*/
    private String productId;

    /*商品名称*/
    private String productName;

    /*单价*/
    private BigDecimal productPrice;

    /*商品数量*/
    private Integer productQuantity;

    /*商品图片*/
    private String productIcon;

    /*创建时间*/
    private Date createTime;

    /*更新时间*/
    private Date updateTime;

}