package com.cms.hibernate.sell.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cms.hibernate.HibernateSessionFactory;
import com.cms.hibernate.sell.dao.ISellChanceDAO;
import com.cms.hibernate.sell.ent.Sellchance;

public class SellChanceDAOImpl extends HibernateDaoSupport implements ISellChanceDAO {

	Session se=null;
	Transaction ts=null;
	public int delete(int id) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		Sellchance sc=(Sellchance)se.get(Sellchance.class, id);
//		se.delete(sc);
//		ts.commit();
//		this.closeSe();
		Sellchance sc=(Sellchance)super.getHibernateTemplate().get(Sellchance.class, id);
		super.getHibernateTemplate().delete(sc);
		return 0;
	}

	

	public int insert(Sellchance chance) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		se.save(chance);
//		ts.commit();
//		this.closeSe();
		super.getHibernateTemplate().save(chance);
		return 0;
	}

	public int update(Sellchance chance) {
		// TODO Auto-generated method stub
//		 se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		se.update(chance);
//		ts.commit();
//		this.closeSe();
		super.getHibernateTemplate().update(chance);
		return 0;
	}

	public Sellchance getChanceById(int id) {
		// TODO Auto-generated method stub
		// se=HibernateSessionFactory.getSession();
		return (Sellchance)super.getHibernateTemplate().get(Sellchance.class, id);
	}

	public void closeSe()
	{
		this.se=null;
		HibernateSessionFactory.closeSession();
	}
	
	public static void main(String[] args)
	{
		new SellChanceDAOImpl().getChanceById(2);
	}



	public List getListBySellPlan(int userid, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}



	public List search( final Sellchance sc, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		//se=HibernateSessionFactory.getSession();
		return super.getHibernateTemplate().executeFind(
		   new HibernateCallback()
		   {

			public Object doInHibernate(Session se)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Criteria cr=se.createCriteria(Sellchance.class);
				 String clientname=sc.getChaClientName();
				 if(!clientname.equals(null)&&!clientname.equals(""))
					 {
					 cr.add(Restrictions.like("chaClientName", clientname, MatchMode.ANYWHERE));
					 System.out.println("客户名："+clientname);
					 }
				 String summary=sc.getChaSummary();
				 if(!summary.equals(null)&&!summary.equals(""))
					 {
					 cr.add(Restrictions.like("chaSummary", summary, MatchMode.ANYWHERE));
					 System.out.println("概要："+summary);
					 }
				 String context=sc.getChaContext();
				 if(!context.equals(null)&&!context.equals(""))
				 {
					 cr.add(Restrictions.like("chaContext", context, MatchMode.ANYWHERE));
					 System.out.println("联系人:"+context);
				 }
				return cr.list();
			}}
		);
		
		 
	}
}
