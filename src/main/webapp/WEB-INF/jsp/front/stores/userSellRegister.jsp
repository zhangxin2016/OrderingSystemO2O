<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>

<head lang="en">
    <meta charset="UTF-8">
    <title>注册</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="stylesheet" href="<%=path %>css/amazeui.min.css"/>
    <script src="<%=path %>js/jquery.min.js"></script>
    <script src="<%=path %>js/amazeui.min.js"></script>
    <link rel="stylesheet" href="<%=path %>css/amazeui.css"/>
    <link href="<%=path %>css/dlstyle.css" rel="stylesheet" type="text/css">

</head>
<script src="<%=path %>/js/jquery.js"></script>
<script src="<%=path %>/layer/layer.js"></script>
<script src="<%=path %>/laydate/laydate.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!-- 输入验证 -->
<%--<script type="text/javascript" src="<%=path %>/js/checkmsg.js"></script>--%>

<!-- 邮箱验证 -->
<script type="text/javascript" src="<%=path %>/js/jquery.autoComplete.js"></script>
<script src="<%=path%>js/region_select.js"></script>
<script type="text/javascript">
    $(function(){
        $.AutoComplete('#email');
    });
    $(function () {
        //用户名验证（非空、长度、重名）
        $("#usname").blur(function(){
            if($("#usname").val()==null || $("#usname").val()==""){
                $("#nameCheck").html("<font color='black'>用户名不能为空！</font>");
            }else if($("#usname").val().length<1 || $("#usname").val().length>16){
                $("#nameCheck").html("<font color='black'>用户名介于1~16位！</font>");
            }else{
                $.ajax({
                    url:"<%=basePath%>checkUserSellRegister.html",
                    type:"post",
                    dataType:"json",
                    data:{
                        name:$("#usname").val()
                    },
                    success:function(data){
                        if(data.result == 1){
                            $("#nameCheck").html("");
                        }else if(data.result == 0){
                            $("#nameCheck").html("<font color='black'>抱歉！用户</font>"+$("#usname").val()+"<font color='black'>已存在！</font>");
                        }
                    }
                });
                $("#nameCheck").html("");
            }
        });
        //密码验证（非空、长度）
        $("#uspassword").blur(function(){
            if($("#uspassword").val()==null || $("#uspassword").val()==""){
                $("#passCheck").html("<font color='black'>密码不能为空！</font>");
            }else if($("#uspassword").val().length<8 || $("#uspassword").val().length>16){
                $("#passCheck").html("<font color='black'>密码介于8~16位！</font>");
            }else{
                $("#passCheck").html("");
            }
        });
        //确认密码验证（非空、长度、是否与密码一致）
        $("#repass").blur(function(){
            if($("#repass").val()==null || $("#repass").val()==""){
                $("#repassCheck").html("<font color='black'>确认密码不能为空！</font>");
            }else if($("#repass").val().length<1 || $("#repass").val().length>16){
                $("#repassCheck").html("<font color='black'>确认密码介于1~16位！</font>");
            }else if($("#uspassword").val()!=$("#repass").val()){
                $("#repassCheck").html("<font color='black'>确认密码与密码不一致！</font>");
            }else{
                $("#repassCheck").html("");
            }
        });
        //手机号码验证
        $("#usphone").blur(function(){
            if($("#usphone").val()==null || $("#usphone").val()==""){
                $("#phoneCheck").html("<font color='black'>手机号码不能为空！</font>");
            }else if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test($("#usphone").val()))){
                $("#phoneCheck").html("<font color='black'>请输入规范的手机号码！</font>");
            }else{
                $("#phoneCheck").html("");
            }
        });
        //真实姓名
        $("#ustruename").blur(function(){
            if($("#ustruename").val()==null || $("#ustruename").val()=="") {
                $("#ustruenameCheck").html("<font color='black' >真实姓名不能为空！</font>");
            } else{
                $("#ustruenameCheck").html("");
            }
        });

        //身份证验证
        $("#usidcard").blur(function(){
            if($("#usidcard").val()==null || $("#usidcard").val()==""){
                $("#uidcardCheck").html("<font color='black'>身份证不能为空！</font>");
            }else if($("#usidcard").val().length<18 || $("#usidcard").val().length>18){
                $("#uidcardCheck").html("<font color='black'>身份证格式错误！</font>");
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
                    phone:$("#usphone").val()
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
                $("#codeCheck").html("<font color='black'>请输入验证码！</font>");
            }else if(code2 != $("#code").val()){
                $("#codeCheck").html("<font color='black'>验证码不正确，请60秒后重试！</font>");
            }else if(code2 == $("#code").val()){
                $("#codeCheck").html("<font color='black'>验证码正确</font>");
            }
        });
        //详细地址不能为空
        $("#xiangxi").blur(function(){
            if($("#xiangxi").val()==null || $("#xiangxi").val()=="") {
                $("#xxnull").html("<font color='black'>详细地址不能为空！</font>");
            }else{
                $("#xxnull").html("");
            }
        });


        //提交表单进行注册
        $("#sub").click(function(){
            if($("#nameChack").html()!=null || $("#usname").val()==""){
                layer.msg('用户名不规范', {icon: 2,time: 1000});
                return;
            }else if($("#passChack").html()!=null || $("#uspassword").val()==""){
                layer.msg('密码不规范', {icon: 2,time: 1000});
                return;
            }else if($("#repassChack").html()!=null || $("#repass").val()==""){
                layer.msg('确认密码不规范', {icon: 2,time: 1000});
                return;
            }else if($("#ustruenameCheck").html()=="真实姓名不能为空！"|| $("#ustruename").val()==""){
                layer.msg('真实姓名不能为空', {icon: 2,time: 1000});
                return;
            }else if($("#xxnull").html()=="详细地址不能为空！"|| $("#xiangxi").val()==""){
                layer.msg('详细地址不能为空', {icon: 2,time: 1000});
                return;
            }else if($("#uidcardCheck").html()=="身份证格式错误！"|| $("#usidcard").val()==""){
                layer.msg('身份证号不规范', {icon: 2,time: 1000});
                return;
            }

            else if($("#usphone").val()==""){
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
<link href="<%=path%>AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
<link href="<%=path%>AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

<link href="<%=path%>css/personal.css" rel="stylesheet" type="text/css">
<link href="<%=path%>css/addstyle.css" rel="stylesheet" type="text/css">
<body>

<div class="login-boxtitle">
    <a href="home/demo.html"><img alt="" src="<%=path %>images/logobig.png"/></a>
</div>

<div class="res-banner">
    <div class="res-main">
        <div class="login-banner-bg"><span></span><img src="<%=path %>images/big.jpg"/></div>
        <div class="login-box">
            <div class="am-tabs" id="doc-my-tabs">

                <div class="user-name">
                    手机号注册
                </div>
                <form action="<%=basePath%>userSellRegister.html" method="post" id="registerForm">
                    <div id="nameCheck" style="float: right"></div>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1">用&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp户：</span>
                        <input type="text" class="form-control" placeholder="Username" name="usname" id="usname" aria-describedby="basic-addon1">
                    </div>
                    <div id="passCheck"style="float: right"></div>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon2">密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码：</span>
                        <input type="password" name="uspassword" id="uspassword" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
                    </div>
                    <div id="repassCheck" style="float: right"></div></td>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon3">重复密码：</span>
                        <input type="password" class="form-control" placeholder="Username" type="password" name="password" id="repass" aria-describedby="basic-addon1">
                    </div>
                    <div id="ustruenameCheck" style="float: right"></div></td>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon4">真实姓名：</span>
                        <input type="text" name="ustruename" id="ustruename" placeholder="请输入真实姓名" class="form-control" aria-describedby="basic-addon1">
                    </div>
                    <div id="uidcardCheck" style="float: right"></div></td>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon5">身份证号：</span>
                        <input type="text" class="form-control" name="usidcard" id="usidcard" placeholder="请输入身份证号" aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon6">联系地址：</span>
                        <%--<input type="text"  name="usaddress" id="usaddress" placeholder="请输入联系地址" class="form-control"  aria-describedby="basic-addon1">--%>
                        <div>
                            <select data-am-selected name="sheng" id="sheng">
                            </select>
                            <select data-am-selected name="shi" id="shi">
                            </select>
                            <select data-am-selected name="qu" id="qu">
                            </select>
                            <script src="<%=path%>js/region_select.js"></script>
                            <script type="text/javascript">
                                new PCAS('sheng', 'shi', 'qu', '北京市', '', '');
                            </script>
                    </div>
                    </div>
                    <div id="xxnull" style="float: right"></div>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon9">详细地址：</span>
                        <input type="text"  rows="3" id="xiangxi" name="xiangxi" placeholder="请输入详细地址" class="form-control" aria-describedby="basic-addon1">
                    </div>
                    <div id="phoneCheck" style="float: right"></div>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon7">手机号码：</span>
                        <input type="text"  name="usphone" id="usphone" placeholder="请输入手机号" class="form-control" aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon8">验证号码：</span>
                        <input type="text" class="form-control" name="code" id="code" required pattern="[0-9]{6}" placeholder="请输入验证码" aria-describedby="basic-addon1">
                        <input style="float: right" type="button" id="btn" value="获取验证码" class="Submit_b" onclick="settime(this)"/><br>
                    </div>
                    <div id="codeCheck" ></div>

                </form>
                <div class="login-links">
                    <label for="reader-me">
                        <input id="reader-me" type="checkbox"> 点击表示您同意《服务协议》
                    </label>
                </div>
                <div class="am-cf">
                    <input type="button" name="" value="注册" id="sub" class="am-btn am-btn-primary am-btn-sm am-fl">
                </div>

                <hr>


                <script>
                    $(function () {
                        $('#doc-my-tabs').tabs();
                    })
                </script>

            </div>

        </div>
    </div>
</div>

<div class="footer ">
        <div class="footer-hd ">
            <p>
                <a href="# ">恒望科技</a>
                <b>|</b>
                <a href="# ">商城首页</a>
                <b>|</b>
                <a href="# ">支付宝</a>
                <b>|</b>
                <a href="# ">物流</a>
            </p>
        </div>
        <div class="footer-bd ">
            <p>
                <a href="# ">关于恒望</a>
                <a href="# ">合作伙伴</a>
                <a href="# ">联系我们</a>
                <a href="# ">网站地图</a>
                <em>© 2015-2025 Hengwang.com 版权所有</em>
            </p>
        </div>
    </div>
</body>

</html>