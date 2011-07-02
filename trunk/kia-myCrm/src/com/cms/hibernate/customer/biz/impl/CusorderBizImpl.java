package com.cms.hibernate.customer.biz.impl;

import java.util.List;

import com.cms.hibernate.customer.biz.ICusorderBiz;
import com.cms.hibernate.customer.dao.ICusorderDAO;
import com.cms.hibernate.customer.dao.impl.CusorderDAOImpl;
import com.cms.hibernate.customer.ent.Cusorder;

public class CusorderBizImpl implements ICusorderBiz {

	public ICusorderDAO cusorderDAO=null;
	
	public ICusorderDAO getCusorderDAO() {
		return cusorderDAO;
	}

	public void setCusorderDAO(ICusorderDAO cusorderDAO) {
		this.cusorderDAO = cusorderDAO;
	}

	public int delete(int s) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List getListByUserId(int userid, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert( Cusorder s) {
		// TODO Auto-generated method stub
		cusorderDAO.insert(s);
		return 0;
	}

	public int update( Cusorder s) {
		// TODO Auto-generated method stub
		return 0;
	}

}
