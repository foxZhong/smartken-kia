package com.smartken.kia.core.model.impl;

import java.text.MessageFormat;

public class ResultModel extends BaseModel{

	public static int CODE_SUCCESS=0;
	public static int CODE_ALERT=1;
	public static int CODE_ERROR=2;
	
	public static String ICON_INFO="info";
	public static String ICON_ERROR="error";
	public static String ICON_QUESTION="question";
	public static String ICON_WARNING="warning";
	
	public static String ACTION_SHOW="show";
	public static String ACTION_CONFIRM="confirm";
	public static String ACTION_ALERT="alert";
	public static String ACTION_PROMPT="prompt";
	
	private int re;
    private Integer code;
    private String icon;
    private String title;
    private String msg;
    private String action;
	
    public ResultModel(){
    	this.re=0;
    	this.code=CODE_SUCCESS;
    	this.icon=ICON_INFO;
    	this.title="";
    	this.msg="";
    	this.action=ACTION_SHOW;
    }
    
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setTitle(String pattern,Object...arguments){
		this.title=MessageFormat.format(pattern, arguments);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void setMsg(String pattern,Object...arguments){
		this.msg=MessageFormat.format(pattern, arguments);
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getRe() {
		return re;
	}

	public void setRe(int re) {
		this.re = re;
	}


	

}
