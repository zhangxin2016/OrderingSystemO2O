<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head lang="en">
	<meta charset="UTF-8">
	<title>登录</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta name="format-detection" content="telephone=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp"/>

	<link rel="stylesheet" href="<%=path %>css/amazeui.css"/>
	<link href="<%=path %>css/dlstyle.css" rel="stylesheet" type="text/css">
	<script src="<%=path %>/js/jquery.js"></script>
	<script src="<%=path %>/layer/layer.js"></script>
	<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<script type="text/javascript">
    $(function(){
        $("#checkLogin").click(function(){
            $.ajax({
                url:"<%=path%>/checkUserSellLogin.html",
                type:"post",
                dataType:"json",
                data:{
                    name:$("#usname").val(),
                    pass:$("#uspassword").val()
                },
                success:function(data){
                    if(data.result == 0){
                        layer.msg('用户名或密码错误', {icon: 2,time: 1000});
                        $("#error").html("<font color='red'>用户名或密码错误！</font>");
                        return;
                    }else if(data.result == 1){
                        $("#error").html("");
                        layer.msg('登录成功', {icon: 1,time: 1000});
                        $("#loginform").submit();
                    }else{
                        $("#error").html("");
                    }
                },
                error:function(){
                    layer.msg('系统错误！', {icon: 2,time: 1000});
                }
            });
        });

    });

</script>
<body>

<div class="login-boxtitle">
	<a href="home.html"><img alt="logo" src="images/logobig.png"/></a>
</div>

<div class="login-banner">
	<div class="login-main">
		<div class="login-banner-bg"><span></span><img src="images/big.jpg"/></div>
		<div class="login-box">

			<h3 class="title">登录店铺</h3>

			<div class="clear"></div>

			<div class="login-form">
				<form action="<%=basePath%>userSellLogin.html" method="post" id="loginform">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon4">用&nbsp&nbsp&nbsp&nbsp户：</span>
						<input type="text" name="usname" id="usname" placeholder="用户名" class="form-control" aria-describedby="basic-addon1">
					</div>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon5">密&nbsp&nbsp&nbsp&nbsp码：</span>
						<input type="password" name="uspassword" id="uspassword" placeholder="请输入密码" class="form-control" aria-describedby="basic-addon1">
					</div>
				</form>
			</div>

			<div class="login-links">
				<%--<label for="remember-me"><input id="remember-me" type="checkbox">记住密码</label>--%>
				<a href="#" class="am-fr">忘记密码</a>
				<a href="<%=basePath%>userSellToRegister.html" class="zcnext am-fr am-btn-default">注册</a>
				<br/>
			</div>
			<div class="am-cf">
				<input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm" id="checkLogin">
			</div>
			<%--<div class="partner">
				<h3>合作账号</h3>
				<div class="am-btn-group">
					<li><a href="#"><i class="am-icon-qq am-icon-sm"></i><span>QQ登录</span></a></li>
					<li><a href="#"><i class="am-icon-weibo am-icon-sm"></i><span>微博登录</span> </a></li>
					<li><a href="#"><i class="am-icon-weixin am-icon-sm"></i><span>微信登录</span> </a></li>
				</div>
			</div>--%>

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