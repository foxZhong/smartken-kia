package com.smartken.kia.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.IvParameterSpec;

import oracle.jdbc.OracleDriver;




import com.smartken.kia.core.plugin.mybatis.MapperFactory;
import com.smartken.kia.core.plugin.mybatis.MapperTemplate;
import com.smartken.kia.core.plugin.mybatis.OracleMapperTemplate;
import com.smartken.kia.mapper.admin.IMenuMapper;
import com.smartken.kia.model.admin.MenuModel;

public class GenMapperTool {

	
	public static enum Table{
      KIA_ADMIN_MENU
	}
	
	public static enum Seqs{
	}
	
	public static String NEXTVAL=".nextval";
	
	public static Map<Table,MapperTemplate> getMappers(Connection con,Class<? extends MapperTemplate> cls){
		MapperFactory mf=new MapperFactory(con,cls);
		Map<Table,MapperTemplate> mappers=new HashMap<Table, MapperTemplate>();
		try{
			mappers.put(Table.KIA_ADMIN_MENU,mf.createMapperTemplate(Table.KIA_ADMIN_MENU.name().toUpperCase(), "id".toUpperCase(),IMenuMapper.class, MenuModel.class ));
		}catch(Exception ex){ex.printStackTrace();}
		
		return mappers;
	}
	
	public static Connection getConnection(){
		Connection c=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//c=  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oradrvde", "drv_admin", "stjj117");
			c=  DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.10:1521:oradrvde", "aspnet", "stjj117");
			//c=  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hrsystem", "ken147");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{return c;}

	}
	
	public static void main(String[] args){
		Map<Table, MapperTemplate> mappers=getMappers(getConnection(), OracleMapperTemplate.class);
		//String srcPath="D:/tempProject/ett/dao/src/main/java/";
		String srcPath="D:\\tempProject\\smartken-kia\\kia-webapp\\src\\";
		Table[] enTables=Table.values();
		//for (Enum<Table> et : enTables) {
		//	try{
		//	MapperTemplate mapper=mappers.get(et);
		    MapperTemplate mapper=mappers.get(Table.KIA_ADMIN_MENU);
			System.out.println(mapper.generalMapplerXML(srcPath,"oracle"));
		//	}catch(Exception ex){}
		//}

		
		
		//D:\tempProject\smartken-drv\drv-dao\src\main\java\com\smartken\drv\mapper\admin
	}
	
}
