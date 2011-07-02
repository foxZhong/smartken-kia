package com.cms.hibernate.customer.dao;

import java.util.List;

import com.cms.hibernate.customer.ent.Cusstaff;

public interface ICusstaffDAO {
	
	public int insert(Cusstaff s);
	
	public int update(Cusstaff s);
	
	public int delete(Cusstaff s);
	
	public List getListByUserId(int userid,int curPage,int maxItems);
	
	public List search(Cusstaff s);
}
