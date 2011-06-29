package shoes.dao;
import java.sql.SQLException;
import java.util.List;

import shoes.entity.OrderItem;
import shoes.entity.Orders;

public interface OrdersDao {
	
	public int addOrders(Orders orders,String EndTime,List items);
	
	public int deleteOrders(int oid);
	
	public List findOrders();
	
	public List findOrders(int current);
	
	public List findUnsettledOrders();
	
	public int updateOState(int OId);
	
	public int addItem(OrderItem item) throws SQLException;
	
	public List findOrders(String number);
	
	public List findOrders(String number,int current);
	
	public Orders findOrdersNumber(int oid);
	
	public int findOStateCount();
	//public int deleteItems(Orders orders,OrderItem item);
}
