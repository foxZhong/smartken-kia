<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>法律声明</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/styles.css">


  </head>
  
  <body>
<div id="top"><jsp:include page="../Top.jsp"></jsp:include></div>
<div align="center">
<table width="642" border="0">
  <tr>
    <td><div align="left"><img src="image/copyright2.jpg" width="596" height="76" /></div></td>
  </tr>
  <tr>
    <td><span style="text-indent:32px">本网站包含之所有内容：文本、图形、LOGO、创意、及软件等之所有权归属国际鞋子设计在线网站及本网站的内容/信息提供 者，受中国及国际版权法的保护。对本网站上所有内容之复制（意指收集、组合和重新组合），本网站享有排他权并受中国及国际版权法的保护。对本网站产品内容的任何其他使用，包括再造、修改、发布、转发、再版、演示或播出被严格禁止。</span></td>
  </tr>
  <tr>
    <td><strong>商标</strong> <br />
国际鞋子设计在线网站所有图形、图片、图表、声音、创意、LOGO和服务名称、标识均受相关法律保护，该等商标、专有名称、标识等不能在任何非属国际鞋子设计在线网站的产品或服务上进行容易在客户中引起混淆或引起歧义的使用，或以任何曲解或诋毁国际鞋子设计在线网站之形式使用。</td>
  </tr>
  <tr>
    <td><p><strong>网站使用</strong> <br />
      会员在获得本网站权限后，不得把我方的设计产品传给第三方，禁止把自己的帐号和第三方共享或商业运作。若发现，我方有权取消订单并拒退订金。</p>
      <p><strong>链接 </strong><br />
        本网站上的链接服务可以直接进入其他站点，这些链接的站点不受本网站的控制，本网站对任何与本站链接网站的内容不负责任。</p>
      <p><strong>免责条款</strong> <br />
        本网站在此声明，对您使用网站、与本网站相关的任何内容、服务或其它链接至本网站的站点、内容均不作直接、间接、法定、约定的保证。无论在任何原因下（包括但不限于疏忽原因），对您或任何人通过使用本网站上的信息或由本网站链接的信息，或其他与本网站链接的网站信息所导致的损失或损害（包括直接、间接、特别或后果性的损失或损害，例如收入或利润之损失，电脑系统之损坏或数据丢失等后果），责任均由使用者自行承担（包括但不限于疏忽责任）。</p>
      <p><strong>操作规则</strong> <br />
        当您使用本网站服务时，您不可以：</p>
      <p>1）粘贴或传播任何非法的，具威胁性的，诽谤性的，贬损的，报复的、亵渎的或任何其他法律禁止的信息，包括传播任何煽动性鼓励犯罪的，或违反公民义务或任何其他违反地方法规、国家法律、法规或国际法律、惯例或公约的内容。</p>
      <p>2）粘贴或传播任何散布任何他人的私人事件，粘贴或传播带有病毒，或任何带有贬损或损害性特征的内容；</p>
      <p>3）粘贴或传播任何可能侵害其他人财`产权利的数据、图形或程序，包括以非法形式使用未经注册的版权文本、图形或程序，商业秘密及其他保密信息、 商标、服务标识等；</p>
      <p>4）以任何形式干扰本网站的其他用户。</p>
      <p>&nbsp;</p>
      <p>国际鞋子设计在线网站由上海逸尚信息咨询有限公司运营和控制，适用中华人民共和国法律。我们保留随时更改我们的网站和上述免责及条款的权利。</p>
      <p><strong>隐私声明</strong><br />
        国际鞋子设计在线网站非常重视用户的隐私权，请您务必仔细阅读。在您同意国际鞋子设计在线网站服务协议（“会员协议”）之时，您已经同意本网站按照本隐私申明来使用和披露您的个人信息。本隐私申明的所有条款均属于该协议的一部分。 </p>
      <p><strong>未成年人的特别注意事项 </strong><br />
        如果您未满18周岁，您无权使用公司服务，因此我们希望您不要向我们提供任何个人信息。如果您未满18周岁，您只能在父母或监护人的陪同下才可以使用公司服务。</p>
      <p><strong>用户名和密码 </strong><br />
        如果您泄漏了密码，您可能丢失了您的个人识别信息，并且有可能导致对您不利的司法行为。因此不管任何原因使您的密码安全受到危及，您应该立即与我们取得联系。</p>
      <p><strong>注册信息 </strong><br />
        当您在注册为会员时，我们要求您填写一张注册表，我们将会用这些统计数据来给我们的会员分类，以便有针对性地向我们的会员提供新的服务和机会。我们会通过您的邮件地址来通知您这些新的服务和机会。</p>
      <p><strong>Cookie的使用 </strong><br />
        我们使用cookie来使我们的网站对用户更友好。它可以帮您省去为使用我们的服务而重复输入注册信息和跟踪您的浏览器的状态。</p>
      <p><strong>外部链接 </strong><br />
        本站含有到其他网站的链接。本网站对那些网站的隐私保护措施不负任何责任。我们承诺为您的身份保密。</p>
      <p>本网的隐私声明正在不断完善中，随着我网服务范围的扩大，我们会随时更新我们的隐私申明。欢迎您随时查看！</p>
      <p><strong>修改资料</strong> <br />
    您可以在页面上点进“会员帐户管理”修改您的资料，只限于您成功登录后。</p></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
</div>
<div><jsp:include page="../Bottom.jsp"></jsp:include></div>
  </body>
</html>
