<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
</head>

<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>
<body>
      <sql:query var="messages" dataSource="${con}">
         SELECT mes_id, mes_title, mes_fromid,
         (select u_realname from users where u_id=mes_fromid) as fromername
          FROM sys_message where mes_toid=? or mes_ispublic=1 order by mes_time desc limit 0,5;
         <sql:param value='${user.uid}'></sql:param>
      </sql:query>
      <p style="margin:0px; padding:5px 0px 5px 2px;
	font-weight:bold; font-size:20;
	color:#014e68;">消息通知:</p>
      <marquee direction="right" onmouseover="this" scrolldelay="150">
      <c:forEach var="mesRow" items="${messages.rows}">
       <a href="../main/main.jsp">${mesRow.fromername}:${mesRow.mes_title }</a>&nbsp;&nbsp;
      </c:forEach>
      </marquee>
     <hr width="100%"/>
</body>
</html>
