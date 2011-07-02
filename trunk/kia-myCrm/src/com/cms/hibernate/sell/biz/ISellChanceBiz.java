package com.cms.hibernate.sell.biz;

import java.util.List;

import com.cms.hibernate.sell.dao.ISellChanceDAO;
import com.cms.hibernate.sell.ent.Sellchance;

public interface ISellChanceBiz extends ISellChanceDAO{
	//�½����ۻ��� insert
	public int newChance(Sellchance chance);
	//ָ�����ۻ��� update
	public int orderChance(Sellchance chance);
	//�༭���ۻ��� update
	public int editChance(Sellchance chance);

	
	public int doChanceFile(Sellchance ch);
	
	//�����ɹ����򿪷�ʧ��
	public int createCustomer(Sellchance chance);
}
