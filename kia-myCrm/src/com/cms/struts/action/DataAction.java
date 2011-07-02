/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.cms.struts.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.cms.hibernate.data.biz.IDataBiz;
import com.cms.hibernate.data.biz.IOptionBiz;
import com.cms.hibernate.data.biz.impl.DataBizImpl;
import com.cms.hibernate.data.biz.impl.OptionBizImpl;
import com.cms.hibernate.data.ent.SysDataoptions;
import com.cms.hibernate.data.ent.SysDatas;
import com.cms.struts.form.DataForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-24-2009
 * 
 * XDoclet definition:
 * @struts.action path="/data" name="dataForm" input="/form/data.jsp" parameter="oper" scope="request" validate="true"
 * @struts.action-forward name="data_showDictonary" path="/baseData/data_showDictonary.jsp"
 */
public class DataAction extends DispatchAction {
	/*
	 * Generated Methods
	 */
    private IDataBiz dbiz=null;
    private IOptionBiz obiz=null;
	public IDataBiz getDbiz() {
		return dbiz;
	}

	public void setDbiz(IDataBiz dbiz) {
		this.dbiz = dbiz;
	}

	public IOptionBiz getObiz() {
		return obiz;
	}

	public void setObiz(IOptionBiz obiz) {
		this.obiz = obiz;
	}

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward addData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DataForm f= (DataForm) form;// TODO Auto-generated method stub
		SysDatas sd=f.getDatas();
		//sd.setDataTitle(strCon(sd.getDataTitle()));
		dbiz.insert(sd);
		ActionMessages info=new ActionMessages();
		info.add("info", new ActionMessage("data.SucAddData"));
		super.addErrors(request, info);
		return mapping.findForward("data_showDictonary");
	}
	
	public ActionForward addOption(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DataForm f= (DataForm) form;// TODO Auto-generated method stub
		SysDataoptions sdo=f.getOptions();
		//SysDatas sd=f.getDatas();
		//sd.setDataTitle(strCon(sd.getDataTitle()));
		//sdo.setOptName(strCon(sdo.getOptName()));
		//int dataId=Integer.parseInt(request.getParameter("dataId"));
		//sd.setDataId(dataId);
		//sdo.setSysDatas(sd);
		obiz.insert(sdo);
		ActionMessages info=new ActionMessages();
		info.add("info", new ActionMessage("data.SucAddDataOption"));
		super.addErrors(request, info);
		return mapping.findForward("data_showDictonary");
	}
	
	public ActionForward deleteData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DataForm f= (DataForm) form;// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("optId"));
		//sd.setDataTitle(strCon(sd.getDataTitle()));
		obiz.delete(id);
		ActionMessages info=new ActionMessages();
		info.add("info", new ActionMessage("data.SucDelDataOption"));
		super.addErrors(request, info);
		return mapping.findForward("data_showDictonary");
	}
	
	public ActionForward doEditOption(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DataForm f= (DataForm) form;
		obiz.update(f.getOptions());
		ActionMessages info=new ActionMessages();
		info.add("info", new ActionMessage("data.SucUpdateDataOption"));
		super.addErrors(request, info);
		return mapping.findForward("data_showDictonary");
	}

	
}