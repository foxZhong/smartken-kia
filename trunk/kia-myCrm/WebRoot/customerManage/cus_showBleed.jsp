<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>客户流失管理</title>
</head>
<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>

 <sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'B2' and u_id=?;
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
		 客户管理 -> 客户流失管理<p>
		 
		  <html:form action="/customerManage/customer?url=cus_showBleed" method="post">
		 <input type="hidden" name="oper" value="doSearchCustomers">
		 <input type="submit" value="查询"/>
		 <html:hidden property="customers.cusArea" value="0"/>
		  <html:hidden property="customers.cusLevel" value="0"/>
		 <table cellpadding="0" cellspacing="0" border="1" align="center" width="700">
		 
		 	<tr height="30">
		 		<td width="100" align="center" class="formTitleTd">客户</td>
		 		<td width="130" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">
					<html:text property="customers.cusName"></html:text>
				</td>
		 		<td width="100" align="center" class="formTitleTd">客户经理</td>
		 		<td width="130" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">
					<html:text property="cusstaff.staffName"></html:text>
				</td>
		 		<td width="100" align="center" class="formTitleTd">状态</td>
		 		<td width="100" class="formTdMouseOut" 
		 			onMouseOver="this.className='formTdMouseOver'" 
					onMouseOut="this.className='formTdMouseOut'">&nbsp;
					<sql:query var="status" dataSource="${con}">
		 		    select opt_value,opt_name from sys_dataoptions where opt_dataid=12;
		 		   </sql:query>
		 			  <html:select property="customers.cusStatus">
		 				<option value="0">全部</option>
		 				<c:forEach var="statusRow" items="${status.rows}">
		 				 <option value="${statusRow.opt_value }">${statusRow.opt_name }</option>
		 				</c:forEach>
		 			  </html:select>
		 		</td>
		 	</tr>
		 </table>
		 </html:form>
		 <p>
		 <table cellpadding="0" cellspacing="0" border="1" align="center" width="700">
			<tr class="listTitleTR" height="25" align="center">
		 		<td width="40">编号</td>
		 		<td width="70">客户</td>
		 		<td width="70">客户经理</td>
		 		<td width="110">上次下单时间</td>
		 		<td width="110">确认下单时间</td>
		 		<td width="70">状态</td>
		 		<td width="112">操作</td>
		 	</tr>
		 	
	<c:if test="${list==null}">
		 	<sql:query var="customers" dataSource="${con}">
		 		select cus_id,cus_name,cus_losedate,cus_status,
				(select opt_name from sys_dataoptions where opt_dataid=12 and opt_value=cus_status )as statusname,
				(select staff_name from cusstaff  where staff_id=cus_manid) as manager
				from customers  limit ?,?;
             <sql:param value='${(pc.curPage-1)*pc.maxItems }'/>
		     <sql:param value='${pc.maxItems}'></sql:param>
		 	</sql:query>
		 	<c:forEach var="cusRow" items="${customers.rows}"  
		 	begin="0" end="10" varStatus="status" >
		 		<tr align="center" valign="middle" class="listTrMouseOut" 
		 			onMouseOver="this.className='listTrMouseOver'" 
		 			onMouseOut="this.className='listTrMouseOut'">
		 			<td>${cusRow.cus_id }</td>
		 			<td>${cusRow.cus_name }</td>
		 			<td>${cusRow.manager}</td>
		 			<td>
		 				<sql:query var="cusorder" dataSource="${con}">
		 				 SELECT order_date FROM cusorder
						 where order_cusid=? and order_state=0 order by order_date desc limit 0,1;
						 <sql:param value='${cusRow.cus_id}'></sql:param> 
		 				</sql:query>
		 				<c:forEach var="corRow" items="${cusorder.rows}">
		 					${corRow.order_date }
		 				</c:forEach>
		 			</td>
		 			<td>
		 				<sql:query var="cusorder" dataSource="${con}">
		 				 SELECT order_date FROM cusorder
						 where order_cusid=? and order_state=1 order by order_date desc limit 0,1;
						 <sql:param value='${cusRow.cus_id}'></sql:param> 
		 				</sql:query>
		 			
		 				<c:forEach var="corRow" items="${cusorder.rows}">
		 					${corRow.order_date }
		 				</c:forEach>
					</td>
		 			<td>${cusRow.statusname }</td>
		 			<td>
		 				<c:if test="${cusRow.cus_status==2 }">
		 					<a href="cus_confirmation_bleed.jsp?cusId=${cusRow.cus_id}">确认流失</a>
		 				</c:if>
		 				<c:if test="${cusRow.cus_status==1 }">
		 					<a href="cus_respite_bleed.jsp?cusId=${cusRow.cus_id}">暂缓流失</a>
		 				</c:if>
		 				<c:if test="${cusRow.cus_status==3}">
		 					<a href="customer.do?oper=doFollowBleed&cusId=${cusRow.cus_id}">重新跟进</a>
		 				</c:if>
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
	      		<input type="hidden" name="url" value="customerManage/cus_showBleed.jsp"/>
	      		<input type="hidden" name="step" id="setp" />
	      			<sql:query var="count" dataSource="${con}">
		  				SELECT count(*) as total,case
              			when count(*)%${pc.maxItems }=0 then (count(*) div ${pc.maxItems })
              			else (count(*) div ${pc.maxItems })+1
               			end as pages  FROM customers ;
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
         <logic:iterate id="cus" name="list" >
            <tr align="center" valign="middle" class="listTrMouseOut" 
		 			onMouseOver="this.className='listTrMouseOver'" 
		 			onMouseOut="this.className='listTrMouseOut'">
	    			<td>${cus.cusId }</td>
		 			<td>${cus.cusName }</td>
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
		 				<sql:query var="cusorder" dataSource="${con}">
		 				 SELECT order_date FROM cusorder
						 where order_cusid=? and order_state=0 order by order_date desc;
						 <sql:param value='${cus.cusId}'></sql:param> 
		 				</sql:query>
		 				<c:forEach var="cRow" items="${cusorder.rows}">
		 					${cRow.order_date }
		 				</c:forEach>
		 			</td>
		 			<td>
		 				<sql:query var="cusorder" dataSource="${con}">
		 				 SELECT order_date FROM cusorder
						 where order_cusid=? and order_state=1 order by order_date desc;
						 <sql:param value='${cus.cusId}'></sql:param> 
		 				</sql:query>
		 				<c:forEach var="cRow" items="${cusorder.rows}">
		 					${cRow.order_date }
		 				</c:forEach>
					</td>
					<sql:query var="statu" dataSource="${con}">
		 		      select opt_name from sys_dataoptions where opt_dataid=12 and opt_value=?;
		 		      <sql:param value='${cus.cusStatus}'></sql:param>
		 		     </sql:query>
		 		     <c:forEach var="sRow" items="${statu.rows}">
		 			<td>
		 			   	${sRow.opt_name}
		 			</td>
		 			<td>	
		 				<c:if test="${sRow.opt_name=='暂缓流失' }">
		 					<a href="cus_confirmation_bleed.jsp?cusId=${cus.cusId}">确认流失</a>
		 				</c:if>
		 				<c:if test="${sRow.opt_name=='跟进中' }">
		 					<a href="cus_respite_bleed.jsp?cusId=${cus.cusId}">暂缓流失</a>
		 				</c:if>
		 				<c:if test="${sRow.opt_name=='确认流失' }">
		 					<a href="customer.do?oper=doFollowBleed&cusId=${cus.cusId}">跟进中</a>
		 				</c:if>
		 			</td>
		 			</c:forEach>
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
<html:errors property="info"/>
</body>
</html>
