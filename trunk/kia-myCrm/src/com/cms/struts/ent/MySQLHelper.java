package com.cms.struts.ent;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLHelper {

	private String driver;
	private String url;
	private String user;
	private String pass;
	protected Connection con=null;
	protected PreparedStatement ps=null;
	protected ResultSet rs=null;
	
	public MySQLHelper()
	{
		Env env=new Env();
		driver=env.getProperty("Driver");
		url=env.getProperty("Url")+env.getProperty("Database");
	    user=env.getProperty("User");
	    pass=env.getProperty("Password");
	}
	
	public void getCon()
	{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeAll()
	{
		
			try {
				if(con!=null)con.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	
	class Env extends Properties
	{
		public Env()
		{
			InputStream is=getClass().getResourceAsStream("/MySql.properties");
			try {
				load(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		MySQLHelper my=new MySQLHelper();
		System.out.print(my.driver);
		my.getCon();
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
