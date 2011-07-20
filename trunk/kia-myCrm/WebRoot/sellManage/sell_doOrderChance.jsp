<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>ָ�����ۻ���</title>
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
		<!-- �ɱ༭�� -->
		Ӫ������  > ���ۻ������  > ָ�����ۻ���
		<p>
		<%int id=Integer.parseInt(request.getParameter("chaID"));%>	
		
		<html:form action="/sellManage/sell" method="post">
		<input name="oper" value="doOrderChance" type="hidden">
		
		
		<sql:query var="chance" dataSource="${con}">
		select *,(select u_realname from users where u_id=cha_creatorid) as creatorname
		 from sellChance where cha_id=?
		<sql:param value="<%=id %>"></sql:param>
		</sql:query>
		<c:forEach var="chanceRow" items="${chance.rows}">
		<html:hidden property="chance.chaId" value="${chanceRow.cha_id}"/>	
		<html:hidden property="chance.chaUserid" value="${chanceRow.cha_userid}"/>
		<html:hidden property="chance.chaStaut" value="${chanceRow.cha_staut}"/>		
		
		<a href="sell_doEditChance.jsp?chaID=<%=id %>">�༭</a>&nbsp;
		<a href="sell_showChance.jsp">����</a>
		<table width="700"  border="1">
		
		<tr>
		<td width="25%" height="27" class="formTitleTd">���</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		${chanceRow.cha_id}
		</td>
		<td width="25%" height="27" class="formTitleTd">������Դ</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		${chanceRow.cha_source }
		</td>		
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">�ͻ�����</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		${chanceRow.cha_clientName }
		</td>
		<td width="25%" height="27" class="formTitleTd">�ɹ��ʣ�%��</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		${chanceRow.cha_successRate }
		
		</td>		
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">��Ҫ</td>
		<td width="25%" height="27" colspan="3" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		${chanceRow.cha_summary }
		</td>	
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">��ϵ��</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
	       ${chanceRow.cha_context }
		</td>
		<td width="25%" height="27" class="formTitleTd">��ϵ�˵绰</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		${chanceRow.cha_contextPhone }
		</td>		
		</tr>
		<tr>
		<td width="25%" height="80" class="formTitleTd">��������</td>
		<td width="25%" height="80" colspan="3" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		${chanceRow.cha_desc }
		</td>	
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">������</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		 <html:hidden property="chance.chaCreatorid" value="${chanceRow.cha_creatorid }"/>
	       ${chanceRow.creatorname }
		</td>
		<td width="25%" height="27" class="formTitleTd">����ʱ��</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		${chanceRow.cha_createtime}
		</td>		
		</tr>
	
		</table >
	    <p>
		<table width="700"  border="1">
		<tr>
		<td width="25%" class="formTitleTd">ָ�ɸ�</td>
		<td  width="25%"  class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		    <sql:query var="users" dataSource="${con}">
             select * from users; 
           </sql:query>
       <html:select property="chance.chaDispatchid">
          <c:forEach var="userRow" items="${users.rows}">
          <c:if test="${userRow.u_id==chanceRow.cha_dispatchid}">
          <option value="${userRow.u_id}" selected="selected">${userRow.u_realname}</option>
          </c:if>
          <c:if test="${userRow.u_id!=chanceRow.cha_dispatchid}">
          <option value="${userRow.u_id}">${userRow.u_realname}</option>
          </c:if>
          
       </c:forEach>
       </html:select>
		</td >
		<td  class="formTitleTd">ָ��ʱ��</td>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		   <sql:query var="now" dataSource="${con}">
		    select now() as now;
		  </sql:query>
		  <c:forEach var="nowRow" items="${now.rows}">
		    <html:text property="chance.chaDistime" value="${nowRow.now}" size="30"></html:text>
		  </c:forEach>
		</td>		
		</tr>
		</table>	
		</c:forEach>
		<input type="submit" value="ָ��" >		
		</html:form>
		<!-- �ɱ༭��end -->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
<html:errors property="info"/>
 <div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
   </div>
</body>
</html>