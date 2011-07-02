<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>���ۻ������</title>
</head>


<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>
 <sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'A1' and u_id=?;
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
		<!-- �ɱ༭�� -->
		Ӫ������ ->Ӫ���������  
		<p>
		<html:form action="/sellManage/sell?url=sell_showChance" method="post">
		<input type="hidden" name="oper" value="searchChance" >
		<input type="submit" value="����" >&nbsp;<input type="reset" value="���"> 
		<table width="700"  border="1">
		<tr>
		<td class="formTitleTd">�ͻ�����</td>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		 <html:text property="chance.chaClientName"></html:text>
		</td>
		<td class="formTitleTd">��Ҫ</td>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		 <html:text property="chance.chaSummary"></html:text>
		</td>
		<td class="formTitleTd">��ϵ��</td>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'">
		  <html:text property="chance.chaContext"></html:text>
		</td>
		</tr>
		</table >
		</html:form>
		<p>
		<a href="sell_doCreateChance.jsp">�½�Ӫ������</a>
		<table width="700"  border="1">
		<tr class="listTitleTR">
		<td>���</td>
		<td>�ͻ�����</td>
		<td>��Ҫ</td>
		<td>��ϵ��</td>
		<td>��ϵ�˵绰</td>
		<td>����ʱ��</td>
		<td >״̬</td>
		<td>����</td>
		</tr>
		
		<c:if test="${list==null}">
		<sql:query var="sellChance" dataSource="${con}">
		SELECT *,
		(select opt_name from sys_dataoptions where opt_dataid=11 and opt_value=cha_staut) as stautsname
		 FROM sellchance limit ?,?;
		    <sql:param value='${(pc.curPage-1)*pc.maxItems }'/>
		    <sql:param value='${pc.maxItems}'></sql:param>
		</sql:query>
		<c:set var="index" value="${(pc.curPage-1)*pc.maxItems }" scope="page" ></c:set>
		<c:forEach var="chanceRow" items="${sellChance.rows}">
		 <c:set var="index" value="${index+1}"></c:set>
		<tr valign="middle" class="listTrMouseOut" 
		onMouseOver="this.className='listTrMouseOver'" 
		onMouseOut="this.className='listTrMouseOut'">
			<td>${index }</td>
			<td>${chanceRow.cha_clientName }</td>
			<td>${chanceRow.cha_summary }</td>
			<td>${chanceRow.cha_context }</td>
			<td>${chanceRow.cha_contextPhone }</td>
			<td>
			<bean:write name="chanceRow" property="cha_createtime" format="yyyy-MM-dd"/>
			
			</td>
			<td>${chanceRow.stautsname }</td>
			<td>
			   <c:if test="${chanceRow.cha_staut<3}">
				<a href="sell_doOrderChance.jsp?chaID=${chanceRow.cha_id}">ָ��</a>
				<a href="sell_doEditChance.jsp?chaID=${chanceRow.cha_id}">�༭</a>
			   </c:if>
			   <c:if test="${chanceRow.cha_staut>=3}">
			    <a href="sell_doShowPlan.jsp?chaID=${chanceRow.cha_id}" >�鿴</a>
			   </c:if>
			   <a href="sell.do?chaID=${chanceRow.cha_id}&oper=doDeleteChance">ɾ��</a>
			   
				
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
	            alert("��תҳ�泬����Χ!");
	         }
	      </script>
	      <form id="jumpForm" action="../nextpage" method="post">
	      <input type="hidden" name="url" value="sellManage/sell_showChance.jsp"/>
	      <input type="hidden" name="step" id="setp" />
	      <sql:query var="count" dataSource="${con}">
		  SELECT count(*) as total,case
              when count(*)%${pc.maxItems }=0 then (count(*) div ${pc.maxItems })
              else (count(*) div ${pc.maxItems })+1
               end as pages  FROM sellchance;
		   </sql:query>
	      <c:forEach var="countRow" items="${count.rows}">
	                        ��&nbsp${countRow.total }&nbsp����¼
	                   ÿҳ    <input type="text"  size="3" value="${pc.maxItems }" name="maxItems" >��&nbsp
	       <input type="button" value="ˢ��" onclick="jumpTo(0)">
	                   ��${pc.curPage }ҳ /��${countRow.pages }ҳ
	       <input type="hidden" name="pages" id="pages" value="${countRow.pages }"/>
	      <input type="button" value="��һҳ"  onclick="jumpStep(1)">
	      <input type="button" value="��һҳ"  onclick="jumpStep(-2)">
	      <input type="button" value="��һҳ"  onclick="jumpStep(-1)">
	      <input type="button" value="���һҳ"  onclick="jumpStep('${countRow.pages}')">
	                ת��<input type="text" size="3" value="${pc.curPage }" id="jumpPage">ҳ
	      <input type="button" value="Go" onclick="jumpTo()">          
	      </c:forEach>       
	      </form>
	
		  </td>
		</tr>
	</c:if>
	
	<c:if test="${list!=null}">
	 <c:set var="index" value="${(pc.curPage-1)*pc.maxItems }" scope="page" ></c:set>
	 <logic:iterate id="cha" name="list" >
	 <tr class="listTrMouseOut" 
		onMouseOver="this.className='listTrMouseOver'" 
		onMouseOut="this.className='listTrMouseOut'">
	    <c:set var="index" value="${index+1}"></c:set>
	    <td>${index }</td>
			<td>${cha.chaClientName }</td>
			<td>${cha.chaSummary }</td>
			<td>${cha.chaContext }</td>
			<td>${cha.chaContextPhone }</td>
			<td>
		
			<bean:write name="cha" property="chaCreatetime" format="yyyy-MM-dd"/>
			</td>
			<td>
			
			 <sql:query var="staut" dataSource="${con}">
			    select opt_name from sys_dataoptions where opt_dataid=11 and opt_value=?;
			   <sql:param value="${cha.chaStaut}"></sql:param>
			 </sql:query>
			 <c:forEach var="sRow" items="${staut.rows}">
			    ${sRow.opt_name }
			 </c:forEach>
			
			</td>
			<td>
			 <c:if test="${cha.chaStaut<3}">
			<a href="sell_doOrderChance.jsp?chaID=${cha.chaId}">ָ��</a>
				<a href="sell_doEditChance.jsp?chaID=${cha.chaId}">�༭</a>
			</c:if>
			 <c:if test="${cha.chaStaut>=3}">
			    <a href="sell_doShowPlan.jsp?chaID=${cha.chaId}" >�鿴</a>
			 </c:if>
				<a href="sell.do?chaID=${cha.chaId}&oper=doDeleteChance">ɾ��</a>
			</td>
	</tr>
	 </logic:iterate>
	   <bean:size name="list" id="total"/>
	 <tr><td colspan="8">��������${total }�����</td></tr>
	</c:if>
		</table>		
		<!-- �ɱ༭��end -->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
<div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
   </div>

<html:errors property="info" />
</body>
</html>
