<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.io.PrintWriter"
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
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/css";

     String lStrTheme=request.getParameter("theme")==null?"":request.getParameter("theme").toString();
  
     PrintWriter _PW= response.getWriter();
     StringBuffer lSbrScript=new StringBuffer("");
     String lStrPlugFloder="";
     
     if(lStrTheme.length()<1)
     {
     lStrPlugFloder=basePath+"/default";
     }
     lSbrScript.append(getCssLinkTag(lStrPlugFloder+"/style.css"));
     _PW.write(lSbrScript.toString());

%>


