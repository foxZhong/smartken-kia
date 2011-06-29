<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>联系我们</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/styles.css">


  </head>
  
  <body>
<div id="top"><jsp:include page="../Top.jsp"></jsp:include></div>
<div>
  <p>&nbsp;</p>
  <p>如何联系我们</p>
  <pre>有关商品、订单查询等问题请各位用户尽量将邮件发送到
     客户服务信箱和客户满意监督信箱，以便获得最快的回复！ 
     
     <strong>T03Shoes好乐买订购热线 </strong>
     订购、咨询等，请拨打<strong>T03Shoes</strong> 好乐买订购热线：400-8810-400 
     
     <strong>T03Shoes 好乐买售后热线 </strong>
     退换货、投诉等，请拨打Okaybuy   好乐买售后热线：010-58690632
     
     <strong>客户满意监督 </strong>
     客户满意监督和其它服务   service@<strong>T03Shoes</strong>.com.cn
     功能：此信箱是<strong>T03Shoes</strong>好乐买服务的主信箱，接受用户的各种问题和意见。
     感谢您不吝赐教。
     
     <strong>总裁办公室 </strong>
     president@<strong>T03Shoes</strong>.com.cn
     功能：总裁办公室的信箱，接受各种对公司的意见和建议，负责接待客户投诉，听取客户反馈，改进服务质量，接受各种关于Okaybuy好乐买服务问题的反映和意见。欢迎给此信箱发信，感谢您不吝赐教。 
     
     <strong>品牌推广中心 </strong>
     marketing@<strong>T03Shoes</strong>.com.cn
     功能：接受媒体以及广告公司合作的信息及建议，负责公司广告及市场的投放。 
     
     <strong>中国采购中心</strong>
     product@<strong>T03Shoes</strong>.com.cn
     功能：负责OKAYBUY所有产品线在中国的采购工作以及品质控制工作 
     
     <strong>T03Shoes</strong> 好乐买中国总部
     <strong>T03Shoes</strong> 好乐买中国总部电话：010-5869-0629 
     <strong>T03Shoes</strong> 好乐买中国总部地址：北京市朝阳区东三环中路39号建外soho?? 邮编：100022 
</div>
<div><jsp:include page="../Bottom.jsp"></jsp:include></div>
  </body>
</html>
