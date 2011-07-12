package com.smartken.kia.core.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class VerifyFilter extends OncePerRequestFilter{

	private ArrayList<IVerifyRule> rules=new ArrayList<IVerifyRule>();
	private String[] includeRegexps=new String[]{};
	private String[] excludeRegexps=new String[]{};
	private String errorPath="";
	
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
	
	public void setRules(String validates){
		String[] vals=validates.split(",");
		for(String val :vals){
			try {
				Class cls=Class.forName(val);
				IVerifyRule rule=(IVerifyRule) cls.newInstance();
				rules.add(rule);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest req,
			HttpServletResponse res, FilterChain filterChain)
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
			 for(IVerifyRule rule :rules){
	        	 if(!rule.doVerifyRule(req, res)){
	        		 res.sendRedirect(basePath+errorPath);
	        		 break;
	        	 }
	         }
		 }
		 filterChain.doFilter(req, res);
	}

}
