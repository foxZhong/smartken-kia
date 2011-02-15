package com.trusteach.drv.model;

import com.smartken.kia.core.model.impl.BaseModel;

public class DictModel extends BaseModel {

	private Integer id;
	private String typeName;
	private String dictText;
	private String dictValue;
	private String desc1;
	private String desc2;
	private String desc3;
	private String state;

	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getTypeName() {
		return typeName;
	}



	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



	public String getDictText() {
		return dictText;
	}



	public void setDictText(String dictText) {
		this.dictText = dictText;
	}



	public String getDictValue() {
		return dictValue;
	}



	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}



	public String getDesc1() {
		return desc1;
	}



	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}



	public String getDesc2() {
		return desc2;
	}



	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}



	public String getDesc3() {
		return desc3;
	}



	public void setDesc3(String desc3) {
		this.desc3 = desc3;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	@Override
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
