<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/18.css" rel="stylesheet" type="text/css">
<title>�ޱ����ĵ�</title>
</head>

<body>
<div id="container">
	<div id="globallink">
		<jsp:include page="parts/globallink.jsp"></jsp:include>
	</div>
	<div id="left">
		<jsp:include page="parts/left.jsp"></jsp:include>
	</div>
	<div id="main">
		<div id="banner"><img src="images/banner.jpg" border="0"></div>
		<div id="hottest">
			<jsp:include page="parts/hottest.jsp"></jsp:include>
		</div>
		<!-- �ɱ༭�� -->
		 <jsp:include page="parts/list.jsp"></jsp:include>
		<!-- �ɱ༭��end -->
	</div>
	<jsp:include page="parts/letter.jsp"></jsp:include>
</div>
<div id="footer">
 <jsp:include page="parts/footer.jsp"></jsp:include>
   </div>
</body>
</html>
