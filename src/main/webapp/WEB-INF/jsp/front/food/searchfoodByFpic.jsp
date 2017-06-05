<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>按照图片搜索菜品列表</title>
    <meta name="keywords" content="DeathGhost,DeathGhost.cn,web前端设,移动WebApp开发"/>
    <meta name="description" content="DeathGhost.cn::H5 WEB前端设计开发!"/>
    <meta name="author" content="DeathGhost"/>
    <link href="style/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/public.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jqpublic.js"></script>
    <%-- 前台分页 --%>

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
                <a href="<%=basePath%>user/frontindex.html">返回首页</a>
            </div>
        </div>
    </section>
    <div class="Logo_search">
        <div class="Logo">
            <img src="images/logo.jpg" title="DeathGhost" alt="模板">
            <i></i>
            <span>${cityNow}</span>
        </div>
        <div class="Search">
            <form method="get" id="main_a_serach" onsubmit="return check_search(this)">
                <div class="Search_nav" id="selectsearch">
                    <a href="javascript:;" onClick="selectsearch(this,'restaurant_name')">餐厅</a>
                    <a href="javascript:;" onClick="selectsearch(this,'food_name')" class="choose">食物名</a>
                </div>
                <div class="Search_area">
                    <input type="hidden" value="<%=basePath%>frontSearchFoodByName.html" id="urlsearchFoodByName">
                    <input type="hidden" value="<%=basePath%>frontSearchStoresByName.html" id="urlsearchStoresByName">
                    <input type="search" id="fnamesearch" name="fname" placeholder="请输入您所需查找的餐厅名称或食物名称..." class="searchbox" />
                    <input type="submit" class="searchbutton" value="搜 索" />
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
<section class="Psection">
    <section class="fslist_navtree">
        <ul class="select">
        </ul>
    </section>

    <section class="CateL Overflow" id="foodListTable" >
        <div class="panel-body">
            <div id="example" class="table table-bordered table-striped table-hover">
                <ul>
                    <c:forEach items="${foodListByFpic }" var="foodListByFpic">
                        <li>
                            <a href="<%=basePath%>getFoodById.html?fid=${foodListByFpic.fid}" target="_blank" title="酸辣土豆丝">
                                <img src="/pic/${foodListByFpic.fpic }">
                                <p class="Overflow">菜品名字：${foodListByFpic.fname }</p>
                                <p class="Overflow">菜品价格：￥${foodListByFpic.fprice }</p>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>

        </div>
        <div class="TurnPage">

        </div>
    </section>
    <aside class="CateR">
        <!--广告位或推荐位-->
        <div>
            <a target="_blank"><img src="upload/ad.jpg"></a>
        </div>
        <%--<div class="Hot_shop">
            <span class="Hshoptile Font14 FontW Block">热门商家</span>
            <ul>
                <c:forEach items="${storesListFour }" var="storesListFour">
                    <li>
                        <a href="<%=basePath%>userBuyToStores.html?stid=${storesListIndex.stid }" target="_blank" title=""><img src="/pic/${storesListFour.stdesc }"></a>
                        <p class="Font14 FontW Overflow Lineheight35"><a href="shop.html" target="_blank"
                                                                         title="">${storesListFour.stname }</a>
                        </p>
                        <p class="Lineheight35 Overflow"><span title="通过动态控制地址的字符数量...">地址：${storesListFour.staddress }</span></p>
                    </li>
                </c:forEach>
            </ul>
        </div>--%>
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
                <img src="images/Android_ico_d.gif">
                <img src="images/iphone_ico_d.gif">
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
