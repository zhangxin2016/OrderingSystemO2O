<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>lib/Hui-iconfont/1.0.7/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>lib/icheck/icheck.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/style.css" />
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
<script type="text/javascript" src="js/echarts.js"></script>
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
	<script type="text/javascript">
        $.ajax({
            url:"<%=path%>userChartByDate.html",
            type:"get",
            dataType:"json",
            data:{ },
            success:function(data){
                //var aaa = data.replace('[','').replace(']','')
                var aa = new Array(data.length);
                var bb = new Array(data.length);
                for(var a = 0;a<data.length;a++){
                    aa[a]=data[a].counts;
                    bb[a]=data[a].timeDate;
                }
                var myChart = echarts.init(document.getElementById('containeruser'));
                option = {
                    title : {
                        text: '用户注册人数',
                    },
                    tooltip : {
                        trigger: 'axis'
                    },
                    legend: {
                        data:['用户注册人数']
                    },
                    toolbox: {
                        show : true,
                        feature : {
                            dataView : {show: true, readOnly: false},
                            magicType : {show: true, type: ['line', 'bar']},
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    calculable : true,
                    xAxis : [
                        {
                            type : 'category',
                            data : bb
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            name:'人数',
                            type:'bar',
                            data:aa,
                            markPoint : {
                                data : [
                                    {type : 'max', name: '最大值'},
                                    {type : 'min', name: '最小值'}
                                ]
                            },
                            markLine : {
                                data : [
                                    {type : 'average', name: '平均值'}
                                ]
                            }
                        }
                    ]
                };

                myChart.setOption(option);
            }
        });

        $.ajax({
            url:"<%=path%>findFoodChart.html",
            type:"get",
            dataType:"json",
            data:{ },
            success:function(data){
                //var aaa = data.replace('[','').replace(']','')
                var aa = new Array(data.length);
                var bb = new Array(data.length);
                var cc = new Array(data.length);
                for(var a = 0;a<data.length;a++){
                    aa[a]=data[a].fname;
                    bb[a]=data[a].coll;
                    cc[a]=data[a].sal
                }
                var myChart = echarts.init(document.getElementById('container'));
                option = {
                    title: {
                        text: '菜品销售收藏图'
                    },
                    tooltip : {
                        trigger: 'axis',
                        axisPointer: {
                            type: 'cross',
                            label: {
                                backgroundColor: '#6a7985'
                            }
                        }
                    },
                    legend: {
                        data:['销售次数','收藏次数']
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis : [
                        {
                            type : 'category',
                            boundaryGap : false,
                            data : aa
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            name:'收藏次数',
                            type:'line',
                            stack: '总量',
                            areaStyle: {normal: {}},
                            data:bb
                        },
                        {
                            name:'销售次数',
                            type:'line',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'top'
                                }
                            },
                            areaStyle: {normal: {}},
                            data:cc
                        }
                    ]
                };
                myChart.setOption(option);
            }
        });

	</script>

<title>我的桌面</title>
</head>
<body>
<div class="page-container">
	<div align="center">
		<p class="f-20 text-success">O2O订餐系统后台管理系统 <span class="f-14">v1.0</span></p>
		<p class="f-15 text-success">Mars-Shop Back System <span class="f-14"></span></p>
	</div>
	<br>
	<div class="page-container">
		<div id="containeruser" style="min-width:700px;height:400px"></div>
	</div>
	<div class="page-container">
		<div id="container" style="min-width:700px;height:400px"></div>
	</div>

</div>
<footer class="footer mt-20">
	<div class="container">
		<p>感谢jQuery、layer、laypage、Validform、UEditor、My97DatePicker、iconfont、Datatables、WebUploaded、icheck、highcharts、bootstrap-Switch<br>
			Copyright &copy;2015 H-ui.admin v2.3 All Rights Reserved.<br>
			本后台系统由<a href="http://www.h-ui.net/" target="_blank" title="H-ui前端框架">H-ui前端框架</a>提供前端技术支持</p>
	</div>

</footer>
<script type="text/javascript" src="<%=basePath%>lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script> 
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>