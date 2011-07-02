package com.cms.hibernate.sell.biz;

import java.util.List;

import com.cms.hibernate.sell.dao.ISellPlanDAO;
import com.cms.hibernate.sell.ent.Sellplan;

public interface ISellPlanBiz extends ISellPlanDAO{
	
	//��Ӽƻ�
	public int addPlan(Sellplan plan);
	//�޸ļƻ�
	public int editPlan(Sellplan plan);
	//ִ�мƻ�
	public int executePlan(Sellplan plan);
	//������������ѯ
	public List<Sellplan> queryPlanByTerm(String clientName,
			String summary,String conttext);
}
