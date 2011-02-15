package com.smartken.kia.core.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IBaseAction {

	public static String CUSTOM="custom";
	public static String JSP="jsp";
    public static String TEXT="text";
    public static String METHOD_GET="GET";
    public static String METHOD_POST="POST";
    public static String FORMAT_JSON="json";
    public static String FORMAT_XML="xml";
    
    public HttpServletRequest getRequest();
    public HttpServletResponse getResponse();
    public void clear();
}
