package com.imooc.controller;

import com.imooc.config.ProjectUrlConfig;
import com.imooc.constant.CookieContant;
import com.imooc.constant.RedisContant;
import com.imooc.entity.SellerInfo;
import com.imooc.enums.ResultEnum;
import com.imooc.service.impl.SellerServiceImpl;
import com.imooc.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/30 0030
 * Time:11:43
 * Desc 卖家 controller
 */
@RequestMapping("/seller")
@Controller
@Slf4j
public class SellerUserController {

    @Autowired
    SellerServiceImpl sellerService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    ProjectUrlConfig urlConfig;


    /**
     * 登录
     * @param openId
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login(HttpServletResponse response,@RequestParam("openId") String openId, Map<String,Object> map){
        //1.验证openId 该用户是否存在
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenId(openId);
        if (sellerInfo == null){
            log.error("【登录】发生异常，查找不到该用户 openId = {}",openId);
            map.put("msg",ResultEnum.USER_NOT_EXIST.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        //2.设置token至redis
        String token = String.format(RedisContant.TOKEN_PREFIX,UUID.randomUUID().toString());
        stringRedisTemplate.opsForValue().set(token,openId,RedisContant.DEFAULT_EXPIRE, TimeUnit.SECONDS);
        //3.设置token至cookie
        CookieUtil.set(response, CookieContant.TOKEN,token,RedisContant.DEFAULT_EXPIRE);

        return new ModelAndView("redirect:"+urlConfig.getSell()+"/sell/seller/order/list");
    }

    /**
     * 用户登出
     * @param request
     * @param response
     * @param map
     * @return
     */
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response,Map<String,Object> map){
        //1.从cookie中查询
        Cookie cookie = CookieUtil.get(request,CookieContant.TOKEN);
        if (cookie != null){
            //2.清除redis
            String redisName = cookie.getValue();
            stringRedisTemplate.opsForValue().getOperations().delete(redisName);
            //3.清除cookie
            CookieUtil.set(response,CookieContant.TOKEN,null,0);
        }
        map.put("msg",ResultEnum.USER_LOG_OUT.getMessage());
        map.put("url",urlConfig.getSell() + "/sell/seller/order/list");
        return new ModelAndView("common/success");
    }

}
