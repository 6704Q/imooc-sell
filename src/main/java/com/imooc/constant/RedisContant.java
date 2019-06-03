package com.imooc.constant;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/30 0030
 * Time:13:17
 * Desc redis 常量
 */
public interface RedisContant {

    /**
     * name 前缀
     */
    String TOKEN_PREFIX = "token_%s";

    /**
     * 默认过期时长，单位：秒
     */
    int DEFAULT_EXPIRE = 60 * 60 * 24;

    /**
     * 不设置过期时长
     */
    int NOT_EXPIRE = -1;

}
