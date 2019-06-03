package com.imooc.dao;

import com.google.gson.Gson;
import com.imooc.entity.SellerInfo;
import com.imooc.utils.JsonUtil;
import com.imooc.utils.KeyUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/29 0029
 * Time:13:08
 * Desc
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class SellerInfoDaoTest {

    @Autowired
    SellerInfoDao sellerInfoDao;

    @Test
    public void create(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setId(KeyUtils.getUniqueKey());
        sellerInfo.setUsername("胡兰兰");
        sellerInfo.setPassword("woxihuanni");
        sellerInfo.setOpenid("yiqiba");
        sellerInfoDao.save(sellerInfo);
    }

    @Test
    public void findByOpenid() {
        SellerInfo sellerInfo = sellerInfoDao.findByOpenid("yiqiba");
        Gson gson = new Gson();
        log.info("sellerInfo = {}", gson.toJson(sellerInfo));
        log.info("sellerInfo = {}", JsonUtil.toJson(sellerInfo));
    }
}