package com.cms.hibernate.sell.biz.impl;

import java.util.List;

import com.cms.hibernate.customer.dao.ICusstaffDAO;
import com.cms.hibernate.customer.dao.ICustomersDAO;
import com.cms.hibernate.customer.dao.impl.CusnoteDAOImpl;
import com.cms.hibernate.customer.dao.impl.CusstaffDAOImpl;
import com.cms.hibernate.customer.dao.impl.CustomersDAOImpl;
import com.cms.hibernate.customer.ent.Cusstaff;
import com.cms.hibernate.customer.ent.Customers;
import com.cms.hibernate.sell.biz.ISellChanceBiz;
import com.cms.hibernate.sell.dao.ISellChanceDAO;
import com.cms.hibernate.sell.dao.impl.SellChanceDAOImpl;
import com.cms.hibernate.sell.ent.Sellchance;

public class SellChanceBizImpl implements ISellChanceBiz {

	private ISellChanceDAO scDAO=null;
	private ICustomersDAO cuDAO=null;
	private ICusstaffDAO stDAO=null;
	
	public int editChance(Sellchance chance) {
		// TODO Auto-generated method stub
		//Sellchance ns=scDAO.getChanceById(chance.getChaId());
		return scDAO.update(chance);
	}

	public int newChance(Sellchance chance) {
		// TODO Auto-generated method stub
		return scDAO.insert(chance);
	}

	public ISellChanceDAO getScDAO() {
		return scDAO;
	}

	public void setScDAO(ISellChanceDAO scDAO) {
		this.scDAO = scDAO;
	}

	public ICustomersDAO getCuDAO() {
		return cuDAO;
	}

	public void setCuDAO(ICustomersDAO cuDAO) {
		this.cuDAO = cuDAO;
	}

	public ICusstaffDAO getStDAO() {
		return stDAO;
	}

	public void setStDAO(ICusstaffDAO stDAO) {
		this.stDAO = stDAO;
	}

	public int orderChance(Sellchance chance) {
		// TODO Auto-generated method stub
		Sellchance nsc=scDAO.getChanceById(chance.getChaId());
		nsc.setChaDispatchid(chance.getChaDispatchid());
		nsc.setChaDistime(chance.getChaDistime());
		nsc.setChaStaut(2);
		return scDAO.update(nsc);
	}

	public List<Sellchance> queryChanceByTerm(String clientName,
			String summary, String conttext) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int createCustomer(Sellchance ch)
	{
		Sellchance newch=scDAO.getChanceById(ch.getChaId());
		Customers cus=new Customers();
		cus.setCusName(newch.getChaClientName());
		cus.setCusUserid(newch.getChaDispatchid());
		cus.setCusArea(0);
		cus.setCusLevel(5);
		cus.setCusStatus(1);
		cuDAO.insert(cus);
		
		Cusstaff sta=new Cusstaff();
		sta.setStaffCusid(cus.getCusId());
	
		sta.setStaffName(newch.getChaContext());
		sta.setStaffPhone(newch.getChaContextPhone());
		stDAO.insert(sta);
		
		cus.setCusManid(sta.getStaffId());
		cuDAO.update(cus);
		
		newch.setChaStaut(3);
		scDAO.update(newch);
		return 0;
	}
	
	public int doChanceFile(Sellchance ch)
	{
		Sellchance newch=scDAO.getChanceById(ch.getChaId());
		newch.setChaStaut(4);
		scDAO.update(newch);
		return 0;
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return scDAO.delete(id);
	}

	public Sellchance getChanceById(int id) {
		// TODO Auto-generated method stub
		return scDAO.getChanceById(id);
	}

	public List<Sellchance> getListBySellPlan(int userid, int curPage,
			int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Sellchance chance) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Sellchance chance) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args)
	{
		SellChanceBizImpl scbiz=new SellChanceBizImpl();
		Sellchance newch=scbiz.getChanceById(2);
		scbiz.createCustomer(newch);
	}

	public List search(Sellchance sc, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return scDAO.search(sc, curPage, maxItems);
	}

}
