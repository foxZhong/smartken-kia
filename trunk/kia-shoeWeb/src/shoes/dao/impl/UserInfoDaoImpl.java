package shoes.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoes.dao.UserInfoDao;
import shoes.entity.UserInfo;

public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public UserInfo findUser(String uName, String uPass) {
		UserInfo userInfo = null;
		String sql = "select * from UserInfo where UName=? and UPass=?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uName);
			pstmt.setString(2, uPass);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				userInfo = new UserInfo();
				userInfo.setUId(rs.getInt("uId"));
				userInfo.setUName(rs.getString("uName"));
				userInfo.setUPass(rs.getString("uPass"));
				userInfo.setULevel(rs.getString("uLevel"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return userInfo;
	}
	
	public List findAllUser() {
		ArrayList list = new ArrayList();
		String sql = "select * from UserInfo";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserInfo userInfo = new UserInfo();
				userInfo.setUId(rs.getInt("UId"));
				userInfo.setUName(rs.getString("UName"));
				userInfo.setUPass(rs.getString("UPass"));
				userInfo.setULevel(rs.getString("ULevel"));
				list.add(userInfo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return list;
	}
	
	public int addUser(UserInfo userInfo) {
		int result = 0;
		String sql = "insert into UserInfo (UName, UPass, ULevel) values (?,?,?)";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			String[] parameters = {userInfo.getUName(), userInfo.getUPass(), userInfo.getULevel()};
			result = executeUpdate(pstmt, parameters);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return result;
	}
	
	public int updateUser(UserInfo userInfo) {
		int result = 0;
		String sql = "update UserInfo set UPass=? where UName=?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			String[] parameters = {userInfo.getUPass(), userInfo.getUName()};
			result = executeUpdate(pstmt, parameters);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return result;
	}
	public int deleteUser(int uId) {
		int result = 0;
		String sql = "delete from UserInfo where UId="+uId;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			String[] parameters = null;
			result = executeUpdate(pstmt, parameters);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return result;
	}
	
	public int addAdmin(String UName,String UPass) {
		int result = 0;
		String sql = "insert into UserInfo(UName,UPass,ULevel) values(?,?,?)";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			String[] parameters = {UName,UPass,"admin"};
			result = executeUpdate(pstmt, parameters);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return result;
	}

	public UserInfo findUser(int uId) {
		UserInfo userInfo = null;
		String sql = "select * from UserInfo where uid=?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, uId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				userInfo = new UserInfo();
				userInfo.setUId(rs.getInt("UId"));
				userInfo.setUName(rs.getString("UName"));
				userInfo.setUPass(rs.getString("UPass"));
				userInfo.setULevel(rs.getString("ULevel"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}		
		return userInfo;
	}
}
