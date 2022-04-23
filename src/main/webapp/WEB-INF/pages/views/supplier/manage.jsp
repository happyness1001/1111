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
                            供货商供货记录管理
                            <button style="position: relative;left: 800px" type="button" class="btn btn-sm btn-success" onclick="window.location.href='/supplier/insert'">新增供货记录</button>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>供货编号</th>
                                        <th>供货商名称</th>
                                        <th>供货商电话</th>
                                        <th>供货种类编号</th>
                                        <th>质量评级</th>
                                        <th>价格评级</th>
                                        <th>数量评级</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pageInfo.list}" var="supplyRecord">
                                        <tr>
                                            <td>${supplyRecord.recordId}</td>
                                            <td>${supplyRecord.supplierName}</td>
                                            <td>${supplyRecord.supplierPhone}</td>
                                            <td>${supplyRecord.supplyCategory}</td>
                                            <td>${supplyRecord.quality}</td>
                                            <td>${supplyRecord.price}</td>
                                            <td>${supplyRecord.quantity}</td>
                                            <td>
                                                <button type="button" class="btn btn-sm btn-success" onclick="window.location.href='/supplier/get?recordId=${supplyRecord.recordId}'">更 新</button>
                                                <button type="button" class="btn btn-sm btn-danger" onclick="deleteSupplyRecord(${supplyRecord.recordId})">删 除</button>
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
                                                <a href="/supplier/list">首页</a>
                                            </li>
                                            <!-- 如果还有前页就访问当前页码-1的页面， -->
                                            <c:if test="${pageInfo.hasPreviousPage}">
                                                <li class="btn btn-rounded btn-outline-secondary">
                                                    <a href="/supplier/list?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果相等就普通显示  -->
                                            <c:forEach items="${pageInfo.navigatepageNums }" var="page_Nums">
                                                <c:if test="${page_Nums==pageInfo.pageNum }">
                                                    <a class="btn btn-rounded btn-outline-secondary active" href="/supplier/list?pn=${page_Nums}">${page_Nums}</a>
                                                </c:if>
                                                <c:if test="${page_Nums!=pageInfo.pageNum }">
                                                    <a class="btn btn-rounded btn-outline-secondary" href="/supplier/list?pn=${page_Nums}">${page_Nums}</a>
                                                </c:if>
                                            </c:forEach>
                                            <!-- 如果还有后页就访问当前页码+1的页面， -->
                                            <c:if test="${pageInfo.hasNextPage}">
                                                <li class="btn btn-rounded btn-outline-secondary">
                                                    <a href="/supplier/list?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <li class="btn btn-rounded btn-outline-secondary">
                                                <a href="/supplier/list?pn=${pageInfo.pages}">末页</a>
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
    function deleteSupplyRecord(recordId) {
        $('#deleteModal').modal('show');
        $("#deleteButton").on("click", function () {
            $.ajax({
                type: 'GET',
                url: '/supplier/delete?recordId='+recordId,
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
