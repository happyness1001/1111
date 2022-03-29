<%@ page import="entity.BusinessLicenseInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>

<head>
    <title>营业执照信息</title>
    <base href="<%=basePath%>">
</head>
<body>
<h1>营业执照信息</h1>
<%
    BusinessLicenseInfo bl = (BusinessLicenseInfo) request.getAttribute("bL");
%>
<hr>
公司名称：<%=bl.getCorporateName()%><br>
公司电话：<%=bl.getOfficePhone()%><br>
营业执照所在地：<%=bl.getLocationOfBusinessLicense()%><br>
公司详细地址：<%=bl.getAddressOfBusinessLicense()%><br>
联系人姓名：<%=bl.getEmergencyContact()%><br>
联系人手机：<%=bl.getPhoneOfEmergencyContact()%><br>
营业执照号：<%=bl.getBusinessLicense()%><br>
成立日期：<%=bl.getDateOfIncorporation()%><br>
法定代表人：<%=bl.getFrName()%><br>
法定代表人身份证号：<%=bl.getFrontOfIdCardPhoto()%><br>
注册资本：<%=bl.getRegisteredCapital()%><br>
营业范围：<%=bl.getBusinessScope()%><br>
<hr>
<form action="audit/updateAuditresult">
    <input type="text" name="auditPageId" value="<%=bl.getAuditPageId()%>" style="display: none">
    <input type="text" name="type" value="1" style="display: none">
    请选择审核结果：
    <select name="state">
        <option value="0">未通过</option>
        <option value="1">通过</option>
        <option value="2" selected>待审核</option>
    </select><br>
    审核意见：
    <input type="text" name="remark" value="请输入审核意见"><br>
    <button type="submit"  >提交</button>
</form>

</body>
</html>
