package com.cms.hibernate.sell.ent;

import java.sql.Timestamp;

/**
 * Sellchance entity. @author MyEclipse Persistence Tools
 */

public class Sellchance implements java.io.Serializable {

	// Fields

	private Integer chaId;
	private Integer chaUserid;
	private String chaSource;
	private String chaClientName;
	private Integer chaSuccessRate;
	private String chaSummary;
	private String chaContext;
	private String chaContextPhone;
	private String chaDesc;
	private Integer chaCreatorid;
	private Timestamp chaCreatetime;
	private Integer chaDispatchid;
	private Timestamp chaDistime;
	private String chaCode;
	private Integer chaStaut;

	// Constructors

	/** default constructor */
	public Sellchance() {
	}

	/** minimal constructor */
	public Sellchance(Integer chaStaut) {
		this.chaStaut = chaStaut;
	}

	/** full constructor */
	public Sellchance(Integer chaUserid, String chaSource,
			String chaClientName, Integer chaSuccessRate, String chaSummary,
			String chaContext, String chaContextPhone, String chaDesc,
			Integer chaCreatorid, Timestamp chaCreatetime,
			Integer chaDispatchid, Timestamp chaDistime, String chaCode,
			Integer chaStaut) {
		this.chaUserid = chaUserid;
		this.chaSource = chaSource;
		this.chaClientName = chaClientName;
		this.chaSuccessRate = chaSuccessRate;
		this.chaSummary = chaSummary;
		this.chaContext = chaContext;
		this.chaContextPhone = chaContextPhone;
		this.chaDesc = chaDesc;
		this.chaCreatorid = chaCreatorid;
		this.chaCreatetime = chaCreatetime;
		this.chaDispatchid = chaDispatchid;
		this.chaDistime = chaDistime;
		this.chaCode = chaCode;
		this.chaStaut = chaStaut;
	}

	// Property accessors

	public Integer getChaId() {
		return this.chaId;
	}

	public void setChaId(Integer chaId) {
		this.chaId = chaId;
	}

	public Integer getChaUserid() {
		return this.chaUserid;
	}

	public void setChaUserid(Integer chaUserid) {
		this.chaUserid = chaUserid;
	}

	public String getChaSource() {
		return this.chaSource;
	}

	public void setChaSource(String chaSource) {
		this.chaSource = chaSource;
	}

	public String getChaClientName() {
		return this.chaClientName;
	}

	public void setChaClientName(String chaClientName) {
		this.chaClientName = chaClientName;
	}

	public Integer getChaSuccessRate() {
		return this.chaSuccessRate;
	}

	public void setChaSuccessRate(Integer chaSuccessRate) {
		this.chaSuccessRate = chaSuccessRate;
	}

	public String getChaSummary() {
		return this.chaSummary;
	}

	public void setChaSummary(String chaSummary) {
		this.chaSummary = chaSummary;
	}

	public String getChaContext() {
		return this.chaContext;
	}

	public void setChaContext(String chaContext) {
		this.chaContext = chaContext;
	}

	public String getChaContextPhone() {
		return this.chaContextPhone;
	}

	public void setChaContextPhone(String chaContextPhone) {
		this.chaContextPhone = chaContextPhone;
	}

	public String getChaDesc() {
		return this.chaDesc;
	}

	public void setChaDesc(String chaDesc) {
		this.chaDesc = chaDesc;
	}

	public Integer getChaCreatorid() {
		return this.chaCreatorid;
	}

	public void setChaCreatorid(Integer chaCreatorid) {
		this.chaCreatorid = chaCreatorid;
	}

	public Timestamp getChaCreatetime() {
		return this.chaCreatetime;
	}

	public void setChaCreatetime(Timestamp chaCreatetime) {
		this.chaCreatetime = chaCreatetime;
	}

	public Integer getChaDispatchid() {
		return this.chaDispatchid;
	}

	public void setChaDispatchid(Integer chaDispatchid) {
		this.chaDispatchid = chaDispatchid;
	}

	public Timestamp getChaDistime() {
		return this.chaDistime;
	}

	public void setChaDistime(Timestamp chaDistime) {
		this.chaDistime = chaDistime;
	}

	public String getChaCode() {
		return this.chaCode;
	}

	public void setChaCode(String chaCode) {
		this.chaCode = chaCode;
	}

	public Integer getChaStaut() {
		return this.chaStaut;
	}

	public void setChaStaut(Integer chaStaut) {
		this.chaStaut = chaStaut;
	}

}