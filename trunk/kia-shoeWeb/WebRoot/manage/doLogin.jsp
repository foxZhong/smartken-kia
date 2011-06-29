<%@ page language="java" import="java.util.*,shoes.dao.impl.*,shoes.dao.*,shoes.entity.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
	request.setCharacterEncoding("GBK");
	String userName = request.getParameter("userName");
	String passWord = request.getParameter("passWord");
	
	UserInfoDao userDao = new UserInfoDaoImpl();
	UserInfo userInfo = new UserInfo();
	userInfo = userDao.findUser(userName,passWord);
	if(userInfo!=null){
		if(userInfo.getULevel().equals("admin")){
			{
			
			response.sendRedirect("../BackOfficeSystem.jsp");
			}
		}else{
		    //session.setAttribute("order",new Orders);
		    List items=new ArrayList();
		    session.setAttribute("items",items);
		    session.setAttribute("user",userInfo);
			response.sendRedirect("../index.jsp");
		}
	}else{
		response.sendRedirect("../error/LoginError.jsp");
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>doLogin</title>
    
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
