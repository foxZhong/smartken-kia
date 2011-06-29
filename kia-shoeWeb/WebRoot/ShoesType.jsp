<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="shoes.dao.impl.*,shoes.entity.*" %>
<%@page import="shoes.dao.*"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>ShoesType</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<link rel="stylesheet" type="text/css" href="css/page.css">
	<link rel="stylesheet" type="text/css"  href="css/mouse.css" />
	<script type="text/javascript" src="javascript/mouse.js"></script>

  </head>
  
  <body>
   <% 
       int ctId=0;
       int cbId=0;
	   int style=0;
	   int current = 1;
	   if(request.getParameter("current")!=null)
	       current = Integer.parseInt(request.getParameter("current"));
       if(request.getParameter("ctId")!=null)
    	   ctId=Integer.parseInt(request.getParameter("ctId"));
       if(request.getParameter("cbId")!=null)
    	   cbId=Integer.parseInt(request.getParameter("cbId"));
       if(request.getParameter("style")!=null)
    	   style=Integer.parseInt(request.getParameter("style"));
   %>
   <script type="text/javascript" >
       function doctId(ctId)
       {
          document.shoeform.ctId.value=ctId;
          //alert(document.shoeform.tId.value);
          document.shoeform.submit();
       }

       function docbId(cbId)
       {
          document.shoeform.cbId.value=cbId;
          document.shoeform.submit();
       }

       function doStyle(style)
       {
          document.shoeform.style.value=style;
          document.shoeform.submit();
       }
       function doCurrent(current)
       {
          document.shoeform.current.value=current;
          document.shoeform.submit();
       }
       function getCurrent()
       {
          var current = document.getElementById("txt").value;
          document.shoeform.current.value=current;
          document.shoeform.submit();
       }
   </script>
   <form action="ShoesType.jsp" method="post" name="shoeform">
     <input type="hidden" name="ctId" value="<%=ctId %>">
     <input type="hidden" name="cbId" value="<%=cbId %>">
     <input type="hidden" name="style" value="<%=style %>">
     <input type="hidden" name="current" value="<%=current %>">
   </form>
  	<div>
  		<div id="top"><jsp:include page="Top.jsp"></jsp:include></div>
  		<div id="left" style="float:left;width:23%;"><jsp:include page="Left.jsp"></jsp:include></div>
  		<div id="main" style="float:right;width:75%">
			<div>
			  <table width="749" border="0" cellpadding="0" cellspacing="0">
			    <tr>
			      <td width="771">
				  <fieldset>&nbsp;   
					<legend>按<strong style="font-style:italic">品牌</strong>选择</legend>  
						<table border="0" align="center" cellpadding="0" cellspacing="0">
						  <tr>
							<td width="170" height="25" align="center"><a href="javascript:docbId(1);">耐克</a></td>
							<td width="170" height="25" align="center"><a href="javascript:docbId(2);">阿迪达斯</a></td>
							<td width="170" height="25" align="center"><a href="javascript:docbId(3);">李宁</a></td>
							<td width="170" height="25" align="center"><a href="javascript:docbId(4);">彪马</a></td>
							<td width="170" height="25" align="center"><a href="javascript:docbId(5);">安踏</a></td>
						  </tr>
						  <tr>
							<td width="170" height="25" align="center"><a href="javascript:docbId(6);">匡威</a></td>
							<td width="170" height="25" align="center"><a href="javascript:docbId(8);">卡帕</a></td>
							<td width="170" height="25" align="center"><a href="javascript:docbId(9);">茵宝</a></td>
							<td width="170" height="25" align="center"><a href="javascript:docbId(10);">美津浓</a></td>
							<td width="170" height="25" align="center"><a href="javascript:docbId(11);">锐步</a></td>
						  </tr>
						</table>
				  </fieldset>
				  </td>
			    </tr>
			    <tr>
			      <td>
				  <fieldset>
				  	<legend>按<strong style="font-style:italic">类型</strong>选择</legend>
						<table border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td width="170" height="25" align="center"><a href="javascript:doctId(1);">篮球鞋</a></td>
								<td width="170" height="25" align="center"><a href="javascript:doctId(2);">足球鞋</a></td>
								<td width="170" height="25" align="center"><a href="javascript:doctId(3);">网球鞋</a></td>
								<td width="170" height="25" align="center"><a href="javascript:doctId(4);">跑步鞋</a></td>
							</tr>
					    </table>
				  </fieldset>
				  </td>
			    </tr>
			    <tr>
			      <td>
				  <fieldset>
				  	<legend>按<strong style="font-style:italic">款式</strong>选择</legend>
						<table border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td width="170" height="25" align="center"><a href="javascript:doStyle(1);">男款</a></td>
								<td width="170" height="25" align="center"><a href="javascript:doStyle(2);">女款</a></td>
								<td width="170" height="25" align="center"><a href="ShoesType.jsp">所有商品</a></td>
							</tr>
					    </table>
				  </fieldset>
				  </td>
			    </tr>
			  </table>
			  <table width=100%>			  
			   	  <% 
			        CommodityInfoDao cdao=new CommodityInfoDaoImpl();
			        List coms=cdao.getComList(ctId,cbId,style,current);
			        BrandDao bDao = new BrandDaoImpl();
					CommodityTypeDao tDao = new CommodityTypeDaoImpl();
			        if(coms.size()==0){
			      %>			      
			      <tr>
			      	<th align=center class=font5><br /><br /><br />无此类商品！<br /><br /><br /><br /><br /></th>
			      </tr>
			  		      
			      <% 
			        }else{
				        for(int i=0;i<coms.size();i++)
				        {
				        	CommodityInfo ci=(CommodityInfo)coms.get(i);
			      %>			      
                    <% 		if(i%3==0){ %><tr><%} %>
			      	<td>
			         <table>
			          	<tr>
			          		<td colspan="3"><img src="image/<%=ci.getCName()%>/f001.jpg " widht="220" height="180"></td>
			          	</tr>
			          	<tr>
			          		<th>品牌：</th>
			          		<td class=font2><%=bDao.findBrand(ci.getCBId()).getBName() %></td>
			          	</tr>
			          	<tr>
			          		<th>类型：</th>
			          		<td class=font2><%=tDao.findType(ci.getCTId()).getTName() %></td>
			          	</tr>
			          	<tr>
			          		<th>价格：</th>
			          		<td class=font4><%=ci.getPrice() %>元&nbsp;&nbsp;<a href="ShoesInfo.jsp?CId=<%=ci.getCId() %>">详情&gt;&gt;</a></td>
			          	</tr>
			          </table>			      	
			      	</td>
			      	<% 			if(i%3==2){ %></tr><%} %>
				       <%
				      		}
				       %>			      	    
			   </table>			      			      
			   <%} %>   	   	  			   	  
		    </div>
		    <% 
		    	int sumNum = cdao.getComList(ctId,cbId,style).size();
		    	int SumPage = sumNum/6 + (sumNum%6==0?0:1);
		    %>		    
			<table id="page" border="1" bordercolor="#989898" cellpadding="0" cellspacing="10" align="center">
				<tr>
					<td class="bg2">
					<% 
						if(current==1){
							out.print("第一页");
						}else{
							out.print("<a class='bg1' href='javascript:doCurrent(1)'>第一页</a>");
						}
					%>
					</td>
			    	<%
			    		for(int i=1;i<=SumPage;i++){ 
				    		if(current==i){
				    			out.print("<td class='bg3'>&nbsp;"+i+"&nbsp;</td>");
				    		}else{
				    			out.print("<td><a class='bg1' href='javascript:doCurrent("+i+")'>&nbsp;"+i+"&nbsp;</a></td>");
				    		}
			    		}
			    	%>
					<td class="bg2">
					<% 
						if(current==SumPage){
							out.print("最末页(共"+SumPage+"页)");
						}else{
							out.print("<a class='bg1' href='javascript:doCurrent("+SumPage+")'>最末页(共"+SumPage+"页)</a>");
						}
					%>
					</td>
					<td class="bg5"><input class="bg6" type="text" size="1" id="txt" value="<%=current %>" /></td>
					<td class="bg3"><input class="bg4" type="button" value=" Go " onclick="getCurrent()" /></td>					
			    </tr>
		    </table>
  		</div>
  		<div><jsp:include page="Bottom.jsp"></jsp:include></div>
  	</div>
  </body>
</html>
