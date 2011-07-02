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
    <div id="list">
   	<h4><span>公告栏</span></h4>
   	<sql:query var="messages" dataSource="${con}">
   	    SELECT *,
   	    (select u_realname from users where u_id=mes_fromid) as fromname
   	     FROM sys_message where mes_isPublic=1 or mes_toid=? order by mes_time desc limit 0,5;
   	     <sql:param value='${user.uid}'></sql:param>
   	</sql:query>
   	<c:forEach var="mesRow" items="${messages.rows}">
   	    <p class="date">${mesRow.mes_title }---
   	    ${mesRow.mes_time }  </p>
   	    <p class="date"> 发布人：${mesRow.fromname } </p>
   	    <p class="date"> 详细内容:</p>
   	    &nbsp;&nbsp;&nbsp;${mesRow.mes_context }
   	    <p class="more"><a href="#">more</a></p>
   	    <hr>
   	</c:forEach>
				
				
				
			<h4><span>前沿技术</span></h4>
				<p class="date">2007.4.1</p>
				<ul>
					<li><a href="#">清华大学电子工程系牛人做报告，气氛融洽</a></li>
					<li><a href="#">晾衣杆实现高增益、高信噪比波束自动成形天线</a></li>
				</ul>
				<p class="more"><a href="#">more</a></p>
			<h4><span>资源下载</span></h4>
				<p class="date">2006.12.7</p>
				<ul>
					<li><a href="#">时时语音和图象处理功能的纸箱</a></li>
					<li><a href="#">自动收发装置更新，电力充足</a></li>
				</ul>
				<p class="more"><a href="#">more</a></p>
		
     </div>
</body>
</html>
