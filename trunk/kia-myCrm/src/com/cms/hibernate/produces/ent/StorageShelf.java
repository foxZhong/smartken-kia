package com.cms.hibernate.produces.ent;

/**
 * StorageShelf entity. @author MyEclipse Persistence Tools
 */

public class StorageShelf implements java.io.Serializable {

	// Fields

	private Integer sheId;
	private String sheName;
	private Integer sheStorageid;
	private String sheDesc;

	// Constructors

	/** default constructor */
	public StorageShelf() {
	}

	/** full constructor */
	public StorageShelf(String sheName, Integer sheStorageid, String sheDesc) {
		this.sheName = sheName;
		this.sheStorageid = sheStorageid;
		this.sheDesc = sheDesc;
	}

	// Property accessors

	public Integer getSheId() {
		return this.sheId;
	}

	public void setSheId(Integer sheId) {
		this.sheId = sheId;
	}

	public String getSheName() {
		return this.sheName;
	}

	public void setSheName(String sheName) {
		this.sheName = sheName;
	}

	public Integer getSheStorageid() {
		return this.sheStorageid;
	}

	public void setSheStorageid(Integer sheStorageid) {
		this.sheStorageid = sheStorageid;
	}

	public String getSheDesc() {
		return this.sheDesc;
	}

	public void setSheDesc(String sheDesc) {
		this.sheDesc = sheDesc;
	}

}