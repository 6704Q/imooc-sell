package com.imooc.dao;

import com.imooc.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2018/9/28 0028
 * Time:15:02
 * Desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfos = productInfoDao.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfos.size());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("10012");
        productInfo.setProductName("皮蛋瘦肉粥");
        productInfo.setCategoryType(5);
        productInfo.setProductDescription("很nice的粥");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductPrice(new BigDecimal(2.5));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);
        ProductInfo result = productInfoDao.save(productInfo);
        Assert.assertNotNull(result);
    }

}