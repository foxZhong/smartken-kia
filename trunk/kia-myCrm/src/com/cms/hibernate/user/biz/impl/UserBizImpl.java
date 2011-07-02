package com.cms.hibernate.user.biz.impl;



import com.cms.hibernate.user.biz.IUserBiz;
import com.cms.hibernate.user.dao.IUserDAO;
import com.cms.hibernate.user.ent.Users;

public class UserBizImpl implements IUserBiz{

	private IUserDAO udao=null;
	
	public IUserDAO getUdao() {
		return udao;
	}

	public void setUdao(IUserDAO udao) {
		this.udao = udao;
	}

	public int delete(Users u) {
		// TODO Auto-generated method stub
		Users du=udao.getUserById(u.getUId());
		udao.delete(du);
		return 0;
	}

	public int insert(Users u) {
		// TODO Auto-generated method stub
		udao.insert(u);
		return 0;
	}

	public int update(Users u) {
		// TODO Auto-generated method stub
		Users nu=udao.getUserById(u.getUId());
		nu.setUName(u.getUName());
		nu.setUPass(u.getUPass());
		nu.setURealname(u.getURealname());
		nu.setURoleid(u.getURoleid());
		udao.update(nu);
		return 0;
	}

	public Users getUserById(int u) {
		// TODO Auto-generated method stub
		return udao.getUserById(u);
	}

	
	
}
