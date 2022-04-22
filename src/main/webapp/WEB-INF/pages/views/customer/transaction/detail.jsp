<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <%@include file="../../../common/head.jsp" %>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="/static/js/echarts.min.js"></script>
</head>
<body class="sidebar-fixed header-fixed">
<div class="main-container">
    <%@include file="../../../common/header.jsp" %>
    <div class="main-container">
    <%@include file="../../../common/sidebar.jsp" %>
        <div class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header text-white bg-primary">
                            客户近期交易数量
                        </div>
                        <div class="card-body" style="height: 700px; width: 1597px">
                            <div id="main" style="position: relative; width: 800px;height:600px; top: 30px; left: 300px">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <script type="text/javascript">
        var xAxisData = ${xAxis}
        var realList = ${realList}
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'),'dark');
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '客户近期交易数量'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:['实际交易量']
            },
            xAxis: {
                data: xAxisData
            },
            yAxis: {},
            series: [
                {
                name: '实际交易量',
                type: 'line',
                data: realList
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