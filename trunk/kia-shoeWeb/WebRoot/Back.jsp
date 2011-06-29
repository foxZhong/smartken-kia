<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Back.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
   <script type="text/javascript">
  	function show(){
		if(leftIframe.style.display == 'none'){		<%--判断当前是否为隐藏--%>
  			leftIframe.style.display='block';		<%--把当前设置为显示--%>
  		}else{
			leftIframe.style.display = 'none';		<%--否则，隐藏--%>		
  		}
  	}
	</script>
  <body style="margin: 0px;">
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td  width="160" height="100%" id="leftIframe">
				<iframe name="left" src="BackLeft.jsp" width="175" height="100%" frameborder="0"></iframe>
			</td>
			<td height="100%" onclick="show();">
				<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td bgcolor="#3A5F94"><a style="color: #FFFFFF;font-size: 13px; cursor: pointer">点此切换</a></td>
					</tr>
				</table>
			</td>
			<td width="100%" height="100%">
				<iframe frameBorder="0" name="main"  src="BackMain.jsp" height="100%" width="100%" ></iframe>
			</td>
		</tr>
	</table>
  </body>