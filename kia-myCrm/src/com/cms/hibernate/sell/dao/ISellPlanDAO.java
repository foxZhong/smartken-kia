package com.cms.hibernate.sell.dao;

import java.util.List;

import com.cms.hibernate.sell.ent.*;

public interface ISellPlanDAO {

	public int insert(Sellplan plan);
	
	public int update(Sellplan plan);
	
	public int delete(int id);
	
	public Sellplan getPlanById(int id);
	
	public List<Sellplan> getListBySellPlan(int userid,int curPage,int maxItems);
}
