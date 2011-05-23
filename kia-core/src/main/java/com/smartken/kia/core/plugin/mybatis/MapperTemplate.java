package com.smartken.kia.core.plugin.mybatis;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import org.w3c.dom.ls.LSResourceResolver;

import com.smartken.kia.core.enums.CodeEnum;
import com.smartken.kia.core.enums.StringFormatEnum;
import com.smartken.kia.core.util.FileUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;

public abstract class MapperTemplate {

	protected static enum Q{
		lt,lte,gte,gt,like,neq
	}
	
	private static Map<Enum<Q>, String> mapQ2Symbol;
	
	public static String getSymbol(Enum<Q> en){
		if(mapQ2Symbol==null){
			mapQ2Symbol=new HashMap<Enum<Q>, String>();
			mapQ2Symbol.put(Q.lt, "&lt;");
			mapQ2Symbol.put(Q.lte,"&lt;=");
			mapQ2Symbol.put(Q.gt, "&gt;");
			mapQ2Symbol.put(Q.gte,"&gt;=");
			mapQ2Symbol.put(Q.like,"like");
			mapQ2Symbol.put(Q.neq,"!=");
			//mapQ2Symbol.put(Q.eq,"=");
		}
		return mapQ2Symbol.get(en); 
	}
	
	
	protected static String XML_UTF8="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";
	protected static String DOCTYPE_MYBATIS3="<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">";
	protected static String TAG_TRIM_CONDITIOM_START="<trim prefix=\"where 1=2 or (\" suffix=\")\" prefixOverrides=\"and|or\" suffixOverrides=\"and|or\">";
	protected static String TAG_TRIM_COMMA_START="<trim  prefixOverrides=\",\" suffixOverrides=\",\">";
	protected static String TAG_TRIM_UNION_START="<trim  prefixOverrides=\"union\" suffixOverrides=\"union\">";
	protected static String TAG_TRIM_END="</trim>";
	protected static String TAG_IF_END="</if>";
	protected static String TAG_FOREACH_END="</foreach>";
	protected static String TAG_SQL_END="</sql>";
	protected static String TAG_SELECT_END="</select>";
	protected static String TAG_UPDATE_END="</update>";
	protected static String TAG_INSERT_END="</insert>";
	protected static String TAG_DELETE_END="</delete>";
	protected static String SQL_ID_SELECT_CONDITION="selectCondition";
	protected static String SQL_ID_SELECT_VIEW_CONDITION="selectViewCondition";
	protected static String SQL_ID_SELECT_ORDERBY="orderby";
	protected static String TAG_INCLUDE(String id){
		return "<include refid=\""+id+"\"/>";
	}
	
	protected String table;
	protected String pk;
	protected ColumnTemplate pkColumn;
	protected ArrayList<ColumnTemplate> cols=new ArrayList<ColumnTemplate>();
	protected Class namespace;
	protected Class modelClass;

	public void setNamespace(Class namespace) {
		
		this.namespace = namespace;
	}

	public void setModelName(Class modelClass) {
		this.modelClass = modelClass;
	}

    protected abstract Class getSubClass();

	private int rowCount=10;
	
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
		String pk=MessageFormat.format(pattern, this.pkColumn.getJavaName(),this.pkColumn.getJdbcType(),this.pkColumn.getJavaType().getSimpleName());
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
	
	public abstract String getInsertCol(ColumnTemplate ct);
	
	public String getInsertCols(){
		if(cols==null)return "";
		StringBuffer lSbrReturn=new StringBuffer("");
		int colSize=cols.size();
		//String pattern="#'{'{0},jdbcType={1},javaType={2}'}'";
		for(int i=0;i<colSize;i++){
			ColumnTemplate tempCol=cols.get(i);
			String tempStr=this.getInsertCol(tempCol);
			lSbrReturn.append(tempStr).append(",\n");
		}
		return lSbrReturn.toString();
	}
	
	public abstract String getUpdateCol(ColumnTemplate ct);
	
