<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>客户构成分析</title>
</head>

<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>
<sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'D2' and u_id=?;
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
		<div id="banner"><br>
		<img src="../images/banner.jpg" border="0"></div>
		<div id="hottest">
			<jsp:include page="../parts/hottest.jsp"></jsp:include>
		</div>
		<!-- 可编辑区 -->
		
		<script type="text/javascript">
		   function doSearchLevel(level)
		   {
		       document.getElementById("cusLevel").value=level;
		       document.getElementById("searchForm").submit();
		   }
		   
		   function doSearchContentment(con)
		   {
		       document.getElementById("cusContentment").value=con;
		       document.getElementById("searchForm").submit();
		   }
		   
		   function doSearchCredit(credit)
		   {
		      document.getElementById("cusCredit").value=credit;
		       document.getElementById("searchForm").submit();
		   }
		</script>
		
		 <html:form action="/customerManage/customer?url=cus_showCustomer" method="post" styleId="searchForm">
		 <input type="hidden" name="oper" value="doSearchCustomers">
		 <html:hidden property="customers.cusLevel" styleId="cusLevel"/>
		 <html:hidden property="customers.cusContentment" styleId="cusContentment"/>
		 <html:hidden property="customers.cusCredit" styleId="cusCredit"/>
		</html:form>
		
		 <table width="700"  border="1" cellpadding="3px" cellspacing="3px">
		 <div >客户构成分析</div><p>

		
	    <script language="javascript">
	       function changeData()
	       {
	           document.getElementById("dataForm").submit();
	       }
	    </script>
    <form action="sta_showContribute.jsp" method="post" id="dataForm">
		<tr>
			<td class="formTitleTd">报表方式</td>
			
			<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
			 onMouseOut="this.className='formTdMouseOut'">
				<select name="dataid"  onChange="changeData()">
				    <option value="0" selected="selected">请选择</option>
					<option value="1">按等级</option>
					<option value="5">按信用度</option>
					<option value="4">按满意度</option>
				</select>
			</td>
	
			<td class="formTitleTd">&nbsp;</td>
			<td class="formTitleTd">&nbsp;</td>
		</tr>
	</form>
	</table>
	<p>
<table width="700"  border="1">
	
	<c:if test="${requestScope.list==null}">

   <% int id=1;
      if(request.getParameter("dataid")!=null)
       id=Integer.parseInt(request.getParameter("dataid"));
    %>
    <sql:query var="data" dataSource="${con}">
    select * from sys_datas where data_id=?;
      <sql:param value='<%=id %>'></sql:param>
    </sql:query>
    <tr class="listTitleTR"> 
		<td>编号</td>
		<td>
		<c:forEach var="dataRow" items="${data.rows}">
		  ${dataRow.data_title }
		</c:forEach>
		</td>
		<td>客户数量</td>
	</tr>
    
	<sql:query var="Level" dataSource="${con}">
	SELECT * FROM sys_dataoptions where opt_dataid=?;
	  <sql:param value='<%=id %>'></sql:param>
	</sql:query>
    	
	<c:set var="index" value="${(pc.curPage-1)*pc.maxItems }" scope="page" ></c:set>
	<c:forEach var="row" items="${Level.rows}">
		<tr class="listTrMouseOut" onMouseOver="this.className='listTrMouseOver'" 
		  onMouseOut="this.className='listTrMouseOut'">
		<c:set var="index" value="${index+1}"></c:set>
			<td>${index }</td>
			<%if(id==5){ %>
			   <td><a href="javascript:doSearchCredit(${row.opt_value })">
			  ${row.opt_name }</a></td>
			   <td>
				<sql:query var="levCount" dataSource="${con}">
				SELECT count(*) as lc FROM customers c where cus_credit=${row.opt_value}
				</sql:query>
			<%}else if(id==4){  %>
			    <td> <a href="javascript:doSearchContentment(${row.opt_value })">${row.opt_name }</a></td>
			   <td>
				<sql:query var="levCount" dataSource="${con}">
				SELECT count(*) as lc FROM customers c where cus_contentment=${row.opt_value}
				</sql:query>
			<%}else{ %>
			  <td> <a href="javascript:doSearchLevel(${row.opt_value })">
			  ${row.opt_name }</a></td>
			   <td>			
				<sql:query var="levCount" dataSource="${con}">
				SELECT count(*) as lc FROM customers c where cus_level=${row.opt_value}
				</sql:query>
			<%} %>
				<c:forEach var="count" items="${levCount.rows}">
				${count.lc }
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
