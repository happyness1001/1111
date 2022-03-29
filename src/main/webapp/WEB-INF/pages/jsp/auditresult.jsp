<%@ page import="entity.AuditPage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>审核结果</title>
</head>
<body>
<h1>审核结果</h1>
<hr>
<%
    AuditPage auditPage = (AuditPage) request.getAttribute("auditPage");
    String auditResult = "申请待审核";
    if (auditPage.getState() == 0){
        auditResult = "申请未通过审核";
    }else if (auditPage.getState() == 1){
        auditResult = "申请已通过审核";
    }
    String remark = auditPage.getRemark();
%>
审核结果：<%=auditResult%><br>
处理时间：<%=auditPage.getUpdateDateTime()%><br>
管理员备注：<%=remark%>
</body>
</html>
