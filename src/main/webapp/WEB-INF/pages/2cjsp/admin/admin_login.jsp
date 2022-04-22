<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>农村集采后台管理系统</title>
    <link rel="Shortcut Icon" href="icon/all.png"/>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="农村集采后台管理系统 v1.0,农村集采,农村集采购物商城后台管理系统">
    <meta name="description" content="农村集采后台管理系统 v1.0，是一款电商后台管理系统，适合中小型CMS后台系统。">
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- Meta tag Keywords -->

    <!-- css files -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/login/style.css" type="text/css" media="all"/>
    <!-- Style-CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/login/font-awesome.css">
    <!-- Font-Awesome-Icons-CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/layer/2.4/skin/layer.css">
    <!-- Font-Awesome-Icons-CSS -->

    <!-- js -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery-2.1.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/login/jquery.vide.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/2.4/layer.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/lib/jquery.validation/1.14.0/validate-methods.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/gt.js"></script>
    <!-- Hotjar Tracking Code for http://xmadmin.exirck.cn -->
    <script>
        (function (h, o, t, j, a, r) {
            h.hj = h.hj || function () {
                (h.hj.q = h.hj.q || []).push(arguments)
            };
            h._hjSettings = {hjid: 695920, hjsv: 6};
            a = o.getElementsByTagName('head')[0];
            r = o.createElement('script');
            r.async = 1;
            r.src = t + h._hjSettings.hjid + j + h._hjSettings.hjsv;
            a.appendChild(r);
        })(window, document, 'https://static.hotjar.com/c/hotjar-', '.js?sv=');
    </script>
    <script>
        var _hmt = _hmt || [];
        (function () {
            var hm = document.createElement("script");
            hm.src = "https://hm.baidu.com/hm.js?90194188523e0a2d04ad3ad170c83f30";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>

    <style>
        .title, h6 {
            font-family: "黑体";
        }

        span.icon1 {
            top: 23%;
        }

        span.icon2 {
            top: 42%;
        }

        #wait {
            text-align: left;
            color: #ffffff;
            margin: 0;
            font-family: "黑体";
        }
    </style>
</head>
<body>

<!-- main -->
<div data-vide-bg="lib/video/Ipad">
    <div class="center-container">
        <!--header-->
        <div class="header-w3l">
            <h1>集采商城后台管理系统</h1>
        </div>
        <!--//header-->
        <div class="main-content-agile">
            <div class="sub-main-w3">
                <div class="wthree-pro">
                    <h2>Login Here</h2>
                </div>
                <form id="login" action="adminLogin" method="post" >
                    <input placeholder="用户名" name="name" id="username" class="user" type="text" required="">
                    <span class="icon1"><i class="fa fa-user" aria-hidden="true"></i></span><br><br>
                    <input placeholder="密码" name="password" id="password" class="pass" type="password" required="">
                    <span class="icon2"><i class="fa fa-unlock" aria-hidden="true"></i></span><br><br>


                    <div class="sub-w3l">
                        <div class="right-w3l">
                            <input id="loginButton" type="submit" class="login" value="登录">
                        </div>
                    </div>
                    <%--                    <div style="margin-top:20px">--%>
                    <%--                        <button class="btn btn-block redButton" type="submit">登录</button>--%>
                    <%--                    </div>--%>
                </form>
            </div>
        </div>
        <!--//main-->

        <!--footer-->
        <div class="footer">
            <p>&copy; 2022 DLUT. All rights reserved | Design by <a href="#" target="_blank">DLUT</a></p>
        </div>
        <!--//footer-->
    </div>
</div>
</body>
</html>
