package com.smartken.kia.model.sys;

import com.smartken.kia.util.model.impl.BaseModel;

public class UserModel extends BaseModel {

	private String id;
	private String pwd;
	private String name;
	private String role;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	
	
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
