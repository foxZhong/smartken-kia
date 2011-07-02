package com.cms.hibernate.sell.ent;

import java.sql.Timestamp;

/**
 * Sellplan entity. @author MyEclipse Persistence Tools
 */

public class Sellplan implements java.io.Serializable {

	// Fields

	private Integer planId;
	private Integer planChanceid;
	private Timestamp planPubdate;
	private String planContent;
	private Integer planStauts;
	private String planResult;

	// Constructors

	/** default constructor */
	public Sellplan() {
	}

	/** full constructor */
	public Sellplan(Integer planChanceid, Timestamp planPubdate,
			String planContent, Integer planStauts, String planResult) {
		this.planChanceid = planChanceid;
		this.planPubdate = planPubdate;
		this.planContent = planContent;
		this.planStauts = planStauts;
		this.planResult = planResult;
	}

	// Property accessors

	public Integer getPlanId() {
		return this.planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public Integer getPlanChanceid() {
		return this.planChanceid;
	}

	public void setPlanChanceid(Integer planChanceid) {
		this.planChanceid = planChanceid;
	}

	public Timestamp getPlanPubdate() {
		return this.planPubdate;
	}

	public void setPlanPubdate(Timestamp planPubdate) {
		this.planPubdate = planPubdate;
	}

	public String getPlanContent() {
		return this.planContent;
	}

	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}

	public Integer getPlanStauts() {
		return this.planStauts;
	}

	public void setPlanStauts(Integer planStauts) {
		this.planStauts = planStauts;
	}

	public String getPlanResult() {
		return this.planResult;
	}

	public void setPlanResult(String planResult) {
		this.planResult = planResult;
	}

}