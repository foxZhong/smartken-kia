<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>T03Ð¬³ÇÍø</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<link rel="stylesheet" type="text/css"  href="css/mouse.css" />
	<script type="text/javascript" src="javascript/mouse.js"></script>
  </head>
  
  <body>
  	<div>
  		<div id="top"><jsp:include page="Top.jsp"></jsp:include></div>
  		<div id="left" style="float:left;width:23%;"><jsp:include page="Left.jsp"></jsp:include></div>
  		<div id="main" style="float:right;width:75%"><jsp:include page="Main.jsp"></jsp:include></div>
  		<div><jsp:include page="Bottom.jsp"></jsp:include></div>
  	</div>
  </body>
</html>
