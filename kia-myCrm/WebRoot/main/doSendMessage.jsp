<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style type="text/css">
<!--
.listTitleTR {
	font-size: medium;
	font-weight: bold;
	color: #FFFFFF;
	background-color: #7691A4;
	text-align: center;
}

.listTrMouseOver {
	background-color: #FF9933;
}
.listTrMouseOut {
	background-color: #FFFFCC;
}
.listTdMouseOver {
	background-color: #33CC00;
}

.listTdMouseOver {
	background-color: #FF9933;
}


.formTitleTd {
	font-size: small;
	color: #FFFFFF;
	background-color: #7691A4;
}
.formTdMouseOver {
	background-color: #FFFF99;
}
.formTdMouseOut {
	background-color: #FFFFCC;
}
body {
	background-color: #CCFFFF;
}
-->
</style>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>
<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con" />
<body>
    <% int uid=Integer.parseInt(request.getParameter("uId")); %>
     <html:form action="/main/message" method="post" styleId="msgForm" >
     <input type="hidden" name="oper" value="doSendMsg">
     <center><h4>公司小纸条</h4></center>
     <p>&nbsp;</p>
       <table width="400" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCFFCC" align="center">
        <tr>
          <td class="formTitleTd" align="center">发信人</td>
          <td bgcolor="#FFFFFF">
          <sql:query var="sender" dataSource="${con}">
            select u_id,u_realname from users where u_id=?
            <sql:param value="${user.uid}"></sql:param>
          
          </sql:query>
            <c:forEach var="senderRow" items="${sender.rows}">
               <font size='-1'>${senderRow.u_realname }</font>
                <html:hidden property="message.mesFromid" value="${senderRow.u_id}"/>
            </c:forEach>          </td>
        </tr>
        <tr>
          <td class="formTitleTd" align="center">收信人</td>
          <td bgcolor="#FFFFFF">
           <sql:query var="recevicer" dataSource="${con}">
            select u_id,u_realname from users where u_id=?
            <sql:param value="<%=uid %>" ></sql:param>
           </sql:query>
            <c:forEach var="recRow" items="${recevicer.rows}">
               <font size='-1'>${recRow.u_realname }</font>
               <html:hidden property="message.mesToid" value="${recRow.u_id}"/>
            </c:forEach>          </td>
        </tr>
        <tr>
          <td class="formTitleTd">发送时间</td>
         <td bgcolor="#FFFFFF">
         <sql:query var="now" dataSource="${con}">
               select now() as now;
             </sql:query>
             <c:forEach var="nowRow" items="${now.rows}">
             <html:text property="message.mesTime" value="${nowRow.now}" size="30"></html:text>
            </c:forEach>          </td>
        </tr>
        <tr>
           <td class="formTitleTd">消息主题</td>
          <td bgcolor="#FFFFFF">
           <html:text property="message.mesTitle" size="45"></html:text>           </td>
        </tr>
        <tr>
           <td class="formTitleTd">消息内容</td>
          <td bgcolor="#FFFFFF">
           <html:textarea property="message.mesContext" cols="45" rows="7"></html:textarea>           </td>
        </tr>
        <tr>
           <td class="formTitleTd">消息类型</td>
          <td bgcolor="#FFFFFF">
           <html:radio property="message.mesIsPublic" value="1"></html:radio>公开
           <html:radio property="message.mesIsPublic" value="0"></html:radio>私密
          </td>
        </tr>
        <tr>
           <td align="center" colspan="2" >
            	<input type="button" value="发送" onclick="doSend()">
           		<input type="reset" value="重写">
           </td>
        </tr>
      </table>
</html:form>
    <script type="text/javascript">
       function doSend()
       {  
          var b=confirm("确认需要发送消息吗");
          if(b)
           {document.getElementById("msgForm").submit();}
         //window.close();
       }
    </script>
</body>
</html>