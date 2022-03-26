<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!--<div style="height: 110px;">
<div style="width: 146px;float: left;margin-left: 20%;margin-top: -20px;">
<a href="${contextPath}">
<img id="logo" src="img/site/logo.png" class="logo">
</a>
</div>
<div class="searchDiv" style="width: 600px;margin-bottom: 0px;margin-top: 50px;">
<form action="foresearch" method="post" >
<input name="keyword" type="text" value="${param.keyword}" placeholder="时尚男鞋 太阳镜 " style="width: 500px">
<button type="submit" class="searchButton" style="width: 90px;font-weight: 500;">搜索</button>
<div class="searchBelow" style="text-align: center;">
<c:forEach items="${cs}" var="c" varStatus="st">
    <c:if test="${st.count>=5 and st.count<=8}">
        <span>
        <a href="forecategory?cid=${c.id}">
        ${c.name}
        </a>
        <c:if test="${st.count!=8}">
            <span>|</span>
        </c:if>
        </span>
    </c:if>
</c:forEach>
</div>
</form>
</div>

</div>-->

<header id="header" class="header header-desktop header-2">
    <div class="top-search">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <form>
                        <input type="search" class="top-search-input" name="s" placeholder="What are you looking for?"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="#" id="logo">
                    <img class="logo-image" src="img/logo.png" alt="Organik Logo"/>
                </a>
            </div>
            <div class="col-md-9">
                <div class="header-right">
                    <nav class="menu">
                        <ul class="main-menu" style="font-size: larger;">
                            <li><a href="forehome">首页</a></li>
                            <li><a href="about-us.html"></a></li>
                            <li><a href="forecategory?cid=80">所有商品</a></li>
                            <!--<li><a href="shop-list.html">Shop List</a></li>-->
                            <li><a href="forecart">购物车</a></li>
                            <li><a href="forecart">我的订单</a></li>
                            <%--							<li><a href="checkout.html支付买单">Checkout</a></li>--%>
                            <!--<li><a href="contact-us.html">Contact</a></li>-->
                        </ul>
                    </nav>
                    <div class="btn-wrap">
                        <div class="mini-cart-wrap">
                            <%--							<div class="mini-cart">--%>
                            <%--								<div class="mini-cart-icon" data-count="2" >--%>
                            <%--									<i class="ion-bag"></i>--%>
                            <%--								</div>--%>
                            <%--							</div>--%>
                            <%--							<div class="widget-shopping-cart-content">--%>
                            <%--								<ul class="cart-list">--%>
                            <%--									<li>--%>
                            <%--										<a href="forecart" class="remove">×</a>--%>
                            <%--										<a href="shop-detail.html">--%>
                            <%--											<img src="img/shop/thumb/shop_1.jpg" alt="" />--%>
                            <%--											Orange Juice&nbsp;--%>
                            <%--										</a>--%>
                            <%--										<span class="quantity">1 × $12.00</span>--%>
                            <%--									</li>--%>
                            <%--									<li>--%>
                            <%--										<a href="#" class="remove">×</a>--%>
                            <%--										<a href="shop-detail.html">--%>
                            <%--											<img src="img/shop/thumb/shop_2.jpg" alt="" />--%>
                            <%--											Aurore Grape&nbsp;--%>
                            <%--										</a>--%>
                            <%--										<span class="quantity">1 × $9.00</span>--%>
                            <%--									</li>--%>
                            <%--								</ul>--%>
                            <%--								<p class="total">--%>
                            <%--									<strong>Subtotal:</strong>--%>
                            <%--									<span class="amount">$21.00</span>--%>
                            <%--								</p>--%>
                            <%--								<p class="buttons">--%>
                            <%--									<a href="cart.html" class="view-cart">View cart</a>--%>
                            <%--									<a href="checkout.html" class="checkout">Checkout</a>--%>
                            <%--								</p>--%>
                            <%--							</div>--%>
                        </div>
                        <div class="top-search-btn-wrap">
                            <div class="top-search-btn">
                                <a href="javascript:void(0);">
                                    <i class="ion-search"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<header class="header header-mobile">
    <div class="container">
        <div class="row">
            <div class="col-xs-2">
                <div class="header-left">
                    <div id="open-left"><i class="ion-navicon"></i></div>
                </div>
            </div>
            <div class="col-xs-8">
                <div class="header-center">
                    <a href="#" id="logo-2">
                        <img class="logo-image" src="img/logo.png" alt="Organik Logo"/>
                    </a>
                </div>
            </div>
            <div class="col-xs-2">
                <div class="header-right">
                    <div class="mini-cart-wrap">
                        <a href="cart.html">
                            <div class="mini-cart">
                                <div class="mini-cart-icon" data-count="2">
                                    <i class="ion-bag"></i>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
