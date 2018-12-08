package com.imooc.service;

import com.imooc.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2018/9/28 0028
 * Time:15:16
 * Desc
 */
public interface ProductInfoService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有上架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    List<ProductInfo> findByProductStatus(Integer productStauts);

    List<ProductInfo> findByCategoryTypeAndProductStatus(Integer categoryType,Integer productStauts);

}
