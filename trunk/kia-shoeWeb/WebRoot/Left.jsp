<%@ page language="java" import="java.util.*,shoes.entity.*,shoes.dao.*" pageEncoding="GB18030"%>
<jsp:directive.page import="shoes.dao.impl.BrandDaoImpl"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>left</title>
<!--
<link rel="stylesheet" type="text/css" href="css/left.css">
-->
<script type="text/javascript" src="javascript/jquery.js"></script>
<script type="text/javascript" src="javascript/sliding_effect.js"></script>
<script language="javascript" type="text/javascript">
function displayDetail(type, opt) {
	var displayP = window.document.getElementById(type);
	if (type == 'd1') {
		if (opt == 1) {
			displayP.innerHTML = '<p>���Եģ������������Ǿ�Ӫ��Χ�ڵ�Ʒ�ƣ����������Ʒ��ר����ͬ�����ۣ��п��ܻ�����ϻ�����������Բ������ǵ�ȫ����ѿͷ��绰400-8810-400��ѯר����Ļ�Ʒ������ֻ��绰������ṩ��Ʒ�ĳ����ı�׼���š�[<a class="font4" href="#" onclick="displayDetail(\'d1\',0);return false;" title="������ϸ">������ϸ</a>]</p>';
		} else {
			displayP.innerHTML = '<p>���Եģ������������Ǿ�Ӫ��Χ�ڵ�Ʒ�ƣ����������Ʒ��ר����ͬ�����ۣ���...[<a class="font4" href="#" onclick="displayDetail(\'d1\',1);return false;" title="�鿴��ϸ">�鿴��ϸ</a>]</p>';
		}
	}else if (type == 'd2') {
		if (opt == 1) {
			displayP.innerHTML = '<p>��Ԥ����Ʒ����ָ��ǰ������δ��ʽ���е���Ʒ����Ϊ����������Ʒ���߹���������Ʒ��Ϊ�����ܼ�ʱ�յ�����������Ʒ����������Ԥ����Ʒ�����¶�������[<a class="font4" href="#" onclick="displayDetail(\'d2\',0);return false;" title="������ϸ">������ϸ</a>]</p>';
		} else {
			displayP.innerHTML = '<p>��Ԥ����Ʒ����ָ��ǰ������δ��ʽ���е���Ʒ����Ϊ����������Ʒ���߹���...[<a class="font4" href="#" onclick="displayDetail(\'d2\',1);return false;" title="�鿴��ϸ">�鿴��ϸ</a>]</p>';
		}
	}
}
function allForm(){
	var uName = document.getElementById("userName");
    var uPass = document.getElementById("passWord");
    var yz = document.getElementById("yanzheng");
    if(uName.value==""){
    	yz.className="font3";
    	yz.innerHTML="�û�������Ϊ�գ�";
    	return false;
    }
    if(uPass.value==""){
    	yz.className="font3";
    	yz.innerHTML="���벻��Ϊ�գ�";
    	return false;    
    }
    return true;
}
</script>
</head>

<body>
<div style="width:100%;">
  <table width="100%" border="1" bordercolor="#D6D6D6" align="left" cellpadding="0" cellspacing="10">
    <tr>
      <td>
      	<%  if(session.getAttribute("user")!=null) 
		  {%>
		  <table width="100%" border="0" align="center" cellpadding="3" cellspacing="0">
			<tr>
			  <td class="title">&nbsp;<strong>������Ϣ</strong></td>
			</tr>
			
			<tr>
			  <td align="center" class="font2"><br />���ã�<span class=font4>${user.UName }</span><br />��ӭ����T03Ь������
			  </td>
		    </tr>
		    <tr>
		    	<td align="center"><a href="manage/doLogout.jsp">[�ǳ�]</a></td>
		    </tr>
	      </table>
	      <%} %>
		<form action="manage/doLogin.jsp" method="post" onSubmit="return allForm()">
		<%  if(session.getAttribute("user")==null) 
		  {%>
		  <table width="100%" border="0" align="center" cellpadding="3" cellspacing="0">
			<tr>
			  <td colspan="2" class="title">&nbsp;<strong>�û���¼</strong></td>
			</tr>
			
			<tr>
			  <td align="right" class="font2">�˺ţ�</td>
			  <td><label>
				<input name="userName" type="text" id="userName" />
			  </label></td>
			</tr>
			<tr>
			  <td align="right" class="font2">���룺</td>
			  <td><label>
				<input name="passWord" type="password" id="passWord" />
			  </label></td>
			</tr>
			<tr>
				<td height="22px" colspan="2" align="center"><span width="100%" id="yanzheng"></span></td>
			</tr>
			<tr>
			  <td colspan="2" align="center"><label>
				<input name="login" type="submit" id="login" value=" ��  ¼ " />
			  </label></td>
			</tr>
			<tr>
			  <td colspan="2" align="right" class="font4">��û���˺ţ�<a href="Reg.jsp">����ȥע��һ��</a></td>
			</tr>
		  </table>
		  <%} %>
		</form>
	  </td>
    </tr>
    <tr>
		<td>
		<table width="100%" border="0" align="center" cellpadding="3" cellspacing="0">
		  <tr>
	  		<td class="title"><strong>&nbsp;Ʒ��չʾ</strong></td>
		  </tr>
		  <tr>
            <td align="left"><div id="navigation-block"><div id="sliding-navigation">
            <% 
            	BrandDao brandDao = new BrandDaoImpl();
            	List list = brandDao.findAllBrand();
            	for(int i=0;i<list.size();i++){
            		Brand brand = (Brand)(list.get(i));
            %>
            	<li class="sliding-element"><a href="ShoesType.jsp?cbId=<%=brand.getBId() %>&current=1"><img src="image/<%=brand.getBPicture() %>.gif" alt="<%=brand.getBCName() %>" width="159" height="25" /></a></li>
            <%} %>
            </div></div></td>
		  </tr>
		</table></td>
	</tr>
	<tr>
		<td><table width="100%" border="0" align="center" cellpadding="3" cellspacing="0">
			<tr>
				<td class="title">&nbsp;<strong>��վ����</strong></td>
			</tr>
			<tr>
				<td align=center class=font4><br /><marquee scrolldelay=100>Ӫҵʱ��  9:00~22:00</marquee><br /><br /></td>
			</tr>
		</table></td>
	</tr>
    <tr>
      <td><table width="100%" border="0" align="center" cellpadding="3" cellspacing="0">
        <tr>
          <td class="title">&nbsp;<strong>��������</strong></td>
          </tr>
        <tr>
          <td>1���ҿ��Թ���T03Ь����վ��û�е���Ʒô�� </td>
        </tr>
        <tr>
          <td id=d1 class="font2"><p>���Եģ������������Ǿ�Ӫ��Χ�ڵ�Ʒ�ƣ����������Ʒ��ר����ͬ�����ۣ���...[<a class="font4" href="#" onclick="displayDetail('d1',1);return false;"title="�鿴��ϸ">�鿴��ϸ</a>]</p></td>
        </tr>
        <tr>
          <td>2��ʲô��Ԥ����Ʒ������Ԥ����Ʒ�빺��������������Ʒ�кβ�ͬ��</td>
        </tr>
        <tr>
          <td id=d2 class="font2"><p>��Ԥ����Ʒ����ָ��ǰ������δ��ʽ���е���Ʒ����Ϊ����������Ʒ���߹���...[<a class="font4" href="#" onclick="displayDetail('d2',1);return false;"title="�鿴��ϸ">�鿴��ϸ</a>]</p></td>
        </tr>
      </table></td>
    </tr>
  </table>
</div>
</body>
</html>
