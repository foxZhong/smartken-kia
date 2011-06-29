<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>帮助中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/styles.css">


  </head>
  
  <body>
<div id="top"><jsp:include page="../Top.jsp"></jsp:include></div>
<DIV id=ttl0 style="height:300px;"><SPAN></SPAN></DIV>

 <SCRIPT language="JavaScript">
<!--
var layers = document.layers, style = document.all, both = layers || style, idme=908601;
if (layers) { layerRef = 'document.layers'; styleRef = ''; } if (style) { layerRef = 'document.all'; styleRef = '.style'; }
function writeOnText(obj, str) {
if (layers) with (document[obj]) { document.open(); document.write(str); document.close(); }
if (style) eval(obj+'.innerHTML= str');
}
//以下是输出的内容，自己修改即可。
var dispStr = ["<font color=#666666 size=3>注册时电子邮件不被接受的问题正确格式是：用户名@域名，例如 hb3288@hotmail.com如果系统提示出错的话，请注意检查您的输入法是否是纯英文状态，请注意半角全角的切换。(注：电子邮件是网络上您的客与您联系的一个非常重要的方式，请确保您所输入的电子邮件地址正确无误。如果还没有电子邮箱的话，建议您到搜狐或新浪、网易等门户网站申请个免费电子邮箱。</font><br><font color=#9#0066FF size=3>注册时用户名不被接受原因可能是：1.你输入的名字太短或太长，请参照注册页面中每一项后面的注释部分；2.此用户名已被注册；3.输入的用户中是否包含空格等不合法字符？如*#具体请参考出错信息。注册时密码不被接受请检查密码的长度，请参照注册页面中每一项后面的注释部分。注意：密码中不能有空格，可以有#$等。请参考出错信息。登陆帐号异常帐号登陆后出现如上现象，原因是因为该帐号存在违规操作(如：非法倒卖帐号多个公司非法合用同一帐号，非法使用网站内资料等等)，网站电脑系统自动将该帐号禁用，可电话联系网站客服: 020-03t09协调处理。</font><br><font color=#666666 size=3>电脑系统重装后，网站打不开具体现象表现为：电脑系统重新安装后，访问T03Shoes网站，结果网站无法完整显示出来，只显示标志LOGO，其他均为一片白色，无任何内容。原因：因为电脑系统重新安装后，没有安装Flash player的播放控件，导致网页中的flash无法正常显示，因此阻碍了整个网站的显示。解决方法：1.打开网站后，会在网页上方出现一提示条，提安装active控件(flash player)，点击提示条进行安装即可。 2.点击此处(http://www.pop-fashion.com/global/xsl/install_flash_player.exe)，直接下载flash player控件，然后安装即可。</font><br>"];
var overMe=0;

function helpor_net(str, idx, idObj, spObj, clr1, clr2, delay, plysnd) {
var tmp0 = tmp1 = '', skip = 0;
if (both && idx <= str.length) {
if (str.charAt(idx) == '<') { while (str.charAt(idx) != '>') idx++; idx++; }
if (str.charAt(idx) == '&' && str.charAt(idx+1) != ' ') { while (str.charAt(idx) != ';') idx++; idx++; }
tmp0 = str.slice(0,idx);
tmp1 = str.charAt(idx++);
if (overMe==0 && plysnd==1) {
if (navigator.plugins[0]) {
if (navigator.plugins["LiveAudio"][0].type=="audio/basic" && navigator.javaEnabled()) {
document.embeds[0].stop();
setTimeout("document.embeds[0].play(false)",100); }
} else if (document.all) {
ding.Stop();
setTimeout("ding.Run()",100);
}
overMe=1;
} else overMe=0;
writeOnText(idObj, "<span class="+spObj+"><font color='"+clr1+"'>"+tmp0+"</font><font color='"+clr2+"'>"+tmp1+"</font></span>");
setTimeout("helpor_net('"+str+"', "+idx+", '"+idObj+"', '"+spObj+"', '"+clr1+"', '"+clr2+"', "+delay+" ,"+plysnd+")",delay);
}
}
function www_helpor_net() {
helpor_net(dispStr[0], 0, 'ttl0', 'ttl1', '#339933', '#99FF33', 50, 0);
}
www_helpor_net();
// -->
</SCRIPT>
<div><jsp:include page="../Bottom.jsp"></jsp:include></div>
  </body>
</html>
