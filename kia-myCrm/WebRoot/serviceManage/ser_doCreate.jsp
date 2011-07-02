<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" 
prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>创建服务</title>
</head>

<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>
<sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'C1' and u_id=?;
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
	服务管理 ->服务创建
<html:form action="/serviceManage/services" method="post">
         <input type="hidden" name="oper" value="addService">
		 <table width="700" height="157" border="1">
  <tr>
    <td width="180" class="formTitleTd">编号：</td>
    <sql:query var="maxId" dataSource="${con}">
      select max(ser_id)+1 as maxid from services;
    </sql:query>
    <td width="193" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
        <c:forEach var="maxRow" items="${maxId.rows}">
           <html:hidden property="services.serId" value="${maxRow.maxid} "/>  ${maxRow.maxid}
        </c:forEach>
    </td>
    
     <sql:query var="service" dataSource="${con}">
       select * from sys_datas where data_id=2
    </sql:query>  
       <c:forEach var="serRow" items="${service.rows}">
          <td width="66" class="formTitleTd">${serRow.data_title}</td>
       </c:forEach>
       <sql:query var="serviceType" dataSource="${con}">
       select * from sys_dataoptions where opt_dataid=2
       </sql:query>
    <td width="175" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
       <html:select property="services.serType">
     
       <c:forEach var="typeRow" items="${serviceType.rows}">
         <option value="${typeRow.opt_value }">${typeRow.opt_name }</option>
       </c:forEach>   
       </html:select>
    </td>
  </tr>
  <tr>
    <td class="formTitleTd">概要</td>
    <td colspan="3" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'"><html:text property="services.serContext" size="80"/></td>
  </tr>
  <tr>
    <td class="formTitleTd">客户</td>
    <sql:query var="customers" dataSource="${con}">
       SELECT * FROM customers
    </sql:query>
     <td>
       <html:select property="services.serCusid">
          <c:forEach var="cusRow" items="${customers.rows}">
          <option value="${cusRow.cus_id}">${cusRow.cus_name}</option>
       </c:forEach>
       </html:select>
     </td>
    <td class="formTitleTd">状态</td>
    <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'"><html:hidden property="services.serStatus" value="1"/>新创建</td>
  </tr>
  <tr>
    <td class="formTitleTd">服务请求</td>
    <td colspan="3" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'"><html:textarea property="services.serRequset" rows="6" cols="80"></html:textarea>
  </tr>
  <tr>
    <td height="29" class="formTitleTd">创建人</td>
    <sql:query var="users" dataSource="${con}">
      select * from users; 
    </sql:query>
     <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
       <html:select property="services.serCreaterid">
          <c:forEach var="userRow" items="${users.rows}">
          <option value="${userRow.u_id}">${userRow.u_realname}</option>
       </c:forEach>
       </html:select>
     </td>
    <td class="formTitleTd">创建时间</td>
    <jsp:useBean id="today" class="java.util.Date" scope="page"></jsp:useBean>
    <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'"><html:text styleId="txtDate" property="services.serPubtime" value=""/><div id="date" style="display:none">
    <bean:write name='today' format='yyyy-MM-dd hh:mm:ss'/></div></td>
    
  </tr>
   
</table>
  <input type="submit" value="创建">
      <input type="reset" value="清空">
</html:form>		 
		<!-- 可编辑区end -->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
<html:errors property="info"/>
</body>
<div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
   </div>
<script type="text/javascript">
	
	document.getElementById("txtDate").value = document.getElementById("date").innerHTML;
</script>
</html>
