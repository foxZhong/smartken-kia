<%@ page language="java" import="java.util.*,shoes.dao.*" pageEncoding="GB18030"%>
<jsp:directive.page import="shoes.dao.impl.*"/>
<jsp:directive.page import="shoes.entity.*"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>right</title>
<!--
<link rel="stylesheet" type="text/css" href="css/right.css">
-->
<script type="text/javascript" src="javascript/main.js"></script>


<script type="text/javascript">
function divOpen(nid){
	document.getElementById("divOpen"+nid).style.display="block";

}
function divClose(nid){
	document.getElementById("divOpen"+nid).style.display = "none";
}
</script>
<%!
	
     News news = new News();
%>
</head>

<body onLoad="Switch();">
<div style="width:100%;">
  <table width="100%" border="0" cellpadding="10" cellspacing="0">
    <tr>
      <td><table width="100%" border="0" align="center" cellpadding="3" cellspacing="0">
        <tr>
          <td align="center">
			<a href="#">
				<img src="image/001.jpg" id="SlideShow" name='SlideShow' />
			</a>
		  </td>
          <td align="center">
          <table>
				<tr>
					<td>
						<a href="#" onMouseOver="mouseover('0')" onMouseOut="mouseout('0')"><img id="s0" src="image/001.jpg" style="width:120px; height:80;" /></a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="#" onMouseOver="mouseover('1')" onMouseOut="mouseout('1')"><img id="s1" src="image/002.jpg" style="width:120px; height:80;" /></a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="#" onMouseOver="mouseover('2')" onMouseOut="mouseout('2')"><img id="s2" src="image/003.jpg" style="width:120px; height:80;" /></a>
					</td>
				</tr>
			</table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td>
         <div class="title"><strong>站内新闻</strong></div>
         <%
         NewsDaoImpl newsDao = new NewsDaoImpl();
         List list = newsDao.findNewFiveNews();
         for(int i=0;i<list.size();i++){
         news = (News)(list.get(i));
         %>
         <div>&nbsp;<img src="image/data.gif" width="16" height="16" />&nbsp;<a href="javascript:divOpen(<%=news.getNId() %>);" class=font3><%=news.getTitle() %></a>&nbsp;<span class="font">[<%=news.getPublished().substring(0,10) %>]</span></div>

         <div id="divOpen<%=news.getNId() %>" style="position:absolute; top:400px; left:250px; width:600px; height:300px; background-color:#FFFFCC; border:solid #FF6600 1px; display:none; ">
             <table width="100%" cellpadding="0" cellspacing="20">
                 <tr>
                     <th id="divTitle"><%=news.getTitle() %></th>
                 </tr>
                 <tr>
                     <td><p id="divContent">&nbsp;&nbsp;&nbsp;&nbsp;<%=news.getContent() %></p></td>
                 </tr>
             </table>
             <div id="divClose<%=news.getNId() %>" style="position:absolute; left: 581px; top: 2px;"><img src="image/del.gif" onClick="divClose(<%=news.getNId() %>);" /></div>
         </div>
         <%} %>
      </td>
    </tr>
    <tr>
      <td><table width="100%" border="0" cellpadding="3" cellspacing="0">
        <tr>
          <td class="title" colspan="3">&nbsp;<strong>新鞋上架</strong>&nbsp;&nbsp;</td>
        </tr>
        <tr>        
        <% 
        	BrandDao bDao = new BrandDaoImpl();
			CommodityTypeDao tDao = new CommodityTypeDaoImpl();
			CommodityInfoDao cDao = new CommodityInfoDaoImpl();
			List list1 = cDao.findNewWare();
			for(int i=0;i<list1.size();i++){
				CommodityInfo c = (CommodityInfo)(list1.get(i));
			
        %>          

          <td align="left"><a href="ShoesInfo.jsp?CId=<%=c.getCId() %>"><img src="image/<%=c.getCName() %>/f001.jpg" alt="<%=bDao.findBrand(c.getCBId()).getBCName() %>" width="220" height="150" /></a><br />
          	&nbsp;<strong>品牌</strong>：<span class="font2"><%=bDao.findBrand(c.getCBId()).getBName() %></span><br />
          	&nbsp;<strong>类型</strong>：<span class="font2"><%=tDao.findType(c.getCTId()).getTName() %></span><br />
          	&nbsp;<strong>价格</strong>：<span class="font4"><%=c.getPrice() %>元</span><br />
            &nbsp;<strong>时间</strong>：<span class="font2"><%=c.getAddDate().substring(0,10) %></span>
		  &nbsp;&nbsp;<a href="ShoesInfo.jsp?CId=<%=c.getCId() %>">详情&gt;&gt;</a></td>

		<%} %>
        </tr>        
      </table></td>
    </tr>
    <tr>
      <td><table width="100%" border="0" cellpadding="3" cellspacing="0">
        <tr>
          <td class="title"><strong>&nbsp;精品推荐</strong></td>
          </tr>
        <tr>
          <td>
		  <marquee behavior="alternate" onmouseover="this.stop()" onmouseout="this.start()">
		  <a href="#"><img src="image/shoes1.jpg" alt="精品推荐" width="208" height="150" border="0" /></a>
		  <a href="#"><img src="image/shoes2.jpg" alt="精品推荐" width="208" height="150" border="0" /></a>
		  <a href="#"><img src="image/shoes3.jpg" alt="精品推荐" width="208" height="150" border="0" /></a>
		  <a href="#"><img src="image/shoes4.jpg" alt="精品推荐" width="208" height="150" border="0" /></a>
		  <a href="#"><img src="image/shoes5.jpg" alt="精品推荐" width="208" height="150" border="0" /></a>
		  <a href="#"><img src="image/shoes6.jpg" alt="精品推荐" width="208" height="150" border="0" /></a>
		  <a href="#"><img src="image/shoes7.jpg" alt="精品推荐" width="208" height="150" border="0" /></a>
		  <a href="#"><img src="image/shoes8.jpg" alt="精品推荐" width="208" height="150" border="0" /></a>
		  <a href="#"><img src="image/shoes9.jpg" alt="精品推荐" width="208" height="150" border="0" /></a>
		  <a href="#"><img src="image/shoes10.jpg" alt="精品推荐" width="208" height="150" border="0" /></a>
		  </marquee>
		  </td>
        </tr>
      </table></td>
    </tr>
  </table>
</div>
</body>
</html>