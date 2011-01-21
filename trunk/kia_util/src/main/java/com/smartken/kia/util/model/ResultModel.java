package com.smartken.kia.util.model;

import com.smartken.kia.util.model.impl.BaseModel;

public class ResultModel extends BaseModel {

	public static int FAIL=0;
	public static int SUCCESS=1;
	public static int ALERT=2;
	
	private Integer code;
	private String msg;
	
	public int getCode() {
		return  code==null?FAIL:code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg==null?"":msg;
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
