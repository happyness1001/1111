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
                            关联规则挖掘结果
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>关联规则详情
                                    <tr>
                                        <th>前置商品编号</th>
                                        <th>商品名称</th>
                                        <th>后置商品编号</th>
                                        <th>商品名称</th>
                                        <th>置信度</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pageInfo.list}" var="association">
                                        <tr>
                                            <td>${association.preItemNumber}</td>
                                            <td>${association.preItemName}</td>
                                            <td>${association.postItemNumber}</td>
                                            <td>${association.postItemName}</td>
                                            <td>${association.confidence}</td>
                                            <td>
                                                <button type="button" class="btn btn-sm btn-success" onclick="
                                                        window.location.href='/AssociationAnalysis/insert?preItemNumber=${association.preItemNumber}&preItemName=${association.preItemName}&postItemNumber=${association.postItemNumber}&postItemName=${association.postItemName}&confidence=${association.confidence}'">
                                                    添 加</button>
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
                                                <a href="/AssociationAnalysis/search?pn=1">首页</a>
                                            </li>
                                            <!-- 如果还有前页就访问当前页码-1的页面， -->
                                            <c:if test="${pageInfo.hasPreviousPage}">
                                                <li class="btn btn-rounded btn-outline-secondary">
                                                    <a href="/AssociationAnalysis/search?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果相等就普通显示  -->
                                            <c:forEach items="${pageInfo.navigatepageNums}" var="page_Nums">
                                                <c:if test="${page_Nums==pageInfo.pageNum }">
                                                    <a class="btn btn-rounded btn-outline-secondary active" href="/AssociationAnalysis/search?pn=${page_Nums}">${page_Nums}</a>
                                                </c:if>
                                                <c:if test="${page_Nums!=pageInfo.pageNum }">
                                                    <a class="btn btn-rounded btn-outline-secondary" href="/AssociationAnalysis/search?pn=${page_Nums}">${page_Nums}</a>
                                                </c:if>
                                            </c:forEach>
                                            <!-- 如果还有后页就访问当前页码+1的页面， -->
                                            <c:if test="${pageInfo.hasNextPage}">
                                                <li class="btn btn-rounded btn-outline-secondary">
                                                    <a href="/AssociationAnalysis/search?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <li class="btn btn-rounded btn-outline-secondary">
                                                <a href="/AssociationAnalysis/search?pn=${pageInfo.pages}">末页</a>
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
</body>
</html>