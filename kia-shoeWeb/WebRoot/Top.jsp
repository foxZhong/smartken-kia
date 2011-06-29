<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>top</title>
<!--
<link rel="stylesheet" type="text/css" href="css/top.css">
-->
</head>

<body>
<div style="position: relative; height: 130px;">
  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td><img src="image/logo.png" alt="T03鞋城网"/></td>
	  <td><img src="image/top.png" /></td>
	  <td height="28" align="right"><img src="image/car.jpg" />&nbsp;<strong><a href="manage/doMyCar.jsp">购物车</a>&nbsp;|&nbsp;<a href="manage/doMyUserInfo.jsp">修改资料</a>&nbsp;|&nbsp;<a href="HelpJsp/HelpCenter.jsp">帮助</a></strong></td>
	</tr>  
  </table>
	<div class="rhm1" align="center" style="width:100%;">
	<div class="rhm1-right"></div>
	<div class="rhm1-left"></div>
	<div class="rhm1-bg" style="width:96%" align="center">
		<li><a href="index.jsp"><span>首页</span></a></li>
		<li><a href="Reg.jsp"><span>注册</span></a></li>
		<li><a href="ShoesType.jsp"><span>全部</span></a></li>
		<li><a href="ShoesType.jsp?style=1&current=1"><span>男款</span></a></li>	
		<li><a href="ShoesType.jsp?style=2&current=1"><span>女款</span></a></li>
		<li><a href="ShoesType.jsp?ctId=1&current=1"><span>篮球鞋</span></a></li>	
		<li><a href="ShoesType.jsp?ctId=2&current=1"><span>足球鞋</span></a></li>
		<li><a href="ShoesType.jsp?ctId=3&current=1"><span>网球鞋</span></a></li>
		<li><a href="ShoesType.jsp?ctId=4&current=1"><span>跑步鞋</span></a></li>			
	</div>
	</div>
</div>
</body>
</html>


