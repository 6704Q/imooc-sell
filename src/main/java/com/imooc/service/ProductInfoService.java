package com.imooc.service;

import com.imooc.dto.CartDTO;
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

    //加库存
    void addStock(List<CartDTO> cartDTOList);

    //扣库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);

    //修改商品类目
    int updateProductCategory(Integer oldCategory,Integer newCategory);
}
