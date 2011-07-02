package com.cms.hibernate.message.biz.impl;

import com.cms.hibernate.message.biz.IMessageBiz;
import com.cms.hibernate.message.dao.IMessageDAO;
import com.cms.hibernate.message.dao.impl.MessageDAOImpl;
import com.cms.hibernate.message.ent.SysMessage;

public class MessageBizImpl implements IMessageBiz {

	private IMessageDAO mdao=null;
	
	public IMessageDAO getMdao() {
		return mdao;
	}


	public void setMdao(IMessageDAO mdao) {
		this.mdao = mdao;
	}


	public int insert(SysMessage sm) {
		// TODO Auto-generated method stub
		return mdao.insert(sm);
	}

	
	public int sendMes(SysMessage sm)
	{
		return mdao.insert(sm);
	}
}
