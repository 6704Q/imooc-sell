package com.imooc.service;

import com.imooc.entity.ProductCategory;

import java.util.List;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2018/9/28 0028
 * Time:12:51
 * Desc
 */
public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTyprList);

    ProductCategory save(ProductCategory productCategory);

}
