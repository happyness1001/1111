<%@ page import="java.util.ArrayList" %>
<%@ page import="mxz.entity.Provider" %>
<%@ page import="mxz.entity.AuditPage" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>待审核供应商</title>
</head>
<body>
<center>
    <form>
        <table border="1px" >
            <tr>
                <td>供应商ID</td>
                <td>审核状态</td>
                <td>用户类型</td>
                <td>审核单更新时间</td>
                <td>详细信息</td>
            </tr>
            <%
                ArrayList<AuditPage> userList = (ArrayList<AuditPage>) request.getAttribute("userList");
                for (AuditPage auditPage: userList) {
                    String uid = auditPage.getUid();
                    String aduitPageId = auditPage.getAuditPageId();
                    Timestamp createDateTime = auditPage.getCreateDateTime();
            %>
            <tr>
                <td><%=uid%></td>
                <td>待审核</td>
                <td>供应商</td>
                <td><%=createDateTime%></td>
                <td><a href="audit/BLInfo?id=<%=aduitPageId%>">详细信息</a> </td>
            </tr>
            <%
                }
            %>
        </table>
    </form>
</center>
</body>
</html>
