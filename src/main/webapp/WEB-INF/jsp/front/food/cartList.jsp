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
    <title>DeathGhost-我的购物车</title>
    <meta name="keywords" content="DeathGhost,DeathGhost.cn,web前端设,移动WebApp开发"/>
    <meta name="description" content="DeathGhost.cn::H5 WEB前端设计开发!"/>
    <meta name="author" content="DeathGhost"/>
    <link href="<%=path %>style/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=path %>js/public.js"></script>
    <script type="text/javascript" src="<%=path %>js/jquery1.js"></script>
    <script type="text/javascript" src="<%=path %>js/jqpublic.js"></script>
    <script type="text/javascript" src="<%=path %>js/cart.js"></script>
    <script type="text/javascript">
        var n=1; //用以计数,奇数勾选全部，偶数取消勾选择
        var count = 0;
        //批量删除
        function delArc(){
            //函数调用,获取选中id,所组成的字符串
            ids = getSelectCheckboxValues();
            if(ids !=null && ids != ""){
                if(confirm("确认购买?")) {
                    window.location.href='<%=basePath %>deleteCartLotSize.html?prid='+ids;
                }
            }else{
                alert("请至少选择一行！");
            }
        }
        //选中id,组成的字符串
        function getSelectCheckboxValues(){
            //获取名称为ck的checkbox,形成数组
            var objArray = document.getElementsByName('newslist');
            //定义返回结果
            var result ='';
            for (var i=0;i<objArray.length;i++){
                //如果名称为ck的checkbox被选中了，就进行id拼接
                if (objArray[i].checked==true){
                    result += objArray[i].value+",";
                }
            }
            //返回拼接结果,之所以截取到 result.length-1，因为result结果最后一个字符是,
            return result.substring(0, result.length-1);
        }

        $(document).ready(function () {
            //jquery特效制作复选框全选反选取消(无插件)
            // 全选
            $(".allselect").click(function () {
                $(".cart-checkbox input[name=newslist]").each(function () {
                    $(this).attr("checked", true);
                });
                GetCount();
                GetCount1()
            });
            //反选
            $(".invert").click(function () {
                $(".cart-checkbox input[name=newslist]").each(function () {
                    if ($(this).attr("checked")) {
                        $(this).attr("checked", false);
                    } else {
                        $(this).attr("checked", true);
                    }
                });
                GetCount();
                GetCount1();
            });


            // 输出
            $(".cart-checkbox input[name=newslist]").click(function () {
                GetCount($(this).val());

            });
        });
        function GetCount(id) {
            var conts = 0;
            var aa = 0;
            $(".cart-checkbox input[name=newslist]").each(function () {
                if ($(this).attr("checked")) {
                    for (var i = 0; i < $(this).length; i++) {
                        //conts += parseInt($(this).eq("#dangejine"+id+"").val());
                        id = $(this).val();
                        cartcount(id);
                        //conts += parseInt($("input[name='to"+id+"']").val());
                        conts += count;
                        aa += 1;
                    }
                }
            });
            $("#shuliang").text(aa);
            //$("#totalGoodsmoney").html($("#dangejine"+id).text());
            $("#totalGoodsmoney").text((conts).toFixed(2));
        }
        function jian(id,price){
            var x= $("#"+id).val();
            if(x==0){
                alert("您的此商品数量已经为0");
            }
            else{
                $('#bt1'+id).attr('disabled',false);
                $("#"+id).val(parseFloat(x)-1);
                outcars(id);
                GetCount(id);
            }
        }
        function jia(id,price){
            var x= $("#"+id).val();
            $("#"+id).val(parseFloat(x)+1);
            outcara(id);
            GetCount(id);
        }
        function outcara(id){
            $.ajax(
                {
                    type: "post",  //get或post
                    async : false,  //可选，默认true  true或false
                    url:  "<%=path %>/cartAddCount.html",   //请求的服务器地址
                    //dataType: "text",
                    dataType: "json",	//返回的数据类型
                    data:
                        {					//请求携带的参数，一个或者多个均可
                            //$("#ajaxForm").serialize();  form实体提交
                            cartId:id,
                            outcarnum:$("#"+id).val()
                        } ,
                    success:function(data)
                    {
                        $("#dangejine"+id).html(data);
                    }
                });
        }

        function outcars(id){
            $.ajax(
                {
                    type: "post",  //get或post
                    async : false,  //可选，默认true  true或false
                    url:  "<%=path %>/cartLessCount.html",   //请求的服务器地址
                    //dataType: "text",
                    dataType: "json",	//返回的数据类型
                    data:
                        {					//请求携带的参数，一个或者多个均可
                            //$("#ajaxForm").serialize();  form实体提交
                            cartId:id,
                            outcarnum:$("#"+id).val()
                        } ,
                    success:function(data)
                    {
                        $("#dangejine"+id).html(data);
                    },
                });
        }
        function cartcount(id){
            $.ajax(
                {
                    type: "post",  //get或post
                    async : false,  //可选，默认true  true或false
                    url:  "<%=path %>/cartcount.html",   //请求的服务器地址
                    dataType: "json",	//返回的数据类型
                    data:
                        {					//请求携带的参数，一个或者多个均可
                            //$("#ajaxForm").serialize();  form实体提交
                            cartId:id
                        } ,
                    success:function(data)
                    {
                        count = data;
                    },
                });
        }
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
                <a href="#">QQ客服</a><a href="#">微信客服</a><a href="#">手机客户端</a>
            </div>
            <div class="RightNav">
                <a href="user_center.html">用户中心</a> <a href="user_orderlist.html" target="_blank" title="我的订单">我的订单</a>
                <a href="cart.html">购物车（0）</a> <a href="user_favorites.html" target="_blank" title="我的收藏">我的收藏</a> <a
                    href="#">商家入驻</a>
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
<form action="#">
    <div class="gwc" style=" margin:auto;">
    <c:choose>

    <c:when test="${empty cartList }">
        <table cellpadding="0" cellspacing="0" class="gwc_tb1">
            <tr>
                <td class="tb1_td1">您购物车空空的，赶紧去订餐吧！</td>
            </tr>
        </table>
    </c:when>
    <c:otherwise>

        <table cellpadding="0" cellspacing="0" class="gwc_tb1">
            <tr>
                <td class="tb1_td1"></td>
                <td class="tb1_td1">全选</td>
                <td class="tb1_td3">商品</td>
                <td class="tb1_td4">原价</td>
                <td class="tb1_td5">数量</td>
                <td class="tb1_td6">单价</td>
                <td class="tb1_td7">操作</td>
            </tr>
        </table>
        <c:forEach items="${cartList }" var="cart">
            <table cellpadding="0" cellspacing="0" class="gwc_tb2" id="table1">

                <tr>
                    <td colspan="7" class="shopname Font14 FontW">店铺：好味来快餐店</td>
                </tr>
                <tr>
                    <td class="tb2_td1">
                        <div class="cart-checkbox">
                        <input type="checkbox" name="newslist" id='ck'  value="${cart.cid }">
                        <input type="hidden" name="to${cart.cid }" value="${cart.ctotal}" />
                        </div>
                    </td>
                    <td class="tb2_td2"><a href="detailsp.html" target="_blank"><img src="upload/01.jpg"/></a></td>
                    <td class="tb2_td3"><a href="detailsp.html" target="_blank">${cart.foods.fname }</a></td>
                    <td class="tb1_td4"><s>￥${cart.foods.fprice }</s></td>
                    <td class="tb1_td5">

                        <input id="bt1${cart.cid }" type="button" style="height: 20px;width: 20px;" onclick="jian(${cart.cid },${cart.foods.fprice })" value="-"/>
                        <input type="text" id="${cart.cid }" style="width: 30px;" value="${cart.num }">
                        <input id="bt2${cart.cid }" type="button" style="height: 20px;width: 20px;" onclick="jia(${cart.cid },${cart.foods.fprice })" value="+"/>

                    </td>
                    <td class="tb1_td6">
                        <em tabindex="0" id="dangejine${cart.cid }" class="number" style="color:#ff5500;font-size:14px; font-weight:bold;">${cart.ctotal}</em>
                    </td>
                    <td class="tb1_td7"><a href="#" id="delcart1">删除</a></td>
                </tr>
            </table>
        </c:forEach>
        <table cellpadding="0" cellspacing="0" class="gwc_tb3">
            <tr>
                <td class="tb1_td1">
                    <input type="button" class="allselect" value="全选"/>
                </td>
                <td class="tb3_td1" >
                    <input type="button" class="invert" value="反选"/>
                </td>
                <td class="tb3_td2 GoBack_Buy Font14"><a href="#" target="_blank">继续购物</a></td>
                <td class="tb3_td2">已选商品
                    <label id="shuliang" style="color:#ff5500;font-size:14px; font-weight:bold;">0</label>
                    件
                </td>
                <td class="tb3_td3">合计(不含运费):<span>￥</span>
                    <span style=" color:#ff5500;">
							<span id="totalGoodsmoney" style="color:#ff5500;font-size:14px; font-weight:bold;"></span>
                    </span>
                </td>
                <td class="tb3_td4"><span id="jz1">结算</span><a style=" display:none;"
                                                               class="jz2" id="jz2"><span onclick="delArc();">结算</span></a></td>
            </tr>
        </table>
    </c:otherwise>
    </c:choose>
    </div>
</form>
<!--End content-->
<div class="F-link">
    <span>友情链接：</span>
    <a href="http://www.deathghost.cn" target="_blank" title="DeathGhost">DeathGhost</a>
    <a href="http://www.17sucai.com/pins/15966.html" target="_blank" title="免费后台管理模板">绿色清爽版通用型后台管理模板免费下载</a>
    <a href="http://www.17sucai.com/pins/17567.html" target="_blank" title="果蔬菜类模板源码">HTML5果蔬菜类模板源码</a>
    <a href="http://www.17sucai.com/pins/14931.html" target="_blank" title="黑色的cms商城网站后台管理模板">黑色的cms商城网站后台管理模板</a>
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
