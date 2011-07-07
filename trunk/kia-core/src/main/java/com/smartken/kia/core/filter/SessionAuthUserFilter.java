package com.smartken.kia.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class SessionAuthUserFilter implements Filter {

	public static String AUTH_USER="authUser";

	private String sessionKey=AUTH_USER;
	private String pattern="";
	private String failPath="/login.jsp";
	
	
	
	
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public void setFailPath(String failPath) {
		this.failPath = failPath;
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		 HttpServletRequest req=(HttpServletRequest) arg0;
		 HttpServletResponse rep=(HttpServletResponse) arg1;
		 String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath();
		 String loginName=req.getParameter("loginName");
		 String pwd=req.getParameter("pwd");
		 try{
         Object userModel= req.getSession(true).getAttribute(sessionKey);
         if(loginName!=null&&pwd!=null)
         {}
		 }catch(NullPointerException ex){
			 rep.sendRedirect(basePath+failPath);
		 }
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	


}
