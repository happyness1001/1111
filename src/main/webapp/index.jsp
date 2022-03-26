<%--
  Created by IntelliJ IDEA.
  User: lijun
  Date: 2022/2/17
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>首页</title>
    <style type="text/css">
        a {
            text-decoration: none;
            color: black;
            font-size: 18px;
        }

        h3 {
            width: 200px;
            height: 50px;
            margin: 100px auto;
            text-align: center;
            /*位置*/
            line-height: 38px;
            background: deepskyblue;
            /*圆角边框*/
            border-radius: 4px;
        }
    </style>
</head>
<body>

<h3>
    <a href="${pageContext.request.contextPath}/forehome">点击进入商城主页</a>
</h3>
<h3>
    <a href="${pageContext.request.contextPath}/admin_showAllOrder">后台界面</a>
</h3>
</body>
</html>