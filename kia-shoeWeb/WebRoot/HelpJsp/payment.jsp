<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>���ʽ</title>
    
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
			<td class="title"><strong>���ʽ���£�</strong></td>
		</tr>
		<tr>
			<td>
				<p class="beijing"><strong>һ������֧��</strong></p>
				<br />
				<p class="td">֧���� 
				��������֧��ƽ̨<img src="image/3.jpg" width="123" height="40" />�����ͼ�����<br />
				�������ÿ���ͨ������֧�����ܵ����п��ſ��Խ������ϸ��<br />
				֧���� �ʺţ�T03Shoes@shopping.com��ȥT03Shoes�������������߸���,������ʺţ�<br /> 
				֧��������ɹ����뼰ʱ֪ͨ���ǡ�
			  </p>
			</td>
		</tr>
		<tr>
		  <td>
			  <p class="beijing"><strong>�������л�� & ת��</strong></p>
				<br />
				<p class="td">�� �� �������� �� �� �� ��<br />
				�й��������� �й��������й����� 9558 8010 0115 0992805 ʷҵ�� <br />
				�й�ũҵ���� �й�ũҵ���й����� 95599 8003 04013 60810 ��־�� <br />
				�й��������� ������ 4367 4212 1735 4480 592 ��˼ά <br />
				�й���ͨ���� ������ 622260 0110004639279 �ֺ���<br />
				�й����� �й����� ������4563510800012683354 ����<br /> 
				�������� ������ 9555 5002 1470 2457 �ֿɻ� <br />
				�����ʱ�绰֪ͨ��־�ֻ����,������׵�����˾,�Ա㼰ʱ���ʡ� ( ������룺021-33582330 )
				</p>
			</td>
		</tr>
		<tr>
			<td>
				<p class="beijing"><strong>�����ʾֻ��</strong></p><br />
				<p class="td">���ѷ�ʽ �� ַ �� �� �տ��� <br />
				������� ������Խ������������T03Shoes 201100<br />
				�뽫�ʾֻ���ִ���浽��˾�� ( ������룺021-33582330 )
				</p> 
			</td>
		</tr>
		<tr>
			<td>
				<p class="beijing"><strong>�ġ������տ�</strong></p><br />
				<p class="td">�� �� �����޶� ԤԼ�绰 <br />
				������ �����⻷��������ȿ���ר�������տ� �ͷ����ߣ�021-03030303  �㽭������ ͩ�硢���������˵��ܱ�<br />				 				��������ר�������տ� �ͷ����ߣ�021-03030303<br />
				ע�⣺�տ�ʱ�侴����ǰһ������ԤԼ �����ܲ��ͷ����� ,�Ա����ư��š� 
				</p>
			</td>
		</tr>
  </table>
</div>
<div><jsp:include page="../Bottom.jsp"></jsp:include></div>
  </body>
</html>
