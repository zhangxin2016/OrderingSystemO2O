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
    <meta charset="utf-8" />
    <title>我的店铺</title>
    <meta name="keywords" content="DeathGhost,DeathGhost.cn,web前端设,移动WebApp开发" />
    <meta name="description" content="DeathGhost.cn::H5 WEB前端设计开发!" />
    <meta name="author" content="DeathGhost"/>
    <link href="<%=path %>/style/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=path %>/js/public.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
    <%--<script type="text/javascript" src="<%=path %>/js/jqpublic.js"></script>--%>

    <script type="text/javascript" src="<%=path %>/js/cart.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>lib/Validform/5.3.2/Validform.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>lib/layer/2.1/layer.js"></script>

    <script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>

    <script type="text/javascript" src="<%=basePath%>static/h-ui.admin/js/H-ui.admin.js"></script>
    <script type="text/javascript" src="<%=basePath%>lib/laypage/1.2/laypage.js"></script>
    <script type="text/javascript" src="<%=basePath%>lib/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=basePath%>lib/jquery/1.9.1/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <!--  Bootstrap-->
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->

   <%-- <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <!-- 百度地图API样式 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=lo8alm4vpnwYCLWV6PSKtBP402GHU3p4"></script>
    <!-- 自定义分页的JS插件 -->
    <script type="text/javascript" src="<%=basePath%>js/pagination.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/teacher_del.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
    <script>
        $(function(){
            $('.title-list li').click(function(){
                var liindex = $('.title-list li').index(this);
                $(this).addClass('on').siblings().removeClass('on');
                $('.menutab-wrap div.menutab').eq(liindex).fadeIn(150).siblings('div.menutab').hide();
                var liWidth = $('.title-list li').width();
                $('.shopcontent .title-list p').stop(false,true).animate({'left' : liindex * liWidth + 'px'},300);
            });

            $('.menutab-wrap .menutab li').hover(function(){
                $(this).css("border-color","#ff6600");
                $(this).find('p > a').css('color','#ff6600');
            },function(){
                $(this).css("border-color","#fafafa");
                $(this).find('p > a').css('color','#666666');
            });
        });
        var mt = 0;
        window.onload = function () {
            var Topcart = document.getElementById("Topcart");
            var mt = Topcart.offsetTop;
            window.onscroll = function () {
                var t = document.documentElement.scrollTop || document.body.scrollTop;
                if (t > mt) {
                    Topcart.style.position = "fixed";
                    Topcart.style.margin = "";
                    Topcart.style.top = "200px";
                    Topcart.style.right = "191px";
                    Topcart.style.boxShadow ="0px 0px 20px 5px #cccccc";
                    Topcart.style.top="0";
                    Topcart.style.border="1px #636363 solid";
                }
                else {
                    Topcart.style.position = "static";
                    Topcart.style.boxShadow ="none";
                    Topcart.style.border="";
                }
            }
        }
        function toAddStores(title,url,w,h){
            layer.open({
                type: 2,
                area: [w+'px', h +'px'],
                fix: false, //不固定
                maxmin: false,
                shade:0.2,
                shadeClose: false,
                title: title,
                move: false,
                content: [url,'no']
            });
        }
        function editStores(title,url,w,h){
            layer.open({
                type: 2,
                area: [w+'px', h +'px'],
                fix: false, //不固定
                maxmin: false,
                shade:0.2,
                shadeClose: false,
                title: title,
                move: false,
                content: [url,'no']
            });
        }
        function toAddFood(title,url,w,h){
            layer.open({
                type: 2,
                area: [w+'px', h +'px'],
                fix: false, //不固定
                maxmin: false,
                shade:0.2,
                shadeClose: false,
                title: title,
                move: false,
                content: [url,'no']
            });
        }
        function toEditFood(title,url,w,h){
            layer.open({
                type: 2,
                area: [w+'px', h +'px'],
                fix: false, //不固定
                maxmin: false,
                shade:0.2,
                shadeClose: false,
                title: title,
                move: false,
                content: [url,'no']
            });
        }
        function editStores_callback(){
            window.location.reload();
            layer.msg("修改成功！");
        }
        function addStores_callback(){
            window.location.reload();
            layer.msg("增加店铺成功！");
        }

        function replyEvaluate_callback(){
            window.location.reload();
            layer.msg("回复留言成功！");
        }

    </script>

