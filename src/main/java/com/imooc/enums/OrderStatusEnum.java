package com.imooc.enums;

import lombok.Getter;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2018/9/29 0029
 * Time:12:33
 * Desc
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    END(1,"完结"),
    CANCEL(2,"取消")
    ;
    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }
}
