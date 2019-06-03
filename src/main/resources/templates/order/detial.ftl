<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品详情</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/sell/css/style.css">
</head>
<body>

<div id="wrapper" class="toggled">
<#--侧边栏-->
    <#include "../common/nav.ftl"/>

<#--主要内容-->
    <div id="page-content-wrapper" >
    <#--总订单-->
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>订单ID</th>
                            <th>订单总金额</th>
                            <th>订单状态</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${orderDTO.orderId}</td>
                            <td>${orderDTO.orderAmount}</td>
                            <td>${orderDTO.getOrderStatusEnum().getMsg()}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    <#--订单详情-->
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>商品ID</th>
                            <th>商品名称</th>
                            <th>价格</th>
                            <th>数量</th>
                            <th>金额</th>
                        </tr>
                        </thead>
                        <tbody>
                <#list orderDTO.orderDetailList as detial>
                <th>${detial.productId}</th>
                <th>${detial.productName}</th>
                <th>${detial.productPrice}</th>
                <th>${detial.productQuantity}</th>
                <th>${detial.productPrice * detial.productQuantity}</th>
                </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    <#--订单操作-->
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
            <#if orderDTO.orderStatus==0>
                <a href="/sell/seller/order/finish?orderId=${orderDTO.orderId}" type="button" class="btn btn-primary btn-default">完结订单</a>
                <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-danger">取消订单</a>
            </#if>
                </div>
            </div>
        </div>
    </div>

</div>


</body>
</html>