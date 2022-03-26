<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<div class="buyPageDiv">
    <form action="forecreateOrder" method="post">

        <div class="buyFlow" style="text-align: center;margin: 40px;">
            <!--<img class="pull-left" src="img/site/simpleLogo.png">-->
            <img src="img/site/buyflow.png">
            <div style="clear:both"></div>
        </div>
        <div class="container">
            <div class="addressTip" style="font-size: large;font-weight: 600;">输入收货地址</div>
            <div class="docs-methods">
                <form class="form-inline">
                    <div id="distpicker">
                        <div class="form-group">
                            <div style="position: relative;">
                                <input id="city-picker3" class="form-control" readonly type="text" value=""
                                       data-toggle="city-picker">
                            </div>
                        </div>
                        <div class="form-group" style="float: right;">
                            <button class="btn btn-warning" id="reset" type="button">重置</button>
                            <button class="btn btn-danger" id="destroy" type="button">确定</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="address" style="margin-left: 20%;margin-right: 20%;width: 60%;">
            <div class="addressTip" style="font-size: large;font-weight: 600;">输入详细信息</div>
            <div>
                <table class="addressTable">
                    <tr style="margin: 5px;">
                        <td class="firstColumn" style="float: right;margin-right: 15px;">详细地址<span
                                class="redStar">*</span></td>

                        <td style="width: 500px;"><textarea name="address"
                                                            placeholder="填写详细收货地址">${current_member.member_address}</textarea>
                        </td>
                    </tr>
                    <tr style="margin: 5px;">
                        <td style="float: right;margin-right: 15px;">邮政编码</td>
                        <td><input name="post" placeholder="如果您不清楚邮递区号，请填写000000" type="text" value="277500"></td>
                    </tr>
                    <tr style="margin: 5px;">
                        <td style="float: right;margin-right: 15px;">收货人姓名<span class="redStar">*</span></td>
                        <td><input name="receiver" placeholder="长度不超过25个字符" type="text"
                                   value=" ${current_member.member_name}"></td>
                    </tr>
                    <tr style="margin: 5px;">
                        <td style="float: right;margin-right: 15px;">手机号码 <span class="redStar">*</span></td>
                        <td><input name="mobile" placeholder="请输入11位手机号码" type="text"
                                   value=" ${current_member.member_phone}"></td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="productList">
            <div class="productListTip" style="margin-left: 20%;font-size: large;font-weight: 600;margin-top: 30px;">
                确认订单信息
            </div>
            <table class="productListTable" style="margin-left: 20%;margin-right: 20%;width: 60%;">
                <thead>
                <tr>
                    <th colspan="2" class="productListTableFirstColumn" style="text-align: center;">
                        <!--<img class="tmallbuy" src="img/site/tmallbuy.png">-->
                        <a class="marketLink" href="#nowhere">商品名称</a>
                        <a class="wangwanglink" href="#nowhere"> <span class="wangwangGif"></span> </a>
                    </th>
                    <th style="text-align: center;">单价</th>
                    <th style="text-align: center;">数量</th>
                    <th style="text-align: center;">小计</th>
                    <th style="text-align: center;">配送方式</th>
                </tr>
                <tr class="rowborder">
                    <td colspan="2"></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <tbody class="productListTableTbody" style="background-color: #f9f9f9;">
                <c:forEach items="${ois}" var="oi" varStatus="st">
                    <tr class="orderItemTR">
                        <td class="orderItemFirstTD" style="width: 110px;"><img class="orderItemImg"
                                                                                style="width: 90px;height: 90px;"
                                                                                src="img/shop/thumb/shop_1.jpg"></td>
                        <td class="orderItemProductInfo" style="width:200px;">
                            <a href="foreproduct?pid=${oi.product.id}" class="orderItemProductLink">
                                    ${oi.product.name}
                            </a>
                                <%--<img src="img/site/creditcard.png" title="支持信用卡支付">--%>
                                <%--<img src="img/site/7day.png" title="消费者保障服务,承诺7天退货">--%>
                                <%--<img src="img/site/promise.png" title="消费者保障服务,承诺如实描述">--%>

                        </td>
                        <td style="text-align: center;font-weight: 600;">

                            <span class="orderItemProductPrice">￥<fmt:formatNumber type="number"
                                                                                   value="${oi.product.promotePrice}"
                                                                                   minFractionDigits="2"
                                                                                   maxFractionDigits="2"/></span>
                        </td>
                        <td style="text-align: center;font-weight: 600;">
                            <span class="orderItemProductNumber">x${oi.number}</span>
                        </td>
                        <td style="text-align: center;font-weight: 600;color: #ff9800;"><span class="orderItemUnitSum">
						￥<fmt:formatNumber type="number" value="${oi.number*oi.product.promotePrice}"
                                           minFractionDigits="2" maxFractionDigits="2"/>
						</span></td>
                        <c:if test="${st.count==1}">
                            <td rowspan="5" class="orderItemLastTD" style="width:180px;">
                                <label class="orderItemDeliveryLabel">
                                    <input type="radio" value="" checked="checked">
                                    普通配送
                                </label>

                                <select class="orderItemDeliverySelect" class="form-control">
                                    <option>快递 免邮费</option>
                                </select>

                            </td>
                        </c:if>

                    </tr>
                </c:forEach>

                </tbody>

            </table>
            <div class="orderItemSumDiv" style="margin-left: 20%;margin-right: 20%;width: 60%;height: 150px;margin-top: 20px;margin-bottom: 20px;
		background-color: #f9f9f9;padding: 10px;border-radius: 5px;">
                <div class="pull-left">
                    <span class="leaveMessageText">订单备注:</span>
                    <span>
					<!--<img class="leaveMessageImg" src="img/site/leaveMessage.png">-->
				</span>
                    <span class="leaveMessageTextareaSpan">
					<textarea name="userMessage" class="leaveMessageTextarea"></textarea>
					<div>
						<span>还可以输入200个字符</span>
					</div>
				</span>
                </div>

                <span class="pull-right" style="font-weight: 600;">店铺合计(含运费): <span
                        style="font-weight: 600;color: #7a7777;">￥<fmt:formatNumber type="number" value="${total}"
                                                                                    minFractionDigits="2"
                                                                                    maxFractionDigits="2"/></span></span>
            </div>


        </div>

        <div class="orderItemTotalSumDiv" style="margin-left: 20%;margin-right: 20%;width: 60%;height: 50px;">
            <div class="pull-right">
                <span>实付款：</span>
                <span class="orderItemTotalSumSpan"
                      style="color: #ff9800;font-size: x-large;font-weight: 600;">￥<fmt:formatNumber type="number"
                                                                                                     value="${total}"
                                                                                                     minFractionDigits="2"
                                                                                                     maxFractionDigits="2"/></span>
            </div>
        </div>


        <div class="submitOrderDiv"
             style="margin-left: 20%;margin-right: 20%;width: 60%;margin-bottom: 50px;height: 41px;">
            <button type="submit" class="submitOrderButton" style="float: right;">提交订单</button>
        </div>
    </form>
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

<script src="http://hovertree.com/texiao/bootstrap/4/js/city-picker.data.js"></script>
<script src="http://hovertree.com/texiao/bootstrap/4/js/city-picker.js"></script>
<script src="http://hovertree.com/texiao/bootstrap/4/js/main.js"></script>