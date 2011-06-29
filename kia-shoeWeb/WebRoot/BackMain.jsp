<%@ page language="java" import="java.util.*,shoes.entity.*,shoes.dao.*,shoes.dao.impl.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BackMain.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="css/BackOfficeSystem.css"/>
<link rel="stylesheet" type="text/css" href="css/page.css"/>
  </head>
  
  <body style=" border:solid #698CC3 1px; background-color:#F1F7F9;">
		<div style="position:relative; top:30px; left:30px; width:750px; border:solid #698CC3 1px; background-color:#F1F7F9;">  
			<form action="BackOfficeSystem.jsp" method="post" name="Orderfrom">
				<table class="font" width="100%" height="100%" border="1" bordercolor="#D6E0EF" cellpadding="3" cellspacing="0">
					<tr>
						<td colspan="7" bgcolor="#698CC3" class="font1">订单管理</td>
					</tr>
					<tr>
						<th>订单编号</th>
						<th>顾客名称</th>
						<th>电话</th>
						<th>地址</th>
						<th>订货时间</th>
						<th>状态</th>
						<th>管理</th>
					</tr>
					<%	int current=1;
						if(request.getParameter("current")!=null){
							current = Integer.parseInt(request.getParameter("current"));
						}										
						String number = request.getParameter("number");
						OrdersDaoImpl od = new OrdersDaoImpl();
						List list = new ArrayList();
						if(number!=null && number!=""){
							list = od.findOrders(number,current);
						}else{
							list = od.findOrders(current);
						}					
						String result = "";
						for(int i=0; i<list.size(); i++) {
							Orders orders = (Orders)(list.get(i));
							DeliveryInfoDao did = new DeliveryInfoDaoImpl();
							if(orders.getOState().equals("未发货")) {
								result = "发货";
							}else {
								result = "&nbsp;";
							}
					%>
					<tr align="center">
						<td><a class="font2" href="BackOfficeOrderInfo.jsp?oid=<%=orders.getOId() %>"><%=orders.getNumber() %></a></td>
						<td><%=did.findDeliveryInfo(orders.getODId()).getDName() %></td>
						<td><%=did.findDeliveryInfo(orders.getODId()).getTel() %></td>
						<td><%=did.findDeliveryInfo(orders.getODId()).getAddress() %></td>
						<td><%=orders.getStartTime().substring(0,10) %></td>
						<td><%=orders.getOState() %></td>
						<td><a class="font2" href="manage/doOrders.jsp?OId=<%=orders.getOId() %>"><%=result %></a></td>
					</tr>
					<%} %>
				</table>				
				<br /><div align="right" class="font">请输入订单号：<input name="number" type="text" /><input type="submit" value="查询" /></div>
			</form>
			<script type="text/javascript" >          
		       function getCurrent()
		       {
		          var current = document.getElementById("txt").value;
		          document.form1.current.value=current;
		          document.form1.submit();
		       }
		    
		    </script>
		    <form action="BackOfficeSystem.jsp" method="post" name="form1">
		    	<input type="hidden" name="current" value="<%=current %>"/>
		    </form>		                 
		    <% 	
		    	int sumNum = od.findOrders(number).size();
		    	int SumPage = sumNum/6 + (sumNum%6==0?0:1);
		    %>		    
			<table id="page" border="1" bordercolor="#989898" cellpadding="0" cellspacing="10" align="center">
				<tr>
					<td class="bg2">
					<% 
						if(current==1){
							out.print("第一页");
						}else{
							out.print("<a class='bg1' href='BackOfficeSystem.jsp?current=1'>第一页</a>");
						}
					%>
					</td>
			    	<%
			    		for(int i=1;i<=SumPage;i++){ 
				    		if(current==i){
				    			out.print("<td class='bg3'>&nbsp;"+i+"&nbsp;</td>");
				    		}else{
				    			out.print("<td>&nbsp;<a class='bg1' href='BackOfficeSystem.jsp?current="+i+"'>"+i+"</a>&nbsp;</td>");
				    		}
			    		}
			    	%>
					<td class="bg2">
					<% 
						if(current==SumPage){
							out.print("最末页(共"+SumPage+"页)");
						}else{
							out.print("<a class='bg1' href='BackOfficeSystem.jsp?current="+SumPage+"'>最末页(共"+SumPage+"页)</a>");
						}
					%>
					</td>
					<td class="bg5"><input class="bg6" type="text" size="1" id="txt" value="<%=current %>" /></td>
					<td class="bg3"><input class="bg4" type="button" value=" Go " onclick="getCurrent()" /></td>					
			    </tr>
		    </table>
		</div>		
  </body>
</html>
