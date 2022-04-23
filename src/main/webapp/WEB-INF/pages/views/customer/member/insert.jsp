<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<head>
    <base href="<%=basePath%>">
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
                            新增会员等级
                        </div>

                        <div class="card-body">

                            <label>会员等级:</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-user"></i></span>
                                </div>
                                <input type="text" name="memberLevel" class="form-control" placeholder="请输入会员等级">
                            </div>

                            <label>最低积分:</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-envelope"></i></span>
                                </div>
                                <input type="text" name="minPoints" class="form-control" placeholder="请输入最低积分">
                            </div>

                            <label>最高积分:</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-phone"></i></span>
                                </div>
                                <input type="text" name="maxPoints" class="form-control" placeholder="请输入最高积分">
                            </div>
                            <button type="button" class="btn btn-block btn-info" onclick="insertCustomerMember()">新增客户等级</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function insertCustomerMember() {
        var memberLevel = $("input[name='memberLevel']").val();
        var minPoints = $("input[name='minPoints']").val();
        var maxPoints = $("input[name='maxPoints']").val();

        if (memberLevel == null || memberLevel.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('会员等级不能为空');
            return;
        }
        if (minPoints == null || minPoints.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('最小积分不能为空');
            return;
        }
        if (maxPoints == null || maxPoints.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('最大积分不能为空');
            return;
        }

        $.ajax({
            type: 'POST',
            url: "/member/insert",
            data: {
                memberLevel: memberLevel,
                minPoints: minPoints,
                maxPoints: maxPoints,
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
