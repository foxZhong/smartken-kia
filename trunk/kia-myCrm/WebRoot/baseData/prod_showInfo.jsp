<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/18.css" rel="stylesheet" type="text/css">
<title>��ѯ��Ʒ��Ϣ</title>
</head>
<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>
       
        <sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'E2' and u_id=?;
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
		�������� ->��ѯ��Ʒ��Ϣ<p>
		<html:form action="/baseData/produce" method="post">
		<input type="hidden" name="oper" value="doSearchProd">
		<input type="submit" value="����">&nbsp;<input type="reset" value="���">
		<table width="700"  border="1">
		<tr>
		<td class="formTitleTd">����</td>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'"><html:text property="produce.prodName" /></td>
		<td class="formTitleTd">�ͺ�</td>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'"><html:text property="produce.prodType" /></td>
		<td class="formTitleTd">����</td>
		<td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'"><html:text property="produce.prodLevel" /></td>		
		</tr>
		</table >
		</html:form>
		
		<p>
		<table width="700"  border="1">
		<tr class="listTitleTR">
		<td width="7%" height="27">���</td>
		<td width="21%" height="27">����</td>
		<td width="14%" height="27">�ͺ�</td>
		<td width="14%" height="27">�ȼ�/����</td>	
		<td width="14%" height="27">��λ</td>
		<td width="14%" height="27">���ۣ�Ԫ��</td>
		<td width="14%" height="27">��ע</td>		
		</tr >
<c:if test="${requestScope.list==null}">
		<sql:query var="pordInfo" dataSource="${con}">
		SELECT * FROM produces limit ?,?;
		    <sql:param value='${(pc.curPage-1)*pc.maxItems }'/>
		    <sql:param value='${pc.maxItems}'></sql:param>
		</sql:query>
		<c:set var="index" value="${(pc.curPage-1)*pc.maxItems }" scope="page" ></c:set>
		<c:forEach var="infoRow" items="${pordInfo.rows}" varStatus="status">
		<tr class="listTrMouseOut" onMouseOver="this.className='listTrMouseOver'" 
		  onMouseOut="this.className='listTrMouseOut'">
		<c:set var="index" value="${index+1}"></c:set>		
		<td  >${index }</td>
		<td >${infoRow.prod_name }</td>
		<td>${infoRow.prod_type }</td>
		<td>${infoRow.prod_level }</td>	
		<td>${infoRow.prod_unit }</td>
		<td>${infoRow.prod_price }</td>
		<td>${infoRow.prod_info }</td>		
		</tr>
		</c:forEach>

		<tr>
		  <td colspan="7">
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
	      <input type="hidden" name="url" value="baseData/prod_showInfo.jsp"/>
	      <input type="hidden" name="step" id="setp" />
	      <sql:query var="count" dataSource="${con}">
		  SELECT count(*) as total,case
              when count(*)%${pc.maxItems }=0 then (count(*) div ${pc.maxItems })
              else (count(*) div ${pc.maxItems })+1
               end as pages  FROM produces;
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
  <c:forEach var="prod" items="${list}" varStatus="i">
    <tr class="listTrMouseOut" onMouseOver="this.className='listTrMouseOver'" 
		  onMouseOut="this.className='listTrMouseOut'">
     <td  >${i.index+1 }</td>
		<td >${prod.prodName }</td>
		<td>${prod.prodType }</td>
		<td>${prod.prodLevel }</td>	
		<td>${prod.prodUnit }</td>
		<td>${prod.prodPrice }</td>
		<td>${prod.prodInfo }</td>
	 </tr>		
  </c:forEach>
  <bean:size id="total" name="list"/>
  <tr><td colspan="7">��������${total }�����</td></tr>
</c:if>
		</table>		
		<!-- �ɱ༭��end -->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
<div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
   </div>
</body>
</html>
