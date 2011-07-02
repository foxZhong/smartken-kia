<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>客户服务分析</title>
</head>

<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>
<sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'D4' and u_id=?;
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

		<div >统计管理 -> 客户服务分析</div><p>

	    <script language="javascript">
	       function changeData()
	       {
	           document.getElementById("dataForm").submit();
	       }
	       
	       function searchService(type)
	       {
	           document.getElementById("serType").value=type;
	           document.getElementById("searchForm").submit();
	           
	       }
   		</script>
   		<html:form action="/serviceManage/services?url=ser_showAssign" method="post" styleId="searchForm">
   		<input type="hidden" name="oper" value="searchServices">
   		<html:hidden property="services.serType" styleId="serType"/>
   		</html:form>
		 
		
   <form action="sta_showServer.jsp" method="post" id="dataForm">
		<tr>
			<th class="formTitleTd">年份</th>
			<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
			 onMouseOut="this.className='formTdMouseOut'">
				<select name="year" onChange="changeData()">
				<option value="0" selected="selected">全部</option>
				<sql:query var="years" dataSource="${con}">
				select EXTRACT(YEAR FROM ser_pubtime) as year from
				 services group by EXTRACT(YEAR FROM ser_pubtime);
				</sql:query>
				<c:forEach var="yearRow" items="${years.rows}">
					<option value="${yearRow.year}">${yearRow.year }</option>
				</c:forEach>
				</select>
			</td>
			<td class="formTitleTd">&nbsp;</td>
			<td class="formTitleTd">&nbsp;</td>
		</tr>
	</form>
	</table><p>
<table width="700"  border="1">
	<tr class="listTitleTR">
		<th>编号</th>
		<th>条目</th>
		<th>服务数量</th>
	</tr>
	<c:if test="${requestScope.list==null}">
	<% int y=0;
      	if(request.getParameter("year")!=null)
      	y=Integer.parseInt(request.getParameter("year"));
   	%>
 	<sql:query var="serves" dataSource="${con}">
 	SELECT * FROM sys_dataoptions s where opt_dataid=2
 	</sql:query>
 	
 	<c:set var="index" value="${(pc.curPage-1)*pc.maxItems }" scope="page" ></c:set>
	<c:forEach var="row" items="${serves.rows}">
	<tr class="listTrMouseOut" onMouseOver="this.className='listTrMouseOver'" 
		  onMouseOut="this.className='listTrMouseOut'">
	<c:set var="index" value="${index+1}"></c:set>
		<td>${index }</td>
		<td><a href="javascript:searchService(${row.opt_value });">${row.opt_name }</a></td>
		<td>
		<%if(y==0){ %>
			<sql:query var="serCount" dataSource="${con}">
			SELECT count(*) as sc FROM services s where ser_type=${row.opt_value};
			</sql:query>
		<%}else{ %>
			<sql:query var="serCount" dataSource="${con}">
			SELECT count(*) as sc FROM services s where ser_type=${row.opt_value} and
			ser_pubtime between '<%=y %>-01-01 00:00:00' and '<%=y+1 %>-01-01 00:00:00';
			</sql:query>
		<%} %>
			<c:forEach var="count" items="${serCount.rows}">
			${count.sc }
			</c:forEach>
		</td>
	</tr>
	</c:forEach>
	
	</c:if>
	<tr>
		
	</tr>
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
