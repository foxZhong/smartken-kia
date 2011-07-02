package com.cms.hibernate.message.biz;

import com.cms.hibernate.message.dao.IMessageDAO;
import com.cms.hibernate.message.ent.SysMessage;

public interface IMessageBiz extends IMessageDAO{

	
	public int sendMes(SysMessage sm);
}
