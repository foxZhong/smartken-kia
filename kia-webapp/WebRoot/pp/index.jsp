<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.JsContextModel"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
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
     
    <style type="text/css">
   #f1{
     width: 90%;
     height: 100%;
   }
   
   #f1-1{
     width:70%;
     height:100%;
     float: left;
   }
   
    #f1-2{
     width:25%;
     height:100%;
     float: left;
     margin-left: 2%;
   }
   
    
    </style>
    

    
  </head>
  
  <body>
      <div id="fl" >
         <div id="f1-1" class="easyui-layout">
            <div region="center" title="系统导航" style="overflow: hidden;">
                <div  class="b" style="width: 99%;height: 15%;margin:0.5% auto auto 0.5%">
                  menuDiv
                </div>
                <div id="menuDiv" class="b" style="width: 99%;height: 83%;margin:0.5% auto auto 0.5%">
                   <div id="menuDiv-left" class="b" style="width: 40%;height: 100%;float: left;">
                   </div>
                   <div id="menuDiv-right" class="b" style="width: 59%;height: 100%;float: right;">
                   </div>
                </div>
		    </div>
         </div>
         <div id="f1-2" class="b"  style="margin-left: 2%;">

         </div>  
      </div>
  </body>
</html>
