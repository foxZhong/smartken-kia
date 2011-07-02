package com.cms.hibernate.data.biz.impl;

import java.util.List;

import com.cms.hibernate.data.biz.IDataBiz;
import com.cms.hibernate.data.dao.IDataDAO;
import com.cms.hibernate.data.dao.impl.DataDAOImpl;
import com.cms.hibernate.data.ent.SysDatas;

public class DataBizImpl implements IDataBiz {
    
	private IDataDAO ddao=null;
	
	public IDataDAO getDdao() {
		return ddao;
	}

	public void setDdao(IDataDAO ddao) {
		this.ddao = ddao;
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return ddao.delete(id);
	}

	public List getListByUserId(int userid, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(SysDatas sd) {
		// TODO Auto-generated method stub
		ddao.insert(sd);
		return 0;
	}

	public int update(SysDatas sd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
