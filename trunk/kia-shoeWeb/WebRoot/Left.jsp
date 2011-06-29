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
		<table width="100%" border="0" align="center" cellpadding="3" cellspacing="0">
		  <tr>
	  		<td class="title"><strong>&nbsp;品牌展示</strong></td>
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
</body>
</html>
