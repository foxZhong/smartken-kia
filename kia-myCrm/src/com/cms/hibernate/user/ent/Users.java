package com.cms.hibernate.user.ent;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */



public class Users implements java.io.Serializable {

	// Fields

	private Integer UId;
	private String UName;
	private String UPass;
	private String URealname;
	private Integer URoleid;
	private String UGrant;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(String UName, String UPass, String URealname, Integer URoleid,
			String UGrant) {
		this.UName = UName;
		this.UPass = UPass;
		this.URealname = URealname;
		this.URoleid = URoleid;
		this.UGrant = UGrant;
	}

	// Property accessors

	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	public String getUPass() {
		return this.UPass;
	}

	public void setUPass(String UPass) {
		this.UPass = UPass;
	}

	public String getURealname() {
		return this.URealname;
	}

	public void setURealname(String URealname) {
		this.URealname = URealname;
	}

	public Integer getURoleid() {
		return this.URoleid;
	}

	public void setURoleid(Integer URoleid) {
		this.URoleid = URoleid;
	}

	public String getUGrant() {
		return this.UGrant;
	}

	public void setUGrant(String UGrant) {
		this.UGrant = UGrant;
	}

}