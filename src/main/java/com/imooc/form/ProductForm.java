package com.imooc.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/28 0028
 * Time:15:13
 * Desc 商品form
 */
@Data
public class ProductForm {

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

}
