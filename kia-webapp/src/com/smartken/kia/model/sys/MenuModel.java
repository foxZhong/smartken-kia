package com.smartken.kia.model.sys;


import com.smartken.kia.core.model.impl.BaseModel;

public class MenuModel extends BaseModel {

	public static final String TYPE_FOLDER="folder";
	public static final String TYPE_TITLE="title";
	public static final String TYPE_LINK="link";
	
	protected Object id;
	protected String name;
	protected String descp;
	protected String url;
	protected String icon;
	protected String parma;
	protected String parentId;
	protected Integer seqno;
	protected String type;
	protected String token;
	
	public Integer getSeqno() {
		return seqno;
	}
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setId(Object id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Object getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getParma() {
		return parma;
	}
	public void setParma(String parma) {
		this.parma = parma;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return id;
	}
	
}
