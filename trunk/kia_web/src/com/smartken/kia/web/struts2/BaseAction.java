package com.smartken.kia.web.struts2;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.smartken.kia.biz.ISysBiz;


public abstract class BaseAction extends ActionSupport 
implements ServletResponseAware,ServletRequestAware,Preparable{

	protected static String CUSTOM="custom";
	protected static String METHOD_GET="GET";
	protected static String METHOD_POST="POST";
	protected static String FORMAT_JSON="json";
	protected static String FORMAT_XML="xml";
	
	
	protected HttpServletResponse _res;
	protected HttpServletRequest _req;
	protected HttpSession _session;
	protected String format;

	
	
	public abstract String remove() throws Exception;
	public abstract String search() throws Exception;
	public abstract String moidfy() throws Exception;
	public abstract String add() throws Exception;
	protected abstract void clear();
	
	public String to_index() throws Exception
	{
		return INPUT;
	}
	
	protected void writeHTML(String lStrHTML)
	{
		_res.setContentType("text/html; charset=UTF-8");
		try {
			_res.getWriter().println(lStrHTML);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void writeScript(String lStrScript)
	{
		_res.setContentType("text/html; charset=UTF-8");
		try {
			_res.getWriter().println("<script type='text/javascript'>"+lStrScript+"</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 
	
	
	public void setServletRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		this._req=req;
		this._session=req.getSession();
	}

	public void setServletResponse(HttpServletResponse res) {
		// TODO Auto-generated method stub
		this._res=res;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	

}
