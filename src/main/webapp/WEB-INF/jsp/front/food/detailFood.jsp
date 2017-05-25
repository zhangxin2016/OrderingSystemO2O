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
    <title>${food.fname }</title>
    <meta name="keywords" content="DeathGhost,DeathGhost.cn,web前端设,移动WebApp开发"/>
    <meta name="description" content="DeathGhost.cn::H5 WEB前端设计开发!"/>
    <meta name="author" content="DeathGhost"/>
    <link href="<%=path %>style/style.css" rel="stylesheet" type="text/css"/>
    <%--<script type="text/javascript" src="<%=path %>js/public.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jqpublic.js"></script>--%>
    <script type="text/javascript" src="<%=path %>js/jquery1.js"></script>

    <script src="<%=path %>/js/jquery.js"></script>
    <script src="<%=path %>/laydate/laydate.js"></script>
    <script>
        $(function () {
            $('.title-list li').click(function () {
                var liindex = $('.title-list li').index(this);
                $(this).addClass('on').siblings().removeClass('on');
                $('.menutab-wrap div.menutab').eq(liindex).fadeIn(150).siblings('div.menutab').hide();
                var liWidth = $('.title-list li').width();
                $('.shopcontent .title-list p').stop(false, true).animate({'left': liindex * liWidth + 'px'}, 300);
            });

            $('.menutab-wrap .menutab li').hover(function () {
                $(this).css("border-color", "#ff6600");
                $(this).find('p > a').css('color', '#ff6600');
            }, function () {
                $(this).css("border-color", "#fafafa");
                $(this).find('p > a').css('color', '#666666');
            });
        });
    </script>

    <script>
        $(document).ready(function(){
            //加的效果
            $(".add").click(function(){
                var n=$(this).prev().val();
                var num=parseInt(n)+1;
                if(num==0){ return;}
                $(this).prev().val(num);
            });
            //减的效果
            $(".jian").click(function(){
                var n=$(this).next().val();
                var num=parseInt(n)-1;
                if(num==0){ return}
                $(this).next().val(num);
            });
        })

        function addcart(fid){
            $.ajax(
                {
                    type: "post",  //get或post
                    async : false,  //可选，默认true  true或false
                    url:  "<%=path %>/addFoodCart.html",   //请求的服务器地址
                    //dataType: "text",
                    dataType: "json",	//返回的数据类型
                    data:
                        {					//请求携带的参数，一个或者多个均可
                            //$("#ajaxForm").serialize();  form实体提交
                            foodId:fid,
                            outcarnum:$("#"+fid).val()
                        } ,
                    success:function(data){
                        var con = data.con;
                        if (con=="nologin"){
                            layer.msg('请先登录', {icon: 1,time: 1000})
                        }else {
                            $("#cartUserCount").html(data);
                            layer.msg('加入购物车成功', {icon: 1,time: 1000});
                        }
                        return;
                    }
                });

        }
        function addcollection(fid){
            $.ajax(
                {
                    type: "post",  //get或post
                    async : false,  //可选，默认true  true或false
                    url:  "<%=path %>/addCollectionFood.html",   //请求的服务器地址
                    //dataType: "text",
                    dataType: "json",	//返回的数据类型
                    data:
                        {					//请求携带的参数，一个或者多个均可
                            //$("#ajaxForm").serialize();  form实体提交
                            foodId:fid,
                        } ,
                    success:function(data)
                    {
                        if(data==0){
                            layer.msg('收藏成功', {icon: 1,time: 1000});
                            return;
                        }else if(data==1){
                            layer.msg('您已经收藏过该菜品了', {icon: 1,time: 1000});
                            return;
                        }else if(data==2){
                            layer.msg('请先登录', {icon: 1,time: 1000});
                            return;
                        }
                    }
                });

        }
    </script>
    <style type="text/css">
        .gw_num{border: 1px solid #dbdbdb;width: 110px;line-height: 26px;overflow: hidden;}
        .gw_num em{display: block;height: 26px;width: 26px;float: left;color: #7A7979;border-right: 1px solid #dbdbdb;text-align: center;cursor: pointer;}
        .gw_num .num{display: block;float: left;text-align: center;width: 52px;font-style: normal;font-size: 14px;line-height: 24px;border: 0;}
        .gw_num em.add{float: right;border-right: 0;border-left: 1px solid #dbdbdb;}
    </style>
    <script src="<%=path %>/layer/layer.js"></script>
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
                <a href="<%=basePath%>getUserAllCartList.html">购物车</a><a id="cartUserCount"></a>
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
                    <input type="search" id="fkeyword" name="keyword" placeholder="请输入您所需查找的餐厅名称或食物名称..."
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
<section class="slp">
    <section class="food-hd">
        <div class="foodpic">
            <img src="/pic/${food.fpic }" id="showimg">
            <ul class="smallpic">
                <li><span onclick="addcollection(${food.fid })"><button class="btn btn-default" type="submit"style="width: 100px; background-color: #f3ab26 " >收藏菜品</button></span></li>
            </ul>
        </div>
        <div class="foodtext">
            <div class="foodname_a">
                <h1>${food.fname }</h1>
                <p>西安市丈八路220号</p>
            </div>
            <div class="price_a">
                <p class="price01">价格：￥<span>${food.fprice }</span></p>
            </div>

            <ul class="Tran_infor">
                <li>
                    <p class="Numerical">${food.fsalesvolume }</p>
                    <p>累计销量</p>
                </li>
                <li class="line">
                    <p class="Numerical">${food.fstatus }</p>
                    <p>累计评价</p>
                </li>
                <li>
                    <p class="Numerical">${food.fcollection }</p>
                    <p>累计收藏</p>
                </li>
            </ul>

            <form action="cart.html">
                <div class="BuyNo">
                    <span>我要买：
                        <input type="button" class="jian" value="-" style="background: white"></input>
                        <input type="text" class="num" id="${food.fid }" name="shuliang" required autofocus min="1" value="1"/>
                        <input type="button" class="add" value="+" style="background: white"></input>
                        份</span>
                    <div class="Buybutton">
                        <input name="" type="button" value="加入购物车" onclick="addcart(${food.fid })" class="BuyB" id="addcartlayer">
                        <a href="<%=basePath%>userBuyToStores.html?fid=${food.fid }"><span class="Backhome">进入店铺首页</span></a>
                    </div>
                </div>
            </form>
        </div>
        <div class="viewhistory">
            <span class="VHtitle">看了又看</span>
            <ul class="Fsulist">
                <c:forEach items="${foodListLook }" var="foodListLook">
                    <li>
                        <a href="<%=basePath%>getFoodById.html?fid=${foodListLook.fid}" target="_blank" title=""><img src="/pic/${foodListLook.fpic }"></a>
                        <p>${foodListLook.fname }</p>
                        <p>${foodListLook.fprice }</p>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </section>
    <!--bottom content-->
    <section class="Bcontent">
        <article>
            <div class="shopcontent">
                <div class="title2 cf">
                    <ul class="title-list fr cf ">
                        <li class="on">评价详情</li>
                        <p><b></b></p>
                    </ul>
                </div>
                <div class="menutab-wrap">
                    <!--case2-->
                    <div class="menutab show">
                        <div class="cont_padding">
                            <table class="Dcomment">
                                <th width="50%">评价内容</th>
                                <th width="50%" style="text-align:right">回复内容</th>
                                <c:forEach items="${foodDetailEvaluateList }" var="foodDetailEvaluateList">
                                    <tr>
                                        <td>${foodDetailEvaluateList.ebuycontent }
                                            <time><fmt:formatDate value="${foodDetailEvaluateList.ebuydate }"
                                                                  type="both"/></time>
                                        </td>
                                        <td align="right">${foodDetailEvaluateList.esellcontent }
                                            <time><fmt:formatDate value="${foodDetailEvaluateList.eselldate }"
                                                                  type="both"/></time>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <div class="TurnPage">

                            </div>
                        </div>
                    </div>
                    <!--case4-->

                </div>
            </div>
        </article>
        <!--ad&other infor-->
        <aside>
            <!--广告位或推荐位-->
            <a href="#" title="广告位占位图片" target="_blank"><img src="upload/2014912.jpg"></a>
        </aside>
    </section>
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
