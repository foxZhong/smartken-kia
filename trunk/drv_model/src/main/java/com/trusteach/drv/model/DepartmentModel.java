package com.trusteach.drv.model;

import javax.swing.DebugGraphics;

import com.smartken.kia.core.model.impl.BaseModel;



public class DepartmentModel extends BaseModel {

 	
	private Integer id;
	private String connector;
	private String mobile;
	private String phone;
	private String companycode;
	private String depfullname;
	private String depnickname;
	private String depcode;
	private String parentcode;
	private String deptype;
	
	
	
	
	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	



	public String getConnector() {
		return connector;
	}




	public void setConnector(String connector) {
		this.connector = connector;
	}




	public String getMobile() {
		return mobile;
	}




	public void setMobile(String mobile) {
		this.mobile = mobile;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getCompanycode() {
		return companycode;
	}




	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}




	public String getDepfullname() {
		return depfullname;
	}




	public void setDepfullname(String depfullname) {
		this.depfullname = depfullname;
	}




	public String getDepnickname() {
		return depnickname;
	}




	public void setDepnickname(String depnickname) {
		this.depnickname = depnickname;
	}




	public String getDepcode() {
		return depcode;
	}




	public void setDepcode(String depcode) {
		this.depcode = depcode;
	}




	public String getParentcode() {
		return parentcode;
	}




	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}




	public String getDeptype() {
		return deptype;
	}




	public void setDeptype(String deptype) {
		this.deptype = deptype;
	}




	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}
 	
 	
}
