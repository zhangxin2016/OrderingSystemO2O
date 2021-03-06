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
    <title>修改用户信息</title>
    <meta name="keywords" content="DeathGhost,DeathGhost.cn,web前端设,移动WebApp开发"/>
    <meta name="description" content="DeathGhost.cn::H5 WEB前端设计开发!"/>
    <meta name="author" content="DeathGhost"/>
    <link href="style/style.css" rel="stylesheet" type="text/css"/>

    <script type="text/javascript" src="js/jquery1.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script>
        $(function () {
            $("#sub1").click(function(){
                document.getElementById("updateForm").submit();
            });
        });
    </script>
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
            <span>西安市 [ <a href="#">莲湖区</a> ]</span>
        </div>
        <div class="Search">
            <form method="get" id="main_a_serach" onsubmit="return check_search(this)">
                <div class="Search_nav" id="selectsearch">
                    <a href="javascript:;" onClick="selectsearch(this,'restaurant_name')" class="choose">餐厅</a>
                    <a href="javascript:;" onClick="selectsearch(this,'food_name')">食物名</a>
                </div>
                <div class="Search_area">
                    <input type="search" id="fkeyword" name="keyword" placeholder="请输入您所需查找的餐厅名称或食物名称..."
                           class="searchbox"/>
                    <input type="submit" class="searchbutton" value="搜 索"/>
                </div>
            </form>
            <p class="hotkeywords"><a href="#" title="酸辣土豆丝">酸辣土豆丝</a><a href="#" title="这里是产品名称">螃蟹炒年糕</a><a href="#"
                                                                                                              title="这里是产品名称">牛奶炖蛋</a><a
                    href="#" title="这里是产品名称">芝麻酱凉面</a><a href="#" title="这里是产品名称">滑蛋虾仁</a><a href="#" title="这里是产品名称">蒜汁茄子</a>
            </p>
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
    <nav class="U-nav Font14 FontW">
        <ul>
            <li><i></i><a href="<%=basePath%>indexToUserCenter.html">用户中心首页</a></li>
            <li><i></i><a href="<%=basePath%>listOrderDetailByFront.html">我的订单</a></li>
            <li><i></i><a href="<%=basePath%>addressByUid.html">收货地址</a></li>
            <li><i></i><a href="<%=basePath%>userFindMyEvaluate.html">我的留言</a></li>
            <li><i></i><a href="<%=basePath%>findCollectionStoresListByUid.html">收藏的店铺</a></li>
            <li><i></i><a href="<%=basePath%>findCollectionListByUid.html">收藏的菜品</a></li>
            <li><i></i><a href="<%=basePath%>userBuyManagement.html?uid=${user.uid}">账户管理</a></li>
            <li><i></i><a href="<%=basePath%>Logout.html">安全退出</a></li>
        </ul>
    </nav>
    <article class="U-article Overflow">
        <!--user Account-->
        <section class="AccManage Overflow">
            <span class="AMTitle Block Font14 FontW Lineheight35">账户修改</span>
            <form action="<%=basePath%>userBuyUpdateManagement.html" method="post" id="updateForm">
                <table>
                    <tr>
                        <td width="30%" align="right">用户名：</td>
                        <td><input type="text" name="uname" value="${userBuyUpdate.uname}"></td>
                    </tr>
                    <tr>
                        <td width="30%" align="right">真实姓名：</td>
                        <td><input type="email" name="utruename" value="${userBuyUpdate.utruename}"></td>
                    </tr>
                    <tr>
                        <td width="30%" align="right">密码：</td>
                        <td><input type="tel" name="upassword" value="${userBuyUpdate.upassword}"></td>
                    </tr>
                    <tr>
                        <td width="30%" align="right">身份证号码：</td>
                        <td><input type="text" name="uidcard" value="${userBuyUpdate.uidcard}"></td>
                    </tr>
                    <tr>
                        <td width="30%" align="right">电话号码：</td>
                        <td><input type="text" name="uphone" value="${userBuyUpdate.uphone}"></td>
                    </tr>
                    <tr>
                        <td width="30%" align="right">电子邮箱：</td>
                        <td><input type="text" name="umail" value="${userBuyUpdate.umail}"></td>
                    </tr>
                    <tr>
                        <td width="30%" align="right">性别：</td>
                        <td><input type="text" name="usex" value="${userBuyUpdate.usex}"></td>
                    </tr>
                    <tr>
                        <td width="30%" align="right">年龄：</td>
                        <td><input type="text" name="uage" value="${userBuyUpdate.uage}"></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="uid" value="${userBuyUpdate.uid}"></td>
                        <td><input type="button" name="" id="sub1" class="Submit_b" value="保 存"></td>
                    </tr>
                </table>
            </form>
        </section>
    </article>
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
