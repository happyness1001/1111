<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <%@include file="../../common/head.jsp" %>
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
                            新增文本
                        </div>

                        <div class="card-body">
                            <label>文本内容</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-envelope"></i></span>
                                </div>
                                <input type="text" name="text" class="form-control" placeholder="文本内容">
                            </div>

                            <label>文本极性</label>
                            <div class="input-group mb-3" style="width: 200px">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-envelope"></i></span>
                                </div>
                                    <input type="radio" name="textCategory" class="form-control"  value="正面" checked>正面
                                    <input type="radio" name="textCategory" class="form-control"  value="负面" >负面
                            </div>
                            <button type="button" class="btn btn-block btn-info" onclick="insertText()">新增文本</button>
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
    function insertText() {
        var textId = $("input[name='textId']").val();
        var text = $("input[name='text']").val();
        var textCategory = $("input[name='textCategory']:checked").val();

        if (text == null || text.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('文本内容不能为空');
            return;
        }
        $.ajax({
            type: 'POST',
            url: "/sentimentAnalysis/insert",
            data: {
                textId: textId,
                text: text,
                textCategory: textCategory,
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
