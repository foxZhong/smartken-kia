package com.cms.hibernate.message.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cms.hibernate.HibernateSessionFactory;
import com.cms.hibernate.message.dao.IMessageDAO;
import com.cms.hibernate.message.ent.SysMessage;

public class MessageDAOImpl extends HibernateDaoSupport implements IMessageDAO {

	Session se=null;
	Transaction tr=null;
	
	public int insert(SysMessage sm) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().save(sm);
		return 0;
		
	}
	
	

}
