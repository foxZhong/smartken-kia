<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>������¼</title>
</head>
<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>

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
		 <!--�༭��-->
		 �ͻ���Ϣ���� > �ͻ���Ϣ > ������¼<p>
		 <%int id=Integer.parseInt(request.getParameter("cusId")); %>
		 <sql:query var="customer" dataSource="${con}">
		 	select * from customers where cus_id=?
		 <sql:param value="<%=id %>"></sql:param>
		 </sql:query>
		 <c:forEach var="cusRow" items="${customer.rows}">	
		 <table cellpadding="0" cellspacing="0" border="1" align="center" width="700">
		 	<tr>
		 		<td colspan="4" align="right">
		 			<a href="cus_showContacts.jsp?cusId=${cusRow.cus_id}">��ϵ��</a>	
		 			<a href="cus_showOrders.jsp?cusId=${cusRow.cus_id}">��ʷ����</a>
					<a href="cus_manage.jsp?cusId=${cusRow.cus_id}">����</a>	
				</td>
		 	</tr>
		 	<tr height="30">
		 		<td width="180" align="center" class="formTitleTd">�ͻ����</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">&nbsp;
					${cusRow.cus_id}
				</td>
		 		<td width="180" align="center" class="formTitleTd">�ͻ�����</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">&nbsp;
					${cusRow.cus_name}
				</td>
		 	</tr>
		 	<tr>
		 		<td colspan="6">&nbsp;</td>
		 	</tr>
		 	</table>
		 	
		 	<table cellpadding="0" cellspacing="0" border="1" align="center" width="700">
			<tr height="25" class="listTitleTR">
		 		<td width="130" align="center">ʱ��</td>
		 		<td width="70" align="center">�ص�</td>
		 		<td width="130" align="center">��Ҫ</td>
		 		<td width="130" align="center">��ϸ��Ϣ</td>
		 		<td width="96" align="center">��ע</td>
		 		<td width="100" align="center">����</td>
		 	</tr>
		 	<sql:query var="cusnote" dataSource="${con}">
		 		SELECT * FROM cusnote where note_cusid=?;
		 		<sql:param value="${cusRow.cus_id}"></sql:param>
		 	</sql:query>
		 	<c:forEach var="cnoRow" items="${cusnote.rows}">
		 		<tr align="center" valign="middle" class="listTrMouseOut" 
		 			onMouseOver="this.className='listTrMouseOver'" 
		 			onMouseOut="this.className='listTrMouseOut'">
		 			<td>${cnoRow.note_time }</td>
		 			<td>${cnoRow.note_addr }</td>
		 			<td>${cnoRow.note_summary }</td>
		 			<td>${cnoRow.note_info }</td>
		 			<td>${cnoRow.note_remark }</td>
		 			<td>
		 				<table border="0">
		 					<tr>
		 						<td>
									<a href="customer.do?oper=delCusnote&noteId=${cnoRow.note_id}&cusId=${cnoRow.note_cusid }">ɾ��</a>
								</td>
							</tr>
						</table>
					</td>
		 		</tr>
		 	</c:forEach>
			</table>
			
			<html:form action="/customerManage/customer" method="post">
			<html:hidden property="cusnote.noteCusid" value="${cusRow.cus_id}"/>
			<table cellpadding="0" cellspacing="0" border="1" align="center" width="700">
		 	<tr>
		 		<td colspan="6" align="right">
		 			<input name="oper" type="hidden" value="addCusnote"/>
		 			<input type="submit" value="�½�������¼"/>
		 		</td>
		 	</tr>
		 	<tr height="30">
		 	     <sql:query var="now" dataSource="${con}">
		    select now() as now;
		        </sql:query>
		        <td width="180" align="center" class="formTitleTd">ʱ��</td>
		       <c:forEach var="nowRow" items="${now.rows}">
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">&nbsp;
		 			<html:text property="cusnote.noteTime"  value="${nowRow.now}" size="18"/><font color="red"/>*
		 		</td>
		 		</c:forEach>
		 	
		 		<td width="180" align="center" class="formTitleTd">�ص�</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">&nbsp;
		 			<html:text property="cusnote.noteAddr" size="18"/><font color="red"/>*
		 		</td>
		 	</tr>
		 	<tr height="30">
		 		<td width="180" align="center" class="formTitleTd">��Ҫ</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">&nbsp;
		 			<html:text property="cusnote.noteSummary" size="18"/><font color="red"/>*
				</td>
		 		<td width="180" align="center" class="formTitleTd">��ע</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">&nbsp;
		 			<html:text property="cusnote.noteRemark" size="18"/>
				</td>
		 	</tr>
		 	<tr height="30">
		 		<td width="180" align="center" class="formTitleTd">��ϸ��Ϣ</td>
		 		<td width="150" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'" colspan="3">&nbsp;
		 			<html:textarea property="cusnote.noteInfo"  cols="70" rows="5"></html:textarea>
		 		</td>
		 	</tr>
		 </table>
		 </html:form>
		 </c:forEach>
		 <!--�༭��-->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
<div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
</div>
<html:errors property="info"/>
</body>
</html>
