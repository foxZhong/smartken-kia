package com.smartken.kia.core.filter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oro.text.regex.PatternMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sun.tools.javac.resources.compiler;


public  class SessionRequiredFilter extends OncePerRequestFilter  {

	public static String AUTH_USER="authUser";

	private String[] requiredKeys=new String[]{};
	private String[] includeRegexps=new String[]{};
	private String[] excludeRegexps=new String[]{};
	private String errorPath="";
	
	
	

	public void setRequiredKeys(String requiredKeys) {
		String[] vals=requiredKeys.split(",");
		this.requiredKeys = vals;
	}

	public void setIncludeRegexps(String includeRegexp) {
		String[] vals=includeRegexp.split(",");
		this.includeRegexps = vals;
	}

	public void setExcludeRegexps(String excludeRegexp) {
		String[] vals=excludeRegexp.split(",");
		this.excludeRegexps = vals;
	}

	public void setErrorPath(String errorPath) {
		this.errorPath = errorPath;
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}


	@Override
	protected void doFilterInternal(HttpServletRequest req,
			HttpServletResponse res, FilterChain fc)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String url=req.getServletPath();
		 String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath();
         boolean isMatch=false;
		 for(String regexp:includeRegexps){
			 Pattern p=Pattern.compile(regexp);
			 Matcher matcher=p.matcher(url);
			 if(matcher.find()){
				 isMatch=true;
				 for(String regexp2:excludeRegexps){
					 Pattern p2=Pattern.compile(regexp2);
					 Matcher matcher2=p2.matcher(url);
					 if(matcher2.find()){
						isMatch=false;
                        break;
					 }
				 }
				 break;
			 }
		 }
		 if(isMatch){
			 for(String key :requiredKeys){
	        	 if(req.getSession().getAttribute(key)==null){
	        		 res.sendRedirect(basePath+errorPath);
	        	 }
	         }
		 }
		 fc.doFilter(req, res);
	}
	

	
	public static void main(String[] args){
		 String regexp="(/to/).*(.action)$";
		 String url="/admin/Buslog/to/count.action";
		 Pattern p=Pattern.compile(regexp);
		 Matcher matcher=p.matcher(url);
		 boolean isMatch= matcher.find();
		 System.out.println(isMatch);
		 //int end= matcher.end();
		 //System.out.println(end);
	}

}
