package com.cms.hibernate.data.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cms.hibernate.HibernateSessionFactory;
import com.cms.hibernate.data.dao.IOptionDAO;
import com.cms.hibernate.data.ent.SysDataoptions;

public class OptionDAOImpl extends HibernateDaoSupport implements IOptionDAO {

	Session se=null;
	Transaction ts=null;
	
	public int delete(int id) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		SysDataoptions sdo=(SysDataoptions)se.get(SysDataoptions.class, id);
//		se.delete(sdo);
//		ts.commit();
		SysDataoptions sdo=(SysDataoptions)super.getHibernateTemplate().get(SysDataoptions.class, id);
		super.getHibernateTemplate().delete(sdo);
		return 0;
	}

	public List getListByUserId(int userid, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(SysDataoptions sdo) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		se.save(sdo);
//		ts.commit();
		super.getHibernateTemplate().save(sdo);
		return 0;
	}

	public int update(SysDataoptions sdo) {
		// TODO Auto-generated method stub
//		se=HibernateSessionFactory.getSession();
//		ts=se.beginTransaction();
//		se.update(sdo);
//		ts.commit();
		super.getHibernateTemplate().update(sdo);
		return 0;
	}

	public SysDataoptions getOptionById(int id) {
		// TODO Auto-generated method stub
		//se=HibernateSessionFactory.getSession();
		return (SysDataoptions)super.getHibernateTemplate().get(SysDataoptions.class, id);
	}

}
