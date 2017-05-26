<%--
  Created by IntelliJ IDEA.
  User: Xin
  Date: 2017/3/14
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>DeathGhost-注册</title>
    <meta name="keywords" content="DeathGhost,DeathGhost.cn,web前端设,移动WebApp开发" />
    <meta name="description" content="DeathGhost.cn::H5 WEB前端设计开发!" />
    <meta name="author" content="DeathGhost"/>
    <link href="<%=path %>/style/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=path %>/js/public.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery1.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jqpublic.js"></script>
    <!--
    Author: DeathGhost
    Author URI: http://www.deathghost.cn
    -->
    <script>
        function checksex() {
            var div = document.getElementById("div4");
            div.innerHTML = "";
            var sex = document.form1.usex.value;
            if (sex == "") {
                div.innerHTML = "<font color='red'>请选择！</font>";
                document.form1.usex.focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<script src="<%=path %>/js/jquery.js"></script>
<script src="<%=path %>/layer/layer.js"></script>
<script src="<%=path %>/laydate/laydate.js"></script>
<!-- 输入验证 -->
<%--<script type="text/javascript" src="<%=path %>/js/checkmsg.js"></script>--%>

<!-- 邮箱验证 -->
<script type="text/javascript" src="<%=path %>/js/jquery.autoComplete.js"></script>
<script type="text/javascript">

    $(function(){
        $.AutoComplete('#email');
    });

    $(function () {
        //用户名验证（非空、长度、重名）
        $("#uname").blur(function(){
            if($("#uname").val()==null || $("#uname").val()==""){
                $("#nameCheck").html("<font color='red'>用户名不能为空！</font>");
            }else if($("#uname").val().length<1 || $("#uname").val().length>16){
                $("#nameCheck").html("<font color='red'>用户名介于1~16位！</font>");
            }else{
                $.ajax({
                    url:"<%=basePath%>CheckRegister.html",
                    type:"post",
                    dataType:"json",
                    data:{
                        name:$("#uname").val()
                    },
                    success:function(data){
                        if(data.result == 1){
                            $("#nameCheck").html("");
                        }else if(data.result == 0){
                            $("#nameCheck").html("<font color='red'>抱歉！用户</font>"+$("#uname").val()+"<font color='red'>已存在！</font>");
                        }
                    }
                });
                $("#nameCheck").html("");
            }
        });
        //密码验证（非空、长度）
        $("#upassword").blur(function(){
            if($("#upassword").val()==null || $("#upassword").val()==""){
                $("#passCheck").html("<font color='red'>密码不能为空！</font>");
            }else if($("#upassword").val().length<8 || $("#upassword").val().length>16){
                $("#passCheck").html("<font color='red'>密码介于8~16位！</font>");
            }else{
                $("#passCheck").html("");
            }
        });
        //确认密码验证（非空、长度、是否与密码一致）
        $("#repass").blur(function(){
            if($("#repass").val()==null || $("#repass").val()==""){
                $("#repassCheck").html("<font color='red'>确认密码不能为空！</font>");
            }else if($("#repass").val().length<1 || $("#repass").val().length>16){
                $("#repassCheck").html("<font color='red'>确认密码介于1~16位！</font>");
            }else if($("#upassword").val()!=$("#repass").val()){
                $("#repassCheck").html("<font color='red'>确认密码与密码不一致！</font>");
            }else{
                $("#repassCheck").html("");
            }
        });
        //手机号码验证
        $("#uphone").blur(function(){
            if($("#uphone").val()==null || $("#uphone").val()==""){
                $("#phoneCheck").html("<font color='red'>手机号码不能为空！</font>");
            }else if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test($("#uphone").val()))){
                $("#phoneCheck").html("<font color='red'>请输入规范的手机号码！</font>");
            }else{
                $("#phoneCheck").html("");
            }
        });
        //邮箱验证
        $("#umail").blur(function(){
            if($("#umail").val()==null || $("#umail").val()==""){
                $("#emailCheck").html("");
            }else if(!(/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test($("#umail").val()))){
                $("#emailCheck").html("<font color='red'>请输入正确的邮箱！</font>");
            }else{
                $("#emailCheck").html("");
            }
        });
        //身份证验证
        $("#uidcard").blur(function(){
            if($("#uidcard").val()==null || $("#uidcard").val()==""){
                $("#uidcardCheck").html("<font color='red'>身份证不能为空！</font>");
            }else if($("#uidcard").val().length<18 || $("#uidcard").val().length>18){
                $("#uidcardCheck").html("<font color='red'>身份证格式错误！</font>");
            }else{
                $("#uidcardCheck").html("");
            }
        });

        var code2 = null;
        //手机验证码
        $("#btn").mousedown(function(){
            $.ajax({
                url:"<%=basePath%>SendMessage.html",
                type:"post",
                dataType:"json",
                data:{
                    phone:$("#uphone").val()
                },
                success:function(data){
                    if(data.code==2){
                        layer.msg('短信已发送，请注意查收', {icon: 1,time: 1000});
                        code2 = data.phoneCode;
                        //alert(code2);
                        $("#codeCheck").html("");
                    }else{
                        layer.msg('短信发送失败，请60秒后重试', {icon: 2,time: 1000});
                    }
                }
            });
        });

        //验证码验证
        $("#code").blur(function(){

            if($("#code").val()==null || $("#code").val()==""){
                $("#codeCheck").html("<font color='red'>请输入验证码！</font>");
            }else if(code2 != $("#code").val()){

                $("#codeCheck").html("<font color='red'>验证码不正确，请60秒后重试！</font>");
            }else if(code2 == $("#code").val()){
                $("#codeCheck").html("<font color='red'>验证码正确</font>");
            }


        });

        //提交表单进行注册
        $("#sub").click(function(){
            if($("#nameChack").html()!=null || $("#uname").val()==""){
                layer.msg('用户名不规范', {icon: 2,time: 1000});
                return;
            }else if($("#passChack").html()!=null || $("#upassword").val()==""){
                layer.msg('密码不规范', {icon: 2,time: 1000});
                return;
            }else if($("#repassChack").html()!=null || $("#repass").val()==""){
                layer.msg('确认密码不规范', {icon: 2,time: 1000});
                return;
            }else if($("#emailChack").html()!=null|| $("#umail").val()==""){
                layer.msg('邮箱不规范', {icon: 2,time: 1000});
                return;
            }else if($("#uidcardCheck").html()=="身份证格式错误！"|| $("#uidcard").val()==""){
                layer.msg('身份证号不规范', {icon: 2,time: 1000});
                return;
            }
            else if($("#uphone").val()==""){
                layer.msg('手机号码不规范', {icon: 2,time: 1000});
                return;
            }else if(code2 != $("#code").val()){
                layer.msg('验证码不正确，请60秒后重试', {icon: 2,time: 1000});
                return;
            }else{
                document.getElementById("registerForm").submit();
            }

        });

    });

    //验证码倒计时
    var countdown=60;
    function settime(obj) {
        if (countdown == 0) {
            obj.removeAttribute("disabled");
            obj.value="免费获取验证码";
            countdown = 60;
            return;
        } else {
            obj.setAttribute("disabled", true);
            obj.value="重新发送(" + countdown + ")";
            countdown--;
        }
        setTimeout(function() {
            settime(obj);
        },1000);
    }

