<%--
  Created by IntelliJ IDEA.
  User: Xin
  Date: 2017/3/5
  Time: 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="user/back.html">test</a>
  <a href="user/testJson.html">testJson</a>
  </body>
</html>
