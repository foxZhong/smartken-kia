<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>制定计划</title>
</head>

<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>
    <sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'A2' and u_id=?;
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
		营销管理 > 客户开发计划 > 制定计划
		
		<%int id=Integer.parseInt(request.getParameter("chaID")); %>
		
		<sql:query var="chance" dataSource="${con}">
		SELECT cha_id, cha_userid, cha_source, cha_clientName, cha_successRate, cha_summary,
       cha_context, cha_contextPhone, cha_desc, cha_creatorid, cha_createtime,
       cha_dispatchid, cha_distime, cha_code, cha_staut,
      (select u_realname from users where u_id=cha_creatorid) as creatorname,
      (select u_realname from users where u_id=cha_dispatchid) as dispatchname
       FROM sellchance s where cha_id=?
		<sql:param value="<%=id %>"></sql:param>
		</sql:query>
		<c:forEach var="chaRow" items="${chance.rows}">
		<p>
		<a href="sell_doExecutePlan.jsp?chaID=<%=id %>">执行计划</a>&nbsp;
		<a href="sell_showEmpolder.jsp">返回</a>
		<table width="700"  border="1">
		<tr>
		<td width="25%" height="27" class="formTitleTd">编号</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_id }</td>
		<td width="25%" height="27" class="formTitleTd">机会来源</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_source }</td>
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">客户名称</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_clientName }</td>
		<td width="25%" height="27" class="formTitleTd">成功率（%）</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_successRate }</td>
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">概要</td>
		<td width="25%" height="27" colspan="3" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_summary }</td>
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">联系人</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_context }</td>
		<td width="25%" height="27" class="formTitleTd">联系人电话</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_contextPhone }</td>
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">机会描述</td>
		<td width="25%" height="27" colspan="3" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_desc }</td>
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">创建人</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.creatorname }</td>
		<td width="25%" height="27" class="formTitleTd">创建时间</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_createtime }</td>
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">指派给</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.dispatchname }</td>
		<td width="25%" height="27" class="formTitleTd">指派时间</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_distime }</td>
		</tr>
		
		</table >
		<p>
		<table width="700"  border="1">
		<sql:query var="plans" dataSource="${con}">
		select * from sellplan where plan_chanceid =?
		<sql:param value="<%=id %>"></sql:param>
		</sql:query>
		
		<tr class="listTitleTR">
		<td width="60" >日期</td>
		<td width="500">计划项</td>		
		</tr>
		<script language="javascript" type="text/javascript">
		    function doPlan(oper,id)
		    {
		      
		      document.getElementById("oper"+id).value=oper;
		      //alert( document.getElementById("oper1").value);
		      document.getElementById("plan"+id).submit();
		    }
		</script>
		<c:forEach var="planRow" items="${plans.rows}">
		<html:form action="/sellManage/sell" method="post" styleId="plan${planRow.plan_id}">
		<input name="oper" type="hidden" id="oper${planRow.plan_id}">
		<html:hidden property="plan.planId" value="${planRow.plan_id}"/>
		<html:hidden property="chance.chaId" value="${planRow.plan_chanceid}"/>
		<tr class="listTrMouseOut" onMouseOver="this.className='listTrMouseOver'" 
		  onMouseOut="this.className='listTrMouseOut'">
		<td>
		<html:hidden property="plan.planPubdate" value="${planRow.plan_pubdate }"></html:hidden>
		${planRow.plan_pubdate }
		</td>
		<td><html:text property="plan.planContent" value="${planRow.plan_content}" />
		    <input type="button" value="保存" onclick="doPlan('doEditPlan','${planRow.plan_id}')">
		       <input type="button" value="删除" onclick="doPlan('doDeletePlan','${planRow.plan_id}')">
		</td>
		</tr>
		</html:form>
		</c:forEach>
		</table>	
		<p>
		<html:form action="/sellManage/sell" method="post" >
		<input name="oper" type="hidden" value="doAddPlan">
		<html:hidden property="plan.planChanceid" value="${chaRow.cha_id}"/>
		<input value="创建计划" type="submit"><input type="reset" value="清空" >
		<table width="700"  border="1">
		<tr>
		<td width="25%" height="27" class="formTitleTd">日期</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		<sql:query var="today" dataSource="${con}">
		    select now() as now;
		</sql:query>
		<c:forEach var="nowRow" items="${today.rows}">
		<html:text property="plan.planPubdate" value="${nowRow.now}"></html:text>
		</c:forEach>
		</td>
		<td width="25%" height="27" class="formTitleTd">计划项</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		<html:text property="plan.planContent"></html:text>
		</td>
		</tr>
		</table>
		</html:form>
		
		</c:forEach>
		<!-- 可编辑区end -->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
<html:errors property="info"/>
<div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
   </div>
</body>
</html>
