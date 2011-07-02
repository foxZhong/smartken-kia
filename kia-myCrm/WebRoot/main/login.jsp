<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<style type="text/css">
<!--
body{
	margin:0px;
	padding:0px;
	font-family:Arial, Helvetica, sans-serif;
	font-size:12px;
	background:#cad7df url(../images/bg.jpg) repeat-x;
	/* ����ɫ��ˮƽ�ظ��ı���ͼƬ */
}
#container{
	width:1024px;
}
div br{
	display:none;
}
#globallink{
	width:1024px; height:62px;
	margin:0px 0px 1px 0px;
	background:url(../images/logo.jpg) no-repeat;	/* ���bannerͼƬ */
}
#globallink ul{
	list-style:none;
	position:absolute;
	left:700px; top:35px;				/* �����˵����ֵ�λ�� */
	padding:0px; margin:0px;
}
#globallink li{
	float:left; 
	text-align:center;
	padding:0px 10px 0px 18px;
	margin:0px;
}
#globallink a:link, #globallink a:visited{
	color:#4a6f87;
	text-decoration:none;
}
#globallink a:hover{
	color:#FFFFFF;
	text-decoration:underline;
}

#left{
	width:138px;
	float:left;
}
#navigation{
	width:138px;
	padding:0px;
	margin:0px 0px 10px 0px;
}
#navigation ul{
	margin:0px;
	padding:0px;
	border-top:5px solid  #cad7df;		/* ���˴��� */
}
#navigation li{
	border-bottom:1px solid #cad7df;	/* ����»��� */
	
}
#navigation li a{
	display:block;						/* ������ʾ */
	padding:3px 5px 3px 2em;
	text-decoration:none;
	background:url(../images/icon1.gif) no-repeat 13px 9px;
}
#navigation li a:link, #navigation li a:visited{
	background-color:#7591a3;
	color:#FFFFFF;
}
#navigation li a:hover{					/* ��꾭��ʱ */
	color:#003e66;						/* �ı�������ɫ */
	background:#aacbe0 url(../images/icon2.gif) no-repeat 13px 9px;
}
#search form, #search p{
	margin:0px;
	padding:0px;
	text-align:center;
}
#search input.text{
	border:1px solid #7591a3;
	background:transparent;
	width:80px; font-size:12px;
	font-family:Arial;
}
#search input.btn{
	border:1px solid #7591a3;
	background:transparent;
	font-size:12px; height:19px;
	font-family:Arial;
	padding:0px;
}

#main{
	width:700px; float:left;
	margin:0px; padding:0px;
	background-color:#FFFFFF;
}
#hottest h3{
	font-size:16px;
	padding:28px 5px 4px 40px;
	margin:0px;
	background:url(../images/icon3.gif) no-repeat 29px 34px;
}
#hottest h3 a:link, #hottest h3 a:visited{
	color:#000000;
	text-decoration:none;
}
#hottest h3 a:hover{
	color:#7591a3;
	text-decoration:underline;
}

#list{
	float:left;
	margin:20px 0px 4px 0px;
	width:620px;
	padding:0px 0px 0px 28px;
}
#list h4{
	font-size:12px;
	background:#e0e7ec url(images/icon4.gif) no-repeat 7px 8px;
	padding:3px 0px 2px 17px;
	margin:0px;
}
#list p.date{
	margin:0px; padding:5px 0px 5px 2px;
	font-weight:bold;
	color:#014e68;
}
#list ul{
	margin:0px 0px 6px 40px;
	padding:0px;
	list-style-type:disc;
}
#list ul li a:link, #list ul li a:visited, #list p.more a:link, #list p.more a:visited{
	color:#333333;
	text-decoration:none;
}
#list ul li a:hover, #list p.more a:hover{
	color:#00a9e7;
	text-decoration:underline;
}
#list p.more{
	margin:0px; padding:5px 0px 20px 10px;
	background:url(../images/icon5.gif) no-repeat 0px 10px;
}

