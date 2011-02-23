package com.smartken.kia.core.plugin.mybatis;

import java.math.BigDecimal;
import java.text.Bidi;
import java.util.Date;

import com.smartken.kia.core.enums.StringFormatEnum;
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
	public static String DB_TYPE_FLOAT="FLOAT";
	public static String DB_TYPE_DATE="DATE";
	public static String MOD_TYPE_STRING="String";
	public static String MOD_TYPE_INTEGER="Integer";

	public static final int PREC_FLOAT=126;
	public static final int PREC_INTEGER=38;
	
	private String dbColName;
	private String dbColType;
	private String javaName;
	private String javaType;
	private String jdbcType;
	private int precision;
	
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
	
	public ColumnTemplate(String dbColName,String dbColType,int perc){
		this.dbColName=dbColName;
		this.dbColType=dbColType;
		this.precision=perc;
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

	public int getPrecision() {
		return precision;
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
			lSbrModelColName.append(StringUtil.format(lSubName, StringFormatEnum.upcaseFirstChar));
			}
		}
		return lSbrModelColName.toString();
	}
	
	
	public String toModelType(String lDbType){
		if(StringUtil.isBlank(lDbType))return "";
		if(ObjectUtil.isInArray(lDbType.toUpperCase(), 
		    new String[]{DB_TYPE_CHAR,DB_TYPE_TEXT,DB_TYPE_VARCHAR2})
		 ){
			return String.class.getSimpleName();
		}else if(ObjectUtil.isInArray(lDbType.toUpperCase(), new String[]{DB_TYPE_INTEGER,DB_TYPE_NUMBER,DB_TYPE_FLOAT})){
			String re="";
			switch (this.precision) {
			case PREC_FLOAT: re= Float.class.getSimpleName(); break;
			case PREC_INTEGER: re= Integer.class.getSimpleName();break;
			default:re= Integer.class.getSimpleName();break;
			}
			return re;
		}else if(ObjectUtil.isInArray(lDbType.toUpperCase(), 
                new String[]{DB_TYPE_DATE}  )
        ){
			return Date.class.getSimpleName();
		}
		else 
		{
			return String.class.getSimpleName();
		}
	}
	
	public String toJdbcType(String lDbType){
		if(StringUtil.isBlank(lDbType))return "";
		if(ObjectUtil.isInArray(lDbType.toUpperCase(), 
		    new String[]{DB_TYPE_VARCHAR2,DB_TYPE_VARCHAR})
		 ){
			return JdbcType.VARCHAR.toString();
		}else if(ObjectUtil.isInArray(lDbType.toUpperCase(), new String[]{DB_TYPE_INTEGER,DB_TYPE_NUMBER,DB_TYPE_FLOAT}) ){
			switch (this.precision) {
			case PREC_FLOAT: return JdbcType.FLOAT.toString();
			case PREC_INTEGER: return JdbcType.INTEGER.toString();
			default:return JdbcType.INTEGER.toString();
			}
		}
		else if(ObjectUtil.isInArray(lDbType.toUpperCase(), 
				new String[]{DB_TYPE_DATE})
		 ){
			return JdbcType.DATE.toString();
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
