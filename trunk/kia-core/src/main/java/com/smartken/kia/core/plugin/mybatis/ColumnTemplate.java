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
	
	
	final public static String DB_TYPE_VARCHAR2="VARCHAR2";
	final public static String DB_TYPE_VARCHAR="VARCHAR";
	final public static String DB_TYPE_CHAR="CHAR";
	final public static String DB_TYPE_TEXT="TEXT";
	final public static String DB_TYPE_INTEGER="INTEGER";
	final public static String DB_TYPE_INT="INT";
	final public static String DB_TYPE_NUMBER="NUMBER";
	final public static String DB_TYPE_FLOAT="FLOAT";
	final public static String DB_TYPE_DOUBLE="DOUBLE";
	final public static String DB_TYPE_DATE="DATE";
	final public static String DB_TYPE_TIME="TIME";
	final public static String DB_TYPE_DATETIME="DATETIME";
	final public static String DB_TYPE_TIMESTAMP="TIMESTAMP";
	final public static String DB_TYPE_BLOB="BLOB";
	final public static String DB_TYPE_LONGBLOB="LONGBLOB";


	final public static JdbcType[]  JDBC_TYPES_STRING;
	final public static JdbcType[]  JDBC_TYPES_DATE;
	final public static JdbcType[]  JDBC_TYPES_TIMESTAMP;
	final public static JdbcType[]  JDBC_TYPES_BYTES;
	
	static{
		JDBC_TYPES_STRING=new JdbcType[]{JdbcType.VARCHAR,JdbcType.CHAR};
		JDBC_TYPES_DATE=new JdbcType[]{JdbcType.DATE};
		JDBC_TYPES_TIMESTAMP=new JdbcType[]{JdbcType.TIMESTAMP};
		JDBC_TYPES_BYTES=new JdbcType[]{JdbcType.BLOB,JdbcType.CLOB};
	}

	
	public static final int PREC_FLOAT=126;
	public static final int PREC_INTEGER=38;
	
	private String dbColName;
	private String dbColType;
	private String javaName;
	private Class javaType;
	private JdbcType jdbcType;
	private int precision;
	

	
	public ColumnTemplate(String dbColName,String dbColType,int perc){
		this.dbColName=dbColName;
		this.dbColType=dbColType;
		this.precision=perc;
		this.javaName=getJavaColName(dbColName);
		//this.javaType=toJavaType(dbColType);
		//this.jdbcType=toJdbcType(dbColType);
		try {
			JdbcType enumJdbcType=this.getJdbcType(dbColType, perc);
			Class clsJavaType=this.getJavaClass(enumJdbcType);
			this.jdbcType=enumJdbcType;
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

	public JdbcType getJdbcType() {
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
	
	

	
	
	private static Map<String, JdbcType> mapJdbcEnum;
	private static Map<Enum, Class> mapJavaClass;
	
	public static JdbcType getJdbcType(String dbType,int perc) throws Exception{
		if(dbType==null)throw new Exception();
	 	JdbcType jdbcType=null;
	 	if(mapJdbcEnum==null){
	 		mapJdbcEnum=new HashMap<String, JdbcType>();
	 		mapJdbcEnum.put(DB_TYPE_CHAR, JdbcType.CHAR);
	 		mapJdbcEnum.put(DB_TYPE_VARCHAR, JdbcType.VARCHAR);
	 		mapJdbcEnum.put(DB_TYPE_VARCHAR2, JdbcType.VARCHAR);
	 		mapJdbcEnum.put(DB_TYPE_TEXT, JdbcType.VARCHAR);
	 		mapJdbcEnum.put(DB_TYPE_DOUBLE, JdbcType.DOUBLE);
	 		mapJdbcEnum.put(DB_TYPE_FLOAT, JdbcType.FLOAT);
	 		mapJdbcEnum.put(DB_TYPE_INTEGER, JdbcType.INTEGER);
	 		mapJdbcEnum.put(DB_TYPE_INT, JdbcType.INTEGER);
	 		mapJdbcEnum.put(DB_TYPE_DATE, JdbcType.DATE);
	 		mapJdbcEnum.put(DB_TYPE_DATETIME, JdbcType.DATE);
	 		mapJdbcEnum.put(DB_TYPE_TIME, JdbcType.TIME);
	 		mapJdbcEnum.put(DB_TYPE_TIMESTAMP, JdbcType.TIMESTAMP);
	 		mapJdbcEnum.put(DB_TYPE_BLOB, JdbcType.BLOB);
	 		mapJdbcEnum.put(DB_TYPE_LONGBLOB, JdbcType.BLOB);
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
	 		mapJavaClass.put(JdbcType.DOUBLE,Double.class);
	 		mapJavaClass.put(JdbcType.FLOAT,Float.class);
	 		mapJavaClass.put(JdbcType.INTEGER,Integer.class);
	 		mapJavaClass.put(JdbcType.DATE,Date.class);
	 		mapJavaClass.put(JdbcType.TIME,Date.class);
	 		mapJavaClass.put(JdbcType.TIMESTAMP,Timestamp.class);
	 		mapJavaClass.put(JdbcType.BLOB, Byte.class);
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