	public String getUpdateCols(){
		if(cols==null)return "";
		StringBuffer lSbrReturn=new StringBuffer("");
		int colSize=cols.size();
		//String pattern="{0}=#'{'{1},jdbcType={2},javaType={3}'}'";
		for(int i=0;i<colSize;i++){
			ColumnTemplate tempCol=cols.get(i);
			String tempStr=this.getUpdateCol(tempCol);
			lSbrReturn.append(tempStr).append(",\n");
		}
		return lSbrReturn.toString();
	}
	
	public abstract String getResultMapPol(ColumnTemplate ct);
	
	public String getResultMapPols(){
		if(cols==null)return "";
		StringBuffer lSbrReturn=new StringBuffer("");
		int colSize=cols.size();
		//String patternId="<id column=\"{0}\"  property=\"{1}\" jdbcType=\"{2}\" javaType=\"{3}\"/>";
		//String patternResult="<result column=\"{0}\"  property=\"{1}\" jdbcType=\"{2}\" javaType=\"{3}\"/>";
		//String patternResult4bytes="<result column=\"{0}\"  property=\"{1}\" jdbcType=\"{2}\" />";

		for(int i=0;i<colSize;i++){
			ColumnTemplate tempCol=cols.get(i);
			if(!tempCol.getDbColName().equalsIgnoreCase(this.pk))continue;
				String tempStr=this.getResultMapPol(tempCol);
				lSbrReturn.append(tempStr).append("\n");
				break;
		}
		
		
		for(int i=0;i<colSize;i++){
			ColumnTemplate tempCol=cols.get(i);
			if(tempCol.getDbColName().equalsIgnoreCase(this.pk))continue;
			String tempStr=this.getResultMapPol(tempCol);
			lSbrReturn.append(tempStr).append("\n");
		}
		return lSbrReturn.toString();
	}
	

//	public String getRefColumn(){
//		StringBuffer lSbrReturn=new StringBuffer("");
//		String pattern="<sql id=\"{0}Col\">#'{'{0},jdbcType={1},javaType={2}'}'</sql>";
//		String pattern4bytes="<sql id=\"{0}Col\">#'{'{0},jdbcType={1}'}'</sql>";
//		for(int i=0;i<cols.size();i++){
//			ColumnTemplate tempCol=cols.get(i);
//			String tempPattern=pattern;
//			if(ColumnTemplate.DB_TYPE_BLOB.equalsIgnoreCase(tempCol.getDbColType())){
//				tempPattern=pattern4bytes;
//			}
//			String tempStr=MessageFormat.format(tempPattern
//					,tempCol.getJavaName()  //0
//					,tempCol.getJdbcType()  //1
//					,tempCol.getJavaType()  //2
//			);
//			
//		}
//		return lSbrReturn.toString();
//	}
	public String getJavaCol(ColumnTemplate ct){
		return null;
	};
	
	public String getJavaCols(){
		if(cols==null)return "";
		StringBuffer lSbrReturn=new StringBuffer("");
		int colSize=cols.size();
		String pattern="private {0} {1};         //{2}  {3} {4}";
		for(int i=0;i<colSize;i++){
			ColumnTemplate tempCol=cols.get(i);
			String tempStr=MessageFormat.format(pattern,
					tempCol.getJavaType().getSimpleName(),  //0
					tempCol.getJavaName()  //1
					,tempCol.getDbColName()  //2
					,tempCol.getDbColType()  //3
					,tempCol.getPrecision()  //4
			);
			lSbrReturn.append(tempStr+"\n");
		}
		return lSbrReturn.toString();
	}
	
