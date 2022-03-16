<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<script type="text/javascript">
    window.location.href = "login";
</script>
</body>
</html>

