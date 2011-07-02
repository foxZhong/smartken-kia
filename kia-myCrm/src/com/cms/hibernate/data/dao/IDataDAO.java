package com.cms.hibernate.data.dao;

import java.util.List;

import com.cms.hibernate.data.ent.SysDatas;

public interface IDataDAO {

	public int insert(SysDatas sd);
	
	public int update(SysDatas sd);
	
	public int delete(int id);
	
	public List getListByUserId(int userid,int curPage,int maxItems);
	
}
