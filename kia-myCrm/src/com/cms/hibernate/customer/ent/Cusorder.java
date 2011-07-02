package com.cms.hibernate.customer.ent;

import java.sql.Timestamp;

/**
 * Cusorder entity. @author MyEclipse Persistence Tools
 */

public class Cusorder implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Integer orderCusid;
	private Timestamp orderDate;
	private String orderAddr;
	private Integer orderState;

	// Constructors

	/** default constructor */
	public Cusorder() {
	}

	/** full constructor */
	public Cusorder(Integer orderCusid, Timestamp orderDate, String orderAddr,
			Integer orderState) {
		this.orderCusid = orderCusid;
		this.orderDate = orderDate;
		this.orderAddr = orderAddr;
		this.orderState = orderState;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderCusid() {
		return this.orderCusid;
	}

	public void setOrderCusid(Integer orderCusid) {
		this.orderCusid = orderCusid;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderAddr() {
		return this.orderAddr;
	}

	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}

	public Integer getOrderState() {
		return this.orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

}