<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<head>
    <base href="<%=basePath%>">
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
                            客户流失管理
                        </div>
                        <form class="form-inline" role="search" method="get" action="/customerTransaction/search">
                            <label class="control-label">开始时间</label>
                            <input type="text" class="Wdate form-controls" value="${beginDate}" name="beginDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true});">
                            <label class="control-label">结束时间</label>
                            <input type="text" class="Wdate form-controls" value="${endDate}" name="endDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true});">
                            <button type="submit" class="btn btn-sm btn-success" onclick="return searchData()">查询</button>
                        </form>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>客户编号</th>
                                        <th>客户姓名</th>
                                        <th>客户邮箱</th>
                                        <th>客户电话</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pageInfo.list}" var="customer">
                                        <tr>
                                            <td>${customer.customerId}</td>
                                            <td>${customer.customerName}</td>
                                            <td>${customer.customerEmail}</td>
                                            <td>${customer.customerPhone}</td>
                                            <td>
                                                <button type="button" class="btn btn-sm btn-success" onclick="detailTransaction(${customer.customerId}, ${customer.frequency})">交易详情</button>
                                                <button type="button" class="btn btn-sm btn-danger" onclick="window.location.href='/customerTransaction/record/search?customerId=${customer.customerId}'">回访记录</button>
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
                                                <a href="/customerTransaction/search?pn=1&beginDate=${beginDate}&endDate=${endDate}">首页</a>
                                            </li>
                                            <!-- 如果还有前页就访问当前页码-1的页面， -->
                                            <c:if test="${pageInfo.hasPreviousPage}">
                                                <li class="btn btn-rounded btn-outline-secondary">
                                                    <a href="/customerTransaction/search?pn=${pageInfo.pageNum-1}&beginDate=${beginDate}&endDate=${endDate}" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果相等就普通显示  -->
                                            <c:forEach items="${pageInfo.navigatepageNums}" var="page_Nums">
                                                <c:if test="${page_Nums==pageInfo.pageNum }">
                                                    <a class="btn btn-rounded btn-outline-secondary active" href="/customerTransaction/search?pn=${page_Nums}&beginDate=${beginDate}&endDate=${endDate}">${page_Nums}</a>
                                                </c:if>
                                                <c:if test="${page_Nums!=pageInfo.pageNum }">
                                                    <a class="btn btn-rounded btn-outline-secondary" href="/customerTransaction/search?pn=${page_Nums}&beginDate=${beginDate}&endDate=${endDate}">${page_Nums}</a>
                                                </c:if>
                                            </c:forEach>
                                            <!-- 如果还有后页就访问当前页码+1的页面， -->
                                            <c:if test="${pageInfo.hasNextPage}">
                                                <li class="btn btn-rounded btn-outline-secondary">
                                                    <a href="/customerTransaction/search?pn=${pageInfo.pageNum+1}&beginDate=${beginDate}&endDate=${endDate}" aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <li class="btn btn-rounded btn-outline-secondary">
                                                <a href="/customerTransaction/search?pn=${pageInfo.pages}&beginDate=${beginDate}&endDate=${endDate}">末页</a>
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
<%@include file="../../../common/message.jsp" %>
<%@include file="../../../common/js.jsp" %>
<script>
    function searchData() {
        var beginDate = $("input[name='beginDate']").val();
        var endDate = $("input[name='endDate']").val();
        var beginDateFormat = new Date(beginDate);
        var endDateFormat = new Date(endDate);
        if (beginDateFormat.getTime() >= endDateFormat.getTime()) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('开始时间大于等于结束时间,请重新输入');
            return false;
        }
    }

</script>
<script  type="text/javascript">
    function detailTransaction(var1,var2) {
        var beginDate = $("input[name='beginDate']").val();
        var endDate = $("input[name='endDate']").val();
        var customerId = var1;
        var frequency = var2;
        if (frequency == "0.0" || frequency.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('该用户无交易记录');
            return;
        }
        window.location.href='/customerTransaction/get?customerId='+customerId+'&beginDate='+beginDate+'&endDate='+endDate;
    }
</script>
</body>
</html>
