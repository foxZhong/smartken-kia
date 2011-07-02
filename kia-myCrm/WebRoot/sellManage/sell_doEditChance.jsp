<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>编辑销售机会</title>
</head>


<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>
    <sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'A1' and u_id=?;
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
		营销管理  > 销售机会管理  > 编辑销售机会
		<p> 
		<%int id=Integer.parseInt(request.getParameter("chaID"));%>	
		
		<html:form action="/sellManage/sell" method="post">
		<input name="oper" value="doEditChance" type="hidden">
		
		
		<sql:query var="chance" dataSource="${con}">
		select *,(select u_realname from users where u_id=cha_dispatchid) as disname
		from sellChance where cha_id=?
		<sql:param value="<%=id %>"></sql:param>
		</sql:query>
		<c:forEach var="chanceRow" items="${chance.rows}">
		<html:hidden property="chance.chaId" value="${chanceRow.cha_id}"/>	
		<html:hidden property="chance.chaUserid" value="${chanceRow.cha_userid}"/>
		<html:hidden property="chance.chaStaut" value="${chanceRow.cha_staut}"/>		
		
		<a href="sell_doOrderChance.jsp?chaID=<%=id %>">指派</a>&nbsp;
		<a href="sell_showChance.jsp">返回</a>
		<table width="700"  border="1">
		
		<tr>
		<td width="25%" height="27" class="formTitleTd">编号</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		<html:text property="chance.chaId" value="${chanceRow.cha_id }" readonly="true" ></html:text>
		</td>
		<td width="25%" height="27" class="formTitleTd">机会来源</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		<html:text property="chance.chaSource" value="${chanceRow.cha_source }"></html:text>
		</td>		
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">客户名称</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		<html:text property="chance.chaClientName" value="${chanceRow.cha_clientName }"></html:text>
		</td>
		<td width="25%" height="27" class="formTitleTd">成功率（%）</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		<html:text property="chance.chaSuccessRate" value="${chanceRow.cha_successRate }"></html:text>
		
		</td>		
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">概要</td>
		<td width="25%" height="27" colspan="3" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		<html:text property="chance.chaSummary" value="${chanceRow.cha_summary }" size="79"></html:text>
		</td>	
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">联系人</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		<html:text property="chance.chaContext" value="${chanceRow.cha_context }"></html:text>
		</td>
		<td width="25%" height="27" class="formTitleTd">联系人电话</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		<html:text property="chance.chaContextPhone" value="${chanceRow.cha_contextPhone }"></html:text>
		</td>		
		</tr>
		<tr>
		<td width="25%" height="80" class="formTitleTd">机会描述</td>
		<td width="25%" height="80" colspan="3" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		<html:textarea property="chance.chaDesc" value="${chanceRow.cha_desc }" cols="70" rows="8"></html:textarea>
		</td>	
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">创建人</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		 <sql:query var="users" dataSource="${con}">
             select * from users; 
           </sql:query>
       <html:select property="chance.chaCreatorid">
          <c:forEach var="userRow" items="${users.rows}">
            <c:if test="${userRow.u_id==chanceRow.cha_creatorid}">
          <option value="${userRow.u_id}" selected="selected">${userRow.u_realname}</option>
          </c:if>
          <c:if test="${userRow.u_id!=chanceRow.cha_creatorid}">
          <option value="${userRow.u_id}">${userRow.u_realname}</option>
          </c:if>
       </c:forEach>
       </html:select>
	
		</td>
		<td width="25%" height="27" class="formTitleTd">创建时间</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		<html:text property="chance.chaCreatetime" value="${chanceRow.cha_createtime}" readonly="true" ></html:text>
		</td>		
		</tr>
	
		</table >
		<input type="submit" value="修改" >		
		<p>
		<table width="700"  border="1">
		<tr>
		<td width="25%" height="27" class="formTitleTd">指派给</td>
		
     <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
       <html:hidden property="chance.chaDispatchid" value="${chanceRow.cha_dispatchid}" ></html:hidden>
          ${chanceRow.disname }
		</td>
		<td width="25%" height="27" class="formTitleTd">指派时间</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		${chanceRow.cha_distime }
		</td>		
		</tr>
	
		</table>
		</c:forEach>
		
		</html:form>
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
