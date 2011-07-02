package com.cms.hibernate.customer.ent;

import java.sql.Timestamp;

/**
 * Customers entity. @author MyEclipse Persistence Tools
 */

public class Customers implements java.io.Serializable {

	// Fields

	private Integer cusId;
	private Integer cusUserid;
	private String cusName;
	private Integer cusArea;
	private Integer cusLevel;
	private Integer cusContentment;
	private Integer cusCredit;
	private String cusAddress;
	private Integer cusPostalcode;
	private String cusTel;
	private String cusFax;
	private String cusSite;
	private String cusEnrol;
	private String cusCorporation;
	private Integer cusBankroll;
	private Integer cusTurnover;
	private String cusBank;
	private String cusBankAccouts;
	private String cusTerraTax;
	private String cusCountryTax;
	private Integer cusStatus;
	private Timestamp cusLosedate;
	private Integer cusManid;
	private String cusLoseinfo;
	private String cusLosedelay;

	// Constructors

	/** default constructor */
	public Customers() {
	}

	/** full constructor */
	public Customers(Integer cusUserid, String cusName, Integer cusArea,
			Integer cusLevel, Integer cusContentment, Integer cusCredit,
			String cusAddress, Integer cusPostalcode, String cusTel,
			String cusFax, String cusSite, String cusEnrol,
			String cusCorporation, Integer cusBankroll, Integer cusTurnover,
			String cusBank, String cusBankAccouts, String cusTerraTax,
			String cusCountryTax, Integer cusStatus, Timestamp cusLosedate,
			Integer cusManid, String cusLoseinfo, String cusLosedelay) {
		this.cusUserid = cusUserid;
		this.cusName = cusName;
		this.cusArea = cusArea;
		this.cusLevel = cusLevel;
		this.cusContentment = cusContentment;
		this.cusCredit = cusCredit;
		this.cusAddress = cusAddress;
		this.cusPostalcode = cusPostalcode;
		this.cusTel = cusTel;
		this.cusFax = cusFax;
		this.cusSite = cusSite;
		this.cusEnrol = cusEnrol;
		this.cusCorporation = cusCorporation;
		this.cusBankroll = cusBankroll;
		this.cusTurnover = cusTurnover;
		this.cusBank = cusBank;
		this.cusBankAccouts = cusBankAccouts;
		this.cusTerraTax = cusTerraTax;
		this.cusCountryTax = cusCountryTax;
		this.cusStatus = cusStatus;
		this.cusLosedate = cusLosedate;
		this.cusManid = cusManid;
		this.cusLoseinfo = cusLoseinfo;
		this.cusLosedelay = cusLosedelay;
	}

	// Property accessors

	public Integer getCusId() {
		return this.cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public Integer getCusUserid() {
		return this.cusUserid;
	}

	public void setCusUserid(Integer cusUserid) {
		this.cusUserid = cusUserid;
	}

	public String getCusName() {
		return this.cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public Integer getCusArea() {
		return this.cusArea;
	}

	public void setCusArea(Integer cusArea) {
		this.cusArea = cusArea;
	}

	public Integer getCusLevel() {
		return this.cusLevel;
	}

	public void setCusLevel(Integer cusLevel) {
		this.cusLevel = cusLevel;
	}

	public Integer getCusContentment() {
		return this.cusContentment;
	}

	public void setCusContentment(Integer cusContentment) {
		this.cusContentment = cusContentment;
	}

	public Integer getCusCredit() {
		return this.cusCredit;
	}

	public void setCusCredit(Integer cusCredit) {
		this.cusCredit = cusCredit;
	}

	public String getCusAddress() {
		return this.cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	public Integer getCusPostalcode() {
		return this.cusPostalcode;
	}

	public void setCusPostalcode(Integer cusPostalcode) {
		this.cusPostalcode = cusPostalcode;
	}

	public String getCusTel() {
		return this.cusTel;
	}

	public void setCusTel(String cusTel) {
		this.cusTel = cusTel;
	}

	public String getCusFax() {
		return this.cusFax;
	}

	public void setCusFax(String cusFax) {
		this.cusFax = cusFax;
	}

	public String getCusSite() {
		return this.cusSite;
	}

	public void setCusSite(String cusSite) {
		this.cusSite = cusSite;
	}

	public String getCusEnrol() {
		return this.cusEnrol;
	}

	public void setCusEnrol(String cusEnrol) {
		this.cusEnrol = cusEnrol;
	}

	public String getCusCorporation() {
		return this.cusCorporation;
	}

	public void setCusCorporation(String cusCorporation) {
		this.cusCorporation = cusCorporation;
	}

	public Integer getCusBankroll() {
		return this.cusBankroll;
	}

	public void setCusBankroll(Integer cusBankroll) {
		this.cusBankroll = cusBankroll;
	}

	public Integer getCusTurnover() {
		return this.cusTurnover;
	}

	public void setCusTurnover(Integer cusTurnover) {
		this.cusTurnover = cusTurnover;
	}

	public String getCusBank() {
		return this.cusBank;
	}

	public void setCusBank(String cusBank) {
		this.cusBank = cusBank;
	}

	public String getCusBankAccouts() {
		return this.cusBankAccouts;
	}

	public void setCusBankAccouts(String cusBankAccouts) {
		this.cusBankAccouts = cusBankAccouts;
	}

	public String getCusTerraTax() {
		return this.cusTerraTax;
	}

	public void setCusTerraTax(String cusTerraTax) {
		this.cusTerraTax = cusTerraTax;
	}

	public String getCusCountryTax() {
		return this.cusCountryTax;
	}

	public void setCusCountryTax(String cusCountryTax) {
		this.cusCountryTax = cusCountryTax;
	}

	public Integer getCusStatus() {
		return this.cusStatus;
	}

	public void setCusStatus(Integer cusStatus) {
		this.cusStatus = cusStatus;
	}

	public Timestamp getCusLosedate() {
		return this.cusLosedate;
	}

	public void setCusLosedate(Timestamp cusLosedate) {
		this.cusLosedate = cusLosedate;
	}

	public Integer getCusManid() {
		return this.cusManid;
	}

	public void setCusManid(Integer cusManid) {
		this.cusManid = cusManid;
	}

	public String getCusLoseinfo() {
		return this.cusLoseinfo;
	}

	public void setCusLoseinfo(String cusLoseinfo) {
		this.cusLoseinfo = cusLoseinfo;
	}

	public String getCusLosedelay() {
		return this.cusLosedelay;
	}

	public void setCusLosedelay(String cusLosedelay) {
		this.cusLosedelay = cusLosedelay;
	}

}