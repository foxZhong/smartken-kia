package com.smartken.kia.core.plugin.mybatis;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;


import com.smartken.kia.core.model.IMapper;

public class Generator {

	private Connection connection;

	


	public void setConnection(Connection connection) {
		this.connection = connection;
	}


	
	public  MapperTemplate getMapperTemplate(String table){
		return getMapperTemplate(table, "id",null,null);
	}
	
	public  MapperTemplate getMapperTemplate(String table,String pk){
          return getMapperTemplate(table, pk, null, null);
	}
	
	public  MapperTemplate getMapperTemplate(String table,String pk,Class nameSpace){
	   return getMapperTemplate(table, pk, nameSpace,null);
	}
	
	public  MapperTemplate getMapperTemplate(String table,String pk,Class nameSpace,Class modelClass){
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
				dbColNames.add(mtdata.getColumnName(i));
				dbColTypes.add(mtdata.getColumnTypeName(i));
				precisions.add(mtdata.getPrecision(i));
			}
		    mapper=new MapperTemplate(table, pk, dbColNames,dbColTypes,precisions);
		    if(modelClass!=null)mapper.setModelName(modelClass);
		    if(nameSpace!=null)mapper.setNamespace(nameSpace);
		    return mapper;
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{return mapper;}
	}
	
	public static void main(String[] args)
	{
//        MapperTemplate mt=getMapperTemplate("pp_personc","staff_no");
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
