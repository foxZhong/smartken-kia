package com.cms.hibernate.data.dao;

import java.util.List;

import com.cms.hibernate.data.ent.SysDataoptions;

public interface IOptionDAO {
     
    public int insert(SysDataoptions sdo);
	
	public int update(SysDataoptions sdo);
	
	public int delete(int id);
	
	public List getListByUserId(int userid,int curPage,int maxItems);
	
	public SysDataoptions getOptionById(int id);
}
