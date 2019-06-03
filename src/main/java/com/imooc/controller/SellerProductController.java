package com.imooc.controller;

import com.imooc.entity.ProductCategory;
import com.imooc.entity.ProductInfo;
import com.imooc.exception.SellException;
import com.imooc.form.ProductForm;
import com.imooc.service.ProductCategoryService;
import com.imooc.service.ProductInfoService;
import com.imooc.utils.KeyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/5/27 0027
 * Time:20:19
 * Desc 卖家段商品controller
 */
@Controller
@Slf4j
@RequestMapping("seller/product")
public class SellerProductController {

    @Autowired
    ProductInfoService productInfoService;

    @Autowired
    ProductCategoryService categoryService;

    /**
     * 商品列表
     * @param page 当前页
     * @param size 数量
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map){
        PageRequest pageRequest = new PageRequest(page - 1,size);
        Page<ProductInfo> productInfos = productInfoService.findAll(pageRequest);
        map.put("currentPage",page);
        map.put("size",size);
        map.put("data",productInfos);
        return new ModelAndView("product/productList",map);
    }

    /**
     * 商品上架
     * @param productId 商品ID
     * @param map
     * @return
     */
    @RequestMapping("/onSale")
    public ModelAndView onSale(@RequestParam("productId") String productId,Map<String,Object> map){
        try {
            productInfoService.onSale(productId);
        }catch (SellException e){
            log.error("【商品上架】 上架异常{}",e.getMessage());
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg","商品上架成功！");
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }

    /**
     * 商品下架
     * @param productId 商品ID
     * @param map
     * @return
     */
    @RequestMapping("/offSale")
    public ModelAndView offSale(@RequestParam("productId") String productId,Map<String,Object> map){
        try {
            productInfoService.offSale(productId);
        }catch (SellException e){
            log.error("【商品下架】 下架异常{}",e.getMessage());
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg","商品下架成功！");
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }

    /**
     * 商品详情页
     * @param productId 商品ID
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId",required = false) String productId,Map<String,Object> map){
        ProductInfo productInfo = new ProductInfo();
        if (!StringUtils.isEmpty(productId)){
            productInfo = productInfoService.findOne(productId);
            map.put("product",productInfo);
        }
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("product/index",map);
    }

    /**
     * 保存商品
     * @param productInfo 商品信息
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductInfo productInfo, BindingResult bindingResult, Map<String, Object> map){
        if (bindingResult.hasErrors()){
            log.error("【保存商品信息】保存异常 {}",bindingResult.getFieldError().getDefaultMessage());
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/product/index?productId="+productInfo.getProductId());
            return new ModelAndView("common/error");
        }
        if (StringUtils.isEmpty(productInfo.getProductId())){
            productInfo.setProductId(KeyUtils.getUniqueKey());
        }
        productInfoService.save(productInfo);
        map.put("msg","商品保存成功");
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }

}
