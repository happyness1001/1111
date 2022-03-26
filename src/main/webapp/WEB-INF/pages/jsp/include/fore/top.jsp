<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>


<!--<nav class="top " style="height: 50px;
width: 100%;
padding-top: 17px;
background-color: #444;
border-bottom-color: #444;
padding-left: 20%;
padding-right: 20%;
font-size: larger;">
<a href="${pageContext.request.contextPath}/forehome">
<span style="color:#C40000;margin:0px" class=" glyphicon glyphicon-home redColor"></span>村镇零售商城
</a>

<c:if test="${!empty user}">
    <a href="">${user.name}</a>
    <a href="personalCenter" >个人中心</a>
    <a href="forelogout">退出</a>

</c:if>

<c:if test="${empty user}">
    <a href="loginPage">登录</a>
    <a href="loginPage" style="margin: 0;">|</a>
    <a href="registerPage">注册</a>
    <a href="adminloginPage">我是管理</a>
</c:if>

<span class="pull-right">
<c:if test="${!empty user}">
    <a href="shouCangPage">我的收藏</a>
    <a href="keFuPage">我的客服</a>
</c:if>
<a href="forebought">我的订单</a>
<a href="forecart">
<span style="color:#c5c9c5;margin:0px" class=" glyphicon glyphicon-shopping-cart redColor"></span>
购物车<strong>${cartTotalItemNumber}</strong>件</a>
</span>
</nav>-->

<div class="topbar">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <%--				<div class="topbar-text">--%>
                <%--					<span></span>--%>
                <%--					<span></span>--%>
                <%--				</div>--%>
            </div>
            <div class="col-md-6">
                <div class="topbar-menu">
                    <ul class="topbar-menu">
                        <%--						<li class="dropdown">--%>
                        <%--							<a href="#">选择语言</a>--%>
                        <%--							<ul class="sub-menu">--%>
                        <%--								<li><a href="#">中文</a></li>--%>
                        <%--								<li><a href="#">英文</a></li>--%>
                        <%--							</ul>--%>
                        <%--						</li>--%>
                        <c:if test="${empty user}">
                            <li><a href="${pageContext.request.contextPath}/loginPage">登录</a></li>
                            <li><a href="${pageContext.request.contextPath}/registerPage">注册</a></li>
                        </c:if>
                        <c:if test="${!empty user}">
                            <li><a href="#">${user.name}</a></li>
                            <li><a href="personalCenter">个人中心</a></li>
                            <li><a href="forelogout">退出</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>


