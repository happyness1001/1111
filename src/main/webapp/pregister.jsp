<%@ page import="mxz.entity.Provider" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <title>商家入驻申请</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="css/webbase.css" />
    <link rel="stylesheet" type="text/css" href="css/pages-register.css" />

    <script type="text/javascript" src="plugins/angularjs/angular.min.js">  </script>
    <script type="text/javascript" src="js/base.js">  </script>
    <script type="text/javascript" src="js/service/sellerService.js">  </script>
    <script type="text/javascript" src="js/controller/baseController.js">  </script>
    <script type="text/javascript" src="js/controller/sellerController.js">  </script>
</head>

<body ng-app="pinyougou" ng-controller="sellerController">
<div class="register py-container ">
    <!--head-->
    <div class="logoArea">
        <a href="" class="logo"></a>
    </div>
    <!--register-->
    <div class="registerArea">
        <h3>商家入驻申请<span class="go">我有账号，去<a href="shoplogin.html" target="_blank">登陆</a></span></h3>
        <div class="info">
            <form class="sui-form form-horizontal" action="forehome" method="post">

                <div class="control-group">
                    <label class="control-label">公司名称：</label>
                    <div class="controls">
                        <input type="text" placeholder="公司名称" class="input-xfat input-xlarge" name="corporateName">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">公司电话：</label>
                    <div class="controls">
                        <input type="text" placeholder="公司电话" class="input-xfat input-xlarge" name="officePhone">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">营业执照所在地：</label>
                    <div class="controls">
                        <input type="text" placeholder="营业执照所在地" class="input-xfat input-xlarge" name="locationOfBusinessLicense">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">公司详细地址：</label>
                    <div class="controls">
                        <input type="text" placeholder="公司详细地址" class="input-xfat input-xlarge" name="addressOfBusinessLicense">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">联系人姓名：</label>
                    <div class="controls">
                        <input type="text" placeholder="联系人姓名" class="input-xfat input-xlarge" name="emergencyContact">
                    </div>
                </div>


                <div class="control-group">
                    <label class="control-label">联系人手机：</label>
                    <div class="controls">
                        <input type="text" placeholder="联系人手机" class="input-xfat input-xlarge" name="phoneOfEmergencyContact">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">营业执照号：</label>
                    <div class="controls">
                        <input type="text" placeholder="营业执照号" class="input-xfat input-xlarge" name="registrationNumber">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">成立日期：</label>
                    <div class="controls">
                        <input type="text" placeholder="成立日期" class="input-xfat input-xlarge" name="dateOfIncorporation">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">法定代表人：</label>
                    <div class="controls">
                        <input type="text" placeholder="法定代表人" class="input-xfat input-xlarge" name="frName" >
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">法定代表人身份证号：</label>
                    <div class="controls">
                        <input type="text" placeholder="法定代表人身份证号" class="input-xfat input-xlarge" name="idNumber">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">注册资本：</label>
                    <div class="controls">
                        <input type="text" placeholder="注册资本" class="input-xfat input-xlarge"name="registeredCapital" >
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label">营业范围：</label>
                    <div class="controls">
                        <input type="text" placeholder="营业范围" class="input-xfat input-xlarge" name="businessScope">
                    </div>
                </div>

                <div class="control-group">
                    <label  class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <div class="controls">
                        <input name="m1" type="checkbox" value="2" checked=""><span>同意协议并注册  <a href="sampling.html">《商家入驻协议》</a></span>
                    </div>
                </div>
                <%--<input type="text" name="uid" style="display: none" value="<%=request.getParameter("uid")%>"/>--%>
                <input type="text" name="state" style="display: none" value="2"/>
                <input type="text" name="type" style="display: none" value="1"/>
                <div class="control-group">
                    <label class="control-label"></label>
                    <div class="controls btn-reg">
                        <button type="submit" class="submit_btn" id="btnSubmit" onclick="sendSubmit()">提交</button>
                    </div>
                </div>
            </form>
            <div class="clearfix"></div>
        </div>
    </div>
    <!--foot-->
    <div class="py-container copyright">
        <ul>
            <li>关于我们</li>
            <li>联系我们</li>
            <li>联系客服</li>
            <li>商家入驻</li>
            <li>营销中心</li>
            <li>手机品优购</li>
            <li>销售联盟</li>
        </ul>

    </div>
</div>
</body>
</html>

