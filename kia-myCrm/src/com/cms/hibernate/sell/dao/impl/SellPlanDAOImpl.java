package com.cms.hibernate.sell.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cms.hibernate.HibernateSessionFactory;
import com.cms.hibernate.sell.dao.ISellPlanDAO;
import com.cms.hibernate.sell.ent.Sellplan;

public class SellPlanDAOImpl extends HibernateDaoSupport implements ISellPlanDAO {

	Session se=HibernateSessionFactory.getSession();
	Transaction ts=null;
	public int delete(int id) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
		Sellplan sp= (Sellplan)super.getHibernateTemplate().get(Sellplan.class, id);
	    super.getHibernateTemplate().delete(sp);
		return 0;
	}

	public List<Sellplan> getListBySellPlan(int userid, int curPage,
			int maxItems) {
		// TODO Auto-generated method stub

		return null;
	}

	public int insert(Sellplan plan) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		se.save(plan);
//		ts.commit();
//		this.closeSe();
		super.getHibernateTemplate().save(plan);
		return 0;
	}

	public int update(Sellplan plan) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		se.update(plan);
//		ts.commit();
//		this.closeSe();
		super.getHibernateTemplate().update(plan);
		return 0;
	}

	public Sellplan getPlanById(int id) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		Sellplan sp=se.get(Sellplan.class, id);
//		this.closeSe();
		return (Sellplan)super.getHibernateTemplate().get(Sellplan.class, id);
	}
	
	public void closeSe()
	{
		this.se=null;
		HibernateSessionFactory.closeSession();
	}

}
