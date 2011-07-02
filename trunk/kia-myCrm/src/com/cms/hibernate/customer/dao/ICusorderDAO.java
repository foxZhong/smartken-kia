package com.cms.hibernate.customer.dao;

import java.util.List;

import com.cms.hibernate.customer.ent.Cusorder;

public interface ICusorderDAO {
	
	public int insert(Cusorder s);
	
	public int update(Cusorder s);
	
	public int delete(int s);
	
	public List getListByUserId(int userid,int curPage,int maxItems);
}
