<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>后台管理版面</title>
<script type="text/javascript">
function onClick(op){
	for(var i=1;i<=4;i++){
		if(op==i){
			if(document.getElementById("d"+i).style.display=="none"){
				document.getElementById("d"+i).style.display="block";
			}else{
				document.getElementById("d"+i).style.display="none";
			}			
		}else{
			document.getElementById("d"+i).style.display="none";
		}
	}			
}
function CkeckForm(){
	var title = document.getElementById("Title");
	var content = document.getElementById("Content");
	if(title.value.length == 0){
		alert("您还没写新闻标题哦！");
		return false;
	}else if(title.value.length < 3){
		alert("标题字符少于3位！");
		return false;
	}else if(content.value.length == 0){
		alert("您还没有写新闻内容哦！");
		return false;
	}else if(content.value.length < 6){
		alert("新闻内容字符少于6位！您至少得写多点东西来描述清楚吧？");
		return false;
	}else{
		return true;
	}
}
</script>
<link rel="stylesheet" type="text/css" href="css/BackOfficeSystem.css">
</head>

<body>
	<div style="float: left; width:16%; height:550px; background-color: #EFEFEF; border:solid #698CC3 1px">
		<br />
		<table align="center" width="100%" border="0" cellpadding="3" cellspacing="0" class="font">
			<tr align="center">
				<td>系统后台管理版面</td>
			</tr>
			<tr align="center">
				<td><a href="javascript:onClick('1');" class="font">用户管理</a><div id="d1" style="display:none;">
						<table id="menu" border="1" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td><a href="BackOfficeAddAdmin.jsp">			
									<span class="left"></span>
										添加管理员
									<span class="right"></span></a></td>
							</tr>
							<tr>
								<td><a href="BackOfficeUser.jsp">
									<span class="left"></span>
										用户管理
									<span class="right"></span></a></td>
							</tr>
						</table></div></td>
			</tr>
			<tr align="center">
				<td><a href="javascript:onClick('2');" class="font">商品管理</a><div id="d2" style="display:none;">
						<table id="menu" border="1" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td><a href="BackOfficeAddWare.jsp">			
									<span class="left"></span>
										添加商品
									<span class="right"></span></a></td>
							</tr>
							<tr>
								<td><a href="BackOfficeSuperviseWare.jsp">
									<span class="left"></span>
										管理商品
									<span class="right"></span></a></td>
							</tr>
						</table></div></td>
			</tr>
			<tr align="center">
				<td><a href="javascript:onClick('3');" class="font">新闻管理</a><div id="d3" style="display:none;">
						<table id="menu" border="1" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td><a href="BackOfficeAddNews.jsp">
									<span class="left"></span>
										添加新闻
									<span class="right"></span></a></td>
							</tr>
						</table></div></td>
			</tr>
			<tr align="center">
				<td><a href="javascript:onClick('4');" class="font">订单管理</a><div id="d4" style="display:none;">
						<table id="menu" border="1" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td><a href="BackOfficeSystem.jsp">
									<span class="left"></span>
										查看订单
									<span class="right"></span></a></td>
							</tr>						
						</table></div></td>
			</tr>
			<tr align="center">
				<td><a href="manage/doLogout.jsp" class="font">[安全登出]</a></td>
			</tr>
		</table>
	</div>
	<div style="float: left;width:82%; height:550px; border:solid #698CC3 1px; border-left-width:15px; background-color:#F1F7F9;">
		<div style="position:relative; top:30px; left:35px; width:750px; border:solid #698CC3 1px;">
			<form action="manage/doAddNews.jsp" method="post" onsubmit="return CkeckForm()">
				<table class="font" width="100%" height="100%" border="0" bordercolor="#D6E0EF" cellpadding="3" cellspacing="0">
					<tr>
						<td colspan="2" bgcolor="#698CC3" class="font1">新闻发布</td>
					</tr>
                    <tr>
                      <td width="30%"  align="right" valign="top">新闻标题：</td>
                      <td width="70%"><input type="text" name="Title" id="Title" /></td>
                  </tr>
                  <tr>
				  	<td align="right" valign="top">新闻内容：</td>
                  	<td valign="top"><textarea cols="50" rows="20" name="Content" id="Content" /></textarea></td>
                  </tr>
                  <tr>
                  		<td align="center" colspan="2"><input type="submit" value=" 发 布 " />
                        	&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value=" 重 置 " /></td>
               	  </tr>
				</table>
		  </form>
		</div>
	</div>
</body>
</html>
