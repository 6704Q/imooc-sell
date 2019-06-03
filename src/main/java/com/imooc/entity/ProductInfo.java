package com.imooc.entity;

import com.imooc.enums.ProductStatusEnum;
import com.imooc.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;

    /**商品名字**/
    @NotEmpty(message = "商品名不能为空")
    private String productName;

    /**商品单价**/
    @NotNull(message = "价格不能为空")
    private BigDecimal productPrice;

    /**商品库存**/
    @NotNull(message = "库存不能为空")
    private Integer productStock;

    /**商品描述**/
    @NotEmpty(message = "描述不能为空")
    private String productDescription;

    /**商品小图**/
    @NotEmpty(message = "图片不能为空")
    private String productIcon;

    /**商品状态0正常 1下架**/
    @NotNull(message = "状态不能为空")
    private Integer productStatus = 0;

    /**类目编号**/
    @NotNull(message = "类目不能为空")
    private Integer categoryType;

    /**创建时间**/
    private Date createTime;

    /**更新时间**/
    private Date updateTime;

    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }

}