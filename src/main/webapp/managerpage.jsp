<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<head>
    <title>管理员页面</title>
</head>
<body>
<base href="<%=basePath%>"/>


<p><a href="javascript:void(0)">审核商家</a> </p><br>
<p><a href="audit/auditUser?type=1">审核供应商</a> </p>
</body>
</html>
