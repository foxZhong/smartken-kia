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
        $("#weekDateBox").datebox({
            formatter:function(date){
              //return date.year()+'-'+(date.month()+1)+'-'+date.getdate();  
              return date.getFullYear();            
            }
          }
        );
    });  //$(document).ready(function(){
    
    </script>
    
  </head>
  
  <body>
  	<div class="innerDiv" id="innerDiv">
  	<table  class="editTable" cellpadding="1" cellspacing="0">
  	  <tr>
  	    <td>日期</td>
  	    <td><input id="weekDateBox" /></td>
  	  </tr>
  	</table>
  	   <table  class="editTable" cellpadding="1" cellspacing="0">
  	     <thead>
  	        <tr>
  	          <td rowspan="2">星期/科目</td>
  	          <td colspan="2" >科目一</td>
  	          <td colspan="2">科目二</td>
  	          <td colspan="2">科目三</td>
  	        </tr>
  	        <tr>
  	           <td>总数</td>
  	           <td>分配</td>
  	           <td>总数</td>
  	           <td>分配</td>
  	           <td>总数</td>
  	           <td>分配</td>
  	        </tr>
  	     </thead>
  	     <tbody>
  	        <tr>
  	           <td>星期一</td>
               <td>${IWeek1Km1Num}</td>
               <td>${IWeek1Km1Fp}</td>
               <td>${IWeek1Km2Num}</td>
               <td>${IWeek1Km2Fp}</td>
               <td>${IWeek1Km3Num}</td>
               <td>${IWeek1Km3Fp}</td>
  	        </tr>
  	        <tr>
  	           <td>星期二</td>
               <td>${IWeek2Km1Num}</td>
               <td>${IWeek2Km1Fp}</td>
               <td>${IWeek2Km2Num}</td>
               <td>${IWeek2Km2Fp}</td>
               <td>${IWeek2Km3Num}</td>
               <td>${IWeek2Km3Fp}</td>
  	        </tr>
  	        <tr>
  	           <td>星期三</td>
               <td>${IWeek3Km1Num}</td>
               <td>${IWeek3Km1Fp}</td>
               <td>${IWeek3Km2Num}</td>
               <td>${IWeek3Km2Fp}</td>
               <td>${IWeek3Km3Num}</td>
               <td>${IWeek3Km3Fp}</td>
  	        </tr>
  	        <tr>
  	           <td>星期四</td>
               <td>${IWeek4Km1Num}</td>
               <td>${IWeek4Km1Fp}</td>
               <td>${IWeek4Km2Num}</td>
               <td>${IWeek4Km2Fp}</td>
               <td>${IWeek4Km3Num}</td>
               <td>${IWeek4Km3Fp}</td>
  	        </tr>
  	        <tr>
  	           <td>星期五</td>
               <td>${IWeek5Km1Num}</td>
               <td>${IWeek5Km1Fp}</td>
               <td>${IWeek5Km2Num}</td>
               <td>${IWeek5Km2Fp}</td>
               <td>${IWeek5Km3Num}</td>
               <td>${IWeek5Km3Fp}</td>
  	        </tr>
  	        <tr>
  	           <td>星期六</td>
               <td>${IWeek6Km1Num}</td>
               <td>${IWeek6Km1Fp}</td>
               <td>${IWeek6Km2Num}</td>
               <td>${IWeek6Km2Fp}</td>
               <td>${IWeek6Km3Num}</td>
               <td>${IWeek6Km3Fp}</td>
  	        </tr>
  	        <tr>
  	           <td>星期日</td>
               <td>${IWeek7Km1Num}</td>
               <td>${IWeek7Km1Fp}</td>
               <td>${IWeek7Km2Num}</td>
               <td>${IWeek7Km2Fp}</td>
               <td>${IWeek7Km3Num}</td>
               <td>${IWeek7Km3Fp}</td>
  	        </tr>
  	         
  	     </tbody>
  	     <tfoot>
  	        <tr>
  	          <td colspan="20">
  	            <a class="easyui-linkbutton" iconCls="icon-save" 
	            onclick="menuAddForm_submit('sys/Menu/fn/add.action')">保存</a>
	            <a class="easyui-linkbutton" iconCls="icon-save" 
	            href="booked/WeekPb/to/index.action" >返回</a>
  	          </td>
  	        </tr>
  	     </tfoot>
  	   </table>
	</div>
  </body>
</html>
