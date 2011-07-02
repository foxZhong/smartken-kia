package com.cms.hibernate.services.dao.impl;

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
import com.cms.hibernate.customer.ent.Customers;
import com.cms.hibernate.services.dao.IServicesDAO;
import com.cms.hibernate.services.ent.Services;

public class ServicesDAOImpl extends HibernateDaoSupport implements IServicesDAO{

	Session se=null;
	Transaction ts=null;
	
	public int delete(int id) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		Services s=(Services)se.get(Services.class, id);
//		se.delete(s);
//		ts.commit();
		Services s=(Services)super.getHibernateTemplate().get(Services.class, id);
		super.getHibernateTemplate().delete(s);
		return 0;
	}

	public List getListByUserId(int userid, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Services s) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		se.save(s);
//		ts.commit();
		super.getHibernateTemplate().save(s);
		return 0;
	}

	public int update(Services s) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		se.update(s);
//		ts.commit();
		super.getHibernateTemplate().update(s);
		return 0;
	}

	public Services getService(int id) {
		// TODO Auto-generated method stub
		//se=HibernateSessionFactory.getSession();
		return (Services)super.getHibernateTemplate().get(Services.class, id);
	}

	public List search(final Services s,final List cus,int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return super.getHibernateTemplate().executeFind(
			new HibernateCallback()
			{
				  public Object doInHibernate(Session se)
						throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					  Criteria cr=se.createCriteria(Services.class);
						if(cus!=null&&cus.size()>0)
						{ 
							Object[] cusids=new Object[cus.size()];
							for(int i=0;i<cusids.length;i++)
							{
								Customers c=(Customers)cus.get(i);
								cusids[i]=c.getCusId();
							}
							cr.add(Restrictions.in("serCusid", cusids));
						}
						//String sercontext=s.getSerContext();
						if(s.getSerContext()!=null&&!s.getSerContext().equals(""))
						{
							cr.add(Restrictions.like("serContext",s.getSerContext(),MatchMode.ANYWHERE));
							System.out.println(""+s.getSerContext());
						}
						
						//int status=s.getSerStatus();
						if(s.getSerStatus()!=null&&s.getSerStatus()!=0)
						{
							cr.add(Restrictions.eq("serStatus", s.getSerStatus()));
							System.out.println(":"+s.getSerStatus());
						}
						
						//int type=s.getSerType();
						if(s.getSerType()!=null&s.getSerType()!=0)
						{
							cr.add(Restrictions.eq("serType", s.getSerType()));
							System.out.println(":"+s.getSerType());
						}
						return cr.list();
				}
				
			}
		);
		
		
	}
	
	public void closeSe()
	{
		this.se=null;
		HibernateSessionFactory.closeSession();
	}

}
