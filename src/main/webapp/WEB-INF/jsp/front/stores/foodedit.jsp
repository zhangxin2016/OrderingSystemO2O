<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>

<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<LINK rel="Bookmark" href="/favicon.ico">
	<LINK rel="Shortcut Icon" href="/favicon.ico" />
	<!--[if lt IE 9]>
	<script type="text/javascript" src="http://lib.h-ui.net/html5.js"></script>
	<script type="text/javascript" src="http://lib.h-ui.net/respond.min.js"></script>
	<script type="text/javascript" src="http://lib.h-ui.net/PIE_IE678.js"></script>
	<![endif]-->
	<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
	<link rel="stylesheet" href="<%=basePath%>lib/labellauty/css/jquery-labelauty.css">
	<!--[if IE 6]>
	<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
	<script>DD_belatedPNG.fix('*');</script>
	<![endif]-->
	<!--/meta 作为公共模版分离出去-->

	<title>商家修改商品信息</title>
	<meta name="keywords" content="H-ui.admin v2.3,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
	<meta name="description" content="H-ui.admin v2.3，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
	<style>
		.col-center-block {
			float: none;
			display: block;
			margin-left: auto;
			margin-right: auto;
		}
	</style>
</head>

<body style="overflow: hidden;">
<article class="page-container" style="padding-top: 1%;width: 90%;margin-left: 5%;">

	<form action="<%=basePath %>frontEditFood.html" method="post" class="form form-horizontal" id="demoform-2" novalidate="novalidate" enctype="multipart/form-data">
		<input type="hidden" name="fid" value="${editFoodByStid.fid}"/>
		<input type="hidden" name="stid" value="${editFoodByStid.stid}"/>
		<input type="hidden" name="fcollection" value="${editFoodByStid.fcollection}"/>
		<input type="hidden" name="fsalesvolume" value="${editFoodByStid.fsalesvolume}"/>
		<input type="hidden" name="fstatus" value="${editFoodByStid.fstatus}"/>
		<legend class="col-xs-12" style="font-size: 16px;padding: 0px;margin-top: 10px;margin-bottom: 0px;">请输入菜品名字:</legend>
		<input type="text" class="input-text" name="fname" value="${editFoodByStid.fname}" id="stname" >
		<legend class="col-xs-12" style="font-size: 16px;padding: 0px;margin-top: 10px;margin-bottom: 0px;">请输入菜品价格:</legend>
		<input type="text" class="input-text" name="fprice" value="${editFoodByStid.fprice}" id="xiangxi" >
		<legend class="col-xs-12" style="font-size: 16px;padding: 0px;margin-top: 10px;margin-bottom: 0px;">请输入餐厅图片:</legend>
		<c:if test="${editFoodByStid.fpic !=null}">
			<img src="/pic/${editFoodByStid.fpic}" width=100 height=80  />
			<br/>
		</c:if>
		<input type="file" class="input-text" name="items_pic" value="${editFoodByStid.fpic}" id="items_pic" >
		<input style="width: 100%;margin-top: 25px;" class="btn btn-primary" type="submit" value="&nbsp;&nbsp;提&nbsp;交&nbsp;&nbsp;">
	</form>

</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=basePath%>lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui.admin/js/H-ui.admin.js"></script>
<script src="<%=basePath%>lib/labellauty/js/jquery-labelauty.js"></script>

<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript">
    $(function(){
        $(':input').labelauty();
        var call_flag = '<%=request.getAttribute("close") %>';
        if(call_flag=="close"){
            //layer.msg('修改成功', {icon: 1,time: 1000});
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.editStores_callback();
            parent.layer.close(index);
        }
    });
</script>
</body>

</html>