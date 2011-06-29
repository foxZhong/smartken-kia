package shoes.dao;

import java.util.List;

import shoes.entity.OrderItem;

public interface OrderItemDao {

	public List findOrderitems(int oid);
}
