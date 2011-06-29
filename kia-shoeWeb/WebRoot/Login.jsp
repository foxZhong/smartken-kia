<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/styles.css">
<script language="javascript" type="text/javascript">
function Sub(){
	document.form1.submit();
}
</script>

  </head>
  
  <body>
    <div id="top"><jsp:include page="Top.jsp"></jsp:include></div>
    <br /><br /><br /><br /><div align="center" class="font5">请登录！</div>
	<form id="form1" name="form1" method="post" action="manage/doLogin.jsp">
      <table cellpadding="5" cellspacing="0" class="tttt" align="center">
        <tr>
          <td colspan="3" bgcolor="#99CCFF"><strong>用户登录</strong></td>
        </tr>
        <tr>
          <td class="font2">用户名</td>
          <td><input type="text" name="userName" id="userName" /></td>
          <td rowspan="2"><a href="javascript:Sub()"><img src="image/logbtn.gif" width="87" height="42" border="0" /></a></td>
        </tr>
        <tr>
          <td class="font2">密&nbsp;&nbsp;码</td>
          <td><input type="password" name="passWord" id="passWord" /></td>
        </tr>
        <tr>
          <td colspan="3" align="center"><a href="Reg.jsp">您是否要现在注册？</a></td>
        </tr>
      </table>
    </form><br /><br /><br /><br /><br />
  	<div><jsp:include page="Bottom.jsp"></jsp:include></div>
  </body>
</html>
