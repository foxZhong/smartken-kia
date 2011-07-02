<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>无标题文档</title>
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
		<table width="660"  border="1">
		<tr>
		<td width="16%" height="27">编号</td>
		<td width="16%" height="27"></td>
		<td width="16%" height="27">类别</td>
		<td width="16%" height="27"></td>	
		</tr>
				<tr>
		<td width="16%" height="27">条目</td>
		<td width="16%" height="27"></td>
		<td width="16%" height="27">值</td>
		<td width="16%" height="27"></td>	
		</tr>
		<tr>
		<td width="16%" height="27">是否可编辑</td>
		<td width="16%" height="27"></td>
		<td width="16%" height="27"></td>
		<td width="16%" height="27"></td>
		</tr>
		</table >			
		<!-- 可编辑区end -->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
</body>
</html>
