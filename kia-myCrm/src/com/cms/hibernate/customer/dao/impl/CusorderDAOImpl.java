package com.cms.hibernate.customer.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cms.hibernate.HibernateSessionFactory;
import com.cms.hibernate.customer.dao.ICusorderDAO;
import com.cms.hibernate.customer.ent.Cusorder;

public class CusorderDAOImpl extends HibernateDaoSupport implements ICusorderDAO {

	Session se=null;
	Transaction ts=null;

	public List getListByUserId(int userid, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Cusorder s) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		se.save(s);
//		ts.commit();
//		this.closeSe();
		super.getHibernateTemplate().save(s);
		return 0;
	}

	public int update(Cusorder s) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(int s) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void closeSe(){
		this.se=null;
		HibernateSessionFactory.closeSession();
	}

}
