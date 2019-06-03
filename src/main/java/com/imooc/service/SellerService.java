package com.imooc.service;

import com.imooc.entity.SellerInfo;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/29 0029
 * Time:13:19
 * Desc 卖家段
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenId(String openId);

}
