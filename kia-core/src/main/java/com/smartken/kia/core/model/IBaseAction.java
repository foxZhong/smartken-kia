package com.smartken.kia.core.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smartken.kia.core.pager.PageBounds;

public interface IBaseAction {

    public static String METHOD_GET="GET";
    public static String METHOD_POST="POST";
    public static String QUERY="query";
    public static String QUERY_EMPTY="empty";
    public static String QUERY_SEARCH="search";
    

    
    public void clear();
    
	public void setPage(Integer page);
	public void setRows(Integer rows);
	public void setDataFormat(String format);
	
	public Integer getPage();
	public Integer getRows();
	public String getDataFormat();
	
	public PageBounds getPager();
	
    public HttpServletRequest getRequest();
    public HttpServletResponse getResponse();
	public HttpSession getSession();
	
    public Object getRequestAttribute(Enum en);
    public Object getRequestAttribute(String key);
	public String getParameter(Enum en);
	public String getParameter(String key);
	public Object getSessionAttribute(Enum en);
	public Object getSessionAttribute(String key);
    
}
