<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>后台登录</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="<%=path %>/back/css/style.css" tppabs="<%=path %>/back/css/style.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="<%=path %>/back/js/jquery.js"></script>
<script src="<%=path %>/back/js/verificationNumbers.js" tppabs="<%=path %>/back/js/verificationNumbers.js"></script>
<script src="<%=path %>/back/js/Particleground.js" tppabs="<%=path %>/back/js/Particleground.js"></script>
<script type="text/javascript" src="<%=path %>/back/layer/2.1/layer.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  //验证码
  createCode();
    //用户名或密码错误时的layer弹框
  if ('${mess}' != null && '${mess}' != "") {
        layer.msg('${mess}', {icon: 2,time: 1000});
  }
});
</script>
</head>
<body>
<form action="<%=basePath%>back/login/backlogin.html"  method="post" id="subform">
    <dl class="admin_login">
        <dt>
            <strong>020后台管理系统</strong>
            <em>OrderingSystem</em>
        </dt>
        <dd class="user_icon">
            <input type="text" placeholder="账号" class="login_txtbx" id="aname" name="aname" />
        </dd>
        <dd class="pwd_icon">
            <input type="password" placeholder="密码" class="login_txtbx" id="apassword" name="apassword"/>
        </dd>
        <dd class="val_icon">
         <div class="checkcode">
              <input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
              <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
         </div>
            <input type="button" value="验证码核验" class="ver_btn" onClick="validate();">
        </dd>
        <dd>
            <input type="button" value="立即登陆" class="submit_btn" onClick="validate();" />
        </dd>
        <dd>
            <p>© 2015-2016 jq22 版权所</p>
            <p>陕B2-8998988-1</p>
        </dd>
    </dl>
</form>
</body>
</html>
