<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>添加收货地点</title>
    <link
            rel="stylesheet"
            href="https://a.amap.com/jsapi_demos/static/demo-center/css/demo-center.css"
    />
    <style>
        html,
        body,
        #container {
            height: 100%;
            width: 100%;
        }

        .btn {
            width: 10rem;
            margin-left: 6.8rem;
        }

    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="ajax方式">
    <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <%--    <script src="${ctx}/webjars/jquery/3.6.0/jquery.min.js"></script>--%>


</head>
<body>
<form id="lnglat">

</form>

<script
        type="text/javascript"
        src="https://webapi.amap.com/maps?v=1.4.15&key=ce3b1a3a7e67fc75810ce1ba1f83c01a&plugin=AMap.Geocoder"
></script>
<script type="text/javascript">

    var map = new AMap.Map("container", {
        resizeEnable: true,
    });
    let lnglats = [];
    var geocoder = new AMap.Geocoder({});
    var marker = new AMap.Marker();

    function geoCode() {
        geocoder.getLocation(address, function (status, result) {
            if (status === "complete" && result.geocodes.length) {
                ${distance_name}.
                location_name1
                var lnglat = result.geocodes[0].location;

                let status = 1;
                for (let i = 0; i < lnglats.length; i++) {
                    const element = lnglats[i];
                    // console.log(element);
                    if (element.lng === lnglat.lng && element.lat === lnglat.lat) {
                        alert("已有该地点");
                        status = 0;
                        break;
                    } else {
                        status = 1;
                    }
                }
                if (status === 1) {
                    lnglats.push(lnglat);
                    document.getElementById("longitude").value = lnglat.lng;
                    document.getElementById("latitude").value = lnglat.lat;
                    $.ajax({
                        //几个参数需要注意一下
                        type: "POST",//方法类型
                        dataType: "json",//预期服务器返回的数据类型
                        url: "${pageContext.request.contextPath}/GenerateRoute/getLngLat",//url
                        data: $('#lnglat').serialize(),
                        /*success: function (result) {
                            console.log(result);//打印服务端返回的数据(调试用)
                            if (result.resultCode === 200) {
                                alert("SUCCESS");
                            }
                            ;
                        },
                        error : function() {
                            alert("异常！");
                        }*/
                    });
                }
                console.log(lnglats);
                marker.setPosition(lnglat);
                map.add(marker);
                map.setFitView(marker);
            } else {
                log.error("根据地址查询位置失败");
            }
        });


    }

    document.getElementById("geo").onclick = geoCode;
    document.getElementById("address").onkeydown = function (e) {
        if (e.keyCode === 13) {
            geoCode();
            return false;
        }
        return true;
    };
</script>

</body>
</html>
