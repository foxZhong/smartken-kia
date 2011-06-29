<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/userReg.css" />
<title> 用户注册页 </title>
<style type="text/css">
.orderlyDiv{
	color:#00CC00;
}
.orderlyTable{
	border-color:#000000;
}
</style>
<script language="javascript">
	function onFocus(i,div){		//获取光标事件
		var num = new Array('','userName','pwdOne','pwdTwo','txtSurname','txtPhone','txtAddress');
		var text = new Array("","由a~z、0~9、减号或下划线组成，长度为4~16 ","4~18位，限英文、数字以及下划线，区分大小写",
			"再输入一次密码","输入您的姓名，以便送货时确认。","输入您的联系电话，以便送货时联系","输入您的收货地址!");
	
		document.getElementById(div).innerHTML = text[i];
		document.getElementById(num[i]).style.borderColor = "#2165E7";
		document.getElementById(num[i]).style.backgroundColor = "#9AFFFF";
		document.getElementById(div).style.color = "#2165E7";
	}
	function userNameBlur(){		//帐号的验证事件
		var userName = document.getElementById("userName");
		var userNameDiv = document.getElementById("userNameDiv");
		if(userName.value.length == 0){
			userNameDiv.innerHTML = "用户名不能为空！";
			userName.style.borderColor = "#F7615A";
			userNameDiv.style.color = "#F7615A";
			userName.style.backgroundColor = "#FFFFFF";
			return false;
		}else if(userName.value.length < 4 || userName.value.length > 16){
			userNameDiv.innerHTML = "用户名长度不正确！";
			userName.style.borderColor = "#F7615A";
			userNameDiv.style.color = "#F7615A";
			userName.style.backgroundColor = "#FFFFFF";
			return false;
		}else{
			userName.style.borderColor = "#C6C6C6";
			userNameDiv.style.color = "#00CC00";
			userName.style.backgroundColor = "#FFFFFF";
			userNameDiv.innerHTML = "用户名已填写。";
			return true;
		}
	}
	function pwdOneBlur(){		//密码的验证事件
		var pwdOne = document.getElementById("pwdOne");
		var pwdOneDiv = document.getElementById("pwdOneDiv");
		
		if(pwdOne.value == null){
			pwdOne.style.borderColor = "#F7615A";
			pwdOneDiv.style.color = "#F7615A";
			pwdOne.style.backgroundColor = "#FFFFFF";
			pwdOneDiv.innerHTML = "密码不能为空！";
			return false;
		}else if(pwdOne.value.length < 4 || pwdOne.value.length >18){
			pwdOne.style.borderColor = "#F7615A";
			pwdOneDiv.style.color = "#F7615A";
			pwdOne.style.backgroundColor = "#FFFFFF";
			pwdOneDiv.innerHTML = "密码长度不正确！";
			return false;
		}else{
			var checkDiv1 = document.getElementById("CheckOne");
			var checkDiv2 = document.getElementById("CheckTwo");
			var checkDiv3 = document.getElementById("CheckThree");
			if(pwdOne.value.length >= 4 && pwdOne.value.length <= 7){
				checkDiv1.style.color = "#C6C6C6";
				checkDiv2.style.color = "#FFFFFF";
				checkDiv3.style.color = "#FFFFFF";
				checkDiv1.style.backgroundColor = "#FF5655";
				checkDiv2.style.display = "none";
				checkDiv3.style.display = "none";
			}else{
				if(pwdOne.value.length >= 11 && isNaN(pwdOne.value)){
					checkDiv1.style.color = "#C6C6C6";
					checkDiv2.style.color = "#C6C6C6";
					checkDiv3.style.color = "#C6C6C6";
					checkDiv2.style.display = "inline";
					checkDiv3.style.display = "inline";
					checkDiv1.style.backgroundColor = "#9EFF9D";
					checkDiv2.style.backgroundColor = "#9EFF9D";
					checkDiv3.style.backgroundColor = "#9EFF9D";
				}else{
					checkDiv1.style.color = "#C6C6C6";
					checkDiv2.style.color = "#C6C6C6";
					checkDiv3.style.color = "#FFFFFF";
					checkDiv2.style.display = "inline";
					checkDiv3.style.display = "none";
					checkDiv1.style.backgroundColor = "#F7615A";
					checkDiv2.style.backgroundColor = "#F7615A";
				}			
			}
			pwdOne.style.borderColor = "#C6C6C6";
			pwdOneDiv.style.color = "#00CC00";
			pwdOne.style.backgroundColor = "#FFFFFF";
			pwdOneDiv.innerHTML = "密码已填写。";
			return true;
		}
	}
	function pwdTwoBlur(){		//确认密码的验证事件
		var pwdOne = document.getElementById("pwdOne");
		var pwdTwo = document.getElementById("pwdTwo");
		var pwdTwoDiv = document.getElementById("pwdTwoDiv");

		if(pwdTwo.value.length == 0){
			pwdTwo.style.borderColor = "#F7615A";
			pwdTwoDiv.style.color = "#F7615A";
			pwdTwo.style.backgroundColor = "#FFFFFF";
			pwdTwoDiv.innerHTML = "确认密码不能为空！";
			return false;
		}else if(pwdTwo.value.length < 4 || pwdTwo.value.length >18){
			pwdTwo.style.borderColor = "#F7615A";
			pwdTwoDiv.style.color = "#F7615A";
			pwdTwo.style.backgroundColor = "#FFFFFF";
			pwdTwoDiv.innerHTML = "确认密码长度不正确！";
			return false;
		}else if(pwdOne.value != pwdTwo.value){
			pwdTwo.style.borderColor = "#F7615A";
			pwdTwoDiv.style.color = "#F7615A";
			pwdTwo.style.backgroundColor = "#FFFFFF";
			pwdTwoDiv.innerHTML = "两次输入密码不一致！";
			return false;
		}else{
			pwdTwo.style.borderColor = "#C6C6C6";
			pwdTwoDiv.style.color = "#00CC00";
			pwdTwo.style.backgroundColor = "#FFFFFF";
			pwdTwoDiv.innerHTML = "两次输入密码一致。";
			return true;
		}
	}
	function allForm(){		//表单提交的验证事件
		if(userNameBlur() && pwdOneBlur() && pwdTwoBlur()){
			return true;
		}
		else{
			alert("你填入的信息有误.请根据页面的红框提示修改!");
			return false;
		}
	}
	function txtSurnameBlur(){		//姓名的验证事件
		var SurName = document.getElementById("txtSurname");
		var SurNameDiv = document.getElementById("SurNameDiv");
		
		if(SurName.value.length == 0){
			SurNameDiv.innerHTML = "姓名不能为空！";
			SurName.style.borderColor = "#F7615A";
			SurNameDiv.style.color = "#F7615A";
			SurName.style.backgroundColor = "#FFFFFF";
		}else if(SurName.value.length < 2 || SurName.value.length > 20){
			SurNameDiv.innerHTML = "姓名长度不正确！";
			SurName.style.borderColor = "#F7615A";
			SurNameDiv.style.color = "#F7615A";
			SurName.style.backgroundColor = "#FFFFFF";
		}else{
			SurName.style.borderColor = "#C6C6C6";
			SurNameDiv.style.color = "#00CC00";
			SurName.style.backgroundColor = "#FFFFFF";
			SurNameDiv.innerHTML = "姓名填已填写。";
		}
	}
	function txtPhoneBlur(){		//联系电话的验证事件
		var txtPhone = document.getElementById("txtPhone");
		var txtPhoneDiv = document.getElementById("txtPhoneDiv");
			
		if(txtPhone.value.length == 0){
			txtPhoneDiv.innerHTML = "联系电话不能为空！";
			txtPhone.style.borderColor = "#F7615A";
			txtPhoneDiv.style.color = "#F7615A";
			txtPhone.style.backgroundColor = "#FFFFFF";
		}else if(txtPhone.value.length < 11 || txtPhone.value.length > 12){
			txtPhoneDiv.innerHTML = "联系电话填写不正确！";
			txtPhone.style.borderColor = "#F7615A";
			txtPhoneDiv.style.color = "#F7615A";
			txtPhone.style.backgroundColor = "#FFFFFF";
		}else{
			if(!isNaN(txtPhone.value)){
				txtPhone.style.borderColor = "#C6C6C6";
				txtPhoneDiv.style.color = "#00CC00";
				txtPhone.style.backgroundColor = "#FFFFFF";
				txtPhoneDiv.innerHTML = "联系电话已填写。";
			}else{
				txtPhoneDiv.innerHTML = "联系电话只能是数字！";
				txtPhone.style.borderColor = "#F7615A";
				txtPhoneDiv.style.color = "#F7615A";
				txtPhone.style.backgroundColor = "#FFFFFF";
			}
		}
	}
	function txtAddressBlur(){		//联系地址的验证事件
		var txtAddress = document.getElementById("txtAddress");
		var txtAddressDiv = document.getElementById("txtAddressDiv");
		
		if(txtAddress.value.length == 0){
			txtAddressDiv.innerHTML = "地址不能为空！";
			txtAddress.style.borderColor = "#F7615A";
			txtAddressDiv.style.color = "#F7615A";
			txtAddress.style.backgroundColor = "#FFFFFF";
		}else{
			txtAddress.style.borderColor = "#C6C6C6";
			txtAddressDiv.style.color = "#00CC00";
			txtAddress.style.backgroundColor = "#FFFFFF";
			txtAddressDiv.innerHTML = "地址已填写。";
		}
	}
	function reloadImage(url) 
	{ 
		document.form1.img1.src = url; 
	}
