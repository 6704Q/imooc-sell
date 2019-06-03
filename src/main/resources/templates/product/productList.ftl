<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品列表</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/sell/layui/css/layui.css"  media="all">
    <script src="/sell/layui/layui.js" charset="utf-8"></script>
    <script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
    <link rel="stylesheet" href="/sell/css/style.css">
</head>
<body>

<div id="wrapper" class="toggled">
<#--侧边栏-->
    <#include "../common/nav.ftl"/>

<#--主要内容-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>状态</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list data.getContent() as product>
                        <tr>
                            <th>${product.getProductId()}</th>
                            <th>${product.getProductName()}</th>
                            <th><img width="100px" src="${product.getProductIcon()}"/></th>
                            <th>${product.getProductPrice()}</th>
                            <th>${product.getProductStock()}</th>
                            <th>${product.getProductDescription()}</th>
                            <th>${product.getProductStatusEnum().getMsg()}</th>
                            <th>${product.getCategoryType()}</th>
                            <th>${product.getCreateTime()}</th>
                            <th>${product.getUpdateTime()}</th>
                            <th><a href="/sell/seller/product/index?productId=${product.getProductId()}" class="btn active btn-sm btn-primary">修改</a></th>
                            <th>
                                <#if product.getProductStatus() == 0>
                                    <a href="/sell/seller/product/offSale?productId=${product.getProductId()}" class="btn active btn-sm btn-primary">下架</a>
                                    <#else>
                                    <a href="/sell/seller/product/onSale?productId=${product.getProductId()}" class="btn active btn-sm btn-primary">上架</a>
                                </#if>
                            </th>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-12 column">
                <ul class="pagination pull-right">
                <li>
            <#if currentPage lte 1>
                <li class="disabled"><a href="#">上一页</a></li>
            <#else>
                <li><a href="/sell/seller/product/list?page=${currentPage-1}&size=${size}">上一页</a></li>
            </#if>
                    </li>
        <#list 1..data.getTotalPages() as index>
            <#if currentPage == index>
                <li class="disabled"><a href="#">${index}</a></li>
            <#else>
                <li><a href="/sell/seller/product/list?page=${index}&size=${size}">${index}</a></li>
            </#if>
        </#list>
                <li>
            <#if currentPage gte data.getTotalPages()>
                <li class="disabled"><a href="#">下一页</a></li>
            <#else>
                <li><a href="/sell/seller/product/list?page=${currentPage+1}&size=${size}">下一页</a></li>
            </#if>
                    </li>
                </ul>
            </div>
        </div>
    </div>

</div>

</body>
</html>