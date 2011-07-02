package com.cms.hibernate.produces.biz;

import java.util.List;

import com.cms.hibernate.produces.dao.IProduceDAO;
import com.cms.hibernate.produces.ent.Produces;

public interface IProduceBiz extends IProduceDAO{
	
	public List seach(Produces p);

}
