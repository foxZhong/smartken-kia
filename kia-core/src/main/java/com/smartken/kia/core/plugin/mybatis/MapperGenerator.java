package com.smartken.kia.core.plugin.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MapperGenerator {

	
	public static void main(String[] args)
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection c= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oradrvde", "aspnet", "stjj117");
		    PreparedStatement ps= c.prepareStatement("");
		    ResultSet rs= ps.executeQuery();
		    ResultSetMetaData data=rs.getMetaData();
		    
		    
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
