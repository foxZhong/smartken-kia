package shoes.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoes.dao.DeliveryInfoDao;
import shoes.entity.DeliveryInfo;

public class DeliveryInfoDaoImpl extends BaseDao implements DeliveryInfoDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public DeliveryInfo findDeliveryInfo(int DId) {
		DeliveryInfo dInfo = null;
		String sql = "select * from DeliveryInfo where DId="+DId;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dInfo = new DeliveryInfo();
				dInfo.setDId(DId);
				dInfo.setDName(rs.getString("DName"));
				dInfo.setTel(rs.getString("Tel"));
				dInfo.setAddress(rs.getString("Address"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return dInfo;
	}

	public int addDeliveryInfo(DeliveryInfo deliveryInfo) {
		int result = 0;
		String sql = "insert into DeliveryInfo(DUId,DName,Tel,Address) values("+deliveryInfo.getDUId()+",?,?,?)";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			String[] parameters = {deliveryInfo.getDName(),deliveryInfo.getTel(),deliveryInfo.getAddress()};
			result = executeUpdate(pstmt, parameters);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return result;
	}
	public List findAllDeliveryInfo(int duid) {
		List list = new ArrayList();
		String sql = "select * from DeliveryInfo where duid=?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, duid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DeliveryInfo deliveryInfo = new DeliveryInfo();
				deliveryInfo.setDId(rs.getInt("DId"));
				deliveryInfo.setDUId(rs.getInt("DUId"));
				deliveryInfo.setDName(rs.getString("DName"));
				deliveryInfo.setTel(rs.getString("Tel"));
				deliveryInfo.setAddress(rs.getString("Address"));
				list.add(deliveryInfo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return list;
	}
	
	public int DelDeliveryInfo(int DId){
		String sql = "DELETE FROM DeliveryInfo WHERE DId = " +DId;
		int num = 0;
		try{
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			num = executeUpdate(pstmt, null);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return num;
	}

	public int addAddress(int DUId, String DName, String Tel, String Address) {
		String sql = "INSERT INTO DeliveryInfo VALUES (?,?,?,?)";
		int num = 0;
		try{
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, DUId);
			pstmt.setString(2, DName);
			pstmt.setString(3, Tel);
			pstmt.setString(4, Address);
			num = pstmt.executeUpdate();
			this.closeAll(con, pstmt, null);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return num;
	}
}
