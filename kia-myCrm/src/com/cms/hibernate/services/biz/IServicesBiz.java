package com.cms.hibernate.services.biz;

import java.util.List;

import com.cms.hibernate.customer.ent.Customers;
import com.cms.hibernate.services.dao.IServicesDAO;
import com.cms.hibernate.services.ent.Services;

public interface IServicesBiz extends IServicesDAO {

	public int createService(Services s);
	
	public int doHandle(Services s);
	
	public int doFeedBack(Services s);
	
	public int doAssgin(Services s);
	
	public int doFile(Services s);
	
	public List search(Services s,Customers c,int curPage, int maxItems);
}
