package com.smartken.kia.core.plugin.mybatis;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.Bidi;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.smartken.kia.core.enums.StringFormatEnum;
import com.smartken.kia.core.jdbc.dialect.DB2Dialect;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;
import org.apache.ibatis.type.JdbcType;

public class ColumnTemplate {

	public static enum MysqlJdbcType{
		TEXT,DATETIME
	}
	
	
	public static String DB_TYPE_VARCHAR2="VARCHAR2";
	public static String DB_TYPE_VARCHAR="VARCHAR";
	public static String DB_TYPE_CHAR="CHAR";
	public static String DB_TYPE_TEXT="TEXT";
	public static String DB_TYPE_INTEGER="INTEGER";
	public static String DB_TYPE_INT="INT";
	public static String DB_TYPE_NUMBER="NUMBER";
	public static String DB_TYPE_FLOAT="FLOAT";
	public static String DB_TYPE_DOUBLE="DOUBLE";
	public static String DB_TYPE_DATE="DATE";
	public static String DB_TYPE_TIME="TIME";
	public static String DB_TYPE_DATETIME="DATETIME";
	public static String DB_TYPE_TIMESTAMP="TIMESTAMP";
	public static String DB_TYPE_BLOB="BLOB";
	public static String DB_TYPE_LONGBLOB="LONGBLOB";
	public static String JAVA_TYPE_STRING="String";
	public static String JAVA_TYPE_INTEGER="Integer";
	public static String JAVA_TYPE_BYTES="byte[]";

	public static String[] DB_TYPES_CHAR=new String[]{DB_TYPE_VARCHAR2,DB_TYPE_VARCHAR,DB_TYPE_CHAR,DB_TYPE_TEXT};
	public static String[] DB_TYPES_NUMBER=new String[]{DB_TYPE_INT,DB_TYPE_INTEGER,DB_TYPE_NUMBER,DB_TYPE_FLOAT,DB_TYPE_DOUBLE};
	public static String[] DB_TYPES_DATETIME=new String[]{DB_TYPE_DATE,DB_TYPE_TIME,DB_TYPE_DATETIME,DB_TYPE_TIMESTAMP};
	
	public static final int PREC_FLOAT=126;
	public static final int PREC_INTEGER=38;
	
