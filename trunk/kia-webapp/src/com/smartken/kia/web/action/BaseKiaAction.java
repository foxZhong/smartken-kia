package com.smartken.kia.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.smartken.kia.biz.IAdminBiz;
import com.smartken.kia.core.enums.EDataFormat;
import com.smartken.kia.core.model.IBaseAction;
import com.smartken.kia.core.model.impl.BaseAction;
import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.core.util.ObjectUtil;



public abstract class BaseKiaAction extends BaseAction 
implements Preparable,IBaseAction
{


	protected IAdminBiz adminBiz;
	
	
	

	public void setAdminBiz(IAdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}

	
	

}
