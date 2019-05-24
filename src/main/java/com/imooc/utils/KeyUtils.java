package com.imooc.utils;

import java.util.Random;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/14 0014
 * Time:10:10
 * Desc
 */
public class KeyUtils {

    /**
     * 生成唯一主键
     * 格式：时间 + 随机数
     * @return
     */
    public static synchronized String getUniqueKey(){
        Random random = new Random();
        //生成六位随机数
        Integer number = random.nextInt(900000)+100000;
        return  System.currentTimeMillis() + String.valueOf(number);
    }

}
