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
	function checkFocus(i,div){		//获取光标的验证事件
		var name = new Array('adminName','adminPwdOne','adminPwdTwo');
		var promptOne = new Array('创建您的管理员帐号,4~16位。','为您的账号添加密码,4~16位。','再输入一次密码。');
		
		document.getElementById(div).innerHTML = promptOne[i];
		document.getElementById(name[i]).style.borderColor = "#00DAD6";
		document.getElementById(name[i]).style.backgroundColor = "#9AFFFF";
		document.getElementById(div).style.color = "#0000FF";
	}
	function checkForm(){
		if(adminNameblur() && adminPwdOneblur() && adminPwdTwoblur()){
			return true;
		}else{
			alert("你填入的信息有误.请根据页面的红框提示修改!");
			return false;
		}
	}
	function adminNameblur(){	//帐号的验证事件
		var AName = document.getElementById("adminName");
		var ANameDiv = document.getElementById("adminNameDiv");
		
		if(AName.value.length == 0){
			ANameDiv.innerHTML = "帐号不能为空！";
			AName.style.borderColor = "#FE686C";
			ANameDiv.style.color = "#FF0000";
			AName.style.backgroundColor = "#FFFFFF";
			return false;
		}else if(AName.value.length < 4 || AName.value.length > 16){
			ANameDiv.innerHTML = "帐号长度不正确！";
			AName.style.borderColor = "#FE686C";
			ANameDiv.style.color = "#FF0000";
			AName.style.backgroundColor = "#FFFFFF";
			return false;
		}else{
			AName.style.borderColor = "";
			ANameDiv.style.color = "#00CC00";
			AName.style.backgroundColor = "#FFFFFF";
			ANameDiv.innerHTML = "帐号已填写。";
			return true;
		}
	}
	function adminPwdOneblur(){	//密码的验证事件
		var APwdOne = document.getElementById("adminPwdOne");
		var APwdOneDiv = document.getElementById("adminPwdOneDiv");
		
		if(APwdOne.value.length == 0){
			APwdOneDiv.innerHTML = "密码不能为空！";
			APwdOne.style.borderColor = "#FE686C";
			APwdOneDiv.style.color = "#FF0000";
			APwdOne.style.backgroundColor = "#FFFFFF";
			return false;
		}else if(APwdOne.value.length < 4 || APwdOne.value.length > 16){
			APwdOneDiv.innerHTML = "密码长度不正确！";
			APwdOne.style.borderColor = "#FE686C";
			APwdOneDiv.style.color = "#FF0000";
			APwdOne.style.backgroundColor = "#FFFFFF";
			return false;
		}else{
			APwdOne.style.borderColor = "";
			APwdOneDiv.style.color = "#00CC00";
			APwdOne.style.backgroundColor = "#FFFFFF";
			APwdOneDiv.innerHTML = "密码已填写。";
			return true;
		}
	}
	function adminPwdTwoblur(){	//确认密码的验证事件
		var APwdOne = document.getElementById("adminPwdOne");
		var APwdTwo = document.getElementById("adminPwdTwo");
		var APwdTwoDiv = document.getElementById("adminPwdTwoDiv");
		
		if(APwdTwo.value.length == 0){
			APwdTwoDiv.innerHTML = "确认密码不能为空！";
			APwdTwo.style.borderColor = "#FE686C";
			APwdTwoDiv.style.color = "#FF0000";
			APwdTwo.style.backgroundColor = "#FFFFFF";
			return false;
		}else if(APwdTwo.value.length < 4 || APwdTwo.value.length > 16){
			APwdTwoDiv.innerHTML = "确认密码长度不正确！";
			APwdTwo.style.borderColor = "#FE686C";
			APwdTwoDiv.style.color = "#FF0000";
			APwdTwo.style.backgroundColor = "#FFFFFF";
			return false;
		}else if(APwdOne.value != APwdTwo.value){
			APwdTwoDiv.innerHTML = "两次密码输入不一致！";
			APwdTwo.style.borderColor = "#FE686C";
			APwdTwoDiv.style.color = "#FF0000";
			APwdTwo.style.backgroundColor = "#FFFFFF";
			return false;
		}else{
			APwdTwo.style.borderColor = "";
			APwdTwoDiv.style.color = "#00CC00";
			APwdTwo.style.backgroundColor = "#FFFFFF";
			APwdTwoDiv.innerHTML = "密码输入一致。";
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
							<tr>
								<td><a href="BackOfficeSuperviseNews.jsp">
									<span class="left"></span>
										管理新闻
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
            <form action="manage/doAddAdmin.jsp" method="post" name="regForm" id="regForm" onsubmit="return checkForm()">
                <table class="font" width="100%" height="100%" border="0" bordercolor="#D6E0EF" cellpadding="3" cellspacing="0">
                    <tr>
                        <td colspan="3" bgcolor="#698CC3" class="font1">添加管理员帐号</td>
                    </tr>
                    <tr>
                        <td width="25%" height="35"  align="right">帐&nbsp;&nbsp;号:&nbsp;</td>
                        <td width="30%" valign="middle">&nbsp;<input type="text" name="adminName" id="adminName"
                            onblur="adminNameblur()" onfocus="checkFocus(0,'adminNameDiv')" /></td>
                        <td width="46%" align="center"><div id="adminNameDiv" class="tableDiv"></div>&nbsp;&nbsp;</td>
                    </tr>
                    <tr>
                        <td height="35" align="right">密&nbsp;&nbsp;码:&nbsp;</td>
                        <td valign="middle">&nbsp;<input type="text" name="adminPwdOne" id="adminPwdOne" 
                            onblur="adminPwdOneblur()" onfocus="checkFocus(1,'adminPwdOneDiv')" /></td>
                        <td align="center"><div id="adminPwdOneDiv" class="tableDiv"></div>&nbsp;&nbsp;</td>
                    </tr>
                    <tr>
                        <td height="45" align="right">确认密码:&nbsp;</td>
                        <td valign="middle">&nbsp;<input type="text" name="adminPwdTwo" id="adminPwdTwo" 
                            onblur="adminPwdTwoblur()" onfocus="checkFocus(2,'adminPwdTwoDiv')" /></td>
                        <td align="center"><div id="adminPwdTwoDiv" class="tableDiv"></div>&nbsp;&nbsp;</td>
                    </tr>
                    <tr>
                        <td align="right"><input type="submit" value=" 确 定 " /></td>
                        <td>&nbsp;&nbsp;&nbsp;<input type="reset" value=" 重 置 " /></td>
                    </tr>
                </table>
            </form>
		</div>
	</div>
</body>
</html>
