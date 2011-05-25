package com.smartken.kia.core.plugin.mybatis;

import java.text.MessageFormat;
import java.util.ArrayList;

import com.smartken.kia.core.util.ObjectUtil;

final public class MySQLMapperTemplate extends MapperTemplate {

	
	public MySQLMapperTemplate(String table,String pk,ArrayList<String> dbCols,ArrayList<String> dbTypes,ArrayList<Integer> precisions){
		super(table,pk,dbCols,dbTypes,precisions);
	}

	public MySQLMapperTemplate(String table,String pk,ArrayList<String> dbCols,ArrayList<String> dbTypes,ArrayList<Integer> precisions,String idGerner){
		super(table,pk,dbCols,dbTypes,precisions,idGerner);
	}
	
	@Override
	protected Class getSubClass() {
		// TODO Auto-generated method stub
		return this.getClass();
	}



	@Override
	public String getCondition(ColumnTemplate ct) {
		// TODO Auto-generated method stub
		String str="";
		String pattern="<if test=\"model.{0} neq null\">and m.{1} = #'{'model.{0},jdbcType={2} javaType={3} '}' </if> ";
		String patternLike="<if test=\"model.{0} neq null\">and m.{1} like #'{'model.{0},jdbcType={2} javaType={3} '}' </if> ";
		String datePattern="<if test=\"model.{0} neq null\">and date_format(m.{1},{4})= date_format(#'{'model.{0},jdbcType={2} javaType={3} '}',{4}) </if> ";
		String tempPattern=pattern;		
		if(ObjectUtil.isInArray(ct.getJdbcType(), ColumnTemplate.JDBC_TYPES_DATE )
		 ||ObjectUtil.isInArray(ct.getJdbcType(), ColumnTemplate.JDBC_TYPES_TIMESTAMP )
		){
			tempPattern=datePattern;
		}else if(ObjectUtil.isInArray(ct.getJdbcType(),ColumnTemplate.JDBC_TYPES_STRING)){
			tempPattern=patternLike;
		}
		str =MessageFormat.format(tempPattern,
				ct.getJavaName()  //0
				,ct.getDbColName()  //1
				,ct.getJdbcType()  //2
				,ct.getJavaType().getSimpleName()  //3
				,"'YYYY-MM-DD'"   //4
		);
		return str;
	}



	
}
