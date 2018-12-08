package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2018/9/29 0029
 * Time:9:18
 * Desc
 */
@Data
public class ProductVO {

    /**类目名字**/
    @JsonProperty("name")
    private String categoryName;

    /**类目编号**/
    @JsonProperty("type")
    private Integer categoryType;

    /**类目下商品**/
    private List<ProductInfoVO> foods;

}
