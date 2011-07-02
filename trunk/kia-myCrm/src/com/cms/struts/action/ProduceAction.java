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
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

import com.cms.hibernate.produces.biz.IProduceBiz;
import com.cms.hibernate.produces.biz.impl.ProduceBizImpl;
import com.cms.hibernate.produces.ent.Produces;

/** 
 * MyEclipse Struts
 * Creation date: 05-12-2009
 * 
 * XDoclet definition:
 * @struts.action path="baseData/produce" name="produceForm" input="/form/produce.jsp" parameter="oper" scope="request" validate="true"
 * @struts.action-forward name="prod_showInfo" path="/baseData/prod_showInfo.jsp"
 */
public class ProduceAction extends DispatchAction {
	/*
	 * Generated Methods
	 */
   private IProduceBiz pbiz=new ProduceBizImpl();
	public IProduceBiz getPbiz() {
	return pbiz;
}
public void setPbiz(IProduceBiz pbiz) {
	this.pbiz = pbiz;
}
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward doSearchProd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DynaActionForm pf = (DynaActionForm) form;// TODO Auto-generated method stub
		Produces p=(Produces)pf.get("produce");
		List list=pbiz.seach(p);
		if(list==null)
			request.setAttribute("list", new ArrayList());
		else
		request.setAttribute("list", list);
		return mapping.findForward("prod_showInfo");
	}
}