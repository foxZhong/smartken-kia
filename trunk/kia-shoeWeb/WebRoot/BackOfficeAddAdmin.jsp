<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��̨�������</title>
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
	function checkFocus(i,div){		//��ȡ������֤�¼�
		var name = new Array('adminName','adminPwdOne','adminPwdTwo');
		var promptOne = new Array('�������Ĺ���Ա�ʺ�,4~16λ��','Ϊ�����˺��������,4~16λ��','������һ�����롣');
		
		document.getElementById(div).innerHTML = promptOne[i];
		document.getElementById(name[i]).style.borderColor = "#00DAD6";
		document.getElementById(name[i]).style.backgroundColor = "#9AFFFF";
		document.getElementById(div).style.color = "#0000FF";
	}
	function checkForm(){
		if(adminNameblur() && adminPwdOneblur() && adminPwdTwoblur()){
			return true;
		}else{
			alert("���������Ϣ����.�����ҳ��ĺ����ʾ�޸�!");
			return false;
		}
	}
	function adminNameblur(){	//�ʺŵ���֤�¼�
		var AName = document.getElementById("adminName");
		var ANameDiv = document.getElementById("adminNameDiv");
		
		if(AName.value.length == 0){
			ANameDiv.innerHTML = "�ʺŲ���Ϊ�գ�";
			AName.style.borderColor = "#FE686C";
			ANameDiv.style.color = "#FF0000";
			AName.style.backgroundColor = "#FFFFFF";
			return false;
		}else if(AName.value.length < 4 || AName.value.length > 16){
			ANameDiv.innerHTML = "�ʺų��Ȳ���ȷ��";
			AName.style.borderColor = "#FE686C";
			ANameDiv.style.color = "#FF0000";
			AName.style.backgroundColor = "#FFFFFF";
			return false;
		}else{
			AName.style.borderColor = "";
			ANameDiv.style.color = "#00CC00";
			AName.style.backgroundColor = "#FFFFFF";
			ANameDiv.innerHTML = "�ʺ�����д��";
			return true;
		}
	}
	function adminPwdOneblur(){	//�������֤�¼�
		var APwdOne = document.getElementById("adminPwdOne");
		var APwdOneDiv = document.getElementById("adminPwdOneDiv");
		
		if(APwdOne.value.length == 0){
			APwdOneDiv.innerHTML = "���벻��Ϊ�գ�";
			APwdOne.style.borderColor = "#FE686C";
			APwdOneDiv.style.color = "#FF0000";
			APwdOne.style.backgroundColor = "#FFFFFF";
			return false;
		}else if(APwdOne.value.length < 4 || APwdOne.value.length > 16){
			APwdOneDiv.innerHTML = "���볤�Ȳ���ȷ��";
			APwdOne.style.borderColor = "#FE686C";
			APwdOneDiv.style.color = "#FF0000";
			APwdOne.style.backgroundColor = "#FFFFFF";
			return false;
		}else{
			APwdOne.style.borderColor = "";
			APwdOneDiv.style.color = "#00CC00";
			APwdOne.style.backgroundColor = "#FFFFFF";
			APwdOneDiv.innerHTML = "��������д��";
			return true;
		}
	}
	function adminPwdTwoblur(){	//ȷ���������֤�¼�
		var APwdOne = document.getElementById("adminPwdOne");
		var APwdTwo = document.getElementById("adminPwdTwo");
		var APwdTwoDiv = document.getElementById("adminPwdTwoDiv");
		
		if(APwdTwo.value.length == 0){
			APwdTwoDiv.innerHTML = "ȷ�����벻��Ϊ�գ�";
			APwdTwo.style.borderColor = "#FE686C";
			APwdTwoDiv.style.color = "#FF0000";
			APwdTwo.style.backgroundColor = "#FFFFFF";
			return false;
		}else if(APwdTwo.value.length < 4 || APwdTwo.value.length > 16){
			APwdTwoDiv.innerHTML = "ȷ�����볤�Ȳ���ȷ��";
			APwdTwo.style.borderColor = "#FE686C";
			APwdTwoDiv.style.color = "#FF0000";
			APwdTwo.style.backgroundColor = "#FFFFFF";
			return false;
		}else if(APwdOne.value != APwdTwo.value){
			APwdTwoDiv.innerHTML = "�����������벻һ�£�";
			APwdTwo.style.borderColor = "#FE686C";
			APwdTwoDiv.style.color = "#FF0000";
			APwdTwo.style.backgroundColor = "#FFFFFF";
			return false;
		}else{
			APwdTwo.style.borderColor = "";
			APwdTwoDiv.style.color = "#00CC00";
			APwdTwo.style.backgroundColor = "#FFFFFF";
			APwdTwoDiv.innerHTML = "��������һ�¡�";
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
				<td>ϵͳ��̨�������</td>
			</tr>
			<tr align="center">
				<td><a href="javascript:onClick('1');" class="font">�û�����</a><div id="d1" style="display:none;">
						<table id="menu" border="1" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td><a href="BackOfficeAddAdmin.jsp">			
									<span class="left"></span>
										��ӹ���Ա
									<span class="right"></span></a></td>
							</tr>
							<tr>
								<td><a href="BackOfficeUser.jsp">
									<span class="left"></span>
										�û�����
									<span class="right"></span></a></td>
							</tr>
						</table></div></td>
			</tr>
			<tr align="center">
				<td><a href="javascript:onClick('2');" class="font">��Ʒ����</a><div id="d2" style="display:none;">
						<table id="menu" border="1" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td><a href="BackOfficeAddWare.jsp">			
									<span class="left"></span>
										�����Ʒ
									<span class="right"></span></a></td>
							</tr>
							<tr>
								<td><a href="BackOfficeSuperviseWare.jsp">
									<span class="left"></span>
										������Ʒ
									<span class="right"></span></a></td>
							</tr>
						</table></div></td>
			</tr>
			<tr align="center">
				<td><a href="javascript:onClick('3');" class="font">���Ź���</a><div id="d3" style="display:none;">
						<table id="menu" border="1" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td><a href="BackOfficeAddNews.jsp">
									<span class="left"></span>
										�������
									<span class="right"></span></a></td>
							</tr>
							<tr>
								<td><a href="BackOfficeSuperviseNews.jsp">
									<span class="left"></span>
										��������
									<span class="right"></span></a></td>
							</tr>
						</table></div></td>
			</tr>
			<tr align="center">
				<td><a href="javascript:onClick('4');" class="font">��������</a><div id="d4" style="display:none;">
						<table id="menu" border="1" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td><a href="BackOfficeSystem.jsp">
									<span class="left"></span>
										�鿴����
									<span class="right"></span></a></td>
							</tr>						
						</table></div></td>
			</tr>
			<tr align="center">
				<td><a href="manage/doLogout.jsp" class="font">[��ȫ�ǳ�]</a></td>
			</tr>
		</table>
	</div>
	<div style="float: left;width:82%; height:550px; border:solid #698CC3 1px; border-left-width:15px; background-color:#F1F7F9;">
		<div style="position:relative; top:30px; left:35px; width:750px; border:solid #698CC3 1px;">
            <form action="manage/doAddAdmin.jsp" method="post" name="regForm" id="regForm" onsubmit="return checkForm()">
                <table class="font" width="100%" height="100%" border="0" bordercolor="#D6E0EF" cellpadding="3" cellspacing="0">
                    <tr>
                        <td colspan="3" bgcolor="#698CC3" class="font1">��ӹ���Ա�ʺ�</td>
                    </tr>
                    <tr>
                        <td width="25%" height="35"  align="right">��&nbsp;&nbsp;��:&nbsp;</td>
                        <td width="30%" valign="middle">&nbsp;<input type="text" name="adminName" id="adminName"
                            onblur="adminNameblur()" onfocus="checkFocus(0,'adminNameDiv')" /></td>
                        <td width="46%" align="center"><div id="adminNameDiv" class="tableDiv"></div>&nbsp;&nbsp;</td>
                    </tr>
                    <tr>
                        <td height="35" align="right">��&nbsp;&nbsp;��:&nbsp;</td>
                        <td valign="middle">&nbsp;<input type="text" name="adminPwdOne" id="adminPwdOne" 
                            onblur="adminPwdOneblur()" onfocus="checkFocus(1,'adminPwdOneDiv')" /></td>
                        <td align="center"><div id="adminPwdOneDiv" class="tableDiv"></div>&nbsp;&nbsp;</td>
                    </tr>
                    <tr>
                        <td height="45" align="right">ȷ������:&nbsp;</td>
                        <td valign="middle">&nbsp;<input type="text" name="adminPwdTwo" id="adminPwdTwo" 
                            onblur="adminPwdTwoblur()" onfocus="checkFocus(2,'adminPwdTwoDiv')" /></td>
                        <td align="center"><div id="adminPwdTwoDiv" class="tableDiv"></div>&nbsp;&nbsp;</td>
                    </tr>
                    <tr>
                        <td align="right"><input type="submit" value=" ȷ �� " /></td>
                        <td>&nbsp;&nbsp;&nbsp;<input type="reset" value=" �� �� " /></td>
                    </tr>
                </table>
            </form>
		</div>
	</div>
</body>
</html>
