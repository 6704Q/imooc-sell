package com.imooc.service.impl;

import com.imooc.dao.ProductInfoDao;
import com.imooc.dto.CartDTO;
import com.imooc.entity.ProductCategory;
import com.imooc.entity.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.ProductCategoryService;
import com.imooc.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Created with IDuthor:ChenSuoZhang
 * Date:2018/9/28 0028
 * Time:15:21
 * Desc
 */
@Service
@Slf4j
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

    /**
     * 加库存
     * @param cartDTOList
     */
    @Override
    @Transactional
    public void addStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo = productInfoDao.findOne(cartDTO.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer num = cartDTO.getProductStock() + productInfo.getProductStock();
            productInfo.setProductStock(num);
            productInfoDao.save(productInfo);
        }
    }

    /**
     * @param cartDTOList
     * 减商品库存
     */
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo = productInfoDao.findOne(cartDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductStock();
            if (result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoDao.save(productInfo);
        }
    }

    /**
     * 上架
     * @param productId
     * @return
     */
    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = productInfoDao.findOne(productId);
        if (productInfo == null){
            log.error("【商品上架】商品不存在 商品ID={}",productId);
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatus() == ProductStatusEnum.UP.getCode()){
            log.error("【商品上架】状态错误，该商品已在架 商品ID={}",productId);
            throw new SellException(ResultEnum.PRODUCT_SALE_ON);
        }
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return productInfoDao.save(productInfo);
    }

    /**
     * 下架
     * @param productId
     * @return
     */
    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = productInfoDao.findOne(productId);
        if (productInfo == null){
            log.error("【商品下架】商品不存在 商品ID={}",productId);
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatus() == ProductStatusEnum.DOWN.getCode()){
            log.error("【商品上架】状态错误，该商品已下架 商品ID={}",productId);
            throw new SellException(ResultEnum.PRODUCT_SALE_OFF);
        }
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return productInfoDao.save(productInfo);
    }

    @Override
    @Transactional
    public int updateProductCategory(Integer oldCategory, Integer newCategory) {
        return productInfoDao.updateProductCategory(oldCategory,newCategory);
    }
}
