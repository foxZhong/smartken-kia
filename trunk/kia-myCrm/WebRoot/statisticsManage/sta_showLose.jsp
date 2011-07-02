<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>客户流失分析</title>
</head>

<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>
<sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'D3' and u_id=?;
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
		 <script language="javascript">
	       function queryData()
	       {
	           document.getElementById("dataForm").submit();
	       }
   		</script>
   <% String name="";
	   String staff="";
	   request.setCharacterEncoding("gbk");
       if(request.getParameter("name")!=null)
       name=String.valueOf(request.getParameter("name"));
       if(request.getParameter("staff")!=null)
       staff=String.valueOf(request.getParameter("staff"));
   	%>
		 <table width="700"  border="1" cellpadding="3px" cellspacing="3px">

		<div >客户流失分析</div><p>
		<div >
		<button onclick="queryData()">查询</button> 
		</div>
	<form action="sta_showLose.jsp" method="post" id="dataForm">
	<tr>
		<th class="formTitleTd">客户名称</th>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
			<input type="text" name="name" value="<%=name %>">
		</td>
		<th class="formTitleTd">客户经理</th>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
			<input type="text" name="staff" value="<%=staff %>">
		</td>
	</tr>
	</form>
	</table><p>
<table width="700"  border="1">
	<tr class="listTitleTR">
		<th>编号</th>
		<th>年份</th>
		<th>客户</th>
		<th>客户经理</th>
		<th>流失原因</th>
	</tr>
	<c:if test="${requestScope.list==null}">

	<sql:query var="test" dataSource="${con}">
	select cus.cus_id,cus.cus_name,staf.staff_name,cus.cus_losedate,cus_loseinfo from
	customers as cus,cusstaff as staf
	where cus.cus_manid=staf.staff_id and cus.cus_status=3 and
	cus_name like '%<%=name %>%' and staff_name like '%<%=staff %>%'
	limit ?,?;
		    <sql:param value='${(pc.curPage-1)*pc.maxItems }'/>
		    <sql:param value='${pc.maxItems}'></sql:param>
	</sql:query>
	<c:set var="index" value="${(pc.curPage-1)*pc.maxItems }" scope="page" ></c:set>
	<c:forEach var="row" items="${test.rows}">
	<tr class="listTrMouseOut" onMouseOver="this.className='listTrMouseOver'" 
		  onMouseOut="this.className='listTrMouseOut'">
	<c:set var="index" value="${index+1}"></c:set>
		<td>${index }</td>
		<td>${row.cus_losedate}</td>
		<td><a href="../customerManage/cus_confirmation_bleed.jsp?cusId=${row.cus_id}">${row.cus_name }</a></td>
		<td>${row.staff_name }</td>
		<td>${row.cus_loseinfo }</td>
	</tr>
	</c:forEach>
	<tr>
		  <td colspan="6">
	       <script type="text/javascript">
	         
	         function jumpStep(v)
	         {
	           
			   document.getElementById("step").value=v;
	           document.forms['jumpForm'].submit();
	         }
	         
	         function jumpTo()
	         {
	            var jp=document.getElementById("jumpPage").value;
	            if(jp>0&&jp<=document.getElementById("pages").value)
	            {document.getElementById("step").value=jp;
	           document.forms['jumpForm'].submit();}
	           else
	            alert("跳转页面超出范围!");
	         }
	      </script>
	      <form id="jumpForm" action="../nextpage" method="post">
	      <input type="hidden" name="url" value="statisticsManage/sta_showLose.jsp"/>
	      <input type="hidden" name="step" id="setp" />
	      <sql:query var="count" dataSource="${con}">
		  SELECT count(*) as total,case
            when count(*)%${pc.maxItems }=0 then (count(*) div ${pc.maxItems })
            else (count(*) div ${pc.maxItems })+1
            end as pages  FROM customers as cus,cusstaff as staf
			where cus.cus_manid=staf.staff_id and cus.cus_status=3;
		   </sql:query>
	      <c:forEach var="countRow" items="${count.rows}">
	                        共&nbsp${countRow.total }&nbsp条记录
	                   每页    <input type="text"  size="3" value="${pc.maxItems }" name="maxItems" >条&nbsp
	       <input type="button" value="刷新" onclick="jumpTo(0)">
	                   第${pc.curPage }页 /共${countRow.pages }页
	       <input type="hidden" name="pages" id="pages" value="${countRow.pages }"/>
	      <input type="button" value="第一页"  onclick="jumpStep(1)">
	      <input type="button" value="上一页"  onclick="jumpStep(-2)">
	      <input type="button" value="下一页"  onclick="jumpStep(-1)">
	      <input type="button" value="最后一页"  onclick="jumpStep('${countRow.pages}')">
	                转到<input type="text" size="3" value="${pc.curPage }" id="jumpPage">页
	      <input type="button" value="Go" onclick="jumpTo()">          
	      </c:forEach>       
	      </form>
		  </td>
		</tr>
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
