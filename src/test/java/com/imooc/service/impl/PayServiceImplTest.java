package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.service.OrderServicer;
import com.imooc.service.PayService;
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
 * Date:2019/5/24 0024
 * Time:21:59
 * Desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderServicer orderServicer;

    @Test
    public void create() {
        OrderDTO orderDTO = orderServicer.findOne("1558594956447138888");
        payService.create(orderDTO);
    }

    @Test
    public void refund() {
        OrderDTO orderDTO = orderServicer.findOne("1558591760655706510");
        payService.refund(orderDTO);
    }

}