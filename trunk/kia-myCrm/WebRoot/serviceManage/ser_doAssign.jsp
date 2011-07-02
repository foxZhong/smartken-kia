<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>分配服务</title>
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
		 <table width="650" border="1" cellpadding="3px" cellspacing="3px">
  <tr>
    <td width="115">编号</td>
    <td width="236">&nbsp;</td>
    <td width="116">服务类型</td>
    <td width="200">&nbsp;</td>
  </tr>
  <tr>
    <td>概要</td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td>客户</td>
    <td>&nbsp;</td>
    <td>状态</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="37">服务请求</td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td height="37">创建人</td>
    <td>&nbsp;</td>
    <td>创建时间</td>
    <td>&nbsp;</td>
  </tr>
</table>
<br>
<table width="650" height="38" border="1" cellpadding="3px" cellspacing="3px">
  <tr>
    <td width="114">分配给</td>
    <td width="236">&nbsp;</td>
    <td width="117">分配时间</td>
    <td width="200">&nbsp;</td>
  </tr>
</table>
<br>
<table width="650" height="121" border="1" cellpadding="3px" cellspacing="3px">
  <tr>
    <td width="114" height="74">服务处理</td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td height="36">处理人</td>
    <td width="236">&nbsp;</td>
    <td width="118">处理时间</td>
    <td width="199">&nbsp;</td>
  </tr>
</table>
		<!-- 可编辑区end -->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
</body>
</html>
