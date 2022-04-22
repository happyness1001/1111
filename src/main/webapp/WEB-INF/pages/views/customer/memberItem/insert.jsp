<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <%@include file="../../../common/head.jsp" %>
    <%@include file="../../../common/message.jsp" %>
    <%@include file="../../../common/js.jsp" %>
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <%@include file="../../../common/header.jsp" %>

    <div class="main-container">

        <%@include file="../../../common/sidebar.jsp" %>

        <div class="content">
            <div class="row">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header text-white bg-primary">
                            新增会员商品
                        </div>

                        <div class="card-body">

                            <label>商品编号:</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-user"></i></span>
                                </div>
                                <input type="text" name="itemNumber" class="form-control" placeholder="请输入会员商品编号">
                            </div>
                            <label>商品名称:</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-user"></i></span>
                                </div>
                                <input type="text" name="itemName" class="form-control" placeholder="请输入会员商品名称">
                            </div>
                            <label>会员等级:</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-envelope"></i></span>
                                </div>
                                <input type="text" name="memberLevel" class="form-control" placeholder="请输入会员等级">
                            </div>
                            <label>会员价格:</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-phone"></i></span>
                                </div>
                                <input type="text" name="memberPrice" class="form-control" placeholder="请输入会员价格">
                            </div>
                            <button type="button" class="btn btn-block btn-info" onclick="insertMemberItem()">新增客户等级</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function insertMemberItem() {
        var itemNumber = $("input[name='itemNumber']").val();
        var itemName = $("input[name='itemName']").val();
        var memberLevel = $("input[name='memberLevel']").val();
        var memberPrice = $("input[name='memberPrice']").val();

        if (itemNumber == null || itemNumber.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('会员编号不能为空');
            return;
        }
        if (itemName == null || itemName.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('会员名称不能为空');
            return;
        }
        if (memberLevel == null || memberLevel.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('会员等级不能为空');
            return;
        }
        if (memberPrice == null || memberPrice.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('会员价格不能为空');
            return;
        }

        $.ajax({
            type: 'POST',
            url: "/memberItem/insert",
            data: {
                itemNumber: itemNumber,
                itemName: itemName,
                memberLevel: memberLevel,
                memberPrice: memberPrice,
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
