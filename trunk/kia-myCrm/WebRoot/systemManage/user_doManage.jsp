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
<title>�û���Ϣ����</title>


</head>
<sql:setDataSource driver="${mysql.driver}"
      url="${mysql.url}" 
       user="${mysql.user}" password="${mysql.pass}" var="con"/>

 <sql:query var="grant" dataSource="${con}">
	            SELECT count(f_id) as fcount
                 FROM users,sys_function
                   where u_grant regexp 'F2' and u_id=?;
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
		���ù��� -> �û�����<p>
		
		<html:form action="/systemManage/user" method="post">
		<input type="submit" value="�������û�">
		<table width="700"  border="1">

	    <input type="hidden" name="oper" value="doAddUser">
	    <tr>
	      <td class="formTitleTd">�û���:</td>
	      <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" >
		    <html:text property="users.UName" ></html:text>
		   </td>
		   <td class="formTitleTd">    ����:</td>       
	      
	      <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" >
		  <html:text property="users.UPass" ></html:text>
		 </td>
		 
		 </tr>
		 <tr>
		   <td class="formTitleTd">  ��ʵ����</td> 
	      <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" >
		     <html:text property="users.URealname" ></html:text>
		 </td>
	      
	       <td class="formTitleTd"> ��ɫ</td> 
	      <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" >
		     <sql:query var="roles" dataSource="${con}">
		           select opt_value,opt_name from sys_dataoptions where opt_dataid=8;
		          </sql:query>
		          <html:select property="users.URoleid">
		          <c:forEach var="roleRow" items="${roles.rows}">
		          
		               <option value="${roleRow.opt_value}">${roleRow.opt_name }</option>
		             
		          </c:forEach>
		             </html:select>
		 </td>
	     
        </tr>
  
		</table >
	  </html:form>
		<p>
		<table width="700"  border="1">
		<tr class="listTitleTR" >
		<td width="8%" height="27">���</td>
		<td width="20%" height="27">�û���</td>
		<td width="20%" height="27">����</td>
		<td width="10%" height="27">��ʵ����</td>	
		<td width="19%" height="27">ְλ</td>
		<td width="19%" height="27">����</td>
		</tr>
<!-- ���û��ʹ��hibernate�������ݣ���ʹ��ҳ��sql��ѯ -->
<c:if test="${requestScope.list==null}">
		<sql:query var="users" dataSource="${con}">
		    SELECT u_id,u_name,u_pass,u_realname,u_roleid,
         (select opt_name from sys_dataoptions where  opt_value=u_roleid and opt_dataid=8) as rolename
            FROM users u limit ?,?;
		    <sql:param value='${(pc.curPage-1)*pc.maxItems }'/>
		    <sql:param value='${pc.maxItems}'></sql:param>
		</sql:query>
		<c:set var="index" value="${(pc.curPage-1)*pc.maxItems }" scope="page" ></c:set>
		
		<c:forEach var="uRow" items="${users.rows}"   >
		
		<html:form action="/systemManage/user" method="post" styleId="userForm${uRow.u_id}">
		 <input name="oper" type="hidden" id="oper${uRow.u_id}" >
		 <html:hidden property="users.UId" value="${uRow.u_id}"/>
		  <tr class="listTrMouseOut" onMouseOver="this.className='listTrMouseOver'" 
		  onMouseOut="this.className='listTrMouseOut'">
		 <c:set var="index" value="${index+1}"></c:set>
		    <td>${index }</td>
		    <td>
		     <html:text property="users.UName" value="${uRow.u_name }"></html:text>
		   </td>
		    <td>
		         <html:text property="users.UPass" value="${uRow.u_pass}"></html:text>
		        
		     
		    </td>
		    
		    <td>
		         <html:text property="users.URealname" value="${uRow.u_realname }" ></html:text>
		    
		    </td>
		    <td>
		          <sql:query var="roles" dataSource="${con}">
		           select opt_value,opt_name from sys_dataoptions where opt_dataid=8;
		          </sql:query>
		          <html:select property="users.URoleid">
		          <c:forEach var="roleRow" items="${roles.rows}">
		             <c:if test="${roleRow.opt_value==uRow.u_roleid}">
		               <option value="${roleRow.opt_value}" selected="selected">${roleRow.opt_name}</option>
		             </c:if>
		             <c:if test="${roleRow.opt_value!=uRow.u_roleid}">
		               <option value="${roleRow.opt_value}">${roleRow.opt_name }</option>
		             </c:if>
		          </c:forEach>
		             </html:select>
		    </td>
		    
		    <td>
		      
		         <a href="user.do?oper=doDeleteUser&uId=${uRow.u_id}">ɾ��</a>
		         <a href="javascript:doEdit(${uRow.u_id })">�༭</a>
		         <a href="grant_userManage.jsp?uId=${uRow.u_id }">Ȩ��</a>  
		    </td>
		  </tr>
		</html:form>   
		</c:forEach>
		 <script type="text/javascript">
		   function doEdit(id)
		   { 
		      //alert(id);
		      confirm("ȷʵ��Ҫ�޸��û�������");
		      document.getElementById("oper"+id).value="doUpdateUser";
		      document.getElementById("userForm"+id).submit();
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
	      <input type="hidden" name="url" value="systemManage/user_doManage.jsp"/>
	      <input type="hidden" name="step" id="setp" />
	      <sql:query var="count" dataSource="${con}">
		  SELECT count(*) as total,case
              when count(*)%${pc.maxItems }=0 then (count(*) div ${pc.maxItems })
              else (count(*) div ${pc.maxItems })+1
               end as pages  FROM users;
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
