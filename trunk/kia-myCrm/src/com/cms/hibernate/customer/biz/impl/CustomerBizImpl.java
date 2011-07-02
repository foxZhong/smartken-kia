package com.cms.hibernate.customer.biz.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.cms.hibernate.customer.biz.ICustomerBiz;
import com.cms.hibernate.customer.dao.ICusstaffDAO;
import com.cms.hibernate.customer.dao.ICustomersDAO;
import com.cms.hibernate.customer.ent.Cusstaff;
import com.cms.hibernate.customer.ent.Customers;

public class CustomerBizImpl implements ICustomerBiz {

	private ICustomersDAO customersDAO=null;
	private ICusstaffDAO cstaDAO=null;

	public ICustomersDAO getCustomersDAO() {
		return customersDAO;
	}

	public void setCustomersDAO(ICustomersDAO customersDAO) {
		this.customersDAO = customersDAO;
	}

	public ICusstaffDAO getCstaDAO() {
		return cstaDAO;
	}

	public void setCstaDAO(ICusstaffDAO cstaDAO) {
		this.cstaDAO = cstaDAO;
	}

	public List getListByUserId(int userid, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Customers s) {
		// TODO Auto-generated method stub
		customersDAO.insert(s);
		return 0;
	}

	public int update(Customers s) {
		// TODO Auto-generated method stub
		customersDAO.update(s);
		return 0;
	}

	public int delete(Customers s) {
		// TODO Auto-generated method stub
		customersDAO.delete(s);
		return 0;
	}

	public List search(Customers s,Cusstaff sta) {
		// TODO Auto-generated method stub
		List stas=cstaDAO.search(sta);
		return customersDAO.search(s,stas);
	}

	
	public List search(Customers s, List stas) {
		// TODO Auto-generated method stub
		return null;
	}

	public int doConfirmLose(Customers s) {
		// TODO Auto-generated method stub
		Customers ns=customersDAO.getCusById(s.getCusId());
		ns.setCusStatus(3);
		ns.setCusLosedate(new Timestamp(new Date().getTime()));
		ns.setCusLoseinfo(s.getCusLoseinfo());
		customersDAO.update(ns);
		return 0;
	}

	public int doDelayLose(Customers s) {
		// TODO Auto-generated method stub
		Customers ns=customersDAO.getCusById(s.getCusId());
		ns.setCusStatus(2);
		ns.setCusLosedate(new Timestamp(new Date().getTime()));
		ns.setCusLosedelay(s.getCusLosedelay());
		customersDAO.update(ns);
		return 0;
	}
	
	public int doFollowLose(Customers s) {
		// TODO Auto-generated method stub
		Customers ns=customersDAO.getCusById(s.getCusId());
		ns.setCusStatus(1);
		ns.setCusLosedate(null);
		ns.setCusLosedelay("²»Ïê");
		ns.setCusLoseinfo("²»Ïê");
		customersDAO.update(ns);
		return 0;
	}

	public Customers getCusById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
