package com.smartken.kia.core.model.impl;

import java.text.MessageFormat;

import com.smartken.kia.core.model.IScriptModel;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public class EasyUiMessager implements IScriptModel {

	public static String SHOW_TYPE_SLIDE="slide";
	public static String SHOW_TYPE_FADE="fade";
	public static String SHOW_TYPE_SHOW="show";
	
	public static String ICON_INFO="info";
	public static String ICON_ERROR="error";
	public static String ICON_QUESTION="question";
	public static String ICON_WARNING="warning";
	
	private String showType;
	private String showSpeed;
	private String width;
	private String height;
	private String msg;
	private String title;
	private String timeout;
	private String icon;
	private String fn;
	
	public EasyUiMessager(){
		
	}
	
	public String alert()
	{
		String lStrReturn="";
		String lStrRege="$.messager.alert({0},{1},{2},{3});";
		lStrReturn=MessageFormat.format(lStrRege,
	            ObjectUtil.formatString(this.title,"\"\""),	 //0
	            ObjectUtil.formatString(this.msg, "\"\""),   //1
	            ObjectUtil.formatString(this.icon,"\"\""),    //2
	            ObjectUtil.formatString(this.fn, new JsFunctionModel(new String[]{"ok"}).toScirpt()) //3
		);
		return lStrReturn;
	}
	
	public String confirm()
	{
		String lStrReturn="";
		String lStrRege="$.messager.confirm({0},{1},{2});";
		lStrReturn=MessageFormat.format(lStrRege,
	    ObjectUtil.formatString(this.title,"\"\""),	 //0
	    ObjectUtil.formatString(this.msg, "\"\""),   //1
	    ObjectUtil.formatString(this.fn, new JsFunctionModel(new String[]{"ok"}).toScirpt())  //2
		);
		return lStrReturn;
	}
	
	public String prompt()
	{
		String lStrReturn="";
		String lStrRege="$.messager.prompt({0},{1},{2})";
		lStrReturn=MessageFormat.format(lStrRege,
			    ObjectUtil.formatString(this.title,"\"\""),	 //0
			    ObjectUtil.formatString(this.msg, "\"\""),   //1
			    ObjectUtil.formatString(this.fn, new JsFunctionModel(new String[]{"ok"}).toScirpt())  //2
				);
		return lStrReturn;
	}
	
	public String show()
	{
		String lStrReturn="";
		String lStrRege="$.messager.{0}.({1})";
		return lStrReturn;
	}
	
	
	
	
	public String getShowType() {
		return showType;
	}

	public EasyUiMessager setShowType(String showType) {
		this.showType = showType;
		return this;
	}
	
	public EasyUiMessager setShowType(String showType,boolean isStr) {
		this.showType =isStr?StringUtil.quota(showType):showType;
		return this;
	}

	public String getShowSpeed() {
		return showSpeed;
	}

	public EasyUiMessager setShowSpeed(String showSpeed) {
		this.showSpeed = showSpeed;
		return this;
	}
	
	public EasyUiMessager setShowSpeed(String showSpeed,boolean isStr) {
		this.showSpeed = isStr?StringUtil.quota(showSpeed):showSpeed;
		return this;
	}

	public String getWidth() {
		return width;
	}

	public EasyUiMessager setWidth(String width) {
		this.width = width;
		return this;
	}
	
	public EasyUiMessager setWidth(String showSpeed,boolean isStr) {
		this.width = isStr?StringUtil.quota(width):width;
		return this;
	}

	public String getHeight() {
		return height;
	}

	public EasyUiMessager setHeight(String height) {
		this.height = height;
		return this;
	}
	
	public EasyUiMessager setHeight(String height,boolean isStr) {
		this.height = isStr?StringUtil.quota(height):height;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public EasyUiMessager setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	
	public EasyUiMessager setMsg(String msg,boolean isStr) {
		this.msg = isStr?StringUtil.quota(msg):msg;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public EasyUiMessager setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public EasyUiMessager setTitle(String title,boolean isStr) {
		this.title = isStr?StringUtil.quota(title):title;
		return this;
	}

	public String getTimeout() {
		return timeout;
	}

	public EasyUiMessager setTimeout(String timeout) {
		this.timeout = timeout;
		return this;
	}
	
	public EasyUiMessager setTimeout(String timeout,boolean isStr) {
		this.timeout =isStr?StringUtil.quota(timeout):timeout;
	    return this;
	}

	public String getIcon() {
		return icon;
	}

	public EasyUiMessager setIcon(String icon) {
		this.icon = icon;
		return this;
	}
	
	public EasyUiMessager setIcon(String icon,boolean isStr) {
		this.icon =isStr?StringUtil.quota(icon):icon;
		return this;
	}

	public String getFn() {
		return fn;
	}

	public EasyUiMessager setFn(String fn) {
		this.fn = fn;
		return this;
	}

	public String toScirpt() {
		// TODO Auto-generated method stub
		String lStrRege="$.messager.{0}.({1})";
		return null;
	}

}
