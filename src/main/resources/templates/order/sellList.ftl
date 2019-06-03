<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>table模块快速使用</title>
    <link rel="stylesheet" href="/sell/layui/css/layui.css"  media="all">
    <script src="/sell/layui/layui.js" charset="utf-8"></script>
</head>
<body>

<table id="demo" lay-filter="test"></table>

<script>
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 312
            ,url: '/sell/seller/order/sellList' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'orderId', title: '订单ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'buyerName', title: '用户名', width:80}
                ,{field: 'buyerPhone', title: '手机号', width:80, sort: true}
                ,{field: 'buyerAddress', title: '地址', width:80}
                ,{field: 'orderAmount', title: '金额', width: 177}
                ,{field: 'orderStatus', title: '订单状态', width: 80, sort: true}
                ,{field: 'payStatus', title: '支付状态', width: 80, sort: true}
                ,{field: 'createTime', title: '创建时间', width: 80}
                ,{field: 'updateTime', title: '操作', width: 135, sort: true}
            ]]
        });

    });
</script>
</body>
</html>