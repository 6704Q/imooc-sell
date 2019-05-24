package com.imooc.dao;

import com.imooc.entity.OrderMaster;
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
 * Date:2019/3/12 0012
 * Time:14:05
 * Desc订单接口测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerAddress("香港城");
        orderMaster.setBuyerName("张三");
        orderMaster.setOrderId("2019031212345");
        orderMaster.setBuyerPhone("15868147835");
        orderMaster.setOrderAmount(new BigDecimal(9.9));
        orderMaster.setBuyerOpenid("123456");
        OrderMaster result = orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(1,5);
        Page<OrderMaster> orderMasterList = orderMasterDao.findByBuyerOpenid("123456",request);
        System.out.println(orderMasterList.getTotalElements()+" "+orderMasterList.getTotalPages()+" "+orderMasterList.getContent().size());


    }
}