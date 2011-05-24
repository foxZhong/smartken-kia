package com.smartken.kia.core.plugin.mybatis;

import java.text.MessageFormat;
import java.util.ArrayList;

import com.smartken.kia.core.util.ObjectUtil;

final public class MySQLMapperTemplate extends MapperTemplate {

	
	public MySQLMapperTemplate(String table,String pk,ArrayList<String> dbCols,ArrayList<String> dbTypes,ArrayList<Integer> precisions){
		super(table,pk,dbCols,dbTypes,precisions);
	}

	
	
	@Override
	protected Class getSubClass() {
		// TODO Auto-generated method stub
		return this.getClass();
	}



	@Override
	public String getCondition(ColumnTemplate ct,Q q) {
		// TODO Auto-generated method stub
		String str="";
		String pattern="<if test=\"model.{0} neq null\">and m.{1}=#'{'model.{0},jdbcType={2} javaType={3} '}' </if> ";
		String datePattern="<if test=\"model.{0} neq null\">and date_format(m.{1},{4})= date_format(#'{'model.{0},jdbcType={2} javaType={3} '}',{4}) </if> ";
		String tempPattern=pattern;
		if(ObjectUtil.isInArray(ct.getDbColType().toUpperCase(), new String[]{ ColumnTemplate.DB_TYPE_DATE,ColumnTemplate.DB_TYPE_TIMESTAMP}) ){
			tempPattern=datePattern;
		}
		str =MessageFormat.format(tempPattern,
				ct.getJavaName()  //0
				,ct.getDbColName()  //1
				,ct.getJdbcType()  //2
				,ct.getJavaType().getSimpleName()  //3
				,"'%Y-%m-%d'"
		);
		return str;
	}

	@Override
	public String getInsertCol(ColumnTemplate ct) {
		// TODO Auto-generated method stub
		String pattern="#'{'{0},jdbcType={1},javaType={2}'}'";
		String str=MessageFormat.format(pattern
				,ct.getJavaName()  //0
				,ct.getJdbcType()  //1
				,ct.getJavaType().getSimpleName()  //2
		);
		return str;
	}

	@Override
	public String getUpdateCol(ColumnTemplate ct) {
		// TODO Auto-generated method stub
		String str="";
		String pattern="{0}=#'{'{1},jdbcType={2},javaType={3}'}'";
		if(ct.getDbColName().equalsIgnoreCase(pk)){
			str=MessageFormat.format("<if test=\"pk neq null\">{0}=#'{'pk'}'</if>",pk);
		
		}else{
		    str=MessageFormat.format(pattern
				,ct.getDbColName()   //0
				,"model."+ct.getJavaName()   //1
				,ct.getJdbcType()  //2
				,ct.getJavaType().getSimpleName()
		);
		}
		return str;
	}

	@Override
	public String getResultMapPol(ColumnTemplate ct) {
		// TODO Auto-generated method stub
		String str="";
		String patternId="<id column=\"{0}\"  property=\"{1}\" jdbcType=\"{2}\" javaType=\"{3}\"/>";
		String patternResult="<result column=\"{0}\"  property=\"{1}\" jdbcType=\"{2}\" javaType=\"{3}\"/>";
		String patternResult4bytes="<result column=\"{0}\"  property=\"{1}\" jdbcType=\"{2}\" />";
		if(ct.getDbColName().equalsIgnoreCase(this.pk)){
		 str=MessageFormat.format(patternId,
				ct.getDbColName(),   //1
				ct.getJavaName(),   //2
				ct.getJdbcType(),   //3  
				ct.getJavaType().getSimpleName()  //4
		  );
		}else {
		   str=MessageFormat.format(patternResult,
						ct.getDbColName(),   //1
						ct.getJavaName(),   //2
						ct.getJdbcType(),   //3  
						ct.getJavaType().getSimpleName()  //4
				  );
		}
		return str;
	}
	

}