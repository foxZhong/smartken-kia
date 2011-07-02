package com.cms.hibernate.customer.dao.impl;

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
import com.cms.hibernate.customer.dao.ICusstaffDAO;
import com.cms.hibernate.customer.ent.Cusstaff;

public class CusstaffDAOImpl extends HibernateDaoSupport implements ICusstaffDAO {

	Session se=HibernateSessionFactory.getSession();
	Transaction ts=null;

	public List getListByUserId(int userid, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Cusstaff s) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		se.save(s);
//		ts.commit();
//		this.closeSe();
		super.getHibernateTemplate().save(s);
		return 0;
	}

	public int update(Cusstaff s) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().update(s);
		return 0;
	}

	public int delete(Cusstaff s) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		se.delete(s);
//		ts.commit();
//		this.closeSe();
		Cusstaff st=(Cusstaff)super.getHibernateTemplate().get(Cusstaff.class, s.getStaffId());
		super.getHibernateTemplate().delete(st);
		return 0;
	}
	
	public void closeSe(){
		this.se=null;
		HibernateSessionFactory.closeSession();
	}

	public List search(final Cusstaff s) {
		// TODO Auto-generated method stub
		//se=HibernateSessionFactory.getSession()
		if(s.getStaffName()==null||s.getStaffName().equals(""))
		return null;
		else
		return super.getHibernateTemplate().executeFind(
				 new HibernateCallback()
			       {
					public Object doInHibernate(Session se)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Criteria cr=se.createCriteria(Cusstaff.class);
						String staname=s.getStaffName();
						
							cr.add(Restrictions.like("staffName", staname,MatchMode.ANYWHERE));
							System.out.println("客户经理:"+staname);
						
						return cr.list();
						//System.out.println("搜到客户经理:"+list.size());
			        }		}
		);
	      
	}




}