</script>
<body>
<header>
    <section class="Topmenubg">
        <div class="Topnav">
            <div class="LeftNav">
                <c:if test="${user.uname==null}">
                    <a href="<%=basePath%>user/userBuyRegister.html">注册</a>
                    |<a href="<%=basePath%>user/userBuylogin.html">登录</a>
                </c:if>
                <c:if test="${user.uname!=null}">
                    欢迎您，${user.uname }<a href="<%=basePath%>Logout.html">退出</a>
                </c:if>
            </div>
            <div class="RightNav">
                <a href="<%=basePath%>indexToUserCenter.html">用户中心</a>
                <a href="<%=basePath%>getUserAllCartList.html">购物车</a>
            </div>
        </div>
    </section>
    <div class="Logo_search">
        <div class="Logo">
            <img src="<%=path %>/images/logo.jpg" title="DeathGhost" alt="模板">
            <i></i>
            <span>${cityNow}</span>
        </div>
        <div class="Search">
            <form method="get" id="main_a_serach" onsubmit="return check_search(this)">
                <div class="Search_nav" id="selectsearch">
                    <a href="javascript:;" onClick="selectsearch(this,'restaurant_name')" class="choose">餐厅</a>
                    <a href="javascript:;" onClick="selectsearch(this,'food_name')">食物名</a>
                </div>
                <div class="Search_area">
                    <input type="hidden" value="<%=basePath%>frontSearchFoodByName.html" id="urlsearchFoodByName">
                    <input type="hidden" value="<%=basePath%>frontSearchStoresByName.html" id="urlsearchStoresByName">
                    <input type="search" id="fnamesearch" name="fname" placeholder="请输入您所需查找的餐厅名称或食物名称..."
                           class="searchbox"/>
                    <input type="submit" class="searchbutton" value="搜 索"/>
                </div>
            </form>
        </div>
    </div>
    <nav class="menu_bg">
        <ul class="menu">
            <li><a href="index.html">首页</a></li>
            <li><a href="list.html">订餐</a></li>
            <li><a href="category.html">积分商城</a></li>
            <li><a href="article_read.html">关于我们</a></li>
        </ul>
    </nav>