</script>
</head>


<body style="margin-left: 120px">
<form action="manage/doReg.jsp" method="post" name="form1" id="form1" onSubmit="return allForm()">
<br /><br />
<TABLE class="table1" cellSpacing=0 cellPadding=0>
  <TR>
    <TD style="WIDTH: 496px" vAlign=top>
      <DIV>
      <TABLE style="MARGIN: 0px auto" cellSpacing=0 cellPadding=0 width=460 border=0>
        <TR>
          <TD class="font">如果您已经是T03的注册用户，<A href="manage/doLanding.jsp">点这里登录</A> </TD></TR>
        <TR>
          <TD style="HEIGHT: 4px"></TD></TR></TABLE></DIV>
      <HR class="hrOne" />

      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TR>
          <TD style="HEIGHT: 15px"></TD></TR>
        <TR>
          <TD class="font">&nbsp;<B>登录及帐户信息</B><SPAN class="spanOne">&nbsp;&nbsp;&nbsp;&nbsp; --  
            登录及取回密码所用，请认真填写！</SPAN> </TD></TR>
        <TR>
          <TD style="HEIGHT: 10px"></TD></TR></TABLE>
      <TABLE cellSpacing=1 cellPadding=0 width="100%" border=0>
        <TR>
          <TD class="tdOne"align=right><SPAN class="spanTwo">用户名</SPAN> </TD>
          <TD class="tdTwo"><SPAN id=ctl00_cph_center_up2><span class="red">*</span>&nbsp;<INPUT type="text" class="inputOne"
            name="userName" id="userName" onFocus="onFocus(1,'userNameDiv')" onBlur="userNameBlur()">
            &nbsp;&nbsp;<br />&nbsp;<div class="tableDiv" id="userNameDiv"></div></SPAN></TD>
        </TR>
        <TR>
          <TD class="tdThree" align=right><SPAN class="spanThree">密&nbsp;&nbsp;码</SPAN> </TD>
          <TD class="tdFour"><span class="red">*</span>&nbsp;<INPUT type="password" class="inputTwo" name="pwdOne"
          	id="pwdOne" onFocus="onFocus(2,'pwdOneDiv')" onBlur="pwdOneBlur()">&nbsp;&nbsp;
            <div style="display:inline;" id="pwdCheckDiv">
            	<div class="checkPwdDiv" id="CheckOne">&nbsp;&nbsp;&nbsp;弱&nbsp;&nbsp;&nbsp;</div>
            	<div class="checkPwdDiv" id="CheckTwo">&nbsp;&nbsp;&nbsp;中&nbsp;&nbsp;&nbsp;</div>
             	<div class="checkPwdDiv" id="CheckThree">&nbsp;&nbsp;&nbsp;强&nbsp;&nbsp;&nbsp;</div></div>
            <br />&nbsp;<div class="tableDiv" id="pwdOneDiv"></div>
          </TD></TR>
        <TR>
          <TD  class="tdFive" align=right><SPAN class="spanFour">确认密码</SPAN> </TD>
          <TD class="tdSix"><span class="red">*</span>&nbsp;<INPUT class="inputThree" type="password" name="pwdTwo" id="pwdTwo"
            onFocus="onFocus(3,'pwdTwoDiv')" onBlur="pwdTwoBlur()">&nbsp;&nbsp;<br />&nbsp;
            <div class="tableDiv" id="pwdTwoDiv"></div> </TD></TR>
            </TABLE>
      <TABLE cellSpacing=1 cellPadding=0 width="100%" border=0>
        <TR>
          <TD colSpan=2>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TR>
                <TD style="HEIGHT: 15px"></TD></TR>
              <TR>
                <TD class="font">&nbsp;<B>您的重要个人信息</B><SPAN class="spanFive">&nbsp;&nbsp;&nbsp;-- 
                  为了更好的服务，请认真填写，T03不会泄露您的个人信息</SPAN> </TD></TR>
              <TR>
                <TD style="HEIGHT: 10px"></TD></TR></TABLE></TD></TR>
        <TR>
          <TD class="tdSeven" align=right><SPAN class="spanSix">姓 名</SPAN> </TD>
          <TD class="tdEight"> &nbsp;
            <span class="red">*</span>&nbsp;<INPUT class="inputFour" id="txtSurname" name="txtSurname" onFocus="onFocus(4,'SurNameDiv')" onblur="txtSurnameBlur()" />
            &nbsp;<div id="SurNameDiv" class="UserDiv"></div></TD></TR>
        <TR>
          <TD class="tdTen" align=right><SPAN class="spanSeven">手机号码</SPAN> </TD>
          <TD class="tdEleven"> &nbsp;
            <span class="red">*</span>&nbsp;<INPUT class="inputFive" id="txtPhone" maxLength=11 name="txtPhone" onFocus="onFocus(5,'txtPhoneDiv')" onblur="txtPhoneBlur()" />
            &nbsp;<div id="txtPhoneDiv" class="UserDiv"></div></TD></TR>
        <TR>
          <TD class="tdTwelve" align=right><SPAN class="spanEight">详细地址</SPAN> </TD>
          <TD class="tdThirteen">&nbsp;
            <span class="red">*</span>&nbsp;<INPUT class="inputSix" id="txtAddress" name="txtAddress" onFocus="onFocus(6,'txtAddressDiv')" onblur="txtAddressBlur()" />
            &nbsp;<div id="txtAddressDiv" class="UserDiv"></div>
        </TD></TR></TABLE>
      <TR>
            <TD colSpan=3><TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                <TR>
                  <TD width="40" class="tdFourteen"></TD>
                  <TD width="418" class="tdFifteen"><span class="red">*</span>&nbsp;请输入验证码
                    <INPUT class="inputSeven" id="txtmask" maxLength=4 name="txtmask" />
                  <img name="img1" src="ColorRandom.jsp" style="cursor: hand" width="100" onclick="this.src='ColorRandom.jsp'">
<a href="JavaScript:reloadImage('ColorRandom.jsp');"><font size="2">看不清?换一张</font></a><br/>
				  </TD>
              </TR>
                <TR>
              <tr height="38px">
              	<td colspan="4" align="center"><br /><input type="submit"value=" 提 交 " />
               	&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value=" 重 置 " />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
              </tr>
            </TABLE></td></TR>
	</TABLE>
</form>
  </body>
</html>
