package com.smartken.kia.core.model.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;



import com.opensymphony.xwork2.ActionSupport;
import com.smartken.kia.core.enums.DataFormatEnum;
import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.model.IBaseAction;
import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.core.util.DateTimeUtil;
import com.smartken.kia.core.util.FileUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public abstract class BaseAction extends ActionSupport implements IBaseAction {


	
	private String dataFormat;
    private Integer page;
    private Integer rows;
    protected int count;

	
	public String to_index() throws Exception
	{
		return ResultEnum.jsp.toString();
	
	}
	
	protected void writeHTML(String lStrHTML)
	{
		HttpServletResponse res=this.getResponse();
		res.setContentType(CONTENT_TYPE_HTML);
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
				res.setContentType(CONTENT_TYPE_TEXT);
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
		res.setContentType(CONTENT_TYPE_HTML);
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
		return this.getRequest().getParameter(key);
	}
	
	public Double getParameterDouble(String key,double dblDefaultValue) {
		// TODO Auto-generated method stub
		String value=this.getParameter(key);
        Double dblValue=ObjectUtil.formatDouble(value,dblDefaultValue);
        return dblValue;
	}
	
	public Integer getParameterInt(String key,int intDefaultValue) {
		// TODO Auto-generated method stub
		String value=this.getParameter(key);
        Integer intValue=ObjectUtil.formatInt(value,intDefaultValue);
        return intValue;
	}
	
	public Date getParameterDate(String key,Date dateDefalueValue) {
		// TODO Auto-generated method stub
		String value=this.getParameter(key);
		Date dateValue=null;
		if(StringUtil.isBlank(value)){
			return dateDefalueValue;
		}
		try{
		dateValue=DateTimeUtil.parse(value);
		}catch(Exception ex){
			dateValue=dateDefalueValue;
		}
		return dateValue;
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
	
	



	public void setRequestAttribute(Enum en, Object obj) {
		// TODO Auto-generated method stub
	    this.getRequest().setAttribute(en.name(),obj);
	}

	public void setRequestAttribute(String key, Object obj) {
		// TODO Auto-generated method stub
		this.getRequest().setAttribute(key, obj);
	}

	public void setSessionAttribute(Enum en, Object obj) {
		// TODO Auto-generated method stub
		this.setSessionAttribute(en.name(), obj);
	}

	public void setSessionAttribute(String key, Object obj) {
		// TODO Auto-generated method stub
		this.getSession().setAttribute(key, obj);
	}
	
	
	
	

	public boolean isPost() {
		// TODO Auto-generated method stub
		
		return METHOD_POST.equalsIgnoreCase(this.getRequest().getMethod());
	}

	public boolean isGet() {
		// TODO Auto-generated method stub
		return METHOD_GET.equalsIgnoreCase(this.getRequest().getMethod());
	}
	
	public String getBasePath(){
		HttpServletRequest request=this.getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	    return basePath;
	}
	
	public String getPhysicsBasePath(){
		String physicsBasePath="";
		URL classPathUrl=FileUtil.getClassPath(this.getClass());
		try {
			physicsBasePath=FileUtil.getParentDir(classPathUrl,2).getPath();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return physicsBasePath;
	}

	public void writeStream(byte[] bytes) {
		// TODO Auto-generated method stub
		HttpServletResponse res=this.getResponse();
		OutputStream os=null;
		try {
			os=res.getOutputStream();
			os.write(bytes);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public void setResponseFileName(String fileName){
	  this.getResponse().setHeader(HEADER_Content_DISPOSITION, 
			  "attachment; filename="+fileName );   
   }
	
}
