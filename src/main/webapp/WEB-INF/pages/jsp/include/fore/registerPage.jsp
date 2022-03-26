<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>


<script>
    $(function () {

        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.registerErrorMessageDiv").css("visibility", "visible");
        </c:if>

        $(".registerForm").submit(function () {
            if (0 == $("#name").val().length) {
                $("span.errorMessage").html("请输入用户名");
                $("div.registerErrorMessageDiv").css("visibility", "visible");
                return false;
            }
            if (0 == $("#password").val().length) {
                $("span.errorMessage").html("请输入密码");
                $("div.registerErrorMessageDiv").css("visibility", "visible");
                return false;
            }
            if (0 == $("#repeatpassword").val().length) {
                $("span.errorMessage").html("请输入重复密码");
                $("div.registerErrorMessageDiv").css("visibility", "visible");
                return false;
            }
            if ($("#password").val() != $("#repeatpassword").val()) {
                $("span.errorMessage").html("重复密码不一致");
                $("div.registerErrorMessageDiv").css("visibility", "visible");
                return false;
            }

            return true;
        });
    })
</script>


<form method="post" action="foreregister" class="registerForm">


    <div class="registerDiv">
        <div class="registerErrorMessageDiv">
            <div class="alert alert-danger" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
                <span class="errorMessage"></span>
            </div>
        </div>


        <table class="registerTable" align="center">
            <tr>
                <td class="registerTip registerTableLeftTD" style="font-size: large;">新建一个用户名：</td>
                <td></td>
            </tr>
            <tr>
                <td class="registerTableLeftTD" style="font-size: medium;">用户名</td>
                <td class="registerTableRightTD"><input id="name" name="name" placeholder="用户名将不可修改"></td>
            </tr>
            <tr>
                <td class="registerTip registerTableLeftTD" style="font-size: large;">设置一个登录密码：</td>
                <!--<td  class="registerTableRightTD">登陆时验证，保护账号信息</td>-->
            </tr>
            <tr>
                <td class="registerTableLeftTD" style="font-size: medium;">输入密码</td>
                <td class="registerTableRightTD"><input id="password" name="password" type="password"
                                                        placeholder="设置新的密码"></td>
            </tr>
            <tr>
                <td class="registerTableLeftTD" style="font-size: medium;">确认密码</td>
                <td class="registerTableRightTD"><input id="repeatpassword" type="password" placeholder="请再次输入密码"></td>
            </tr>

            <tr>
                <td colspan="2" class="registerButtonTD">
                    <a href="registerSuccess.jsp" style="background-color: #5fbd74;font-size: medium;">
                        <button>注册</button>
                    </a>
                </td>
            </tr>
        </table>
    </div>
</form>