package com.cms.hibernate.services.ent;

import java.sql.Timestamp;

/**
 * Services entity. @author MyEclipse Persistence Tools
 */

public class Services implements java.io.Serializable {

	// Fields

	private Integer serId;
	private Integer serUserid;
	private Integer serType;
	private String serContext;
	private Integer serCusid;
	private Integer serStatus;
	private String serRequset;
	private Timestamp serPubtime;
	private Integer serCreaterid;
	private Integer serAssginerid;
	private Timestamp serAsstime;
	private String serHandle;
	private Timestamp serHandletime;
	private Integer serHandlerid;
	private String serResult;
	private Integer serLevel;

	// Constructors

	/** default constructor */
	public Services() {
	}

	/** full constructor */
	public Services(Integer serUserid, Integer serType, String serContext,
			Integer serCusid, Integer serStatus, String serRequset,
			Timestamp serPubtime, Integer serCreaterid, Integer serAssginerid,
			Timestamp serAsstime, String serHandle, Timestamp serHandletime,
			Integer serHandlerid, String serResult, Integer serLevel) {
		this.serUserid = serUserid;
		this.serType = serType;
		this.serContext = serContext;
		this.serCusid = serCusid;
		this.serStatus = serStatus;
		this.serRequset = serRequset;
		this.serPubtime = serPubtime;
		this.serCreaterid = serCreaterid;
		this.serAssginerid = serAssginerid;
		this.serAsstime = serAsstime;
		this.serHandle = serHandle;
		this.serHandletime = serHandletime;
		this.serHandlerid = serHandlerid;
		this.serResult = serResult;
		this.serLevel = serLevel;
	}

	// Property accessors

	public Integer getSerId() {
		return this.serId;
	}

	public void setSerId(Integer serId) {
		this.serId = serId;
	}

	public Integer getSerUserid() {
		return this.serUserid;
	}

	public void setSerUserid(Integer serUserid) {
		this.serUserid = serUserid;
	}

	public Integer getSerType() {
		return this.serType;
	}

	public void setSerType(Integer serType) {
		this.serType = serType;
	}

	public String getSerContext() {
		return this.serContext;
	}

	public void setSerContext(String serContext) {
		this.serContext = serContext;
	}

	public Integer getSerCusid() {
		return this.serCusid;
	}

	public void setSerCusid(Integer serCusid) {
		this.serCusid = serCusid;
	}

	public Integer getSerStatus() {
		return this.serStatus;
	}

	public void setSerStatus(Integer serStatus) {
		this.serStatus = serStatus;
	}

	public String getSerRequset() {
		return this.serRequset;
	}

	public void setSerRequset(String serRequset) {
		this.serRequset = serRequset;
	}

	public Timestamp getSerPubtime() {
		return this.serPubtime;
	}

	public void setSerPubtime(Timestamp serPubtime) {
		this.serPubtime = serPubtime;
	}

	public Integer getSerCreaterid() {
		return this.serCreaterid;
	}

	public void setSerCreaterid(Integer serCreaterid) {
		this.serCreaterid = serCreaterid;
	}

	public Integer getSerAssginerid() {
		return this.serAssginerid;
	}

	public void setSerAssginerid(Integer serAssginerid) {
		this.serAssginerid = serAssginerid;
	}

	public Timestamp getSerAsstime() {
		return this.serAsstime;
	}

	public void setSerAsstime(Timestamp serAsstime) {
		this.serAsstime = serAsstime;
	}

	public String getSerHandle() {
		return this.serHandle;
	}

	public void setSerHandle(String serHandle) {
		this.serHandle = serHandle;
	}

	public Timestamp getSerHandletime() {
		return this.serHandletime;
	}

	public void setSerHandletime(Timestamp serHandletime) {
		this.serHandletime = serHandletime;
	}

	public Integer getSerHandlerid() {
		return this.serHandlerid;
	}

	public void setSerHandlerid(Integer serHandlerid) {
		this.serHandlerid = serHandlerid;
	}

	public String getSerResult() {
		return this.serResult;
	}

	public void setSerResult(String serResult) {
		this.serResult = serResult;
	}

	public Integer getSerLevel() {
		return this.serLevel;
	}

	public void setSerLevel(Integer serLevel) {
		this.serLevel = serLevel;
	}

}