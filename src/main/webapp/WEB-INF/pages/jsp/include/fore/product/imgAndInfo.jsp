<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>

    <%--$(function(){--%>
    <%--    var stock = ${p.stock};--%>
    <%--    $(".productNumberSetting").keyup(function(){--%>
    <%--        var num= $(".productNumberSetting").val();--%>
    <%--        num = parseInt(num);--%>
    <%--        if(isNaN(num))--%>
    <%--            num= 1;--%>
    <%--        if(num<=0)--%>
    <%--            num = 1;--%>
    <%--        if(num>stock)--%>
    <%--            num = stock;--%>
    <%--        $(".productNumberSetting").val(num);--%>
    <%--    });--%>

    <%--    $(".increaseNumber").click(function(){--%>
    <%--        var num= $(".productNumberSetting").val();--%>
    <%--        num++;--%>
    <%--        if(num>stock)--%>
    <%--            num = stock;--%>
    <%--        $(".productNumberSetting").val(num);--%>
    <%--    });--%>
    <%--    $(".decreaseNumber").click(function(){--%>
    <%--        var num= $(".productNumberSetting").val();--%>
    <%--        --num;--%>
    <%--        if(num<=0)--%>
    <%--            num=1;--%>
    <%--        $(".productNumberSetting").val(num);--%>
    <%--    });--%>

    <%--    $(".addCartButton").removeAttr("disabled");--%>
    <%--    $(".addCartLink").click(function(){--%>
    <%--        var page = "forecheckLogin";--%>
    <%--        $.get(--%>
    <%--                page,--%>
    <%--                function(result){--%>
    <%--                    if("success"==result){--%>
    <%--                        var pid = ${p.id};--%>
    <%--                        var num= 1;--%>
    <%--                        alert(num);--%>
    <%--                        var addCartpage = "foreaddCart";--%>
    <%--                        $.get(--%>
    <%--                                addCartpage,--%>
    <%--                                {"pid":pid,"num":num},--%>
    <%--                                function(result){--%>
    <%--                                    if("success"==result){--%>
    <%--                                       // $(".addCartButton").html("已加入购物车");--%>
    <%--                                       // $(".addCartButton").attr("disabled","disabled");--%>
    <%--                                       // $(".addCartButton").css("background-color","lightgray")--%>
    <%--                                       // $(".addCartButton").css("border-color","lightgray")--%>
    <%--                                       // $(".addCartButton").css("color","black")--%>
    <%--                                    }--%>
    <%--                                    else{--%>

    <%--                                    }--%>
    <%--                                }--%>
    <%--                        );--%>
    <%--                    }--%>
    <%--                    else{--%>
    <%--                        // $("#loginModal").modal('show');--%>
    <%--                        window.location.href='loginPage';--%>
    <%--                    }--%>
    <%--                }--%>
    <%--        );--%>
    <%--        return false;--%>
    <%--    });--%>
    <%--    $(".buyLink").click(function(){--%>
    <%--        var page = "forecheckLogin";--%>
    <%--        $.get(--%>
    <%--                page,--%>
    <%--                function(result){--%>
    <%--                    if("success"==result){--%>
    <%--                        var num = $(".productNumberSetting").val();--%>
    <%--                        location.href= $(".buyLink").attr("href")+"&num="+num;--%>
    <%--                    }--%>
    <%--                    else{--%>
    <%--                        // $("#loginModal").modal('show');--%>
    <%--                        // $.get("fore/login");--%>
    <%--                        window.location.href='loginPage';--%>
    <%--                    }--%>
    <%--                }--%>
    <%--        );--%>
    <%--        return false;--%>
    <%--    });--%>

    <%--    $("button.loginSubmitButton").click(function(){--%>
    <%--        var name = $("#name").val();--%>
    <%--        var password = $("#password").val();--%>

    <%--        if(0==name.length||0==password.length){--%>
    <%--            $("span.errorMessage").html("请输入账号密码");--%>
    <%--            $("div.loginErrorMessageDiv").show();--%>
    <%--            return false;--%>
    <%--        }--%>
    <%--        var page = "foreloginAjax";--%>
    <%--        $.get(--%>
    <%--                page,--%>
    <%--                {"name":name,"password":password},--%>
    <%--                function(result){--%>
    <%--                    if("success"==result){--%>
    <%--                        location.reload();--%>
    <%--                    }--%>
    <%--                    else{--%>
    <%--                        $("span.errorMessage").html("账号密码错误");--%>
    <%--                        $("div.loginErrorMessageDiv").show();--%>
    <%--                    }--%>
    <%--                }--%>
    <%--        );--%>

    <%--        return true;--%>
    <%--    });--%>

    <%--    $("img.smallImage").mouseenter(function(){--%>
    <%--        var bigImageURL = $(this).attr("bigImageURL");--%>
    <%--        $("img.bigImg").attr("src",bigImageURL);--%>
    <%--    });--%>

    <%--    $("img.bigImg").load(--%>
    <%--        function(){--%>
    <%--            $("img.smallImage").each(function(){--%>
    <%--                var bigImageURL = $(this).attr("bigImageURL");--%>
    <%--                img = new Image();--%>
    <%--                img.src = bigImageURL;--%>

    <%--                img.onload = function(){--%>
    <%--                    $("div.img4load").append($(img));--%>
    <%--                };--%>
    <%--            });--%>
    <%--        }--%>
    <%--    );--%>
    <%--});--%>

    function go_cart(id) {
        var page = "forecheckLogin";
        $.get(
            page,
            function (result) {
                if ("success" == result) {
                    var pid = id;
                    var num = document.getElementById("product_num").value;
                    var addCartpage = "foreaddCart";
                    $.ajax({
                        url: "foreaddCart",
                        data: {"pid": 266, "num": 1},
                        type: "GET",
                        success: function (re) {
                            if ("success" == result) {
                                toastr.options.positionClass = 'toast-top-center';
                                toastr.success('已加入购物车');
                            } else {
                                toastr.options.positionClass = 'toast-top-center';
                                toastr.error('系统错误，请稍后重试');
                            }
                        }
                    });
                } else {
                    // $("#loginModal").modal('show');
                    window.location.href = 'loginPage';
                }
            });
        //return false;
        //alert(1);
        //alert(id);
        //window.location.href = "foreaddCart?pid="+ id + "&num="+document.getElementById("product_num").value;
        //alert(2);
    }

    function go_buy_imm(id) {
        var page = "forecheckLogin";
        $.get(
            page,
            function (result) {
                if ("success" == result) {
                    window.location.href = "forebuyone?pid=" + id + "&num=" + document.getElementById("product_num").value;
                } else {
                    window.location.href = 'loginPage';
                }
            });

    }

