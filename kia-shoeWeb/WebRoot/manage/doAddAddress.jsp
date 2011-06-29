<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:directive.page import="shoes.dao.DeliveryInfoDao"/>
<jsp:directive.page import="shoes.dao.impl.DeliveryInfoDaoImpl"/>
<%
	request.setCharacterEncoding("gb2312");
	int DUId = Integer.parseInt(request.getParameter("DUId"));
	String Name = request.getParameter("Name");
	String Tel = request.getParameter("Tel");
	String Address = request.getParameter("Address");
	DeliveryInfoDao info = new DeliveryInfoDaoImpl();
	int result = info.addAddress(DUId,Name,Tel,Address);
	if(result == 1){
		out.println("修改成功！");
		response.sendRedirect("../AddAddress.jsp");
	}else{
		out.print("<h1>修改失败!</h1>");
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'doAddAddress.jsp' starting page</title>
    
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
