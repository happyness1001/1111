<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <%@include file="../../common/head.jsp" %>
    <%@include file="../../common/message.jsp" %>
    <%@include file="../../common/js.jsp" %>
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <%@include file="../../common/header.jsp" %>

    <div class="main-container">

        <%@include file="../../common/sidebar.jsp" %>

        <div class="content">
            <div class="row">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header text-white bg-primary">
                            新增客户
                        </div>

                        <div class="card-body">

                            <label>客户姓名:</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-user"></i></span>
                                </div>
                                <input type="text" name="name" class="form-control" placeholder="请输入姓名">
                            </div>

                            <label>客户邮箱:</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-envelope"></i></span>
                                </div>
                                <input type="email" name="email" class="form-control" placeholder="请输入邮箱">
                            </div>

                            <label>联系电话:</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-phone"></i></span>
                                </div>
                                <input type="text" name="phone" class="form-control" placeholder="请输入电话">
                            </div>

                            <label>地址:</label>
                            <div data-toggle="distpicker">
                                <select id="province"></select>
                                <select id="city"></select>
                                <select id="district"></select>
                            </div>
                            <label>详细地址:</label>
                            <div class="input-group mb-3">
                                <textarea id="textarea" name="address" class="form-control" rows="6" placeholder="请输入详细地址"></textarea>
                            </div>

                            <button type="button" class="btn btn-block btn-info" onclick="insertCustomer()">新增客户</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function insertCustomer() {
        var customerName = $("input[name='name']").val();
        var customerEmail = $("input[name='email']").val();
        var customerPhone = $("input[name='phone']").val();
        var province = $("#province").find("option:selected").text();
        var city = $("#city").find("option:selected").text();
        var district = $("#district").find("option:selected").text();
        var customerAddress = province + " " + city + " "  + district + " "  + $("#textarea").val();

        if (customerName == null || customerName.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('客户姓名不能为空');
            return;
        }
        if (customerEmail == null || customerEmail.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('客户邮箱不能为空');
            return;
        }
        if (customerPhone == null || customerPhone.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('客户联系电话不能为空');
            return;
        }
        if (customerAddress == null || customerAddress.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('客户详细地址不能为空');
            return;
        }

        $.ajax({
            type: 'POST',
            url: "/customer/insert",
            data: {
                customerName: customerName,
                customerEmail: customerEmail,
                customerPhone: customerPhone,
                customerAddress: customerAddress
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
