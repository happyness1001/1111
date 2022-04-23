<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<head>
    <base href="<%=basePath%>">
    <%@include file="../../common/head.jsp" %>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="static/js/echarts.min.js"></script>
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
                        <form class="form-inline" role="search" method="get" action="/bassCalculate/chart">
                            <label class="control-label">商品编号</label>
                            <input type="text" name="id" class="form-control" placeholder="商品编号" value="${id}">
                            <label class="control-label">开始时间</label>
                            <input type="text" class="Wdate form-controls" value="${beginDate}" name="beginDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true});">
                            <label class="control-label">结束时间</label>
                            <input type="text" class="Wdate form-controls" value="${endDate}" name="endDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true});">
                            <button type="submit" class="btn btn-sm btn-success">查询</button>
                            <button type="submit" class="btn btn-sm btn-success" formaction="/bassCalculate/chart?id=${id}&beginDate=${beginDate}&endDate=${endDate}">销量预测</button>
                        </form>
                        <div class="card-body" style="height: 700px; width: 1597px">
                            <div id="main" style="position: relative; width: 800px;height:600px; top: 30px; left: 300px">
                            </div>
                            <div style="position:relative; left:1150px; bottom:200px">
                                <table width="400" height="100px" border="3" style="font-size:20px">
                                    <caption style="padding-bottom: 3px; text-align: center; caption-side: top; font-size: 20px">预测数据</caption>
                                    <tr>
                                        <td align="left">时段(周)</td>
                                        <c:forEach items="${forecastDate}" var="date">
                                            <td align="right">${date}</td>
                                        </c:forEach>
                                    </tr>
                                    <tr>
                                        <td align="left">预测值</td>
                                        <c:forEach items="${forecastList}" var="forecast">
                                            <td align="right">${forecast}</td>
                                        </c:forEach>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <script type="text/javascript">
        var xAxisData = ${xAxis}
        var realList = ${realList}
        var fittingList = ${fittingList}
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'),'dark');
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: 'Bass模型+情感分析拟合曲线'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:['实际累计销量','拟合累计销量']
            },
            xAxis: {
                data: xAxisData
            },
            yAxis: {},
            series: [
                {
                name: '实际累计销量',
                type: 'line',
                data: realList
                },
                {
                name: '拟合累计销量',
                smooth: true,
                type: 'line',
                data: fittingList
                },
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
    </div>
</div>
</body>
</html>