<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>客户共享分析</title>
</head>

<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>
<sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'D1' and u_id=?;
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
		<table width="700"  border="1" cellpadding="3px" cellspacing="3px">
		 
		<div >客户贡献分析</div><p>

	    <script language="javascript">
	       function changeData()
	       {
	           document.getElementById("dataForm").submit();
	       }
   		</script>
   		
   	<form action="sta_showComposing.jsp" method="post" id="dataForm">
	<tr>
		<td class="formTitleTd">客户名称</td>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		 <input type="text" name="name"/>
		 <input type="button" value="搜索" onclick="changeData()">
		 </td>
		<td class="formTitleTd">年份</td>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
			<select name="year" onChange="changeData()">
				<sql:query var="years" dataSource="${con}">
				select EXTRACT(YEAR FROM order_date) as year from
				 cusorder group by EXTRACT(YEAR FROM order_date);
				</sql:query>
				<option value="0" selected="selected">全部</option>
				<c:forEach var="yearRow" items="${years.rows}">
					<option value="${yearRow.year}">${yearRow.year }</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	</form>
</table><p>

<table width="700"  border="1">
	<tr class="listTitleTR">
		<th>编号</th>
		<th>客户名称</th>
		<th>订单金额（元）</th>
	</tr>
	<c:if test="${requestScope.list==null}">
	<%
		request.setCharacterEncoding("gbk"); 
		int y=0;
      	if(request.getParameter("year")!=null)
      	y=Integer.parseInt(request.getParameter("year"));
	    String name="";
	    if(request.getParameter("name")!=null)
	    name=String.valueOf(request.getParameter("name"));
   	%>
   	
	<sql:query var="cus" dataSource="${con}">
	SELECT cus_id,cus_name FROM customers c where cus_name like '%<%=name %>%'
	</sql:query>
	
	<c:set var="index" value="${(pc.curPage-1)*pc.maxItems }" scope="page" ></c:set>
	<c:forEach var="row" items="${cus.rows}">
	<c:set var="index" value="${index+1}"></c:set>
	<tr class="listTrMouseOut" onMouseOver="this.className='listTrMouseOver'" 
		  onMouseOut="this.className='listTrMouseOut'">
		<td>${index }</td>
		<td><a href="../customerManage/cus_showOrders.jsp?cusId=${row.cus_id}">${row.cus_name }</a></td>
		<td>
		<%if(y==0 ){ %>
		<sql:query var="order" dataSource="${con}">
		SELECT sum(ordite.ordSum) as cusSum FROM cusorder ord,
		(SELECT item_orderid,sum(item_count * item_price) as ordSum FROM cusorderitems c group by item_orderid) 
		as ordite
		where ordite.item_orderid=ord.order_id and order_cusid=${row.cus_id };
		</sql:query>
		<%}else{ %>
		<sql:query var="order" dataSource="${con}">
		SELECT sum(ordite.ordSum) as cusSum FROM cusorder ord,
		(SELECT item_orderid,sum(item_count * item_price) as ordSum FROM cusorderitems c group by item_orderid) 
		as ordite
		where ordite.item_orderid=ord.order_id and order_cusid=${row.cus_id } and
		ord.order_date between '<%=y %>-01-01' and '<%=y+1 %>-01-01';
		</sql:query>
		<%} %>
		<c:forEach var="ord" items="${order.rows}">	
		<c:if test="${ord.cusSum!=null }">
		${ord.cusSum }
		</c:if>
		<c:if test="${ord.cusSum==null }">
		 0
		</c:if>
		</c:forEach>

		</td>
	</tr>
	</c:forEach>

	</c:if>
</table>
		<!-- 可编辑区end -->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
<div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
   </div>
</body>
</html>
