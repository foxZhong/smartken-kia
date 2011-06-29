<%@ page language="java" import="java.util.*,shoes.entity.*" pageEncoding="GB18030"%>
<jsp:directive.page import="shoes.dao.UserInfoDao"/>
<jsp:directive.page import="shoes.dao.impl.UserInfoDaoImpl"/>
<%
	String pass1 = request.getParameter("pass1");
	String pass2 = request.getParameter("pass2");
	int uId = Integer.parseInt(request.getParameter("uId"));
	String uName = request.getParameter("uName");
	UserInfoDao uDao = new UserInfoDaoImpl();
	if(pass1.equals(uDao.findUser(uId).getUPass())){
		UserInfo uInfo =  new UserInfo();
		uInfo.setUName(uName);
		uInfo.setUPass(pass2);
		uDao.updateUser(uInfo);
		out.print("<script type='text/javascript'>alert('修改成功！');history.go(-1);</script>");
	}else{
		out.print("<script type='text/javascript'>alert('修改失败！密码错误！');history.go(-1);</script>");
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'doUpdateUser.jsp' starting page</title>
    
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
