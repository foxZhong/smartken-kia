<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.smartken.kia.core.util.StringUtil"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addLimit.jsp' starting page</title>
    
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
    <jsp:useBean id="tempLimit" scope="request" beanName="tempLimit"
    type="com.trusteach.drv.model.BookedLimitModel"></jsp:useBean>
    <script type="text/javascript">
    
    <%=JQueryModel.DOC_READY_START %>
    
    <%
        
           String formEditLimit="formEditLimit";
           String selectKscc="selectKscc";
           String selectKsdd="selectKsdd";
           String selectSchool="selectSchool";
           String txtTotal="txtTotal";
           String aSaveLimit="aSaveLimit";
           String aReset="aReset";
          
           EasyUiModel comboboxKscc=new EasyUiModel(StringUtil.quota("#"+formEditLimit+"-"+selectKscc),EasyUiModel.ComboBox.NAME);
           comboboxKscc.appendAttrs(EasyUiModel.ComboBox.Properties.URL,basePath+"booked/WeekPb/select/kscc.action",true)
           .appendAttrs(EasyUiModel.ComboBox.Properties.TEXT_FIELD,"dictText",true)
           .appendAttrs(EasyUiModel.ComboBox.Properties.VALUE_FIELD,"dictValue",true)
           .appendAttrs(EasyUiModel.ComboBox.Properties.EDITABLE,false)
           .appendAttrs(EasyUiModel.ComboBox.Properties.WIDTH,150)
           .appendAttrs(EasyUiModel.ComboBox.Properties.REQUIRED,true)
           .appendAttrs(EasyUiModel.ComboBox.Properties.VALUE,tempLimit.getKsccCode(),true)
           ;
           
           EasyUiModel comboboxKsdd=new EasyUiModel(StringUtil.quota("#"+formEditLimit+"-"+selectKsdd),EasyUiModel.ComboBox.NAME);
           comboboxKsdd.appendAttrs(EasyUiModel.ComboBox.Properties.URL,basePath+"booked/WeekPb/select/ksdd.action",true)
           .appendAttrs(EasyUiModel.ComboBox.Properties.TEXT_FIELD,"dictText",true)
           .appendAttrs(EasyUiModel.ComboBox.Properties.VALUE_FIELD,"dictValue",true)
           .appendAttrs(EasyUiModel.ComboBox.Properties.EDITABLE,false)
           .appendAttrs(EasyUiModel.ComboBox.Properties.WIDTH,150)
           .appendAttrs(EasyUiModel.ComboBox.Properties.REQUIRED,true)
           .appendAttrs(EasyUiModel.ComboBox.Properties.VALUE,tempLimit.getKsddCode(),true)
           .appendAttrs(EasyUiModel.ComboBox.Events.ON_LOAD_SUCCESS,new JsFunctionModel(null).appendContext(comboboxKscc))
           ;
              
           EasyUiModel comboboxSchool=new EasyUiModel(StringUtil.quota("#"+formEditLimit+"-"+selectSchool),EasyUiModel.ComboBox.NAME);
           comboboxSchool.appendAttrs(EasyUiModel.ComboBox.Properties.URL,basePath+"booked/WeekPb/select/school.action",true)
           .appendAttrs(EasyUiModel.ComboBox.Properties.TEXT_FIELD,"depnickname",true)
           .appendAttrs(EasyUiModel.ComboBox.Properties.VALUE_FIELD,"depcode",true)
           .appendAttrs(EasyUiModel.ComboBox.Properties.EDITABLE,false)
           .appendAttrs(EasyUiModel.ComboBox.Properties.WIDTH,150)
           .appendAttrs(EasyUiModel.ComboBox.Properties.REQUIRED,true)
           .appendAttrs(EasyUiModel.ComboBox.Properties.VALUE,tempLimit.getSchoolCode(),true)
           .appendAttrs(EasyUiModel.ComboBox.Events.ON_LOAD_SUCCESS,new JsFunctionModel(null).appendContext(comboboxKsdd))
           ;
           
           EasyUiModel numberTotal=new EasyUiModel(StringUtil.quota("#"+formEditLimit+"-"+txtTotal),EasyUiModel.NumberSpinner.NAME);
           numberTotal.appendAttrs(EasyUiModel.Spinner.Properties.INCREMENT,5)
           .appendAttrs(EasyUiModel.NumberBox.Properties.MIN,1)
           .appendAttrs(EasyUiModel.Spinner.Properties.REQUIRED,true)
           ;
           
           
           EasyUiModel btnSave=new EasyUiModel(StringUtil.formatId(true,"#","-",formEditLimit,aSaveLimit),EasyUiModel.LinkButton.NAME);
           btnSave.appendAttrs(EasyUiModel.LinkButton.Properties.ICON_CLS,EasyUiModel.ICON_SAVE,true)
           .appendAttrs(EasyUiModel.LinkButton.Properties.TEXT,"保存",true)
           ;
           
           JsMapModel optEditForm=new JsMapModel();
           optEditForm.put(EasyUiModel.Form.Properties.URL,basePath+"booked/WeekPb/do/editLimit.action",true);
           optEditForm.put(EasyUiModel.Form.Events.SUCCESS,
                new JsFunctionModel(new String[]{"data"})
                .appendContext("var re=eval('('+data+')');")
                .appendContext(new EasyUiMessager()
                                .setTitle("re.title")
                                .setMsg("re.msg")
                                .alert()
                )
           );
           
           JQueryModel btnSaveClick=new JQueryModel(StringUtil.formatId(true,"#","-",formEditLimit,aSaveLimit),JQueryModel.Events.CLICK);
           btnSaveClick.appendParma(
               new JsFunctionModel(null)
               .appendContext(
                 new EasyUiModel(StringUtil.formatId(true,"#",null,formEditLimit),
                                    EasyUiModel.Form.NAME,
                                    EasyUiModel.Form.Methods.SUBMIT,
                                    optEditForm.toScirpt())
                          //.appendAttrs(EasyUiModel.Form.Properties.URL,StringUtil.quota(basePath+"booked/WeekPb/do/editLimit.action"),true)
               )
           )
           ;
           
           EasyUiModel btnReset=new EasyUiModel(StringUtil.formatId(true,"#","-",formEditLimit,aReset),EasyUiModel.LinkButton.NAME);
           btnReset.appendAttrs(EasyUiModel.LinkButton.Properties.ICON_CLS,EasyUiModel.ICON_RELOAD,true)
           .appendAttrs(EasyUiModel.LinkButton.Properties.TEXT,"重置",true)
           ;
           
           JsContextModel jsContext=new JsContextModel();
           jsContext.appendScript(comboboxSchool)
           .appendScript(numberTotal)
           .appendScript(btnSave)
           .appendScript(btnSaveClick)
           .appendScript(btnReset)
           //.appendScript(formEditLimits)
           ;
     %>
    
           <%=jsContext.toScirpt() %>
    
      
    <%=JQueryModel.DOC_READY_END %>
    </script>
    
  </head>
  
  <body>
  	      <div class="innerDiv">
  	        <form  id="<%=formEditLimit %>" method="post">
  	         <input type="hidden" name="tempLimit.km" value="${tempLimit.km}">
  	         <input type="hidden" name="tempLimit.dayofweek" value="${tempLimit.dayofweek}">
  	        <input type="hidden" name="tempLimit.dateKsrq" value="${tempLimit.dateKsrq}">
  	        <input type="hidden" name="tempLimit.weekNum" value="${tempLimit.weekNum}">
  	         <input type="hidden" name="tempLimit.kscc">
  	         <input type="hidden" name="tempLimit.ksdd">
  	         <input type="hidden" name="tempLimit.schoolName">
  	          <table class="editTable">
  	            <tr>
  	              <td>考试场次</td>
  	              <td>
  	                 <input name="tempLimit.ksccCode"  id="<%=StringUtil.formatId(null,"-",formEditLimit,selectKscc) %>"   />
  	              </td>
  	            </tr>
  	            <tr>
  	              <td>考试地点</td>
  	              <td>
  	                 <input name="tempLimit.ksddCode"  id="<%=StringUtil.formatId(null,"-",formEditLimit,selectKsdd) %>" />
  	              </td>
  	            </tr>
  	            <tr>
  	              <td>驾校</td>
  	              <td>
  	                 <input name="tempLimit.schoolCode" id="<%=StringUtil.formatId(null,"-",formEditLimit,selectSchool) %>"  />
  	              </td>
  	            </tr>
  	            <tr>
  	              <td>分配人数</td>
  	              <td><input name="tempLimit.total" id="<%=formEditLimit+"-"+txtTotal %>" value="${tempLimit.total}" /></td>
  	            </tr>
  	            <tr>
  	              <td colspan="2">
  	               <a id="<%=StringUtil.formatId(null,"-",formEditLimit,aSaveLimit) %>"></a>
  	               <a id="<%=StringUtil.formatId(null,"-",formEditLimit,aReset) %>" ></a>
  	              </td>
  	            </tr>
  	          </table>
  	        </form>
  	      </div>
  </body>
</html>
