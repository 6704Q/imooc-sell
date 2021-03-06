package com.imooc.enums;

import lombok.Data;
import lombok.Getter;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2018/9/28 0028
 * Time:15:30
 * Desc
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
        UP(0,"在架"),
        DOWN(1,"下架")
    ;
    private Integer code;

    private String msg;

    ProductStatusEnum(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }
}
