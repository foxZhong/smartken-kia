package shoes.test;

import shoes.dao.OrdersDao;
import shoes.dao.impl.OrdersDaoImpl;
import shoes.entity.Orders;
import java.util.List;

public class OrdersTest {
	public static void main(String[] args) {
		OrdersDao od = new OrdersDaoImpl();
		List list = od.findOrders();
		list.get(1);
	}

}
