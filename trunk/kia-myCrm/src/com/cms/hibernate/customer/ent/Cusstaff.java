package com.cms.hibernate.customer.ent;

/**
 * Cusstaff entity. @author MyEclipse Persistence Tools
 */

public class Cusstaff implements java.io.Serializable {

	// Fields

	private Integer staffId;
	private String staffName;
	private Integer staffCusid;
	private String staffSex;
	private String staffJob;
	private String staffPhone;
	private String staffTel;
	private String staffRemark;

	// Constructors

	/** default constructor */
	public Cusstaff() {
	}

	/** full constructor */
	public Cusstaff(String staffName, Integer staffCusid, String staffSex,
			String staffJob, String staffPhone, String staffTel,
			String staffRemark) {
		this.staffName = staffName;
		this.staffCusid = staffCusid;
		this.staffSex = staffSex;
		this.staffJob = staffJob;
		this.staffPhone = staffPhone;
		this.staffTel = staffTel;
		this.staffRemark = staffRemark;
	}

	// Property accessors

	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Integer getStaffCusid() {
		return this.staffCusid;
	}

	public void setStaffCusid(Integer staffCusid) {
		this.staffCusid = staffCusid;
	}

	public String getStaffSex() {
		return this.staffSex;
	}

	public void setStaffSex(String staffSex) {
		this.staffSex = staffSex;
	}

	public String getStaffJob() {
		return this.staffJob;
	}

	public void setStaffJob(String staffJob) {
		this.staffJob = staffJob;
	}

	public String getStaffPhone() {
		return this.staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}

	public String getStaffTel() {
		return this.staffTel;
	}

	public void setStaffTel(String staffTel) {
		this.staffTel = staffTel;
	}

	public String getStaffRemark() {
		return this.staffRemark;
	}

	public void setStaffRemark(String staffRemark) {
		this.staffRemark = staffRemark;
	}

}