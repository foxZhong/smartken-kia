<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.io.PrintWriter"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.net.URLDecoder"%>
    
<%!
   String getScriptTag(String pStrSrcPath)
   {
     return "<script type='text/javascript' language='javascript' src='"+pStrSrcPath+"'></script>\n";
     
   }
   
   String getCssLinkTag(String pStrHrefPath)
   {
    return "<link rel='stylesheet' type='text/css'  href='"+pStrHrefPath+"' /> \n";
   }
   
   boolean isExist(String[] pArrPlugs,String pStrPlug)
   {
      if(pArrPlugs.length<1||pStrPlug==null)return false;
      for(int i=0;i<pArrPlugs.length;i++)
      {
        if(pArrPlugs[i].equalsIgnoreCase(pStrPlug))
         return true;
      }
      return false;  
    }
 %>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/plugin";

     String lStrPlugins=request.getParameter("plugin")==null?"":request.getParameter("plugin").toString();
     
     String[] lArrPlugins=URLDecoder.decode(lStrPlugins).split(",");
     PrintWriter _PW= response.getWriter();
     StringBuffer lSbrScript=new StringBuffer("");
     String lStrPlugFloder="";
     if( isExist(lArrPlugins,"jquery"))
     {
         lStrPlugFloder=basePath+"/jquery";
    	 lSbrScript.append(getScriptTag(lStrPlugFloder+"/jquery-1.4.4.min.js"));
    	 
     }
     if(isExist(lArrPlugins,"easyui"))
     {
         lStrPlugFloder=basePath+"/jquery-easyui-1.2.2"; 
         lSbrScript.append(getScriptTag(lStrPlugFloder+"/jquery.easyui.min.js"))
    	 .append(getCssLinkTag(lStrPlugFloder+"/themes/default/easyui.css"))
    	  .append(getCssLinkTag(lStrPlugFloder+"/themes/icon.css"));
     }
     
     if(isExist(lArrPlugins,"jval"))
     {
         lStrPlugFloder=basePath+"/jquery-jval";
         lSbrScript.append(getScriptTag(lStrPlugFloder+"/jVal.js"))
         .append(getCssLinkTag(lStrPlugFloder+"/jVal.css")); 
     }
     
     if(isExist(lArrPlugins,"kingeditor"))
     {
         lStrPlugFloder=basePath+"/kingeditor";
         lSbrScript.append(getScriptTag(lStrPlugFloder+"/kingeditor.js"));
     }
     
     if(isExist(lArrPlugins,"json"))
     {
         lStrPlugFloder=basePath+"/json";
         lSbrScript.append(getScriptTag(lStrPlugFloder+"/json.js"));
     }
     
     if(isExist(lArrPlugins,"jsjava"))
     {
         lStrPlugFloder=basePath+"/jsjava/jslib";
         lSbrScript.append(getScriptTag(lStrPlugFloder+"/jsjava-core.js"));
     }
        _PW.write(lSbrScript.toString());

%>


