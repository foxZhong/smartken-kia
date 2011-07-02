package com.cms.hibernate.produces.biz.impl;

import java.util.List;

import com.cms.hibernate.produces.biz.IProduceBiz;
import com.cms.hibernate.produces.dao.IProduceDAO;
import com.cms.hibernate.produces.dao.impl.ProduceDAOImpl;
import com.cms.hibernate.produces.ent.Produces;

public class ProduceBizImpl implements IProduceBiz {

	private IProduceDAO pdao=null;
	
	public IProduceDAO getPdao() {
		return pdao;
	}

	public void setPdao(IProduceDAO pdao) {
		this.pdao = pdao;
	}

	public List seach(Produces p) {
		// TODO Auto-generated method stub
		return pdao.seach(p);
	}

}
