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
<div class="main-container">

    <%@include file="../../common/header.jsp" %>

    <div class="main-container">

        <%@include file="../../common/sidebar.jsp" %>

        <div class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header text-white bg-primary">
                            供货商推荐
                        </div>
                        <div class="form-inline">
                            <label class="control-label">进货商品类别编号: </label>
                            <input type="text" name="category" class="form-control" placeholder="进货商品类别编号" id="category" value="${category}" list="category_list" autocomplete="off">
                            <button type="button" class="btn btn-sm btn-success" onclick="supplierRecommendation()">供货商推荐</button>
                            <datalist id="category_list"/>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>商品评论
                                    <tr>
                                        <th>供货编号</th>
                                        <th>供货商名称</th>
                                        <th>供货商电话</th>
                                        <th>供货种类</th>
                                        <th>质量评级</th>
                                        <th>价格评级</th>
                                        <th>数量评级</th>
                                        <th>综合评级</th>
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
                                            <td>${supplyRecord.total}</td>
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
                                                <a href="/supplier/search?category=${category}">首页</a>
                                            </li>
                                            <!-- 如果还有前页就访问当前页码-1的页面， -->
                                            <c:if test="${pageInfo.hasPreviousPage}">
                                                <li class="btn btn-rounded btn-outline-secondary">
                                                    <a href="/supplier/search?pn=${pageInfo.pageNum-1}&category=${category}" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果相等就普通显示  -->
                                            <c:forEach items="${pageInfo.navigatepageNums }" var="page_Nums">
                                                <c:if test="${page_Nums==pageInfo.pageNum }">
                                                    <a class="btn btn-rounded btn-outline-secondary active" href="/supplier/search?pn=${page_Nums}&category=${category}">${page_Nums}</a>
                                                </c:if>
                                                <c:if test="${page_Nums!=pageInfo.pageNum }">
                                                    <a class="btn btn-rounded btn-outline-secondary" href="/supplier/search?pn=${page_Nums}&category=${category}">${page_Nums}</a>
                                                </c:if>
                                            </c:forEach>
                                            <!-- 如果还有后页就访问当前页码+1的页面， -->
                                            <c:if test="${pageInfo.hasNextPage}">
                                                <li class="btn btn-rounded btn-outline-secondary">
                                                    <a href="/supplier/search?pn=${pageInfo.pageNum+1}&category=${category}" aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <li class="btn btn-rounded btn-outline-secondary">
                                                <a href="/supplier/search?pn=${pageInfo.pages}&category=${category}">末页</a>
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
    $('input#category').bind('keyup', function () {
        var category = $('input#category').val();
        $.ajax({
            type: "POST",
            url: '/supplier/recommend',
            data: {category: category},
            dataType: 'json',
            async: false,
            success: function (arg) {
            $('datalist#category_list').empty();
                for (var i = 0; i < (arg.length > 10 ? 10 : arg.length); i++) {
                    var add_options = '<option value="' + arg[i] + '">'+ arg[i] + '</option>';
                    $('datalist#category_list').append(add_options);
                }
            }
        })
    });
    function supplierRecommendation() {
        var category = $("input[name='category']").val();
        if (category == null || category.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('商品类别不能为空');
            return;
        }
        window.location.href = '/supplier/search?category='+category;
    }
</script>
</body>
</html>