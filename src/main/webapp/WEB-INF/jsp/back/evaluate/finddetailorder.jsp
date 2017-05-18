<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <LINK rel="Bookmark" href="/favicon.ico">
    <LINK rel="Shortcut Icon" href="/favicon.ico"/>
    <!--[if lt IE 9]>
    <!--<script type="text/javascript" src="http://lib.h-ui.net/html5.js"></script>-->
    <script type="text/javascript" src="http://lib.h-ui.net/respond.min.js"></script>
    <script type="text/javascript" src="http://lib.h-ui.net/PIE_IE678.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css"/>

    <%--<link rel="stylesheet" type="text/css" href="http://static.h-ui.net/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="http://static.h-ui.net/h-ui/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="http://lib.h-ui.net/Hui-iconfont/1.0.7/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="http://lib.h-ui.net/icheck/icheck.css" />
    <link rel="stylesheet" type="text/css" href="http://static.h-ui.net/h-ui/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="http://static.h-ui.net/h-ui/css/style.css" />--%>
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>店铺信息 </title>
</head>
<body>
<article class="page-container">

    <form class="form form-horizontal" method="post">

            <div class="row cl" align="center">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>买家姓名：</label>
                <div class="formControls col-xs-8 col-sm-3">
                    <input type="button" class="input-text" value="${finddetailOrderListByDoid.order.userBuy.uname}" placeholder="名称" id="fname"
                           name="stname">
                </div>
            </div>
        <div class="row cl" align="center">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>菜品名字：</label>
            <div class="formControls col-xs-8 col-sm-3">
                <input type="button" class="input-text" value="${finddetailOrderListByDoid.food.fname}" placeholder="名称" id="stname"
                       name="stname">
            </div>
        </div>
        <div class="row cl" align="center">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>菜品价格：</label>
            <div class="formControls col-xs-8 col-sm-3">
                <input type="button" class="input-text" value="￥${finddetailOrderListByDoid.food.fprice}" placeholder="名称" id="staddress"
                       name="stname">
            </div>
        </div>
        <div class="row cl" align="center">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>菜品图片：</label>
            <div class="formControls col-xs-8 col-sm-3">
                <img src="/pic/${finddetailOrderListByDoid.food.fpic}" width="100px" height="60px">
            </div>
        </div>
        <div class="row cl" align="center">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>订单数量：</label>
            <div class="formControls col-xs-8 col-sm-3">
                <input type="button" class="input-text" value="${finddetailOrderListByDoid.donum}" placeholder="名称"
                       name="stname">
            </div>
        </div>
        <div class="row cl" align="center">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>订单日期：</label>
            <div class="formControls col-xs-8 col-sm-3">
                <input type="button" class="input-text" value="${finddetailOrderListByDoid.dodate}" placeholder="名称"
                       name="stname">
            </div>
        </div>
        <div class="row cl" align="center">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>订单留言：</label>
            <div class="formControls col-xs-8 col-sm-3">
                <input type="button" class="input-text" value="${finddetailOrderListByDoid.domessage}" placeholder="名称"
                       name="stname">
            </div>
        </div>
        <div class="row cl" align="center">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>收货地址：</label>
            <div class="formControls col-xs-8 col-sm-3">
                <input type="button" class="input-text" value="${finddetailOrderListByDoid.address.adcon}" placeholder="名称"
                       name="stname">
            </div>
        </div>

    </form>
</article>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="http://lib.h-ui.net/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="http://lib.h-ui.net/layer/2.1/layer.js"></script>
<script type="text/javascript" src="http://lib.h-ui.net/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="http://lib.h-ui.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="http://lib.h-ui.net/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="http://lib.h-ui.net/jquery.validation/1.14.0/messages_zh.min.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
</body>
</html>
