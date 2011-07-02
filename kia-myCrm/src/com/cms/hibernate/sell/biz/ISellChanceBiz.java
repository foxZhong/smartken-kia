package com.cms.hibernate.sell.biz;

import java.util.List;

import com.cms.hibernate.sell.dao.ISellChanceDAO;
import com.cms.hibernate.sell.ent.Sellchance;

public interface ISellChanceBiz extends ISellChanceDAO{
	//新建销售机会 insert
	public int newChance(Sellchance chance);
	//指派销售机会 update
	public int orderChance(Sellchance chance);
	//编辑销售机会 update
	public int editChance(Sellchance chance);

	
	public int doChanceFile(Sellchance ch);
	
	//开发成功，或开发失败
	public int createCustomer(Sellchance chance);
}
