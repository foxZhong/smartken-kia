<%@ page language="java" import="java.util.*,com.smartken.kia.core.model.impl.EasyUiModel" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.JQueryModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsFunctionModel"%>
<%@page import="com.smartken.kia.core.util.StringUtil"%>
<%@page import="com.smartken.kia.core.model.impl.JsMapModel"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiMessager"%>
<%@page import="com.smartken.kia.core.model.impl.JsContextModel"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    
    <script type="text/javascript">
    
    
    <%= JQueryModel.DOC_READY_START %>
        <%  
           String divAddLimit="divAddLimit"; 
           String divEditLimit="divEditLimit";      
           String aEditLimit="aEditLimit";
           String aRemoveLimit="aRemoveLimit";
           String aAddLimit="aAddLimit";
           String aRemoveAllLimit="aRemoveAllLimit";
           String txtSearchDate="txtSearchDate";
           String aBack="aBack";
           String aSaveWeek="aSaveWeek";

           EasyUiModel searchDateBox=new EasyUiModel(StringUtil.quota("#"+txtSearchDate),EasyUiModel.DateBox.NAME);
           searchDateBox.appendAttrs(EasyUiModel.DateBox.Properties.FORMATTER,"function(date){return date.getFullYear()+\"-\"+(date.getMonth()+1)+\"-\"+date.getDate();}");
           
           JsFunctionModel handlerAddLimitClick=new JsFunctionModel(null);
           handlerAddLimitClick
           .appendContext("")
           ;
           
           JQueryModel btnAddLimit=new JQueryModel(StringUtil.quota("."+aAddLimit),JQueryModel.Events.CLICK);
           btnAddLimit.appendParma(handlerAddLimitClick);
           
          
           JQueryModel btnEditLimit=new JQueryModel(StringUtil.quota("."+aEditLimit),JQueryModel.Events.CLICK);
           btnEditLimit.appendParma(
               new JsFunctionModel(null)
               .appendContext("var limitId=$(this).attr('id');")
               .appendContext("var key=limitId.split(',')[0];")
               .appendContext("var keys=key.split('_');")   
               //.appendContext("var total=limitId.split(',')[1];")
               .appendContext("var ldate=limitId.split(',')[1];")
               .appendContext(
                 new EasyUiModel(StringUtil.quota("#"+divEditLimit),EasyUiModel.Dialog.NAME)
                   .appendAttrs(EasyUiModel.Dialog.Properties.WIDTH,400)
                   .appendAttrs(EasyUiModel.Dialog.Properties.HEIGHT,300)
                   .appendAttrs(EasyUiModel.Dialog.Properties.MODAL,true)
                   .appendAttrs(EasyUiModel.Dialog.Properties.TITLE,"\"修改分配项目-\"+ldate")
                   .appendAttrs(EasyUiModel.Dialog.Events.ON_BEFORE_OPEN,
                                 new JsFunctionModel(null).appendContext(
                                   new JQueryModel("this",JQueryModel.Properties.HTML).appendParma(JsFunctionModel.iframe(basePath+"booked/WeekPb/to/editLimit.action?limitKey=\"+key+\""),true)
                                ))
                   .appendAttrs(EasyUiModel.Dialog.Events.ON_CLOSE,new JsFunctionModel(null).appendContext("location.href='"+basePath+"booked/WeekPb/reload/assign.action';"))
               )
           );
           
           JQueryModel btnRemoveLimit=new JQueryModel(StringUtil.quota("."+aRemoveLimit),JQueryModel.Events.CLICK);
           btnRemoveLimit.appendParma(
                   new JsFunctionModel(null)
                   .appendContext("var limitId=$(this).attr('id');")
                   .appendContext(
                       new JQueryModel(JQueryModel.Ajax.GET)
                       .appendParma(basePath+"booked/WeekPb/do/removeLimit.action",true)
                       .appendParma("{limitKey:limitId}")
                       .appendParma(new JsFunctionModel(new String[]{"data"})
                                      .appendContext("location.href='"+basePath+"booked/WeekPb/reload/assign.action';")
                       )
                   )
           );
           
           EasyUiModel btnBack=new EasyUiModel(StringUtil.quota("#"+aBack),EasyUiModel.LinkButton.NAME );
           btnBack.appendAttrs(EasyUiModel.LinkButton.Properties.ICON_CLS,EasyUiModel.ICON_BACK,true);
 
           EasyUiModel btnSaveWeek=new EasyUiModel(StringUtil.quota("#"+aSaveWeek),EasyUiModel.LinkButton.NAME );
           btnSaveWeek.appendAttrs(EasyUiModel.LinkButton.Properties.ICON_CLS,EasyUiModel.ICON_SAVE,true);
        
 
           JsContextModel context=new JsContextModel();
           context.appendScript(searchDateBox)
           .appendScript(btnBack)
           .appendScript(btnSaveWeek)
           .appendScript(btnEditLimit)
           .appendScript(btnRemoveLimit)
           ; 
        %>      
       
      <%= context.toScirpt() %>
   
      
    <%= JQueryModel.DOC_READY_END %>
    
    </script>
    
  </head>
  
  <body>
  	<div class="innerDiv" id="innerDiv">
  	<form action="booked/WeekPb/to/assign.action" method="post">
	  	<table  class="editTable" cellpadding="1" cellspacing="0">
	  	  <tr>
	  	    <td><s:property value="%{getText('booked.searchDate')}" /> </td>
	  	    <td><input id="<%=txtSearchDate %>" name="searchDate" />
	  	    <button type="submit"><div class="kia-icon search"></div>查询</button>
	  	    </td>
	  	  </tr>
	  	</table>
  	</form>
  	
     ${CWeekRange}:${IWeekNum}
  	  
  	   <table  class="editTable" cellpadding="1" cellspacing="0">
  	     <thead>
  	        <tr>
  	          <td  style="width:15%" >星期</td>
  	          <td >科目</td>
  	          <td >总数</td>
  	          <td colspan="2">分配明细</td>
  	        </tr>
  	        

  	     </thead>
  	     <tbody>
  	        <tr>
  	           <td rowspan="3">星期一 <br/>(<s:date name="monday" format="yyyy-MM-dd"/>)</td>
  	           <td>科目一</td>
               <td>${IWeek1Km1Num}</td>
               <td>${IWeek1Km1Fp}</td>
               <td>
                 <table style="table-layout: fixed;">
                   <tr>
                     <td colspan="100">
                       <a class="kia-icon add <%=aAddLimit %>" title="新增菜单" id="1,1,<s:property value="value.dateKsrq" />" ></a>
                       <a class="kia-icon remove <%=aAddLimit %>" title="清空"></a>
                     </td>
                   </tr>
                   <s:iterator value="limits" >
                   <s:if test="value.dayofweek eq 1 && value.km eq 1">
                   <tr>
                     <td><s:property value="value.ksdd" /></td>
                     <td><s:property value="value.kscc" /></td>
                     <td><s:property value="value.schoolName" /></td>
                     <td><s:property value="value.total" /></td>
                     <td>
                        <a class="kia-icon edit <%=aEditLimit %>" name="<s:property value="key" />" id="<s:property value="key" />,<s:property value="value.dateKsrq" />" ></a>
                         <a class="kia-icon remove <%=aRemoveLimit %>" id="<s:property value="key" />" ></a>
                     </td>
                   </tr>
                   </s:if>
                   </s:iterator>
                 </table>
               </td>
  	        </tr> 
  	        <tr>
               <td>科目二</td>
               <td>${IWeek1Km2Num}</td>
               <td>${IWeek1Km2Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        <tr>
  	            <td>科目三</td>
               <td>${IWeek1Km3Num}</td>
               <td>${IWeek1Km3Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        
  	        
  	        <tr>
  	           <td rowspan="3">星期二</td>
  	           <td>科目一</td>
               <td>${IWeek2Km1Num}</td>
               <td>${IWeek2Km1Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        <tr>
               <td>科目二</td>
               <td>${IWeek2Km2Num}</td>
               <td>${IWeek2Km2Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        <tr>
  	            <td>科目三</td>
               <td>${IWeek2Km3Num}</td>
               <td>${IWeek2Km3Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        
  	        <tr>
  	           <td rowspan="3">星期三</td>
  	           <td>科目一</td>
               <td>${IWeek3Km1Num}</td>
               <td>${IWeek3Km1Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        <tr>
               <td>科目二</td>
               <td>${IWeek3Km2Num}</td>
               <td>${IWeek3Km2Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        <tr>
  	            <td>科目三</td>
               <td>${IWeek3Km3Num}</td>
               <td>${IWeek3Km3Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        
  	          	        <tr>
  	           <td rowspan="3">星期四</td>
  	           <td>科目一</td>
               <td>${IWeek4Km1Num}</td>
               <td>${IWeek4Km1Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        <tr>
               <td>科目二</td>
               <td>${IWeek4Km2Num}</td>
               <td>${IWeek4Km2Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        <tr>
  	            <td>科目三</td>
               <td>${IWeek4Km3Num}</td>
               <td>${IWeek4Km3Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        
  	        <tr>
  	           <td rowspan="3">星期四</td>
  	           <td>科目一</td>
               <td>${IWeek4Km1Num}</td>
               <td>${IWeek4Km1Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        <tr>
               <td>科目二</td>
               <td>${IWeek4Km2Num}</td>
               <td>${IWeek4Km2Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        <tr>
  	            <td>科目三</td>
               <td>${IWeek4Km3Num}</td>
               <td>${IWeek4Km3Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        
  	        <tr>
  	           <td rowspan="3">星期五</td>
  	           <td>科目一</td>
               <td>${IWeek5Km1Num}</td>
               <td>${IWeek5Km1Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        <tr>
               <td>科目二</td>
               <td>${IWeek5Km2Num}</td>
               <td>${IWeek5Km2Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        <tr>
  	            <td>科目三</td>
               <td>${IWeek5Km3Num}</td>
               <td>${IWeek5Km3Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        
  	        <tr>
  	           <td rowspan="3">星期六</td>
  	           <td>科目一</td>
               <td>${IWeek6Km1Num}</td>
               <td>${IWeek6Km1Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        <tr>
               <td>科目二</td>
               <td>${IWeek6Km2Num}</td>
               <td>${IWeek6Km2Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        <tr>
  	            <td>科目三</td>
               <td>${IWeek6Km3Num}</td>
               <td>${IWeek6Km3Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        
  	        <tr>
  	           <td rowspan="3">星期日</td>
  	           <td>科目一</td>
               <td>${IWeek7Km1Num}</td>
               <td>${IWeek7Km1Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        <tr>
               <td>科目二</td>
               <td>${IWeek7Km2Num}</td>
               <td>${IWeek7Km2Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	        <tr>
  	            <td>科目三</td>
               <td>${IWeek7Km3Num}</td>
               <td>${IWeek7Km3Fp}</td>
               <td>&nbsp;</td>
  	        </tr>
  	         
  	     </tbody>
  	     <tfoot>
  	        <tr>
  	          <td colspan="20">
  	            <a id="<%=aSaveWeek %>"
	            onclick="menuAddForm_submit('sys/Menu/fn/add.action')">保存</a>
	            <a id="<%=aBack %>"
	            href="booked/WeekPb/to/index.action" >返回</a>
  	          </td>
  	        </tr>
  	     </tfoot>
  	   </table>
  	   
  	   <div id="<%=divEditLimit %>"></div>
	</div>
  </body>
</html>
