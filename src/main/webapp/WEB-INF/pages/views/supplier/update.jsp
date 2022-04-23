<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<head>
    <base href="<%=basePath%>">
    <%@include file="../../common/head.jsp" %>
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">

    <%@include file="../../common/header.jsp" %>

    <div class="main-container">

        <%@include file="../../common/sidebar.jsp" %>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6">
                        <div class="card">
                            <div class="card-header text-white bg-primary">
                                更新供货记录
                            </div>

                            <div class="card-body">
                                <label>供货编号</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="fa fa-user"></i></span>
                                    </div>
                                    <input type="text" name="recordId" class="form-control" readonly value="${supplyRecord.recordId}">
                                </div>

                                <label>供货商名称</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="fa fa-user"></i></span>
                                    </div>
                                    <input type="text" name="supplierName" class="form-control" placeholder="供货商名称" value="${supplyRecord.supplierName}">
                                </div>

                                <label>供货商电话</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="fa fa-envelope"></i></span>
                                    </div>
                                    <input type="text" name="supplierPhone" class="form-control" placeholder="供货商电话" value="${supplyRecord.supplierPhone}">
                                </div>

                                <label>供货类别</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="fa fa-phone"></i></span>
                                    </div>
                                    <input type="text" name="supplyCategory" class="form-control" placeholder="供货类别" value="${supplyRecord.supplyCategory}">
                                </div>
                                <label>质量</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="fa fa-phone"></i></span>
                                    </div>
                                    <input type="text" name="quality" class="form-control" placeholder="质量" value="${supplyRecord.quality}">
                                </div>
                                <label>价格</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="fa fa-phone"></i></span>
                                    </div>
                                    <input type="text" name="price" class="form-control" placeholder="价格" value="${supplyRecord.price}">
                                </div>
                                <label>数量</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="fa fa-phone"></i></span>
                                    </div>
                                    <input type="text" name="quantity" class="form-control" placeholder="数量" value="${supplyRecord.quantity}">
                                </div>
                                <button type="button" class="btn btn-block btn-info" onclick="updateMemberItem()">更新供货记录</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../../common/message.jsp" %>
<%@include file="../../common/js.jsp" %>
<script>
    function updateMemberItem() {
        var recordId = $("input[name='recordId']").val();
        var supplierName = $("input[name='supplierName']").val();
        var supplierPhone = $("input[name='supplierPhone']").val();
        var supplyCategory = $("input[name='supplyCategory']").val();
        var quality = $("input[name='quality']").val();
        var price = $("input[name='price']").val();
        var quantity = $("input[name='quantity']").val();

        if (supplierName == null || supplierName.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('供货商名称不能为空');
            return;
        }
        if (supplierPhone == null || supplierPhone.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('供货商电话不能为空');
            return;
        }
        if (supplyCategory == null || supplyCategory.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('供货类别不能为空');
            return;
        }
        if (quality == null || quality.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('供货质量评级不能为空');
            return;
        }
        if (price == null || price.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('供货价格评级不能为空');
            return;
        }
        if (quantity == null || quantity.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('供货数量评级不能为空');
            return;
        }

        $.ajax({
            type: 'POST',
            url: "/supplier/update",
            data: {
                recordId: recordId,
                supplierName: supplierName,
                supplierPhone: supplierPhone,
                supplyCategory: supplyCategory,
                quality: quality,
                price: price,
                quantity: quantity,
            },
            dataType: "json",
            success: function(result) {
                if (result.code == 200) {
                    $('#modal-success').modal('show');
                    $('#modal-success .modal-body').html(result.msg);
                    $("#successBtn").on("click", function () {
                        window.location.reload();
                    });
                } else {
                    $('#modal-danger').modal('show');
                    $('#modal-danger .modal-body').html("失败：状态码：" + result.code + "，" + result.msg);
                }
            },
            error: function () {
                $('#modal-danger').modal('show');
                $('#modal-danger .modal-body').html('请求失败，请检查请求数据或网络哟');
            }
        });
    }
</script>
</body>
</html>
