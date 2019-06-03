package com.imooc.utils;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/30 0030
 * Time:13:47
 * Desc cookie工具类
 */
public class CookieUtil {

    /**
     * cookie设置
     * @param response
     * @param name cookie名称
     * @param value cookie 值
     * @param maxAge 过期时间
     */
    public static void set(HttpServletResponse response, String name, String value, int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 获取cookie
     * @param request
     * @param name cookie KEY
     * @return
     */
    public static Cookie get(HttpServletRequest request,String name){
        Map<String,Cookie> cookieMap = readCookieMap(request);
        if (cookieMap != null){
            if (cookieMap.containsKey(name)){
                return cookieMap.get(name);
            }
        }
        return null;
    }

    /**
     * 将cookie[]封装成Map
     * @param request
     * @return
     */
    private  static Map<String,Cookie> readCookieMap(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Map<String,Cookie> cookieMap = new HashMap<>();
        if (cookies != null){
            for (Cookie cookie : cookies){
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }

}
