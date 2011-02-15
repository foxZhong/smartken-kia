package com.smartken.kia.core.model.impl;

public class ResultModel extends BaseModel{

	public static int CODE_SUCCESS=0;
	public static int CODE_ALERT=1;
	public static int CODE_ERROR=2;
	
	public static String ICON_INFO="info";
	public static String ICON_ERROR="error";
	public static String ICON_QUESTION="question";
	public static String ICON_WARNING="warning";
	
    private Integer code;
    private String icon;
    private String title;
    private String msg;
	
    public ResultModel(){
    	this.code=CODE_SUCCESS;
    	this.icon=ICON_INFO;
    	this.title="";
    	this.msg="";
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

}
