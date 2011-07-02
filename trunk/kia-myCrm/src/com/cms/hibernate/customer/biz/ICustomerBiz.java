package com.cms.hibernate.customer.biz;

import java.util.List;

import com.cms.hibernate.customer.dao.ICustomersDAO;
import com.cms.hibernate.customer.ent.Cusstaff;
import com.cms.hibernate.customer.ent.Customers;

public interface ICustomerBiz extends ICustomersDAO {

	public List search(Customers s,Cusstaff sta);
	
	public int doConfirmLose(Customers s);
	
	public int doDelayLose(Customers s);
	
	public int doFollowLose(Customers s);
}
