package com.cms.hibernate.customer.biz.impl;

import java.util.List;

import com.cms.hibernate.customer.biz.ICusnoteBiz;
import com.cms.hibernate.customer.dao.ICusnoteDAO;
import com.cms.hibernate.customer.dao.impl.CusnoteDAOImpl;
import com.cms.hibernate.customer.ent.Cusnote;

public class CusnoteBizImpl implements ICusnoteBiz {

	private ICusnoteDAO cusnoteDAO=null;
	
	public ICusnoteDAO getCusnoteDAO() {
		return cusnoteDAO;
	}

	public void setCusnoteDAO(ICusnoteDAO cusnoteDAO) {
		this.cusnoteDAO = cusnoteDAO;
	}

	public int delete(Cusnote s) {
		// TODO Auto-generated method stub
		cusnoteDAO.delete(s);
		return 0;
	}

	public List getListByUserId(int userid, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Cusnote s) {
		// TODO Auto-generated method stub
		cusnoteDAO.insert(s);
		return 0;
	}

	public int update(Cusnote s) {
		// TODO Auto-generated method stub
		return 0;
	}

}
