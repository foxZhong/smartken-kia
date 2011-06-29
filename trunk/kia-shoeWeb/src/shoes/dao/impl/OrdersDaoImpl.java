package shoes.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import shoes.dao.OrdersDao;
import shoes.entity.CommodityInfo;
import shoes.entity.OrderItem;
import shoes.entity.Orders;

public class OrdersDaoImpl extends BaseDao implements OrdersDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	


	public int addOrders(Orders orders,String EndTime,List items) {
		int result = 0;
		String sql = "insert into Orders (ODId,StartTime,EndTime,OState) values ("+
		orders.getODId()+",getdate(),dateadd(dd,10,getdate())"+",'未发货')";
		String time = new SimpleDateFormat("yyyyMMdd").format(new Date());
		try {
			con = getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.executeUpdate();
			closeAll(con, pstmt, rs);
			
			sql="select top 1 oid from Orders order by oid desc";
			con = getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			int oid=rs.getInt("oid");
			closeAll(con, pstmt, rs);
			
			sql="update orders set number=? where oid=?";
			con = getConnection();
			pstmt=con.prepareStatement(sql);
			String number="T03"+time.substring(2, time.length())+oid;
			pstmt.setString(1, number);
			pstmt.setInt(2, oid);
			pstmt.executeUpdate();
			closeAll(con, pstmt, rs);
			System.out.println("新订单号:"+number);
			
			con = getConnection();
			for(int i=0;i<items.size();i++)
			{
				OrderItem oi=(OrderItem)items.get(i);
				oi.setItemOid(oid);
				this.addItem(oi);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return result;
	}
	
	public int deleteOrders(int oid) {
		int result = 0;
		String sql = "delete from Orders where OId="+oid;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return result;
	}

	public List findOrders() {
		List list = new ArrayList();
		String sql = "select * from Orders";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Orders orders = new Orders();
				orders.setOId(rs.getInt("Oid"));
				orders.setNumber(rs.getString("Number"));
				orders.setODId(rs.getInt("ODId"));
				//orders.setOCId(rs.getInt("OCId"));
				orders.setStartTime(rs.getString("StartTime"));
				orders.setEndTime(rs.getString("EndTime"));
				orders.setOState(rs.getString("OState"));
				list.add(orders);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return list;
	}
	
	public List findOrders(int current) {
		List list = new ArrayList();
		String sql = "select top 6 * from Orders where oid not in (select top (6*("+current+"-1)) oid from Orders)";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Orders orders = new Orders();
				orders.setOId(rs.getInt("Oid"));
				orders.setNumber(rs.getString("Number"));
				orders.setODId(rs.getInt("ODId"));
				//orders.setOCId(rs.getInt("OCId"));
				orders.setStartTime(rs.getString("StartTime"));
				orders.setEndTime(rs.getString("EndTime"));
				orders.setOState(rs.getString("OState"));
				list.add(orders);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return list;
	}
	
	public List findUnsettledOrders() {
		List list = new ArrayList();
		String sql = "select * from Orders where OState='未发货'";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Orders orders = new Orders();
				orders.setOId(rs.getInt("Oid"));
				orders.setNumber(rs.getString("Number"));
				orders.setODId(rs.getInt("ODId"));
				//orders.setOCId(rs.getInt("OCId"));
				orders.setStartTime(rs.getString("StartTime"));
				orders.setEndTime(rs.getString("EndTime"));
				orders.setOState(rs.getString("OState"));
				list.add(orders);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return list;
	}
	
	public int findOStateCount() {
		int count =0;
		String sql="select count(*) from orders where OState='未发货'";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Orders orders = new Orders();
				orders.setOId(rs.getInt("Oid"));
				orders.setNumber(rs.getString("Number"));
				orders.setODId(rs.getInt("ODId"));
				//orders.setOCId(rs.getInt("OCId"));
				orders.setStartTime(rs.getString("StartTime"));
				orders.setEndTime(rs.getString("EndTime"));
				orders.setOState(rs.getString("OState"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return count;
	}

	public int updateOState(int OId) {
		int result = 0;
		String sql = "update Orders set OState=? where OId="+OId;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "已发货");
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return result;
	}

	public int addItem(OrderItem item) throws SQLException {
		// TODO Auto-generated method stub
		String str="insert into orderitems values (?,?,?,?)";
		pstmt=con.prepareStatement(str);
		pstmt.setInt(1, item.getItemCount());
		pstmt.setInt(2, item.getItemCid());
		pstmt.setDouble(3, item.getItemPrice());
		pstmt.setInt(4, item.getItemOid());
		pstmt.executeUpdate();
		return 0;
	}

	public List findOrders(String number) {
		List list = new ArrayList();
		StringBuffer str = new StringBuffer();
		str.append("select * from Orders ");
		if(number!=null){
			str.append("where number like '%"+number+"%'");
		}
		try{
			con = getConnection();
			pstmt = con.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			while(rs.next()){
				Orders o = new Orders();
				o.setNumber(rs.getString("number"));
				o.setODId(rs.getInt("odid"));
				o.setOId(rs.getInt("oid"));
				o.setOState(rs.getString("OState"));
				o.setStartTime(rs.getString("StartTime"));
				list.add(o);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			closeAll(con, pstmt, rs);
		}
		return list;
	}
	
	public List findOrders(String number,int current) {
		List list = new ArrayList();
		String sql = "select top 6 * from Orders where oid not in (select top (6*("+current+"-1)) oid from Orders) and number like '%"+number+"%'";
		try{
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Orders o = new Orders();
				o.setNumber(rs.getString("number"));
				o.setODId(rs.getInt("odid"));
				o.setOId(rs.getInt("oid"));
				o.setOState(rs.getString("OState"));
				o.setStartTime(rs.getString("StartTime"));
				list.add(o);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			closeAll(con, pstmt, rs);
		}
		return list;
	}
	
	public Orders findOrdersNumber(int oid){
		Orders o = null;
		String sql="select * from orders where oid=?";
		try{
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,oid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				o = new Orders();
				o.setNumber(rs.getString("number"));
				o.setODId(rs.getInt("odid"));
				o.setOState(rs.getString("OState"));
				o.setStartTime(rs.getString("StartTime"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			closeAll(con, pstmt, rs);
		}
		return o;
	}

}
