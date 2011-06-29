<%@ page language="java" import="java.util.*,shoes.dao.*" pageEncoding="GB18030"%>
<jsp:directive.page import="shoes.entity.*"/>
<jsp:directive.page import="shoes.dao.impl.*"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
	int CId = Integer.parseInt(request.getParameter("CId"));
	CommodityInfoDao cDao = new CommodityInfoDaoImpl();
	CommodityInfo cInfo = cDao.findWard(CId);
    BrandDao bDao = new BrandDaoImpl();
	CommodityTypeDao tDao = new CommodityTypeDaoImpl();

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ShoesInfo</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<link rel="stylesheet" type="text/css"  href="css/mouse.css" />
	<script type="text/javascript" src="javascript/mouse.js"></script>	
<script language="javascript" type="text/javascript">
function view_on(op){
	var aa = document.getElementById("image").src;
	for(var i=1;i<=8;i++){
		if(op==i){
			document.getElementById("img"+i).src="image/view"+i+"_on.gif";
			document.getElementById("image").src="image/<%=cInfo.getCName() %>/f00"+i+".jpg";
		}else{
			document.getElementById("img"+i).src="image/view"+i+"_off.gif";
		}	
	}
}
var advInitTop=60;
var closeInitTop=64;
function init(){
    advInitTop=document.getElementById("advLayer").style.pixelTop;
	closeInitTop=document.getElementById("closeLayer").style.pixelTop;
}
function move(){
    document.getElementById("advLayer").style.pixelTop=advInitTop+document.body.scrollTop;
    document.getElementById("closeLayer").style.pixelTop=closeInitTop+document.body.scrollTop;
}
function closeMe(){
    document.getElementById("closeLayer").style.display="none";
    document.getElementById("advLayer").style.display="none";
}
window.onscroll=move;
</script>

  </head>
  
  <body>
  	<div>
  		<div id="top"><jsp:include page="Top.jsp"></jsp:include></div>
  		<div id="left" style="float:left;width:23%;"><jsp:include page="Left.jsp"></jsp:include></div>
  		<div id="main" style="float:right;width:75%">
		  <div id=advLayer style="position:absolute; top:140px; right:30px;"><img src="image/guanggao.png" border="0" /></div>
		  <div id=closeLayer onClick="closeMe()" style="position:absolute; top:144px; right:33px;"><img src="image/closed.gif" border="0" /></div>		  
		  <div>
		  	<table cellpadding="0" cellspacing="0" border="0">
			  <tr>
			  	<td colspan="8">
				<img id="image" src="image/<%=cInfo.getCName() %>/f001.jpg" />
				</td>
			  </tr>
			  <tr>
			  	<td align="center"><img id="img1" src="image/view1_on.gif"  width="53" height="53" onmouseover="view_on('1');" /></td>
				<td align="center"><img id="img2" src="image/view2_off.gif" width="53" height="53" onmouseover="view_on('2');" /></td>
				<td align="center"><img id="img3" src="image/view3_off.gif" width="53" height="53" onmouseover="view_on('3');" /></td>
				<td align="center"><img id="img4" src="image/view4_off.gif" width="53" height="53" onmouseover="view_on('4');" /></td>
				<td align="center"><img id="img5" src="image/view5_off.gif" width="53" height="53" onmouseover="view_on('5');"  /></td>
				<td align="center"><img id="img6" src="image/view6_off.gif" width="53" height="53" onmouseover="view_on('6');"  /></td>
				<td align="center"><img id="img7" src="image/view7_off.gif" width="53" height="53" onmouseover="view_on('7');"  /></td>
				<td align="center"><img id="img8" src="image/view8_off.gif" width="53" height="53" onmouseover="view_on('8');" /></td>
			  </tr>
			  <tr>
			  	<td align="center">整对</td>
				<td align="center">顶部</td>
				<td align="center">底部</td>
				<td align="center">左侧</td>
				<td align="center">背面</td>
				<td align="center">右侧</td>
				<td align="center">正面</td>
				<td align="center">放大</td>
			  </tr>
			</table>
		  </div>
		  <div>
		  	<form action="manage/doBuy.jsp" method="post" id="buyForm">
			    <input type="hidden" name="cId" value="<%=cInfo.getCId() %>">
			    <input type="hidden" name="price" value="<%=cInfo.getPrice() %>">
		  	<table border="0" width=505px cellpadding="5" cellspacing="0">
			  <tr>
			  	<td colspan="2"><hr /></td>
			  </tr>		  	
			  <tr>
			  	<td>商品名：</td>
			  	<td class=font2><%=bDao.findBrand(cInfo.getCBId()).getBName() %> <%=tDao.findType(cInfo.getCTId()).getTName() %> <%=cInfo.getCName() %></td>
			  </tr>
			  <tr>
			  	<td>价格：</td>
			  	<td class=font4><%=cInfo.getPrice() %>元</td>
			  </tr>
			  <tr>
			  	<td>款式：</td>
			  	<td class=font2><%=cInfo.getStyle()==1?"男款":"女款" %></td>
			  </tr>
			  <tr>
			  	<td>联系客服：</td>
				  <td>
					<a target="_top" href="tencent://message/?uin=331234058&Site=T03Shoes&Menu=yes">
					<img border="0" src="image/qq.jpg" /></a>
				  </td>
			  </tr>
			  <tr>
			  	<td>累计销售：</td>
			  	<td class=font2><%=cInfo.getSalesCount() %> 对</td>
			  </tr>
			  <tr>
			  	<td>剩余库存：</td>
			  	<td class=font2><%=cInfo.getStockCount() %> 对</td>
			  </tr>
			  <tr>
			  	<td colspan="2"><hr /></td>
			  </tr>
			  <tr>
			  	<td>尺码：</td>
			  	<td class=font2><%=cInfo.getSize() %></td>
			  </tr>

			  <tr>
			  	<td>我要买:</td>
			  	<td class=font2>
			  	<input name="count" type="text" value=1 style="text-align:right; width:40px;" /> 对</td>
			  </tr>
			  <tr>
			  	<td colspan="2" align="center"><a href="javascript:doBuy()"><img src="image/13.gif" border="0" /></a></td>
			  </tr>
			</table>
			</form>
			<script type="text/javascript">
			   function doBuy()
			   {
			     document.getElementById("buyForm").submit();
			   }
			</script>
		  </div>
  		</div>
  		<div><jsp:include page="Bottom.jsp"></jsp:include></div>
  	</div>
  </body>
</html>
