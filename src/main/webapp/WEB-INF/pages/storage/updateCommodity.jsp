<%--
  Created by IntelliJ IDEA.
  User: LN
  Date: 2021/11/12
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品信息</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>修改商品信息</h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/commodity/update" method="post">
        <input type="hidden" name="commodity_id" value="${QCommodity.commodity_id}">

        <div class="form-group">
            <label>商品cate_id</label>
            <input type="text" name="cate_id" class="form-control" placeholder="请输入商品cate_id"
                   value="${QCommodity.cate_id}">
            <label>商品仓库id</label>
            <input type="text" name="store_id" class="form-control" placeholder="请输入商品仓库id"
                   value="${QCommodity.store_id}">
            <label>商品名称</label>
            <input type="text" name="name" class="form-control" placeholder="请输入商品名称" value="${QCommodity.name}">
            <label>商品subtitle</label>
            <input type="text" name="subtitle" class="form-control" placeholder="请输入商品subtitle"
                   value="${QCommodity.subtitle}">
            <label>商品main_image</label>
            <input type="text" name="main_image" class="form-control" placeholder="请上传商品main_image"
                   value="${QCommodity.main_image}">
            <label>商品sub_images</label>
            <input type="text" name="sub_images" class="form-control" placeholder="请上传商品sub_images"
                   value="${QCommodity.sub_images}">
            <label>商品detail</label>
            <input type="text" name="detail" class="form-control" placeholder="请输入商品detail"
                   value="${QCommodity.detail}">
            <label>商品price</label>
            <input type="text" name="price" class="form-control" placeholder="请输入商品price" value="${QCommodity.price}">
            <label>商品quantity</label>
            <input type="text" name="quantity" class="form-control" placeholder="请输入商品quantity"
                   value="${QCommodity.quantity}">
            <label>商品location</label>
            <input type="text" name="location" class="form-control" placeholder="请输入商品location"
                   value="${QCommodity.location}">
            <label>商品status</label>
            <input type="text" name="status" class="form-control" placeholder="请输入商品status 1代表在售 2代表下架"
                   value="${QCommodity.status}">
            <input type="text" name="modify_time" id="modify_time" class="form-control"
                   value="${QCommodity.modify_time}" style=" display:none">
            <script type="text/javascript">
                function time() {
                    const nowDate = new Date();
                    const tt = nowDate.getFullYear() + "-" + (nowDate.getMonth() + 1) + "-" + nowDate.getDate() + ":" + (nowDate.getHours() + ":" + nowDate.getMinutes() + ":" + nowDate.getSeconds())
                    $("#modify_time").val(tt);
                }
            </script>
        </div>
        <div class="form-group">
            <input type="submit" class="form-group" value="修改" id="submit" onclick="time()">
        </div>
    </form>
</div>
</body>
</html>
