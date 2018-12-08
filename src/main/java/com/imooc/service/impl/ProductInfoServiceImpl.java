package com.imooc.service.impl;

import com.imooc.dao.ProductInfoDao;
import com.imooc.entity.ProductCategory;
import com.imooc.entity.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.service.ProductCategoryService;
import com.imooc.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDuthor:ChenSuoZhang
 * Date:2018/9/28 0028
 * Time:15:21
 * Desc
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoDao productInfoDao;


    @Override
    public List<ProductInfo> findByProductStatus(Integer productStauts) {
        return productInfoDao.findByProductStatus(productStauts);
    }

    @Override
    public List<ProductInfo> findByCategoryTypeAndProductStatus(Integer categoryType, Integer productStauts) {
        return productInfoDao.findByCategoryTypeAndProductStatus(categoryType,productStauts);
    }

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }
}
