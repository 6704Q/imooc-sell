package com.imooc.config;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/24 0024
 * Time:21:51
 * Desc 微信支付配置文件
 */
@Component
public class WechatPayConfig {

    @Autowired
    WechatAccountConfig accountConfig;

    @Bean
    public BestPayServiceImpl bestPayService(){
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        WxPayH5Config payH5Config = new WxPayH5Config();
        payH5Config.setAppId(accountConfig.getMpAppId());
        payH5Config.setAppSecret(accountConfig.getMpAppSecret());
        payH5Config.setMchId(accountConfig.getMchId());
        payH5Config.setMchKey(accountConfig.getMchKey());
        payH5Config.setKeyPath(accountConfig.getKeyPath());
        payH5Config.setNotifyUrl(accountConfig.getNotifyUrl());
        bestPayService.setWxPayH5Config(payH5Config);
        return bestPayService;
    }

}