</script>

<%--<div class="imgAndInfo">--%>
<%-- --%>
<%--    <div class="imgInimgAndInfo">--%>
<%--        <img src="img/productSingle_middle/${p.imageName}" class="bigImg">--%>
<%--        <div class="smallImageDiv">--%>
<%--           &lt;%&ndash; <c:forEach items="${p.productSingleImages}" var="pi">--%>
<%--                <img src="img/productSingle_small/${pi.id}.jpg" class="smallImage">--%>
<%--            </c:forEach>&ndash;%&gt;--%>
<%--        </div>--%>
<%--        <div class="img4load hidden" ></div>--%>
<%--    </div>--%>


<%--    <div class="infoInimgAndInfo">--%>
<%--         --%>
<%--        <div class="productTitle">--%>
<%--            ${p.name}--%>
<%--        </div>--%>
<%--        <div class="productSubTitle">--%>
<%--            ${p.subTitle} --%>
<%--        </div>--%>


<%--        <div class="productPrice">--%>
<%--            <div class="juhuasuan">--%>
<%--                <span class="juhuasuanBig" >聚划算</span>--%>
<%--                <span>此商品即将参加聚划算，<span class="juhuasuanTime">1天19小时</span>后开始，</span>--%>
<%--            </div>--%>


<%--            <div class="productPriceDiv">--%>
<%--                <div class="gouwujuanDiv"><img height="16px" src="img/site/gouwujuan.png">--%>
<%--                <span> 全天猫实物商品通用</span>--%>
<%--                 --%>
<%--                </div>--%>
<%--                <div class="originalDiv">--%>
<%--                    <span class="originalPriceDesc">价格</span>--%>
<%--                    <span class="originalPriceYuan">¥</span>--%>
<%--                    <span class="originalPrice">--%>
<%--                        <fmt:formatNumber type="number" value="${p.originalPrice}" minFractionDigits="2"/>--%>
<%--                    </span>--%>
<%--                </div>--%>

