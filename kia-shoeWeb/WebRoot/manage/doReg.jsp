<%@ page language="java" import="java.util.*,shoes.entity.*,shoes.dao.*,shoes.dao.impl.*" pageEncoding="gb2312"%>
<%
	request.setCharacterEncoding("gb2312");
	
	String userName = request.getParameter("userName");
	String pwdOne = request.getParameter("pwdOne");
	String txtSurname = request.getParameter("txtSurname");
	String txtPhone = request.getParameter("txtPhone");
	String txtAddress = request.getParameter("txtAddress");
	String s1 = request.getParameter("txtmask");
    String s2 = (String)(session.getAttribute("sRand"));
    out.println(s1);
    out.println(s2);
	
	int x = 0;
	UserInfo ui = null;
	UserInfoDao uid = new UserInfoDaoImpl();
	
	List list = uid.findAllUser();
	for(int i=0; i<list.size(); i++) {
		ui = (UserInfo)list.get(i);
		if(userName.equals(ui.getUName())) {
			out.println("用户名已存在,注册失败!");
			x = 1;
			break;
		}
	}
	if(x==0) {
		if(s1.equalsIgnoreCase(s2)){
			ui = new UserInfo(userName,pwdOne,"guest");	
			int result1 = uid.addUser(ui);
			DeliveryInfo di = new DeliveryInfo(uid.findUser(userName,pwdOne).getUId(),txtSurname,txtPhone,txtAddress);
			DeliveryInfoDao did = new DeliveryInfoDaoImpl();
			int result2 = did.addDeliveryInfo(di);
    		if(result1==1 && result2==1) {
				ui = uid.findUser(userName,pwdOne);
				if(ui!=null){
				    session.setAttribute("user",ui);
					response.sendRedirect("../index.jsp");			
				}
			}else {
				out.println("注册失败!");
			}
    	}else{
    		out.print("<script type='text/javascript'>alert('验证码错误！');history.go(-1);</script>");
    	}
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>doReg.jsp</title>
    
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
