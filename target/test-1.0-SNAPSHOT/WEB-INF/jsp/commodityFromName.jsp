<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 column">
            <div class="page-header">
                <h1>商品详情</h1>
            </div>
        </div>
    </div>


</div>
<div class="row clearfix">
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 column">
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th>commodity_id</th>
                <th>cate_id</th>
                <th>store_id</th>
                <th>name</th>
                <th>subtitle</th>
                <th>main_image</th>
                <th>sub_images</th>
                <th>detail</th>
                <th>price</th>
                <th>quantity</th>
                <th>location</th>
                <th>status</th>
                <th>creat_time</th>
                <th>modify_time</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="commodity" items="${commodityList}" >
                <tr>
                    <td>${commodity.commodity_id}</td>
                    <td>${commodity.cate_id}</td>
                    <td>${commodity.store_id}</td>
                    <td>${commodity.name}</td>
                    <td>${commodity.subtitle}</td>
                    <td>${commodity.main_image}</td>
                    <td>${commodity.sub_images}</td>
                    <td>${commodity.detail}</td>
                    <td>${commodity.price}</td>
                    <td>${commodity.quantity}</td>
                    <td>${commodity.location}</td>
                    <td>${commodity.status}</td>
                    <td>${commodity.creat_time}</td>
                    <td>${commodity.modify_time}</td>
                    <td><a href="${pageContext.request.contextPath}/commodity/toUpdate?commodity_id=${commodity.commodity_id}">修改</a>&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/commodity/delete?commodity_id=${commodity.commodity_id}">删除</a>
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
