<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.io.PrintWriter"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
    
<%!
   String getScriptTag(String pStrSrcPath)
   {
     return "<script type='text/javascript' src='"+pStrSrcPath+"'></script>\n";
     
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
      String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

        String lStrTheme=request.getParameter("theme")==null?"":request.getParameter("theme").toString();


         PrintWriter _PW= response.getWriter();
         StringBuffer lSbrScript=new StringBuffer("");
         
         
         
         String lStrPlugFloder=basePath+"/js3rd";
         
         lSbrScript
         .append(getCssLinkTag(lStrPlugFloder+"/jquery-easyui-1.2.3/themes/gray/easyui.css"))
         .append(getCssLinkTag(lStrPlugFloder+"/jquery-easyui-1.2.3/themes/icon.css"))
         .append(getScriptTag(lStrPlugFloder+"/package.js"));
         
         
    	 lStrPlugFloder=basePath+"/css";
    	  
         if(lStrTheme.length()<1)
         {
         lStrPlugFloder=lStrPlugFloder+"/default";
         }
         lSbrScript
         .append(getCssLinkTag(lStrPlugFloder+"/style.css"))
         .append(getCssLinkTag(lStrPlugFloder+"/icon.css"));
         
         
         lStrPlugFloder=basePath+"/js";

    	 lSbrScript
    	 .append(getScriptTag(lStrPlugFloder+"/util.core.js"))
    	 .append(getScriptTag(lStrPlugFloder+"/setting.js"))
    	 .append(getScriptTag(lStrPlugFloder+"/extends.jquery.js"))
    	 .append(getScriptTag(lStrPlugFloder+"/extends.easyui.js"))
    	 .append(getScriptTag(lStrPlugFloder+"/easyui.CrudDatagrid.js"))
    	 .append(getScriptTag(lStrPlugFloder+"/prototype.Object.js"))
    	 .append(getScriptTag(lStrPlugFloder+"/prototype.Array.js"))
    	 .append(getScriptTag(lStrPlugFloder+"/prototype.String.js"))
    	 .append(getScriptTag(lStrPlugFloder+"/util.excel.js"))
    	 
    	 //.append(getScriptTag(lStrPlugFloder+"/package.js"))
    	 ;
    	 

    	 lStrPlugFloder=basePath+"/cache/json";
    	 lSbrScript
    	 .append(getScriptTag(lStrPlugFloder+"/dict.share.json"))
    	 ;
 
     _PW.write(lSbrScript.toString());

%>


