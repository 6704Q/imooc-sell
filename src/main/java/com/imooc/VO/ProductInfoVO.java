package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2018/9/29 0029
 * Time:9:22
 * Desc
 */
@Data
public class ProductInfoVO implements Serializable {


    private static final long serialVersionUID = -3895834204864685262L;

    @JsonProperty("id")
    private String productId;

    /**商品名字**/
    @JsonProperty("name")
    private String productName;

    /**商品单价**/
    @JsonProperty("price")
    private BigDecimal productPrice;

    /**商品描述**/
    @JsonProperty("description")
    private String productDescription;

    /**商品小图**/
    @JsonProperty("icon")
    private String productIcon;

}
