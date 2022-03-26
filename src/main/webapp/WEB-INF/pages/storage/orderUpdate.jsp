<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改订单状态</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>修改订单信息</h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/order/match" method="post">
        <input type="hidden" name="id" value="${q_order.order_id}">
        <div class="form-group">
            <label>收货地址</label>
            <input type="text" name="receive_location" class="form-control" placeholder="请输入新的收货地址"
                   value="${q_order.receive_location}">
        </div>
        <div class="form-group">
            <input type="submit" class="form-group" value="修改">
        </div>
    </form>
</div>
</body>
</html>
