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
                            关联分析
                        </div>
                        <form class="form-inline" role="search" method="get" action="/AssociationAnalysis/search">
                            <label class="control-label">开始时间:</label>
                            <input type="text" class="Wdate form-controls" name="beginDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true});">
                            <label class="control-label">结束时间:</label>
                            <input type="text" class="Wdate form-controls" name="endDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true});">
                            <label class="control-label">筛选级别:</label>
                            <select id="level">
                                <option value ="2">2级</option>
                                <option value ="3">3级</option>
                                <option value="4">4级</option>
                            </select>
                            <label class="control-label">最小支持度:</label>
                            <input type="text" name="support" class="form-control" placeholder="最小支持度">
                            <label class="control-label">最小置信度:</label>
                            <input type="text" name="confidence" class="form-control" placeholder="最小置信度">
                            <button type="button" class="btn btn-sm btn-success" onclick="associationAnalysis()">关联挖掘</button>
                        </form>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>交易详情
                                    <tr>
                                        <th>交易编号</th>
                                        <th>交易时间</th>
                                        <th>商品编号</th>
                                        <th>商品名称</th>
                                        <th>消费金额</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pageInfo.list}" var="transaction">
                                        <tr>
                                            <td>${transaction.transactionId}</td>
                                            <td>${transaction.transactionDate}</td>
                                            <td>${transaction.itemNumber}</td>
                                            <td>${transaction.itemName}</td>
                                            <td>${transaction.money}</td>
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
                                                <a href="/AssociationAnalysis/list?pn=1">首页</a>
                                            </li>
                                            <!-- 如果还有前页就访问当前页码-1的页面， -->
                                            <c:if test="${pageInfo.hasPreviousPage}">
                                                <li class="btn btn-rounded btn-outline-secondary">
                                                    <a href="/AssociationAnalysis/list?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果相等就普通显示  -->
                                            <c:forEach items="${pageInfo.navigatepageNums}" var="page_Nums">
                                                <c:if test="${page_Nums==pageInfo.pageNum }">
                                                    <a class="btn btn-rounded btn-outline-secondary active" href="/AssociationAnalysis/list?pn=${page_Nums}">${page_Nums}</a>
                                                </c:if>
                                                <c:if test="${page_Nums!=pageInfo.pageNum }">
                                                    <a class="btn btn-rounded btn-outline-secondary" href="/AssociationAnalysis/list?pn=${page_Nums}">${page_Nums}</a>
                                                </c:if>
                                            </c:forEach>
                                            <!-- 如果还有后页就访问当前页码+1的页面， -->
                                            <c:if test="${pageInfo.hasNextPage}">
                                                <li class="btn btn-rounded btn-outline-secondary">
                                                    <a href="/AssociationAnalysis/list?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <li class="btn btn-rounded btn-outline-secondary">
                                                <a href="/AssociationAnalysis/list?pn=${pageInfo.pages}">末页</a>
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
    function associationAnalysis() {
        var beginDate = $("input[name='beginDate']").val();
        var endDate = $("input[name='endDate']").val();
        var level = $("#level").find("option:selected").val();
        var support = $("input[name='support']").val();
        var confidence = $("input[name='confidence']").val();
        var beginDateFormat = new Date(beginDate);
        var endDateFormat = new Date(endDate);
        if (beginDate == null || beginDate.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('开始时间不能为空');
            return;
        }
        if (endDate == null || endDate.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('结束时间不能为空');
            return;
        }
        if (support == null || support.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('最小支持度不能为空');
            return;
        }
        if (confidence == null || confidence.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('最小置信度不能为空');
            return;
        }
        if (beginDateFormat.getTime() >= endDateFormat.getTime()) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('开始时间大于等于结束时间,请重新输入');
            return;
        }
        window.location.href = '/AssociationAnalysis/search?level='+level+'&beginDate='+beginDate+'&endDate='+endDate+'&support='+support+'&confidence='+confidence;
    }
</script>
</body>
</html>