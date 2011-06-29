package shoes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shoes.dao.CommodityTypeDao;
import shoes.entity.CommodityType;

public class CommodityTypeDaoImpl extends BaseDao implements CommodityTypeDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public CommodityType findType(int TId) {
		CommodityType ct = null;
		String sql = "select * from CommodityType where TId="+TId;
		try{
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ct = new CommodityType();
				ct.setTId(rs.getInt("TId"));
				ct.setTName(rs.getString("TName"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			closeAll(con, pstmt, rs);
		}
		return ct;
	}
}
