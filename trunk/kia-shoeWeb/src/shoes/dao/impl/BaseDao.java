package shoes.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=ShoesDB";
	private static final String DBNAME = "root";
	private static final String DBPASS = "sa";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,DBNAME,DBPASS);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeAll(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if(con != null && (!con.isClosed())) {
				con.close();
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int executeUpdate(PreparedStatement pstmt, String[] parameters) {
		int result = 0;
		try {
			if(parameters != null) {
				for(int i=0; i<parameters.length; i++) {
					pstmt.setString(i+1, parameters[i]);
				}
			}
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static ResultSet executeQuery(PreparedStatement pstmt, String[] parameters) {
		ResultSet rs = null;
		try {
			if(parameters != null) {
				for(int i=0; i<parameters.length; i++) {
					pstmt.setString(i+1, parameters[i]);
				}
			}
			rs = pstmt.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void main(String[] args)
	{
		new BaseDao().getConnection();
	}
	
}
