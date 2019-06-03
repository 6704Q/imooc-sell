<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品类目</title>
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
                            <th>类目id</th>
                            <th>名称</th>
                            <th>编号</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list data as category>
                        <tr>
                            <th>${category.categoryId}</th>
                            <th>${category.categoryName}</th>
                            <th>${category.categoryType}</th>
                            <th>${category.createTime}</th>
                            <th>${category.updateTime}</th>
                            <th><a href="/sell/seller/category/index?categoryId=${category.categoryId}" class="btn active btn-sm btn-primary">修改</a></th>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>