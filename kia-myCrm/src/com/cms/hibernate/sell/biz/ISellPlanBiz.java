package com.cms.hibernate.sell.biz;

import java.util.List;

import com.cms.hibernate.sell.dao.ISellPlanDAO;
import com.cms.hibernate.sell.ent.Sellplan;

public interface ISellPlanBiz extends ISellPlanDAO{
	
	//添加计划
	public int addPlan(Sellplan plan);
	//修改计划
	public int editPlan(Sellplan plan);
	//执行计划
	public int executePlan(Sellplan plan);
	//按特殊条件查询
	public List<Sellplan> queryPlanByTerm(String clientName,
			String summary,String conttext);
}
