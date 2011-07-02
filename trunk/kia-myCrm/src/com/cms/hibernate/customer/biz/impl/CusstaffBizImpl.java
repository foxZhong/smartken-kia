package com.cms.hibernate.customer.biz.impl;

import java.util.List;

import com.cms.hibernate.customer.biz.ICusstaffBiz;
import com.cms.hibernate.customer.dao.ICusstaffDAO;
import com.cms.hibernate.customer.dao.impl.CusstaffDAOImpl;
import com.cms.hibernate.customer.ent.Cusstaff;

public class CusstaffBizImpl implements ICusstaffBiz {

	private ICusstaffDAO cusstaffDAO=null;
	
	public ICusstaffDAO getCusstaffDAO() {
		return cusstaffDAO;
	}

	public void setCusstaffDAO(ICusstaffDAO cusstaffDAO) {
		this.cusstaffDAO = cusstaffDAO;
	}

	public int delete(Cusstaff s) {
		// TODO Auto-generated method stub
		cusstaffDAO.delete(s);
		return 0;
	}

	public List getListByUserId(int userid, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Cusstaff s) {
		// TODO Auto-generated method stub
		cusstaffDAO.insert(s);
		return 0;
	}

	public int update(Cusstaff s) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List search(Cusstaff s) {
		// TODO Auto-generated method stub
		return null;
	}

}
