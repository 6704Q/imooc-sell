package com.imooc.service.impl;

import com.imooc.dao.SellerInfoDao;
import com.imooc.entity.SellerInfo;
import com.imooc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/29 0029
 * Time:13:21
 * Desc
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findSellerInfoByOpenId(String openId) {
        return sellerInfoDao.findByOpenid(openId);
    }
}
