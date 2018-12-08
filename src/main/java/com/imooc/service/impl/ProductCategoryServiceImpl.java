package com.imooc.service.impl;

import com.imooc.dao.ProductCategoryDao;
import com.imooc.entity.ProductCategory;
import com.imooc.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2018/9/28 0028
 * Time:14:28
 * Desc 类目
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryDao.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTyprList) {
        return productCategoryDao.findByCategoryTypeIn(categoryTyprList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }
}
