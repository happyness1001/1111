<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script>

    $(function () {

        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.loginErrorMessageDiv").show();
        </c:if>

        //初始化验证码

        var show_num = [];
        draw(show_num);
        $("#canvas").on('click', function () {
            draw(show_num);
        })

        $("form.loginForm").submit(function () {
            if (0 == $("#name").val().length || 0 == $("#password").val().length) {
                $("span.errorMessage").html("请输入账号密码");
                $("div.loginErrorMessageDiv").show();
                return false;
            }

            var val = $(".input-val").val().toLowerCase();
            var num = show_num.join("");
            if (val == '') {
                //alert('请输入验证码！');
                $("span.errorMessage").html("请输入验证码");
                $("div.loginErrorMessageDiv").show();
                return false;
            } else if (val == num) {
                //alert('提交成功！');
                //$(".input-val").val('');
                //draw(show_num);
                return true;
            } else {
                $("span.errorMessage").html("验证码错误");
                $("div.loginErrorMessageDiv").show();
                $(".input-val").val('');
                draw(show_num);
                return false;
            }

            return true;
        });

        $("form.loginForm input").keyup(function () {
            $("div.loginErrorMessageDiv").hide();
        });


        var left = window.innerWidth / 2 + 162;
        $("div.loginSmallDiv").css("left", left);
    })

    //验证码
    $(function () {
        var show_num = [];
        draw(show_num);

        $("#canvas").on('click', function () {
            draw(show_num);
        })
        /*$(".btn").on('click',function(){
            var val = $(".input-val").val().toLowerCase();
            var num = show_num.join("");
            if(val==''){
                alert('请输入验证码！');
            }else if(val == num){
                alert('提交成功！');
                $(".input-val").val('');
                draw(show_num);

            }else{
                alert('验证码错误！请重新输入！');
                $(".input-val").val('');
                draw(show_num);
            }
        })*/
    })

    function draw(show_num) {
        var canvas_width = $('#canvas').width();
        var canvas_height = $('#canvas').height();
        var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
        var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
        canvas.width = canvas_width;
        canvas.height = canvas_height;
        var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
        var aCode = sCode.split(",");
        var aLength = aCode.length;//获取到数组的长度

        for (var i = 0; i <= 3; i++) {
            var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
            var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
            var txt = aCode[j];//得到随机的一个内容
            show_num[i] = txt.toLowerCase();
            var x = 10 + i * 20;//文字在canvas上的x坐标
            var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
            context.font = "bold 23px 微软雅黑";

            context.translate(x, y);
            context.rotate(deg);

            context.fillStyle = randomColor();
            context.fillText(txt, 0, 0);

            context.rotate(-deg);
            context.translate(-x, -y);
        }
        for (var i = 0; i <= 5; i++) { //验证码上显示线条
            context.strokeStyle = randomColor();
            context.beginPath();
            context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.stroke();
        }
        for (var i = 0; i <= 30; i++) { //验证码上显示小点
            context.strokeStyle = randomColor();
            context.beginPath();
            var x = Math.random() * canvas_width;
            var y = Math.random() * canvas_height;
            context.moveTo(x, y);
            context.lineTo(x + 1, y + 1);
            context.stroke();
        }
    }

    function randomColor() {//得到随机的颜色值
        var r = Math.floor(Math.random() * 256);
        var g = Math.floor(Math.random() * 256);
        var b = Math.floor(Math.random() * 256);
        return "rgb(" + r + "," + g + "," + b + ")";
    }

</script>


<div id="loginDiv" style="position: relative">
    <!--<div class="simpleLogo">
		<a href="${contextPath}"><img src="img/site/simpleLogo.png"></a>
	</div>-->
    <img id="loginBackgroundImg" class="loginBackgroundImg" src="img/site/loginBackground.png" style="width: 100%;">

    <form class="loginForm" action="forelogin" method="post">
        <div id="loginSmallDiv" class="loginSmallDiv" style="position: absolute;top: 200px;left: 1200px;background-color: #ffff;
    width: 400px;
    height: 500px;
    padding: 50px;
    border-radius: 5px;">
            <div class="loginErrorMessageDiv" style="display: none;">
                <div class="alert alert-danger">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"
                            style="background-color: #5fbd74;"></button>
                    <span class="errorMessage"></span>
                </div>
            </div>

            <div class="login_acount_text">账户登录</div>
            <div class="loginInput ">
				<span class="loginInputIcon ">
					用户名
				</span>
                <input id="name" name="name" placeholder="手机/会员名/邮箱" type="text">
            </div>

            <div class="loginInput ">
				<span class="loginInputIcon ">
					密码
				</span>
                <input id="password" name="password" type="password" placeholder="密码" type="text">
            </div>

            <div class="code" style="margin-top: 20px;">
                <input type="text" value="" placeholder="请输入验证码" class="input-val"
                       style="background: #ffffff;width: 200px;"/>
                <canvas id="canvas" width="100" height="43"
                        style="float:right;display: inline-block;border:1px solid #ccc;border-radius: 5px;cursor: pointer;height: 40px;"></canvas>
                <!--<button class="btn" style="width: 100px;height: 40px;background: #f1f1f1;border: 1px solid #ccc;border-radius: 5px;margin: 20px auto 0;display: block;font-size: 1.2rem;color: #e22e1c;cursor: pointer;">提交</button>-->
            </div>
            <div>
                <a class="notImplementLink" href="#nowhere">忘记登录密码</a>
                <a href="registerPage" class="pull-right">免费注册</a>
            </div>
            <div style="margin-top:20px">
                <button class="btn btn-block redButton" type="submit" style="background-color: #5fbd74;">登录</button>
            </div>
        </div>
    </form>


</div>

