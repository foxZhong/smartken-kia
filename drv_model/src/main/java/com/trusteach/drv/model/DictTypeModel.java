package com.trusteach.drv.model;

import com.smartken.kia.core.model.impl.BaseModel;

public class DictTypeModel extends BaseModel{

	private Integer id;
	private String cTypeName;
	private String cTypeDescription;
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getcTypeName() {
		return cTypeName;
	}



	public void setcTypeName(String cTypeName) {
		this.cTypeName = cTypeName;
	}



	public String getcTypeDescription() {
		return cTypeDescription;
	}



	public void setcTypeDescription(String cTypeDescription) {
		this.cTypeDescription = cTypeDescription;
	}



	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

}
