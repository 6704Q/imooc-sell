package com.imooc.dao;

import com.imooc.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/29 0029
 * Time:13:04
 * Desc
 */
public interface SellerInfoDao extends JpaRepository<SellerInfo,String> {

    SellerInfo findByOpenid(String opinId);

}
