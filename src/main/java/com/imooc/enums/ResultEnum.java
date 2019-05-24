package com.imooc.enums;

import lombok.Getter;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/14 0014
 * Time:9:47
 * Desc异常类用枚举
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(20,"库存不正确"),
    ORDER_NOT_EXIST(30,"订单不存在"),
    ORDER_STATUS_ERROR(31,"订单状态不正确"),
    ORDER_UPDATE_ERROR(32,"订单更新失败"),
    ORDER_PAY_STATUS_ERROR(33,"订单支付状态不正确"),
    PARAM_ERROR(1,"参数错误"),
    CART_EMPTY(2,"购物车不能为空"),
    ORDER_OWNER_ERROR(34,"该订单不属于当前用户")
    ;
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
