package com.cms.hibernate.services.biz.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.cms.hibernate.customer.dao.ICustomersDAO;
import com.cms.hibernate.customer.dao.impl.CustomersDAOImpl;
import com.cms.hibernate.customer.ent.Customers;
import com.cms.hibernate.services.biz.IServicesBiz;
import com.cms.hibernate.services.dao.IServicesDAO;
import com.cms.hibernate.services.dao.impl.ServicesDAOImpl;
import com.cms.hibernate.services.ent.Services;

public class ServicesBizImpl implements IServicesBiz{

	private IServicesDAO sdao=null;
	private ICustomersDAO cdao=null;
	
	public IServicesDAO getSdao() {
		return sdao;
	}

	public void setSdao(IServicesDAO sdao) {
		this.sdao = sdao;
	}

	public ICustomersDAO getCdao() {
		return cdao;
	}

	public void setCdao(ICustomersDAO cdao) {
		this.cdao = cdao;
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return sdao.delete(id);
	}

	public List getListByUserId(int userid, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Services s) {
		// TODO Auto-generated method stub
		sdao.insert(s);
		return 0;
	}

	public int update(Services s) {
		// TODO Auto-generated method stub
		sdao.update(s);
		return 0;
	}

	public Services getService(int id) {
		// TODO Auto-generated method stub
		sdao.getService(id);
		return null;
	}
	
	public int doHandle(Services s)
	{
		Services ns=sdao.getService(s.getSerId());
		ns.setSerHandle(s.getSerHandle());
		ns.setSerHandlerid(s.getSerHandlerid());
		ns.setSerHandletime(s.getSerHandletime());
		ns.setSerStatus(3);
		sdao.update(ns);
		return 0;
	}

	public int doFeedBack(Services s) {
		// TODO Auto-generated method stub
		Services ns=sdao.getService(s.getSerId());
		ns.setSerResult(s.getSerResult());
		ns.setSerLevel(s.getSerLevel());
		sdao.update(ns);
		return 0;
	}
	
	public int doAssgin(Services s)
	{
		Services ns=sdao.getService(s.getSerId());
		ns.setSerAssginerid(s.getSerAssginerid());
		ns.setSerStatus(2);
		Date d=new Date();
	
		ns.setSerAsstime(new Timestamp(d.getTime()));
		sdao.update(ns);
		return 0;
	}

	public int createService(Services s)
	{
		//s.setSerCreaterid(s.getSerCusid());
		s.setSerUserid(s.getSerCreaterid());
		sdao.insert(s);
		return 0;
	}

	public List search(Services s,List cus, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return sdao.search(s,cus, curPage, maxItems);
	}

	public List search(Services s, Customers c, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		List list=cdao.search(c, null);
		return sdao.search(s, list, curPage, maxItems);
	}

	public int doFile(Services s) {
		// TODO Auto-generated method stub
		Services ns=sdao.getService(s.getSerId());
		ns.setSerAssginerid(s.getSerAssginerid());
		ns.setSerStatus(5);
		Date d=new Date();
	
		//ns.setSerAsstime(new Timestamp(d.getTime()));
		sdao.update(ns);
		return 0;
	}
}
