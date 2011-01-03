package com.smartken.kia.web.struts2.sys;

import com.opensymphony.xwork2.ActionSupport;
import com.smartken.kia.biz.ISysBiz;



public class MenuTreeNodeAction extends ActionSupport {

	private ISysBiz iSysBiz;

	public ISysBiz getiSysBiz() {
		return iSysBiz;
	}

	public void setiSysBiz(ISysBiz iSysBiz) {
		this.iSysBiz = iSysBiz;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	    System.out.println(iSysBiz.getJsonEasyUITree().toString());
	    
		return SUCCESS;
	}
	
	

}
