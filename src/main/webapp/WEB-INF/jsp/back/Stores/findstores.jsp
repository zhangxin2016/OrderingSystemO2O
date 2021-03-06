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
        <c:forEach items="${findstores}" var="findstores">
            <div class="row cl" align="center">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>店铺名称：</label>
                <div class="formControls col-xs-8 col-sm-3">
                    <input type="button" class="input-text" value="${findstores.stname}" placeholder="名称" id="stname"
                           name="stname">
                </div>
            </div>
            <div class="row cl" align="center">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>店铺类型名称：</label>
                <div class="formControls col-xs-8 col-sm-3">
                    <input type="button" class="input-text" value="${findstores.storestype.stypename}" placeholder="名称"
                           id="stypename" name="stypename">
                </div>
            </div>
            <div class="row cl" align="center">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>商家名称：</label>
                <div class="formControls col-xs-8 col-sm-3">
                    <input type="button" class="input-text" value="${findstores.userSell.usname}" placeholder="名称"
                           id="usname" name="usname">
                </div>
            </div>
        </c:forEach>
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
