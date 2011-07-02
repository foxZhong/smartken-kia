package com.cms.hibernate.customer.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cms.hibernate.HibernateSessionFactory;
import com.cms.hibernate.customer.dao.ICusnoteDAO;
import com.cms.hibernate.customer.ent.Cusnote;

public class CusnoteDAOImpl extends HibernateDaoSupport implements ICusnoteDAO {

	Session se=HibernateSessionFactory.getSession();
	Transaction ts=null;

	public List getListByUserId(int userid, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Cusnote s) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		se.save(s);
//		ts.commit();
//		this.closeSe();
		super.getHibernateTemplate().save(s);
		return 0;
	}

	public int update(Cusnote s) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Cusnote s) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		se.delete(s);
//		ts.commit();
//		this.closeSe();
		Cusnote cs=(Cusnote)super.getHibernateTemplate().get(Cusnote.class, s.getNoteId());
		super.getHibernateTemplate().delete(cs);
		return 0;
	}

	public void closeSe(){
		this.se=null;
		HibernateSessionFactory.closeSession();
	}
}
