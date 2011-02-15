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
	<jsp:include page="/plugin/index.jsp?plugin=jquery,easyui"></jsp:include>
   <jsp:include page="/css/index.jsp"></jsp:include>
   <jsp:include page="/js/index.jsp"></jsp:include>
   <script type="text/javascript">
   
	var gIdMenuAddForm="#menuAddForm";
	
	function menuAddForm_submit(pStrUrl){
		
	   $(gIdMenuAddForm).form("submit",
	                           { url:pStrUrl
	                             ,success:function(data){
	                                  $.messager.confirm("操作成功","再添加一个菜单吗?",function(yes){if(yes)menuAddForm_clear();});          
	                                     }
	                             ,onSubmit:function(){
	                                      if(!$(this).form("validate"))return false;
	                                      //alert($(this).form("validate"));
	                                      return confirm("确认提交修改?");
	                                      }
	                           }
	   );
	}
	
	function menuAddForm_clear(){
	    $(gIdMenuAddForm).form("clear");
	}
	   
 	   
	   

	      
	</script>
  </head>
 
  <body>
  <div class="innerDiv">
    <form id="menuAddForm" method="post">
	   <table  class="editTable" cellpadding="1" cellspacing="0">
       <tr>
         <td class="tdLabel" style="width:20%">菜单ID</td>
         <td><input name="id"   class="tdInput easyui-validatebox" required="true" size="30" /></td>
       </tr>
       <tr>
         <td class="tdLabel">菜单名</td>
         <td><input name="name" class="tdInput easyui-validatebox" required="true" size="30"/></td>
       </tr>
              <tr>
         <td class="tdLabel">页面路径</td>
         <td><input name="url"  class="tdInput easyui-validatebox" size="30"/></td>
       </tr>
       <tr>
         <td class="tdLabel">请求参数</td>
         <td><input name="parma"  class="tdInput easyui-validatebox" size="30"/></td>
       </tr>
       <tr>
         <td class="tdLabel">父菜单</td>
         <td><input name="parentId" value="root"  
              textField="name" idField="id" class="easyui-combotree"
              url="sys/menu/listComboTree.action?format=json"  required="true"
               panelWidth="200"  /></td>
       </tr>
       <tr>
         <td class="tdLabel">功能描述</td>
         <td><textarea name="descp"  class="tdInput easyui-validatebox" 
             rows="5" cols="40" ></textarea>  
         </td>
              
       </tr>
       
         <tr>
	       <td colspan="2">
	          <a class="easyui-linkbutton" iconCls="icon-save" 
	            onclick="menuAddForm_submit('sys/menu/save.action')">保存</a>
	          	          <a class="easyui-linkbutton" iconCls="icon-remove" 
	            onclick="menuAddForm_submit('sys/menu/remove.action')">删除</a>
	          	          <a class="easyui-linkbutton" iconCls="icon-reload" 
	          	onclick="menuAddForm_clear()"
	          	          >清空</a>
	        </td>
	     </tr>
	   </table>
	</form>
	
   </div>
</body>
