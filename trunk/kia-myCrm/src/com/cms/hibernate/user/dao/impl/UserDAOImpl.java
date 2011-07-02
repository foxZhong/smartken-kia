package com.cms.hibernate.user.dao.impl;



import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cms.hibernate.user.dao.IUserDAO;
import com.cms.hibernate.user.ent.Users;

public class UserDAOImpl extends HibernateDaoSupport implements IUserDAO {

	public int insert(Users u)
	{
		super.getHibernateTemplate().save(u);
		return 0;
	}

	public int delete(Users u) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().delete(u);
		return 0;
	}

	public int update(Users u) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().update(u);
		return 0;
	}

	public Users getUserById(int id) {
		// TODO Auto-generated method stub
		return (Users)super.getHibernateTemplate().get(Users.class, id);
	}
	
}
