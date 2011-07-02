package com.cms.hibernate.customer.dao;

import java.util.List;

import com.cms.hibernate.customer.ent.Cusstaff;
import com.cms.hibernate.customer.ent.Customers;

public interface ICustomersDAO {
	
	public Customers getCusById(int id);
	
	public int insert(Customers s);
	
	public int update(Customers s);
	
	public int delete(Customers s);
	
	public List getListByUserId(int userid,int curPage,int maxItems);
	
	public List search(Customers s,List stas);
}
