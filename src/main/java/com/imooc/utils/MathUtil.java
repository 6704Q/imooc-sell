package com.imooc.utils;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/25 0025
 * Time:14:28
 * Desc 金额工具类
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    public static boolean equals(Double d1 , Double d2){
        Double result = Math.abs(d1 - d2);

      /*  if (result < MONEY_RANGE){
            return true;
        }else {
            return false;
        }*/
        return result < MONEY_RANGE?true:false;
    }

}
