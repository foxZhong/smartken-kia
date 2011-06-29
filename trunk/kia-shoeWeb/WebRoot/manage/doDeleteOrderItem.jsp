<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="shoes.entity.OrderItem"%>


<% 
	 int cid=Integer.parseInt(request.getParameter("cId"));
    List items=(List)session.getAttribute("items");
    for(int i=0;i<items.size();i++)
    {
      OrderItem oi=(OrderItem)items.get(i);
       if(oi.getItemCid()==cid)
       items.remove(i);
    }
    session.setAttribute("items",items);
	response.sendRedirect("../myCar.jsp");	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
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
