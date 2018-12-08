package com.imooc.dao;

import com.imooc.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOnTest(){
        ProductCategory productCategory = productCategoryDao.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory = productCategoryDao.findOne(2);
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
        productCategoryDao.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> productCategoryList = productCategoryDao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,productCategoryList.size());
    }

}