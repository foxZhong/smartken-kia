package com.cms.hibernate.message.dao;

import com.cms.hibernate.message.ent.SysMessage;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

public interface IMessageDAO {

	
	public int insert(SysMessage sm);
}
