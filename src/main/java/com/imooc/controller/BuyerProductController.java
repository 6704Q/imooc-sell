package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.entity.ProductCategory;
import com.imooc.entity.ProductInfo;
import com.imooc.service.ProductCategoryService;
import com.imooc.service.ProductInfoService;
import com.imooc.service.impl.ProductCategoryServiceImpl;
import com.imooc.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2018/9/28 0028
 * Time:16:01
 * Desc
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/list")
    @Cacheable(cacheNames = "product" , key = "123")
    public ResultVO list(){
        ResultVO resultVO = new ResultVO();
        List<ProductCategory> categoryList = productCategoryService.findAll();
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory category : categoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            List<ProductInfo> productInfos = productInfoService.findByCategoryTypeAndProductStatus(category.getCategoryType(),0);
            for (ProductInfo productInfo : productInfos){
                ProductInfoVO productInfoVO = new ProductInfoVO();
                BeanUtils.copyProperties(productInfo,productInfoVO);
                productInfoVOList.add(productInfoVO);
            }
            productVO.setFoods(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtils.success(productVOList);
    }

}
