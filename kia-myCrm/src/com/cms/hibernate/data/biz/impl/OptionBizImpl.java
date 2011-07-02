package com.cms.hibernate.data.biz.impl;

import java.util.List;

import com.cms.hibernate.data.biz.IOptionBiz;
import com.cms.hibernate.data.dao.IOptionDAO;
import com.cms.hibernate.data.dao.impl.OptionDAOImpl;
import com.cms.hibernate.data.ent.SysDataoptions;

public class OptionBizImpl implements IOptionBiz {

	private IOptionDAO odao=null;
	
	public IOptionDAO getOdao() {
		return odao;
	}

	public void setOdao(IOptionDAO odao) {
		this.odao = odao;
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return odao.delete(id);
	}

	public List getListByUserId(int userid, int curPage, int maxItems) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(SysDataoptions sdo) {
		// TODO Auto-generated method stub
		odao.insert(sdo);
		return 0;
	}

	public int update(SysDataoptions sdo) {
		// TODO Auto-generated method stub
		SysDataoptions s=odao.getOptionById(sdo.getOptId());
		s.setOptName(sdo.getOptName());
		s.setOptValue(sdo.getOptValue());
		odao.update(s);
		return 0;
	}

	public SysDataoptions getOptionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
