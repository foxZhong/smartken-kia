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
import com.cms.hibernate.customer.dao.ICustomersDAO;
import com.cms.hibernate.customer.ent.Cusstaff;
import com.cms.hibernate.customer.ent.Customers;

public class CustomersDAOImpl extends HibernateDaoSupport implements ICustomersDAO {

	Session se=HibernateSessionFactory.getSession();
	Transaction ts=null;

	public List getListByUserId(int userid, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Customers s) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		se.save(s);
//		ts.commit();
//		this.closeSe();
		super.getHibernateTemplate().save(s);
		return 0;
	}

	public int update(Customers s) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		se.update(s);
//		ts.commit();
//		this.closeSe();
		super.getHibernateTemplate().update(s);
		return 0;
	}

	public int delete(Customers s) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		se.delete(s);
//		ts.commit();
//		this.closeSe();
		Customers cs=(Customers)super.getHibernateTemplate().get(Customers.class, s.getCusId());
		super.getHibernateTemplate().delete(cs);
		return 0;
	}

	public void closeSe(){
		this.se=null;
		HibernateSessionFactory.closeSession();
	}

	public List search(final Customers s,final List stas) {
		// TODO Auto-generated method stub
		
		//se=HibernateSessionFactory.getSession();
		return super.getHibernateTemplate().executeFind(
		   new HibernateCallback(){

			public Object doInHibernate(Session se)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Criteria cr=se.createCriteria(Customers.class);
			    
				String cusname=s.getCusName();
				
				if(stas!=null&&stas.size()!=0)
				{
					Object[] context=new Object[stas.size()];
					for(int i=0;i<stas.size();i++)
					{
						Cusstaff sta=(Cusstaff)stas.get(i);
						context[i]=sta.getStaffId();
					}
					cr.add(Restrictions.in("cusManid", context));
				}
				
				if(cusname!=null&&!cusname.equals(""))
				{
					cr.add(Restrictions.like("cusName", cusname, MatchMode.ANYWHERE));
					System.out.println("客户名:"+cusname);
				}
				
				//int cusarea=s.getCusArea();
				if(s.getCusArea()!=null&&s.getCusArea()!=0)
				{
					cr.add(Restrictions.eq("cusArea", s.getCusArea()));
					System.out.println("客户区域:"+s.getCusArea());
				}
				
				//int cuslevel=s.getCusLevel();
				if(s.getCusLevel()!=null&&s.getCusLevel()!=0)
				{ 
					cr.add(Restrictions.eq("cusLevel",s.getCusLevel()));
					System.out.println("客户等级:"+s.getCusLevel());
				}
				
				if(s.getCusStatus()!=null && s.getCusStatus()!=0)
				{ 
					cr.add(Restrictions.eq("cusStatus",s.getCusStatus()));
					System.out.println("客户状态:"+s.getCusStatus());
				}
				
				if(s.getCusCredit()!=null && s.getCusCredit()!=0)
				{
					cr.add(Restrictions.eq("cusCredit",s.getCusCredit()));
					System.out.println("客户信用度:"+s.getCusCredit());
				}
				
				if(s.getCusContentment()!=null&&s.getCusContentment()!=0)
				{
					cr.add(Restrictions.eq("cusContentment",s.getCusContentment()));
					System.out.println("客户满意度:"+s.getCusContentment());
				}
				return cr.list();
			}
			   
		   }	
		);
		
	}

	public Customers getCusById(int id) {
		// TODO Auto-generated method stub
		return (Customers)super.getHibernateTemplate().get(Customers.class, id);
	}
}
