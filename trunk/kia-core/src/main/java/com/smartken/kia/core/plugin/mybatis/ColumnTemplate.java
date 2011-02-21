package com.smartken.kia.core.plugin.mybatis;

import com.smartken.kia.core.enums.FormatEnum;
import com.smartken.kia.core.jdbc.dialect.DB2Dialect;
import com.smartken.kia.core.util.StringUtil;

public class ColumnTemplate {

	public static String DB_TYPE_VARCHAR="varchar2";
	public static String DB_TYPE_INTEGER="number";
	public static String MOD_TYPE_STRING="String";
	public static String MOD_TYPE_INTEGER="Integer";
	
	private String dbColName;
	private String dbColType;
	private String modColName;
	private String modColType;
	
	public ColumnTemplate(String dbColName){
		this.dbColName=dbColName;
		this.dbColType=DB_TYPE_VARCHAR;
		this.modColName=toModelColName(dbColName);
		this.modColType=MOD_TYPE_STRING;
	}
	
	public ColumnTemplate(String dbColName,String dbColType){
		this.dbColName=dbColName;
		this.dbColType=dbColType;
		this.modColName=toModelColName(dbColName);
		this.modColType=toModelType(dbColType);
	}
	
	public String getDbColName() {
		return dbColName;
	}
	public String getDbColType() {
		return dbColType;
	}
	public String getModColName() {
		return modColName;
	}
	public String getModColType() {
		return modColType;
	}
	
	
	public static String toModelColName(String lStrDbColName)
	{
		if(StringUtil.isBlank(lStrDbColName))return "";
		StringBuffer lSbrModelColName=new StringBuffer("");
		String[] lSubNames=lStrDbColName.split("_");
		for (int i = 0; i < lSubNames.length; i++) {
			String lSubName=lSubNames[i].toLowerCase();
			if(i==0){
				if(lSubName.length()>1){
					lSbrModelColName.append(lSubName);
				}
			}else if(i==1 && lSbrModelColName.length()==0)
			{
				lSbrModelColName.append(lSubName);
			}
			else{
			lSbrModelColName.append(StringUtil.format(lSubName, FormatEnum.UPCASE_FIRST));
			}
		}
		return lSbrModelColName.toString();
	}
	
	
	public static String toModelType(String lDbType){
		if(StringUtil.isBlank(lDbType))return "";
		if(lDbType.equalsIgnoreCase(DB_TYPE_VARCHAR)){
			return MOD_TYPE_STRING;
		}else if(lDbType.equalsIgnoreCase(DB_TYPE_INTEGER)){
			return MOD_TYPE_INTEGER;
		}
		else 
		{
			return MOD_TYPE_STRING;
		}
	}
	
	public static void main(String[] args){
		ColumnTemplate ct=new ColumnTemplate("xxxx",DB_TYPE_VARCHAR);
	}
	
}
