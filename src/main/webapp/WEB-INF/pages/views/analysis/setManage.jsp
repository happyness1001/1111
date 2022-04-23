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
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header text-white bg-primary">
                            训练集管理
                            <button type="button" class="btn btn-sm btn-success" onclick="trainModel()" style="position:relative; left:1350px; width:100px; height:30px">训练模型</button>
                        </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>文本编号</th>
                                        <th style="word-wrap:break-word; width:1200px">文本内容</th>
                                        <th>文本极性</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pageInfo.list}" var="sentimentAnalysis">
                                        <tr>
                                            <td>${sentimentAnalysis.textId}</td>
                                            <td>${sentimentAnalysis.text}</td>
                                            <td>${sentimentAnalysis.textCategory}</td>
                                            <td>
                                                <button type="button" class="btn btn-sm btn-success" onclick="window.location.href='/sentimentAnalysis/get?textId=${sentimentAnalysis.textId}'">更 新</button>
                                                <button type="button" class="btn btn-sm btn-danger" onclick="deleteText(${sentimentAnalysis.textId})">删 除</button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <!-- 提示分页信息行 -->
                            <div class="row">
                                <!-- 分页码 -->
                                <div class="col-md-12">
                                    <nav aria-label="Page navigation">
                                        <ul class="pagination">
                                            <li class="btn btn-rounded btn-outline-secondary">
                                                <a href="/sentimentAnalysis/list">首页</a>
                                            </li>
                                            <!-- 如果还有前页就访问当前页码-1的页面， -->
                                            <c:if test="${pageInfo.hasPreviousPage}">
                                                <li class="btn btn-rounded btn-outline-secondary">
                                                    <a href="/sentimentAnalysis/list?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果相等就普通显示  -->
                                            <c:forEach items="${pageInfo.navigatepageNums }" var="page_Nums">
                                                <c:if test="${page_Nums==pageInfo.pageNum }">
                                                    <a class="btn btn-rounded btn-outline-secondary active" href="/sentimentAnalysis/list?pn=${page_Nums}">${page_Nums}</a>
                                                </c:if>
                                                <c:if test="${page_Nums!=pageInfo.pageNum }">
                                                    <a class="btn btn-rounded btn-outline-secondary" href="/sentimentAnalysis/list?pn=${page_Nums}">${page_Nums}</a>
                                                </c:if>
                                            </c:forEach>
                                            <!-- 如果还有后页就访问当前页码+1的页面， -->
                                            <c:if test="${pageInfo.hasNextPage}">
                                                <li class="btn btn-rounded btn-outline-secondary">
                                                    <a href="/sentimentAnalysis/list?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <li class="btn btn-rounded btn-outline-secondary">
                                                <a href="/sentimentAnalysis/list?pn=${pageInfo.pages}">末页</a>
                                            </li>
                                        </ul>
                                    </nav>
                                    <p>当前第：${pageInfo.pageNum} 页，共 ${pageInfo.pages } 页，总共 ${pageInfo.total } 条记录</p>
                                </div>
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
    function deleteText(id) {
        $('#deleteModal').modal('show');
        $("#deleteButton").on("click", function () {
            $.ajax({
                type: 'GET',
                url: '/sentimentAnalysis/delete?id=' + id,
                dataType: "json",
                success: function (data) {
                    $('#deleteModal').modal('hide');
                    if (data.code == 200) {
                        $('#modal-success').modal('show');
                        $('#modal-success .modal-body').html(data.msg);
                        $("#successBtn").on("click", function () {
                            window.location.reload();
                        });
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
    function trainModel() {
        window.location.href="/sentimentAnalysis/train"
        alert("模型训练成功")
        window.location.href="/sentimentAnalysis/list"
    }
</script>
</body>
</html>
