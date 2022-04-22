<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
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
                            需求预测(量)
                        </div>
                        <form class="form-inline" role="search" method="get" action="/bassCalculate/search">
                            <label class="control-label">商品编号</label>
                            <input type="text" name="id" class="form-control" placeholder="商品编号" value="${id}">
                            <label class="control-label">开始时间</label>
                            <input type="text" class="Wdate form-controls" value="${beginDate}" name="beginDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true});">
                            <label class="control-label">结束时间</label>
                            <input type="text" class="Wdate form-controls" value="${endDate}" name="endDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true});">
                            <button type="submit" class="btn btn-sm btn-success" onclick="return searchData()">查询</button>
                            <button type="button" class="btn btn-sm btn-success" onclick="saleForecast()">销量预测</button>
                        </form>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>商品评论
                                    <tr>
                                        <th>客户编号</th>
                                        <th>商品名称</th>
                                        <th style="word-wrap:break-word; width:800px ">评论内容</th>
                                        <th>购买时间</th>
                                        <th>情感分析(积极的概率)</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pageInfo.list}" var="comment">
                                        <tr>
                                            <td>${comment.userId}</td>
                                            <td>${comment.referenceName}</td>
                                            <td>${comment.content}</td>
                                            <td>${comment.boughtTime}</td>
                                            <td>${comment.positiveProbability}%</td>
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
                                                <a href="/bassCalculate/search?pn=1&id=${id}&beginDate=${beginDate}&endDate=${endDate}">首页</a>
                                            </li>
                                            <!-- 如果还有前页就访问当前页码-1的页面， -->
                                            <c:if test="${pageInfo.hasPreviousPage}">
                                                <li class="btn btn-rounded btn-outline-secondary">
                                                    <a href="/bassCalculate/search?pn=${pageInfo.pageNum-1}&id=${id}&beginDate=${beginDate}&endDate=${endDate}" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果相等就普通显示  -->
                                            <c:forEach items="${pageInfo.navigatepageNums}" var="page_Nums">
                                                <c:if test="${page_Nums==pageInfo.pageNum }">
                                                    <a class="btn btn-rounded btn-outline-secondary active" href="/bassCalculate/search?pn=${page_Nums}&id=${id}&beginDate=${beginDate}&endDate=${endDate}">${page_Nums}</a>
                                                </c:if>
                                                <c:if test="${page_Nums!=pageInfo.pageNum }">
                                                    <a class="btn btn-rounded btn-outline-secondary" href="/bassCalculate/search?pn=${page_Nums}&id=${id}&beginDate=${beginDate}&endDate=${endDate}">${page_Nums}</a>
                                                </c:if>
                                            </c:forEach>
                                            <!-- 如果还有后页就访问当前页码+1的页面， -->
                                            <c:if test="${pageInfo.hasNextPage}">
                                                <li class="btn btn-rounded btn-outline-secondary">
                                                    <a href="/bassCalculate/search?pn=${pageInfo.pageNum+1}&id=${id}&beginDate=${beginDate}&endDate=${endDate}" aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <li class="btn btn-rounded btn-outline-secondary">
                                                <a href="/bassCalculate/search?pn=${pageInfo.pages}&id=${id}&beginDate=${beginDate}&endDate=${endDate}">末页</a>
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
    function saleForecast() {
        var id = $("input[name='id']").val();
        var beginDate = $("input[name='beginDate']").val();
        var endDate = $("input[name='endDate']").val();
        var beginDateFormat = new Date(beginDate);
        var endDateFormat = new Date(endDate);
        if (id == null || id.length == 0) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('商品编号不能为空');
            return;
        }
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
        if (beginDateFormat.getTime() >= endDateFormat.getTime()) {
            $('#modal-danger').modal('show');
            $('#modal-danger .modal-body').html('开始时间大于等于结束时间,请重新输入');
            return;
        }
        window.location.href = '/bassCalculate/chart?id='+id+'&beginDate='+beginDate+'&endDate='+endDate;
    }
</script>
</body>
</html>