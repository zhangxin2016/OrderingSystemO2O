<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="<%=basePath%>/favicon.ico">
<LINK rel="Shortcut Icon" href="<%=basePath%>/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="<%=basePath%>lib/html5.js"></script>
<script type="text/javascript" src="<%=basePath%>lib/respond.min.js"></script>
<script type="text/javascript" src="<%=basePath%>lib/PIE_IE678.js"></script>
<![endif]-->
<link href="<%=basePath%>static/h-ui/css/H-ui.min.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>lib/Hui-iconfont/1.0.7/iconfont.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>lib/icheck/icheck.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>lib/laypage/1.2/skin/laypage.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="<%=basePath%>http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>管理员信息列表</title>
<script type="text/javascript"
	src="<%=basePath%>lib/jquery/1.9.1/jquery.js"></script>
<script type="text/javascript"
	src="<%=basePath%>lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
	<!--  Bootstrap-->
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<!-- 自定义分页的JS插件 -->
	<script type="text/javascript" src="<%=basePath%>js/pagination.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/teacher_del.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<!-- 控制页面格式 -->
<style>
.Huifold .item {
	position: relative;
}

.tabBar span.current {
	background-color: #fff;
	color: #fff
}

.Huifold .item h4 {
	margin: 0;
	padding: 0px;
	position: relative;
	border-top: 1px solid #fff;
	font-size: 3px;
	line-height: 3px;
	background-color: #eee;
	height: 3px;
}

.Huifold .item h4 b {
	position: absolute;
	cursor: pointer;
	text-align: center;
	color: #666
}

.Huifold .item .info {
	display: none;
}
</style>
</head>

