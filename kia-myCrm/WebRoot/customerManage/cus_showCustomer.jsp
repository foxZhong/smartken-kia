<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>客户信息管理</title>
</head>
<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>
<sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'B1' and u_id=?;
	           <sql:param value='${user.uid}'></sql:param>
	        </sql:query>
   <c:forEach var="gRow" items="${grant.rows}">
     <c:if test="${gRow.fcount==0}">
        <jsp:forward page="../main/errorGrant.jsp"></jsp:forward>
     </c:if>
   </c:forEach>
<body>
<div id="container">
	<div id="globallink">
		<jsp:include page="../parts/globallink.jsp"></jsp:include>
	</div>
	<div id="left">
		<jsp:include page="../parts/left.jsp"></jsp:include>
	</div>
	<div id="main">
		<div id="banner"><img src="../images/banner.jpg" border="0"></div>
		<div id="hottest">
			<jsp:include page="../parts/hottest.jsp"></jsp:include>
		</div>
		 <!--编辑区-->
		 客户管理 -> 客户信息管理<p>
		 <html:form action="/customerManage/customer?url=cus_showCustomer" method="post">
		 <input type="hidden" name="oper" value="doSearchCustomers">
		 <input type="submit" value="查询"/>
		 <table width="700" cellpadding="0" cellspacing="0" border="1" align="center">
		 	<tr>
		 		<td width="100" align="center" class="formTitleTd">客户编号</td>
		 		<td width="130" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">
		 		  <html:text property="customers.cusId" value=""></html:text>
		 		</td>
		 		<td width="100" align="center" class="formTitleTd">名称</td>
		 		<td width="130" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">
		 		   <html:text property="customers.cusName"></html:text>
		 		</td>
		 		<td width="100" align="center" class="formTitleTd">地区</td>
		 		<td width="100" colspan="2" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">
		 		   <sql:query var="areas" dataSource="${con}">
		 		    select opt_value,opt_name from sys_dataoptions where opt_dataid=3;
		 		   </sql:query>
		 			  <html:select property="customers.cusArea">
		 				<option value="0">全部</option>
		 				<c:forEach var="areaRow" items="${areas.rows}">
		 				 <option value="${areaRow.opt_value }">${areaRow.opt_name }</option>
		 				</c:forEach>
		 			  </html:select>
		 		</td>
		 	</tr>
		 	<tr>
		 		<td width="100" align="center" class="formTitleTd">客户经理</td>
		 		<td width="130" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'"><html:text property="cusstaff.staffName"></html:text>
		 		</td>
		 		<td width="100" align="center" class="formTitleTd">客户等级</td>
		 		<td width="130" colspan="4" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">
		 			<sql:query var="levels" dataSource="${con}">
		 		    select opt_value,opt_name from sys_dataoptions where opt_dataid=1;
		 		   </sql:query>
		 			  <html:select property="customers.cusLevel">
		 				<option value="0">全部</option>
		 				<c:forEach var="levelRow" items="${levels.rows}">
		 				 <option value="${levelRow.opt_value }">${levelRow.opt_name }</option>
		 				</c:forEach>
		 			  </html:select>
		 		</td>
		 	</tr>
		 </table>
		 </html:form>
      
		 <table cellpadding="0" cellspacing="0" border="1" align="center" width="700">
			<tr height="25" class="listTitleTR">
		 		<td width="50" align="center">序号</td>
		 		<td width="80" align="center">客户编号</td>
		 		<td width="120" align="center">名称</td>
		 		<td width="70" align="center">地区</td>
		 		<td width="70" align="center">客户经理</td>
		 		<td width="110" align="center">客户等级</td>
		 		<td width="179" align="center">操作</td>
		 	</tr>
		<c:if test="${list==null}">
		 	<sql:query var="customers" dataSource="${con}">
		 		select cus_id,cus_name,
		 		(select opt_name from sys_dataoptions where opt_dataid=3 and opt_value=cus_area )as areaname,
		 		(select opt_name from sys_dataoptions where opt_dataid=1 and opt_value=cus_level )as levelname,
         		(select staff_name from cusstaff  where staff_id=cus_manid) as manager
         		from customers limit ?,?;
             <sql:param value='${(pc.curPage-1)*pc.maxItems }'/>
		     <sql:param value='${pc.maxItems}'></sql:param>
		 	</sql:query>
		 	<c:set var="index" value="${(pc.curPage-1)*pc.maxItems }" scope="page" ></c:set>
		 	<c:forEach var="cusRow" items="${customers.rows}" begin="0" end="10">
		 		<tr align="center" valign="middle" class="listTrMouseOut" 
		 			onMouseOver="this.className='listTrMouseOver'" 
		 			onMouseOut="this.className='listTrMouseOut'">
		 			<c:set var="index" value="${index+1}"></c:set>
		    		<td>${index }</td>
		 			<td>${cusRow.cus_id }</td>
		 			<td>${cusRow.cus_name }</td>
		 			<td>${cusRow.areaname }</td>
		 			<td>${cusRow.manager}</td>
		 			<td>${cusRow.levelname }</td>
		 			<td>
		 				<a href="cus_manage.jsp?cusId=${cusRow.cus_id}">编辑</a>
		 				<a href="cus_showContacts.jsp?cusId=${cusRow.cus_id}">联系</a>	
		 				<a href="cus_record.jsp?cusId=${cusRow.cus_id}">记录</a>	
		 				<a href="cus_showOrders.jsp?cusId=${cusRow.cus_id}">订单</a>	
		 			</td>
		 		</tr>
		 	</c:forEach>
		 	<tr>
		  		<td colspan="8">
	       		<script type="text/javascript">
	         		function jumpStep(v){
			   			document.getElementById("step").value=v;
	           			document.forms['jumpForm'].submit();
	         		}
	         		function jumpTo(){
	            		var jp=document.getElementById("jumpPage").value;
	            		if(jp>0&&jp<=document.getElementById("pages").value){
	            			document.getElementById("step").value=jp;
	           				document.forms['jumpForm'].submit();}
	           		 	else
	            			alert("跳转页面超出范围!");
	        		 }
	      		</script>
	      		<form id="jumpForm" action="../nextpage" method="post">
	      		<input type="hidden" name="url" value="customerManage/cus_showCustomer.jsp"/>
	      		<input type="hidden" name="step" id="setp" />
	      			<sql:query var="count" dataSource="${con}">
		  				SELECT count(*) as total,case
              			when count(*)%${pc.maxItems }=0 then (count(*) div ${pc.maxItems })
              			else (count(*) div ${pc.maxItems })+1
               			end as pages  FROM customers;
		   			</sql:query>
	      			<c:forEach var="countRow" items="${count.rows}">
	                        	共&nbsp${countRow.total }&nbsp条记录
	                   	每页    <input type="text"  size="3" value="${pc.maxItems }" name="maxItems" >条&nbsp
	       				<input type="button" value="刷新" onclick="jumpTo(0)">
	                   		第${pc.curPage }页 /共${countRow.pages }页
	      				<input type="hidden" name="pages" id="pages" value="${countRow.pages }"/>
	      				<input type="button" value="第一页"  onclick="jumpStep(1)">
	      				<input type="button" value="上一页"  onclick="jumpStep(-2)">
	      				<input type="button" value="下一页"  onclick="jumpStep(-1)">
	      				<input type="button" value="最后一页"  onclick="jumpStep('${countRow.pages}')">
	                		转到<input type="text" size="3" value="${pc.curPage }" id="jumpPage">页
	      				<input type="button" value="Go" onclick="jumpTo()">          
	      			</c:forEach>       
	      			</form>
		  		</td>
			</tr>
      </c:if>
      
      <c:if test="${list!=null}">
         	<logic:iterate id="cus" name="list">
            	<tr align="center" valign="middle" class="listTrMouseOut" 
		 			onMouseOver="this.className='listTrMouseOver'" 
		 			onMouseOut="this.className='listTrMouseOut'">
		 			<c:set var="index" value="${index+1}"></c:set>
	    			<td >${index }</td>
		 			<td>${cus.cusId }</td>
		 			<td>${cus.cusName }</td>	 			
		 			<td>
		 			<sql:query var="area" dataSource="${con}">
		 		    	select opt_name from sys_dataoptions where opt_value=? and opt_dataid=3;
		 		     <sql:param value="${cus.cusArea}"></sql:param>
		 		   </sql:query>
		 				<c:forEach var="aRow" items="${area.rows}">
		 				${aRow.opt_name }
		 				</c:forEach>
		 			</td>		
		 			<td>
		 			  <sql:query var="manage" dataSource="${con}">
		 			    select staff_name from cusstaff  where staff_id=?;
		 			    <sql:param value=' ${cus.cusManid }'></sql:param>
		 			  </sql:query>
		 			   <c:forEach var="mRow" items="${manage.rows}">
		 			     ${mRow.staff_name }
		 			   </c:forEach>
		 			</td>
		 			<td>
		 			  <sql:query var="level" dataSource="${con}">
		 		    select opt_name from sys_dataoptions where opt_value=? and opt_dataid=1;
		 		     <sql:param value="${cus.cusLevel}"></sql:param>
		 		   </sql:query>
		 				<c:forEach var="lRow" items="${level.rows}">
		 				${lRow.opt_name }
		 				</c:forEach>
		 			</td>
		 			<td>
		 				<a href="cus_manage.jsp?cusId=${cus.cusId }">编辑</a>
		 				<a href="cus_showContacts.jsp?cusId=${cus.cusId }">联系</a>	
		 				<a href="cus_record.jsp?cusId=${cus.cusId }">记录</a>	
		 				<a href="cus_showOrders.jsp?cusId=${cus.cusId }">订单</a>	
		 			</td>
		 		</tr>   
         </logic:iterate> 
         <tr>
		 	<td colspan="7">
         		<bean:size id="sum" name="list"/>
                       共搜索到${sum }条记录
         	</td>
         </tr>     
      </c:if>
	</table>
<!--编辑区-->
</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
<div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
</div>
</body>
</html>
