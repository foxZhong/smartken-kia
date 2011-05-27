package com.smartken.kia.model.admin;


import com.smartken.kia.core.model.impl.BaseModel;

public class DepartmentModel extends BaseModel {
	private String id;
 	private String fullname;
 	private String nickname;
 	private String company;
 	private String type;
 	private String linkman;
 	private String phone;
 	private String mobile;
	public String getId() {
		return id==null?"":id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname==null?"":fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getNickname() {
		return nickname==null?"":nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCompany() {
		return company==null?"":company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getType() {
		return type==null?"":type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLinkman() {
		return linkman==null?"":linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getPhone() {
		return phone==null?"":phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile==null?"":mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Object generalPK() {
		// TODO Auto-generated method stub
		return null;
	}
}