<body>


	<div class="page-container">
		<!--选项卡开始-->
		<div id="tab_demo" class="HuiTab">
			<div class="tabBar cl">
				<span class="l">
						<a class="btn btn-primary radius"  href="javascript:;"
					onclick="admin_add('添加店铺类型','<%=basePath%>addStorestype.html','800','500')"
					class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>
						添加店铺类型</a> </span>
			</div>
			<div style="margin-top: 5px;margin-bottom: 2px;">
				<!-------------------------------分页插件↓(根据业务需要添加)----------------------------------------------------------------->
				<form method="post" <%--action="<%=basePath%>back/admin/search.html"--%> style="margin: 10px">
					<input type="text" id="keyWordInput" placeholder="请输入关键词" value="${keyWord}"class="input-text ac_input"
						name="id" value=""  autocomplete="off"
						style="width:20%;">
					<button type="submit" class="btn btn-default" id="searchBtn">搜索</button>
				</form>
				<!-------------------------------分页插件↑------------------------------------------------------------------->

			</div>
			<div class="tabCon">
				<table
					class="table table-border table-bordered table-hover table-bg table-sort">
					<thead>
						<tr class="text-c">

							<th width="80" class="hidden-xs">店铺类别ID</th>
							<th width="100" class="hidden-xs">店铺类别名称</th>
							<%--<th width="150">权限</th>--%>
							<th width="150">操作</th>

						</tr>

					</thead>
					<tbody id="table_all">
						<c:forEach items="${storestypes}" var="Storestype">
							<tr class="text-c">
								<td>${Storestype.stypeid}</td>
								<td class="hidden-xs">${Storestype.stypename}</td>
								<%--<td>${arr.authority}</td>--%>
								<td class="td-manage"><a title="编辑"
									href="javascript:;"
									onclick="admin_edit('店铺类别编辑','<%=basePath%>getStorestypeId.html?stypeid=${Storestype.stypeid }','${Storestype.stypeid }','800','500')"
									class="ml-5" style="text-decoration:none"><i
										class="Hui-iconfont">&#xe6df;</i> </a> <a title="删除"
									href="<%=basePath%>deleteStorestype.html?stypeid=${Storestype.stypeid }"
									<%--href="javascript:;"--%>
									onclick="javascript:if (confirm('确定删除吗？')) { 'return true';}else{'return false';};" class="ml-5"
									style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<td colspan="8">
					<!-------------------------------分页插件↓----------------------------------------------------------------->
					<form action="<%=basePath%>getAllStorestype.html" method="POST" name="spForm" id="spForm">
						<input type="hidden" id="currentPage" name="currentPage" value="${pageInfo.pageNum}">
						<input type="hidden" id="lineSize" name="lineSize" value="${pageInfo.pageSize}">
						<input type="hidden" id="keyWord" name="keyWord" value="${keyWord}">
						<button type="button" class="btn btn-primary" value="${pageInfo.firstPage}"
						${pageInfo.pageNum==1?"disabled='disabled'":""}>
							首页
						</button>
						<button type="button" class="btn btn-success"
								value="${pageInfo.prePage}"
						${pageInfo.prePage==0?"disabled='disabled'":""}>
							上一页
						</button>
						&nbsp;&nbsp;&nbsp;跳转到第&nbsp;<div class="btn-group">
						<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" id="cpBtn">
							${pageInfo.pageNum}&nbsp;&nbsp;<span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu" id="cpMenu">
							<c:forEach begin="1" end="${pageInfo.pages}" var="page">
								<li><a href="#">${page}</a></li>
							</c:forEach>
						</ul>
					</div>&nbsp;页&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;每页显示&nbsp;<div class="btn-group">
						<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" id="lsBtn">
							${pageInfo.pageSize}&nbsp;&nbsp;<span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu" id="lsMenu">
							<c:forEach items="${lineSizes}" var="lineSize">
								<li><a href="#">${lineSize}</a></li>
							</c:forEach>
						</ul>
					</div>&nbsp;条&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-info"
								value="${pageInfo.nextPage}"
						${pageInfo.nextPage==0?"disabled='disabled'":""}>
							下一页
						</button>
						<button type="button" class="btn btn-danger"value="${pageInfo.lastPage}"
						${pageInfo.pageNum==pageInfo.lastPage?"disabled='disabled'":""}>
							尾页
						</button>
						&nbsp;共 &nbsp;${pageInfo.size}/${pageInfo.total} &nbsp;条
					</form>
					<!-------------------------------分页插件↑------------------------------------------------------------------->
				</td>

				<div id="pageSplit" style="text-align:center; margin-top: 2%"></div>
				
			</div>


		</div>

		<!--选项卡结束-->
		<!-- 分页功能 start -->  
    <%--<div align="center">
        <font size="2">共 ${page.totalPage} 页</font> &nbsp;<font size="2"> 当前第 ${i} 页</font> &nbsp;
        
	        <c:choose>
	        <c:when test="${i eq '1'}">上一页
	        </c:when>
	        <c:otherwise>
	         <font size="2"><a href="<%=basePath%>back/admin/fenye.html?currentPage=${i-1}">上一页</a></font>&nbsp;
	        </c:otherwise>
	        </c:choose> 
	        
	        
            <c:choose>
	        <c:when test="${i eq page.totalPage}">下一页
	        </c:when>
	        <c:otherwise>
	         <font size="2"><a href="<%=basePath%>back/admin/fenye.html?currentPage=${i+1}">下一页</a></font>
	        </c:otherwise>
	        </c:choose> 
         
    </div>  --%>
    <!-- 分页功能 End -->  
		
	</div>



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
	<script type="text/javascript">
		$(function() {

			$.Huitab("#tab_demo .tabBar span", "#tab_demo .tabCon", "current",
					"click", "0");//选项面板
			$.Huifold("#Huifold1 .item h4", "#Huifold1 .item .info", "fast", 1,
					"click"); /*5个参数顺序不可打乱，分别是：相应区,隐藏显示的内容,速度,类型,事件*///折叠面板
			$(function() {
				$(window).on("scroll", $backToTopFun);
				$backToTopFun();
			});//返回顶部
			$('.skin-minimal input').iCheck({
				checkboxClass : 'icheckbox-blue',
				radioClass : 'iradio-blue', //check-box美化
				increaseArea : '20%'
			});

			$("#multiple_search").hide(); //多条件查询隐藏

			var nums = 5; //每页出现的数量
			var pages = 10; //得到总页数

			var thisDate = function(curr) {
				//此处只是演示，实际场景通常是返回已经当前页已经分组好的数据
				var str = '<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
				//alert(str);
				return str;
			};

			/*laypage({
				cont: 'pageSplit',
				pages: pages,
				skin: 'yahei', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#000
				jump: function(obj){
				document.getElementById('table_all').innerHTML = thisDate(obj.curr);
				//alert("123");
				}
			})*/

			//alert("sds");
		});

		/*
		 
		 * 控制表格某行展开项
		 * 
		 * */
		function item_detail(id, target) {
			if (target.title == "展开") {
				target.innerHTML = "&#xe6d6;";
				target.title = "收起";
				document.getElementById("tr_detail_1").style.display = "";

				$("#1").click();
			} else {
				$("#1").click();
				target.innerHTML = "&#xe6d5;";
				target.title = "展开";
				document.getElementById("tr_detail_1").style.display = "none";
			}

		}

		/*
		 
		 * 控制搜索展开项
		 * 
		 * */
		var multiple_search_flag = true;
		function show_multiple(target) {
			if (multiple_search_flag) {
				target.innerHTML = "&#xe6d4;";
				$("#multiple_search").show();
				multiple_search_flag = false;

				//$('.hui-animation').on('click',function(){
				var tra = 'hui-bounceinL';
				$('#multiple_search').val(tra);
				$('#multiple_search').removeClass();
				$('#multiple_search').addClass(tra);
				//})

			} else {
				target.innerHTML = "&#xe6d7;";

				var tra = 'hui-bounceoutL';
				$('#multiple_search').val(tra);
				$('#multiple_search').removeClass();
				$('#multiple_search').addClass(tra);
				setTimeout('$("#multiple_search").hide()', 1000);
				multiple_search_flag = true;

			}

		}

	function save() {
		var ids = '';
		var checks = document.getElementsByName("wangjuan");
		for ( var i = 0; i < checks.length; i++) {
			if (checks[i].checked == true) {
				ids = ids + checks[i].value + ",";
			}
		}
		document.getElementById("goodsids").value = ids;
		document.getElementById("idform").submit();
	}
