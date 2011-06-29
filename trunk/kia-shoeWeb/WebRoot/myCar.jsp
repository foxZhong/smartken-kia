<%@ page language="java" import="java.util.*,shoes.dao.*" pageEncoding="GB18030"%>
<jsp:directive.page import="shoes.entity.*"/>
<jsp:directive.page import="shoes.dao.impl.*"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>购物车</title>
<link rel="stylesheet" type="text/css" href="css/myCar.css" />
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>

<body>
<div id="top"><jsp:include page="Top.jsp"></jsp:include></div>
<div id="left" style="float:left;width:23%;"><jsp:include page="MyCarLeft.jsp"></jsp:include></div>
<div style="float:right;width:75%">
  <div class="top">
  <img src="image/cart_001.gif" />
  </div>
  <div id="nifty">
	<b class="rtop"><b class="r1"></b><b class="r2"></b><b class="r3"></b><b class="r4"></b></b>
	&nbsp;&nbsp;<b>我选择的商品</b>
  </div>
  <table border="0" id="bigTable" cellpadding="10" cellspacing="0">
	<tr>
	  <td width="90%" align="center">
	  <DIV>
	  	<table border="1" align="center" width="90%" cellpadding="0" cellspacing="0">
			  <tr class="tr">
			  	<td align="center">图片</td>
				<td align="center">商品名</td>
				<td align="center">单价（元）</td>
				<td align="center">数量</td>
				<td align="center">删除</td>
				<td align="center">小计</td>
			  </tr>
		  </table>
		  <DIV class="cartmore" style="height: 200px">
		  <table border="0" align="center" width="97%" cellpadding="10" cellspacing="0">
		  <%  
		  	  List items=(List)session.getAttribute("items"); 
		      double total=0;
		     if(items.size()==0)
		     {
		  %>
			  <tr>
				<td colspan="6" align="center"><strong>您还没有选任何商品,<a class=font4 href="ShoesType.jsp">马上去选购</a></strong></td>
			  </tr>
		  <%}else{
		        Iterator it=items.iterator();
		        CommodityInfoDaoImpl cdao=new CommodityInfoDaoImpl();
		        while(it.hasNext())
		        {
		          OrderItem oi=(OrderItem)it.next();
		          CommodityInfo cio=cdao.findWard(oi.getItemCid());
		          total+=oi.getItemCount()*oi.getItemPrice();
		   %>
		   <form action="manage/doEditOrderItem.jsp" method="post" id="itemForm<%=oi.getItemCid() %>">
			  <input type="hidden" name="cId" value="<%=oi.getItemCid()%>"/> 
			  <tr>
			  	<td align="center"><img src="image/<%=cio.getCName()%>/f001.jpg" width=70 height=50 /></td>
				<td align="center">ESITO XL IT<%=cio.getCName() %></td>
				<td align="center"><%=oi.getItemPrice() %></td>
				<td align="center">
					<input type="text" name="count" class="count" value="<%=oi.getItemCount() %>" />
					<a href="javascript:doItem(<%=oi.getItemCid() %>)">修改</a>
				</td>
				<td align="center"><a href="manage/doDeleteOrderItem.jsp?cId=<%=oi.getItemCid() %>"><img src="image/del.gif" border="0" /></a></td>
				<td align="center"><%=oi.getItemCount()*oi.getItemPrice() %></td>
			  </tr>
		   </form>
			<%}
			} %> 
		</table>
		<script type="text/javascript" >
		  function doItem(id)
		  {
		    document.getElementById("itemForm"+id).submit();
		  }
		  function doCar()
		  {
		    alert("您还没有选择商品~！");
		  }
		</script>
		</DIV>
	</DIV>
		<hr />
		<table border="0" class="table3">
		  <tr>
		  	<td colspan="4" align="right"><strong>商品总额：<img src="image/money.png" />&nbsp;<%=total %></strong>&nbsp;&nbsp;&nbsp;</td>
		  </tr>
		</table>
		<br />
		<table border="0" align="center" width="100%" cellpadding="0" cellspacing="5%">
		  <tr>
		  	<td align="left"><a href="ShoesType.jsp?curremt=1"><img src="image/b1.gif" /></a>&nbsp;
			<a href="manage/doClearCar.jsp"><img src="image/b2.gif" /></a></td>
			<td align="right">
			<% 
				if(items.size()==0){
					out.print("<a href='javascript:doCar()'><img src='image/b3.gif' /></a>&nbsp;&nbsp;");
				}else{
					out.print("<a href='Checkout.jsp'><img src='image/b3.gif' /></a>&nbsp;&nbsp;");
				}
			%>
			</td>
		  </tr>
		</table>
	  </td>
	</tr>
  </table>
</div>
<div><jsp:include page="Bottom.jsp"></jsp:include></div>
</body>
</html>
