<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>后台管理版面</title>
<script type="text/javascript">
function onClick(op){
	for(var i=1;i<=4;i++){
		if(op==i){
			if(document.getElementById("d"+i).style.display=="none"){
				document.getElementById("d"+i).style.display="block";
			}else{
				document.getElementById("d"+i).style.display="none";
			}			
		}else{
			document.getElementById("d"+i).style.display="none";
		}
	}			
}
</script>
<link rel="stylesheet" type="text/css" href="css/BackOfficeSystem.css">
</head>

<body>
	<div style="float: left; width:16%; height:550px; background-color: #EFEFEF; border:solid #698CC3 1px">
		<br />
		<table align="center" width="100%" border="0" cellpadding="3" cellspacing="0" class="font">
			<tr align="center">
				<td>系统后台管理版面</td>
			</tr>
			<tr align="center">
				<td><a href="javascript:onClick('1');" class="font">用户管理</a><div id="d1" style="display:none;">
						<table id="menu" border="1" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td><a href="BackOfficeAddAdmin.jsp">			
									<span class="left"></span>
										添加管理员
									<span class="right"></span></a></td>
							</tr>
							<tr>
								<td><a href="BackOfficeUser.jsp">
									<span class="left"></span>
										用户管理
									<span class="right"></span></a></td>
							</tr>
						</table></div></td>
			</tr>
			<tr align="center">
				<td><a href="javascript:onClick('2');" class="font">商品管理</a><div id="d2" style="display:none;">
						<table id="menu" border="1" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td><a href="BackOfficeAddWare.jsp">			
									<span class="left"></span>
										添加商品
									<span class="right"></span></a></td>
							</tr>
							<tr>
								<td><a href="BackOfficeSuperviseWare.jsp">
									<span class="left"></span>
										管理商品
									<span class="right"></span></a></td>
							</tr>
						</table></div></td>
			</tr>
			<tr align="center">
				<td><a href="javascript:onClick('3');" class="font">新闻管理</a><div id="d3" style="display:none;">
						<table id="menu" border="1" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td><a href="BackOfficeAddNews.jsp">
									<span class="left"></span>
										添加新闻
									<span class="right"></span></a></td>
							</tr>
							<tr>
								<td><a href="BackOfficeSuperviseNews.jsp">
									<span class="left"></span>
										管理新闻
									<span class="right"></span></a></td>
							</tr>
						</table></div></td>
			</tr>
			<tr align="center">
				<td><a href="javascript:onClick('4');" class="font">订单管理</a><div id="d4" style="display:none;">
						<table id="menu" border="1" bordercolor="#FFFFFF" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td><a href="BackOfficeSystem.jsp">
									<span class="left"></span>
										查看订单
									<span class="right"></span></a></td>
							</tr>
						</table></div></td>
			</tr>
			<tr align="center">
				<td><a href="manage/doLogout.jsp" class="font">[安全登出]</a></td>
			</tr>
		</table>
	</div>
	<div style="float: left;width:80%; height:550px; border:solid #698CC3 1px; border-left-width:15px; background-color:#F1F7F9;">
	  <div style="position:relative; top:20px; left:35px; width:80%; height:500px; border:solid #698CC3 1px;">
	    <form>
	      <table class="font" width="100%" height="100%" border="1" bordercolor="#D6E0EF" cellpadding="10" cellspacing="0">
	        <tr>
	          <td colspan="2" bgcolor="#698CC3" class="font1">添加商品</td>
	        </tr>
	        <tr>
	          <th width="30%">产品类型</th>
	          <th width="70%" height="26" colspan="10"><label>
	            <select name="select2">
	              <option>nike</option>
	              <option>adidas</option>
	            </select>
	          </label></th>
	        </tr>
	        <tr>
	          <th>品牌名称</th>
	          <th><label>
	            <select name="select3">
	              <option>adidas</option>
	            </select>
	          </label></th>
	        </tr>
	        <tr>
	          <th>鞋子名称</th>
	          <th><label>
	            <input type="text" name="textfield3" />
	          </label></th>
	        </tr>
	        <tr>
	          <th>尺寸</th>
	          <th><label>
	            <input type="text" name="textfield4" />
	          </label></th>
	        </tr>
	        <tr>
	          <th>款式</th>
	          <th><label>
	            <select name="select">
	              <option>男款</option>
	              <option>女款</option>
	            </select>
	          </label></th>
	        </tr>
	        <tr>
	          <th>价钱</th>
	          <th><input type="text" name="textfield42" /></th>
	        </tr>
	        <tr>
	          <th>订单数量</th>
	          <th><input type="text" name="textfield43" /></th>
	        </tr>
	        <tr>
	          <th>库存</th>
	          <th><input type="text" name="textfield44" /></th>
	        </tr>
	        <tr>
	          <th>添加时间</th>
	          <th><input type="text" name="textfield45" /></th>
	        </tr>
	        <tr>
	          <th  colspan="2" align="left">　　　　　　　　　　　　　　　　　
	              <input type="submit" value="提交" />  
	              <input type="reset" value="重置" /></th>
	        </tr>
	      </table>
	    </form>
	  </div>
	</div>
</body>
</html>
