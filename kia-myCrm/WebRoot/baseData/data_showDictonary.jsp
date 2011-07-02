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
<script type="text/javascript" src="../JS/jquery.js"></script>
<script type="text/javascript" src="../JS/listTable_effect.js"></script>
<title>�����ֵ����</title>


</head>
<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>

 <sql:query var="grant" dataSource="jdbc/mycms">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'E1' and u_id=?;
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
		<div id="context" >
		�������� -> �����ֵ����<p>
		<table id="formTable">
	<html:form action="/baseData/data" method="post" >
		<tr>
		<input type="hidden" name="oper" value="addData">
		<td width="60" height="27" class="formTitleTd">�������:</td>
		<td  width="120" height="27" 
		 class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" >
		 <html:text property="datas.dataTitle" size="10" ></html:text></td>
		<td colspan="4" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" ><input type="submit" value="�ύ"></td>
		</tr>
	</html:form>
	<html:form action="/baseData/data" method="post">
	    <input type="hidden" name="oper" value="addOption">
	    <tr>
	      <td class="formTitleTd">������Ŀ:</td>
	      <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" >
		 ���:<html:select property="options.optDataid">
	                <sql:query var="datas" dataSource="${con}">
	                  select * from sys_datas;
	                </sql:query>
	                <c:forEach var="dataRow" items="${datas.rows}">
	                  <option value="${dataRow.data_id}">${dataRow.data_title }</option>
	                </c:forEach>
	              </html:select>
	      <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" >
	      ��Ŀ����:<html:text property="options.optName" size="15"/></td>
	      <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" >
		 ֵ:<html:text property="options.optValue" size="4"/></td>
	      <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" >
	      �ɱ༭<html:select property="options.optIsEdit">
	                 <html:option value="1">��</html:option>
	                  <html:option value="0">��</html:option>
	                 </html:select>
	      </td>
	      <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" >
	      <input type="submit" value="�ύ"></td>
    </tr>
    </html:form>
		</table >
	
		<p>
		<table id="listTable" width="700"  border="1">
		<tr class="listTitleTR" >
		<td width="8%" height="27">���</td>
		<td width="20%" height="27">���</td>
		<td width="20%" height="27">��Ŀ</td>
		<td width="10%" height="27">ֵ</td>	
		<td width="19%" height="27">�Ƿ�ɱ༭</td>
		<td width="19%" height="27">����</td>
		</tr>
<!-- ���û��ʹ��hibernate�������ݣ���ʹ��ҳ��sql��ѯ -->
<c:if test="${requestScope.list==null}">
		<sql:query var="dataDir" dataSource="${con}">
		    SELECT * from view_sys_dataoptions limit ?,?;
		    <sql:param value='${(pc.curPage-1)*pc.maxItems }'/>
		    <sql:param value='${pc.maxItems}'></sql:param>
		</sql:query>
		<c:set var="index" value="${(pc.curPage-1)*pc.maxItems }" scope="page" ></c:set>
		
		<c:forEach var="dr" items="${dataDir.rows}"   >
		
		<html:form action="/baseData/data" method="post" styleId="opt${dr.opt_id}">
		 <input name="oper" type="hidden" id="oper${dr.opt_id}" >
		 <html:hidden property="options.optId" value="${dr.opt_id}"/>
		  <tr class="listTR">
		 <c:set var="index" value="${index+1}"></c:set>
		    <td>${index }</td>
		    <td>${dr.data_title }</td>
		    <td>
		      <c:if test="${dr.opt_isEdit==1}" >
		         <html:text property="options.optName" value="${dr.opt_name }" ></html:text>
		      </c:if>
		      <c:if test="${dr.opt_isEdit==0}" >
		         ${dr.opt_name }
		      </c:if>
		    </td>
		    
		    <td>
		         <c:if test="${dr.opt_isEdit==1}" >
		         <html:text property="options.optValue" value="${dr.opt_value}"></html:text>
		      </c:if>
		      <c:if test="${dr.opt_isEdit==0}" >
		         ${dr.opt_value }
		      </c:if>
		    </td>
		    <td>${dr.isEdit}</td>
		    
		    <td>
		      <c:if test="${dr.opt_isEdit==1}" >
		         <a href="data.do?oper=deleteData&optId=${dr.opt_id}">ɾ��</a>
		         <a href="javascript:doEdit(${dr.opt_id })">�༭</a>  
		      </c:if>
		    </td>
		  </tr>
		</html:form>   
		</c:forEach>
		 <script type="text/javascript">
		   function doEdit(id)
		   { 
		      //alert(id);
		      confirm("ȷʵ��Ҫ�޸������ֵ���");
		      document.getElementById("oper"+id).value="doEditOption";
		      document.getElementById("opt"+id).submit();
		   }
		 </script>
		<tr>
		  <td colspan="6">
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
	      <input type="hidden" name="url" value="baseData/data_showDictonary.jsp"/>
	      <input type="hidden" name="step" id="setp" />
	      <sql:query var="count" dataSource="${con}">
		  SELECT count(*) as total,case
              when count(*)%${pc.maxItems }=0 then (count(*) div ${pc.maxItems })
              else (count(*) div ${pc.maxItems })+1
               end as pages  FROM view_sys_dataoptions;
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
<!-- ҳ��sql��ѯ��� -->
		</table>
		</div>		
		<!-- �ɱ༭��end -->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
  <div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
   </div>
   <html:errors property="info"/>
</body>
</html>
