<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>


<script>
    var deleteOrderItem = false;
    var deleteOrderItemid = 0;

    calcCartSumPriceAndNumber();

    function go_numberPlus(pid) {
        //var pid=$(this).attr("pid");
        var stock = $("span.orderItemStock[pid=" + pid + "]").text();
        var price = $("span.orderItemPromotePrice[pid=" + pid + "]").text();
        var num = $(".orderItemNumberSetting[pid=" + pid + "]").val();

        num++;
        if (num > stock)
            num = stock;
        syncPrice(pid, num, price);
    }

    function go_numberMinus(pid) {
        //var pid=$(this).attr("pid");
        var stock = $("span.orderItemStock[pid=" + pid + "]").text();
        var price = $("span.orderItemPromotePrice[pid=" + pid + "]").text();

        var num = $(".orderItemNumberSetting[pid=" + pid + "]").val();
        --num;
        if (num <= 0)
            num = 1;
        syncPrice(pid, num, price);
    }

    (".orderItemNumberSetting").keyup(function () {
        var pid = $(this).attr("pid");
        var stock = $("span.orderItemStock[pid=" + pid + "]").text();
        var price = $("span.orderItemPromotePrice[pid=" + pid + "]").text();

        var num = $(".orderItemNumberSetting[pid=" + pid + "]").val();
        num = parseInt(num);
        if (isNaN(num))
            num = 1;
        if (num <= 0)
            num = 1;
        if (num > stock)
            num = stock;

        syncPrice(pid, num, price);
    });

    function deleteOrderItems(obj, oid) {
        6
        var msg = "确认从购物车移除该商品吗？";
        if (confirm(msg) == true) {
            $.ajax({
                type: 'PUT',
                async: false,
                url: '/foredeleteOrderItem?oiid=' + oid,
                dataType: 'text',
                success: function (data) {
                    if (data == 'success') {
                        toastr.options.positionClass = 'toast-top-center';
                        toastr.success('已移除');
                        $("tr.cartProductItemTR[oiid=" + oid + "]").hide();
                    } else {
                        location.href = "loginPage";
                    }
                },
                error: function (XMLHttpRequest) {
                    toastr.options.positionClass = 'toast-top-center';
                    toastr.error('数据处理失败! 错误码:' + XMLHttpRequest.status);
                }
            });
        } else {

        }
    }


    function select_all_pro() {
        if ("selectit" == $("#img_all_select").attr("selectit")) {

            $("img.selectAllItem").attr("src", "img/site/cartNotSelected.png");
            $("img.selectAllItem").attr("selectit", "false");
            $(".cartProductItemIfSelected").each(function () {
                $(this).attr("src", "img/site/cartNotSelected.png");
                $(this).attr("selectit", "false");
                $(this).parents("tr.cartProductItemTR").css("background-color", "#fff");
            });
        } else {
            $("img.selectAllItem").attr("src", "img/site/cartSelected.png");
            $("img.selectAllItem").attr("selectit", "selectit");
            $(".cartProductItemIfSelected").each(function () {
                $(this).attr("src", "img/site/cartSelected.png");
                $(this).attr("selectit", "selectit");
                $(this).parents("tr.cartProductItemTR").css("background-color", "#FFF8E1");
            });
        }
        syncCreateOrderButton();
        calcCartSumPriceAndNumber();
    }

    function select_index_pro(id) {
        var img = $("#img_select_" + id);
        if ("selectit" == $("#img_select_" + id).attr("selectit")) {
            img.attr("src", "img/site/cartNotSelected.png");
            img.attr("selectit", "false")
            img.parents("tr.cartProductItemTR").css("background-color", "#fff");
        } else {
            img.attr("src", "img/site/cartSelected.png");
            img.attr("selectit", "selectit")
            img.parents("tr.cartProductItemTR").css("background-color", "#FFF8E1");
        }
        syncSelect();
        syncCreateOrderButton();
        calcCartSumPriceAndNumber();

    }

    $(function () {
        $("a.deleteOrderItem").click(function () {
            deleteOrderItem = false;
            var oiid = $(this).attr("oiid");
            deleteOrderItemid = oiid;
            $("#deleteConfirmModal").modal('show');
            alert(oiid);
        });
        $("button.deleteConfirmButton").click(function () {
            deleteOrderItem = true;
            $("#deleteConfirmModal").modal('hide');
        });

        $('#deleteConfirmModal').on('hidden.bs.modal', function (e) {
            console.log(deleteOrderItem)
            if (deleteOrderItem) {
                var page = "foredeleteOrderItem";
                $.post(
                    page,
                    {"oiid": deleteOrderItemid},
                    function (result) {
                        if ("success" == result) {
                            $("tr.cartProductItemTR[oiid=" + deleteOrderItemid + "]").hide();
                        } else {
                            location.href = "loginPage";
                        }
                    }
                );

            }
        })


        $("img.cartProductItemIfSelected").click(function () {
            var selectit = $(this).attr("selectit")
            if ("selectit" == selectit) {
                $(this).attr("src", "img/site/cartNotSelected.png");
                $(this).attr("selectit", "false")
                $(this).parents("tr.cartProductItemTR").css("background-color", "#fff");
            } else {
                $(this).attr("src", "img/site/cartSelected.png");
                $(this).attr("selectit", "selectit")
                $(this).parents("tr.cartProductItemTR").css("background-color", "#FFF8E1");
            }
            syncSelect();
            syncCreateOrderButton();
            calcCartSumPriceAndNumber();
        });

        $("img.selectAllItem").click(function () {
            var selectit = $(this).attr("selectit")
            if ("selectit" == selectit) {
                $("img.selectAllItem").attr("src", "img/site/cartNotSelected.png");
                $("img.selectAllItem").attr("selectit", "false")
                $(".cartProductItemIfSelected").each(function () {
                    $(this).attr("src", "img/site/cartNotSelected.png");
                    $(this).attr("selectit", "false");
                    $(this).parents("tr.cartProductItemTR").css("background-color", "#fff");
                });
            } else {
                $("img.selectAllItem").attr("src", "img/site/cartSelected.png");
                $("img.selectAllItem").attr("selectit", "selectit")
                $(".cartProductItemIfSelected").each(function () {
                    $(this).attr("src", "img/site/cartSelected.png");
                    $(this).attr("selectit", "selectit");
                    $(this).parents("tr.cartProductItemTR").css("background-color", "#FFF8E1");
                });
            }
            syncCreateOrderButton();
            calcCartSumPriceAndNumber();


        });

        $(".orderItemNumberSetting").keyup(function () {
            var pid = $(this).attr("pid");
            var stock = $("span.orderItemStock[pid=" + pid + "]").text();
            var price = $("span.orderItemPromotePrice[pid=" + pid + "]").text();

            var num = $(".orderItemNumberSetting[pid=" + pid + "]").val();
            num = parseInt(num);
            if (isNaN(num))
                num = 1;
            if (num <= 0)
                num = 1;
            if (num > stock)
                num = stock;

            syncPrice(pid, num, price);
        });

        $(".numberPlus").click(function () {

            var pid = $(this).attr("pid");
            var stock = $("span.orderItemStock[pid=" + pid + "]").text();
            var price = $("span.orderItemPromotePrice[pid=" + pid + "]").text();
            var num = $(".orderItemNumberSetting[pid=" + pid + "]").val();

            num++;
            if (num > stock)
                num = stock;
            syncPrice(pid, num, price);
        });
        $(".numberMinus").click(function () {
            var pid = $(this).attr("pid");
            var stock = $("span.orderItemStock[pid=" + pid + "]").text();
            var price = $("span.orderItemPromotePrice[pid=" + pid + "]").text();

            var num = $(".orderItemNumberSetting[pid=" + pid + "]").val();
            --num;
            if (num <= 0)
                num = 1;
            syncPrice(pid, num, price);
        });

        $("button.createOrderButton").click(function () {
            var params = "";
            $(".cartProductItemIfSelected").each(function () {
                if ("selectit" == $(this).attr("selectit")) {
                    var oiid = $(this).attr("oiid");
                    params += "&oiid=" + oiid;
                }
            });
            params = params.substring(1);
            location.href = "forebuy?" + params;
        });


    })

    function syncCreateOrderButton() {
        var selectAny = false;
        $(".cartProductItemIfSelected").each(function () {
            if ("selectit" == $(this).attr("selectit")) {
                selectAny = true;
            }
        });

        if (selectAny) {
            $("button.createOrderButton").css("background-color", "#C40000");
            $("button.createOrderButton").removeAttr("disabled");
        } else {
            $("button.createOrderButton").css("background-color", "#AAAAAA");
            $("button.createOrderButton").attr("disabled", "disabled");
        }

    }

    function syncSelect() {
        var selectAll = true;
        $(".cartProductItemIfSelected").each(function () {
            if ("false" == $(this).attr("selectit")) {
                selectAll = false;
            }
        });

        if (selectAll)
            $("img.selectAllItem").attr("src", "img/site/cartSelected.png");
        else
            $("img.selectAllItem").attr("src", "img/site/cartNotSelected.png");


    }

    function calcCartSumPriceAndNumber() {
        var sum = 0;
        var totalNumber = 0;
        $("img.cartProductItemIfSelected[selectit='selectit']").each(function () {
            var oiid = $(this).attr("oiid");
            var price = $(".cartProductItemSmallSumPrice[oiid=" + oiid + "]").text();
            price = price.replace(/,/g, "");
            price = price.replace(/￥/g, "");
            sum += new Number(price);

            var num = $(".orderItemNumberSetting[oiid=" + oiid + "]").val();
            totalNumber += new Number(num);

        });

        $("span.cartSumPrice").html("￥" + formatMoney(sum));
        $("span.cartTitlePrice").html("￥" + formatMoney(sum));
        $("span.cartSumNumber").html(totalNumber);
    }

    function syncPrice(pid, num, price) {
        $(".orderItemNumberSetting[pid=" + pid + "]").val(num);
        var cartProductItemSmallSumPrice = formatMoney(num * price);
        $(".cartProductItemSmallSumPrice[pid=" + pid + "]").html("￥" + cartProductItemSmallSumPrice);
        calcCartSumPriceAndNumber();

        var page = "forechangeOrderItem";
        $.post(
            page,
            {"pid": pid, "number": num},
            function (result) {
                if ("success" != result) {
                    location.href = "loginPage";
                }
            }
        );

    }
