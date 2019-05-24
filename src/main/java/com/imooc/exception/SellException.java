package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/14 0014
 * Time:9:41
 * Desc 异常处理类
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
