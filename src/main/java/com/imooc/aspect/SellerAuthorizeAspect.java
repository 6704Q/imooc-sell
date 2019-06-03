package com.imooc.aspect;

import com.imooc.constant.CookieContant;
import com.imooc.constant.RedisContant;
import com.imooc.exception.SellerAuthorizeException;
import com.imooc.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/6/1 0001
 * Time:15:27
 * Desc 用户登录验证切面
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    HttpServletRequest request;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.imooc.controller.Seller*.*(..))" +
            "&& !execution(public * com.imooc.controller.SellerUserController.*(..))")
    public void verify(){}

    @Before("verify()")
    public void doVerify(){
        //HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        //1.区cookie中查询
        Cookie cookie = CookieUtil.get(request, CookieContant.TOKEN);
        if (cookie == null){
            log.warn("【登录验证】 cookie中没有token");
            throw new SellerAuthorizeException();
        }
        //2.redis中查询
        String redisUser = redisTemplate.opsForValue().get(cookie.getValue());
        if (redisUser == null){
            log.warn("【登录验证】 redis中没有token");
            throw new SellerAuthorizeException();
        }
    }

}
