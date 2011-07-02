<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>历史订单</title>
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
		<div id="banner"><img src="../images/banner.jpg" border="0"></div>
		<div id="hottest">
			<jsp:include page="../parts/hottest.jsp"></jsp:include>
		</div>
		 <!--编辑区-->
		 客户信息管理 > 客户信息 > 历史订单 > 订单明细<p>
		
		 	
		 	<%int id=Integer.parseInt(request.getParameter("orderId")); %>
		 	<sql:query var="cusorder" dataSource="${con}">
		 		select * from cusorder where order_id=?;
		 	<sql:param value='<%=id %>'></sql:param>
		 	</sql:query>
		 	<c:forEach var="cusRow" items="${cusorder.rows}">
		 	 <table cellpadding="0" cellspacing="0" border="1" align="center" width="700">
		 	<tr>
		 		<td colspan="4" align="right">
					<a href="javascript:history.go(-1)">返回</a>	
				</td>
		 	</tr>	
		 	<tr height="30">
		 		<td width="180" align="center" class="formTitleTd">订单编号</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">&nbsp;${cusRow.order_id}</td>
		 		<td  align="center" class="formTitleTd">日期</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">${cusRow.order_date}</td>
		 	</tr>
		 	<tr height="30">
		 		<td width="180" align="center" class="formTitleTd">送货地址</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">&nbsp;${cusRow.order_addr}</td>
		 		<td width="180" align="center" class="formTitleTd">总金额(元)</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">
		 			<sql:query var="sum" dataSource="${con}">
		 				select sum(item_price*item_count) as sumprice from cusorderitems where item_orderid=?;
		 				<sql:param value='${cusRow.order_id}'></sql:param>
		 			</sql:query>
		 		<c:forEach var="sumRow" items="${sum.rows}">
		 		&nbsp; ${sumRow.sumprice}
		 	
		 		</td>
		 	</tr>
		 	<tr height="30">
		 		<td width="180" align="center" class="formTitleTd">状态</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">&nbsp;
		 			<c:if test="${cusRow.order_state==0 }">未处理</c:if>
		 			<c:if test="${cusRow.order_state==1 }">已处理</c:if>
		 		</td>
		 		<td width="180" align="center" class="formTitleTd">&nbsp;</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">&nbsp;
				</td>
		 	</tr>
		 	</c:forEach>
		 	<tr>
		 		<td colspan="6">&nbsp;</td>
		 	</tr>
		 </table>
		 <table cellpadding="0" cellspacing="0" border="1" align="center" width="700">
			<tr class="listTitleTR" height="25">
		 		<td width="150" align="center">商品</td>
		 		<td width="150" align="center">数量</td>
		 		<td width="70" align="center">单位</td>
		 		<td width="144" align="center">单价(元)</td>
		 		
		 		<td width="144" align="center">金额(元)</td>
		 	</tr>
		 	<sql:query var="produces" dataSource="${con}">
		 	select prod_name,prod_unit,item_id,item_count,item_price,(item_count*item_price) as sumprice
             from produces,cusorderitems
                where  prod_id=item_prodid and item_orderid=?;
		 	 <sql:param value='${cusRow.order_id}'></sql:param>
		 	</sql:query>
		 	
		 	<c:forEach var="prodRow" items="${produces.rows}">
		 		<tr align="center" valign="middle" class="listTrMouseOut" 
		 			onMouseOver="this.className='listTrMouseOver'" 
		 			onMouseOut="this.className='listTrMouseOut'">
		 			<td>${prodRow.prod_name }</td>
		 			<td>${prodRow.item_count}</td>
		 			<td>${prodRow.prod_unit }</td>
		 			<td>${prodRow.item_price}</td>
		 			<td>${prodRow.sumprice}</td>
		 		</tr>
		 	</c:forEach>
		 	
		</table>
			</c:forEach>
		 <!--编辑区-->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
<div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
</div>
</body>
</html>
