<%@ page language="java" import="java.util.*,shoes.dao.impl.*,shoes.dao.*,shoes.entity.*" pageEncoding="GB18030"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>Checkout</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/myCar.css" />
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<link rel="stylesheet" type="text/css" href="css/left.css">
	<link rel="stylesheet" type="text/css"  href="css/mouse.css" />
	<script type="text/javascript" src="javascript/mouse.js"></script>	
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
function $G(Read_Id) { return document.getElementById(Read_Id) }
function Effect(ObjectId,parentId){
var Obj_Display = $G(ObjectId).style.display;
	if (Obj_Display == 'none'){
	Start(ObjectId,'Opens');
	$G(parentId).innerHTML = "<a href=Checkout.jsp# onClick=javascript:Effect('"+ObjectId+"','"+parentId+"');>-</a>"
	}else{ 
	Start(ObjectId,'Close');
	$G(parentId).innerHTML = "<a href=Checkout.jsp# onClick=javascript:Effect('"+ObjectId+"','"+parentId+"');>+</a>"
	}
}
function Start(ObjId,method){
var BoxHeight = $G(ObjId).offsetHeight;   			//��ȡ����߶�
var MinHeight = 5;									//���������С�߶�
var MaxHeight = 30;					 			//����������߶�
var BoxAddMax = 1;									//��������ʼֵ
var Every_Add = 0.1;								//ÿ�εĵ�(��)����  [��ֵԽ���ٶ�Խ��]
var Reduce    = (BoxAddMax - Every_Add);
var Add       = (BoxAddMax + Every_Add);
//�رն���**************************************
if (method == "Close"){
var Alter_Close = function(){						//����һ�������[�ݼ�]ѭ��
	BoxAddMax /= Reduce;
	BoxHeight -= BoxAddMax;
	if (BoxHeight <= MinHeight){
		$G(ObjId).style.display = "none";
		window.clearInterval(BoxAction);
	}
	else $G(ObjId).style.height = BoxHeight;
}
var BoxAction = window.setInterval(Alter_Close,1);
}
//�򿪶���**************************************
else if (method == "Opens"){
var Alter_Opens = function(){
	BoxAddMax *= Add;
	BoxHeight += BoxAddMax;
	if (BoxHeight >= MaxHeight){
		$G(ObjId).style.height = MaxHeight;
		window.clearInterval(BoxAction);
	}else{
	$G(ObjId).style.display= "block";
	$G(ObjId).style.height = BoxHeight;
	}
}
var BoxAction = window.setInterval(Alter_Opens,1);
}
}
</script>
  </head>
  
  <body>
<div id="top"><jsp:include page="Top.jsp"></jsp:include></div>
<div id="left" style="float:left;width:23%;">
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
		<div id="control">
		  <table class=title width="100%"  border="0" cellpadding="0" cellspacing="0">
		    <tr>
				  <td width="100%" align="center" class="tabTit" ><li id="testtab" style="float:right"><a href="Checkout.jsp#" onClick="Effect('test',this.parentNode.id);" >+</a> </li><li style="float:left"><a href="Checkout.jsp#" onClick="Effect('test');" class="testLink">�ҵ���Ϣ</a></li></td>
		    </tr>
		  </table>
		</div>
		<div id="test" class="test" style="display:none;">
		  <table width="100%"  border="0" cellpadding="4" cellspacing="0" bgcolor="#EEEEEE">
		    <tr>
		      <td colspan="3" align="center" valign="top"><ul><li><a href="UpdateUserInfo.jsp">�޸�����</a></li></ul></td>
		    </tr>
		  </table>
		</div>
		
		<div id="control">
		  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
		    <tr>
		      <td width="100%" align="center" class="tabTit" ><li id="test1tab" style="float:right"><a href="Checkout.jsp#" onClick="Effect('test1',this.parentNode.id);" >+</a> </li><li style="float:left"><a href="Checkout.jsp#" onClick="Effect('test1');" class="testLink">�ջ���ַ</a></li></td>
		    </tr>
		  </table>
		</div>
		<div id="test1" class="test" style="display:none;">
		  <table width="100%"  border="0" cellpadding="4" cellspacing="0" bgcolor="#EEEEEE">
		    <tr>
		      <td colspan="3" align="center" valign="top"><ul><li><a href="AddAddress.jsp">��ӵ�ַ</a></li></ul></td>
		    </tr>
		  </table>
		</div>
		
		<div id="control">
		  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
		    <tr>
		      <td width="100%" align="center" class="tabTit" ><li id="test2tab" style="float:right"><a href="Checkout.jsp#" onClick="Effect('test2',this.parentNode.id);" >+</a> </li><li style="float:left"><a href="Checkout.jsp#" onClick="Effect('test2');" class="testLink">�ҵ�����</a></li></td>
		    </tr>
		  </table>
		</div>
		<div id="test2" class="test" style="display:none;">
		  <table width="100%"  border="0" cellpadding="4" cellspacing="0" bgcolor="#EEEEEE">
		    <tr>
		      <td colspan="3" align="center" valign="top"><ul><li><a href="Orders.jsp">�ҵĶ���&nbsp;&nbsp;</a></li></ul></td>
		    </tr>
		  </table>
		</div></td>
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
<div style="float:right;width:75%">
  <div class="top">
  	<img src="image/cart_001.gif" />
  </div>
  <div id="nifty">
	<b class="rtop"><b class="r1"></b><b class="r2"></b><b class="r3"></b><b class="r4"></b></b>
	&nbsp;&nbsp;<b>��ѡ���ַ</b>
  </div>
  <% 
    UserInfo user=(UserInfo)session.getAttribute("user"); 
    DeliveryInfoDao dedao=new DeliveryInfoDaoImpl();
    List dels=dedao.findAllDeliveryInfo(user.getUId());
    Iterator it=dels.iterator();
  %>
  <table border="5" id="bigTable" cellpadding="10" cellspacing="0">
	<tr>
	  <td width="90%" align="center">
	  <DIV>
	  	<table border="1" align="center" width="90%" cellpadding="0" cellspacing="0">
			  <tr class="tr">
			  	<td align="center">ѡ��</td>
				<td align="center">����</td>
				<td align="center">�绰</td>
				<td align="center">��ַ</td>
			  </tr>
		  </table>
		  <DIV class="cartmore" style="height: 200px">
			  <form action="manage/doCheckOut.jsp" method="post" id="deliForm">
				  <table border="0" align="center" width="97%" cellpadding="10" cellspacing="0">
				      <%  while(it.hasNext())
				     	{   DeliveryInfo di=(DeliveryInfo)it.next();
				      %>
					  <tr>
					  	<td align="center"><input name="odId" type="radio" value="<%=di.getDId() %>" checked="checked"/></td>
						<td align="center"><%=di.getDName() %></td>
						<td align="center"><%=di.getTel() %></td>
						<td align="center"><%=di.getAddress() %></td>
					  </tr>
					  <%} %>
				  </table>
			  </form>		  
		  </DIV>
	  </DIV>
	  </td>
	</tr>
    <tr>
  	  <td align=right colspan=4><img onclick="doCheckOut()" src="image/Buy.gif" /></td>
  	  <script language="javascript" type="text/javascript">
  	    function doCheckOut()
  	    {
  	    	alert("����ɹ����ȴ����ҷ�����");
  	      	document.getElementById("deliForm").submit();
  	    }
  	  </script>
    </tr>	
  </table>
</div>
<div><jsp:include page="Bottom.jsp"></jsp:include></div>
  </body>
</html>