</header>
<!--Start content-->
<section class="Psection MT20">
    <form action="<%=basePath%>Register.html" method="post" id="registerForm">
        <table class="Register">
            <tr>
                <td width="40%" align="right" class="FontW"><span>*  </span>用户名：</td>
                <td><input type="text" id="uname" name="uname" required autofocus><span id="nameCheck"></span></td>
            </tr>
            <tr>
                <td width="40%" align="right" class="FontW"><span>*  </span>密码：</td>
                <td><input type="password" id="upassword" name="upassword" required><span id="passCheck"></span></td>
            </tr>
            <tr>
                <td width="40%" align="right" class="FontW"><span>*  </span>再次确认：</td>
                <td><input type="password" name="password" id="repass" required><span id="repassCheck"></span></td>
            </tr>
            <tr>
                <td width="40%" align="right" class="FontW"><span>*  </span>真实姓名：</td>
                <td><input type="text" name="utruename" id="utruename" required></td>
            </tr>
            <tr>
                <td width="40%" align="right" class="FontW"><span>*  </span>身份证号：</td>
                <td><input type="text" name="uidcard" id="uidcard" required><span id="uidcardCheck"></span></td>
            </tr>
            <tr>
                <td width="40%" align="right" class="FontW">性别：</td>
                <td><input type="radio" value="男" style="width:30px; height: 20px;" id="usex" name="usex">男
                    <input type="radio" value="女" style="width:30px; height: 20px;" id="usex1" name="usex">女
                <div id="div4" ></div></td>
            </tr>
            <tr>
                <td width="40%" align="right" class="FontW">年龄：</td>
                <td><input type="text" name="uage" id="uage" required></td>
            </tr>
            <tr>
                <td width="40%" align="right" class="FontW">电子邮件：</td>
                <td><input type="email" name="umail" id="umail" required><span id="emailCheck"></span></td>
            </tr>
            <tr>
                <td width="40%" align="right" class="FontW"><span>*  </span>手机号码：</td>
                <td><input type="text" name="uphone" id="uphone" required pattern="[0-9]{11}"><span id="phoneCheck"></span></td>
            </tr>
            <tr>
                <td width="40%" align="right" class="FontW"><span>*  </span>手机校验码：</td>
                <td><input type="text" name="code" id="code" required pattern="[0-9]{6}">
                    <input type="button" id="btn" value="获取验证码" class="Submit_b" onclick="settime(this)"/><br><span id="codeCheck"></span>
                </td>
            </tr>
            <tr>
                <td width="40%" align="right"></td>
                <td><input type="button" name="" id="sub" class="Submit_b" value="注 册">( 已经是会员，<a href="<%=basePath%>user/userBuylogin.html" class="BlueA">请登录</a> )</td>
            </tr>
        </table>
    </form>
</section>
<!--End content-->
<div class="F-link">
    <span>友情链接：</span>
    <a href="http://www.deathghost.cn" target="_blank" title="DeathGhost">DeathGhost</a>
    <a href="http://www.17sucai.com/pins/15966.html" target="_blank" title="免费后台管理模板">绿色清爽版通用型后台管理模板免费下载</a>
    <a href="http://www.17sucai.com/pins/17567.html" target="_blank" title="果蔬菜类模板源码">HTML5果蔬菜类模板源码</a>
    <a href="http://www.17sucai.com/pins/14931.html" target="_blank" title="黑色的cms商城网站后台管理模板">黑色的cms商城网站后台管理模板</a>
</div>
<footer>
    <section class="Otherlink">
        <aside>
            <div class="ewm-left">
                <p>手机扫描二维码：</p>
                <img src="images/Android_ico_d.gif">
                <img src="images/iphone_ico_d.gif">
            </div>
            <div class="tips">
                <p>客服热线</p>
                <p><i>1830927**73</i></p>
                <p>配送时间</p>
                <p><time>09：00</time>~<time>22:00</time></p>
                <p>网站公告</p>
            </div>
        </aside>
        <section>
            <div>
                <span><i class="i1"></i>配送支付</span>
                <ul>
                    <li><a href="article_read.html" target="_blank" title="标题">支付方式</a></li>
                    <li><a href="article_read.html" target="_blank" title="标题">配送方式</a></li>
                    <li><a href="article_read.html" target="_blank" title="标题">配送效率</a></li>
                    <li><a href="article_read.html" target="_blank" title="标题">服务费用</a></li>
                </ul>
            </div>
            <div>
                <span><i class="i2"></i>关于我们</span>
                <ul>
                    <li><a href="article_read.html" target="_blank" title="标题">招贤纳士</a></li>
                    <li><a href="article_read.html" target="_blank" title="标题">网站介绍</a></li>
                    <li><a href="article_read.html" target="_blank" title="标题">配送效率</a></li>
                    <li><a href="article_read.html" target="_blank" title="标题">商家加盟</a></li>
                </ul>
            </div>
            <div>
                <span><i class="i3"></i>帮助中心</span>
                <ul>
                    <li><a href="article_read.html" target="_blank" title="标题">服务内容</a></li>
                    <li><a href="article_read.html" target="_blank" title="标题">服务介绍</a></li>
                    <li><a href="article_read.html" target="_blank" title="标题">常见问题</a></li>
                    <li><a href="article_read.html" target="_blank" title="标题">网站地图</a></li>
                </ul>
            </div>
        </section>
    </section>
    <div class="copyright">© 版权所有 2016 DeathGhost 技术支持：<a href="http://www.deathghost.cn" title="DeathGhost">DeathGhost</a></div>
</footer>
</body>
</html>

