package com.cms.hibernate.sell.dao;

import java.util.List;

import com.cms.hibernate.sell.ent.Sellchance;

public interface ISellChanceDAO {

	public int insert(Sellchance chance);
	
	public int update(Sellchance chance);
	
	public int delete(int id);
	
	public Sellchance getChanceById(int id);
	
	public List search(Sellchance sc,int curPage,int maxItems);
	
	public List getListBySellPlan(int userid,int curPage,int maxItems);
}
