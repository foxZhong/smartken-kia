package shoes.dao;

import java.util.List;

import shoes.entity.DeliveryInfo;

public interface DeliveryInfoDao {
	
	public DeliveryInfo findDeliveryInfo(int DId);
	
	public int addDeliveryInfo(DeliveryInfo deliveryInfo);
	
	public List findAllDeliveryInfo(int duid);
	
	public int DelDeliveryInfo(int DId);
	
	public int addAddress(int DUId,String DName,String Tel,String Address);
}
