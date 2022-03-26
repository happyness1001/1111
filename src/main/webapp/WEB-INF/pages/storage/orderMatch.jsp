<%--还没写完--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>订单商品情况</h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/commodity/toUpdate">修改订单信息</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>order_id</th>
                    <th>commodity</th>
                    <th>sent_location</th>
                    <th>receive_location</th>
                    <th>creat_time</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="order" items="${order}">
                    <tr>
                        <td>${order}</td>
                        <td>${order.commodity.id}</td>
                        <td>${order.commodity.name}</td>
                        <td>${order.commodity.main_image}</td>
                        <td>${order.commodity.price}</td>
                        <td>${order.commodity.quantity}</td>
                        <td>${order.sent_location}</td>
                        <td>${order.receive_location}</td>
                        <td>${order.creat_time}</td>

                        <td><a href="${pageContext.request.contextPath}/commodity/toUpdate?id=${commodity.id}">修改</a>
                            &nbsp;| &nbsp;
                            <a href="${pageContext.request.contextPath}/commodity/delete?id=${commodity.id}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
