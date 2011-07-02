<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    <jsp:useBean  id="pageCon" class="com.cms.struts.ent.PageConctrl" scope="session">
    </jsp:useBean>
    <jsp:setProperty name="pageCon" property="curPage" value="1" />
    <jsp:setProperty name="pageCon" property="maxItems" value="20"/>
    
    <jsp:forward page="main.jsp"></jsp:forward>
  </body>
</html>
