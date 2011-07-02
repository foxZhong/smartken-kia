package com.cms.hibernate.data.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cms.hibernate.HibernateSessionFactory;
import com.cms.hibernate.data.dao.IDataDAO;
import com.cms.hibernate.data.ent.SysDatas;

public class DataDAOImpl extends HibernateDaoSupport implements IDataDAO {

	Session se=HibernateSessionFactory.getSession();
	Transaction ts=null;
	public int delete(int id) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	public List getListByUserId(int userid, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(SysDatas sd) {
		// TODO Auto-generated method stub
//		ts=se.beginTransaction();
//		se.save(sd);
//		ts.commit();
		super.getHibernateTemplate().save(sd);
		return 0;
	}

	public int update(SysDatas sd) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().update(sd);
		return 0;
	}

}
