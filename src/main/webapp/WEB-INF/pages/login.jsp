<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<head>
    <base href="<%=basePath%>">
    <%@include file="common/head.jsp" %>
    <script>
        $(function(){
                $(window).keydown(function (e){
                    if (e.keyCode==13){
                        $("#loginBtn").click();
                    }
                })

            }
        )
    </script>
</head>
<body>
<div class="page-wrapper flex-row align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <c:if test="${!empty message}">
                    <div class="alert alert-dismissible alert-danger">
                        ${message}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>

                <div class="card p-4">
                    <form action="adminlogin" method="post">
                        <div class="card-header text-center text-uppercase h4 font-weight-light">
                            客户管理系统
                        </div>

                        <div class="card-body py-5">
                            <div class="form-group">
                                <label class="form-control-label">用户名</label>
                                <input type="text" class="form-control" name="username" value="${cookie.loginAdminAct.value}">
                            </div>

                            <div class="form-group">
                                <label class="form-control-label">密码</label>
                                <input type="password" class="form-control" name="password" value="${cookie.loginAdminPwd.value}">
                            </div>
                            <div class="checkbox"  style="position: relative;top: 30px; left: 10px;">
                                <label>
                                    <c:if test="${not empty cookie.loginAdminAct and not empty cookie.loginAdminPwd}">
                                        <input type="checkbox" name="isRemPwd" checked>
                                    </c:if>
                                    <c:if test="${empty cookie.loginAdminAct or empty cookie.loginAdminPwd}">
                                        <input type="checkbox" name="isRemPwd">
                                    </c:if>
                                    十天内免登录
                                </label>
                            </div>

                        </div>

                        <div class="text-center">
                            <button type="submit" id="loginBtn" class="btn btn-primary px-5">登录</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="common/js.jsp" %>
</body>
</html>
