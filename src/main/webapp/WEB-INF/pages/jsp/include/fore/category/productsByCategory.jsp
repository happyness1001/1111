<!-- 模仿天猫整站ssm 教程 为how2j.cn 版权所有-->
<!-- 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关-->
<!-- 供购买者学习，请勿私自传播，否则自行承担相关法律责任-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${empty param.categorycount}">
    <c:set var="categorycount" scope="page" value="100"/>
</c:if>

<c:if test="${!empty param.categorycount}">
    <c:set var="categorycount" scope="page" value="${param.categorycount}"/>
</c:if>

<!--<div class="categoryProducts">
<c:if test="${showProduct=='showProduct'}">
    <c:forEach items="${c.products}" var="p" varStatus="stc">
        <c:if test="${p.status ne 0 and p.stock gt 0}">
            <c:if test="${stc.count<=categorycount}">
                <div class="productUnit" price="${p.promotePrice}">
                <div class="productUnitFrame">
                <a href="foreproduct?pid=${p.id}">
                <img class="productImage" src="img/productSingle_middle/${p.imageName}">
                </a>
                <span class="productPrice">¥<fmt:formatNumber type="number" value="${p.promotePrice}"
                                                              minFractionDigits="2"/></span>
                <a class="productLink" href="foreproduct?pid=${p.id}">
                ${fn:substring(p.name, 0, 50)}
                </a>

                <a class="tmallLink" href="foreproduct?pid=${p.id}">天猫专卖</a>

                <div class="show1 productInfo">
                <span class="monthDeal ">月成交 <span class="productDealNumber">${p.saleCount}笔</span></span>
                <span class="productReview">评价<span class="productReviewNumber">${p.reviewCount}</span></span>
                <span class="wangwang">
                <a class="wangwanglink" href="#nowhere">
                <img src="img/site/wangwang.png">
                </a>

                </span>
                </div>
                </div>
                </div>
            </c:if>
        </c:if>
    </c:forEach>
</c:if>
<c:if test="${showProduct!='showProduct'}">
    <c:forEach items="${c}" var="p" varStatus="stc">
        <c:if test="${p.status ne 0 and p.stock gt 0}">
            <div class="productUnit" price="${p.promotePrice}">
            <div class="productUnitFrame">
            <a href="foreproduct?pid=${p.id}">

            <img class="productImage" src="img/productSingle_middle/${p.firstProductImage.id}.jpg">
            </a>
            <span class="productPrice">¥<fmt:formatNumber type="number" value="${p.promotePrice}"
                                                          minFractionDigits="2"/></span>
            <a class="productLink" href="foreproduct?pid=${p.id}">
            ${fn:substring(p.name, 0, 50)}
            </a>

            <a class="tmallLink" href="foreproduct?pid=${p.id}">天猫专卖</a>

            <div class="show1 productInfo">
            <span class="monthDeal ">月成交 <span class="productDealNumber">${p.saleCount}笔</span></span>
            <span class="productReview">评价<span class="productReviewNumber">${p.reviewCount}</span></span>
            <span class="wangwang">
            <a class="wangwanglink" href="#nowhere">
            <img src="img/site/wangwang.png">
            </a>

            </span>
            </div>
            </div>
            </div>
        </c:if>
    </c:forEach>
</c:if>
<div style="clear:both"></div>
</div>-->
<c:if test="${showProduct=='showProduct'}">
    <c:forEach items="${c.products}" var="p" varStatus="stc">
        <c:if test="${p.status ne 0 and p.stock gt 0}">
            <c:if test="${stc.count<=categorycount}">
                <div class="col-md-4 col-sm-6 product-item text-center mb-3">
                    <div class="product-thumb">
                        <a href="foreproduct?pid=${p.id}">
                            <div class="badges">
                                <span class="hot">热销</span>
                                <span class="onsale">活动</span>
                            </div>
                            <img src="img/shop/shop_1.jpg" alt=""/>
                        </a>
                        <div class="product-action">
							<span class="add-to-cart">
								<a href="#" data-toggle="tooltip" data-placement="top" title="Add to cart"></a>
							</span>
                            <span class="wishlist">
								<a href="#" data-toggle="tooltip" data-placement="top" title="Add to wishlist"></a>
							</span>
                            <span class="quickview">
								<a href="#" data-toggle="tooltip" data-placement="top" title="Quickview"></a>
							</span>
                            <span class="compare">
								<!--<a href="#" data-toggle="tooltip" data-placement="top" title="Compare"></a>-->
							</span>
                        </div>
                    </div>
                    <div class="product-info">
                        <a href="foreproduct?pid=${p.id}" style="text-decoration: none;">
                            <h2 class="title" style="font-size: small;">${fn:substring(p.name, 0, 50)}</h2>
                            <div>
								<span style="font-size: small;">
								 已售<ins style="color: #5fbd74;">${p.saleCount}</ins>件 |
								 共<ins style="color: #5fbd74;">${p.reviewCount}</ins>条评论
							    </span>
                            </div>
                            <span class="price">
								<del><fmt:formatNumber type="number" value="${p.promotePrice}"
                                                       minFractionDigits="2"/></del>
								<ins><fmt:formatNumber type="number" value="${p.promotePrice}"
                                                       minFractionDigits="2"/></ins>
							</span>
                        </a>
                    </div>
                </div>
            </c:if>
        </c:if>
    </c:forEach>
</c:if>