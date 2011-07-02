package com.cms.hibernate.services.dao;

import java.util.List;

import com.cms.hibernate.services.ent.*;;

public interface IServicesDAO {

	public Services getService(int id);
	
	public int insert(Services s);
	
	public int update(Services s);
	
	public int delete(int id);
	
	public List getListByUserId(int userid,int curPage,int maxItems);
	
	public List search(Services s,List cus,int curPage,int maxItems);
}
