package com.cms.hibernate.produces.ent;

/**
 * StorageShelfitems entity. @author MyEclipse Persistence Tools
 */

public class StorageShelfitems implements java.io.Serializable {

	// Fields

	private Integer sitemId;
	private Integer sitemShelfid;
	private Integer sitemProdid;
	private Integer sitemCount;

	// Constructors

	/** default constructor */
	public StorageShelfitems() {
	}

	/** full constructor */
	public StorageShelfitems(Integer sitemShelfid, Integer sitemProdid,
			Integer sitemCount) {
		this.sitemShelfid = sitemShelfid;
		this.sitemProdid = sitemProdid;
		this.sitemCount = sitemCount;
	}

	// Property accessors

	public Integer getSitemId() {
		return this.sitemId;
	}

	public void setSitemId(Integer sitemId) {
		this.sitemId = sitemId;
	}

	public Integer getSitemShelfid() {
		return this.sitemShelfid;
	}

	public void setSitemShelfid(Integer sitemShelfid) {
		this.sitemShelfid = sitemShelfid;
	}

	public Integer getSitemProdid() {
		return this.sitemProdid;
	}

	public void setSitemProdid(Integer sitemProdid) {
		this.sitemProdid = sitemProdid;
	}

	public Integer getSitemCount() {
		return this.sitemCount;
	}

	public void setSitemCount(Integer sitemCount) {
		this.sitemCount = sitemCount;
	}

}