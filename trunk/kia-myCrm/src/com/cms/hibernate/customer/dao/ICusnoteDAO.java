package com.cms.hibernate.customer.dao;

import java.util.List;

import com.cms.hibernate.customer.ent.Cusnote;

public interface ICusnoteDAO {
	
	public int insert(Cusnote s);
	
	public int update(Cusnote s);
	
	public int delete(Cusnote s);
	
	public List getListByUserId(int userid,int curPage,int maxItems);
}
