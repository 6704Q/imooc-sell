package com.imooc.convert;

import com.imooc.dto.OrderDTO;
import com.imooc.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/14 0014
 * Time:13:21
 * Desc
 */
public class OrdermasterToOrderDTO {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> masterList){
        List<OrderDTO> orderDTOList = masterList.stream().map(e ->
                OrdermasterToOrderDTO.convert(e)
                ).collect(Collectors.toList());
        return orderDTOList;
    }

}
