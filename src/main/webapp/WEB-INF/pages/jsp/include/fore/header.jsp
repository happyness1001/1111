<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/toastr.min.css" type="text/css" media="all">
    <!--home.jsp-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css" type="text/css"
          media="all"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ionicons.min.css" type="text/css" media="all"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.css" type="text/css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.theme.css" type="text/css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/settings.css" type="text/css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css" type="text/css" media="all">

    <!--searchResult.jsp-->
    <link rel='stylesheet' href='${pageContext.request.contextPath}/css/prettyPhoto.css' type='text/css' media='all'>
    <!--product.jsp-->
    <link rel='stylesheet' href='${pageContext.request.contextPath}/css/slick.css' type='text/css' media='all'>
    <!--cart.jsp-->
    <!--buy.jsp-->
    <link href="http://hovertree.com/texiao/bootstrap/4/css/city-picker.css" rel="stylesheet" type="text/css"/>

    <link href="http://fonts.googleapis.com/css?family=Great+Vibes%7CLato:100,100i,300,300i,400,400i,700,700i,900,900i"
          rel="stylesheet">

    <script src="http://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <!--<script src="${pageContext.request.contextPath}/admin/assets/js/jquery.min.js"></script>
	<link href="${pageContext.request.contextPath}/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/js/bootstrap/3.3.6/bootstrap.min.js"></script>
	<link href="${pageContext.request.contextPath}/css/fore/style.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/js/layer/2.4/layer.js"></script>-->
    <script>
        function formatMoney(num) {
            num = num.toString().replace(/\$|\,/g, '');
            if (isNaN(num))
                num = "0";
            sign = (num == (num = Math.abs(num)));
            num = Math.floor(num * 100 + 0.50000000001);
            cents = num % 100;
            num = Math.floor(num / 100).toString();
            if (cents < 10)
                cents = "0" + cents;
            for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
                num = num.substring(0, num.length - (4 * i + 3)) + ',' +
                    num.substring(num.length - (4 * i + 3));
            return (((sign) ? '' : '-') + num + '.' + cents);
        }

        function checkEmpty(id, name) {
            var value = $("#" + id).val();
            if (value.length == 0) {

                $("#" + id)[0].focus();
                return false;
            }
            return true;
        }


        $(function () {


            $("a.productDetailTopReviewLink").click(function () {
                $("div.productReviewDiv").show();
                $("div.productDetailDiv").hide();
            });
            $("a.productReviewTopPartSelectedLink").click(function () {
                $("div.productReviewDiv").hide();
                $("div.productDetailDiv").show();
            });

            $("span.leaveMessageTextareaSpan").hide();
            $("img.leaveMessageImg").click(function () {

                $(this).hide();
                $("span.leaveMessageTextareaSpan").show();
                $("div.orderItemSumDiv").css("height", "100px");
            });

            $("div#footer a[href$=#nowhere]").click(function () {
                alert("模仿农村集采商城的连接，并没有跳转到实际的页面");
            });


            $("a.wangwanglink").click(function () {
                alert("模仿旺旺的图标，并不会打开旺旺");
            });
            $("a.notImplementLink").click(function () {
                alert("这个功能没做，蛤蛤~");
            });


        });

    </script>
</head>

<body>

