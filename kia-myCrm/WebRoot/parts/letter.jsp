<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
</head>
   <script type="text/javascript" language="javascript">
      function doDiv(v)
      {
       //alert(v);
       var div=document.getElementById("users"+v);
       if(div.style.display=="none")
       div.style.display="block";
       else
       div.style.display="none";
      }
      
      function doSendMsg(id)
      {
        window.open("../main/doSendMessage.jsp?uId="+id,"发送内部信息",
        "toolbar=0,scrollbars=0,location=0,status=0,,menubar=0,resizable=0,width=640,height=480");
        
      }
      
   </script>

   <sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>
<body>
     <div id="letter" style="background-color:#CCCCCC ">
	        <h4><span>用户列表</span></h4>
	       <sql:query var="roles" dataSource="${con}">
	       SELECT opt_name,opt_value FROM sys_dataoptions where opt_dataid=8;
	       </sql:query>
	       <c:forEach var="roleRow" items="${roles.rows}">
	         <p class="date2" onclick="doDiv(${roleRow.opt_value})">${roleRow.opt_name }</p>
	         <sql:query var="users" dataSource="${con}">
	           SELECT u_id,u_realname FROM users u where u_roleid=?;
	           <sql:param value='${roleRow.opt_value}'></sql:param>
	         </sql:query>
	           <div style="display:none;" id="users${roleRow.opt_value }">
	           <c:forEach var="userRow" items="${users.rows}">
	             <center><p class="content2"><a href="javascript:doSendMsg(${userRow.u_id })">${userRow.u_realname }</a></p></center>
	           </c:forEach>
	           </div>
	       </c:forEach>
			
		
			
		</div>
</body>
</html>
