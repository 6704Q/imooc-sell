package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/6/1 0001
 * Time:20:53
 * Desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PushMessageImplTest {

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    PushMessageImpl pushMessage;

    @Test
    public void orderStatus() {

        OrderDTO orderDTO = orderService.findOne("1558594956447138888");
        pushMessage.orderStatus(orderDTO);

    }
}