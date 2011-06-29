<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>出错页面</title>
<style type="text/css">
h2{color:#FF0000;}
h3{color:#989898;}
a:link,a:visited{text-decoration:none;color:#FF0000;}
a:hover,a:focus{color:#698CC3;}

</style>
</head>

<body style="background-color:#D5E4E4;">
<div align="center">
	<br /><br /><br /><br /><br /><br /><br />
	<h2>出错啦！</h2>
	<h3>您输入的用户名或密码不正确。</h3>
	<div>请：<a href="../Login.jsp">重新登录</a>&nbsp;|&nbsp;<a href="../index.jsp">返回主页</a></div>
</div>
</body>
</html>