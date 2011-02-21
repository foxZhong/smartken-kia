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


	public static Connection getConnection(){
		Connection c=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			c= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oradrvde", "aspnet", "stjj117");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{return c;}

	}
	
	public static MapperTemplate getMapperTemplate(String table){
		return getMapperTemplate(table, "id");
	}
	
	public static MapperTemplate getMapperTemplate(String table,String pk){
		MapperTemplate mapper=null;
		try {
			Connection c=getConnection();
			String pattern="select * from {0}";
			String querySql=MessageFormat.format(pattern, table);
		    PreparedStatement ps= c.prepareStatement(querySql);
		    ResultSet rs= ps.executeQuery();
		    ResultSetMetaData mtdata=rs.getMetaData();
		    ArrayList<String> dbColNames=new ArrayList<String>();
		    ArrayList<String> dbColTypes=new ArrayList<String>();
		    for (int i = 1; i <= mtdata.getColumnCount(); i++) {
				dbColNames.add(mtdata.getColumnName(i));
				dbColTypes.add(mtdata.getColumnTypeName(i));
			}
		    mapper=new MapperTemplate(table, pk, dbColNames,dbColTypes);
		    return mapper;
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{return mapper;}
	}
	
	public static void main(String[] args)
	{
        MapperTemplate mt=getMapperTemplate("table_yuyue_info","id");
        System.out.println(mt.getDbCols());
        System.out.println(mt.getInsertCols());
        System.out.println(mt.getUpdateCols());
        System.out.println(mt.getResultMap());
        System.out.println(mt.getModelCols());
        System.out.println(mt.getCondition());
        System.out.println(mt.getMapper(IMapper.class));
	}
}
