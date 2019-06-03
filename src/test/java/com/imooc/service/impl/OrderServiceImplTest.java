package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.entity.OrderDetail;
import com.imooc.utils.KeyUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/14 0014
 * Time:11:25
 * Desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerOpenid("19901123");
        orderDTO.setBuyerAddress("浙江杭州滨江区缤纷北苑23幢2单元503");
        orderDTO.setBuyerPhone("1383546987");
        orderDTO.setOrderAmount(new BigDecimal(699));
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("10011");
        orderDetail.setProductQuantity(1);
        orderDetailList.add(orderDetail);

        orderDTO.setOrderDetailList(orderDetailList);
        for (int i =0;i < 1000;i++){
            orderDTO.setBuyerName("舞飘剑"+i);
            OrderDTO result = orderService.create(orderDTO);
            log.info("i = {}",i);
        }

    }

    @Test
    public void findOne() {
        OrderDTO result = orderService.findOne("1557808354417380156");
        log.info("【创建订单】result = {}",result);
    }

    @Test
    public void findList() {
        Page<OrderDTO> orderDTOS = orderService.findList("oTgZpwVg5gRS2pbOkV4ARcSD57Vw",new PageRequest(0,5));
        log.info("【订单列表】result = {}",orderDTOS);
    }

    @Test
    public void cancel() {
        OrderDTO result = orderService.findOne("1557808354417380156");
        OrderDTO orderDTO = orderService.cancel(result);
        log.info("【取消订单】result = {}",orderDTO);
    }

    @Test
    public void finish() {
        OrderDTO result = orderService.findOne("1557808354417380156");
        OrderDTO orderDTO = orderService.finish(result);
        log.info("【完结订单】result = {}",orderDTO);
    }

    @Test
    public void pay() {
        OrderDTO result = orderService.findOne("1557808354417380156");
        OrderDTO orderDTO = orderService.pay(result);
        log.info("【订单支付完成】result = {}",orderDTO);
    }

    @Test
    public void List() {
        Page<OrderDTO> orderDTOS = orderService.findList(new PageRequest(0,20));
        log.info("【订单列表】result = {}",orderDTOS);
    }

}