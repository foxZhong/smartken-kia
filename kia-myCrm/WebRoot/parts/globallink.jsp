<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�ޱ����ĵ�</title>
</head>

<body>
    
         <ul>
			<li>��ǰ�û�: ${user.urealname } (${user.urole })</li>
			<li><a href="../main/main.jsp">��ҳ</a></li>
			<li><a href="../logout">�˳�ϵͳ</a></li>
		</ul>
		
		<br>
</body>
</html>
