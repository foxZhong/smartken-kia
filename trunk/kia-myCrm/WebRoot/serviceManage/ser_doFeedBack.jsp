<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>服务反馈</title>
</head>

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
		服务管理->服务反馈 ->反馈<p>
		<a href="ser_showHandle.jsp">返回</a>
<sql:setDataSource driver="${mysql.driver}" url="${mysql.url}" 
           user="${mysql.user}" password="${mysql.pass}" var="con"/>
       <sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'C4' and u_id=?;
	           <sql:param value='${user.uid}'></sql:param>
	        </sql:query>
	     <c:forEach var="gRow" items="${grant.rows}">
     <c:if test="${gRow.fcount==0}">
        <jsp:forward page="../main/errorGrant.jsp"></jsp:forward>
     </c:if>
   </c:forEach>
       
       <% int serID=Integer.parseInt(request.getParameter("serID")); %>
       <sql:query var="service" dataSource="${con}" >
       SELECT * FROM services,users,customers where cus_id=ser_cusid and u_id=ser_createrid and ser_id=?;
          <sql:param value='<%=serID %>'></sql:param>
       </sql:query>
       <c:forEach var="serRow" items="${service.rows}">
		 <table width="700"  border="1" cellpadding="3px" cellspacing="3px">
  <tr>
    <td width="115" class="formTitleTd">编号</td>
    <td width="236" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${serRow.ser_id }</td>
    <td width="116" class="formTitleTd">服务类型</td>
    <td width="200" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
       <sql:query var="data" dataSource="${con}">
         SELECT * FROM sys_dataoptions where opt_dataid=2 and opt_value=? 
         <sql:param value='${serRow.ser_status}'></sql:param>
     </sql:query>
     <c:forEach var="dataRow" items="${data.rows}">
         ${dataRow.opt_name }
     </c:forEach>
    </td>
  </tr>
  <tr>
    <td class="formTitleTd">概要</td>
    <td colspan="3" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${serRow.ser_context }</td>
  </tr>
  <tr>
    <td class="formTitleTd">客户</td>
    <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${serRow.cus_name}</td>
    <td class="formTitleTd">状态</td>
    <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
                    已分配
    </td>
  </tr>
  <tr>
    <td class="formTitleTd">服务请求</td>
    <td colspan="3" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${serRow.ser_requset }</td>
  </tr>
  <tr>
    <td class="formTitleTd">创建人</td>
    <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${serRow.u_realname}</td>
    <td class="formTitleTd">创建时间</td>
    <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${serRow.ser_pubtime }</td>
  </tr>
</table>
<p>
<table width="700"  border="1" cellpadding="3px" cellspacing="3px">
  <tr>
    <td width="114" class="formTitleTd">分配给</td>
    <td width="236" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
       <sql:query var="assigner" dataSource="${con}">
       SELECT * FROM users where u_id=?;
         <sql:param value='${serRow.ser_assginerid}'></sql:param>
       </sql:query>
       <c:forEach var="assRow" items="${assigner.rows}">${assRow.u_realname}</c:forEach>
    </td>
    <td width="117" class="formTitleTd">分配时间</td>
    <td width="200" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">${serRow.ser_asstime }</td>
  </tr>
</table>

<p>

<html:form action="/serviceManage/services" method="post">
<table width="700"  border="1" cellpadding="3px" cellspacing="3px">
  <tr>
    <td width="114" class="formTitleTd">服务处理</td>
    <td colspan="3" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
      <html:text  size="90" property="services.serHandle" value="${serRow.ser_handle}"></html:text>
    </td>
  </tr>
  
  <tr>
    <td class="formTitleTd">处理人</td>
      <sql:query var="users" dataSource="${con}">
      select * from users; 
    </sql:query>
     <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
       <html:select property="services.serUserid">
          <c:forEach var="userRow" items="${users.rows}">
          <option value="${userRow.u_id}">${userRow.u_realname}</option>
       </c:forEach>
       </html:select>
    </td>
    <td width="118" class="formTitleTd">处理时间</td>
    <td width="199" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
       <jsp:useBean id="today" class="java.util.Date" scope="page"></jsp:useBean>
    <html:text styleId="txtDate" property="services.serPubtime" value=""/>
    <div id="date" style="display:none"><bean:write name='today' format='yyyy-MM-dd hh:mm:ss'/></div></td>
    <script type="text/javascript">
	   document.getElementById("txtDate").value = document.getElementById("date").innerHTML;
    </script>
   
  </tr>
</table>
</html:form>

<p>
  <br><html:form action="/serviceManage/services" method="post">
  <html:hidden property="services.serId" value="${serRow.ser_id}"/>
  <input type="hidden" name="oper" value="doFeedBack" />
  <input type="submit" value="反馈">
  <table width="700"  border="1" >
    <tr>
    <td width="114" class="formTitleTd">处理结果<br></td>
    <td width="236" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'"><html:text property="services.serResult" /><br></td>
    <td width="118" class="formTitleTd">满意度<br></td>
    <td width="199" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'"><html:select property="services.serLevel">
                     <sql:query var="levels" dataSource="${con}">
                       SELECT opt_name,opt_value FROM sys_dataoptions where opt_dataid=4;
                     </sql:query>
                     <c:forEach var="lr" items="${levels.rows}">
                       <option value="${lr.opt_value }">${lr.opt_name }</option>
                     </c:forEach>
                    </html:select><br></td>
  </tr>
  </table>
  </html:form>
 </c:forEach> 

		<!-- 可编辑区end -->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
<div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
   </div>
</body>

</html>
