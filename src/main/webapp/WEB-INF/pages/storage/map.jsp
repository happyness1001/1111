<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>点到线的距离和最近点</title>

    <script src="https://a.amap.com/jsapi_demos/static/demo-center/js/demoutils.js"></script>
    <script src="https://a.amap.com/jsapi_demos/static/demo-center/js/demoutils.js"></script>
    <script
            type="text/javascript"
            src="https://webapi.amap.com/maps?v=1.4.15&key=ce3b1a3a7e67fc75810ce1ba1f83c01a&plugin=AMap.Driving"
    ></script>
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
</head>
<body>
<div id="container"></div>
<div id="panel"></div>
<script type="text/javascript">
    //初始化地图对象，加载地图
    let map = new AMap.Map("container", {
        resizeEnable: true,
        center: [116.397428, 39.90923],
        zoom: 13,
    });
    let driving = new AMap.Driving({
        map: map,
        panel: "panel",
    });
    /* let latlng = []; // 根据起终点经纬度规划驾车路线
     driving.search(
         new AMap.LngLat(116.379028, 39.865042),
         new AMap.LngLat(116.427281, 39.903719),
         function (status, result) {
             for (let i = 0; i < result.routes[0].steps.length; i++) {
                 for (let j = 0; j < result.routes[0].steps[i].path.length; j++) {
                     // console.log(result.routes[0].steps[i].path.length)；
                     // console.log(typeof(result.routes[0].steps[i].path[j].getLng()));
                     // console.log(typeof(result.routes[0].steps[i].path[j].getLng()));
                     // console.log(result.routes[0].steps[i].path[j].getLng());
                     // console.log(result.routes[0].steps[i].path[j].getLat());
                     latlng.push(
                         new AMap.LngLat(
                             result.routes[0].steps[i].path[j].getLng(),
                             result.routes[0].steps[i].path[j].getLat()
                         )
                     );
                 }
             }
             //   console.log("latlng1:" + latlng.length);
             function pathLength() {
                 // await driving.search();
                 //定义折线对象
                 polyline = new AMap.Polyline({
                     path: latlng, //设置折线的节点数组
                     strokeColor: "red",
                     strokeOpacity: 1,
                     strokeWeight: 3,
                     strokeDasharray: [10, 5],
                 });
                 // console.log("latlng3:" + latlng.length);
                 polyline.setMap(map); //地图上添加折线
                 let distance = Math.round(AMap.GeometryUtil.distanceOfLine(latlng));

                 let text = new AMap.Text({
                     position: latlng[latlng.length - 1],
                     text: "路径长" + distance + "米",
                     offset: new AMap.Pixel(-20, -20),
                 });
                 map.add(text);
                 map.setFitView();
             }
             pathLength();
         }
     );
     //   console.log("latlng2:" + latlng.length);*/
</script>
</body>
</html>
