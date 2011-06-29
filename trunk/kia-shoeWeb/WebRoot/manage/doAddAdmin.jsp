<%@ page language="java" import="java.util.*,shoes.entity.*,shoes.dao.*,shoes.dao.impl.*" pageEncoding="gb2312"%>
<%
	request.setCharacterEncoding("gb2312");
	String UName = request.getParameter("adminName");
	String UPass = request.getParameter("adminPwdOne");
	UserInfoDao ui = new UserInfoDaoImpl();
	int result = ui.addAdmin(UName,UPass);
	if(result == 1) {
		out.println("添加成功!");
		response.sendRedirect("../BackOfficeAddAdmin.jsp");
	}else {
		out.println("<h1>添加失败!</h1>");	
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'doAddAdmin.jsp' starting page</title>
    
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
  </body>
</html>
