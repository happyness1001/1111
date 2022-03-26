<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>


<script>
    function showProductsAsideCategorys(cid) {
        $("div.eachCategory[cid=" + cid + "]").css("background-color", "white");
        $("div.eachCategory[cid=" + cid + "] a").css("color", "#87CEFA");
        $("div.productsAsideCategorys[cid=" + cid + "]").show();
    }


    function hideProductsAsideCategorys(cid) {
        $("div.eachCategory[cid=" + cid + "]").css("background-color", "#e2e2e3");
        $("div.eachCategory[cid=" + cid + "] a").css("color", "#000");
        $("div.productsAsideCategorys[cid=" + cid + "]").hide();
    }

    $(function () {
        $("div.eachCategory").mouseenter(function () {
            var cid = $(this).attr("cid");
            showProductsAsideCategorys(cid);
        });
        $("div.eachCategory").mouseleave(function () {
            var cid = $(this).attr("cid");
            hideProductsAsideCategorys(cid);
        });
        $("div.productsAsideCategorys").mouseenter(function () {
            var cid = $(this).attr("cid");
            showProductsAsideCategorys(cid);
        });
        $("div.productsAsideCategorys").mouseleave(function () {
            var cid = $(this).attr("cid");
            hideProductsAsideCategorys(cid);
        });

        $("div.rightMenu span").mouseenter(function () {
            var left = $(this).position().left;
            var top = $(this).position().top;
            var width = $(this).css("width");
            var destLeft = parseInt(left) + parseInt(width) / 2;
            $("img#catear").css("left", destLeft);
            $("img#catear").css("top", top - 20);
            $("img#catear").fadeIn(500);

        });
        $("div.rightMenu span").mouseleave(function () {
            $("img#catear").hide();
        });

        var left = $("div#carousel-of-product").offset().left;
        $("div.categoryMenu").css("left", left - 20);
        $("div.categoryWithCarousel div.head").css("margin-left", left);
        $("div.productsAsideCategorys").css("left", left - 20);


    });
</script>

<img src="img/site/catear.png" id="catear" class="catear"/>

<div class="categoryWithCarousel">
    <div>
        <div class="headbar show1" style="background-color: #5fbd74;height: 50px;padding-top: 8px;">
            <div class="head" style="margin-left:20px;background-color: #5fbd74;">

                <span style="margin-left:10px" class="glyphicon glyphicon-th-list"></span>
                <span style="margin-left:10px;font-size: large;">商品分类</span>

            </div>

            <div class="rightMenu">
                <!--<span><a href=""><img src="img/site/chaoshi.png"/></a></span>
                <span><a href=""><img src="img/site/guoji.png"/></a></span>-->

                <c:forEach items="${cs}" var="c" varStatus="st">
                    <c:if test="${st.count<=4}">
						<span>
						<a href="forecategory?cid=${c.id}" style="font-size: large;">
                                ${c.name}
                        </a></span>
                    </c:if>
                </c:forEach>
                <span>
					<a href="foretuijian" style="font-size: large;">
						活动会场
					</a>
				</span>
                <span>
					<a href="foreGouzuire" style="font-size: large;">
						限时抢购
					</a>
				</span>
            </div>

        </div>
    </div>
    <div>
        <div style="width: 60%;background-color: #8fcf9d;margin-left: 20%;margin-right: 20%;
		padding-left: 50px;padding-right: 50px;padding-top: 20px;padding-bottom: 20px;">
            <div>
                <%@include file="categoryMenu.jsp" %>
                <div style="width: 60%;">
                    <div style="color: #8fcf9d;">———————————————————————————————————————————————————</div>
                </div>
            </div>
        </div>
    </div>

    <!--<div style="position: relative;">
        # @include file="categoryMenu.jsp" #
    </div>-->

    <div style="position: relative;left: 0;top: 0;">
        <%@include file="productsAsideCategorys.jsp" %>
    </div>

    <!--<div style="position: relative;right: 0;top: 0;">
        # @include file="categoryMenu.jsp" #
    </div>-->

    <%@include file="carousel.jsp" %>

    <div class="carouselBackgroundDiv">
    </div>

</div>





