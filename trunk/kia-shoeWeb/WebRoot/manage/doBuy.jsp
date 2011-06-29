<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="shoes.entity.OrderItem"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
	if(session.getAttribute("user")!=null){
		int cId=Integer.parseInt(request.getParameter("cId"));
		int count=Integer.parseInt(request.getParameter("count"));
		double price=Double.parseDouble(request.getParameter("price"));
		List items=(List)session.getAttribute("items");
		//Iterator it=items.iterator();
		boolean isExist=false;
		int existid=0;
		for(int i=0;i<items.size();i++)
		{
		     OrderItem oi=(OrderItem)items.get(i);
		       if(oi.getItemCid()==cId)
		         {isExist=true;
		          existid=i; }
		}

		if(isExist==false)
		{
		   OrderItem oi=new OrderItem();
		   oi.setItemCount(count);
		   oi.setItemCid(cId);
		   oi.setItemPrice(price);
		   items.add(oi);
		}else
		{
		   OrderItem oi=(OrderItem)items.get(existid);
		   oi.setItemCount(oi.getItemCount()+count);
		   items.set(existid,oi);
		}
		session.setAttribute("items",items);
		response.sendRedirect("../myCar.jsp");
	}else{
		response.sendRedirect("../Login.jsp");
	} 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doBuy.jsp' starting page</title>
    
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
