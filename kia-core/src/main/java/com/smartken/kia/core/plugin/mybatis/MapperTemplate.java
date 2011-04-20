package com.smartken.kia.core.plugin.mybatis;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.bcel.util.Class2HTML;
import org.w3c.dom.ls.LSResourceResolver;

import com.smartken.kia.core.enums.StringFormatEnum;
import com.smartken.kia.core.util.StringUtil;

public class MapperTemplate {

	private String table;
	private String pk;
	private ColumnTemplate pkColumn=new ColumnTemplate("");
	private ArrayList<ColumnTemplate> cols=new ArrayList<ColumnTemplate>();
	private Class namespace;
	private Class modelClass;

	public void setNamespace(Class namespace) {
		
		this.namespace = namespace;
	}

	public void setModelName(Class modelClass) {
		this.modelClass = modelClass;
	}



	private int rowCount=10;
	
	public MapperTemplate(String table,String pk,ArrayList<String> dbCols){
		this.table=table;
		this.pk=pk;
		this.pkColumn=new ColumnTemplate(pk);
        for (String dbCol : dbCols) {
			this.cols.add(new ColumnTemplate(dbCol));
		}
	}
	
	public MapperTemplate(String table,String pk,ArrayList<String> dbCols,ArrayList<String> dbTypes){
		this.table=table;
		this.pk=pk;
        for (int i = 0; i < dbCols.size(); i++) {
			this.cols.add(new ColumnTemplate(dbCols.get(i), dbTypes.get(i)));
			if(dbCols.get(i).equalsIgnoreCase(pk))
			{
				this.pkColumn=new ColumnTemplate(dbCols.get(i), dbTypes.get(i));
			}
		}
	}
	
	public MapperTemplate(String table,String pk,ArrayList<String> dbCols,ArrayList<String> dbTypes,ArrayList<Integer> precisions){
	
		this.table=table;
		this.pk=pk;
        for (int i = 0; i < dbCols.size(); i++) {
			this.cols.add(new ColumnTemplate(dbCols.get(i), dbTypes.get(i),precisions.get(i)));
			if(dbCols.get(i).equalsIgnoreCase(pk))
			{
				this.pkColumn=new ColumnTemplate(dbCols.get(i), dbTypes.get(i),precisions.get(i));
			}
		}
	}
	
	public String getPkCol(){
		String pattern="{0},jdbcType={1},javaType={2}";
		String pk=MessageFormat.format(pattern, this.pkColumn.getJavaName(),this.pkColumn.getJdbcType(),this.pkColumn.getJavaType());
		return pk;
	}
	
	public String getDbCols(){
		if(cols==null)return "";
		StringBuffer lSbrReturn=new StringBuffer("");
		int colSize=cols.size();
		for(int i=0;i<colSize;i++)
		{
			String tempCols=cols.get(i).getDbColName();
			lSbrReturn.append(tempCols);
			if(i!=colSize-1)
			{
				lSbrReturn.append(",");
				if(i%rowCount==0&&i!=0){
				    lSbrReturn.append("\n");
				}
			}

		}
		return lSbrReturn.toString();
	}
	
	public String getInsertCols(){
		if(cols==null)return "";
		StringBuffer lSbrReturn=new StringBuffer("");
		int colSize=cols.size();
		String pattern="#'{'{0},jdbcType={1},javaType={2}'}'";
		for(int i=0;i<colSize;i++){
			ColumnTemplate tempCol=cols.get(i);
			String tempStr=MessageFormat.format(pattern
					,tempCol.getJavaName()  //0
					,tempCol.getJdbcType()  //1
					,tempCol.getJavaType()  //2
			);
			lSbrReturn.append(tempStr);
			if(i!=colSize-1)
			{
				    lSbrReturn.append(",\n");

			}
		}
		return lSbrReturn.toString();
	}
	
	
	public String getUpdateCols(){
		if(cols==null)return "";
		StringBuffer lSbrReturn=new StringBuffer("");
		int colSize=cols.size();
		String pattern="{0}=#'{'{1},jdbcType={2},javaType={3}'}'";
		for(int i=0;i<colSize;i++){
			ColumnTemplate tempCol=cols.get(i);
			if(tempCol.getDbColName().equalsIgnoreCase(pk)){
				lSbrReturn.append(MessageFormat.format("<if test=\"pk neq null\">{0}=#'{'pk'}',</if>\n",pk));
				continue;
			}
			String tempStr=MessageFormat.format(pattern
					,tempCol.getDbColName()   //0
					,"model."+tempCol.getJavaName()   //1
					,tempCol.getJdbcType()  //2
					,tempCol.getJavaType()
			);
			lSbrReturn.append(tempStr);
			if(i!=colSize-1)
			{
				lSbrReturn.append(",\n");
			}
		}
		return lSbrReturn.toString();
	}
	
