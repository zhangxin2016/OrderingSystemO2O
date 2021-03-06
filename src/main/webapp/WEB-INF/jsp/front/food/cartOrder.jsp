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
    <title>确认订单</title>
    <meta name="keywords" content="DeathGhost,DeathGhost.cn,web前端设,移动WebApp开发"/>
    <meta name="description" content="DeathGhost.cn::H5 WEB前端设计开发!"/>
    <meta name="author" content="DeathGhost"/>
    <link href="style/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="<%=path%>js/jquery-3.0.0.js"></script>
    <script type="text/javascript" src="<%=basePath%>lib/layer/2.1/layer.js"></script>
    <script>
        $(document).ready(function(){
            var conts = 0;
            $(".totalnumber").each(function (index,domEle) {
                //id = $(this).val();
                conts += parseInt($(domEle).text());
            });
            $("#J_ActualFee").text((conts).toFixed(2));
            $("#paysuccess").val((conts).toFixed(2));
        });
        function toAddAddress(title,url,w,h){
            layer.open({
                type: 2,
                area: [w+'px', h +'px'],
                //fix: false, //不固定
                maxmin: true,
                shade:0.2,
                shadeClose: true,
                title: title,
                move: false,
                content: [url,'no']
            });
        }
        function addAddress_callback(){
            window.location.reload();
            layer.msg('添加成功！',{icon: 2,time: 2000});
        }
        //判断地址是否被选中
        function sureOrder(){
                var val=$('input:radio[name="addressIn"]:checked').val();
                if(val!=null){
                    $("#submitFormSure").submit( );
                }else{
                    layer.msg('请选择一个收货地址！', {icon: 2,time: 2000});
                    setTimeout(function(){
                        window.location.reload();
                    },2000);
                }
            };
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
<section class="Psection MT20" id="Cflow">

    <!--如果用户未添加收货地址，则显示如下-->


    <!--配送方式及支付，则显示如下-->
    <!--check order or add other information-->
    <div class="pay_delivery">
        <a><span onclick="toAddAddress('添加地址','<%=basePath%>toUserAddAddress.html',800,1000)"><img src="images/newaddress.png"/></span></a>
    </div>

    <form action="${pageContext.request.contextPath }/addFoodOrders.html" method="post" id="submitFormSure">
        <input type="hidden" id="paysuccess" name="pays" />

        <div class="confirm_addr_f">
            <span class="flow_title">收货地址：</span>
            <!--已保存的地址列表-->
            <c:forEach items="${listAddressOrder }" var="listAddressOrder">
                <ul class="address">
                    <li id="style1"><input type="radio" value="${listAddressOrder.adid }" id="addressIn" name="addressIn" onclick="changeColor(1)"/>
                            ${listAddressOrder.adcon }（${listAddressOrder.adname }收）<span class="fontcolor">联系方式：${listAddressOrder.adtel }</span></li>
                </ul>
            </c:forEach>

        </div>

        <div class="inforlist">
            <span class="flow_title">商品清单</span>
            <table>
                <th>名称</th>
                <th>数量</th>
                <th>价格</th>
                <th>小计</th>
                <c:forEach items="${cartListByLot }" var="cartListByLot">
                    <tr>
                        <input type="hidden" name="cartid" value="${cartListByLot.cid }" />
                        <td>${cartListByLot.foods.fname }</td>
                        <td>${cartListByLot.num }</td>
                        <td>￥${cartListByLot.foods.fprice }</td>
                        <td><span>￥</span><span id="total${cartListByLot.cid }" class="totalnumber">${cartListByLot.ctotal }</span></td>
                    </tr>
                </c:forEach>
            </table>
            <div class="Order_M">
                <p><em>订单附言:</em><input name="domessage" id="domessage" type="text"></p>
            </div>
            <div class="Sum_infor">
                <p class="p2">合计：￥<span id="J_ActualFee"></span></p>
                <span onclick="sureOrder();">
                    <input type="button" value="提交订单" class="p3button" />
                </span>
            </div>
        </div>
    </form>
</section>
<script>
    //Test code,You can delete this script /2014-9-21DeathGhost/
    $(document).ready(function () {
        var submitorder = $.noConflict();
        submitorder(".p3button").click(function () {
            submitorder("#Cflow").hide();
            submitorder("#Aflow").show();
        });
    });
</script>
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
