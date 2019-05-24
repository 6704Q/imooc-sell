package com.imooc.dto;

import lombok.Data;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/14 0014
 * Time:1
 * Desc购物车
 */
@Data
public class CartDTO {

    //商品ID
    private String productId;

    //商品库存
    private Integer productStock;

    public CartDTO(String productId, Integer productStock) {
        this.productId = productId;
        this.productStock = productStock;
    }
}
