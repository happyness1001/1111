<%--
  Created by IntelliJ IDEA.
  User: LN
  Date: 2021/11/11
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加商品</title>
    <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>新增商品</h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/commodity/addCommodity" method="post">

        <div class="form-group">
            <label>商品cate_id</label>
            <input type="text" name="cate_id" class="form-control" placeholder="请输入商品cate_id" >
            <label>商品仓库id</label>
            <input type="text" name="store_id" class="form-control" placeholder="请输入商品仓库id" >
            <label>商品名称</label>
            <input type="text" name="name" class="form-control" placeholder="请输入商品名称" >
            <label>商品subtitle</label>
            <input type="text" name="subtitle" class="form-control" placeholder="请输入商品subtitle" >
            <label>商品main_image</label>
            <input type="text" name="main_image" class="form-control" placeholder="请上传商品main_image" >
            <label>商品sub_images</label>
            <input type="text" name="sub_images" class="form-control" placeholder="请上传商品sub_images" >
            <label>商品detail</label>
            <input type="text" name="detail" class="form-control" placeholder="请输入商品detail" >
            <label>商品price</label>
            <input type="text" name="price" class="form-control" placeholder="请输入商品price" >
            <label>商品quantity</label>
            <input type="text" name="quantity" class="form-control" placeholder="请输入商品quantity" >
            <label>商品location</label>
            <input type="text" name="location" class="form-control" placeholder="请输入商品location" >
            <label>商品status</label>
            <input type="text" name="status" class="form-control" placeholder="请输入商品status 1代表上架，2代表下架，3代表揽收，4代表运输，5代表收货" >
            <input type="text" name="creat_time" id="creat_time" value="" style=" display:none">
            <input type="text" name="modify_time" id="modify_time" value="2020-02-01 14:00:00" style=" display:none">
            <script type="text/javascript">


                window.onload = function(){
                    const nowDate = new Date();
                    const time = nowDate.getFullYear() + "-" + (nowDate.getMonth() + 1) + "-" + nowDate.getDate() + ":" + (nowDate.getHours() + ":" + nowDate.getMinutes() + ":" + nowDate.getSeconds())
                    $("#creat_time").val(time);
                    $("#modify_time").val(time)
                }
            </script>
        </div>
        <div class="form-group">
            <input type="submit" class="form-group" value="添加">
        </div>
    </form>
</div>
</body>
</html>
