package com.cms.hibernate.sell.biz.impl;

import java.util.List;

import com.cms.hibernate.sell.biz.ISellPlanBiz;
import com.cms.hibernate.sell.dao.ISellPlanDAO;
import com.cms.hibernate.sell.dao.impl.SellPlanDAOImpl;
import com.cms.hibernate.sell.ent.Sellplan;

public class SellPlanBizImpl implements ISellPlanBiz {

	private ISellPlanDAO spDAO=null;
	
	public ISellPlanDAO getSpDAO() {
		return spDAO;
	}

	public void setSpDAO(ISellPlanDAO spDAO) {
		this.spDAO = spDAO;
	}

	public int addPlan(Sellplan plan) {
		// TODO Auto-generated method stub
		plan.setPlanStauts(1);
		return spDAO.insert(plan);
	}

	public int editPlan(Sellplan plan) {
		// TODO Auto-generated method stub
		Sellplan sp=spDAO.getPlanById(plan.getPlanId());
		sp.setPlanContent(plan.getPlanContent());
		sp.setPlanPubdate(plan.getPlanPubdate());
		return spDAO.update(sp);
	}

	public int executePlan(Sellplan plan) {
		// TODO Auto-generated method stub
		Sellplan sp=spDAO.getPlanById(plan.getPlanId());
		sp.setPlanResult(plan.getPlanResult());
		return spDAO.update(sp);
	}

	public List<Sellplan> queryPlanByTerm(String clientName, String summary,
			String conttext) {
		// TODO Auto-generated method stub
		return null;
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return spDAO.delete(id);
	}

	public List<Sellplan> getListBySellPlan(int userid, int curPage,
			int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public Sellplan getPlanById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Sellplan plan) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Sellplan plan) {
		// TODO Auto-generated method stub
		return 0;
	}

}
