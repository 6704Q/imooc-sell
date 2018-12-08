package com.imooc.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**类目实体类**/
@Entity
@DynamicUpdate
@Data
public class ProductCategory {
	
	/**类目ID**/
	@Id
	@GeneratedValue
    private Integer categoryId;

    /**类目名字**/
    private String categoryName;

    /**类目编号**/
    private Integer categoryType;

    /**创建时间**/
    private Date createTime;

    /**更新时间**/
    private Date updateTime;


    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}