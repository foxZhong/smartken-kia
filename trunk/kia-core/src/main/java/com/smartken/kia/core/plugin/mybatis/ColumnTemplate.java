package com.smartken.kia.core.plugin.mybatis;

import com.smartken.kia.core.enums.FormatEnum;
import com.smartken.kia.core.jdbc.dialect.DB2Dialect;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;
import org.apache.ibatis.type.JdbcType;

public class ColumnTemplate {

	public static String DB_TYPE_VARCHAR2="VARCHAR2";
	public static String DB_TYPE_VARCHAR="VARCHAR";
	public static String DB_TYPE_CHAR="CHAR";
	public static String DB_TYPE_TEXT="TEXT";
	public static String DB_TYPE_INTEGER="INTEGER";
	public static String DB_TYPE_NUMBER="NUMBER";
	public static String MOD_TYPE_STRING="String";
	public static String MOD_TYPE_INTEGER="Integer";
	
	private String dbColName;
	private String dbColType;
	private String javaName;
	private String javaType;
	private String jdbcType;
	
	public ColumnTemplate(String dbColName){
	
		this.dbColName=dbColName;
		this.dbColType=DB_TYPE_VARCHAR;
		this.javaName=toModelColName(dbColName);
		this.javaType=MOD_TYPE_STRING;
		this.jdbcType=toJdbcType(DB_TYPE_VARCHAR);
	}
	
	public ColumnTemplate(String dbColName,String dbColType){
		this.dbColName=dbColName;
		this.dbColType=dbColType;
		this.javaName=toModelColName(dbColName);
		this.javaType=toModelType(dbColType);
		this.jdbcType=toJdbcType(dbColType);
	}
	
	public String getDbColName() {
		return dbColName;
	}
	public String getDbColType() {
		return dbColType;
	}

	
	
	public String getJavaName() {
		return javaName;
	}

	public String getJavaType() {
		return javaType;
	}

	public String getJdbcType() {
		return jdbcType;
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
		if(ObjectUtil.isInArray(lDbType.toUpperCase(), 
		    new String[]{DB_TYPE_CHAR,DB_TYPE_TEXT,DB_TYPE_VARCHAR2})
		 ){
			return MOD_TYPE_STRING;
		}else if(ObjectUtil.isInArray(lDbType.toUpperCase(), 
			    new String[]{DB_TYPE_INTEGER,DB_TYPE_NUMBER})
		 ){
			return MOD_TYPE_INTEGER;
		}
		else 
		{
			return MOD_TYPE_STRING;
		}
	}
	
	public static String toJdbcType(String lDbType){
		if(StringUtil.isBlank(lDbType))return "";
		if(ObjectUtil.isInArray(lDbType.toUpperCase(), 
		    new String[]{DB_TYPE_VARCHAR2,DB_TYPE_VARCHAR})
		 ){
			return JdbcType.VARCHAR.toString();
		}else if(ObjectUtil.isInArray(lDbType.toUpperCase(), 
			new String[]{DB_TYPE_INTEGER,DB_TYPE_NUMBER})
		 ){
			return JdbcType.INTEGER.toString();
		}
		else 
		{
		    return JdbcType.VARCHAR.toString();
		}
	}
	
	
	
	public static void main(String[] args){
		ColumnTemplate ct=new ColumnTemplate("xxxx",DB_TYPE_VARCHAR);
	}
	
}
