<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>关于我们</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/styles.css">


  </head>
  
<body>
<div id="top"><jsp:include page="../Top.jsp"></jsp:include></div>
<div class=font>
<p align="center"><strong>概括与简介</strong></p>
<br />
<p style="text-indent:32px">    T03Shoes购物网站是一家专业的鞋子销售小网站，旨在为鞋子企业、鞋子贸易公司以及鞋子设计师提供最前端的鞋类的款式流

行资讯，内容囊括全球最新的流行趋势分析、市场报告、最新款式、卖场热卖款式实拍、名牌跟踪、品牌发布会等等十几个方面，

新颖时尚，即时实用，是目前全球信息量最大，内容最前端，实用性和市场价值最大的鞋类款式流行资讯的提供商、分析商和服务商。</p>
<p><strong>成员介绍</strong> <br />
组一：<br />
		组长：史业嘉<br />
		组员：林克华、林海晖、杨福祥<br />
	组二：<br />
		组长：刘志荣<br />
		组员：唐毅、吕思维、庞志林</p>
<p><strong>工作分配</strong> <br />

	前台布局：<br />
		刘志荣、唐毅、庞志林<br />
	后台设计：<br />
		史业嘉、吕思维、林克华、杨福祥<br />
	全程监测：<br />
		林海晖</p>
<p><strong>户交费确认 </strong><br />
●　请您汇款后将汇款底单传真到020-09t03 或将底单扫描后发至 T03Shoes@shopping.com。<br />

●　传真件或扫描件请务必注明会员名称和用途，若注册过网站会员，请一并写上会员用户名。<br />

●　我司收到有效传真件或扫描件即可为您入帐，开通相应的会员服务。<br />

●　为了加快入帐步伐,建议您及时传真；对于不方便传真或扫描的客户，请再汇款后电话 ( 020-03t09) 通知我们进行查帐即可。</p>
</div>
<div><jsp:include page="../Bottom.jsp"></jsp:include></div>
</body>
</html>
