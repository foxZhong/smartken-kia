/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.cms.struts.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.cms.hibernate.customer.biz.ICusnoteBiz;
import com.cms.hibernate.customer.biz.ICusorderBiz;
import com.cms.hibernate.customer.biz.ICusstaffBiz;
import com.cms.hibernate.customer.biz.ICustomerBiz;
import com.cms.hibernate.customer.biz.impl.CusnoteBizImpl;
import com.cms.hibernate.customer.biz.impl.CusorderBizImpl;
import com.cms.hibernate.customer.biz.impl.CusstaffBizImpl;
import com.cms.hibernate.customer.biz.impl.CustomerBizImpl;
import com.cms.hibernate.customer.ent.Cusnote;
import com.cms.hibernate.customer.ent.Cusstaff;
import com.cms.hibernate.customer.ent.Customers;
import com.cms.struts.form.CustomerForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-27-2009
 * 
 * XDoclet definition:
 * @struts.action path="/customer" name="customerForm" input="/form/customer.jsp" scope="request" validate="true"
 */
public class CustomerAction extends DispatchAction {
	/*
	 * Generated Methods
	 */
	private ICustomerBiz customerbiz=null;
    private ICusstaffBiz cusstaffbiz=null;
    private ICusorderBiz cusorderbiz=null;
    private ICusnoteBiz cusnotebiz=null;
	public ICustomerBiz getCustomerbiz() {
		return customerbiz;
	}

	public void setCustomerbiz(ICustomerBiz customerbiz) {
		this.customerbiz = customerbiz;
	}

	public ICusstaffBiz getCusstaffbiz() {
		return cusstaffbiz;
	}

	public void setCusstaffbiz(ICusstaffBiz cusstaffbiz) {
		this.cusstaffbiz = cusstaffbiz;
	}

	public ICusorderBiz getCusorderbiz() {
		return cusorderbiz;
	}

	public void setCusorderbiz(ICusorderBiz cusorderbiz) {
		this.cusorderbiz = cusorderbiz;
	}

	public ICusnoteBiz getCusnotebiz() {
		return cusnotebiz;
	}

	public void setCusnotebiz(ICusnoteBiz cusnotebiz) {
		this.cusnotebiz = cusnotebiz;
	}

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward addCusstaff(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CustomerForm customerForm = (CustomerForm) form;// TODO Auto-generated method stub
		Cusstaff cusstaff=customerForm.getCusstaff();
		int cusId=cusstaff.getStaffCusid();
	    cusstaffbiz.insert(cusstaff);
		ActionMessages info=new ActionMessages();
		info.add("info",new ActionMessage("cus.SucAddCustomer"));
		super.addErrors(request, info);
		try {
			request.getRequestDispatcher("/customerManage/cus_showContacts.jsp?cusId="+cusId).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ActionForward delCusstaff(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int cusId=Integer.parseInt(request.getParameter("cusId"));
		int staId=Integer.parseInt(request.getParameter("staId"));
		Cusstaff cs=new Cusstaff();
		cs.setStaffId(staId);
	    cusstaffbiz.delete(cs);
		ActionMessages info=new ActionMessages();
		info.add("info",new ActionMessage("cus.SucDelCustomer"));
		super.addErrors(request, info);
		try {
			request.getRequestDispatcher("/customerManage/cus_showContacts.jsp?cusId="+cusId).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ActionForward delCustomers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CustomerForm customerForm = (CustomerForm) form;// TODO Auto-generated method stub
		Customers customer=customerForm.getCustomers();
		customerbiz.delete(customer);
		return mapping.findForward("cus_showCustomer");
	}
	
	public ActionForward updateCustomers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CustomerForm customerForm = (CustomerForm) form;// TODO Auto-generated method stub
		Customers customer=customerForm.getCustomers();
		int cusId=customer.getCusId();
		customer.setCusId(cusId);
		customerbiz.update(customer);
		ActionMessages info=new ActionMessages();
		info.add("info",new ActionMessage("cus.SucEditCustomer"));
		super.addErrors(request, info);
		try {
			request.getRequestDispatcher("/customerManage/cus_manage.jsp?cusId="+cusId).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ActionForward addCusnote(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CustomerForm customerForm = (CustomerForm) form;// TODO Auto-generated method stub
		Cusnote cusnote=customerForm.getCusnote();
		int cusId=cusnote.getNoteCusid();
	    cusnotebiz.insert(cusnote);
		ActionMessages info=new ActionMessages();
		info.add("info",new ActionMessage("cus.SucAddCustomer"));
		super.addErrors(request, info);
		try {
			request.getRequestDispatcher("/customerManage/cus_record.jsp?cusId="+cusId).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ActionForward delCusnote(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int cusId=Integer.parseInt(request.getParameter("cusId"));
		int noteId=Integer.parseInt(request.getParameter("noteId"));
		Cusnote cs=new Cusnote();
		cs.setNoteId(noteId);
		cusnotebiz.delete(cs);
		ActionMessages info=new ActionMessages();
		info.add("info",new ActionMessage("cus.SucDelCustomer"));
		super.addErrors(request, info);
		try {
			request.getRequestDispatcher("/customerManage/cus_record.jsp?cusId="+cusId).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ActionForward doDelayBleed(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CustomerForm cf = (CustomerForm) form;
		Customers c=cf.getCustomers();
		customerbiz.doDelayLose(c);
		ActionMessages info=new ActionMessages();
		info.add("info",new ActionMessage("cus.SucDelayLose"));
		super.addErrors(request, info);
		try {
			request.getRequestDispatcher("/customerManage/cus_respite_bleed.jsp?cusId="+c.getCusId()).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ActionForward doConfirmBleed(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CustomerForm cf = (CustomerForm) form;
		Customers c=cf.getCustomers();
		customerbiz.doConfirmLose(c);
		ActionMessages info=new ActionMessages();
		info.add("info",new ActionMessage("cus.SucConfirmLose"));
		super.addErrors(request, info);
		try {
			request.getRequestDispatcher("/customerManage/cus_confirmation_bleed.jsp?cusId="+c.getCusId()).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ActionForward doFollowBleed(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int cusId=Integer.parseInt(request.getParameter("cusId"));
		Customers c=new Customers();
		c.setCusId(cusId);
		customerbiz.doFollowLose(c);
		ActionMessages info=new ActionMessages();
		info.add("info",new ActionMessage("cus.SucFollowLose"));
		super.addErrors(request, info);
		try {
			request.getRequestDispatcher("/customerManage/cus_showBleed.jsp?="+cusId).forward(request, response);			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ActionForward doSearchCustomers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CustomerForm customerForm = (CustomerForm) form;
		String url=request.getParameter("url");
		Customers cus=customerForm.getCustomers();
		Cusstaff sta=customerForm.getCusstaff();
		//customerbiz.search(cus,sta);
		List list=customerbiz.search(cus,sta);
		if(list!=null)
		request.setAttribute("list", list);
		else
		request.setAttribute("list", new ArrayList());
		return mapping.findForward(url);
		
	}
}