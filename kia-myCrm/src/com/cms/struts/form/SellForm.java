/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.cms.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import com.cms.hibernate.sell.ent.Sellchance;
import com.cms.hibernate.sell.ent.Sellplan;

/** 
 * MyEclipse Struts
 * Creation date: 03-28-2009
 * 
 * XDoclet definition:
 * @struts.form name="sellForm"
 */
public class SellForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** plan property */
	private Sellplan plan=new Sellplan();

	/** chance property */
	private Sellchance chance=new Sellchance();

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the plan.
	 * @return Sellplan
	 */
	public Sellplan getPlan() {
		return plan;
	}

	/** 
	 * Set the plan.
	 * @param plan The plan to set
	 */
	public void setPlan(Sellplan plan) {
		this.plan = plan;
	}

	/** 
	 * Returns the chance.
	 * @return Sellchance
	 */
	public Sellchance getChance() {
		return chance;
	}

	/** 
	 * Set the chance.
	 * @param chance The chance to set
	 */
	public void setChance(Sellchance chance) {
		this.chance = chance;
	}
}