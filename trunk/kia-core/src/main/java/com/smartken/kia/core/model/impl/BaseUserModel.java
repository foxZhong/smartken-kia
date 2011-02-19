package com.smartken.kia.core.model.impl;

import com.smartken.kia.core.model.impl.BaseModel;

public abstract class BaseUserModel extends BaseModel {

	private String loginId;
	private String loginPwd;
	private String name;
	private String role;
	private String dept;
	private String idCard;
	private String workId;
	private String ipBegin;
	private String ipEnd;
	private String statue;
	

	
	public String getLoginId() {
		return loginId;
	}



	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}



	public String getLoginPwd() {
		return loginPwd;
	}



	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getDept() {
		return dept;
	}



	public void setDept(String dept) {
		this.dept = dept;
	}



	public String getIdCard() {
		return idCard;
	}



	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}



	public String getWorkId() {
		return workId;
	}



	public void setWorkId(String workId) {
		this.workId = workId;
	}



	public String getIpBegin() {
		return ipBegin;
	}



	public void setIpBegin(String ipBegin) {
		this.ipBegin = ipBegin;
	}



	public String getIpEnd() {
		return ipEnd;
	}



	public void setIpEnd(String ipEnd) {
		this.ipEnd = ipEnd;
	}



	public String getStatue() {
		return statue;
	}



	public void setStatue(String statue) {
		this.statue = statue;
	}



	public Object generalPK() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
