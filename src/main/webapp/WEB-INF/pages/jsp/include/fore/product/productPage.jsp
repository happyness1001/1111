<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<title>商品详情-${p.name}</title>
<div class="categoryPictureInProductPageDiv">

</div>

<!--<div class="productPageDiv">

<@include file="imgAndInfo.jsp" %>

<@include file="productReview.jsp" %>

<@include file="productDetail.jsp" %>
</div>-->

<div id="main">
    <div class="section section-bg-10 pt-11 pb-17">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h2 class="page-title text-center">Shop Detail</h2>
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
                        <li>商品详情</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="section pt-7 pb-7">
        <div class="container">
            <div class="row">
                <div class="col-md-9 col-md-push-3">
                    <div class="single-product">

                        <%@include file="imgAndInfo.jsp" %>

                        <div class="col-md-12">
                            <div class="commerce-tabs tabs classic">
                                <ul class="nav nav-tabs tabs">
                                    <li class="active">
                                        <a data-toggle="tab" href="#tab-description" aria-expanded="true">详情</a>
                                    </li>
                                    <li class="">
                                        <a data-toggle="tab" href="#tab-reviews" aria-expanded="false">评论</a>
                                    </li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane fade active in" id="tab-description">
                                        <p>
                                            ${detailed}
                                        </p>
                                    </div>
                                    <div id="tab-reviews" class="tab-pane fade">
                                        <div class="single-comments-list mt-0">
                                            <div class="mb-2">
                                                <h2 class="comment-title">显示评论的数量</h2>
                                            </div>
                                            <ul class="comment-list">
                                                <li>
                                                    <div class="comment-container">
                                                        <div class="comment-author-vcard">
                                                            <img alt="" src="img/avatar/avatar.png"/>
                                                        </div>
                                                        <div class="comment-author-info">
                                                            <span class="comment-author-name">admin</span>
                                                            <a href="#" class="comment-date">July 27, 2016</a>
                                                            <p>Far far away, behind the word mountains, far from the
                                                                countries Vokalia and Consonantia, there live the blind
                                                                texts. Separated they live in Bookmarksgrove right at
                                                                the coast of the Semantics, a large language ocean. A
                                                                small river named Duden flows by their place and
                                                                supplies it with the necessary regelialia.</p>
                                                        </div>
                                                        <div class="reply">
                                                            <a class="comment-reply-link" href="#">Reply</a>
                                                        </div>
                                                    </div>
                                                    <ul class="children">
                                                        <li>
                                                            <div class="comment-container">
                                                                <div class="comment-author-vcard">
                                                                    <img alt="" src="img/avatar/avatar.png"/>
                                                                </div>
                                                                <div class="comment-author-info">
                                                                    <span class="comment-author-name">admin</span>
                                                                    <a href="#" class="comment-date">July 27, 2016</a>
                                                                    <p>Far far away, behind the word mountains, far from
                                                                        the countries Vokalia and Consonantia, there
                                                                        live the blind texts. Separated they live in
                                                                        Bookmarksgrove right at the coast of the
                                                                        Semantics, a large language ocean. A small river
                                                                        named Duden flows by their place and supplies it
                                                                        with the necessary regelialia.</p>
                                                                </div>
                                                                <div class="reply">
                                                                    <a class="comment-reply-link" href="#">Reply</a>
                                                                </div>
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </li>
                                                <li>
                                                    <div class="comment-container">
                                                        <div class="comment-author-vcard">
                                                            <img alt="" src="img/avatar/avatar.png"/>
                                                        </div>
                                                        <div class="comment-author-info">
                                                            <span class="comment-author-name">admin</span>
                                                            <a href="#" class="comment-date">July 27, 2016</a>
                                                            <p>Far far away, behind the word mountains, far from the
                                                                countries Vokalia and Consonantia, there live the blind
                                                                texts. Separated they live in Bookmarksgrove right at
                                                                the coast of the Semantics, a large language ocean. A
                                                                small river named Duden flows by their place and
                                                                supplies it with the necessary regelialia.</p>
                                                        </div>
                                                        <div class="reply">
                                                            <a class="comment-reply-link" href="#">Reply</a>
                                                        </div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="single-comment-form mt-0">
                                            <div class="mb-2">
                                                <h2 class="comment-title">LEAVE A REPLY</h2>
                                            </div>
                                            <form class="comment-form">
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <textarea id="comment" name="comment" cols="45" rows="5"
                                                                  placeholder="Message *"></textarea>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <input id="author" name="author" type="text" value="" size="30"
                                                               placeholder="Name *" class="mb-2">
                                                    </div>
                                                    <div class="col-md-4">
                                                        <input id="email" name="email" type="email" value="" size="30"
                                                               placeholder="Email *" class="mb-2">
                                                    </div>
                                                    <div class="col-md-4">
                                                        <input id="url" name="url" type="text" value=""
                                                               placeholder="Website">
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-2">
                                                        <input name="submit" type="submit" id="submit"
                                                               class="btn btn-alt btn-border" value="Submit">
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="related">
                                <div class="related-title">
                                    <div class="text-center mb-1 section-pretitle fz-34">Related</div>
                                    <h2 class="text-center section-title mtn-2 fz-24">推送相关商品</h2>
                                </div>
                                <div class="product-carousel p-0" data-auto-play="true" data-desktop="3" data-laptop="2"
                                     data-tablet="2" data-mobile="1">
                                    <div class="product-item text-center">
                                        <div class="product-thumb">
                                            <a href="shop-detail.html">
                                                <div class="badges">
                                                    <span class="hot">热销</span>
                                                </div>
                                                <img src="img/shop/shop_5.jpg" alt=""/>
                                            </a>
                                            <div class="product-action">
													<span class="add-to-cart">
														<a href="#" data-toggle="tooltip" data-placement="top"
                                                           title="Add to cart"></a>
													</span>
                                                <span class="wishlist">
														<a href="#" data-toggle="tooltip" data-placement="top"
                                                           title="Add to wishlist"></a>
													</span>
                                                <span class="quickview">
														<a href="#" data-toggle="tooltip" data-placement="top"
                                                           title="Quickview"></a>
													</span>
                                                <span class="compare">
														<a href="#" data-toggle="tooltip" data-placement="top"
                                                           title="Compare"></a>
													</span>
                                            </div>
                                        </div>
                                        <div class="product-info">
                                            <a href="shop-detail.html">
                                                <h2 class="title">相关商品</h2>
                                                <span class="price">$12.00</span>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="product-item text-center">
                                        <div class="product-thumb">
                                            <a href="shop-detail.html">
                                                <span class="outofstock"><span>售空</span>正在补货中...</span>
                                                <img src="img/shop/shop_6.jpg" alt=""/>
                                            </a>
                                            <div class="product-action">
													<span class="add-to-cart">
														<a href="#" data-toggle="tooltip" data-placement="top"
                                                           title="Add to cart"></a>
													</span>
                                                <span class="wishlist">
														<a href="#" data-toggle="tooltip" data-placement="top"
                                                           title="Add to wishlist"></a>
													</span>
                                                <span class="quickview">
														<a href="#" data-toggle="tooltip" data-placement="top"
                                                           title="Quickview"></a>
													</span>
                                                <span class="compare">
														<a href="#" data-toggle="tooltip" data-placement="top"
                                                           title="Compare"></a>
													</span>
                                            </div>
                                        </div>
                                        <div class="product-info">
                                            <a href="shop-detail.html">
                                                <h2 class="title">相关商品</h2>
                                                <span class="price">$6.00</span>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="product-item text-center">
                                        <div class="product-thumb">
                                            <a href="shop-detail.html">
                                                <img src="img/shop/shop_7.jpg" alt=""/>
                                            </a>
                                            <div class="product-action">
													<span class="add-to-cart">
														<a href="#" data-toggle="tooltip" data-placement="top"
                                                           title="Add to cart"></a>
													</span>
                                                <span class="wishlist">
														<a href="#" data-toggle="tooltip" data-placement="top"
                                                           title="Add to wishlist"></a>
													</span>
                                                <span class="quickview">
														<a href="#" data-toggle="tooltip" data-placement="top"
                                                           title="Quickview"></a>
													</span>
                                                <span class="compare">
														<a href="#" data-toggle="tooltip" data-placement="top"
                                                           title="Compare"></a>
													</span>
                                            </div>
                                        </div>
                                        <div class="product-info">
                                            <a href="shop-detail.html">
                                                <h2 class="title">相关商品</h2>
                                                <span class="price">$9.00</span>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="product-item text-center">
                                        <div class="product-thumb">
                                            <a href="shop-detail.html">
                                                <div class="badges">
                                                    <span class="hot">热销</span>
                                                </div>
                                                <img src="img/shop/shop_8.jpg" alt=""/>
                                            </a>
                                            <div class="product-action">
													<span class="add-to-cart">
														<a href="#" data-toggle="tooltip" data-placement="top"
                                                           title="Add to cart"></a>
													</span>
                                                <span class="wishlist">
														<a href="#" data-toggle="tooltip" data-placement="top"
                                                           title="Add to wishlist"></a>
													</span>
                                                <span class="quickview">
														<a href="#" data-toggle="tooltip" data-placement="top"
                                                           title="Quickview"></a>
													</span>
                                                <span class="compare">
														<a href="#" data-toggle="tooltip" data-placement="top"
                                                           title="Compare"></a>
													</span>
                                            </div>
                                        </div>
                                        <div class="product-info">
                                            <a href="shop-detail.html">
                                                <h2 class="title">相关商品</h2>
                                                <span class="price">$9.00</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-migrate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/modernizr-2.7.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.countdown.min.js"></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery.prettyPhoto.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery.prettyPhoto.init.min.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/slick.min.js'></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>