	private String dbColName;
	private String dbColType;
	private String javaName;
	private Class javaType;
	private String jdbcType;
	private int precision;
	

	
	public ColumnTemplate(String dbColName,String dbColType,int perc){
		this.dbColName=dbColName;
		this.dbColType=dbColType;
		this.precision=perc;
		this.javaName=getJavaColName(dbColName);
		//this.javaType=toJavaType(dbColType);
		//this.jdbcType=toJdbcType(dbColType);
		try {
			Enum enumJdbcType=this.getJdbcType(dbColType, perc);
			Class clsJavaType=this.getJavaClass(enumJdbcType);
			this.jdbcType=enumJdbcType.name();
			this.javaType=clsJavaType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public Class getJavaType() {
		return javaType;
	}

	public String getJdbcType() {
		return jdbcType;
	}

	public int getPrecision() {
		return precision;
	}

	public static String getJavaColName(String lStrDbColName)
	{
		if(StringUtil.isBlank(lStrDbColName))return "";
		StringBuffer lSbrModelColName=new StringBuffer("");
		String[] lSubNames=lStrDbColName.split("_");
		boolean isFirstSubNameLen1=false;
		for (int i = 0; i < lSubNames.length; i++) {
			String lSubName=lSubNames[i].toLowerCase();
//			if(i==0){
//				isFirstSubNameLen1=lSbrModelColName.length()==1;
//				if(isFirstSubNameLen1){
//					lSbrModelColName.append(lSubName.toUpperCase());
//				}else{
//					lSbrModelColName.append(lSubName);
//				}
//			}
//			else{
			   lSbrModelColName.append(StringUtil.format(lSubName, StringFormatEnum.upcaseFirstChar));
//			}
		}
		return lSbrModelColName.toString();
	}
	
	

	
	
	private static Map<String, Enum> mapJdbcEnum;
	private static Map<Enum, Class> mapJavaClass;
	
	public static Enum getJdbcType(String dbType,int perc) throws Exception{
		if(dbType==null)throw new Exception();
	 	Enum jdbcType=null;
	 	if(mapJdbcEnum==null){
	 		mapJdbcEnum=new HashMap<String, Enum>();
	 		mapJdbcEnum.put(DB_TYPE_CHAR, JdbcType.CHAR);
	 		mapJdbcEnum.put(DB_TYPE_VARCHAR, JdbcType.VARCHAR);
	 		mapJdbcEnum.put(DB_TYPE_VARCHAR2, JdbcType.VARCHAR);
	 		mapJdbcEnum.put(DB_TYPE_TEXT, MysqlJdbcType.TEXT);
	 		mapJdbcEnum.put(DB_TYPE_DOUBLE, JdbcType.DOUBLE);
	 		mapJdbcEnum.put(DB_TYPE_FLOAT, JdbcType.FLOAT);
	 		mapJdbcEnum.put(DB_TYPE_INTEGER, JdbcType.INTEGER);
	 		mapJdbcEnum.put(DB_TYPE_INT, JdbcType.INTEGER);
	 		mapJdbcEnum.put(DB_TYPE_DATE, JdbcType.DATE);
	 		mapJdbcEnum.put(DB_TYPE_DATETIME, JdbcType.DATE);
	 		mapJdbcEnum.put(DB_TYPE_TIME, JdbcType.TIME);
	 		mapJdbcEnum.put(DB_TYPE_TIMESTAMP, JdbcType.TIMESTAMP);
	 	}
	 	if(DB_TYPE_NUMBER.equalsIgnoreCase(dbType)){
			if(perc<=PREC_INTEGER){
				jdbcType=JdbcType.INTEGER;
			}else if(perc<=PREC_FLOAT){
				jdbcType=JdbcType.FLOAT;
			}
			else {
				jdbcType=JdbcType.DOUBLE;
			}
	 	}else{
		 	jdbcType=mapJdbcEnum.get(dbType);
	 	}
	 	if(jdbcType==null){
		 	  String errMsg=MessageFormat.format("dbType:{0} can't ref to JdbcType",dbType );
		 	  throw new Exception(errMsg);
		} 
	 	return jdbcType;
	}
	
	public static Class getJavaClass(Enum jdbcType) throws Exception{
	 	Class javaClass=null;
	 	if(mapJavaClass==null){
	 		mapJavaClass=new HashMap<Enum, Class>();
	 		mapJavaClass.put(JdbcType.CHAR,String.class);
	 		mapJavaClass.put(JdbcType.VARCHAR,String.class);
	 		mapJavaClass.put(MysqlJdbcType.TEXT, String.class);
	 		mapJavaClass.put(JdbcType.DOUBLE,Double.class);
	 		mapJavaClass.put(JdbcType.FLOAT,Double.class);
	 		mapJavaClass.put(JdbcType.INTEGER,Integer.class);
	 		mapJavaClass.put(JdbcType.DATE,Date.class);
	 		mapJavaClass.put(JdbcType.TIME,Date.class);
	 		mapJavaClass.put(JdbcType.TIMESTAMP,Timestamp.class);
	 	}
	 	javaClass=mapJavaClass.get(jdbcType);
	 	if(javaClass==null){
		 	  String errMsg=MessageFormat.format("jdbcType:{0} can't ref to JavaClass",jdbcType );
		 	  throw new Exception(errMsg);
		} 
	 	return javaClass;
	}
	
	
	
	
	public static void main(String[] args){
		//ColumnTemplate ct=new ColumnTemplate("xxxx",DB_TYPE_VARCHAR);
	}
	
}
