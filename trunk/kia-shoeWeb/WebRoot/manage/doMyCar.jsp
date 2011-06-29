<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<% 
	if(session.getAttribute("user")!=null){
		response.sendRedirect("../myCar.jsp");
	}else{
		response.sendRedirect("../Login.jsp");
	} 
%>

