package com.smartken.kia.model.admin;


import com.smartken.kia.core.model.impl.BaseModel;

public class MenuModel extends BaseModel {

	public static final String TYPE_FOLDER="folder";
	public static final String TYPE_TITLE="title";
	public static final String TYPE_LINK="link";
	
	 public static enum F { 
		  Id,Name,Descp,Url,Parma,ParentId,Ordernum,Icon,Token,Folder  
		 } 

		private String Id;         //ID  VARCHAR2 100
		private String Name;         //NAME  VARCHAR2 100
		private String Descp;         //DESCP  VARCHAR2 400
		private String Url;         //URL  VARCHAR2 400
		private String Parma;         //PARMA  VARCHAR2 400
		private String ParentId;         //PARENT_ID  VARCHAR2 20
		private Integer Ordernum;         //ORDERNUM  NUMBER 38
		private String Icon;         //ICON  VARCHAR2 50
		private String Token;         //TOKEN  CHAR 3
		private String Folder;         //FOLDER  CHAR 1
		public String getId() {
			return Id;
		}
		public void setId(String id) {
			Id = id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getDescp() {
			return Descp;
		}
		public void setDescp(String descp) {
			Descp = descp;
		}
		public String getUrl() {
			return Url;
		}
		public void setUrl(String url) {
			Url = url;
		}
		public String getParma() {
			return Parma;
		}
		public void setParma(String parma) {
			Parma = parma;
		}
		public String getParentId() {
			return ParentId;
		}
		public void setParentId(String parentId) {
			ParentId = parentId;
		}
		public Integer getOrdernum() {
			return Ordernum;
		}
		public void setOrdernum(Integer ordernum) {
			Ordernum = ordernum;
		}
		public String getIcon() {
			return Icon;
		}
		public void setIcon(String icon) {
			Icon = icon;
		}
		public String getToken() {
			return Token;
		}
		public void setToken(String token) {
			Token = token;
		}
		public String getFolder() {
			return Folder;
		}
		public void setFolder(String folder) {
			Folder = folder;
		}
	
		
		
}
