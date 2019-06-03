<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>类目详情</title>
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
                    <form action="/sell/seller/category/save" method="post">
                        <div class="form-group">
                            <label>名字</label>
                            <input name="categoryName" type="text" value="${(data.categoryName)!''}" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>编号</label>
                            <input name="categoryType" type="text" value="${(data.categoryType)!''}" class="form-control"/>
                        </div>
                        <input hidden name="categoryId" type="text" value="${(data.categoryId)!''}"/>
                        <input hidden name="oldCategoryType" type="text" value="${(data.categoryType)!''}"/>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>