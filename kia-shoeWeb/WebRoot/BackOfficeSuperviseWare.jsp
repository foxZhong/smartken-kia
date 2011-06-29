<%@ page language="java" import="java.util.*,shoes.entity.*,shoes.dao.*,shoes.dao.impl.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>后台管理版面</title>
<link rel="stylesheet" type="text/css" href="css/page.css"/>
<script language="javascript" type="text/javascript">
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
<link rel="stylesheet" type="text/css" href="css/BackOfficeSystem.css"/>

<%
	int current=1;
	if(request.getParameter("current")!=null){
		current = Integer.parseInt(request.getParameter("current"));
	}
	CommodityInfoDao cid = new CommodityInfoDaoImpl();
	List list = cid.findAllWare(current);
%>
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
	<div style="float: left;width:82%; height:550px; border:solid #698CC3 1px; border-left-width:15px; background-color:#F1F7F9;">
		<div style="position:relative; top:30px; left:35px; width:750px; border:solid #698CC3 1px;">
		  <table   class="font"width="100%" border="1" bordercolor="#D6E0EF" cellpadding="5" cellspacing="0">
            <tr>
              <td colspan="10" bgcolor="#698CC3" class="font1">商品管理</td>
            </tr>
            <tr>
              <td><div align="center">产品类型</div></td>
              <td><div align="center">品牌名称</div></td>
              <td><div align="center">鞋子名称</div></td>
              <td><div align="center">尺寸</div></td>
              <td><div align="center">款式</div></td>
              <td><div align="center">价钱</div></td>
              <td><div align="center">卖出数量</div></td>
              <td><div align="center">库存</div></td>
              <td><div align="center">添加时间</div></td>
              <td><div align="center">管理</div></td>
            </tr>
			<%
				for(int i=0; i<list.size(); i++) {
					CommodityInfo ci = (CommodityInfo)list.get(i);
					CommodityTypeDao ct = new CommodityTypeDaoImpl();
					BrandDao bd = new BrandDaoImpl();
			%>
            <tr align="center">
              <td><%=ct.findType(ci.getCTId()).getTName() %></td>
              <td><%=bd.findBrand(ci.getCBId()).getBName() %></td>
              <td><%=ci.getCName() %></td>
              <td><%=ci.getSize() %></td>
              <td><%=ci.getStyle()==1?"男款":"女款" %></td>
              <td><%=ci.getPrice()%></td>
              <td><%=ci.getSalesCount() %></td>
              <td><%=ci.getStockCount() %></td>
              <td><%=ci.getAddDate().substring(0,10) %></td>
              <td><a class="font2" href="#">修改</a></td>
            </tr>
			<%} %>
          </table>
			<script type="text/javascript" >          
		       function getCurrent()
		       {
		          var current = document.getElementById("txt").value;
		          document.form1.current.value=current;
		          document.form1.submit();
		       }
		    
		    </script>
		    <form action="BackOfficeSuperviseWare.jsp" method="post" name="form1">
		    	<input type="hidden" name="current" value="<%=current %>"/>
		    </form>		                 
		    <% 
		    	int sumNum = cid.findAllWare().size();
		    	int SumPage = sumNum/6 + (sumNum%6==0?0:1);
		    %>		    
			<table id="page" border="1" bordercolor="#989898" cellpadding="0" cellspacing="10" align="center">
				<tr>
					<td class="bg2">
					<% 
						if(current==1){
							out.print("第一页");
						}else{
							out.print("<a class='bg1' href='BackOfficeSuperviseWare.jsp?current=1'>第一页</a>");
						}
					%>
					</td>
			    	<%
			    		for(int i=1;i<=SumPage;i++){ 
				    		if(current==i){
				    			out.print("<td class='bg3'>&nbsp;"+i+"&nbsp;</td>");
				    		}else{
				    			out.print("<td>&nbsp;<a class='bg1' href='BackOfficeSuperviseWare.jsp?current="+i+"'>"+i+"</a>&nbsp;</td>");
				    		}
			    		}
			    	%>
					<td class="bg2">
					<% 
						if(current==SumPage){
							out.print("最末页(共"+SumPage+"页)");
						}else{
							out.print("<a class='bg1' href='BackOfficeSuperviseWare.jsp?current="+SumPage+"'>最末页(共"+SumPage+"页)</a>");
						}
					%>
					</td>
					<td class="bg5"><input class="bg6" type="text" size="1" id="txt" value="<%=current %>" /></td>
					<td class="bg3"><input class="bg4" type="button" value=" Go " onclick="getCurrent()" /></td>					
			    </tr>
		    </table>
		</div>
	</div>
</body>
</html>