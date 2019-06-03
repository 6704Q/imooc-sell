package com.imooc.utils;

import com.imooc.enums.CodeEnum;
import com.imooc.enums.OrderStatusEnum;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/25 0025
 * Time:16:51
 * Desc 枚举工具类
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each : enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }

}