#letter{
	float:left;
	width:150px;
	margin:20px 0px 5px 30px;
	padding:0px;
	border-left:1px solid #7591a3;
}
#letter h4{
	margin:0px;
	font-size:12px;
	background:url(../images/right_right.gif) no-repeat;
	color:#FFFFFF;
	padding:2px 0px 2px 15px;
}
#letter p.date2{
	background:#e0e7ec url(../images/icon6.gif) no-repeat 5px 7px;
	margin:7px 15px 3px 7px;
	padding:1px 0px 1px 15px;
	font-weight:bold;
}
#letter p.content2{
	margin:2px 15px 0px 7px;
	padding:1px 0px 1px 0px;
}
#letter p.more2{
	margin:1px 15px 3px 7px;
	padding:0px 0px 1px 8px;
	background:url(../images/icon5.gif) no-repeat 2px 5px;
}
#letter p.more2 a:link, #letter p.more2 a:visited{
	color:#555555;
	text-decoration:none;
}
#letter p.more2 a:hover{
	color:#000000;
	text-decoration:underline;
}

#letter a:link, #letter a:visited{
	color:#006699;
	text-decoration:none;
}
#letter a:hover{
	color:#FFFFFF;
	text-decoration:underline;
}

#footer{
	width:1024px; height:62px;
	margin:0px 0px 1px 0px;
	background-color: "#F4F4F4";
	/* ���bannerͼƬ */
}

#footer a:link, #footer a:visited{
	color:#4a6f87;
	text-decoration:none;
}
#footer a:hover{
	color:#FFFFFF;
	text-decoration:underline;
}


.listTitleTR {
	font-size: medium;
	font-weight: bold;
	color: #FFFFFF;
	background-color: #7691A4;
	text-align: center;
}

.listTrMouseOver {
	background-color: #FF9933;
}
.listTrMouseOut {
	background-color: #FFFFCC;
}
.listTdMouseOver {
	background-color: #33CC00;
}

.listTdMouseOver {
	background-color: #FF9933;
}


.formTitleTd {
	font-size: small;
	color: #FFFFFF;
	background-color: #7691A4;
}
.formTdMouseOver {
	background-color: #FFFF99;
}
.formTdMouseOut {
	background-color: #FFFFCC;
}
-->
</style>
<title>Insert title here</title>
</head>
<body>
   <form action="login" method="post">
   		<p>&nbsp;</p>
   		<p>&nbsp;</p>
   		<p>&nbsp;</p>
   		<p>&nbsp;</p>
   		<p><center><h1>
   		  T02�ͻ���ϵ����ϵͳ�ڲ�� beta1.0
   		</h1></center></p>
   		<table align="center" bgcolor="#99FFCC">
<tr>
            	<td width="39" class="formTitleTd"><font size="-1">�û���</font></td>
	  			<td width="151" class="formTdMouseOut" 
		 				onMouseOver="this.className='formTdMouseOver'" 
		 				onMouseOut="this.className='formTdMouseOut'">
		 			<input name="txtName" type="text" value="" size="15">
		 		</td>
          	</tr>
            <tr>
            	<td colspan="2" bgcolor="#CAD7DF">&nbsp;</td>
          </tr>
            <tr>
            	<td class="formTitleTd" align="center"><font size="-1">����</font></td>
              	<td class="formTdMouseOut" 
		 				onMouseOver="this.className='formTdMouseOver'" 
		 				onMouseOut="this.className='formTdMouseOut'">
		 			<input name="pwPass" type="password" value="" size="15">
		 		</td>
          	</tr>
            <tr>
            	<td colspan="2" bgcolor="#CAD7DF">&nbsp;</td>
          </tr>
          <tr><td colspan="2">
          <a target="_top" href="tencent://message/?uin=249750689&Site=mycms&Menu=yes">��ϵ����Ա</a>
          </td></tr>
            <tr bgcolor="#FFCCCC">
            	<td colspan="2" align="center">
      				<input type="submit" value="��¼">&nbsp;            	 
                	<input type="reset" value="����">
                </td>
          	</tr>
     	</table>
     <p>&nbsp;</p>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
</form>
</body>
</html>