</script>

<title>购物车</title>
<%--<div class="cartDiv">--%>
<%--	<div class="cartTitle pull-right">--%>
<%--		<span>已选商品  (不含运费)</span>--%>
<%--		<span class="cartTitlePrice">￥0.00</span>--%>
<%--		<button class="createOrderButton" disabled="disabled">结 算</button>--%>
<%--	</div>--%>
<%--	--%>
<%--	--%>
<%--	<div class="cartProductList">--%>
<%--		<table class="cartProductTable">--%>
<%--			<thead>--%>
<%--				<tr>--%>
<%--					<th class="selectAndImage">--%>
<%--							<img selectit="false" class="selectAllItem" src="img/site/cartNotSelected.png">				--%>
<%--					全选--%>
<%--					--%>
<%--					</th>--%>
<%--					<th>商品信息</th>--%>
<%--					<th>单价</th>--%>
<%--					<th>数量</th>--%>
<%--					<th width="120px">金额</th>--%>
<%--					<th class="operation">操作</th>--%>
<%--				</tr>--%>
<%--			</thead>--%>
<%--			<tbody>--%>
<%--				<c:forEach items="${ois }" var="oi">--%>
<%--					<tr oiid="${oi.id}" class="cartProductItemTR">--%>
<%--						<td>--%>
<%--							<img selectit="false" oiid="${oi.id}" class="cartProductItemIfSelected" src="img/site/cartNotSelected.png">--%>
<%--							<a style="display:none" href="#nowhere"><img src="img/site/cartSelected.png"></a>--%>
<%--							<img class="cartProductImg"  src="img/productSingle_middle/${oi.product.imageName}">--%>
<%--						</td>--%>
<%--						<td>--%>
<%--							<div class="cartProductLinkOutDiv">--%>
<%--								<a href="foreproduct?pid=${oi.product.id}" class="cartProductLink">${oi.product.name}</a>--%>
<%--								<div class="cartProductLinkInnerDiv">--%>
<%--									<img src="img/site/creditcard.png" title="支持信用卡支付">--%>
<%--									<img src="img/site/7day.png" title="消费者保障服务,承诺7天退货">--%>
<%--									<img src="img/site/promise.png" title="消费者保障服务,承诺如实描述">--%>
<%--								</div>--%>
<%--							</div>--%>
<%--							--%>
<%--						</td>--%>
<%--						<td>--%>
<%--							<span class="cartProductItemOringalPrice">￥${oi.product.originalPrice}</span>--%>
<%--							<span  class="cartProductItemPromotionPrice">￥${oi.product.promotePrice}</span>--%>
<%--							--%>
<%--						</td>--%>
<%--						<td>--%>
<%--						--%>
<%--							<div class="cartProductChangeNumberDiv">--%>
<%--								<span class="hidden orderItemStock " pid="${oi.product.id}">${oi.product.stock}</span>--%>
<%--								<span class="hidden orderItemPromotePrice " pid="${oi.product.id}">${oi.product.promotePrice}</span>--%>
<%--								<a  pid="${oi.product.id}" class="numberMinus" href="#nowhere">-</a>--%>
<%--								<input pid="${oi.product.id}" oiid="${oi.id}" class="orderItemNumberSetting" autocomplete="off" value="${oi.number}">--%>
<%--								<a  stock="${oi.product.stock}" pid="${oi.product.id}" class="numberPlus" href="#nowhere">+</a>--%>
<%--							</div>					--%>
<%--						--%>
<%--						 </td>--%>
<%--						<td >--%>
<%--							<span class="cartProductItemSmallSumPrice" oiid="${oi.id}" pid="${oi.product.id}" >--%>
<%--							￥<fmt:formatNumber type="number" value="${oi.product.promotePrice*oi.number}" minFractionDigits="2"/>--%>
<%--							</span>--%>
<%--						--%>
<%--						</td>--%>
<%--						<td>--%>
<%--							<a href="javascript:;" onclick="deleteOrderItems(this,${oi.id})" >删除</a>--%>
<%--						</td>--%>
<%--					</tr>--%>
<%--				</c:forEach>				--%>
<%--			</tbody>--%>
<%--		--%>
<%--		</table>--%>
<%--	</div>--%>
<%--	--%>
<%--	<div class="cartFoot">--%>
<%--		<img selectit="false" class="selectAllItem" src="img/site/cartNotSelected.png">--%>
<%--		<span>全选</span>--%>
<%-- 		<a href="#">删除</a>--%>
<%--		--%>
<%--		<div class="pull-right">--%>
<%--			<span>已选商品 <span class="cartSumNumber" >0</span> 件</span>--%>
<%--			--%>
<%--			<span>合计 (不含运费): </span> --%>
<%--			<span class="cartSumPrice" >￥0.00</span>--%>
<%--			<button class="createOrderButton" disabled="disabled" >结  算</button>--%>
<%--		</div>--%>
<%--		--%>
<%--	</div>--%>
<%--	--%>
<%--</div>--%>

