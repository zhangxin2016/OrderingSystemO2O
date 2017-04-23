<%--
  Created by IntelliJ IDEA.
  User: Xin
  Date: 2017/3/14
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>DeathGhost-登录</title>
    <meta name="keywords" content="DeathGhost,DeathGhost.cn,web前端设,移动WebApp开发" />
    <meta name="description" content="DeathGhost.cn::H5 WEB前端设计开发!" />
    <meta name="author" content="DeathGhost"/>
    <link href="<%=path %>/style/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=path %>/js/public.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery1.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jqpublic.js"></script>
    <!--
    请求
    -->
    <script type="text/javascript" src="<%=path %>/js/jquery-1.11.1.min_044d0927.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery.bxslider_e88acd1b.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/menu.js"></script>
    <script type="text/javascript" src="<%=path %>/js/select.js"></script>
    <script type="text/javascript" src="<%=path %>/js/lrscroll.js"></script>
    <script type="text/javascript" src="<%=path %>/js/iban.js"></script>
    <script type="text/javascript" src="<%=path %>/js/fban.js"></script>
    <script type="text/javascript" src="<%=path %>/js/f_ban.js"></script>
    <script type="text/javascript" src="<%=path %>/js/mban.js"></script>
    <script type="text/javascript" src="<%=path %>/js/bban.js"></script>
    <script type="text/javascript" src="<%=path %>/js/hban.js"></script>
    <script type="text/javascript" src="<%=path %>/js/tban.js"></script>
    <script type="text/javascript" src="<%=path %>/js/lrscroll_1.js"></script>
    <script src="<%=path %>/js/jquery.js"></script>
    <script src="<%=path %>/layer/layer.js"></script>


</head>
<script type="text/javascript">
    $(function(){
        $("#checkLogin").click(function(){
            $.ajax({
                url:"<%=path%>/CheckLogin.html",
                type:"post",
                dataType:"json",
                data:{
                    name:$("#uname").val(),
                    pass:$("#upassword").val()
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
<header>
    <section class="Topmenubg">
        <div class="Topnav">
            <div class="LeftNav">
                <a href="register.html">注册</a>/<a href="login.html">登录</a><a href="#">QQ客服</a><a href="#">微信客服</a><a href="#">手机客户端</a>
            </div>
            <div class="RightNav">
                <a href="user_center.html">用户中心</a> <a href="user_orderlist.html" target="_blank" title="我的订单">我的订单</a> <a href="cart.html">购物车（0）</a> <a href="user_favorites.html" target="_blank" title="我的收藏">我的收藏</a> <a href="#">商家入驻</a>
            </div>
        </div>
    </section>
    <div class="Logo_search">
        <div class="Logo">
            <img src="<%=path %>/images/logo.jpg" title="DeathGhost" alt="模板">
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
                    <input type="search" id="fkeyword" name="keyword" placeholder="请输入您所需查找的餐厅名称或食物名称..." class="searchbox" />
                    <input type="submit" class="searchbutton" value="搜 索" />
                </div>
            </form>
            <p class="hotkeywords"><a href="#" title="酸辣土豆丝">酸辣土豆丝</a><a href="#" title="这里是产品名称">螃蟹炒年糕</a><a href="#" title="这里是产品名称">牛奶炖蛋</a><a href="#" title="这里是产品名称">芝麻酱凉面</a><a href="#" title="这里是产品名称">滑蛋虾仁</a><a href="#" title="这里是产品名称">蒜汁茄子</a></p>
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
    <form action="<%=basePath%>Userlogin.html" method="post" id="loginform">
        <table class="login">
            <tr>
                <td width="40%" align="right" class="FontW">账号：</td>
                <td><input type="text"  name="uname" id="uname" required autofocus placeholder="账号"></td>
            </tr>
            <tr>
                <td width="40%" align="right" class="FontW">密码：</td>
                <td><input type="password" name="upassword" id="upassword" required></td>
            </tr>
            <%--<tr>
                <td width="40%" align="right" class="FontW">验证码：</td>
                <td><input type="text" name="" required><img src="<%=path %>/upload/captcha.png" style="margin-left:8px; vertical-align:bottom" width="83" height="36"></td>
            </tr>--%>
            <tr>
                <td width="40%" align="right"></td>
                <td><input type="button" name="" value="登 录" class="log_btn" id="checkLogin">( 还不是会员，<a href="<%=basePath%>user/userBuyRegister.html" class="BlueA">请注册</a> )</td>
            </tr>
        </table>
    </form>
</section>
<!--End content-->
<div class="F-link">

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
                <p><time>09：00</time>~<time>22:00</time></p>
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
    <div class="copyright">© 版权所有 2016 DeathGhost 技术支持：<a href="http://www.deathghost.cn" title="DeathGhost">DeathGhost</a></div>
</footer>
</body>
</html>

