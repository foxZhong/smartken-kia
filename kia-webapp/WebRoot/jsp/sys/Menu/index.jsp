<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'menuConfig-success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<jsp:include page="/plugin/index.jsp?plugin=jquery,easyui"></jsp:include>
   <jsp:include page="/css/index.jsp"></jsp:include>
   <jsp:include page="/js/index.jsp"></jsp:include>
   	<script>
	  $(document).ready(function(){
	       var innerHeight=$("#menuDiv").outerHeight(false);
	       var innerWidth=$("#menuDiv").width();
	       var menuDG="menuDG";
	       var menuEditDlg="menuEditDlg";
	       var menuAddDlg="menuAddDlg";
	       
	        $("#"+menuDG).datagrid({
				url: 'sys/Menu/list/DataGrid.action?format=json',
				title: '菜单管理列表',
				fitColumns: true,
				singleSelect:false,
				height:innerHeight,
				width:innerWidth,
				pagination:true,
				rownumbers:true,
				idField:"id",
				columns:[[
				    {field:'id',title:'菜单ID',checkbox:true},
				    {field:'name',title:'菜单',width:10},
					//{field:"parentId",title:'父菜单',width:10},
					{field:'url',title:'页面路径',width:30},
					{field:'parma',title:'请求参数',width:30},
					{field:'descp',title:'功能描述',width:30}
					
				]], //columns
				toolbar:[{
					text:'新增菜单',
					iconCls:'icon-add',
					handler:function(){
					          
					 	     $("#"+menuAddDlg).dialog({
					           title:'新增菜单',
					           width:500,
					           height:400,
					           modal:true,
					           onBeforeOpen:function(){
					            $(this).html(fnHtmlInnerFrame("sys/Menu/to/add.action"));
					           },
					           onClose:function(){
					             
					             $("#"+menuDG).datagrid("reload");
					             $(this).html("");
					           }// onClose(function(){
				             });  //$('#editWindow').dialog({
				            
					}  //handler:function(){
				},'-',{
					text:'delete',
					iconCls:'icon-remove',
					handler:function(){
					        var lStrIds="";
					        var lStrName="";
						    var rows = $("#"+menuDG).datagrid('getSelections');
						    $.each(rows,function(index,item){
						       lStrIds+=","+item.id;
						       lStrName+=" "+item.name;
						    });  //rows.each(function(index,item){
						    $.messager.confirm("删除菜单",lStrName,function(ok){
						                      if(ok){
						                         $.get("sys/Menu/fn/remove.action"
						                         ,{menuids:lStrIds}
						                         ,function(data){
						                         $.messager.alert("操作成功",data);
						                         $(menuDG).datagrid('reload');}
						                         );  
						                      } //if(ok){
						                     });    // $.messager.confirm("操作提示","是否删除以下菜单?"+lStrName,function(ok){

                                
                            } //handler:function(){
					}
			
				],//toolbar
				onDblClickRow:function(index,data){			  

				   $("#"+menuEditDlg).dialog({
					  title:'修改菜单-'+data.name,
					  width:500,
					  height:400,
					  modal:true,
				      onClose:function(){
				        $(this).html("");
					    $("#"+menuDG).datagrid("reload");
					  }// onClose(function(){
					  ,onBeforeOpen:function(){
					      $(this).html(fnHtmlInnerFrame("sys/Menu/to/edit.action?menuid="+data.id));
					  }
				   });  //$('#editWindow').dialog({
				   
				}  //onDblClickRow:function(index,data){
          
			});  //$('#menuDG').datagrid({
			
			//var p = $('#'+menuDG).datagrid('getPager');
			//if (p){
			//	$(p).pagination({		
			//		onSelectPage:function(no,size){
			//		    alert(no+":"+size);
			//		    $('#'+menuDG).datagrid({
			//		        queryParams:{pageNo:no,pageSize:size}
			//		    });
			//		}
			//	});
			//}
			
	  });  //ready

	
		
		

	</script>
  </head>
  
  <body> 

	<div class="innerDiv" id="menuDiv">
	<table id="menuDG"></table>
	  <div id="menuEditDlg"></div>
      <div id="menuAddDlg"></div>
    </div>
  </body>
</html>
