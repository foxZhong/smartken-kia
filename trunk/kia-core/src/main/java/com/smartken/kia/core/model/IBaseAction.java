package com.smartken.kia.core.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartken.kia.core.pager.PageBounds;

public interface IBaseAction {

	public static String CUSTOM="custom";
	public static String JSP="jsp";
    public static String TEXT="text";
    public static String METHOD_GET="GET";
    public static String METHOD_POST="POST";
    public static String FORMAT_JSON="json";
    public static String FORMAT_XML="xml";
    public static String FORMAT_EASYUI_DATAGRID="easyui_datagrid";
    
    
    public HttpServletRequest getRequest();
    public HttpServletResponse getResponse();
    
    public void clear();
    
	public void setPage(Integer page);
	public void setRows(Integer rows);
	public void setDataFormat(String format);
	
	public Integer getPage();
	public Integer getRows();
	public String getDataFormat();
	
	public PageBounds getPager();
    
}
