package shoes.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoes.dao.OrderItemDao;
import shoes.dao.OrdersDao;
import shoes.entity.OrderItem;
import shoes.entity.Orders;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List findOrderitems(int oid)
	{
		List list = new ArrayList();
		String sql = "select * from orderitems where Items_oid=?";
		try{
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, oid);
			rs = pstmt.executeQuery();
			while(rs.next()){
			OrderItem o = new OrderItem();
			o.setItemCid(rs.getInt("Items_cid"));
			o.setItemCount(rs.getInt("Items_count"));
			o.setItemId(rs.getInt("Items_id"));
			o.setItemOid(rs.getInt("Items_oid"));
			o.setItemPrice(rs.getDouble("Items_price"));
			list.add(o);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			closeAll(con, pstmt, rs);
		}
		return list;
	}


}
