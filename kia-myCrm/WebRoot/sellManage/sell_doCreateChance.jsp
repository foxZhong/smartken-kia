<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>创建营销机会</title>
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
	营销管理->营销机会管理->新建营销机会
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
       
       <html:form action="/sellManage/sell" method="post">
       <input type="hidden" name="oper" value="doCreateChance">
       <html:hidden property="chance.chaUserid" value="${user.uid}"/>
       <html:hidden property="chance.chaStaut" value="1"/>
		<table width="700"  border="1">
		<tr>
		<td class="formTitleTd">编号</td>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		   <sql:query var="maxId" dataSource="${con}">
		     SELECT (cha_id+1) as maxid FROM sellchance order by cha_id desc limit 0,1;
		   </sql:query>
		   <c:forEach var="id" items="${maxId.rows}">${id.maxid}</c:forEach>
		</td>
		<td class="formTitleTd">机会来源</td>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		    <html:text property="chance.chaSource"></html:text>
		</td>		
		</tr>
		<tr>
		<td class="formTitleTd">客户名称</td>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		   <html:text property="chance.chaClientName"></html:text>
		</td>
		<td class="formTitleTd">成功率（%）</td>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		   <html:text property="chance.chaSuccessRate"></html:text>
		</td>		
		</tr>
		<tr>
		<td class="formTitleTd">概要</td>
		<td  colspan="3" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		   <html:text property="chance.chaSummary" size="70"></html:text>
		 
		</td>	
		</tr>
		<tr>
		<td class="formTitleTd">联系人</td>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		 <html:text property="chance.chaContext"></html:text>
		</td>
		<td class="formTitleTd">联系人电话</td>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		 <html:text property="chance.chaContextPhone"></html:text>
		</td>		
		</tr>
		<tr>
		<td class="formTitleTd">机会描述</td>
		<td  colspan="3" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		  <html:textarea property="chance.chaDesc" rows="5" cols="40"></html:textarea>
		</td>	
		</tr>
		<tr>
		<td class="formTitleTd">创建人</td>
		
        <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
          <sql:query var="users" dataSource="${con}">
             select * from users; 
           </sql:query>
       <html:select property="chance.chaCreatorid">
          <c:forEach var="userRow" items="${users.rows}">
          <option value="${userRow.u_id}">${userRow.u_realname}</option>
       </c:forEach>
       </html:select>
		</td>
		<td class="formTitleTd">创建时间</td>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		  <sql:query var="now" dataSource="${con}">
		    select now() as now;
		  </sql:query>
		  <c:forEach var="nowRow" items="${now.rows}">
		    <html:text property="chance.chaCreatetime" value="${nowRow.now}" size="30"></html:text>
		  </c:forEach>
		  
		</td>		
		</tr>
		</table >
		<input type="submit" value="新建"><input type="reset" value="清空">
			
	</html:form>
		<!-- 可编辑区end -->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
<div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
   </div>
<html:errors property="infoChance"/>
</body>
</html>
