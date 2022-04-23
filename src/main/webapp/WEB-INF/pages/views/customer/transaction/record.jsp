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
                            回访记录
                        </div>
                        <div class="card-body">
                            <label>客户编号</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-user"></i></span>
                                </div>
                                <input type="text" name="customerId" class="form-control" readonly value="${customerId}">
                            </div>
                            <label>回访记录</label>
                            <div class="input-group mb-3">
                                <textarea id="textarea" name="record" class="form-control" rows="6" placeholder="请输入记录内容"></textarea>
                            </div>
                            <script>
                                document.getElementById("textarea").value="${record}"
                            </script>
                            <button type="button" class="btn btn-block btn-info" onclick="updateRecord()">更新记录</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function updateRecord() {
        var customerId = $("input[name='customerId']").val();
        var record = $("#textarea").val();
        if (record == null || record.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('更新记录不能为空');
            return;
        }
        $.ajax({
            type: 'POST',
            url: "/customerTransaction/record/update",
            data: {
                customerId:customerId,
                record:record
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
