package com.smartken.kia.model.sys;

import com.smartken.kia.util.model.BaseModel;

public class MenuModel extends BaseModel {

	private String id;
	private String name;
	private String descp;
	private String url;
	private String icon;
	private String parma;
	private String parentId;
	private String token;
	public String getToken() {
		return token==null?"":token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getId() {
		return id==null?"":id;
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
}
