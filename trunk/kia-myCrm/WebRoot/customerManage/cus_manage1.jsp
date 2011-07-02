<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>客户信息</title>
</head>
<sql:setDataSource driver="com.mysql.jdbc.Driver" 
		 		  url="jdbc:mysql://localhost:3306/mycms" user="root"
		 		  password="sa" var="con"/>


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
		 <table cellpadding="0" cellspacing="0" border="1" align="center" bordercolor="#00FFFF">
		 	<tr>
		 		<td colspan="4"><hr>客户信息管理 > 客户信息</td>
		 	</tr>
		 	<%int id=Integer.parseInt(request.getParameter("cusId")); %>
		 	<sql:query var="customer" dataSource="${con}">
		 		select * from customers where cus_id=?
		 	<sql:param value="<%=id %>"></sql:param>
		 	</sql:query>
		 	<c:forEach var="cusRow" items="${customer.rows}">	
		 	<tr>
		 		<td colspan="4" align="right">
		 			<table>
		 				<tr>
		 					<td>
		 						<form action="">
		 						<input type="hidden" name="cusId"/>
		 						<input type="button" value="帮助"/>
		 						</form>
		 					</td>
		 					<td>
		 						<form action="cus_showContacts.jsp">
		 						<input type="hidden" value="${cusRow.cus_id}" name="cusId"/>
		 						<input type="submit" value="联系人"/>
		 						</form>
		 					</td>
		 					<td>
		 						<form action="cus_record.jsp">
		 						<input type="hidden" value="${cusRow.cus_id}" name="cusId"/>
		 						<input type="submit" value="交往记录"/>
		 						</form>
		 					</td>
		 					<td>
		 						<form action="cus_showOrders.jsp">
		 						<input type="hidden" value="${cusRow.cus_id}" name="cusId"/>
		 						<input type="submit" value="历史订单"/>
		 						</form>
		 					</td>
		 					<td>
		 						<form action="">
		 						<input type="hidden"/>
		 						<input type="button" value="返回"/>
		 						</form>
		 					</td>
		 					<td>
		 						<form action="">
		 						<input type="hidden" name="cusId"/>
		 						<input type="button" value="保存"/>
		 						</form>
		 					</td>
		 				</tr>
		 			</table>
		 		</td>
		 	</tr>
		 	<tr>
		 		<td width="180" align="center" bgcolor="#339999">客户编号</td>
		 		<td width="150" bgcolor="#CCFFCC">${cusRow.cus_code}</td>
		 		<td width="180" align="center" bgcolor="#339999">名称</td>
		 		<td width="150" bgcolor="#CCFFCC">&nbsp;<input type="text" value="${cusRow.cus_name}" size="15"/><font color="red"/>*</td>
		 	</tr>
		 	<tr>
		 		<td width="180" align="center" bgcolor="#339999">地区</td>
		 		<td width="150" bgcolor="#CCFFCC">
		 			&nbsp;<select name="select">
		 				<option value="1">全部</option>
		 				<option value="2">${cusRow.cus_area}</option>
		 			</select><font color="red"/>*
		 		</td>
		 		<td width="180" align="center" bgcolor="#339999">客户经理</td>
		 		<td width="150" bgcolor="#CCFFCC">
		 			&nbsp;<select name="select">
		 				<option value="1">全部</option>
		 				<option value="2">${cusRow.cus_manager }</option>
		 			</select><font color="red"/>*
		 		</td>
		 	</tr>
		 	<tr>
		 		<td width="180" align="center" bgcolor="#339999">客户等级</td>
		 		<td width="150" bgcolor="#CCFFCC">
		 			&nbsp;<select name="select">
		 				   <option value="1">请选择..</option>
		 				   <option value="2">${cusRow.cus_level }</option>
		 			</select><font color="red"/>*
		 		</td>
		 		<td width="180" align="center" bgcolor="#339999">&nbsp;</td>
		 		<td width="150" bgcolor="#CCFFCC">&nbsp;</td>
		 	</tr>
		 	<tr>
		 		<td width="180" align="center" bgcolor="#339999">客户满意度</td>
		 		<td width="150" bgcolor="#CCFFCC">
		 			&nbsp;<select name="select">
		 				<option value="1">全部</option>
		 				<option value="2">${cusRow.cus_contentment }</option>
		 			</select><font color="red"/>*
		 		</td>
		 		<td width="180" align="center" bgcolor="#339999">客户信用度</td>
		 		<td width="150" bgcolor="#CCFFCC">
		 			&nbsp;<select name="select">
		 				<option value="1">全部</option>
		 				<option value="2">${cusRow.cus_credit }</option>
		 			</select><font color="red"/>*
		 		</td>
		 	</tr>
		 	<tr>
		 		<td colspan="6">&nbsp;</td>
		 	</tr>
		 	<tr>
		 		<td width="180" align="center" bgcolor="#339999">地址</td>
		 		<td width="150" bgcolor="#CCFFCC">
		 			&nbsp;<input type="text" value="${cusRow.cus_address }" size="15"><font color="red"/>*
		 		</td>
		 		<td width="180" align="center" bgcolor="#339999">邮政编码</td>
		 		<td width="150" bgcolor="#CCFFCC">
		 			&nbsp;<input type="text" value="${cusRow.cus_postalcode }" size="15"><font color="red"/>*
		 		</td>
		 	</tr>
		 	<tr>
		 		<td width="180" align="center" bgcolor="#339999">电话</td>
		 		<td width="150" bgcolor="#CCFFCC">
		 			&nbsp;<input type="text" value="${cusRow.cus_tel }" size="15"><font color="red"/>*
		 		</td>
		 		<td width="180" align="center" bgcolor="#339999">传真</td>
		 		<td width="150" bgcolor="#CCFFCC">
		 			&nbsp;<input type="text" value="${cusRow.cus_fax }" size="15"><font color="red"/>*
		 		</td>
		 	</tr>
		 	<tr>
		 		<td width="180" align="center" bgcolor="#339999">网址</td>
		 		<td width="150" bgcolor="#CCFFCC">
		 			&nbsp;<input type="text" value="${cusRow.cus_site }" size="15"><font color="red"/>*
		 		</td>
		 		<td width="180" align="center" bgcolor="#339999">&nbsp;</td>
		 		<td width="150" bgcolor="#CCFFCC">&nbsp;</td>
		 	</tr>
		 	<tr>
		 		<td colspan="6">&nbsp;</td>
		 	</tr>
		 	<tr>
		 		<td width="180" align="center" bgcolor="#339999">营业执照注册号</td>
		 		<td width="150" bgcolor="#CCFFCC">
		 			&nbsp;<input type="text" size="15">
		 		</td>
		 		<td width="180" align="center" bgcolor="#339999">法人</td>
		 		<td width="150" bgcolor="#CCFFCC">
		 			&nbsp;<input type="text" size="15"><font color="red"/>*
		 		</td>
		 	</tr>
		 	<tr>
		 		<td width="180" align="center" bgcolor="#339999">注册资金(万元)</td>
		 		<td width="150" bgcolor="#CCFFCC">
		 			&nbsp;<input type="text" size="15">
		 		</td>
		 		<td width="180" align="center" bgcolor="#339999">年营业额</td>
		 		<td width="150" bgcolor="#CCFFCC">
		 			&nbsp;<input type="text" size="15">
		 		</td>
		 	</tr>
		 	<tr>
		 		<td width="180" align="center" bgcolor="#339999">开户银行</td>
		 		<td width="150" bgcolor="#CCFFCC">
		 			&nbsp;<input type="text" size="15"><font color="red"/>*
		 		</td>
		 		<td width="180" align="center" bgcolor="#339999">银行帐号</td>
		 		<td width="150" bgcolor="#CCFFCC">
					&nbsp;<input type="text" size="15"><font color="red"/>*
				</td>
		 	</tr>
		 	<tr>
		 		<td width="180" align="center" bgcolor="#339999">地税登记号</td>
		 		<td width="150" bgcolor="#CCFFCC">
		 			&nbsp;<input type="text" size="15">
		 		</td>
		 		<td width="180" align="center" bgcolor="#339999">国税登记号</td>
		 		<td width="150" bgcolor="#CCFFCC">
					&nbsp;<input type="text" size="15">
				</td>
		 	</tr>
		 	</c:forEach>
		 	<tr>
		 		<td colspan="4"><hr></td>
		 	</tr>
		 </table>
		 <!--编辑区-->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
</body>
</html>
