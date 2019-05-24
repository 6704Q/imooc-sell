package com.imooc.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created with IDEA
 * autChenSuoZhang
 * Date:2019/5/15 0015
 * Time:14:16
 * Desc 订单Form
 */
@Data
public class OrderForm {

    //用户姓名
    @NotEmpty(message = "姓名不能为空")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 卖家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信openID
     */
    @NotEmpty(message = "openID必填")
    private String openid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
