package com.imooc.controller;

import com.imooc.entity.ProductCategory;
import com.imooc.entity.ProductInfo;
import com.imooc.service.ProductCategoryService;
import com.imooc.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
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
 * Date:2019/5/29 0029
 * Time:11:26
 * Desc 商品类目
 */
@RequestMapping("/seller/category")
@Controller
public class ProductCategoryController {

    @Autowired
    ProductInfoService productInfoService;

    @Autowired
    ProductCategoryService categoryService;

    /**
     * 类目列表
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(Map<String,Object> map){
        List<ProductCategory> productInfos = categoryService.findAll();
        map.put("data",productInfos);
        return new ModelAndView("category/list",map);
    }

    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false) Integer categoryId, Map<String,Object> map){
        ProductCategory category = new ProductCategory();
        if (!StringUtils.isEmpty(categoryId)){
            category = categoryService.findOne(categoryId);
        }
        map.put("data",category);
        return new ModelAndView("category/index",map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid ProductCategory category, BindingResult bindingResult,
                             @RequestParam(value = "oldCategoryType",required = false) Integer oldCategoryType,
                             Map<String,Object> map){
        if (bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/category/list");
            return new ModelAndView("common/error",map);
        }
        if (StringUtils.isEmpty(category.getCategoryId())){
            categoryService.save(category);
        }else {
            categoryService.save(category);
            productInfoService.updateProductCategory(oldCategoryType,category.getCategoryType());
        }
        map.put("msg","保存成功！");
        map.put("url","/sell/seller/category/list");
        return new ModelAndView("common/success",map);
    }

}
