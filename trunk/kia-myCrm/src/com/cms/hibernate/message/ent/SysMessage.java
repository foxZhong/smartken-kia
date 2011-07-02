package com.cms.hibernate.message.ent;

import java.sql.Timestamp;

/**
 * SysMessage entity. @author MyEclipse Persistence Tools
 */

public class SysMessage implements java.io.Serializable {

	// Fields

	private Integer mesId;
	private String mesContext;
	private Integer mesFromid;
	private Integer mesToid;
	private Timestamp mesTime;
	private Integer mesIsPublic=1;
	private String mesTitle;

	// Constructors

	/** default constructor */
	public SysMessage() {
	}

	/** minimal constructor */
	public SysMessage(String mesTitle) {
		this.mesTitle = mesTitle;
	}

	/** full constructor */
	public SysMessage(String mesContext, Integer mesFromid, Integer mesToid,
			Timestamp mesTime, Integer mesIsPublic, String mesTitle) {
		this.mesContext = mesContext;
		this.mesFromid = mesFromid;
		this.mesToid = mesToid;
		this.mesTime = mesTime;
		this.mesIsPublic = mesIsPublic;
		this.mesTitle = mesTitle;
	}

	// Property accessors

	public Integer getMesId() {
		return this.mesId;
	}

	public void setMesId(Integer mesId) {
		this.mesId = mesId;
	}

	public String getMesContext() {
		return this.mesContext;
	}

	public void setMesContext(String mesContext) {
		this.mesContext = mesContext;
	}

	public Integer getMesFromid() {
		return this.mesFromid;
	}

	public void setMesFromid(Integer mesFromid) {
		this.mesFromid = mesFromid;
	}

	public Integer getMesToid() {
		return this.mesToid;
	}

	public void setMesToid(Integer mesToid) {
		this.mesToid = mesToid;
	}

	public Timestamp getMesTime() {
		return this.mesTime;
	}

	public void setMesTime(Timestamp mesTime) {
		this.mesTime = mesTime;
	}

	public Integer getMesIsPublic() {
		return this.mesIsPublic;
	}

	public void setMesIsPublic(Integer mesIsPublic) {
		this.mesIsPublic = mesIsPublic;
	}

	public String getMesTitle() {
		return this.mesTitle;
	}

	public void setMesTitle(String mesTitle) {
		this.mesTitle = mesTitle;
	}

}