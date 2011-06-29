package shoes.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoes.dao.BrandDao;
import shoes.entity.Brand;

public class BrandDaoImpl extends BaseDao implements BrandDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int AddBrand(Brand brand) {
		int result = 0;
		String sql = "insert into Brand (BName,BPicture,BCName) values (?,?,?)";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			String[] parameters = {brand.getBName()};
			result = executeUpdate(pstmt, parameters);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return result;
	}
	
	public int deleteBrand(int bid) {
		int result = 0;
		String sql = "delete from Brand where BId="+bid;
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
	
	public int updateBrand(Brand brand) {
		int result = 0;
		String sql = "update Brand set BName=?,BPicture=?,BCName=? where BId="+brand.getBId();
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			String[] parameters = {brand.getBName()};
			result = executeUpdate(pstmt, parameters);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return result;
	}
	
	public Brand findBrand(int bid) {  
		Brand brand = null;
		String sql = "select * from Brand where BId="+bid;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				brand = new Brand();
				brand.setBId(bid);
				brand.setBName(rs.getString("BName"));
				brand.setBPicture(rs.getString("BPicture"));
				brand.setBCName(rs.getString("BCName"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return brand;
	}

	public List findAllBrand() {
		List list = new ArrayList();
		try{
			Connection con = BaseDao.getConnection();
			String sql = "select * from brand";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = BaseDao.executeQuery(pstmt, null);
			while(rs.next()){
				Brand brand = new Brand(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				list.add(brand);
			}
			BaseDao.closeAll(con, pstmt, rs);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return list;
	}
	
}
