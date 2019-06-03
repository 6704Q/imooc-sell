<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品详情</title>
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
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form action="/sell/seller/product/save" method="post">
                        <div class="form-group">
                            <label>商品名字</label>
                            <input name="productName" type="text" value="${(product.getProductName())!''}" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>商品单价</label>
                            <input name="productPrice" type="text" value="${(product.getProductPrice())!''}" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>商品库存</label>
                            <input name="productStock" type="text" value="${(product.getProductStock())!''}" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>商品描述</label>
                            <input name="productDescription" type="text" value="${(product.getProductDescription())!''}" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>商品小图</label><br/>
                            <img width="100" src="${(product.getProductIcon())!''}"/>
                            <input name="productIcon" type="text" value="${(product.getProductIcon())!''}" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>商品状态</label>
                            <select name="productStatus" class="form-control">
                                <option value="0" selected>上架</option>
                                <option value="1">下架</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                                <#list categoryList as cl>
                                    <option value="${cl.categoryType}"
                                    <#if (product.categoryType)?? && cl.categoryType == product.categoryType>
                                                selected
                                    </#if>>
                                        ${cl.getCategoryName()}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <input hidden name="productId" type="text" value="${(product.productId)!''}"/>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>