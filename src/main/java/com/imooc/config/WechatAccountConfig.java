package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/24 0024
 * Time:12:36
 * Desc
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    /**
     * 公众平台ID
     */
    private String mpAppId;

    /**
     * 公众平台秘钥
     */
    private String mpAppSecret;

    /**
     * 开放平台ID
     */
    private String openAppId;

    /**
     * 公众平台秘钥
     */
    private String openAppSecret;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * 商户密钥
     */
    private String mchKey;

    /**
     * 商户证书路径
     */
    private String keyPath;

    /**
     * 回调地址
     */
    private String notifyUrl;


}