<%--                <div class="promotionDiv">--%>
<%--                    <span class="promotionPriceDesc">促销价 </span>--%>
<%--                    <span class="promotionPriceYuan">¥</span>--%>
<%--                    <span class="promotionPrice">--%>
<%--                        <fmt:formatNumber type="number" value="${p.promotePrice}" minFractionDigits="2"/>--%>
<%--                    </span>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="productSaleAndReviewNumber">--%>
<%--            <div>销量 <span class="redColor boldWord"> ${p.saleCount }</span></div>   --%>
<%--            <div>累计评价 <span class="redColor boldWord"> ${p.reviewCount}</span></div>    --%>
<%--        </div>--%>
<%--        <div class="productNumber">--%>
<%--            <span>数量</span>--%>
<%--            <span>--%>
<%--                <span class="productNumberSettingSpan">--%>
<%--                <input class="productNumberSetting" type="text" value="1">--%>
<%--                </span>--%>
<%--                <span class="arrow">--%>
<%--                    <a href="#nowhere" class="increaseNumber">--%>
<%--                    <span class="updown">--%>
<%--                            <img src="img/site/increase.png">--%>
<%--                    </span>--%>
<%--                    </a>--%>
<%--                     --%>
<%--                    <span class="updownMiddle"> </span>--%>
<%--                    <a href="#nowhere"  class="decreaseNumber">--%>
<%--                    <span class="updown">--%>
<%--                            <img src="img/site/decrease.png">--%>
<%--                    </span>--%>
<%--                    </a>--%>
<%--                     --%>
<%--                </span>--%>
<%--                     --%>
<%--            件</span>--%>
<%--            <span>库存${p.stock}件</span>--%>
<%--        </div>--%>
<%--        <div class="serviceCommitment">--%>
<%--            <span class="serviceCommitmentDesc">服务承诺</span>--%>
<%--            <span class="serviceCommitmentLink">--%>
<%--                <a href="#nowhere">正品保证</a>--%>
<%--                <a href="#nowhere">极速退款</a>--%>
<%--                <a href="#nowhere">赠运费险</a>--%>
<%--                <a href="#nowhere">七天无理由退换</a>--%>
<%--            </span>--%>
<%--        </div>    --%>
<%--         --%>
<%--        <div class="buyDiv">--%>
<%--            <a class="buyLink" href="forebuyone?pid=${p.id}"><button class="buyButton">立即购买</button></a>--%>
<%--            <a href="#nowhere" class="addCartLink"><button class="addCartButton"><span class="glyphicon glyphicon-shopping-cart"></span>加入购物车</button></a>--%>
<%--        </div>--%>

<%--        <c:if test="${isShouChang=='false'}">--%>
<%--            <a href="shoucangSucceed?pid=${p.id}">--%>
<%--                <button style="margin-left: 500px" class="orderListItemConfirm">加入收藏</button>--%>
<%--            </a>--%>
<%--        </c:if>--%>

<%--    </div>--%>
<%--     --%>
<%--    <div style="clear:both"></div>--%>
<%--     --%>
<%--</div>--%>

