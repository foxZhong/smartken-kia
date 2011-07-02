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
<title>数据字典管理</title>


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
		<!-- 可编辑区 -->
		<div id="context" >
		基础数据 -> 数据字典管理<p>
		<table id="formTable">
	<html:form action="/baseData/data" method="post" >
		<tr>
		<input type="hidden" name="oper" value="addData">
		<td width="60" height="27" class="formTitleTd">新增类别:</td>
		<td  width="120" height="27" 
		 class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" >
		 <html:text property="datas.dataTitle" size="10" ></html:text></td>
		<td colspan="4" class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" ><input type="submit" value="提交"></td>
		</tr>
	</html:form>
	<html:form action="/baseData/data" method="post">
	    <input type="hidden" name="oper" value="addOption">
	    <tr>
	      <td class="formTitleTd">新增条目:</td>
	      <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" >
		 类别:<html:select property="options.optDataid">
	                <sql:query var="datas" dataSource="${con}">
	                  select * from sys_datas;
	                </sql:query>
	                <c:forEach var="dataRow" items="${datas.rows}">
	                  <option value="${dataRow.data_id}">${dataRow.data_title }</option>
	                </c:forEach>
	              </html:select>
	      <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" >
	      条目名称:<html:text property="options.optName" size="15"/></td>
	      <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" >
		 值:<html:text property="options.optValue" size="4"/></td>
	      <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" >
	      可编辑<html:select property="options.optIsEdit">
	                 <html:option value="1">是</html:option>
	                  <html:option value="0">否</html:option>
	                 </html:select>
	      </td>
	      <td class="formTdMouseOut" onMouseOver="this.className='formTdMouseOver'" 
		 onMouseOut="this.className='formTdMouseOut'" >
	      <input type="submit" value="提交"></td>
    </tr>
    </html:form>
		</table >
	
		<p>
		<table id="listTable" width="700"  border="1">
		<tr class="listTitleTR" >
		<td width="8%" height="27">编号</td>
		<td width="20%" height="27">类别</td>
		<td width="20%" height="27">条目</td>
		<td width="10%" height="27">值</td>	
		<td width="19%" height="27">是否可编辑</td>
		<td width="19%" height="27">操作</td>
		</tr>
<!-- 如果没有使用hibernate请求数据，就使用页面sql查询 -->
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
		         <a href="data.do?oper=deleteData&optId=${dr.opt_id}">删除</a>
		         <a href="javascript:doEdit(${dr.opt_id })">编辑</a>  
		      </c:if>
		    </td>
		  </tr>
		</html:form>   
		</c:forEach>
		 <script type="text/javascript">
		   function doEdit(id)
		   { 
		      //alert(id);
		      confirm("确实需要修改数据字典吗？");
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
	            alert("跳转页面超出范围!");
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
<!-- 页面sql查询完毕 -->
		</table>
		</div>		
		<!-- 可编辑区end -->
	</div>
	<jsp:include page="../parts/letter.jsp"></jsp:include>
</div>
  <div id="footer">
 <jsp:include page="../parts/footer.jsp"></jsp:include>
   </div>
   <html:errors property="info"/>
</body>
</html>
