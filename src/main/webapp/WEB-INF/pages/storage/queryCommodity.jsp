<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#">首页</a>
                </li><br/>
            </ul>
            <h3>
                请输入商品id
            </h3>
            <form class="form-search" action="${pageContext.request.contextPath}/commodity/getCommodityById">
                <input class="input-medium search-query" name="id" type="text" /> <button type="submit" class="btn">查找</button>
            </form>
            <h3>
                请输入商品名称
            </h3>
            <form class="form-search" action="${pageContext.request.contextPath}/commodity/getCommodityLike">
                <input class="input-medium search-query" name="name" type="text" /> <button type="submit" class="btn">模糊</button>
            </form>
        </div>
    </div>
</div>




</body>
</html>