//复选框
	function checkAll() {
		var checkall = document.getElementById("wert");
		var checks = document.getElementsByName("wangjuan");
		if (checkall.checked == true) {
			for ( var i = 0; i < checks.length; i++) {
				checks[i].checked = true;
			}
		} else {
			for ( var i = 0; i < checks.length; i++) {
				checks[i].checked = false;
			}
		}
	}
	
	
	
		/* $(function(){
		$("#wert").click(function(){
			var flag = this.checked;
			$(":checkbox[name='wangjuan']").attr("checked",flag);
		});
		
		$(":checkbox[name='wangjuan']").click(function(){
			$("#wert").attr("checked",$(":checkbox[name='wangjuan']").length == $(":checkbox[name='wangjuan']:checked").length)
		});
		}) */

		
//弹窗		
		/*管理员添加*/
function admin_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员编辑*/
function admin_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*管理员删除*/
function admin_del(obj,url,id){
	layer.confirm('确认要删除吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……

		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}

//批量删除
function createBill(url){
			$('#delete_select_form').attr('action', url).submit();
		}

		
		function delSelectBtn(url){
			
			//alert("delete AL  :"+url);
			
			var page = '<%=session.getAttribute("page")%>';
			
			var jsonData = eval("(" + page + ")"); //JS解析字符串为JSON:  JS方式单引号双引号都可以解析
			
			if(jsonData.page[0].pageType=="find"){
				//alert("find");
				var str = '<%=request.getAttribute("findStr")%>';
				url=url+"?findStr="+str;
			}
			//alert("url:"+url);
			layer.confirm('是否删除选中条目？', {
				skin: 'layui-layer-molv',
  			btn: ['删除','取消'] //按钮
				}, function(){
		
  				layer.msg('删除成功', {icon: 1,time: 1000});
  				setTimeout(function() {
  					$('#delete_select_form').attr('action', url).submit();	
  				}, 500);
				},function(){
  			layer.msg('取消删除', {icon: 2,time: 600});
				});	
		}
	</script>

</body>
</html>