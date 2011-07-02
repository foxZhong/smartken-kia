package com.cms.hibernate.produces.ent;

/**
 * Storage entity. @author MyEclipse Persistence Tools
 */

public class Storage implements java.io.Serializable {

	// Fields

	private Integer stoId;
	private String stoName;
	private String stoDesc;

	// Constructors

	/** default constructor */
	public Storage() {
	}

	/** full constructor */
	public Storage(String stoName, String stoDesc) {
		this.stoName = stoName;
		this.stoDesc = stoDesc;
	}

	// Property accessors

	public Integer getStoId() {
		return this.stoId;
	}

	public void setStoId(Integer stoId) {
		this.stoId = stoId;
	}

	public String getStoName() {
		return this.stoName;
	}

	public void setStoName(String stoName) {
		this.stoName = stoName;
	}

	public String getStoDesc() {
		return this.stoDesc;
	}

	public void setStoDesc(String stoDesc) {
		this.stoDesc = stoDesc;
	}

}