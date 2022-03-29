<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<script>
    $(function () {

        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.loginErrorMessageDiv").show();
        </c:if>

        $("form.loginForm").submit(function () {
            if (0 == $("#name").val().length || 0 == $("#password").val().length) {
                $("span.errorMessage").html("请输入账号密码");
                $("div.loginErrorMessageDiv").show();
                return false;
            }
            return true;
        });

        $("form.loginForm input").keyup(function () {
            $("div.loginErrorMessageDiv").hide();
        });


        var left = window.innerWidth / 2 + 162;
        $("div.loginSmallDiv").css("left", left);
    })
</script>

<head>
    <base href="<%=basePath%>">
</head>
<div id="loginDiv" style="position: relative">

    <div class="simpleLogo">
        <a href="${contextPath}"><img src="img/site/simpleLogo.png"></a>
    </div>


    <%--	<img id="loginBackgroundImg" class="loginBackgroundImg" src="img/site/loginBackground.png">--%>

    <form class="loginForm" action="forelogin" method="post">
        <div id="loginSmallDiv" class="loginSmallDiv">
            <div class="loginErrorMessageDiv">
                <div class="alert alert-danger">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
                    <span class="errorMessage"></span>
                </div>
            </div>

            <div class="login_acount_text">账户登录</div>
            <div class="loginInput ">
				<span class="loginInputIcon ">
					<span class=" glyphicon glyphicon-user"></span>
				</span>
                <input id="name" name="name" placeholder="手机/会员名/邮箱" type="text">
            </div>

            <div class="loginInput ">
				<span class="loginInputIcon ">
					<span class=" glyphicon glyphicon-lock"></span>
				</span>
                <input id="password" name="password" type="password" placeholder="密码" type="text">
            </div>
            <select name="userType">
                <option value="0" selected>请选择用户类型</option>
                <option value="3">普通用户</option>
                <option value="2">商户</option>
                <option value="1">供应商</option>
                <option value="4">管理员</option>
            </select>
            <input type="checkbox" name="un-login" value="1"
                   style="width: 16px;height: 16px;border: 1px solid #D0D0D0;border-radius: 2px;">
            <label style="font-size: 14px;color: #9095A2;line-height: 18px;">十天内免登录</label>

            <div>
                <a class="notImplementLink" href="#nowhere">忘记登录密码</a>
                <a href="registerPage" class="pull-right">免费注册</a>
            </div>
            <div style="margin-top:20px">
                <button class="btn btn-block redButton" type="submit">登录</button>
            </div>
        </div>
    </form>


</div>	