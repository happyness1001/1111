<%@ page import="entity.Provider" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>供应商主页</title>
</head>
<body>
    <h1>供应商主页</h1>
<hr>
    <%  Provider user = new Provider();
        user = (Provider) request.getAttribute("user");%>
<a href="pregister.jsp?uid=${uid}">上传营业执照信息</a><br>
<a href="audit/getauditpagebyuid?uid=${uid}">查看审核结果</a>

</body>
</html>
