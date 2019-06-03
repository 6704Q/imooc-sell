<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>卖家列表</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/sell/layui/css/layui.css"  media="all">
    <script src="/sell/layui/layui.js" charset="utf-8"></script>
    <script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
    <link rel="stylesheet" href="/sell/css/style.css">
    <script src="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>
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
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>订单ID</th>
                            <th>姓名</th>
                            <th>手机号</th>
                            <th>地址</th>
                            <th>金额</th>
                            <th>订单状态</th>
                            <th>支付状态</th>
                            <th>创建时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
            <#list orderDTOPage.getContent() as orderDto>
            <tr>
                <td>${orderDto.getOrderId()}</td>
                <td>${orderDto.getBuyerName()}</td>
                <td>${orderDto.getBuyerPhone()}</td>
                <td>${orderDto.getBuyerAddress()}</td>
                <td>${orderDto.getOrderAmount()}</td>
                <td>${orderDto.getOrderStatusEnum().getMsg()}</td>
                <td>${orderDto.getPayStatusEnum().getMsg()}</td>
                <td>${orderDto.getCreateTime()}</td>
                <td><button type="button" onclick="detialClick(this)" value="${orderDto.getOrderId()}" class="btn active btn-sm btn-primary">详情</button></td>
                <td><button type="button" onclick="btnClick(this)" value="${orderDto.getOrderId()}" class="btn active btn-sm btn-primary">取消</button></td>
            </tr>
            </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        <#--分页-->
            <div class="col-md-12 column">
                <ul class="pagination pull-right">
                <li>
            <#if currentPage lte 1>
                <li class="disabled"><a href="#">上一页</a></li>
            <#else>
                <li><a href="/sell/seller/order/list?page=${currentPage-1}&size=${size}">上一页</a></li>
            </#if>
                    </li>
        <#list 1..orderDTOPage.getTotalPages() as index>
            <#if currentPage == index>
                <li class="disabled"><a href="#">${index}</a></li>
            <#else>
                <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
            </#if>
        </#list>
                <li>
            <#if currentPage gte orderDTOPage.getTotalPages()>
                <li class="disabled"><a href="#">下一页</a></li>
            <#else>
                <li><a href="/sell/seller/order/list?page=${currentPage+1}&size=${size}">下一页</a></li>
            </#if>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<#--弹窗-->
<div class="modal fade" id="modal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                <h4 class="modal-title" id="myModalLabel">
                                    提醒
                                </h4>
                            </div>
                            <div class="modal-body">
                                您有新的订单 ：
                            </div>
                            <div class="modal-footer">
                                <button onclick="javascript:document.getElementById('orderStatusMp3').pause()" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button onclick="location.reload()" type="button" class="btn btn-primary">查看</button>
                            </div>
                        </div>
                    </div>
</div>

<audio id="orderStatusMp3" loop="loop">
    <source src="/sell/mp3/song.mp3" type="audio/mpeg"/>
</audio>


<#--<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>显示完整功能${orderDTOPage.getTotalElements()}</legend>
</fieldset>
<div id="demo7"></div>
<input id="totalNum" value="${totalNum}" hidden></input>
<input id="currentPage" value="${currentPage}" hidden></input>
<input id="size" value="${size}" hidden></input>-->
</body>
<script>


    var websocket = null;
    if ('WebSocket' in window){
        websocket = new WebSocket('ws://cszjy.natapp1.cc/sell/webSocket');
    }else {
        alert("该浏览器不支持 WebSocket！");
    }
    
    websocket.onopen = function (event) {
        console.info("建立连接");
    }

    websocket.onclose = function (event) {
        console.info("关闭连接");
    }

    websocket.onmessage = function (event) {
        console.info("收到消息" + event.data);
        $('#modal').modal('show');
        document.getElementById('orderStatusMp3').play();
    }

    websocket.onerror = function (event) {
        console.info("websocket通信发生错误");
    }

    websocket.onbeforeunload = function (event) {
        websocket.close();
    }

    //取消订单事件
    var btnClick = function (data) {
        //alert(data.value)
        location.href='/sell/seller/order/cancel?orderId='+data.value;
    }

    //商品详情点击事件
    var detialClick = function (data) {
        //alert(data.value)
        location.href='/sell/seller/order/detial?orderId='+data.value;
    }


</script>
</html>

