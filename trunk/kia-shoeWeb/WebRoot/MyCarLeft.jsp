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
<title>MyCarLeft</title>

<link rel="stylesheet" type="text/css" href="css/left.css">
<script type="text/javascript" src="javascript/left.js"></script>

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
		<div id="control">
		  <table class=title width="100%"  border="0" cellpadding="0" cellspacing="0">
		    <tr>
				  <td width="100%" align="center" class="tabTit" ><li id="testtab" style="float:right"><a href="#" onClick="Effect('test',this.parentNode.id);" >+</a> </li><li style="float:left"><a href="#" onClick="Effect('test');" class="testLink">我的信息</a></li></td>
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
		      <td width="100%" align="center" class="tabTit" ><li id="test1tab" style="float:right"><a href="#" onClick="Effect('test1',this.parentNode.id);" >+</a> </li><li style="float:left"><a href="#" onClick="Effect('test1');" class="testLink">收货地址</a></li></td>
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
		      <td width="100%" align="center" class="tabTit" ><li id="test2tab" style="float:right"><a href="#" onClick="Effect('test2',this.parentNode.id);" >+</a> </li><li style="float:left"><a href="#" onClick="Effect('test2');" class="testLink">我的买卖</a></li></td>
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
</body>
</html>