	public String getResultMap(){
		if(cols==null)return "";
		StringBuffer lSbrReturn=new StringBuffer("");
		int colSize=cols.size();
		String pattern="<{0} column=\"{1}\"  property=\"{2}\" jdbcType=\"{3}\" javaType=\"{4}\"/>";
		for(int i=0;i<colSize;i++){
			ColumnTemplate tempCol=cols.get(i);
			String tempStr=MessageFormat.format(pattern,
					tempCol.getDbColName().equalsIgnoreCase(this.pk)?"id":"result",  //0
					tempCol.getDbColName(),   //1
					tempCol.getJavaName(),   //2
					tempCol.getJdbcType(),   //3  
					tempCol.getJavaType()  //4
			);
			lSbrReturn.append(tempStr);
			if(i!=colSize-1)
			{
				lSbrReturn.append("\n");
			}
		}
		return lSbrReturn.toString();
	}
	

	
	public String getJavaCols(){
		if(cols==null)return "";
		StringBuffer lSbrReturn=new StringBuffer("");
		int colSize=cols.size();
		String pattern="private {0} {1};         //{2}  {3} {4}";
		for(int i=0;i<colSize;i++){
			ColumnTemplate tempCol=cols.get(i);
			String tempStr=MessageFormat.format(pattern,
					tempCol.getJavaType(),  //0
					tempCol.getJavaName()  //1
					,tempCol.getDbColName()  //2
					,tempCol.getDbColType()  //3
					,tempCol.getPrecision()  //4
			);
			lSbrReturn.append(tempStr+"\n");
		}
		return lSbrReturn.toString();
	}
	
	public String getModelCols(){
		if(cols==null)return "";
		StringBuffer lSbrReturn=new StringBuffer("");
		int colSize=cols.size();
		String pattern="{0}";
		for(int i=0;i<colSize;i++){
			ColumnTemplate tempCol=cols.get(i);
			lSbrReturn.append(tempCol.getJavaName());
			if(i!=colSize-1)
			{
				lSbrReturn.append(",");
				if(i%rowCount==0&&i!=0){
				    lSbrReturn.append("\n");
				}
			}
		}
		return lSbrReturn.toString();
	}
	
	public String getCondition(){
		if(cols==null)return "";
		StringBuffer lSbrReturn=new StringBuffer("");
		int colSize=cols.size();
		String pattern="<if test=\"model.{0} neq null\">and m.{1}=#'{'model.{0},jdbcType={2} javaType={3} '}' </if> ";
		for(int i=0;i<colSize;i++){
			ColumnTemplate tempCol=cols.get(i);
			String tempStr=MessageFormat.format(pattern,
					tempCol.getJavaName()  //0
					,tempCol.getDbColName()  //1
					,tempCol.getJdbcType()  //2
					,tempCol.getJavaType()  //3
			);
			lSbrReturn.append(tempStr+"\n");
		}
		return lSbrReturn.toString();
	}
	
	public String getPropertiesKey(){
		if(cols==null)return "";
		StringBuffer lSbrReturn=new StringBuffer("");
		int colSize=cols.size();
		String pattern="{0}.F.{1}={1}";
		for(int i=0;i<colSize;i++){
			ColumnTemplate tempCol=cols.get(i);
			String tempStr=MessageFormat.format(pattern,
					this.modelClass.getSimpleName()
					,tempCol.getJavaName()  //0
			);
			lSbrReturn.append(tempStr+"\n");
		}
		return lSbrReturn.toString();
	}
	
	
    public String getMapper(){
    	StringBuffer pattern=new StringBuffer("");
    	pattern
    	.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>").append("\n")
    	.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">").append(StringUtil.ln())
    	.append("<mapper namespace=\"{0}\">").append(StringUtil.ln(2))
    	.append("<cache flushInterval=\"30000\" readOnly=\"true\"></cache>").append(StringUtil.ln(3))
    	.append("<sql id=\"table\">{1}</sql>").append(StringUtil.ln(2))
    	.append("<sql id=\"pk\">{2}</sql>").append(StringUtil.ln(2))
    	.append("<sql id=\"colums\">\n{3} \n</sql>").append(StringUtil.ln(2))
    	.append("<sql id=\"insertCols\">\n{4} \n</sql>").append(StringUtil.ln(2))
    	.append("<sql id=\"updateCols\">\n {5}\n</sql>").append(StringUtil.ln(2))
    	.append("<sql id=\"orderby\">order by {2}</sql>").append(StringUtil.ln(2))
    	.append("<sql id=\"joinColums\"></sql>").append(StringUtil.ln(2))
    	.append("<sql id=\"join\"></sql>").append(StringUtil.ln(0))
    	.append("<!-- 别名m已被主表使用  -->").append(StringUtil.ln(2))
    	.append("<resultMap type=\"{8}\" id=\"resultMap\">\n {6}\n </resultMap>").append(StringUtil.ln(3))
    
        .append("<select id=\"select\" resultType=\"ArrayList\" resultMap=\"resultMap\">").append(StringUtil.ln())
        .append("\t select m.* <include refid=\"joinColums\"/> from <include refid=\"table\" /> m <include refid=\"join\"/> ").append(StringUtil.ln())
        .append("<trim prefix=\"where\" prefixOverrides=\"and\">\n{7}</trim>").append(StringUtil.ln())
        .append("</select>").append(StringUtil.ln())
        
