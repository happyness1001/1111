
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
            position: relative;
        }

        .btn {
            width: 10rem;
            margin-left: 6.8rem;
        }
        #left{
            float: left;
            left: 2rem;
            position: absolute
        }
    </style>
    <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>


</head>
<body>
<div id="container"></div>
<form id="lnglat" >
    <div class="input-card" id="right" style="width: 28rem; ">

        <label style="color: grey">请输入收货地点</label>
        <div class="input-item">
            <div class="input-item-prepend">
                <span class="input-item-text">地址</span>
            </div>
            <input type="text"id="address"   name="address_name"/>
            <input type="hidden" id="longitude"name="longitude" >
            <input type="hidden" id="latitude"name="latitude" >
        </div>
        <input id="geo"  type="button"   class="btn" value="确认" />
        <a href="${pageContext.request.contextPath}/GenerateRoute/null"><input type="button" class="btn" value="输入完毕"/></a>

    </div>


</form>
<form id="lnglat_left">
    <div class="input-card" id="left" style="width: 28rem">
        <label style="color: grey">请输入送货地点</label>
        <div class="input-item">
            <div class="input-item-prepend">
                <span class="input-item-text">地址</span>
            </div>
            <input type="text"id="address_left"   name="address_name"/>
            <input type="hidden" id="longitude_left"name="longitude" >
            <input type="hidden" id="latitude_left"name="latitude" >
        </div>
        <input id="geo_left"  type="button"   class="btn" value="确认" />
        <input id="hidden_input" type="button" class="btn" value="输入完毕"/>
    </div>
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
        var address = document.getElementById("address").value;
        geocoder.getLocation(address, function (status, result) {
            if (status === "complete" && result.geocodes.length) {
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
                        url: "${pageContext.request.contextPath}/GenerateRoute/getLngLat" ,//url
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
            }
        });



    }
    function geoLeftCode() {
        var address = document.getElementById("address_left").value;
        geocoder.getLocation(address, function (status, result) {
            if (status === "complete" && result.geocodes.length) {
                var lnglat = result.geocodes[0].location;


                console.log("lnglat.lng:" + lnglat.lng);
                console.log("lnglat.lat:" + lnglat.lat);
                document.getElementById("longitude_left").value = lnglat.lng;
                document.getElementById("latitude_left").value = lnglat.lat;
                $.ajax({
                    //几个参数需要注意一下
                    type: "POST",//方法类型
                    dataType: "json",//预期服务器返回的数据类型
                    url: "${pageContext.request.contextPath}/GenerateRoute/getLngLatLeft" ,//url
                    data: $('#lnglat_left').serialize(),
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

                marker.setPosition(lnglat);
                map.add(marker);
                map.setFitView(marker);
            }
        });



    }
    document.getElementById("geo").onclick = geoCode;
    document.getElementById("geo_left").onclick = geoLeftCode;
    document.getElementById("address").onkeydown = function (e) {
        if (e.keyCode === 13) {
            geoCode();
            return false;
        }
        return true;
    };
    document.getElementById("hidden_input").onclick = function (e) {
        document.getElementById("left").style.display='none';
    }
</script>

</body>
</html>
