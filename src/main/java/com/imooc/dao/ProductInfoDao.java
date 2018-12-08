package com.imooc.dao;

import com.imooc.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2018/9/28 0028
 * Time:14:57
 * Desc
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer productStauts);

    List<ProductInfo> findByCategoryTypeAndProductStatus(Integer categoryType,Integer productStauts);

}
