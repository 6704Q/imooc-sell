package com.imooc.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /**商品名字**/
    private String productName;

    /**商品单价**/
    private BigDecimal productPrice;

    /**商品库存**/
    private Integer productStock;

    /**商品描述**/
    private String productDescription;

    /**商品小图**/
    private String productIcon;

    /**商品状态0正常 1下架**/
    private Integer productStatus;

    /**类目编号**/
    private Integer categoryType;

    /**创建时间**/
    private Date createTime;

    /**更新时间**/
    private Date updateTime;


}