package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.exception.SellException;
import com.imooc.service.PushMessage;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/6/1 0001
 * Time:20:07
 * Desc 消息推送
 */
@Service
@Slf4j
public class PushMessageImpl implements PushMessage {

    @Autowired
    private WxMpService wxMpService;

    /**
     * 订单状态消息推送
     * @param orderDTO
     */
    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId("FK6xsRI8ZoLyRWQubtl_7JTRr8Nmkgnv6TS3wnglt2M");//模板ID
        templateMessage.setToUser("oYtlk1h3AgYayUsMOD3YybxejZAg");//推送微信用户openID
        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first","亲，请记得收货"),
                new WxMpTemplateData("keyword1","阳澄湖大闸蟹"),
                new WxMpTemplateData("keyword2","13865478897"),
                new WxMpTemplateData("keyword3",orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4",orderDTO.getOrderStatusEnum().getMsg()),
                new WxMpTemplateData("keyword5","￥"+orderDTO.getOrderAmount()),
                new WxMpTemplateData("remark","请给个五星好评")
        );
        templateMessage.setData(data);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        }catch (WxErrorException e){
            log.error("【微信模板消息】 发送失败 {}",e.getMessage());
        }
    }
}
