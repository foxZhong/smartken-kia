<%@ page language="java" import="java.util.*,shoes.entity.*,shoes.dao.*,shoes.dao.impl.*" pageEncoding="gb2312"%>
<%
	request.setCharacterEncoding("gb2312");
	int OId = Integer.parseInt(request.getParameter("OId"));
	OrdersDao od = new OrdersDaoImpl();
	od.updateOState(OId);
	response.sendRedirect("../BackOfficeSystem.jsp");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'doOrders.jsp' starting page</title>
    
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
  </body>
</html>
