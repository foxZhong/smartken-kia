<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��������</title>
    
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
//��������������ݣ��Լ��޸ļ��ɡ�
var dispStr = ["<font color=#666666 size=3>ע��ʱ�����ʼ��������ܵ�������ȷ��ʽ�ǣ��û���@���������� hb3288@hotmail.com���ϵͳ��ʾ����Ļ�����ע�����������뷨�Ƿ��Ǵ�Ӣ��״̬����ע����ȫ�ǵ��л���(ע�������ʼ������������Ŀ�������ϵ��һ���ǳ���Ҫ�ķ�ʽ����ȷ����������ĵ����ʼ���ַ��ȷ���������û�е�������Ļ������������Ѻ������ˡ����׵��Ż���վ�������ѵ������䡣</font><br><font color=#9#0066FF size=3>ע��ʱ�û�����������ԭ������ǣ�1.�����������̫�̻�̫���������ע��ҳ����ÿһ������ע�Ͳ��֣�2.���û����ѱ�ע�᣻3.������û����Ƿ�����ո�Ȳ��Ϸ��ַ�����*#������ο�������Ϣ��ע��ʱ���벻��������������ĳ��ȣ������ע��ҳ����ÿһ������ע�Ͳ��֡�ע�⣺�����в����пո񣬿�����#$�ȡ���ο�������Ϣ����½�ʺ��쳣�ʺŵ�½�������������ԭ������Ϊ���ʺŴ���Υ�����(�磺�Ƿ������ʺŶ����˾�Ƿ�����ͬһ�ʺţ��Ƿ�ʹ����վ�����ϵȵ�)����վ����ϵͳ�Զ������ʺŽ��ã��ɵ绰��ϵ��վ�ͷ�: 020-03t09Э������</font><br><font color=#666666 size=3>����ϵͳ��װ����վ�򲻿������������Ϊ������ϵͳ���°�װ�󣬷���T03Shoes��վ�������վ�޷�������ʾ������ֻ��ʾ��־LOGO��������ΪһƬ��ɫ�����κ����ݡ�ԭ����Ϊ����ϵͳ���°�װ��û�а�װFlash player�Ĳ��ſؼ���������ҳ�е�flash�޷�������ʾ������谭��������վ����ʾ�����������1.����վ�󣬻�����ҳ�Ϸ�����һ��ʾ�����ᰲװactive�ؼ�(flash player)�������ʾ�����а�װ���ɡ� 2.����˴�(http://www.pop-fashion.com/global/xsl/install_flash_player.exe)��ֱ������flash player�ؼ���Ȼ��װ���ɡ�</font><br>"];
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
