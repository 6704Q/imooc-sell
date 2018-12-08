package com.imooc.dao;

import com.imooc.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2018/9/29 0029
 * Time:12:48
 * Desc 订单接口
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {

    /*查询用户下的订单*/
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
