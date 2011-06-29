<%@ page language="java" import="java.util.*,shoes.entity.*" pageEncoding="GB18030"%>
<jsp:directive.page import="shoes.dao.*"/>
<jsp:directive.page import="shoes.dao.impl.*"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>UpdateUserInfo</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<link rel="stylesheet" type="text/css" href="css/left.css">
	<link rel="stylesheet" type="text/css"  href="css/mouse.css" />
	<script type="text/javascript" src="javascript/mouse.js"></script>	
<script language="javascript" type="text/javascript">
function displayDetail(type, opt) {
	var displayP = window.document.getElementById(type);
	if (type == 'd1') {
		if (opt == 1) {
			displayP.innerHTML = '<p>可以的，但必须是我们经营范围内的品牌，由于这类货品跟专卖店同步销售，有可能会产生断货情况。您可以拨打我们的全国免费客服电话400-8810-400查询专卖店的货品情况，手机电话查货请提供产品的出厂的标准货号。[<a class="font4" href="#" onclick="displayDetail(\'d1\',0);return false;" title="隐藏详细">隐藏详细</a>]</p>';
		} else {
			displayP.innerHTML = '<p>可以的，但必须是我们经营范围内的品牌，由于这类货品跟专卖店同步销售，有...[<a class="font4" href="#" onclick="displayDetail(\'d1\',1);return false;" title="查看详细">查看详细</a>]</p>';
		}
	}else if (type == 'd2') {
		if (opt == 1) {
			displayP.innerHTML = '<p>“预售商品”是指提前发售尚未正式发行的商品，多为限量纪念版产品或者国外限量产品，为了您能及时收到正常发货商品，建议您将预售商品单独下订单购买。[<a class="font4" href="#" onclick="displayDetail(\'d2\',0);return false;" title="隐藏详细">隐藏详细</a>]</p>';
		} else {
			displayP.innerHTML = '<p>“预售商品”是指提前发售尚未正式发行的商品，多为限量纪念版产品或者国外...[<a class="font4" href="#" onclick="displayDetail(\'d2\',1);return false;" title="查看详细">查看详细</a>]</p>';
		}
	}
}
function allForm(){
	var uName = document.getElementById("userName");
    var uPass = document.getElementById("passWord");
    var yz = document.getElementById("yanzheng");
    if(uName.value==""){
    	yz.className="font3";
    	yz.innerHTML="用户名不能为空！";
    	return false;
    }
    if(uPass.value==""){
    	yz.className="font3";
    	yz.innerHTML="密码不能为空！";
    	return false;    
    }
    return true;
}
function $G(Read_Id) { return document.getElementById(Read_Id) }
function Effect(ObjectId,parentId){
var Obj_Display = $G(ObjectId).style.display;
	if (Obj_Display == 'none'){
	Start(ObjectId,'Opens');
	$G(parentId).innerHTML = "<a href=UpdateUserInfo.jsp# onClick=javascript:Effect('"+ObjectId+"','"+parentId+"');>-</a>"
	}else{ 
	Start(ObjectId,'Close');
	$G(parentId).innerHTML = "<a href=UpdateUserInfo.jsp# onClick=javascript:Effect('"+ObjectId+"','"+parentId+"');>+</a>"
	}
}
function Start(ObjId,method){
var BoxHeight = $G(ObjId).offsetHeight;   			//获取对象高度
var MinHeight = 5;									//定义对象最小高度
var MaxHeight = 30;					 			//定义对象最大高度
var BoxAddMax = 1;									//递增量初始值
var Every_Add = 0.1;								//每次的递(减)增量  [数值越大速度越快]
var Reduce    = (BoxAddMax - Every_Add);
var Add       = (BoxAddMax + Every_Add);
//关闭动作**************************************
if (method == "Close"){
var Alter_Close = function(){						//构建一个虚拟的[递减]循环
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
//打开动作**************************************
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
<div style="width:100%;">
  <table width="100%" border="1" bordercolor="#D6D6D6" align="left" cellpadding="0" cellspacing="10">
    <tr>
      <td>
      	<%  if(session.getAttribute("user")!=null) 
		  {%>
		  <table width="100%" border="0" align="center" cellpadding="3" cellspacing="0">
			<tr>
			  <td class="title">&nbsp;<strong>个人信息</strong></td>
			</tr>
			
			<tr>
			  <td align="center" class="font2"><br />您好：<span class=font4>${user.UName }</span><br />欢迎来到T03鞋城网！
			  </td>
		    </tr>
		    <tr>
		    	<td align="center"><a href="manage/doLogout.jsp">[登出]</a></td>
		    </tr>
	      </table>
	      <%} %>
		<form action="manage/doLogin.jsp" method="post" onSubmit="return allForm()">
		<%  if(session.getAttribute("user")==null) 
		  {%>
		  <table width="100%" border="0" align="center" cellpadding="3" cellspacing="0">
			<tr>
			  <td colspan="2" class="title">&nbsp;<strong>用户登录</strong></td>
			</tr>
			
			<tr>
			  <td align="right" class="font2">账号：</td>
			  <td><label>
				<input name="userName" type="text" id="userName" />
			  </label></td>
			</tr>
			<tr>
			  <td align="right" class="font2">密码：</td>
			  <td><label>
				<input name="passWord" type="password" id="passWord" />
			  </label></td>
			</tr>
			<tr>
				<td height="22px" colspan="2" align="center"><span width="100%" id="yanzheng"></span></td>
			</tr>
			<tr>
			  <td colspan="2" align="center"><label>
				<input name="login" type="submit" id="login" value=" 登  录 " />
			  </label></td>
			</tr>
			<tr>
			  <td colspan="2" align="right" class="font4">还没有账号？<a href="Reg.jsp">马上去注册一个</a></td>
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
				  <td width="100%" align="center" class="tabTit" ><li id="testtab" style="float:right"><a href="UpdateUserInfo.jsp#" onClick="Effect('test',this.parentNode.id);" >+</a> </li><li style="float:left"><a href="UpdateUserInfo.jsp#" onClick="Effect('test');" class="testLink">我的信息</a></li></td>
		    </tr>
		  </table>
		</div>
		<div id="test" class="test" style="display:none;">
		  <table width="100%"  border="0" cellpadding="4" cellspacing="0" bgcolor="#EEEEEE">
		    <tr>
		      <td colspan="3" align="center" valign="top"><ul><li><a href="UpdateUserInfo.jsp">修改资料</a></li></ul></td>
		    </tr>
		  </table>
		</div>
		
		<div id="control">
		  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
		    <tr>
		      <td width="100%" align="center" class="tabTit" ><li id="test1tab" style="float:right"><a href="UpdateUserInfo.jsp#" onClick="Effect('test1',this.parentNode.id);" >+</a> </li><li style="float:left"><a href="UpdateUserInfo.jsp#" onClick="Effect('test1');" class="testLink">收货地址</a></li></td>
		    </tr>
		  </table>
		</div>
		<div id="test1" class="test" style="display:none;">
		  <table width="100%"  border="0" cellpadding="4" cellspacing="0" bgcolor="#EEEEEE">
		    <tr>
		      <td colspan="3" align="center" valign="top"><ul><li><a href="AddAddress.jsp">添加地址</a></li></ul></td>
		    </tr>
		  </table>
		</div>
		
		<div id="control">
		  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
		    <tr>
		      <td width="100%" align="center" class="tabTit" ><li id="test2tab" style="float:right"><a href="UpdateUserInfo.jsp#" onClick="Effect('test2',this.parentNode.id);" >+</a> </li><li style="float:left"><a href="UpdateUserInfo.jsp#" onClick="Effect('test2');" class="testLink">我的买卖</a></li></td>
		    </tr>
		  </table>
		</div>
		<div id="test2" class="test" style="display:none;">
		  <table width="100%"  border="0" cellpadding="4" cellspacing="0" bgcolor="#EEEEEE">
		    <tr>
		      <td colspan="3" align="center" valign="top"><ul><li><a href="Orders.jsp">我的订单&nbsp;&nbsp;</a></li></ul></td>
		    </tr>
		  </table>
		</div></td>
    </tr>
	<tr>
		<td><table width="100%" border="0" align="center" cellpadding="3" cellspacing="0">
			<tr>
				<td class="title">&nbsp;<strong>网站公告</strong></td>
			</tr>
			<tr>
				<td align=center class=font4><br /><marquee scrolldelay=100>营业时间  9:00~22:00</marquee><br /><br /></td>
			</tr>
		</table></td>
	</tr>
    <tr>
      <td><table width="100%" border="0" align="center" cellpadding="3" cellspacing="0">
        <tr>
          <td class="title">&nbsp;<strong>常见问题</strong></td>
          </tr>
        <tr>
          <td>1、我可以购买T03鞋城网站上没有的商品么？ </td>
        </tr>
        <tr>
          <td id=d1 class="font2"><p>可以的，但必须是我们经营范围内的品牌，由于这类货品跟专卖店同步销售，有...[<a class="font4" href="#" onclick="displayDetail('d1',1);return false;"title="查看详细">查看详细</a>]</p></td>
        </tr>
        <tr>
          <td>2、什么是预售商品？购买预售商品与购买正常发货的商品有何不同？</td>
        </tr>
        <tr>
          <td id=d2 class="font2"><p>“预售商品”是指提前发售尚未正式发行的商品，多为限量纪念版产品或者国外...[<a class="font4" href="#" onclick="displayDetail('d2',1);return false;"title="查看详细">查看详细</a>]</p></td>
        </tr>
      </table></td>
    </tr>    
  </table>
</div>
</div>
<div style="float:right;width:75%">
<% 
	UserInfo user = new UserInfo();
	if(session.getAttribute("user")!=null){
		user=(UserInfo)session.getAttribute("user");
	}
	UserInfoDao uDao = new UserInfoDaoImpl();
	user = uDao.findUser(user.getUId());
%>
<form action="manage/doUpdateUser.jsp" method="post">
	<input type="hidden" name="uId" value="<%=user.getUId() %>">
	<input type="hidden" name="uName" value="<%=user.getUName() %>">
	<div><br /><br /><br /><br /><br />
		<table width="100%" cellpadding="20" cellspacing="0" style="border:solid #0066FF 1px;">
			<tr>
				<th colspan="2" align="left">修改资料</th>
			</tr>
			<tr>
				<td colspan="2"><hr /></td>
			</tr>
			<tr>
				<td width="15%">登陆名：</td>
				<td width="85%"><%=user.getUName() %></td>
			</tr>
			<tr>
				<td>旧密码：</td>
				<td><input name="pass1" type="text" value="" /></td>
			</tr>
			<tr>
				<td>新密码：</td>
				<td><input name="pass2" type="text" value="" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="修 改" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重 置" /></td>
			</tr>
		</table>
	</div>
</form>
</div>
<div><jsp:include page="Bottom.jsp"></jsp:include></div>
</body>
</html>