	public String getEnum(){
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
	
	public abstract String getCondition(ColumnTemplate ct,Q q);
	
	public String getConditions(){
		if(cols==null)return "";
		StringBuffer lSbrReturn=new StringBuffer("");
		int colSize=cols.size();
		//String pattern="<if test=\"model.{0} neq null\">and m.{1}=#'{'model.{0},jdbcType={2} javaType={3} '}' </if> ";
		//String datePattern="<if test=\"model.{0} neq null\">and to_char(m.{1},{4})= to_char(#'{'model.{0},jdbcType={2} javaType={3} '}',{4}) </if> ";
		for(int i=0;i<colSize;i++){
			ColumnTemplate tempCol=cols.get(i);
			String tempStr=this.getCondition(tempCol,null);
			lSbrReturn.append(tempStr).append("\n");
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
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	pattern
    	.append(XML_UTF8).append(StringUtil.ln(1))
        .append("<!--").append(StringUtil.ln(1))
    	.append(StringUtil.tab()).append("Create Date:").append(sdf.format(new Date())).append(StringUtil.ln(1))
        .append(StringUtil.tab()).append("MapperTemplate:{12}").append(StringUtil.ln(1))
        .append(StringUtil.tab()).append("Model:{8} ").append(StringUtil.ln(3))
        .append(" public static enum F '{' \n  {11}  \n '}' ").append(StringUtil.ln(2))
        .append("{10} -->").append(StringUtil.ln(2))
    	.append(DOCTYPE_MYBATIS3).append(StringUtil.ln())
    	.append("<mapper namespace=\"{0}\">").append(StringUtil.ln(2))
    	.append("<cache flushInterval=\"30000\" readOnly=\"true\"></cache>").append(StringUtil.ln(3))
    	.append("<sql id=\"table\">{1}</sql>").append(StringUtil.ln(2))
    	.append("<sql id=\"pk\">{2}</sql>").append(StringUtil.ln(2))
    	.append("<sql id=\"colums\">\n{3} \n</sql>").append(StringUtil.ln(2))
    	.append("<sql id=\"insertCols\">\n{4}\n</sql>").append(StringUtil.ln(2))
    	.append("<sql id=\"updateCols\">\n{5}\n</sql>").append(StringUtil.ln(2))
    	.append("<sql id=\""+SQL_ID_SELECT_ORDERBY+"\">order by m.{2} desc </sql>").append(StringUtil.ln(2))
    	.append("<sql id=\"joinColums\"></sql>").append(StringUtil.ln(2))
    	.append("<sql id=\"join\"></sql>").append(StringUtil.ln(0))
    	.append("<!-- 别名m已被主表使用  -->").append(StringUtil.ln(2))
    	.append("<resultMap type=\"{8}\" id=\"resultMap\">\n {6}\n </resultMap>").append(StringUtil.ln(3))
        .append("<sql id=\""+SQL_ID_SELECT_CONDITION+"\">\n{7}\n</sql>").append(StringUtil.ln(3))
   
    	
        .append("<select id=\"select\" resultType=\"ArrayList\" resultMap=\"resultMap\">").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("select m.* from <include refid=\"table\" /> m   ").append(StringUtil.ln())
        .append(StringUtil.tab(2)).append(TAG_TRIM_CONDITIOM_START).append(StringUtil.ln())
        .append(StringUtil.tab(3)).append(TAG_INCLUDE(SQL_ID_SELECT_CONDITION)).append(StringUtil.ln())
        .append(StringUtil.tab(2)).append(TAG_TRIM_END).append(StringUtil.ln())
        .append(StringUtil.tab(1)).append(TAG_INCLUDE(SQL_ID_SELECT_ORDERBY)).append(StringUtil.ln())
        .append(TAG_SELECT_END).append(StringUtil.ln(2))
        
        .append("<select id=\"selectUnion\" resultType=\"ArrayList\" resultMap=\"resultMap\">").append(StringUtil.ln())
        .append("  ").append("select m.* from (").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append(TAG_TRIM_UNION_START).append(StringUtil.ln())
        .append(StringUtil.tab(2)).append("<foreach collection=\"list\" item=\"model\">").append(StringUtil.ln())
        .append(StringUtil.tab(3)).append("<if test=\"model neq null\">").append(StringUtil.ln())
        .append(StringUtil.tab(4)).append("union select m.* from <include refid=\"table\" /> m ").append(StringUtil.ln())
        .append(StringUtil.tab(5)).append(TAG_TRIM_CONDITIOM_START).append(StringUtil.ln())
        .append(StringUtil.tab(6)).append(TAG_INCLUDE(SQL_ID_SELECT_CONDITION)).append(StringUtil.ln())
        .append(StringUtil.tab(5)).append(TAG_TRIM_END).append(StringUtil.ln())
        .append(StringUtil.tab(3)).append(TAG_IF_END).append(StringUtil.ln())
        .append(StringUtil.tab(2)).append(TAG_FOREACH_END).append(StringUtil.ln())
        .append(StringUtil.tab(1)).append(TAG_TRIM_END).append(StringUtil.ln())
        .append("   ) m ").append(TAG_INCLUDE(SQL_ID_SELECT_ORDERBY)).append(StringUtil.ln())
        .append(TAG_SELECT_END).append(StringUtil.ln(2))
                
        .append("<select id=\"selectEqPk\"  resultMap=\"resultMap\">").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("select m.* from <include refid=\"table\" /> m  where m.<include refid=\"pk\" /> = #'{'{9}'}'").append(StringUtil.ln())
        .append(TAG_SELECT_END).append(StringUtil.ln(2))
        
        .append("<select id=\"selectInPk\" resultType=\"ArrayList\" resultMap=\"resultMap\" >").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("select m.* from <include refid=\"table\" /> m  where m.<include refid=\"pk\" /> in").append(StringUtil.ln())
        .append(StringUtil.tab(2)).append("<foreach item=\"pk\" collection=\"list\" open=\"(\" separator=\",\" close=\")\"> #'{'pk'}' </foreach>").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append(TAG_INCLUDE(SQL_ID_SELECT_ORDERBY)).append(StringUtil.ln())
        .append(TAG_SELECT_END).append(StringUtil.ln(2))
        
        .append("<select id=\"selectNotInPk\" resultType=\"ArrayList\" resultMap=\"resultMap\" >").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("select m.* from <include refid=\"table\" /> m  where m.<include refid=\"pk\" /> not in").append(StringUtil.ln())
        .append(StringUtil.tab(2)).append("<foreach item=\"pk\" collection=\"list\" open=\"(\" separator=\",\" close=\")\"> #'{'pk'}' </foreach>").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append(TAG_INCLUDE(SQL_ID_SELECT_ORDERBY)).append(StringUtil.ln())
        .append(TAG_SELECT_END).append(StringUtil.ln(2))
        
        .append("<select  id=\"selectAll\"  resultType=\"ArrayList\"  resultMap=\"resultMap\">").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("select m.* from  <include refid=\"table\" /> m").append(StringUtil.ln())        
        .append(StringUtil.tab(1)).append(TAG_INCLUDE(SQL_ID_SELECT_ORDERBY)).append(StringUtil.ln())
        .append(TAG_SELECT_END).append(StringUtil.ln(2))
        
        .append("<select id=\"count\" resultType=\"int\">").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("select count(*) from <include refid=\"table\"/>").append(StringUtil.ln())
        .append(TAG_SELECT_END).append(StringUtil.ln(2))
        
        .append("<insert id=\"insertOne\" flushCache=\"true\" >").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("insert into <include refid=\"table\"/> ( <include refid=\"colums\"/> ) values  ").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("(").append(StringUtil.ln())
        .append(StringUtil.tab(2)).append(TAG_TRIM_COMMA_START).append(StringUtil.ln())
        .append(StringUtil.tab(3)).append("<include refid=\"insertCols\"/>").append(StringUtil.ln())
        .append(StringUtil.tab(2)).append(TAG_TRIM_END).append(StringUtil.ln())
        .append(StringUtil.tab(1)).append(")").append(StringUtil.ln())
        .append(TAG_INSERT_END).append(StringUtil.ln(2))
        
        .append("<update id=\"updateOne\" flushCache=\"true\" >").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("update <include refid=\"table\"/> set ").append(StringUtil.ln())        
        .append(StringUtil.tab(2)).append(TAG_TRIM_COMMA_START).append(StringUtil.ln())
        .append(StringUtil.tab(3)).append("<include refid=\"updateCols\"/>").append(StringUtil.ln())
        .append(StringUtil.tab(2)).append(TAG_TRIM_END).append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("where <include refid=\"pk\" />=#'{'model.{9}'}'")
        .append(TAG_UPDATE_END).append(StringUtil.ln(2))
        
        .append("<delete id=\"deleteEqPk\" flushCache=\"true\">").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("delete from <include refid=\"table\"/> where <include refid=\"pk\" /> =#'{'{9}'}'").append(StringUtil.ln())
        .append(TAG_DELETE_END).append(StringUtil.ln(2))
        
        .append("<delete id=\"deleteInPk\" flushCache=\"true\">").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("delete from <include refid=\"table\"/> where <include refid=\"pk\" /> in").append(StringUtil.ln())
        .append(StringUtil.tab(2)).append("<foreach item=\"pk\" collection=\"list\" open=\"(\" separator=\",\" close=\")\">#'{'pk'}'</foreach>").append(StringUtil.ln())
        .append(TAG_DELETE_END).append(StringUtil.ln(2))
        
        .append("<delete id=\"deleteNotInPk\" flushCache=\"true\">").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("delete from <include refid=\"table\"/> where <include refid=\"pk\" /> not in").append(StringUtil.ln())
        .append(StringUtil.tab(2)).append("<foreach item=\"pk\" collection=\"list\" open=\"(\" separator=\",\" close=\")\">#'{'pk'}'</foreach>").append(StringUtil.ln())
        .append(TAG_DELETE_END).append(StringUtil.ln(4))      
        
        
        .append("<resultMap type=\"{8}\" id=\"viewMap\" extends=\"resultMap\" ></resultMap>").append(StringUtil.ln(3))
        .append("<sql id=\"selectViewCondition\">\n\t <include refid=\"selectCondition\"/>  \n</sql>")
        
        
        .append("<select id=\"selectView\" resultType=\"ArrayList\" resultMap=\"viewMap\">").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("select m.* <include refid=\"joinColums\"/> from <include refid=\"table\" /> m <include refid=\"join\"/> ").append(StringUtil.ln())
        .append(StringUtil.tab(2)).append(TAG_TRIM_CONDITIOM_START).append(StringUtil.ln())
        .append(StringUtil.tab(3)).append(TAG_INCLUDE(SQL_ID_SELECT_VIEW_CONDITION)).append(StringUtil.ln())        
        .append(StringUtil.tab(2)).append(TAG_TRIM_END)
        .append(StringUtil.tab(1)).append(TAG_INCLUDE(SQL_ID_SELECT_ORDERBY)).append(StringUtil.ln())
        .append(TAG_SELECT_END).append(StringUtil.ln(2))
        
        .append("<select id=\"selectViewUnion\" resultType=\"ArrayList\" resultMap=\"viewMap\">").append(StringUtil.ln())
        .append("  ").append("select m.* from (").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append(TAG_TRIM_UNION_START).append(StringUtil.ln())
        .append(StringUtil.tab(2)).append("<foreach collection=\"list\" item=\"model\">").append(StringUtil.ln())
        .append(StringUtil.tab(3)).append("<if test=\"model neq null\">").append(StringUtil.ln())
        .append(StringUtil.tab(4)).append("union select m.* <include refid=\"joinColums\"/> from <include refid=\"table\" /> m <include refid=\"join\"/> ").append(StringUtil.ln())
        .append(StringUtil.tab(5)).append(TAG_TRIM_CONDITIOM_START).append(StringUtil.ln())
        .append(StringUtil.tab(6)).append(TAG_INCLUDE(SQL_ID_SELECT_VIEW_CONDITION)).append(StringUtil.ln())       
        .append(StringUtil.tab(5)).append(TAG_TRIM_END).append(StringUtil.ln())
        .append(StringUtil.tab(3)).append(TAG_IF_END).append(StringUtil.ln())
        .append(StringUtil.tab(2)).append(TAG_FOREACH_END).append(StringUtil.ln())
        .append(StringUtil.tab(1)).append(TAG_TRIM_END).append(StringUtil.ln())        
        .append("  ) m ").append(TAG_INCLUDE(SQL_ID_SELECT_ORDERBY)).append(StringUtil.ln())
        .append(TAG_SELECT_END).append(StringUtil.ln(2))
        
        .append("<select id=\"selectViewEqPk\"  resultMap=\"viewMap\">").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("select m.* <include refid=\"joinColums\"/> from <include refid=\"table\" /> m <include refid=\"join\"/> where m.<include refid=\"pk\" /> = #'{'{9}'}'").append(StringUtil.ln())
        .append(TAG_SELECT_END).append(StringUtil.ln(2))
        
        .append("<select id=\"selectViewInPk\" resultType=\"ArrayList\" resultMap=\"viewMap\" >").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("select m.* <include refid=\"joinColums\"/> from <include refid=\"table\" /> m <include refid=\"join\"/> where m.<include refid=\"pk\" /> in").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("<foreach item=\"pk\" collection=\"list\" open=\"(\" separator=\",\" close=\")\"> #'{'pk'}' </foreach>").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append(TAG_INCLUDE(SQL_ID_SELECT_ORDERBY)).append(StringUtil.ln())
        .append(TAG_SELECT_END).append(StringUtil.ln(2))
        
        .append("<select id=\"selectViewNotInPk\" resultType=\"ArrayList\" resultMap=\"viewMap\" >").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("select m.* <include refid=\"joinColums\"/> from <include refid=\"table\" /> m <include refid=\"join\"/> where m.<include refid=\"pk\" /> not in").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("<foreach item=\"pk\" collection=\"list\" open=\"(\" separator=\",\" close=\")\"> #'{'pk'}' </foreach>").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append(TAG_INCLUDE(SQL_ID_SELECT_ORDERBY)).append(StringUtil.ln())
        .append(TAG_SELECT_END).append(StringUtil.ln(2))
        
        .append("<select  id=\"selectViewAll\"  resultType=\"ArrayList\"  resultMap=\"viewMap\">").append(StringUtil.ln())
        .append(StringUtil.tab(1)).append("select m.* <include refid=\"joinColums\"/> from  <include refid=\"table\" /> m <include refid=\"join\"/>").append(StringUtil.ln())        
        .append(StringUtil.tab(1)).append(TAG_INCLUDE(SQL_ID_SELECT_ORDERBY)).append(StringUtil.ln())
        .append(TAG_SELECT_END).append(StringUtil.ln(2))
        
        .append("</mapper>")
    	;
    	String lStrMapper=MessageFormat.format(pattern.toString(),
    			this.namespace.getName()  //0
    			,this.table    //1
    			,this.pk         //2
    			,this.getDbCols()  //3
    			,this.getInsertCols()  //4
    			,this.getUpdateCols()   //5
    			,this.getResultMapPols()   //6
    			,this.getConditions()  //7
    			,this.modelClass.getName() //8
    			,this.getPkCol()  //9
    			,this.getJavaCols() //10
    			,this.getEnum()  //11
    			,this.getSubClass().getName()  //12
    	);
		return lStrMapper;
	   
   }
    
    public boolean generalMapplerXML(String srcPath){
    	return this.generalMapplerXML(srcPath,"");
    }
    
    public boolean generalMapplerXML(String srcPath,String subPath){
    	String refPath= FileUtil.toPath(namespace);
    	return this.generalMapplerXML(srcPath, refPath,subPath);
    }
    
    
   public boolean generalMapplerXML(String srcPath,String refPath,String subPath){
	   boolean isSuccess=false;
	   subPath=ObjectUtil.formatString(subPath);
	   //String path= FileUtil.toPath(namespace);
	   //String xmlPath=srcPath+refPath+".xml";
	   String path=MessageFormat.format("{0}{1}/{2}/{3}",
		   srcPath
		   ,refPath
		   ,subPath
		   ,namespace.getSimpleName()
	   );
	   String xmlPath=path+".xml";
	   String bakPath=path+".bak";
	   String strMapper=this.getMapper();
	   System.err.println(xmlPath);
	   File xmlFile=new File(xmlPath);
	   OutputStreamWriter osw=null;
	   //BufferedOutputStream bos=new BufferedOutputStream(os);
	   BufferedWriter bw=null;
	   try {
		if(xmlFile.exists()&&xmlFile.isFile())
		{ 
			//xmlFile.delete();
			File bakFile=new File(bakPath);
			xmlFile.renameTo(bakFile);
			isSuccess=true;
		}
		xmlFile.createNewFile();
		osw=new OutputStreamWriter(new FileOutputStream(xmlFile),CodeEnum.utf8.name());
		bw=new BufferedWriter(osw);
		bw.write(strMapper);
		bw.flush();
		bw.close();
		osw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return isSuccess;
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
		//MapperTemplate mt=new MapperTemplate("xxx", "id", cols);
		
	}
	
}
