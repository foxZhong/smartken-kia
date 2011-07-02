package com.cms.hibernate.customer.ent;

import java.sql.Timestamp;

/**
 * Cusnote entity. @author MyEclipse Persistence Tools
 */

public class Cusnote implements java.io.Serializable {

	// Fields

	private Integer noteId;
	private Integer noteCusid;
	private Integer noteUserid;
	private Timestamp noteTime;
	private String noteAddr;
	private String noteSummary;
	private String noteInfo;
	private String noteRemark;

	// Constructors

	/** default constructor */
	public Cusnote() {
	}

	/** full constructor */
	public Cusnote(Integer noteCusid, Integer noteUserid, Timestamp noteTime,
			String noteAddr, String noteSummary, String noteInfo,
			String noteRemark) {
		this.noteCusid = noteCusid;
		this.noteUserid = noteUserid;
		this.noteTime = noteTime;
		this.noteAddr = noteAddr;
		this.noteSummary = noteSummary;
		this.noteInfo = noteInfo;
		this.noteRemark = noteRemark;
	}

	// Property accessors

	public Integer getNoteId() {
		return this.noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public Integer getNoteCusid() {
		return this.noteCusid;
	}

	public void setNoteCusid(Integer noteCusid) {
		this.noteCusid = noteCusid;
	}

	public Integer getNoteUserid() {
		return this.noteUserid;
	}

	public void setNoteUserid(Integer noteUserid) {
		this.noteUserid = noteUserid;
	}

	public Timestamp getNoteTime() {
		return this.noteTime;
	}

	public void setNoteTime(Timestamp noteTime) {
		this.noteTime = noteTime;
	}

	public String getNoteAddr() {
		return this.noteAddr;
	}

	public void setNoteAddr(String noteAddr) {
		this.noteAddr = noteAddr;
	}

	public String getNoteSummary() {
		return this.noteSummary;
	}

	public void setNoteSummary(String noteSummary) {
		this.noteSummary = noteSummary;
	}

	public String getNoteInfo() {
		return this.noteInfo;
	}

	public void setNoteInfo(String noteInfo) {
		this.noteInfo = noteInfo;
	}

	public String getNoteRemark() {
		return this.noteRemark;
	}

	public void setNoteRemark(String noteRemark) {
		this.noteRemark = noteRemark;
	}

}