        .append("<select id=\"selectEqPk\" parameterType=\"String\"  resultMap=\"resultMap\">").append(StringUtil.ln())
        .append("\t select <include refid=\"colums\"/> from <include refid=\"table\" /> m <include refid=\"join\"/> where m.<include refid=\"pk\" /> = #'{'{9}'}'").append(StringUtil.ln())
        .append("</select>").append(StringUtil.ln(2))
        
        .append("<select id=\"count\" resultType=\"int\">").append(StringUtil.ln())
        .append("\t select count(*) from <include refid=\"table\"/>").append(StringUtil.ln())
        .append("</select>").append(StringUtil.ln(2))
        
        .append("<select id=\"selectInPk\" resultType=\"ArrayList\" resultMap=\"resultMap\" >").append(StringUtil.ln())
        .append("\t select m.* <include refid=\"joinColums\"/> from <include refid=\"table\" /> m <include refid=\"join\"/> where m.<include refid=\"pk\" /> in").append(StringUtil.ln())
        .append("<foreach item=\"pk\" collection=\"list\" open=\"(\" separator=\",\" close=\")\"> #'{'pk'}' </foreach> \n<include refid=\"orderby\"/>").append(StringUtil.ln())
        .append("</select>").append(StringUtil.ln(2))
        
        .append("<select id=\"selectNotInPk\" resultType=\"ArrayList\" resultMap=\"resultMap\" >").append(StringUtil.ln())
        .append("\t select m.* <include refid=\"joinColums\"/> from <include refid=\"table\" /> m <include refid=\"join\"/> where m.<include refid=\"pk\" /> not in").append(StringUtil.ln())
        .append("<foreach item=\"pk\" collection=\"list\" open=\"(\" separator=\",\" close=\")\"> #'{'pk'}' </foreach> \n<include refid=\"orderby\"/>").append(StringUtil.ln())
        .append("</select>").append(StringUtil.ln(2))
        
        .append("<select  id=\"selectAll\"  resultType=\"ArrayList\"  resultMap=\"resultMap\">").append(StringUtil.ln())
        .append("\t select m.* <include refid=\"joinColums\"/> from  <include refid=\"table\" /> m <include refid=\"join\"/> \n <include refid=\"orderby\"/>").append(StringUtil.ln())        
        .append("</select>").append(StringUtil.ln(2))
        
        .append("<insert id=\"insertOne\" >").append(StringUtil.ln())
        .append("\t insert into <include refid=\"table\"/> ( <include refid=\"colums\"/> ) values ( <include refid=\"insertCols\"/>) ").append(StringUtil.ln())
        .append("</insert>").append(StringUtil.ln(2))
        
        .append("<update id=\"updateOne\" flushCache=\"true\" >").append(StringUtil.ln())
        .append("\t update <include refid=\"table\"/> set <include refid=\"updateCols\"/> where <include refid=\"pk\" />=#'{'model.{9}'}'").append(StringUtil.ln())        
        .append("</update>").append(StringUtil.ln(2))
        
        .append("<delete id=\"deleteInPk\" flushCache=\"true\">").append(StringUtil.ln())
        .append("\t delete from <include refid=\"table\"/> where <include refid=\"pk\" /> in").append(StringUtil.ln())
        .append("<foreach item=\"pk\" collection=\"list\" open=\"(\" separator=\",\" close=\")\">#'{'pk'}'</foreach>").append(StringUtil.ln())
        .append("</delete>").append(StringUtil.ln(2))
        
        .append("<delete id=\"deleteNotInPk\" flushCache=\"true\">").append(StringUtil.ln())
        .append("\t delete from <include refid=\"table\"/> where <include refid=\"pk\" /> not in").append(StringUtil.ln())
        .append("<foreach item=\"pk\" collection=\"list\" open=\"(\" separator=\",\" close=\")\">#'{'pk'}'</foreach>").append(StringUtil.ln())
        .append("</delete>").append(StringUtil.ln(4))      
        .append("</mapper>")
    	;
    	String lStrMapper=MessageFormat.format(pattern.toString(),
    			this.namespace.getName()  //0
    			,this.table    //1
    			,this.pk         //2
    			,this.getDbCols()  //3
    			,this.getInsertCols()  //4
    			,this.getUpdateCols()   //5
    			,this.getResultMap()   //6
    			,this.getCondition()  //7
    			,this.modelClass.getName() //8
    			,this.getPkCol()  //9
    	);
		return lStrMapper;
	   
   }
	

	
	public static void main(String[] args){

		ArrayList<String> cols=new ArrayList<String>();
		cols.add("wekk_ddd");
		cols.add("wexdfskk_ddd");
		cols.add("adafwekk_drsfdd_adff");
		cols.add("wekk_ddd");
		cols.add("wexdfskk_ddd");
		cols.add("adafwekk_drsfdd_adff");
		cols.add("wekk_ddd");
		cols.add("wexdfskk_ddd");
		cols.add("adafwekk_drsfdd_adff");
		cols.add("wekk_ddd");
		cols.add("wexdfskk_ddd");
		cols.add("adafwekk_drsfdd_adff");
		MapperTemplate mt=new MapperTemplate("xxx", "id", cols);
		
	}
	
}
