<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html>
<head>
    <title>路线方案</title>
    <style>
        html,
        body,
        #container {
            width: 100%;
            height: 100%;
        }

        #panel {
            position: fixed;
            background-color: white;
            max-height: 90%;
            overflow-y: auto;
            top: 10px;
            right: 10px;
            width: 280px;
        }

        #panel .amap-lib-driving {
            border-radius: 4px;
            overflow: hidden;
        }
    </style>
    <script type="text/javascript" src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <link rel="stylesheet" href="https://a.amap.com/jsapi_demos/static/demo-center/css/demo-center.css"/>
    <script src="https://a.amap.com/jsapi_demos/static/demo-center/js/demoutils.js"></script>
    <script type="text/javascript"
            src="https://webapi.amap.com/maps?v=2.0&key=ce3b1a3a7e67fc75810ce1ba1f83c01a&plugin=AMap.Driving,AMap.Geocoder"></script>
</head>
<body>


<h2><span id="route">${route}</span></h2><a href="${pageContext.request.contextPath}/order/map">返回</a>
<div id="container"></div>
<div id="panel"></div>
<script type="text/javascript">

    //基本地图加载
    var map = new AMap.Map("container", {
        resizeEnable: true,
        center: [116.397428, 39.90923],//地图中心点
        zoom: 13 //地图显示的缩放级别
    });
    //构造路线导航类
    var driving = new AMap.Driving({
        map: map,
        panel: "panel"
    });
    let routes = document.getElementById("route").innerText;
    let route = routes.split(" ");
    route.push(route[0]);
    for (let i = 0; i < route.length; i++) {
        route[i] = "{keyword:'" + route[i] + "'}";
        route[i] = eval("(" + route[i] + ")");
    }
    console.log(route);
    // 根据起终点经纬度规划驾车导航路线
    driving.search(route, function (status, result) {
            if (status === 'complete') {
                log.success('绘制驾车路线完成')
            } else {
                log.error('获取驾车数据失败：' + result)
            }
        }
    );


</script>
</body>
</html>