</head>
<body>
<header>
    <section class="Topmenubg">
        <div class="Topnav">
            <div class="LeftNav">
                <c:if test="${userSell.usname==null}">
                    <a href="<%=basePath%>userSellToRegister.html">注册</a>
                    |<a href="<%=basePath%>userSellToLogin.html">登录</a>
                </c:if>
                <c:if test="${userSell.usname!=null}">
                欢迎您，${userSell.usname }<a href="<%=basePath%>userSellLogout.html">退出
                </a>
                </c:if>
            <a href="#">QQ客服</a><a href="#">微信客服</a><a href="#">手机客户端</a>
        </div>
            <div class="RightNav">
                <a href="user_center.html">用户中心</a> <a href="user_orderlist.html" target="_blank" title="我的订单">我的订单</a> <a href="cart.html">购物车（0）</a> <a href="user_favorites.html" target="_blank" title="我的收藏">我的收藏</a> <a href="#">商家入驻</a>
            </div>
        </div>
    </section>
    <div class="Logo_search">
        <div class="Logo">
            <img src="images/logo.jpg"  title="DeathGhost" alt="模板">
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
<section class="Shop-index">
    <article>
        <div class="shopinfor">
        <c:if test="${inMyStores==null}">

            <div class="title" style="text-align: center">
                <span style="text-align: center" onclick="toAddStores('添加店铺','<%=basePath%>toAddStores.html',800,600)">您还没有属于自己的店铺，点击添加店铺</span>
            </div>
        </c:if>
        <c:if test="${inMyStores!=null}">
            <div class="title">
                <img src="upload/wpjnewlogo.jpg" class="shop-ico">
                <span>${inMyStores.stname}</span>
                <span>
     <img src="images/star-on.png">
     <img src="images/star-on.png">
     <img src="images/star-on.png">
     <img src="images/star-on.png">
     <img src="images/star-off.png">
    </span>
                <span>4.8</span>
            </div>
            <div class="imginfor">
                <div class="shopimg">
                    <img src="/pic/${inMyStores.stdesc }" id="showimg">
                </div>
                <div class="shoptext">
                    <p><span>地址：</span>${inMyStores.staddress}</p>
                    <p><span>电话：</span>029-88888888</p>
                    <p><span>优惠活动：</span>暂无信息</p>
                    <p><span>停车位：</span>4个停车位（免费）</p>
                    <p><span>营业时间：</span>09:00~22:00</p>
                    <p><span>WIFI：</span>免费WIFI</p>
                    <div class="Button">
                        <input type="button"><span type="button" class="DCbutton" onclick="toAddFood('添加菜品','<%=basePath%>toAddFoodsByStores.html?stid=${inMyStores.stid}',800,500)">添加菜品</span></input>
                        <input type="button"><span type="button" class="DCbutton" onclick="editStores('修改店铺信息','<%=basePath%>toEditStores.html?a=1&stid=${inMyStores.stid}',800,700)">修改店铺信息</span></input>
                    </div>
                    <div class="otherinfor">
                        <script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/buttonLite.js#style=-1&amp;uuid=&amp;pophcol=1&amp;lang=zh"></script><script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/bshareC0.js"></script>
                    </div>
                </div>
            </div>
            <div class="shopcontent">
                <div class="title2 cf">
                    <ul class="title-list fr cf ">
                        <li class="on">菜谱</li>
                        <li>累计评论</li>
                        <li>商家详情</li>
                        <li>订单详情</li>
                        <p><b></b></p>
                    </ul>
                </div>
                <div class="menutab-wrap">
                    <a name="ydwm">
                        <!--case1-->
                        <div class="menutab show">
                            <ul class="products">
                                <c:forEach items="${foodList }" var="listFood">
                                    <li>
                                        <a href="detailsp.html" target="_blank" title="${listFood.fname}">
                                            <img src="/pic/${listFood.fpic }" class="foodsimgsize">
                                        </a>
                                        <div class="item">
                                            <div>
                                                <p>${listFood.fname} ￥${listFood.fprice}元</p>
                                                <span class="AButton" onclick="toEditFood('修改菜品','<%=basePath%>toEditFoodsByStores.html?a=1&fid=${listFood.fid}',800,600)"><a>修改</a></span>
                                                <span class="AButton"><a href="<%=basePath%>frontDeleteFood.html?fid=${listFood.fid}">删除</a></span>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                                <div class="TurnPage">
                                    <c:if test="${foodList ==null}">
                                    </c:if>
                                    <c:if test="${foodList!=null}">
                                        <font size="2">共 ${page.totalPage}页&nbsp;|&nbsp;共${page.totalNumber}条</font> &nbsp;<font size="2"> 当前第 ${i} 页</font> &nbsp;
                                        <c:choose>
                                            <c:when test="${i eq '1'}">上一页
                                            </c:when>
                                            <c:otherwise>
                                                <font size="2"><a href="<%=basePath%>getStoresBySellId.html?currentPage=${i-1}">上一页</a></font>&nbsp;
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${i eq page.totalPage}">下一页
                                            </c:when>
                                            <c:otherwise>
                                                <font size="2"><a href="<%=basePath%>getStoresBySellId.html?currentPage=${i+1}">下一页</a></font>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:if>
                                </div>
                            </ul>
                        </div>
                    </a>
                    <!--case2-->
                    <div class="menutab">
                        <c:forEach items="${evaluatesListByDoid }" var="evaluatesListByDoid">
                        <div class="shopcomment">

                                <div class="Spname">
                                    <a href="#" target="_blank" title="酸辣土豆丝">${evaluatesListByDoid.detailorder.food.fname}</a>
                                </div>
                                <div class="C-content">
                                    <q>${evaluatesListByDoid.ebuycontent}</q>
                                    <i>留言日期：${evaluatesListByDoid.ebuydate}</i>
                                </div>
                                <div class="username">
                                    <c:if test="${evaluatesListByDoid.esellcontent==null}">
                                        <span class="AButton" onclick="toEditFood('回复留言','<%=basePath%>toSellAddEvaluate.html?eid=${evaluatesListByDoid.eid}',800,300)"><a>回复</a></span>
                                    </c:if>
                                    <c:if test="${evaluatesListByDoid.esellcontent!=null}">
                                        已回复：${evaluatesListByDoid.esellcontent}
                                    </a>
                                    </c:if>
                                </div>

                        </div>
                        </c:forEach>
                    </div>
                    <!--case4-->
                    <div class="menutab">
                        <div class="shopdetails">
                            <%--<div id="allmap"></div>
                            <p>返回北京市“景点”关键字的检索结果，并展示在地图上</p>--%>
                            <div class="shopmaparea" id="allmap">
                                <p></p>
                            </div>
                            <div class="shopdetailsT">
                                <input type="hidden" id="storeAddressByMap" value="${inMyStores.staddress}"/>
                                <p><span>店铺：${inMyStores.stname}</span></p>
                                <p><span>地址：</span>${inMyStores.staddress}</p>
                                <p><span>乘车路线：</span>300路、115路、14路、800路到西辛庄站下车往东100米</p>
                                <p><span>店铺介绍：</span>***于2005年3月28日开业，立于西安市碑林区***于2005年3月28日开业，立于西安市碑林区***于2005年3月28日开业，立于西安市碑林区***于2005年3月28日开业，立于西安市碑林区***</p>
                            </div>
                        </div>
                    </div>
                    <!--case5-->
                    <div class="menutab">
                        <c:forEach items="${detailorderList }" var="detailorderList">
                            <div class="shopcomment">
                                <div class="Spname">
                                    <a href="#" target="_blank" title="${detailorderList.food.fname}">菜名：${detailorderList.food.fname}</a>
                                </div>
                                <div class="C-content">
                                    <q>姓名：${detailorderList.address.adname}&nbsp&nbsp电话：${detailorderList.address.adtel}</q>
                                    <i>地址：${detailorderList.address.adcon}&nbsp&nbsp备注：${detailorderList.domessage}</i>
                                </div>
                                <div class="username">
                                    <c:if test="${detailorderList.dostatus == 0}">
                                        <a href="<%=basePath%>userSellSendFood.html?doid=${detailorderList.doid}"> 开始送餐</a>
                                    </c:if>
                                    <c:if test="${detailorderList.dostatus == 1}">
                                        订单状态：待确认收货
                                    </c:if>
                                    <c:if test="${detailorderList.dostatus == 2}">
                                        订单状态：买家未评价
                                    </c:if>
                                    <c:if test="${detailorderList.dostatus == 3}">
                                        订单状态：买家已评价
                                    </c:if>
                                </div>
                            </div>
                        </c:forEach>
                    </div>

                </div>
            </div>
        </c:if>

        </div>
    </article>
    <aside>
        <div class="cart" id="Topcart">
            <span class="Ctitle Block FontW Font14"><a href="cart.html" target="_blank">我的购物车</a></span>
            <table id="cartcontent" fitColumns="true">
                <thead>
                <tr>
                    <th width="33%" align="center" field="name">商品</th>
                    <th width="33%" align="center" field="quantity">数量</th>
                    <th width="33%" align="center" field="price">价格</th>
                </tr>
                </thead>
            </table>
            <p class="Ptc"><span class="Cbutton"><a href="cart.html" target="进入购物车">进入购物车</a></span><span class="total">共计金额: ￥0</span></p>
        </div>

        <div class="Nearshop">
            <span class="Nstitle">附近其他店铺</span>
            <ul>
                <li>
                    <img src="upload/cc.jpg">
                    <p>
                        <span class="shopname" title="动态调用完整标题"><a href="detailsp.html" target="_blank" title="肯德基">肯德基</a></span>
                        <span class="Discolor">距离：1.2KM</span>
                        <span title="完整地址title">地址：西安市雁塔区2000号...</span>
                    </p>
                </li>
            </ul>
        </div>

        <div class="History">
            <span class="Htitle">浏览历史</span>
            <ul>
                <li>
                    <a href="detailsp.html" target="_blank" title="清真川菜馆"><img src="upload/cc.jpg"></a>
                    <p>
                        <span class="shopname" title="动态调用完整标题"><a href="detailsp.html" target="_blank" title="正宗陕北小吃城">正宗陕北小吃城</a></span>
                        <span>西安市莲湖区土门十西安市莲湖区土门十字西安市莲湖区土门十字.</span>
                    </p>
                </li>
                <span>[ <a href="#">清空历史记录</a> ]</span>
            </ul>
        </div>
    </aside>

</section>
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
<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap");
    map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);
    var local = new BMap.LocalSearch(map, {
        renderOptions:{map: map}
    });
    var a = $('#storeAddressByMap').val();
    a = a.replace(" ","");
    local.search(a);
</script>
<script type="text/javascript"
        src="<%=basePath%>lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
        src="<%=basePath%>lib/icheck/jquery.icheck.min.js"></script>
<!--//放在最下边才可以，多选框0-->
<script type="text/javascript"
        src="<%=basePath%>lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript"
        src="<%=basePath%>lib/layer/2.1/layer.js"></script>
<script type="text/javascript"
        src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
<script type="text/javascript"
        src="<%=basePath%>static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript"
        src="<%=basePath%>lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript"
        src="<%=basePath%>lib/My97DatePicker/WdatePicker.js"></script>
</body>
</html>

