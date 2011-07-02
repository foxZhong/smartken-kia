<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<link href="../css/18.css" rel="stylesheet" type="text/css">
	<title>客户信息</title>
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
客户信息管理 > 客户信息<p>
<table cellpadding="0" cellspacing="0" border="1" align="center" width="700">
	
	<%int id = Integer.parseInt(request.getParameter("cusId"));%>
	<sql:query var="customer" dataSource="${con}">
		select *,
        (select staff_name from cusstaff  where staff_id=cus_manid) as manager
        from customers where cus_id=?
	<sql:param value="<%=id%>"></sql:param>
	</sql:query>
	<c:forEach var="cusRow" items="${customer.rows}">
	<tr>
		<td colspan="4" align="right">
			<a href="cus_showContacts.jsp?cusId=${cusRow.cus_id}">联系人</a>	
		 	<a href="cus_record.jsp?cusId=${cusRow.cus_id}">交往记录</a>	
		 	<a href="cus_showOrders.jsp?cusId=${cusRow.cus_id}">历史订单</a>
		 	<a href="cus_showCustomer.jsp">返回</a>	
		</td>
	</tr>
	<html:form action="/customerManage/customer">
	<tr>
		<td width="180" align="center" class="formTitleTd">
			客户编号
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			${cusRow.cus_id}
		</td>
		<td width="180" align="center" class="formTitleTd">
			名称
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
		<html:text property="customers.cusName" value="${cusRow.cus_name }" size="15"/>
		<font color="red" />* 
		</td>
	</tr>
	<tr>
		<td width="180" align="center" class="formTitleTd">
			地区
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:select property="customers.cusArea">
				<sql:query var="areas" dataSource="${con}">
					SELECT opt_name,opt_value FROM sys_dataoptions where opt_dataid=3;
				</sql:query>
				<c:forEach var="areaRow" items="${areas.rows}">
					<c:if test="${areaRow.opt_value==cusRow.cus_area}">
						<option value="${areaRow.opt_value }" selected="selected">${areaRow.opt_name }</option>
					</c:if>
					<c:if test="${areaRow.opt_value!=cusRow.cus_area}">
						<option value="${areaRow.opt_value }">${areaRow.opt_name }</option>
					</c:if>
				</c:forEach>
			</html:select>
			<font color="red" />* 
		</td>
		<td width="180" align="center" class="formTitleTd">
			客户经理
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:select property="customers.cusManid">
				<sql:query var="manager" dataSource="${con}">
					select * from cusstaff where staff_cusid=?;
				<sql:param value="${cusRow.cus_id}"></sql:param>
				</sql:query>
				<c:forEach var="manRow" items="${manager.rows}">
					<c:if test="${manRow.staff_id==cusRow.cus_manid}">
						<option value="${manRow.staff_id }" selected="selected">${manRow.staff_name }</option>
					</c:if>
					<c:if test="${manRow.staff_id!=cusRow.cus_manid}">
						<option value="${manRow.staff_id }">${manRow.staff_name }</option>
					</c:if>
				</c:forEach>
			</html:select>
			<font color="red" />* 
		</td>
	</tr>
	<tr>
		<td width="180" align="center" class="formTitleTd">
			客户等级
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:select property="customers.cusLevel">
				<sql:query var="levels" dataSource="${con}">
					SELECT opt_name,opt_value FROM sys_dataoptions where opt_dataid=1;
				</sql:query>
				<c:forEach var="levelRow" items="${levels.rows}">
					<c:if test="${levelRow.opt_value==cusRow.cus_level}">
						<option value="${levelRow.opt_value }" selected="selected">${levelRow.opt_name }</option>
					</c:if>
					<c:if test="${levelRow.opt_value!=cusRow.cus_level}">
						<option value="${levelRow.opt_value }">${levelRow.opt_name }</option>
					</c:if>
				</c:forEach>
			</html:select>
			<font color="red" />* 
		</td>
		<td width="180" align="center" class="formTitleTd">
			状态
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:select property="customers.cusStatus">
				<sql:query var="status" dataSource="${con}">
					SELECT opt_name,opt_value FROM sys_dataoptions where opt_dataid=12;
				</sql:query>
				<c:forEach var="statusRow" items="${status.rows}">
					<c:if test="${statusRow.opt_value==cusRow.cus_status}">
						<option value="${statusRow.opt_value }" selected="selected">${statusRow.opt_name }</option>
					</c:if>
					<c:if test="${statusRow.opt_value!=cusRow.cus_status}">
						<option value="${statusRow.opt_value }">${statusRow.opt_name }</option>
					</c:if>
				</c:forEach>
			</html:select>
			<font color="red" />* 
		</td>
	</tr>
	<tr>
		<td width="180" align="center" class="formTitleTd">
			客户满意度
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:select property="customers.cusContentment">
				<sql:query var="levels" dataSource="${con}">
					SELECT opt_name,opt_value FROM sys_dataoptions where opt_dataid=4;
				</sql:query>
				<c:forEach var="levelRow" items="${levels.rows}">
					<c:if test="${levelRow.opt_value==cusRow.cus_contentment}">
						<option value="${levelRow.opt_value }" selected="selected">${levelRow.opt_name }</option>
					</c:if>
					<c:if test="${levelRow.opt_value!=cusRow.cus_contentment}">
						<option value="${levelRow.opt_value }">${levelRow.opt_name }</option>
					</c:if>
				</c:forEach>
			</html:select>
			<font color="red" />* 
		</td>
		<td width="180" align="center" class="formTitleTd">
			客户信用度
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:select property="customers.cusCredit">
				<sql:query var="levels" dataSource="${con}">
					SELECT opt_name,opt_value FROM sys_dataoptions where opt_dataid=4;
				</sql:query>
				<c:forEach var="levelRow" items="${levels.rows}">
					<c:if test="${levelRow.opt_value==cusRow.cus_credit}">
						<option value="${levelRow.opt_value }" selected="selected">${levelRow.opt_name }</option>
					</c:if>
					<c:if test="${levelRow.opt_value!=cusRow.cus_credit}">
						<option value="${levelRow.opt_value }">${levelRow.opt_name }</option>
					</c:if>
				</c:forEach>
			</html:select>
			<font color="red" />* 
		</td>
	</tr>
	<tr>
		<td colspan="4">
			&nbsp;
		</td>
	</tr>
	<tr>
		<td width="180" align="center" class="formTitleTd">
			地址
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:text property="customers.cusAddress" 
				value="${cusRow.cus_address }" size="15"/>
			<font color="red" />* 
		</td>
		<td width="180" align="center" class="formTitleTd">
			邮政编码
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:text property="customers.cusPostalcode"
			 	value="${cusRow.cus_postalcode }" size="15"/>
			<font color="red" />* 
		</td>
	</tr>
	<tr>
		<td width="180" align="center" class="formTitleTd">
			电话
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:text property="customers.cusTel"
				value="${cusRow.cus_tel }" size="15"/>
			<font color="red" />* 
		</td>
		<td width="180" align="center" class="formTitleTd">
			传真
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:text property="customers.cusFax"
				value="${cusRow.cus_fax }" size="15"/>
			<font color="red" />* 
		</td>
	</tr>
	<tr>
		<td width="180" align="center" class="formTitleTd">
			网址
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:text property="customers.cusSite"
				value="${cusRow.cus_site }" size="15"/>
			<font color="red" />* 
		</td>
		<td width="180" align="center" class="formTitleTd">
			&nbsp;
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">
			&nbsp;
		</td>
	</tr>
	<tr>
		<td colspan="4">
			&nbsp;
		</td>
	</tr>
	<tr>
		<td width="180" align="center" class="formTitleTd">
			营业执照注册号
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:text property="customers.cusEnrol"
				value="${cusRow.cus_enrol }" size="15"/>
			<font color="red" />* 
		</td>
		<td width="180" align="center" class="formTitleTd">
			法人
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:text property="customers.cusCorporation"
				value="${cusRow.cus_corporation }" size="15"/>
			<font color="red" />* 
		</td>
	</tr>
	<tr>
		<td width="180" align="center" class="formTitleTd">
			注册资金(万元)
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:text property="customers.cusBankroll"
				value="${cusRow.cus_bankroll }" size="15"/>
			<font color="red" />* 
		</td>
		<td width="180" align="center" class="formTitleTd">
			年营业额
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:text property="customers.cusTurnover"
				value="${cusRow.cus_turnover }" size="15"/>
			<font color="red" />* 
		</td>
	</tr>
	<tr>
		<td width="180" align="center" class="formTitleTd">
			开户银行
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:text property="customers.cusBank"
				value="${cusRow.cus_bank }" size="15"/>
			<font color="red" />* 
		</td>
		<td width="180" align="center" class="formTitleTd">
			银行帐号
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:text property="customers.cusBankAccouts"
				value="${cusRow.cus_bankAccouts }" size="15"/>
			<font color="red" />* 
		</td>
	</tr>
	<tr>
		<td width="180" align="center" class="formTitleTd">
			地税登记号
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:text property="customers.cusTerraTax"
				value="${cusRow.cus_terraTax }" size="15"/>
			<font color="red" />* 
		</td>
		<td width="180" align="center" class="formTitleTd">
			国税登记号
		</td>
		<td width="150" class="formTdMouseOut" 
		 	onMouseOver="this.className='formTdMouseOver'" 
		 	onMouseOut="this.className='formTdMouseOut'">&nbsp;
			<html:text property="customers.cusCountryTax"
				value="${cusRow.cus_countryTax }" size="15"/>
			<font color="red" />* 
		</td>
	</tr>
	<tr>
		<td colspan="4">
			&nbsp;
		</td>
	</tr>
	<tr align="center">
		<td colspan="4">
			<html:hidden property="customers.cusId" value="${cusRow.cus_id }" />
			<input name="oper" type="hidden" value="updateCustomers" />
			<html:submit>保存</html:submit>
		</td>
	</tr>
	</html:form>
	</c:forEach>
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
