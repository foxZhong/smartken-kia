<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>确认流失</title>
</head>

<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>

 <sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'B2' and u_id=?;
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
		 <!--编辑区-->
		 客户流失管理 > 确认流失<p>
		
		 	
		 	<%int id=Integer.parseInt(request.getParameter("cusId")); %>
		 	<sql:query var="customer" dataSource="${con}">
		 		select *,
         		(select staff_name from cusstaff  where staff_id=cus_manid) as manager
         		from customers where cus_id=?
		 	<sql:param value="<%=id %>"></sql:param>
		 	</sql:query>
		 	<c:forEach var="cusRow" items="${customer.rows}">
		 	<a href="javascript:history.go(-1)">返回</a>
		 	 <table cellpadding="0" cellspacing="0" border="1" align="center" width="700">
		 	
		 	<tr height="30">
		 		<td width="180" align="center" class="formTitleTd">编号</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">&nbsp;
					${cusRow.cus_id}
				</td>
		 		<td width="180" align="center" class="formTitleTd">客户</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">&nbsp;
					${cusRow.cus_name}
				</td>
		 	</tr>
		 	<tr height="30">
		 		<td width="180" align="center" class="formTitleTd">客户经理</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">&nbsp;
					${cusRow.manager}
				</td>
		 		<td width="180" align="center" class="formTitleTd">上次下单时间</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">&nbsp;
					<sql:query var="cusorder" dataSource="${con}">
		 				 SELECT order_date FROM cusorder
						 where order_cusid=? and order_state=0 order by order_date desc;
						 <sql:param value='${cusRow.cus_id}'></sql:param> 
		 				</sql:query>
		 				<c:forEach var="corRow" items="${cusorder.rows}">
		 					${corRow.order_date }
		 				</c:forEach>
				</td>
		 	</tr>
		 	<tr height="30">
		 		<td width="180" align="center" class="formTitleTd">暂缓措施</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'" colspan="3">${cusRow.cus_losedelay }
				</td>
		 	</tr>
		 	<html:form action="/customerManage/customer" method="post">
		 	<input name="oper" value="doConfirmBleed" type="hidden">
		 	<html:hidden property="customers.cusId" value="${cusRow.cus_id}"/>
		 	<tr height="30">
		 		<td width="180" align="center" class="formTitleTd">流失原因</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'" colspan="3">&nbsp;
					<html:textarea property="customers.cusLoseinfo" cols="50" rows="3" value="${cusRow.cus_loseinfo }"></html:textarea>
		 			<input type="submit" value="提交">
		 			<font color="red"/>*
		 		</td>
		 	</tr>
		 	</html:form>
		 	</c:forEach>
		 	<tr>
		 		<td colspan="6">&nbsp;</td>
		 	</tr>
		 </table>
		 <!--编辑区-->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
<div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
</div>
<html:errors property="info"/>
</body>
</html>
