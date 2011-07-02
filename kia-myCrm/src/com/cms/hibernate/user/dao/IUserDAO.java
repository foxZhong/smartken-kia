package com.cms.hibernate.user.dao;

import com.cms.hibernate.user.ent.Users;



public interface IUserDAO {

	
	public int insert(Users u);
	
	public int delete(Users u);
	
	public int update(Users u);
	
	public Users getUserById(int u);
}
