<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>

<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>登陆</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="libs/particles/css/style.css">
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/login.css"/>
</head>
<body>
<!-- particles.js container -->
<div id="particles-js"></div>
<div id="wrapper">
    <div>
        <h2>农村集采项目</h2>
    </div>
    <nav class="switch_nav">
        <a href="register.jsp" id="switch_signup" class="switch_btn">注册</a>
        <a href="javascript:;" id="switch_login" class="switch_btn on">登陆</a>
        <div class="switch_bottom" id="switch_bottom"></div>
    </nav>
    <div id="login">
        <form method="post" action="user/login" method="POST">
            <ul class="group_input">
                <li>
                    <input type="text" class="mobile required" id="mobile" name="name" placeholder="账户名"/>
                </li>
                <li>
                    <input type="password" class="psd required" id="psd" name="password" placeholder="密码"/>
                </li>
            </ul>
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
            <button type="submit" class="submit_btn" id="btnSubmit">登陆</button>
        </form>

        <div class="states">
            <span class="left"><a href="javascript:;">手机验证码登陆</a></span>
            <span class="right"><a href="javascript:;">无法登陆？</a></span>
        </div>
        <div class="states">
            <a href="javascript:;" class="social_account">社交账号登陆</a>
            <div class="states three_MinIcon">
                <a href="javascript:;" class="MinIcon_weixin"><img src="img/icon_weixin.jpg"
                                                                   style="width:20px;height:18px"/></a>
                <a href="javascript:;" class="MinIcon_weibo"><img src="img/icon_weibo.jpg"
                                                                  style="width:20px;height:18px"/></a>
                <a href="javascript:;" class="MinIcon_qq"><img src="img/icon_qq.jpg"
                                                               style="width:20px;height:18px"/></a>
            </div>
        </div>
    </div>

</div>
<script src="libs/jquery-1.12.4/jquery.min.js"></script>
<script src="libs/particles/particles.min.js"></script>
<script src="libs/particles/js/app.js"></script>
<!-- <script src="libs/particles/js/lib/stats.js"></script> -->
<script>
    var count_particles, stats, update;
    stats = new Stats;
    stats.setMode(0);
    stats.domElement.style.position = 'absolute';
    stats.domElement.style.left = '0px';
    stats.domElement.style.top = '0px';
    document.body.appendChild(stats.domElement);
    count_particles = document.querySelector('.js-count-particles');
    update = function () {
        stats.begin();
        stats.end();
        if (window.pJSDom[0].pJS.particles && window.pJSDom[0].pJS.particles.array) {
            count_particles.innerText = window.pJSDom[0].pJS.particles.array.length;
        }
        requestAnimationFrame(update);
    };
    requestAnimationFrame(update);
</script>
<script>
    $(function () {
        //为表单的必填文本框添加提示信息（选择form中的所有后代input元素）
        // $("form :input.required").each(function () {
        //     //通过jquery api：$("HTML字符串") 创建jquery对象
        //     var $required = $("<strong class='high'>*</strong>");
        //     //添加到this对象的父级对象下
        //     $(this).parent().append($required);
        // });
        // var errorMsg = $(".error-msg").text();
        //为表单元素添加失去焦点事件
        if ('null' != "<%=request.getAttribute("msg")%>") {
            alert('<%=request.getAttribute("msg")%>')
        }
        $("form :input").blur(function () {
            var $parent = $(this).parent();
            $parent.find(".msg").remove(); //删除以前的提醒元素（find()：查找匹配元素集中元素的所有匹配元素）
            //验证手机号
            if ($(this).is("#mobile")) {
                var mobileVal = $.trim(this.value);
                // var regMobile = /^1[3|4|5|7|8][0-9]{9}$/;
                if (mobileVal == "") {
                    var errorMsg = " 请输入手机号或邮箱！";
                    $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
                } else {
                    var okMsg = " 输入正确";
                    $parent.append("<span class='msg onSuccess'>" + okMsg + "</span>");
                }
            }
            //验证密码
            if ($(this).is("#psd")) {
                var psdVal = $.trim(this.value);
                var regPsd = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
                if (psdVal == "" || !regPsd.test(psdVal)) {
                    var errorMsg = " 密码为6-20位字母、数字的组合！";
                    $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
                } else {
                    var okMsg = " 输入正确";
                    $parent.append("<span class='msg onSuccess'>" + okMsg + "</span>");
                }
            }
        }).keyup(function () {
            //triggerHandler 防止事件执行完后，浏览器自动为标签获得焦点
            $(this).triggerHandler("blur");
        }).focus(function () {
            $(this).triggerHandler("blur");
        });

        //点击重置按钮时，通过trigger()来触发文本框的失去焦点事件
        $("#btnSubmit").click(function () {
            //trigger 事件执行完后，浏览器会为submit按钮获得焦点
            $("form .required:input").trigger("blur");
            var numError = $("form .onError").length;
            if (numError) {
                return false;
            }

        });
    })

</script>
</body>
</html>