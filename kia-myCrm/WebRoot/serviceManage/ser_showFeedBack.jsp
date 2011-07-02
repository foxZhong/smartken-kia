<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>服务反馈</title>
</head>
<sql:setDataSource driver="${mysql.driver}" url="${mysql.url}" 
           user="${mysql.user}" password="${mysql.pass}" var="con"/>
           
    <sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'C4' and u_id=?;
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
		<jsp:include page="../parts/left.jsp"  ></jsp:include>
	</div>
	<div id="main">
		<div id="banner"><img src="../images/banner.jpg" border="0"></div>
		<div id="hottest">
			<jsp:include page="../parts/hottest.jsp"></jsp:include>
		</div>
		<!-- 可编辑区 -->
		服务管理->服务反馈
		 <p>
		<html:form action="/serviceManage/services?url=ser_showFeedBack" method="post">
		<input type="submit" value="搜索">&nbsp;<input type="reset" value="清空">
		<input type="hidden" name="oper" value="searchServices">
	 <table width="700"  border="1" cellpadding="3px" cellspacing="3px">
  <tr>
    <td width="64" class="formTitleTd">客户</td>
    <td width="148" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
        <html:text property="customer.cusName"></html:text>
    </td>
    <td width="38" class="formTitleTd">概要</td>
    <td width="207" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
      <html:text property="services.serContext"></html:text>
     </td>
    <td width="72" class="formTitleTd">服务类型</td>
    <td width="51" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
       <sql:query var="types" dataSource="${con}">
          SELECT opt_value, opt_name FROM sys_dataoptions where opt_dataid=2;
       </sql:query>
 
      <html:select property="services.serType">
            <option value="0">全部类型</option>
            <c:forEach var="typeRow" items="${types.rows}">
              <option value="${typeRow.opt_value }">${typeRow.opt_name }</option>
           </c:forEach>
      </html:select>
    </td>
  </tr>
  <tr>
    <td  class="formTitleTd">创建日期</td>
    <td colspan="3" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
    
  </td>
    <td class="formTitleTd">状态</td>
    <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
     <sql:query var="status" dataSource="${con}">
          SELECT opt_value, opt_name FROM sys_dataoptions where opt_dataid=9;
       </sql:query>
 
      <html:select property="services.serStatus">
            <option value="0">全部状态</option>
            <c:forEach var="statusRow" items="${status.rows}">
              <option value="${statusRow.opt_value }">${statusRow.opt_name }</option>
           </c:forEach>
      </html:select>
    </td>
  </tr>
 </table>
 </html:form>
		<p>
	 <table width="700" height="56" border="1">
  <tr class="listTitleTR">
     <td width="50">客户编号</td>
    <td width="100">客户名称</td>
    <td width="135">概要</td>
    <td width="60">服务类型</td>
    <td width="60">创建人</td>
    <td width="80">创建时间</td>
    <td width="57">状态</td>
    <td width="31">操作</td>
  </tr>
  
	<c:if test="${list==null}">	
         <sql:query var="services" dataSource="${con}">
              SELECT ser_id,cus_name,ser_context,
          (select opt_name from sys_dataoptions where opt_dataid=2 and opt_value=ser_type) as sertype ,
           (select u_realname from users where u_id=ser_createrid) as uname,
          ser_pubtime,ser_status,(select opt_name from sys_dataoptions where opt_dataid=9 and opt_value=ser_status) as serstatus
         FROM services,users,customers where cus_id=ser_cusid and u_id=ser_userid limit ?,?;
             <sql:param value='${(pc.curPage-1)*pc.maxItems }'/>
		     <sql:param value='${pc.maxItems}'></sql:param>
         </sql:query>
   <c:set var="index" value="${(pc.curPage-1)*pc.maxItems }" scope="page" ></c:set>
   <c:forEach var="serRow" items="${services.rows}">
     <c:set var="index" value="${index+1}"></c:set>
   
     <tr class="listTrMouseOut" onMouseOver="this.className='listTrMouseOver'" 
		  onMouseOut="this.className='listTrMouseOut'">
     <td>${index }</td>
     <td>${serRow.cus_name}</td>
     <td>${serRow.ser_context }</td>
     <td>
       ${serRow.sertype }
     </td>
     <td>${serRow.uname}</td>
     <td>
    ${serRow.ser_pubtime }
     </td>
      <td>
     ${serRow.serstatus }
     </td>
     <td>
     <c:if test="${serRow.ser_status==3}">
     <a href="ser_doFeedBack.jsp?serID=${serRow.ser_id}">反馈</a>
     </c:if>

     <a href="ser_doFile.jsp?serID=${serRow.ser_id}">查看</a>
    
     </td>
  </tr>
   
  </c:forEach>
    <tr>
		  <td colspan="8">
	       <script type="text/javascript">
	         
	         function jumpStep(v)
	         {
	           
			   document.getElementById("step").value=v;
	           document.forms['jumpForm'].submit();
	         }
	         
	         function jumpTo()
	         {
	            var jp=document.getElementById("jumpPage").value;
	            if(jp>0&&jp<=document.getElementById("pages").value)
	            {document.getElementById("step").value=jp;
	           document.forms['jumpForm'].submit();}
	           else
	            alert("跳转页面超出范围!");
	         }
	      </script>
	      <form id="jumpForm" action="../nextpage" method="post">
	      <input type="hidden" name="url" value="serviceManage/ser_showFeedBack.jsp"/>
	      <input type="hidden" name="step" id="setp" />
	      <sql:query var="count" dataSource="${con}">
		  SELECT count(*) as total,case
              when count(*)%${pc.maxItems }=0 then (count(*) div ${pc.maxItems })
              else (count(*) div ${pc.maxItems })+1
               end as pages  FROM services;
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
  <logic:iterate id="ser" name="list" indexId="i" >
       <html:form action="/serviceManage/services" method="post" >
      <input name="oper" type="hidden" value="doAssignService" >
      <html:hidden property="services.serId" value="${ser.serId}"/>
     <tr class="listTrMouseOut" onMouseOver="this.className='listTrMouseOver'" 
		  onMouseOut="this.className='listTrMouseOut'">
     <td>${i+1 }</td>
     <td>
        <sql:query var="cus" dataSource="${con}">
        SELECT cus_name FROM customers where cus_id=?;
         <sql:param value='${ser.serCusid}'></sql:param>
        </sql:query>
        <c:forEach var="cusRow" items="${cus.rows}">${cusRow.cus_name}</c:forEach>
    </td>
    
     <td>${ser.serContext }</td>
     
     <td>
      <sql:query var="type" dataSource="${con}">
        SELECT opt_name FROM sys_dataoptions where opt_value=? and opt_dataid=2;
         <sql:param value='${ser.serType }'></sql:param>
        </sql:query>
        <c:forEach var="typeRow" items="${type.rows}">${typeRow.opt_name}</c:forEach>
     </td>
     
     <td>
      <sql:query var="creator" dataSource="${con}">
        SELECT u_realname FROM users where u_id=?;
         <sql:param value='${ser.serCreaterid }'></sql:param>
        </sql:query>
        <c:forEach var="creRow" items="${creator.rows}">${creRow.u_realname}</c:forEach>
     </td>
     
     <td>
    <bean:write name="ser" property="serPubtime" format="yyyy-MM-dd"/>
     </td>
     
     
     <td>
     <sql:query var="stauts" dataSource="${con}">
        SELECT opt_name FROM sys_dataoptions where opt_value=? and opt_dataid=9;
         <sql:param value='${ser.serStatus }'></sql:param>
        </sql:query>
        <c:forEach var="stautsRow" items="${stauts.rows}">${stautsRow.opt_name}</c:forEach>
     </td>
     
   
     <td>
       <c:if test="${ser.serStatus==3}">
       <a href="ser_doFeedBack.jsp?serID=${ser.serId}">反馈</a>
       </c:if>
       
         <a href="ser_doFile.jsp?serID=${ser.serId}">查看</a>

     </td>
  </tr>
    </html:form>
    </logic:iterate>
   <bean:size id="total" name="list"/>
    <tr><td colspan="8">共搜索到${total }条结果</td></tr>
  </c:if>
</table>
</table>
		<!-- 可编辑区end -->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
<div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
   </div>
</body>
</html>
