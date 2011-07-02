<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>管理角色权限</title>
</head>
<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>
<sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'F1' and u_id=?;
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
		配置管理 -> 管理角色权限
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
		</script>
		<form action="../grantmanage" method="post" onsubmit="return doEdit()">
		<input type="hidden" value="systemManage/grant_roleManage.jsp" name="url"> 
		<sql:query var="roles" dataSource="${con}">
		     select opt_value,opt_name from sys_dataoptions where opt_dataid=8;
		</sql:query>
		选择角色 <select name="roleId">
		   <c:forEach var="rolRow" items="${roles.rows}">
		     <option value="${rolRow.opt_value }">${rolRow.opt_name }</option>
		   </c:forEach>
		</select>
		&nbsp;<input type="submit" value="保存" >
		&nbsp;<input type="button" value="全选" onclick="doCheckBox(true)">
		&nbsp;<input type="button" value="全否" onclick="doCheckBox(false)">
		
		<sql:query var="models" dataSource="${con}">
		   SELECT * FROM sys_model;
		</sql:query>
		<p>
		<table width="700">
		<c:forEach var="modRow"  items="${models.rows}" varStatus="i">
		   <tr><td colspan="3"> <h4>&nbsp;&nbsp;&nbsp;&nbsp;${i.index+1}.&nbsp;&nbsp;${modRow.m_desc }</h4></td></tr>
		   <sql:query var="functions" dataSource="${con}">
		     select f_id,f_name,f_grant from sys_function where f_mid=?;
		     <sql:param value='${modRow.m_id}'></sql:param>
		   </sql:query>
		   
		   <c:forEach var="funRow" items="${functions.rows}" varStatus="j">
		     <c:if test="${j.index%3==0}"><tr></c:if>
		     <td>${funRow.f_name}&nbsp;&nbsp;
		     <input type="checkbox" name="grants" value="${funRow.f_grant }"></td>
		     <c:if test="${j.index%3==2}"></tr></c:if>
		   </c:forEach>
		  
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
