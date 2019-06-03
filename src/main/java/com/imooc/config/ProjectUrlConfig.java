package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/30 0030
 * Time:11:01
 * Desc 项目常用的URL配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "projectUrl")
public class ProjectUrlConfig {

    /**
     * 微信公众平台授权URL
     */
    public String wechatMpAuthorize;

    /**
     * 微信开放平台授权URL
     */
    public String wechatOpenAuthorize;

    /**
     * 项目路径URL
     */
    public String sell;

}
