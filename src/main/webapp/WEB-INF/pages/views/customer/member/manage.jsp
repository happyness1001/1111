<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <%@include file="../../../common/head.jsp" %>
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">

    <%@include file="../../../common/header.jsp" %>

    <div class="main-container">

        <%@include file="../../../common/sidebar.jsp" %>

        <div class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header text-white bg-primary">
                            客户会员等级管理
                            <button style="position: relative;left: 800px" type="button" class="btn btn-sm btn-success" onclick="window.location.href='/member/insert'">新增客户等级</button>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>会员等级编号</th>
                                        <th>会员等级</th>
                                        <th>最低积分</th>
                                        <th>最高积分</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${memberList}" var="member">
                                        <tr>
                                            <td>${member.memberId}</td>
                                            <td>${member.memberLevel}</td>
                                            <td>${member.minPoints}</td>
                                            <td>${member.maxPoints}</td>
                                            <td>
                                                <button type="button" class="btn btn-sm btn-success" onclick="window.location.href='/member/get?memberId=${member.memberId}'">更 新</button>
                                                <button type="button" class="btn btn-sm btn-danger" onclick="deleteMember(${member.memberId})">删 除</button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../../../common/message.jsp" %>
<%@include file="../../../common/js.jsp" %>
<script>
    function deleteMember(memberId) {
        $('#deleteModal').modal('show');
        $("#deleteButton").on("click", function () {
            $.ajax({
                type: 'GET',
                url: '/member/delete?memberId=' + memberId,
                dataType: "json",
                success: function (data) {
                    $('#deleteModal').modal('hide');
                    if (data.code == 200) {
                        window.location.reload();
                    } else {
                        $('#modal-danger').modal('show');
                        $('#modal-danger .modal-body').html("失败：状态码：" + data.code + "，" + data.msg);
                    }
                },
                error: function () {
                    $('#deleteModal').modal('hide');
                    $('#modal-danger').modal('show');
                    $('#modal-danger .modal-body').html('请求失败，请检查请求数据或网络哟');
                }
            });
        });
    }
</script>
</body>
</html>
