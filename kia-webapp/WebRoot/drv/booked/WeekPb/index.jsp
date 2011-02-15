<%@ page language="java" import="java.util.*,org.json.*,com.smartken.kia.core.model.impl.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.util.StringUtil"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel.DataGrid"%>
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
           var innerHeight=$("#innerDiv").outerHeight(false);
	       var innerWidth=$("#innerDiv").width();
	       <% 
	    String tableWeekPb="tableWeekPb";
        EasyUiModel weekPbDG=new EasyUiModel(StringUtil.quota("#"+tableWeekPb),EasyUiModel.DataGrid.NAME);
        weekPbDG.appendAttrs(DataGrid.Properties.TITLE,StringUtil.quota("周排班列表"))
        .appendAttrs(DataGrid.Properties.URL,"booked/WeekPb/list/DataGrid.action?format=json",true)
        .appendAttrs(EasyUiModel.DataGrid.Properties.FIT_COLUMNS,true)
        .appendAttrs(EasyUiModel.DataGrid.Properties.WIDTH,"innerWidth")
        .appendAttrs(EasyUiModel.DataGrid.Properties.HEIGHT,"innerHeight")
        .appendAttrs(EasyUiModel.DataGrid.Properties.PAGINATION,true)
        .appendAttrs(EasyUiModel.DataGrid.Properties.ID_FIELD,"id",true)
        .appendAttrs(EasyUiModel.DataGrid.Events.ON_DBL_CLICK_ROW,new JsFunctionModel(new String[]{"index,data"}).appendContext("document.location.href=\"booked/WeekPb/to/assign.action?weekNum=\"+data.IWeekNum;"));
        List weekPbColumns=new JsListModel();
        List weekPbR1=new JsListModel();
        JsMapModel<String,Object> weekPbR1C1=new JsMapModel<String,Object>();
        weekPbR1C1.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"编号",true);
        weekPbR1C1.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,"id",true);
        weekPbR1C1.put(EasyUiModel.DataGrid.ColumnProperties.CHECKBOX,true);
        JsMapModel<String,Object> weekPbR1C2=new JsMapModel<String,Object>();
        weekPbR1C2.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"第几周",true);
        weekPbR1C2.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,"IWeekNum",true);
        weekPbR1C2.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,10);
        JsMapModel<String,Object> weekPbR1C3=new JsMapModel<String,Object>();
        weekPbR1C3.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"时间范围",true);
        weekPbR1C3.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,"CWeekRange",true);
        weekPbR1C3.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,10);
        JsMapModel<String,Object> weekPbR1C4=new JsMapModel<String,Object>();
        weekPbR1C4.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"提交人/审核人",true);
        weekPbR1C4.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,"CCheckOperator",true);
        weekPbR1C4.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,30);
        JsMapModel<String,Object> weekPbR1C5=new JsMapModel<String,Object>();
        weekPbR1C5.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"审核结果",true);
        weekPbR1C5.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,"IChecked",true);
        weekPbR1C5.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,30);              
                 
        weekPbR1.add(weekPbR1C1);
        weekPbR1.add(weekPbR1C2);
        weekPbR1.add(weekPbR1C3);
        weekPbR1.add(weekPbR1C4);
        weekPbR1.add(weekPbR1C5);
        weekPbColumns.add(weekPbR1);
        weekPbDG.appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,weekPbColumns);
	       %> 
            <%= weekPbDG.toScirpt() %>
            <%= JQueryModel.DOC_READY_END %>
    </script>
    
  </head>
  
  <body>
  	<div class="innerDiv" id="innerDiv">
	<table id="<%=tableWeekPb %>"></table>
	</div>
  </body>
</html>
