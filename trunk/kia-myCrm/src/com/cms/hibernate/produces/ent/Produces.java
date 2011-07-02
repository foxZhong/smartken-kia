package com.cms.hibernate.produces.ent;

/**
 * Produces entity. @author MyEclipse Persistence Tools
 */

public class Produces implements java.io.Serializable {

	// Fields

	private Integer prodId;
	private String prodName;
	private Double prodPrice;
	private String prodType;
	private String prodLevel;
	private String prodInfo;
	private String prodUnit;

	// Constructors

	/** default constructor */
	public Produces() {
	}

	/** full constructor */
	public Produces(String prodName, Double prodPrice, String prodType,
			String prodLevel, String prodInfo, String prodUnit) {
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodType = prodType;
		this.prodLevel = prodLevel;
		this.prodInfo = prodInfo;
		this.prodUnit = prodUnit;
	}

	// Property accessors

	public Integer getProdId() {
		return this.prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Double getProdPrice() {
		return this.prodPrice;
	}

	public void setProdPrice(Double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdType() {
		return this.prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public String getProdLevel() {
		return this.prodLevel;
	}

	public void setProdLevel(String prodLevel) {
		this.prodLevel = prodLevel;
	}

	public String getProdInfo() {
		return this.prodInfo;
	}

	public void setProdInfo(String prodInfo) {
		this.prodInfo = prodInfo;
	}

	public String getProdUnit() {
		return this.prodUnit;
	}

	public void setProdUnit(String prodUnit) {
		this.prodUnit = prodUnit;
	}

}