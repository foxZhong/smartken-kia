<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�ޱ����ĵ�</title>
</head>
<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>
<body>
    <div id="list">
   	<h4><span>������</span></h4>
   	<sql:query var="messages" dataSource="${con}">
   	    SELECT *,
   	    (select u_realname from users where u_id=mes_fromid) as fromname
   	     FROM sys_message where mes_isPublic=1 or mes_toid=? order by mes_time desc limit 0,5;
   	     <sql:param value='${user.uid}'></sql:param>
   	</sql:query>
   	<c:forEach var="mesRow" items="${messages.rows}">
   	    <p class="date">${mesRow.mes_title }---
   	    ${mesRow.mes_time }  </p>
   	    <p class="date"> �����ˣ�${mesRow.fromname } </p>
   	    <p class="date"> ��ϸ����:</p>
   	    &nbsp;&nbsp;&nbsp;${mesRow.mes_context }
   	    <p class="more"><a href="#">more</a></p>
   	    <hr>
   	</c:forEach>
				
				
				
			<h4><span>ǰ�ؼ���</span></h4>
				<p class="date">2007.4.1</p>
				<ul>
					<li><a href="#">�廪��ѧ���ӹ���ϵţ�������棬������Ǣ</a></li>
					<li><a href="#">���¸�ʵ�ָ����桢������Ȳ����Զ���������</a></li>
				</ul>
				<p class="more"><a href="#">more</a></p>
			<h4><span>��Դ����</span></h4>
				<p class="date">2006.12.7</p>
				<ul>
					<li><a href="#">ʱʱ������ͼ�����ܵ�ֽ��</a></li>
					<li><a href="#">�Զ��շ�װ�ø��£���������</a></li>
				</ul>
				<p class="more"><a href="#">more</a></p>
		
     </div>
</body>
</html>
