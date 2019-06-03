package com.imooc.entity.mapper;

import com.imooc.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.PUT;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/6/2 0002
 * Time:13:46
 * Desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductCategoryMapperTest {

    @Autowired
    private  ProductCategoryMapper categoryMapper;

    @Test
    public void insert() {
       /* Map<String,Object> map = new HashMap<>();
        map.put("categoryName","美容养颜");
        map.put("categoryType",469);*/
        ProductCategory category = new ProductCategory();
        category.setCategoryName("丰胸");
        category.setCategoryType(569);
        int result = categoryMapper.insertByObject(category);
        Assert.assertEquals(result,1);
    }

    @Test
    public void findByCategoryType(){
        ProductCategory category = categoryMapper.selectByCategoryType(269);
        Assert.assertNotNull(category);
    }




}