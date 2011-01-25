<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <jsp:include page="/plugin/index.jsp?plugin=jquery,easyui"></jsp:include>
    <jsp:include page="/css/index.jsp"></jsp:include>
    <jsp:include page="/js/index.jsp"></jsp:include>
    
    <script type="text/javascript">
    
    $(document).ready(function(){
           var innerHeight=$("#innerDiv").outerHeight(false);
	       var innerWidth=$("#innerDiv").width();
	       var weekPbDG="weekPbDG";
	       
	       $("#"+weekPbDG).datagrid({
	            url: 'booked/WeekPb/list/DataGrid.action?format=json',
				title: '周排班列表',
				fitColumns: true,
				singleSelect:false,
				height:innerHeight,
				width:innerWidth,
				pagination:true,
				idField:"id",
				columns:[[
				    {field:'id',title:'编号',checkbox:true},
				    {field:'IWeekNum',title:'第几周',width:10},
					//{field:"parentId",title:'父菜单',width:10},
					{field:'CWeekRange',title:'时间范围',width:30},
					{field:'CCheckOperator',title:'提交人/审核人',width:30},
					{field:'IChecked',title:'审核结果',width:30}
					
				]],
				onDblClickRow:function(index,data){
                     document.location.href="booked/WeekPb/to/assign.action?weekid="+data.id;
					// $(this).html(fnHtmlInnerFrame("booked/WeekPb/to/assign.action?weekid="+data.id));
				   //});  //$('#editWindow').dialog({
				} //onDblClick:function(){
	       
	       }); //$("#"+weekPbDG).datagrid({

    });  //$(document).ready(function(){
    
    </script>
    
  </head>
  
  <body>
  	<div class="innerDiv" id="innerDiv">
	<table id="weekPbDG"></table>
	<div id="weekPbAssign"></div>
	</div>
  </body>
</html>
