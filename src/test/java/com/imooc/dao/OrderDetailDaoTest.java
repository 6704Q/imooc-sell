package com.imooc.dao;

import com.imooc.entity.OrderDetail;
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
 * Date:2019/3/12 0012
 * Time:14:45
 * Desc 商品详情测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;


    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("201903124567");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http.xxx.jpg");
        orderDetail.setProductId("123457");
        orderDetail.setProductName("韭菜饼");
        orderDetail.setProductPrice(new BigDecimal(5.5));
        orderDetail.setProductQuantity(3);
        OrderDetail order = orderDetailDao.save(orderDetail);
        Assert.assertNotNull(order);

    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId("123456");
        System.out.println(orderDetailList.size());
    }
}