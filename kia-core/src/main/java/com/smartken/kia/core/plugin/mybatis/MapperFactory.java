package com.smartken.kia.core.plugin.mybatis;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;

import javax.swing.text.MaskFormatter;


import com.smartken.kia.core.model.IMapper;

public class MapperFactory {

	public MapperFactory(Connection connection,Class<? extends MapperTemplate> cls){
		this.connection=connection;
		this.cls=cls;
	}
	
	private Connection connection;
    private Class<? extends MapperTemplate> cls;

	public  MapperTemplate createMapperTemplate(String table,String pk,Class nameSpace,Class modelClass) throws Exception{
		return createMapperTemplate(table, pk, nameSpace, modelClass,null);
	}
	
	public  MapperTemplate createMapperTemplate(String table,String pk,Class nameSpace,Class modelClass,String idGener) throws Exception{
		if(modelClass==null || nameSpace==null)throw new Exception("MapperFactory creating error: nameSpace and modelclass can't be null");
		MapperTemplate mapper=null;
		try {
			
			String pattern="select * from {0} where 1=2";
			String querySql=MessageFormat.format(pattern, table);
		    PreparedStatement ps=  this.connection.prepareStatement(querySql);
		    ResultSet rs=  ps.executeQuery();
		    ResultSetMetaData mtdata= rs.getMetaData();
		    ArrayList<String> dbColNames=new ArrayList<String>();
		    ArrayList<String> dbColTypes=new ArrayList<String>();
		    ArrayList<Integer> precisions=new ArrayList<Integer>();
		    for (int i = 1; i <= mtdata.getColumnCount(); i++) {
		    	String colName=mtdata.getColumnName(i);
		    	String colType=mtdata.getColumnTypeName(i);
				dbColNames.add(colName);
				dbColTypes.add(colType);
				try{
				precisions.add(mtdata.getPrecision(i));
				}catch (NumberFormatException nfe){
					precisions.add(100);
				}
			}
		    
		    if(OracleMapperTemplate.class.equals(this.cls)){
			    mapper=new OracleMapperTemplate(table, pk, dbColNames,dbColTypes,precisions,idGener);

		    }else if(MySQLMapperTemplate.class.equals(this.cls)){
			    mapper=new MySQLMapperTemplate(table, pk, dbColNames,dbColTypes,precisions,idGener);
		    }else{
		    	throw new Exception(this.cls.getName()+" is not a MapperTemplate");
		    } 
		    mapper.setModelName(modelClass);
		    mapper.setNamespace(nameSpace);
		    return mapper;
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{return mapper;}
	}
	
	
	
	
	public static void main(String[] args)
	{
//        MapperTemplate mt=createMapperTemplate("pp_personc","staff_no");
//        System.err.println(mt.getDbCols());
//        System.err.println(mt.getInsertCols());
//        System.err.println(mt.getUpdateCols());
//        System.err.println(mt.getJavaCols());
//        System.err.println(mt.getModelCols());
//        System.err.println(mt.getResultMap());
//
//        System.err.println(mt.getCondition());
//        System.err.println(mt.getPropertiesKey());
//        //System.out.println(mt.getMapper(IMapper.class));
	}
}
