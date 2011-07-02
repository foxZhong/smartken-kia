package com.cms.hibernate.customer.ent;

/**
 * Cusorderitems entity. @author MyEclipse Persistence Tools
 */

public class Cusorderitems implements java.io.Serializable {

	// Fields

	private Integer itemId;
	private Integer itemCount;
	private Integer itemProdid;
	private Integer itemOrderid;
	private Double itemPrice;

	// Constructors

	/** default constructor */
	public Cusorderitems() {
	}

	/** full constructor */
	public Cusorderitems(Integer itemCount, Integer itemProdid,
			Integer itemOrderid, Double itemPrice) {
		this.itemCount = itemCount;
		this.itemProdid = itemProdid;
		this.itemOrderid = itemOrderid;
		this.itemPrice = itemPrice;
	}

	// Property accessors

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getItemCount() {
		return this.itemCount;
	}

	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}

	public Integer getItemProdid() {
		return this.itemProdid;
	}

	public void setItemProdid(Integer itemProdid) {
		this.itemProdid = itemProdid;
	}

	public Integer getItemOrderid() {
		return this.itemOrderid;
	}

	public void setItemOrderid(Integer itemOrderid) {
		this.itemOrderid = itemOrderid;
	}

	public Double getItemPrice() {
		return this.itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

}