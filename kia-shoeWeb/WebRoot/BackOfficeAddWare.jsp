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
	<div style="float: left;width:80%; height:550px; border:solid #698CC3 1px; border-left-width:15px; background-color:#F1F7F9;">
	  <div style="position:relative; top:20px; left:35px; width:80%; height:500px; border:solid #698CC3 1px;">
	    <form>
	      <table class="font" width="100%" height="100%" border="1" bordercolor="#D6E0EF" cellpadding="10" cellspacing="0">
	        <tr>
	          <td colspan="2" bgcolor="#698CC3" class="font1">�����Ʒ</td>
	        </tr>
	        <tr>
	          <th width="30%">��Ʒ����</th>
	          <th width="70%" height="26" colspan="10"><label>
	            <select name="select2">
	              <option>nike</option>
	              <option>adidas</option>
	            </select>
	          </label></th>
	        </tr>
	        <tr>
	          <th>Ʒ������</th>
	          <th><label>
	            <select name="select3">
	              <option>adidas</option>
	            </select>
	          </label></th>
	        </tr>
	        <tr>
	          <th>Ь������</th>
	          <th><label>
	            <input type="text" name="textfield3" />
	          </label></th>
	        </tr>
	        <tr>
	          <th>�ߴ�</th>
	          <th><label>
	            <input type="text" name="textfield4" />
	          </label></th>
	        </tr>
	        <tr>
	          <th>��ʽ</th>
	          <th><label>
	            <select name="select">
	              <option>�п�</option>
	              <option>Ů��</option>
	            </select>
	          </label></th>
	        </tr>
	        <tr>
	          <th>��Ǯ</th>
	          <th><input type="text" name="textfield42" /></th>
	        </tr>
	        <tr>
	          <th>��������</th>
	          <th><input type="text" name="textfield43" /></th>
	        </tr>
	        <tr>
	          <th>���</th>
	          <th><input type="text" name="textfield44" /></th>
	        </tr>
	        <tr>
	          <th>���ʱ��</th>
	          <th><input type="text" name="textfield45" /></th>
	        </tr>
	        <tr>
	          <th  colspan="2" align="left">����������������������������������
	              <input type="submit" value="�ύ" />  
	              <input type="reset" value="����" /></th>
	        </tr>
	      </table>
	    </form>
	  </div>
	</div>
</body>
</html>
