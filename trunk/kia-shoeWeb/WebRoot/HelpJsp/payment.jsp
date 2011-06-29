<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>付款方式</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/styles.css">

	<link rel="stylesheet" type="text/css"  href="css/mouse.css" />
	<script type="text/javascript" src="../javascript/mouse.js"></script>
  </head>
  
  <body>
<div id="top"><jsp:include page="../Top.jsp"></jsp:include></div>
<div>
	<table border="1" width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td class="title"><strong>付款方式如下：</strong></td>
		</tr>
		<tr>
			<td>
				<p class="beijing"><strong>一、网上支付</strong></p>
				<br />
				<p class="td">支付宝 
				网银在线支付平台<img src="image/3.jpg" width="123" height="40" />点击此图标进入<br />
				（需信用卡或开通过网上支付功能的银行卡才可以进行网上付款）<br />
				支付宝 帐号：T03Shoes@shopping.com（去T03Shoes购物网进行在线付款,付款到该帐号）<br /> 
				支付宝付款成功后，请及时通知我们。
			  </p>
			</td>
		</tr>
		<tr>
		  <td>
			  <p class="beijing"><strong>二、银行汇款 & 转帐</strong></p>
				<br />
				<p class="td">银 行 开户银行 卡 号 户 名<br />
				中国工商银行 中国工商银行广州市 9558 8010 0115 0992805 史业嘉 <br />
				中国农业银行 中国农业银行广州市 95599 8003 04013 60810 刘志荣 <br />
				中国建设银行 广州市 4367 4212 1735 4480 592 吕思维 <br />
				中国交通银行 广州市 622260 0110004639279 林海晖<br />
				中国银行 中国银行 广州市4563510800012683354 唐毅<br /> 
				招商银行 广州市 9555 5002 1470 2457 林可华 <br />
				请汇款后及时电话通知庞志林或杨福祥,或传真汇款底单到我司,以便及时入帐。 ( 传真号码：021-33582330 )
				</p>
			</td>
		</tr>
		<tr>
			<td>
				<p class="beijing"><strong>三、邮局汇款</strong></p><br />
				<p class="td">交费方式 地 址 邮 编 收款人 <br />
				邮政汇款 广州市越秀区北大青鸟T03Shoes 201100<br />
				请将邮局汇款回执传真到我司。 ( 传真号码：021-33582330 )
				</p> 
			</td>
		</tr>
		<tr>
			<td>
				<p class="beijing"><strong>四、上门收款</strong></p><br />
				<p class="td">城 市 区域限定 预约电话 <br />
				广州市 广州外环以内区域等可派专人上门收款 客服热线：021-03030303  浙江嘉兴市 桐乡、海宁、嘉兴等周遍<br />				 				地区可派专人上门收款 客服热线：021-03030303<br />
				注意：收款时间敬请提前一至半天预约 广州总部客服热线 ,以便妥善安排。 
				</p>
			</td>
		</tr>
  </table>
</div>
<div><jsp:include page="../Bottom.jsp"></jsp:include></div>
  </body>
</html>
