package com.cms.hibernate.data.ent;

import java.util.HashSet;
import java.util.Set;

/**
 * SysDatas entity. @author MyEclipse Persistence Tools
 */

public class SysDatas implements java.io.Serializable {

	// Fields

	private Integer dataId;
	private String dataTitle;
	private Set sysDataoptionses = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysDatas() {
	}

	/** full constructor */
	public SysDatas(String dataTitle, Set sysDataoptionses) {
		this.dataTitle = dataTitle;
		this.sysDataoptionses = sysDataoptionses;
	}

	// Property accessors

	public Integer getDataId() {
		return this.dataId;
	}

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}

	public String getDataTitle() {
		return this.dataTitle;
	}

	public void setDataTitle(String dataTitle) {
		this.dataTitle = dataTitle;
	}

	public Set getSysDataoptionses() {
		return this.sysDataoptionses;
	}

	public void setSysDataoptionses(Set sysDataoptionses) {
		this.sysDataoptionses = sysDataoptionses;
	}

}