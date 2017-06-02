<%--
  Created by IntelliJ IDEA.
  User: Xin
  Date: 2017/3/14
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>020订餐系统</title>
    <meta name="keywords" content="DeathGhost,DeathGhost.cn,web前端设,移动WebApp开发"/>
    <meta name="description" content="DeathGhost.cn::H5 WEB前端设计开发!"/>
    <meta name="author" content="DeathGhost"/>
    <link href="<%=path %>/style/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=path %>/js/public.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery1.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jqpublic.js"></script>
    <style type="text/css">
        .file {
            position: relative;
            display: inline-block;
            background: #D0EEFF;
            border: 1px solid #99D3F5;
            border-radius: 4px;
            padding: 4px 12px;
            overflow: hidden;
            color: #1E88C7;
            text-decoration: none;
            text-indent: 0;
            line-height: 20px;
        }
        .file input {
            position: absolute;
            font-size: 100px;
            right: 0;
            top: 0;
            opacity: 0;
        }
        .file:hover {
            background: #AADFFD;
            border-color: #78C3F3;
            color: #004974;
            text-decoration: none;
        }
    </style>
</head>

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
                <a href="<%=basePath%>userSellToLogin.html">我是商家</a>
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
<section class="Cfn">
    <aside class="C-left">
        <div class="S-time">服务时间：周一~周六
            <time>09:00</time>
            -
            <time>23:00</time>
        </div>
        <div class="C-time">
            <img src="<%=path %>/upload/dc.jpg"/>
        </div>
        <a target="_blank"><img src="<%=path %>/images/by_button.png"></a>
        <a target="_blank"><img src="<%=path %>/images/dc_button.png"></a>
    </aside>
    <div class="F-middle">
        <ul class="rslides f426x240">
            <c:forEach items="${foodsListBySalesvolume}" var="foodsListBySalesvolume">
                <li><a href="javascript:"><img src="/pic/${foodsListBySalesvolume.fpic }" width="600"/></a></li>
            </c:forEach>
        </ul>
    </div>

    <aside class="N-right">
        <div class="N-title">订餐系统 <i>图片搜索</i></div>
        <ul class="Newslist">
            <form id="form11" action="<%=basePath %>searchForByPic.html" method="post" enctype="multipart/form-data" >
                <input type="file" class="file" name="items_pic" id="items_pic" value="选择文件">
                <input type="submit" class="file" value="搜 索"/>
            </form>
        </ul>
        <ul class="Orderlist" id="UpRoll">
            <c:forEach items="${detailorderListFrontIndex}" var="detailorderListFrontIndex">
                <li>
                    <p>订单编号：${detailorderListFrontIndex.doid}</p>
                    <p>菜品姓名：${detailorderListFrontIndex.food.fname}</p>
                    <p>订单状态：
                        <c:if test="${detailorderListFrontIndex.dostatus == 0}">
                            <i class="State02">等待商家接单</i>
                        </c:if>
                        <c:if test="${detailorderListFrontIndex.dostatus == 1}">
                            <i class="State01">已发货</i>
                        </c:if>
                        <c:if test="${detailorderListFrontIndex.dostatus == 2}">
                            <i class="State02">已签收</i>
                        </c:if>
                        <c:if test="${detailorderListFrontIndex.dostatus == 3}">
                            <i class="State03">已点评</i>
                        </c:if>
                        <c:if test="${detailorderListFrontIndex.dostatus == 4}">
                            <i class="State01">用户取消订单</i>
                        </c:if>
                        <c:if test="${detailorderListFrontIndex.dostatus == 5}">
                            <i class="State03">商家取消订单</i>
                        </c:if>
                    </p>
                </li>
            </c:forEach>
        </ul>
        <script>
            var UpRoll = document.getElementById('UpRoll');
            var lis = UpRoll.getElementsByTagName('li');
            var ml = 0;
            var timer1 = setInterval(function () {
                var liHeight = lis[0].offsetHeight;
                var timer2 = setInterval(function () {
                    UpRoll.scrollTop = (++ml);
                    if (ml == 1) {
                        clearInterval(timer2);
                        UpRoll.scrollTop = 0;
                        ml = 0;
                        lis[0].parentNode.appendChild(lis[0]);
                    }
                }, 10);
            }, 5000);
        </script>
    </aside>
