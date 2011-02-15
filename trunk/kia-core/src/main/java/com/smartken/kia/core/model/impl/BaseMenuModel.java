package com.smartken.kia.core.model.impl;

public abstract class BaseMenuModel extends BaseModel{
	protected Object id;
	protected String name;
	protected String descp;
	protected String url;
	protected String icon;
	protected String parma;
	protected String parentId;
	protected String token;
	
	public String getToken() {
		return token==null?"":token;
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
		return name==null?"":name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescp() {
		return descp==null?"":descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	public String getUrl() {
		return url==null?"":url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon==null?"":icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getParma() {
		return parma==null?"":parma;
	}
	public void setParma(String parma) {
		this.parma = parma;
	}
	public String getParentId() {
		return parentId==null?"":parentId;
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
