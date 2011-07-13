/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.cms.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.cms.hibernate.customer.ent.Customers;
import com.cms.hibernate.services.biz.IServicesBiz;
import com.cms.hibernate.services.biz.impl.ServicesBizImpl;
import com.cms.hibernate.services.ent.Services;
import com.cms.struts.form.ServicesForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-25-2009
 * 
 * XDoclet definition:
 * @struts.action path="/services" name="servicesForm" input="/form/services.jsp" parameter="oper" scope="request" validate="true"
 */
public class ServicesAction extends DispatchAction {
	/*
	 * Generated Methods
	 */
    private IServicesBiz sbiz=null;
	public IServicesBiz getSbiz() {
		return sbiz;
	}

	public void setSbiz(IServicesBiz sbiz) {
		this.sbiz = sbiz;
	}

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
    
    public ActionForward doFileService(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	    ServicesForm f = (ServicesForm) form;
        Services s=f.getServices();
        int serId=Integer.parseInt(request.getParameter("serID"));
        s.setSerId(serId);
        System.out.println("����鵵");
        sbiz.doFile(s);
    	ActionMessages info=new ActionMessages();
		info.add("info",new ActionMessage("serivce.SucFileService"));
		super.addErrors(request, info);
		return mapping.findForward("ser_showFile");
		}
    
	public ActionForward addService(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ServicesForm f = (ServicesForm) form;// TODO Auto-generated method stub
		Services s=f.getServices();
		//s.setSerContext(CodeHelper.toGB2312(s.getSerContext()));
		//s.setSerRequset(CodeHelper.toGB2312(s.getSerRequset()));
		System.out.println("�����·���");
		sbiz.createService(s);
		ActionMessages info=new ActionMessages();
		info.add("info",new ActionMessage("serivce.SucCreateService"));
		super.addErrors(request, info);
		return mapping.findForward("ser_doCreate");
	}
	
	public ActionForward doHandle(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ServicesForm f = (ServicesForm) form;// TODO Auto-generated method stub
		Services s=f.getServices();
		//s.setSerContext(CodeHelper.toGB2312(s.getSerContext()));
		//s.setSerRequset(CodeHelper.toGB2312(s.getSerRequset()));

		System.out.println("��������");
		sbiz.doHandle(s);
		return mapping.findForward("ser_showHandle");
	}
	
	public ActionForward doFeedBack(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ServicesForm f = (ServicesForm) form;// TODO Auto-generated method stub
		Services s=f.getServices();
		System.out.println("��������");
		sbiz.doFeedBack(s);
		return mapping.findForward("ser_showFeedBack");
	}
	
	public ActionForward doAssignService(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ServicesForm f = (ServicesForm) form;// TODO Auto-generated method stub
		Services s=f.getServices();
		System.out.println("�������");
		sbiz.doAssgin(s);
		ActionMessages info=new ActionMessages();
		info.add("info",new ActionMessage("service.SucUpdateAssigner"));
		super.addErrors(request, info);
		return mapping.findForward("ser_showAssign");
	}
	
	public ActionForward doDeleteService(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ServicesForm f = (ServicesForm) form;// TODO Auto-generated method stub
		Services s=f.getServices();
		System.out.println("ɾ������");
		int serId=Integer.parseInt(request.getParameter("serId"));
		sbiz.delete(serId);
		ActionMessages info=new ActionMessages();
		info.add("info",new ActionMessage("serivce.SucDelService"));
		super.addErrors(request, info);
		return mapping.findForward("ser_showAssign");
	}
	
	public ActionForward searchServices(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ServicesForm f = (ServicesForm) form;
		Services s=f.getServices();
		Customers c=f.getCustomer();
		String url=request.getParameter("url");
		System.out.println("��������");
		List list=sbiz.search(s,c,0, 0);
		if(list!=null)
		{
		System.out.print("�ѵ�����"+list.size());
		request.setAttribute("list", list);
		}
		else
		request.setAttribute("list", new ArrayList());
		return mapping.findForward(url);
	}
	
}
	