</section>
<section class="Sfainfor">
    <article class="Sflist">
        <div id="Indexouter">
            <ul id="Indextab">
                <li class="current">点菜</li>
                <li>餐馆</li>
                <p class="class_B">
                    <span></span>
                    <span><a href="<%=basePath%>frontFindAllFoodFenye.html" target="_blank"
                             style="float: right">more ></a></span>
                </p>
            </ul>
            <div id="Indexcontent">
                <ul style="display:block;">
                    <li>
                        <div class="SCcontent">
                            <c:forEach items="${foodsListByCollection}" var="foodsListByCollection">
                                <a href="<%=basePath%>getFoodById.html?fid=${foodsListByCollection.fid}" target="_blank"
                                   title="菜品名称">
                                    <figure>
                                        <img src="/pic/${foodsListByCollection.fpic }">
                                        <figcaption>
                                            <span class="title">${foodsListByCollection.fname}</span>
                                            <span class="price"><i>￥</i>${foodsListByCollection.fprice}</span>
                                        </figcaption>
                                    </figure>
                                </a>
                            </c:forEach>
                        </div>
                        <div class="bestshop">
                            <a target="_blank" title="店铺名称">
                                <figure>
                                    <img src="<%=path %>/upload/wpjnewlogo.jpg">
                                </figure>
                            </a>
                            <a target="_blank" title="店铺名称">
                                <figure>
                                    <img src="<%=path %>/upload/weijia.jpg">
                                </figure>
                            </a>
                            <a target="_blank" title="店铺名称">
                                <figure>
                                    <img src="<%=path %>/upload/wpjnewlogo.jpg">
                                </figure>
                            </a>
                            <a target="_blank" title="店铺名称">
                                <figure>
                                    <img src="<%=path %>/upload/weijia.jpg">
                                </figure>
                            </a>
                            <a target="_blank" title="店铺名称">
                                <figure>
                                    <img src="<%=path %>/upload/wpjnewlogo.jpg">
                                </figure>
                            </a>
                        </div>
                    </li>
                </ul>
                <ul>
                    <li>
                        <div class="DCcontent">
                            <c:forEach items="${storesListIndex}" var="storesListIndex">
                                <a href="<%=basePath%>userBuyToStores.html?stid=${storesListIndex.stid }"
                                   target="_blank" title="TITLE:店名">
                                    <figure>
                                        <img src="/pic/${storesListIndex.stdesc }">
                                        <figcaption>
                                            <span class="title">${storesListIndex.stname}</span>
                                        </figcaption>
                                        <p class="p3">店铺地址：${storesListIndex.staddress}</p>
                                    </figure>
                                </a>
                            </c:forEach>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </article>
    <aside class="A-infor">
        <img src="<%=path %>/upload/2014911.jpg">
        <div class="usercomment">
            <span>点击联系我们</span>
            <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=1158726684&site=qq&menu=yes">
                <img border="0" width="93px" height="153px" src="http://wpa.qq.com/pa?p=2:1158726684:53" alt="点击这里给我发消息" title="点击这里给我发消息"/>
            </a>
            <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=1158726684&site=qq&menu=yes">
                <img border="0"
                   width="93px"
                   height="153px"
                   src="http://wpa.qq.com/pa?p=2:1158726684:53"
                   alt="点击这里给我发消息"
                   title="点击这里给我发消息"/></a>
            <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=1158726684&site=qq&menu=yes">
                <img border="0"
                   width="93px"
                   height="153px"
                   src="http://wpa.qq.com/pa?p=2:1158726684:53"
                   alt="点击这里给我发消息"
                   title="点击这里给我发消息"/></a>
        </div>
    </aside>
</section>
<!--End content-->
<div class="F-link">
    <span>友情链接：</span>
    <a href="http://www.baidu.com" target="_blank" title="百度">百度</a>
    <a href="https://www.ele.me/" target="_blank" title="饿了么">饿了么</a>
    <a href="http://bj.meituan.com/" target="_blank" title="美团">美团</a>
    <a href="http://www.baidu.com" target="_blank" title="美团">百度外卖</a>
    <a href="http://bj.meituan.com/" target="_blank" title="美团">美团外卖</a>
    <a href="https://www.ele.me/" target="_blank" title="美团">饿了么</a>
</div>
<footer>
    <section class="Otherlink">
        <aside>
            <div class="ewm-left">
                <p>手机扫描二维码：</p>
                <img src="<%=path %>/images/Android_ico_d.gif">
                <img src="<%=path %>/images/iphone_ico_d.gif">
            </div>
            <div class="tips">
                <p>客服热线</p>
                <p><i>1830927**73</i></p>
                <p>配送时间</p>
                <p>
                    <time>09：00</time>
                    ~
                    <time>22:00</time>
                </p>
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
    <div class="copyright">© 版权所有 2016 DeathGhost 技术支持：<a href="http://www.deathghost.cn"
                                                          title="DeathGhost">DeathGhost</a></div>
</footer>
</body>
</html>
