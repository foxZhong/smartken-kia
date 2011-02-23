<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'menuConfig-success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<jsp:include page="/plugin/index.jsp">
	  <jsp:param value="jquery,easyui" name="plugin"/>
	</jsp:include>
   <jsp:include page="/css/index.jsp"></jsp:include>
   
    <script type="text/javascript" language="javascript">
     
      var gIdmenuEditForm="#menuEditForm";
      function menuEditForm_submit(pStrUrl)
      {
         //alert ($(gIdmenuEditForm).form("validate"));
         $(gIdmenuEditForm)
          .form("submit"
                ,{ url:pStrUrl
                   ,onSubmit:function(){
                                     if($(this).form("validate"))
                                     {return confirm("确认保存菜单修改？");}
                                    }
                  ,success:function(data){
                                      $.messager.alert("操作结果","保存菜单成功");
                                   }
                 }
               );
 
      }
      
      
    </script>
  </head>
 
  <body>
  <div class="innerDiv">
    <form id="menuEditForm" method="post">
	   <table  class="editTable" cellpadding="1" cellspacing="0">
       <tr>
         <td class="tdLabel" style="width:20%">菜单ID</td>
         <td><input name="id" value="${id}"  class="tdInput easyui-validatebox" size="30" readonly="readonly"/></td>
       </tr>
       <tr>
         <td class="tdLabel">菜单名</td>
         <td><input name="name" value="${name}" class="tdInput easyui-validatebox" required="true" size="30"/></td>
       </tr>
              <tr>
         <td class="tdLabel">页面路径</td>
         <td><input name="url" value="${url}" class="tdInput easyui-validatebox" size="30"/></td>
       </tr>
       <tr>
         <td class="tdLabel">请求参数</td>
         <td><input name="parma" value="${parma}" class="tdInput easyui-validatebox" size="30"/></td>
       </tr>
       <tr>
         <td class="tdLabel">父菜单</td>
         <td><input name="parentId" value="${parentId}"  
              textField="name" idField="id" class="easyui-combotree"
              url="sys/Menu/list/ComboTree.action?format=json"  required="true"
               panelWidth="200"  /></td>
       </tr>
       <tr>
         <td class="tdLabel">功能描述</td>
         <td><textarea name="descp"  class="tdInput easyui-validatebox" 
             rows="5" cols="40" >${descp}</textarea>  
         </td>
              
       </tr>
       
         <tr>
	       <td colspan="2">
	          <a class="easyui-linkbutton" iconCls="icon-save" 
	            onclick="menuEditForm_submit('sys/Menu/fn/modify.action')">保存</a>
	          	          <a class="easyui-linkbutton" iconCls="icon-remove" 
	            onclick="menuEditForm_submit('sys/Menu/fn/remove.action')">删除</a>
	          	          <a class="easyui-linkbutton" iconCls="icon-reload" 
	          	onclick="document.location.reload()"
	          	          >重置</a>
	        </td>
	     </tr>
	   </table>
	</form>
   </div>
</body>
