package com.cms.hibernate.produces.dao.impl;

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
import com.cms.hibernate.produces.dao.IProduceDAO;
import com.cms.hibernate.produces.ent.Produces;

public class ProduceDAOImpl extends HibernateDaoSupport implements IProduceDAO {

	Session se=null;
	Transaction tr=null;
	
	public List seach(final Produces p) {
		// TODO Auto-generated method stub
		return super.getHibernateTemplate().executeFind(
			new HibernateCallback()
			{

				public Object doInHibernate(Session se)
						throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					Criteria cr=se.createCriteria(Produces.class);
			
					if(p.getProdName()!=null&&!p.getProdName().equals(""))
					{
						cr.add(Restrictions.like("prodName", p.getProdName(),MatchMode.ANYWHERE));
						System.out.println("搜索商品"+p.getProdName());
					}
					
					if(p.getProdType()!=null&&!p.getProdType().equals(""))
					{
						cr.add(Restrictions.like("prodType", p.getProdType(),MatchMode.ANYWHERE));
						System.out.println("搜索型号"+p.getProdType());
					}
					
					if(p.getProdLevel()!=null&&!p.getProdLevel().equals(""))
					{
						cr.add(Restrictions.like("prodLevel", p.getProdLevel(),MatchMode.ANYWHERE));
						System.out.println("搜索批次"+p.getProdLevel());
					}
					System.out.println("搜索结果数:"+cr.list().size());
					return cr.list();
				}}
		);
		
		
	}

}
