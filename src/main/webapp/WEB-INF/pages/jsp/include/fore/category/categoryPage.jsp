<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%--<title>模仿天猫官网-${c.name}</title>	--%>
<!--<div id="category">
<div class="categoryPageDiv">


<@include file="productsByCategory.jsp"%>
</div>

</div>-->

<div id="main">
    <div class="section section-bg-10 pt-11 pb-17">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h2 class="page-title text-center">all products</h2>
                </div>
            </div>
        </div>
    </div>
    <div class="section border-bottom pt-2 pb-2">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <ul class="breadcrumbs">
                        <li><a href="#">首页</a></li>
                        <li><a href="#">所有商品</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="section pt-7 pb-7">
        <div class="container">
            <div class="row">
                <div class="col-md-9 col-md-push-3">
                    <div class="shop-filter">
                        <div class="col-md-6">
                            <p class="result-count"> Showing 1–12 of 23 results</p>
                        </div>
                        <div class="col-md-6">
                            <div class="shop-filter-right">
                                <div class="switch-view">
                                    <a href="shop-list.html" class="switcher" data-toggle="tooltip" data-placement="top"
                                       title="" data-original-title="List"><i class="ion-navicon"></i></a>
                                    <a href="shop.html" class="switcher active" data-toggle="tooltip"
                                       data-placement="top" title="" data-original-title="Grid"><i class="ion-grid"></i></a>
                                </div>
                                <form class="commerce-ordering">
                                    <select name="orderby" class="orderby">
                                        <option value="">Sort by popularity</option>
                                        <option value="">Sort by average rating</option>
                                        <option value="" selected="selected">Sort by newness</option>
                                        <option value="">Sort by price: low to high</option>
                                        <option value="">Sort by price: high to low</option>
                                    </select>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="category-carousel-2 mb-3" data-auto-play="true" data-desktop="3" data-laptop="3"
                         data-tablet="2" data-mobile="1">
                        <div class="cat-item">
                            <div class="cats-wrap" data-bg-color="#f8c9c2">
                                <a href="#">
                                    <img src="img/category/cate_7.png" alt=""/>
                                    <h2 class="category-title">
                                        Dried
                                        <mark class="count">(6)</mark>
                                    </h2>
                                </a>
                            </div>
                        </div>
                        <!--<div class="cat-item">
                                <div class="cats-wrap" data-bg-color="#ebd3c3">
                                    <a href="#">
                                        <img src="images/category/cate_5.png" alt="" />
                                        <h2 class="category-title">
                                            Fruiy <mark class="count">(5)</mark>
                                        </h2>
                                    </a>
                                </div>
                            </div>
                            <div class="cat-item">
                                <div class="cats-wrap" data-bg-color="#c6e6f6">
                                    <a href="#">
                                        <img src="images/category/cate_9.png" alt="" />
                                        <h2 class="category-title">
                                            Juice <mark class="count">(6)</mark>
                                        </h2>
                                    </a>
                                </div>
                            </div>
                            <div class="cat-item">
                                <div class="cats-wrap" data-bg-color="#e0d1a1">
                                    <a href="#">
                                        <img src="images/category/cate_6.png" alt="" />
                                        <h2 class="category-title">
                                            Vegetables <mark class="count">(6)</mark>
                                        </h2>
                                    </a>
                                </div>
                            </div>-->
                    </div>
                    <div class="product-grid">

                        <%@include file="productsByCategory.jsp" %>

                    </div>
                    <div class="pagination">
                        <a class="prev page-numbers" href="#">Prev</a>
                        <a class="page-numbers" href="#">1</a>
                        <span class="page-numbers current">2</span>
                        <a class="page-numbers" href="#">3</a>
                        <a class="next page-numbers" href="#">Next</a>
                    </div>
                </div>
                <div class="col-md-3 col-md-pull-9">
                    <div class="sidebar">
                        <!--<div class="widget widget-product-search">
                            <form class="form-search">
                                <input type="text" class="search-field" placeholder="Search products…" value="" name="s" />
                                <input type="submit" value="Search" />
                            </form>
                        </div>-->
                        <div class="widget widget-product-categories">
                            <h3 class="widget-title">商品类别</h3>
                            <ul class="product-categories">
                                <%@include file="../home/categoryMenu.jsp" %>
                                <!--<li><a href="#">Dried</a> <span class="count">6</span></li>
                                <li><a href="#">Fruits</a> <span class="count">5</span></li>
                                <li><a href="#">Juice</a> <span class="count">6</span></li>
                                <li><a href="#">Vegetables</a> <span class="count">6</span></li>-->
                            </ul>
                        </div>
                        <div class="widget widget-products">
                            <h3 class="widget-title">猜你喜欢</h3>
                            <ul class="product-list-widget">
                                <li>
                                    <a href="shop-detail.html">
                                        <img src="img/shop/thumb/shop_1.jpg" alt=""/>
                                        <span class="product-title">橙汁</span>
                                    </a>
                                    <del>$15.00</del>
                                    <ins>$12.00</ins>
                                </li>
                                <li>
                                    <a href="shop-detail.html">
                                        <img src="img/shop/thumb/shop_2.jpg" alt=""/>
                                        <span class="product-title">庄河蓝莓</span>
                                    </a>
                                    <ins>$9.00</ins>
                                </li>
                                <li>
                                    <a href="shop-detail.html">
                                        <img src="img/shop/thumb/shop_3.jpg" alt=""/>
                                        <span class="product-title">草莓酱</span>
                                    </a>
                                    <ins>$15.00</ins>
                                </li>
                                <li>
                                    <a href="shop-detail.html">
                                        <img src="img/shop/thumb/shop_4.jpg" alt=""/>
                                        <span class="product-title">百香果</span>
                                    </a>
                                    <ins>$35.00</ins>
                                </li>
                                <li>
                                    <a href="shop-detail.html">
                                        <img src="img/shop/thumb/shop_5.jpg" alt=""/>
                                        <span class="product-title">有机小胡萝卜</span>
                                    </a>
                                    <ins>$12.00</ins>
                                </li>
                            </ul>
                        </div>
                        <div class="widget widget-tags">
                            <h3 class="widget-title">关键字推荐</h3>
                            <div class="tagcloud">
                                <a href="#">面包</a> <a href="#">小食品</a> <a href="#">水果</a> <a href="#">绿色无公害</a> <a
                                    href="#">健康</a> <a href="#">自然</a> <a href="#">素食</a> <a href="#">蔬菜</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--searchResult.jsp-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-migrate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/modernizr-2.7.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.countdown.min.js"></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery.prettyPhoto.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery.prettyPhoto.init.min.js'></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/core.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/widget.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mouse.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/slider.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.ui.touch-punch.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/price-slider.js"></script>