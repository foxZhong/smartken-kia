<%@ page language="java" import="java.util.*,shoes.entity.*,shoes.dao.*,shoes.dao.impl.*" pageEncoding="GB18030"%>
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
function onfocusText(){
	
}
</script>
<link rel="stylesheet" type="text/css" href="css/BackOfficeSystem.css">

<%
	UserInfoDao uid = new UserInfoDaoImpl();
	List list = uid.findAllUser();
%>
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
			<form>
				<table class="font" width="100%" height="100%" border="1" bordercolor="#D6E0EF" cellpadding="0" cellspacing="0">
					<tr>
						<td colspan="4" bgcolor="#698CC3" class="font1">�û���Ϣ</td>
					</tr>
                    <tr>
                    	<th>�û���</th>
                        <th>����</th>
						<th>�ȼ�</th>
						<th>����</th>
                    </tr>
					<%
						String del;
						String level = "";
                    	for(int i=0; i<list.size(); i++) {
                    		UserInfo userInfo = (UserInfo)list.get(i);
                    		if(userInfo.getULevel().equals("admin")) {
                    			level = "����Ա";
                    			del="&nbsp;";
                    		}else {
                    			level = "��ͨ�û�";
                    			del="ɾ��";
                    		}
                    %>
				    <tr>
				  	    <td align="center"><%=userInfo.getUName() %></td>
				  	    <td align="center"><%=level=="����Ա"?"****":userInfo.getUPass() %></td>
						<td align="center"><%=level %></td>
				  	    <td align="center" name=del><a id=del href="manage/doDeleteUser.jsp?UId=<%=userInfo.getUId() %>"><%=del %></a></td>
				    </tr>
					<%} %>
				</table>
		  </form>
		</div>
	</div>
</body>
</html>