<div class="col-md-6">
    <div class="image-gallery">
        <div class="image-gallery-inner">
            <div>
                <div class="image-thumb">
                    <a href="img/shop/large/shop_1.jpg" data-rel="prettyPhoto[gallery]">
                        <img src="img/shop/shop_1.jpg" alt=""/>
                    </a>
                </div>
            </div>
            <div>
                <div class="image-thumb">
                    <a href="img/shop/large/shop_2.jpg" data-rel="prettyPhoto[gallery]">
                        <img src="img/shop/shop_3.jpg" alt=""/>
                    </a>
                </div>
            </div>
            <div>
                <div class="image-thumb">
                    <a href="img/shop/large/shop_3.jpg" data-rel="prettyPhoto[gallery]">
                        <img src="img/shop/shop_4.jpg" alt=""/>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div class="image-gallery-nav">
        <div class="image-nav-item">
            <div class="image-thumb">
                <img src="img/shop/thumb/shop_1.jpg" alt=""/>
            </div>
        </div>
        <div class="image-nav-item">
            <div class="image-thumb">
                <img src="img/shop/thumb/shop_3.jpg" alt=""/>
            </div>
        </div>
        <div class="image-nav-item">
            <div class="image-thumb">
                <img src="img/shop/thumb/shop_4.jpg" alt=""/>
            </div>
        </div>
    </div>
</div>
<div class="col-md-6">
    <div class="summary">
        <h1 class="product-title" style="font-size: large;">${p.name}</h1>
        <div class="product-rating">
            <div class="star-rating">
                <span style="width:100%"></span>
            </div>
            <i>(共 ${p.reviewCount} 条评价)</i>
        </div>
        <div class="product-price">
            <del>￥<fmt:formatNumber type="number" value="${p.originalPrice}" minFractionDigits="2"/></del>
            <ins>￥<fmt:formatNumber type="number" value="${p.promotePrice}" minFractionDigits="2"/></ins>
        </div>
        <div class="mb-3">
            <p>${p.subTitle}</p>
        </div>
        <div class="mb-3">
            <p>${p.detailed}</p>
        </div>
        <div class="cart"
             style="margin-bottom: 20px;padding: 30px 0 0 0;border-width: 1px 0 0 0;border-style: solid;border-color: #f1eeea;">
            <div class="quantity-chooser">
                <div class="quantity" style="max-width: 120px;height: 40px;line-height: 1;border: 1px solid #f1eeea;-webkit-border-radius: 2px;-moz-border-radius: 2px;
    border-radius: 2px;padding: 10px;display: inline-block;background: #fbfaf9;float: left;margin: 0 10px 0 0;">
                    <span class="qty-minus" data-min="1" style="float: left;cursor: pointer;"><i
                            class="ion-ios-minus-outline"></i></span>
                    <input id="product_num" type="text" name="quantity" value="1" title="Qty"
                           class="input-text qty text" size="4" style="float: left;
    border: 0;line-height: 1;height: auto;padding: 0 10px;background: none;width: 3.631em;text-align: center;">
                    <span class="qty-plus" data-max="" style="float: left;cursor: pointer;"><i
                            class="ion-ios-plus-outline"></i></span>
                </div>
            </div>
            <button class="single-add-to-cart" onclick="go_cart(${p.id})">添加购物车</button>
            <button class="single-add-to-cart btn-warning" onclick="go_buy_imm(${p.id})">立即购买</button>
        </div>
        <div class="product-tool">
            <a href="#" data-toggle="tooltip" data-placement="top" title="Add to wishlist">收藏</a>
            <!--<a class="compare" href="#" data-toggle="tooltip" data-placement="top" title="Add to compare">比价</a>-->
        </div>
        <div class="product-meta">
            <table>
                <tbody>
                <tr>
                    <td class="label">类别</td>
                    <td><a href="#"></a></td>
                </tr>
                <tr>
                    <td class="label">分享</td>
                    <td class="share">
                        <a target="_blank" href="#"><i class="fa fa-facebook"></i></a>
                        <a target="_blank" href="#"><i class="fa fa-twitter"></i></a>
                        <a target="_blank" href="#"><i class="fa fa-google-plus"></i></a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