<div id="main">
    <div class="section section-bg-10 pt-11 pb-17">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h2 class="page-title text-center">Cart</h2>
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
                        <li>购物车</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="section pt-7 pb-7">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <table class="table shop-cart">
                        <thead>
                        <tr>
                            <th class="selectAndImage" style="width:70px;">
                                <img id="img_all_select" selectit="false" class="selectAllItem"
                                     src="img/site/cartNotSelected.png" onclick="select_all_pro()"/>
                                全选
                            </th>
                            <th style="text-align: center;">商品信息</th>
                            <th style="text-align: center;"></th>
                            <th style="text-align: center;">数量</th>
                            <th width="120px" style="text-align: center;">金额</th>
                            <th class="operation" style="text-align: center;">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${ois }" var="oi">
                            <tr oiid="${oi.id}" class="cart_item cartProductItemTR">
                                <td>
                                    <img id="img_select_${oi.id}" selectit="false" oiid="${oi.id}"
                                         class="cartProductItemIfSelected" src="img/site/cartNotSelected.png"
                                         onclick="select_index_pro(${oi.id})">
                                    <a style="display:none" href="#nowhere"><img src="img/site/cartSelected.png"></a>
                                </td>
                                <td class="product-thumbnail">
                                    <a href="shop-detail.html">
                                        <img src="img/shop/thumb/shop_1.jpg" alt="">
                                    </a>
                                </td>
                                <td class="product-info">
                                    <div class="cartProductLinkOutDiv">
                                        <a href="foreproduct?pid=${oi.product.id}" class="cartProductLink"
                                           style="font-size: small;font-weight: 600;">${oi.product.name}</a>
                                        <span class="cartProductItemOringalPrice"
                                              style="text-decoration: line-through;color: #8b8a8a;font-size: smaller;">￥${oi.product.originalPrice}</span>
                                        <span class="cartProductItemPromotionPrice"
                                              style="font-weight: 600;color: #ff9800;">￥${oi.product.promotePrice}</span>
                                        <div class="cartProductLinkInnerDiv">
                                            <img src="img/site/creditcard.png" title="支持信用卡支付">
                                            <img src="img/site/7day.png" title="消费者保障服务,承诺7天退货">
                                            <img src="img/site/promise.png" title="消费者保障服务,承诺如实描述">
                                        </div>
                                    </div>
                                    <!--<a href="shop-detail.html">Black Hoodie</a>-->
                                </td>
                                <td class="product-quantity">
                                    <div class="cartProductChangeNumberDiv"
                                         style="width: 100px;border: #9e9e9e 1px;border-style: solid;">
                                        <span class="hidden orderItemStock "
                                              pid="${oi.product.id}">${oi.product.stock}</span>
                                        <span class="hidden orderItemPromotePrice "
                                              pid="${oi.product.id}">${oi.product.promotePrice}</span>
                                        <a style="font-size: x-large;" pid="${oi.product.id}" class="numberMinus"
                                           href="#nowhere" onclick="go_numberMinus('${oi.product.id}')">-</a>
                                        <input style="width: 70px;border-style: none;margin-bottom: 5px;text-align: center;"
                                               pid="${oi.product.id}" oiid="${oi.id}" class="orderItemNumberSetting"
                                               autocomplete="off" value="${oi.number}">
                                        <a style="float: right;font-size: x-large;" stock="${oi.product.stock}"
                                           pid="${oi.product.id}" class="numberPlus" href="#nowhere"
                                           onclick="go_numberPlus('${oi.product.id}')">+</a>
                                    </div>
                                </td>
                                <td class="product-subtotal">
                                    <span class="amount cartProductItemSmallSumPrice"
                                          style="font-size: medium;font-weight: 600;" oiid="${oi.id}"
                                          pid="${oi.product.id}">￥<fmt:formatNumber type="number"
                                                                                    value="${oi.product.promotePrice*oi.number}"
                                                                                    minFractionDigits="2"/></span>
                                </td>
                                <td class="product-remove">
                                    <a href="javascript:;" onclick="deleteOrderItems(this,${oi.id})"
                                       class="remove">×</a>
                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="6" class="actions">
                                <a class="continue-shopping" href="#"> Continue Shopping</a>
                                <input type="submit" class="update-cart" name="update_cart" value="Update Cart"/>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-4">
                    <div class="cart-totals">
                        <table>
                            <tbody>
                            <tr class="cart-subtotal">
                                <th>Subtotal</th>
                                <td class="cartSumPrice">0</td>
                            </tr>
                            <tr class="shipping">
                                <th>Shipping</th>
                                <td>Free Shipping</td>
                            </tr>
                            <tr class="order-total">
                                <th>Total</th>
                                <td><strong>$146.00</strong></td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="proceed-to-checkout">
                            <a href="#">Proceed to Checkout</a>
                        </div>
                    </div>
                    <div class="coupon-shipping">
                        <div class="coupon">
                            <form>
                                <input type="text" name="coupon_code" class="coupon-code" id="coupon_code" value=""
                                       placeholder="Coupon code"/>
                                <input type="submit" class="apply-coupon" name="apply_coupon" value="Apply Coupon"/>
                            </form>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>