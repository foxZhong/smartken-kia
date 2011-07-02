<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@page import="com.cms.struts.ent.UserBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>管理用户权限</title>
</head>
<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>

 <sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'F2' and u_id=?;
	           <sql:param value='${user.uid}'></sql:param>
	        </sql:query>
   <c:forEach var="gRow" items="${grant.rows}">
     <c:if test="${gRow.fcount==0}">
        <jsp:forward page="../main/errorGrant.jsp"></jsp:forward>
     </c:if>
   </c:forEach>
<body>
<div id="container">
	<div id="globallink">
		<jsp:include page="../parts/globallink.jsp"></jsp:include>
	</div>
	<div id="left">
		<jsp:include page="../parts/left.jsp"></jsp:include>
	</div>
	<div id="main">
		<div id="banner"><img src="../images/banner.jpg" border="0"></div>
		<div id="hottest">
			<jsp:include page="../parts/hottest.jsp"></jsp:include>
		</div>
		<!-- 可编辑区 -->
		配置管理 -> 管理用户权限
		<script type="text/javascript">
		    function doEdit()
		    {
		      return confirm("温馨提示：修改角色限权会影响其他用户操作，确认修改吗？");
		    
		    }
		    function doCheckBox(b)
		    {
		       var gs=document.getElementsByName("grants");
		       for(var i=0;i<gs.length;i++)
		       {
		         gs[i].checked=b;
		       }
		    }

		    function doChageUser()
		    {
			    document.getElementById("userForm").submit();
			 }
		</script>
		<sql:query var="users" dataSource="${con}">
		     select u_id,u_realname, 
		      (select opt_name from sys_dataoptions where u_roleid=opt_value and opt_dataid=8) as rolename 
		      from users;
		</sql:query>
		<form action="grant_userManage.jsp" method="get" id="userForm">
		选择用户 <select name="uId" onchange="doChageUser()">
		     <option>请选择...</option>
		   <c:forEach var="userRow" items="${users.rows}">
		     <option value="${userRow.u_id }">${userRow.u_realname }(${userRow.rolename })</option>
		   </c:forEach>
		</select>
		</form>
		<form action="../grantmanage" method="post" onsubmit="return doEdit()">
		
		<% UserBean ub=(UserBean)session.getAttribute("user");
		   int uid=ub.getUid();
		   if(request.getParameter("uId")!=null)
		       uid=Integer.parseInt(request.getParameter("uId"));
		 %>
		<input type="hidden" value="systemManage/grant_userManage.jsp" name="url"> 
		<input type="hidden" value="<%=uid %>" name="uId">
			<p>
		<sql:query var="user" dataSource="${con}">
		     select u_id,u_realname, 
		      (select opt_name from sys_dataoptions where u_roleid=opt_value and opt_dataid=8) as rolename 
		      from users where u_id=?;
		      <sql:param value='<%=uid %>'></sql:param>
		</sql:query>
		<c:forEach var="uRow" items="${user.rows}">
		<font color="red">当前用户:${uRow.u_realname}(${uRow.rolename })</font>
		</c:forEach>
	     	&nbsp;<input type="submit" value="保存" >
		&nbsp;<input type="button" value="全选" onclick="doCheckBox(true)">
		&nbsp;<input type="button" value="全否" onclick="doCheckBox(false)">
			<p>
		<sql:query var="models" dataSource="${con}">
		   SELECT * FROM sys_model;
		</sql:query>
		<table width="700">
		<c:forEach var="modRow" items="${models.rows}" varStatus="i">
		   <tr><td colspan="3"><h4>&nbsp;&nbsp;&nbsp;&nbsp;${i.index+1}.&nbsp;&nbsp;${modRow.m_desc }</h4></td></tr>
		   <sql:query var="functions" dataSource="${con}">
		     select f_id,f_name,f_grant from sys_function where f_mid=?;
		     <sql:param value='${modRow.m_id}'></sql:param>
		   </sql:query>
		  
		   <c:forEach var="funRow" items="${functions.rows}" varStatus="i">
		      <c:if test="${i.index%3==0}"><tr></c:if>
		     <td>
		     ${funRow.f_name}&nbsp;&nbsp;
		       <sql:query var="fungrant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where f_mid=? and f_id=? and u_grant regexp f_grant and u_id=?;
	           <sql:param value='${modRow.m_id}'></sql:param>
	             <sql:param value='${funRow.f_id}'></sql:param>
	           <sql:param value='<%=uid %>'></sql:param>
	           </sql:query>
	              <c:forEach var="fgRow" items="${fungrant.rows}" >
	                  <c:if test="${fgRow.fcount==1}">
	                    <input type="checkbox" name="grants" value="${funRow.f_grant }" checked="checked"/>
	                  </c:if>
	                  <c:if test="${fgRow.fcount==0}">
	                    <input type="checkbox" name="grants" value="${funRow.f_grant }"/>
	                  </c:if>
	              </c:forEach>
		     </td>
		        <c:if test="${i.index%3==2}"></tr></c:if>
		   </c:forEach>
		   <tr></tr>
		</c:forEach>
		</table>
		</form>
		<!-- 可编辑区end -->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
<div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
   </div>
</body>
</html>
