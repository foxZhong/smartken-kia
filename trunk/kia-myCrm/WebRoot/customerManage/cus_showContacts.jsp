<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link href="../css/18.css" rel="stylesheet" type="text/css">
		<title>联系人</title>
	</head>
	<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>
   <sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'B1' and u_id=?;
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
				<div id="banner">
					<img src="../images/banner.jpg" border="0">
				</div>
				<div id="hottest">
					<jsp:include page="../parts/hottest.jsp"></jsp:include>
				</div>
				<!--编辑区-->
				客户信息管理 > 客户信息 > 联系人<p>
				<%int id = Integer.parseInt(request.getParameter("cusId"));%>	
				<sql:query var="customer" dataSource="${con}">
		 				select * from customers where cus_id=?
		 			<sql:param value="<%=id%>"></sql:param>
				</sql:query>
				<c:forEach var="cusRow" items="${customer.rows}">
				<table cellpadding="0" cellspacing="0" border="1" align="center" width="700">
					<tr>
						<td colspan="4" align="right">
		 					<a href="cus_record.jsp?cusId=${cusRow.cus_id}">交往记录</a>	
		 					<a href="cus_showOrders.jsp?cusId=${cusRow.cus_id}">历史订单</a>
							<a href="cus_manage.jsp?cusId=${cusRow.cus_id}">返回</a>	
						</td>
		 			</tr>
					<tr height="30">
						<td width="180" align="center" class="formTitleTd">客户编号</td>
						<td width="150" class="formTdMouseOut" 
		 					onMouseOver="this.className='formTdMouseOver'" 
		 					onMouseOut="this.className='formTdMouseOut'">&nbsp;
							${cusRow.cus_id}
						</td>
						<td width="180" align="center" class="formTitleTd">客户名称</td>
						<td width="150" class="formTdMouseOut" 
		 					onMouseOver="this.className='formTdMouseOver'" 
		 					onMouseOut="this.className='formTdMouseOut'">&nbsp;
							${cusRow.cus_name}
						</td>
					</tr>
					<tr>
						<td colspan="6">&nbsp;</td>
					</tr>
				</table>
				
				<table cellpadding="0" cellspacing="0" border="1" align="center" width="700">
					<tr height="25" class="listTitleTR">
						<td width="50" align="center">姓名</td>
						<td width="50" align="center">性别</td>
						<td width="100" align="center">职位</td>
						<td width="130" align="center">办公电话</td>
						<td width="130" align="center">手机</td>
						<td width="94" align="center">备注</td>
						<td width="100" align="center">操作</td>
					</tr>
					<sql:query var="cusstaff" dataSource="${con}">
		 				select * from cusstaff where staff_cusid=?;
						<sql:param value="${cusRow.cus_id}"></sql:param>
						</sql:query>
					<c:forEach var="csaRow" items="${cusstaff.rows}">	
						<tr align="center" valign="middle" class="listTrMouseOut" 
		 					onMouseOver="this.className='listTrMouseOver'" 
		 					onMouseOut="this.className='listTrMouseOut'">
							<td>${csaRow.staff_name }</td>
							<td>${csaRow.staff_sex }</td>
							<td>${csaRow.staff_job }</td>
							<td>${csaRow.staff_phone }</td>
							<td>${csaRow.staff_tel}</td>
							<td>${csaRow.staff_remark}</td>
							<td>
		 						<table border="0">
		 							<tr>
		 								<td>
											<a href="customer.do?oper=delCusstaff&staId=${csaRow.staff_id}&cusId=${csaRow.staff_cusid }">删除</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>							
					</c:forEach>
				</table>
		
				<html:form action="/customerManage/customer" method="post">
				<html:hidden property="cusstaff.staffCusid" value="${cusRow.cus_id}"/>
				<table cellpadding="0" cellspacing="0" border="1" align="center" width="700">
					<tr>
						<td colspan="6" align="right">
							<input name="oper" type="hidden" value="addCusstaff" />
							<input type="submit" value="新建联系人" />
						</td>
					</tr>
					<tr height="30">
						<td width="180" align="center" class="formTitleTd">姓名</td>
						<td width="150" class="formTdMouseOut" 
		 					onMouseOver="this.className='formTdMouseOver'" 
		 					onMouseOut="this.className='formTdMouseOut'"/>&nbsp;
		 					<html:text property="cusstaff.staffName" size="15" />
							<font color="red" />* 
						</td>
						<td width="180" align="center" class="formTitleTd">性别</td>
						<td width="150" class="formTdMouseOut" 
		 					onMouseOver="this.className='formTdMouseOver'" 
		 					onMouseOut="this.className='formTdMouseOut'"/>
							<html:radio property="cusstaff.staffSex" value="男">男</html:radio>
							<html:radio property="cusstaff.staffSex" value="女">女</html:radio>
						</td>
					</tr>
					<tr height="30">
						<td width="180" align="center" class="formTitleTd">职位</td>
						<td width="150" class="formTdMouseOut" 
		 					onMouseOver="this.className='formTdMouseOver'" 
		 					onMouseOut="this.className='formTdMouseOut'"/>&nbsp;
							<html:text property="cusstaff.staffJob" size="15" />
							<font color="red" />* 
						</td>
						<td width="180" align="center" class="formTitleTd">办公电话</td>
						<td width="150" class="formTdMouseOut" 
		 					onMouseOver="this.className='formTdMouseOver'" 
		 					onMouseOut="this.className='formTdMouseOut'"/>&nbsp;
							<html:text property="cusstaff.staffPhone" size="15" />
							<font color="red" />* 
						</td>
					</tr>
					<tr height="30">
						<td width="180" align="center" class="formTitleTd">手机</td>
						<td width="150" class="formTdMouseOut" 
		 					onMouseOver="this.className='formTdMouseOver'" 
		 					onMouseOut="this.className='formTdMouseOut'"/>&nbsp;
							<html:text property="cusstaff.staffTel" size="15" />
						</td>
						<td width="180" align="center" class="formTitleTd">备注</td>
						<td width="150" class="formTdMouseOut" 
		 					onMouseOver="this.className='formTdMouseOver'" 
		 					onMouseOut="this.className='formTdMouseOut'"/>&nbsp;
							<html:text property="cusstaff.staffRemark" size="15" />
						</td>
					</tr>
				</table>
				</html:form>
				</c:forEach>
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
