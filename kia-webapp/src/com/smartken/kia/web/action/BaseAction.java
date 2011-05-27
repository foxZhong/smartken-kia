package com.smartken.kia.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.smartken.kia.biz.IAdminBiz;
import com.smartken.kia.core.enums.DataFormatEnum;
import com.smartken.kia.core.model.IBaseAction;
import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.core.util.ObjectUtil;



public abstract class BaseAction extends ActionSupport 
implements Preparable,IBaseAction
{

	
	
	private String dataFormat;
    private Integer page;
    private Integer rows;
    protected int count;

	protected IAdminBiz adminBiz;
	
	
	

	public void setAdminBiz(IAdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}

	public abstract void clear();
	
	public String to_index() throws Exception
	{
		return INPUT;
	
	}
	
	protected void writeHTML(String lStrHTML)
	{
		HttpServletResponse res=this.getResponse();
		res.setContentType("text/html; charset=UTF-8");
		try {
			res.getWriter().write(lStrHTML);
			res.getWriter().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writePlainText(String lStrText)
	{
		try {
				HttpServletResponse res=this.getResponse();
				res.setContentType("text/plain; charset=UTF-8");
				PrintWriter pw=res.getWriter();
				pw.write(lStrText);
				pw.flush();
				pw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeScript(String lStrScript)
	{
		HttpServletResponse res=this.getResponse();
		res.setContentType("text/html; charset=UTF-8");
		try {
			res.getWriter().println("<script type='text/javascript'>"+lStrScript+"</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
	public void setPage(Integer page) {
		this.page = ObjectUtil.formatInt(page,PageBounds.NO_ROW_OFFSET);
	}
	public void setRows(Integer rows) {
		this.rows = ObjectUtil.formatInt(rows,PageBounds.NO_ROW_LIMIT);
	}
	
	

	public String getDataFormat() {
		// TODO Auto-generated method stub
		return this.dataFormat;
	}

	public Integer getPage() {
		// TODO Auto-generated method stub
		return this.page;
	}

	public Integer getRows() {
		// TODO Auto-generated method stub
		return this.rows;
	}

	public PageBounds getPager(){
		PageBounds pb=new PageBounds(this.page==null?PageBounds.NO_ROW_OFFSET:(this.page-1)*this.rows,
				                     this.rows==null?PageBounds.NO_ROW_LIMIT:this.rows);
		return pb;
	}

	public void setDataFormat(String format) {
		// TODO Auto-generated method stub
		this.dataFormat = ObjectUtil.formatString(dataFormat, DataFormatEnum.json.toString());
	}

	public HttpServletRequest getRequest()
	{
		return ServletActionContext.getRequest();
	}
	
	public HttpServletResponse getResponse()
	{
		return ServletActionContext.getResponse();
	}
	
	public String getParameter(Enum en) {
		// TODO Auto-generated method stub
		return getParameter(en.name());
	}
	
	
	public String getParameter(String key) {
		// TODO Auto-generated method stub
		return ObjectUtil.formatString(this.getRequest().getParameter(key));
	}

	public Object getRequestAttribute(Enum en) {
		// TODO Auto-generated method stub
		return this.getRequestAttribute(en.name());
	}

	public Object getRequestAttribute(String key) {
		// TODO Auto-generated method stub
		return this.getRequest().getAttribute(key);
	}

	public HttpSession getSession() {
		// TODO Auto-generated method stub
		return this.getRequest().getSession();
	}

	public Object getSessionAttribute(Enum en) {
		// TODO Auto-generated method stub
		return this.getSessionAttribute(en.name());
	}

	public Object getSessionAttribute(String key) {
		// TODO Auto-generated method stub
		return this.getSession().getAttribute(key);
	}
	

}
