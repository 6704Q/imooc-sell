package com.imooc.dao;

import com.imooc.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 类目类接口
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {

    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTyprList);

}
