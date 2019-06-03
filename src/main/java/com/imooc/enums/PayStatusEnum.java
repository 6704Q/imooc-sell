package com.imooc.enums;

import lombok.Getter;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2018/9/29 0029
 * Time:12:39
 * Desc
 */
@Getter
public enum PayStatusEnum implements CodeEnum{
    WAIT(0,"未支付"),
    SUCCESS(1,"支付成功")
    ;

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }
}
