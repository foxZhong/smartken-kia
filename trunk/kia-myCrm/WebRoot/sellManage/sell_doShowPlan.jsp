<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>�鿴Ӫ���ƻ�</title>
</head>
<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>
       <sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'A' and u_id=?;
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
		Ӫ������  > ���ۻ������  > �鿴���ۻ���
		<p>
		<%int id=Integer.parseInt(request.getParameter("chaID")); %>
		<sql:query var="chance" dataSource="${con}">
		SELECT *,
       (select opt_name from sys_dataoptions where cha_staut=opt_value and opt_dataid=11) as stautname,
      (select u_realname from users where u_id=cha_creatorid) as creatorname,
      (select u_realname from users where u_id=cha_dispatchid) as dispatchname
       FROM sellchance s where cha_id=?
		<sql:param value="<%=id %>"></sql:param>
		</sql:query>
		
		<a href="javascript:history.go(-1)">����</a>
		<table width="700"  border="1">
		<c:forEach var="chaRow" items="${chance.rows}">
		<tr>
		<td width="25%" height="27" class="formTitleTd">���</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_id }</td>
		<td width="25%" height="27" class="formTitleTd">������Դ</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_source }</td>
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">�ͻ�����</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_clientName }</td>
		<td width="25%" height="27" class="formTitleTd">�ɹ��ʣ�%��</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_successRate }</td>
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">��Ҫ</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_summary }</td>
		<td width="25%" height="27" class="formTitleTd">״̬</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.stautname }</td>
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">��ϵ��</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_context }</td>
		<td width="25%" height="27" class="formTitleTd">��ϵ�˵绰</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_contextPhone }</td>
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">��������</td>
		<td width="25%" height="27" colspan="3" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_desc }</td>
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">������</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.creatorname }</td>
		<td width="25%" height="27" class="formTitleTd">����ʱ��</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_createtime }</td>
		</tr>
		<tr>
		<td width="25%" height="27" class="formTitleTd">ָ�ɸ�</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.dispatchname }</td>
		<td width="25%" height="27" class="formTitleTd">ָ��ʱ��</td>
		<td width="25%" height="27" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${chaRow.cha_distime }</td>
		</tr>
		</c:forEach>
		</table >
		<br>&nbsp;<br>
		<sql:query var="plans" dataSource="${con}">
		select * from sellplan where plan_chanceid=?
		<sql:param value="<%=id %>"></sql:param>
		</sql:query>
		<table width="700"  border="1">
		<tr class="listTitleTR">
		<td>����</td>
		<td>�ƻ���</td>
		<td>ִ��Ч��</td>
		</tr>
		<c:forEach var="planRow" items="${plans.rows}">
		<tr class="listTrMouseOut" onMouseOver="this.className='listTrMouseOver'" 
		  onMouseOut="this.className='listTrMouseOut'">
		<td width="180">${planRow.plan_pubdate }</td>
		<td>${planRow.plan_content }</td>
		<td>${planRow.plan_result }</td>
		</tr>
		</c:forEach>
		</table>	
		
		<!-- �ɱ༭��end -->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>

<div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
   </div>
</body>
</html>
