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
    SUCCESS_MSG(0,"成功"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(20,"库存不正确"),
    PRODUCT_SALE_ON(21,"商品已上架"),
    PRODUCT_SALE_OFF(22,"商品已下架"),
    ORDER_NOT_EXIST(30,"订单不存在"),
    ORDER_STATUS_ERROR(31,"订单状态不正确"),
    ORDER_UPDATE_ERROR(32,"订单更新失败"),
    ORDER_PAY_STATUS_ERROR(33,"订单支付状态不正确"),
    PARAM_ERROR(1,"参数错误"),
    CART_EMPTY(2,"购物车不能为空"),
    ORDER_OWNER_ERROR(34,"该订单不属于当前用户"),
    WECHAT_ERROR(13,"微信相关错误"),
    ORDER_MONER_ERROR(14,"订单金额错误"),
    USER_NOT_EXIST(50,"用户不存在"),
    USER_LOG_OUT(51,"退出成功")
    ;
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
