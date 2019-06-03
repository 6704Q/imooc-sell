package com.imooc.service.impl;

import com.imooc.entity.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2018/9/28 0028
 * Time:15:38
 * Desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productInfoService.findOne("10011");
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findByCategoryTypeAndProductStatus() {
       List<ProductInfo> productInfoList = productInfoService.findByCategoryTypeAndProductStatus(5,0);
       Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(1,5);
        Page<ProductInfo> productInfoList = productInfoService.findAll(request);
        System.out.println(productInfoList.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("10016");
        productInfo.setProductName("豆沙包");
        productInfo.setCategoryType(3);
        productInfo.setProductDescription("美味口");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductPrice(new BigDecimal(2));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);
        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void onSale(){
        ProductInfo productInfo = productInfoService.onSale("10011");
    }

    @Test
    public void offSale(){
        ProductInfo productInfo = productInfoService.offSale("10011");
    }

    @Test
    public void demo(){
        int num = productInfoService.updateProductCategory(2,3);
        log.info("修改数量{}",num);
    }

}