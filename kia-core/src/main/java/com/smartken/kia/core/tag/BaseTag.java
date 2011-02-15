package com.smartken.kia.core.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class BaseTag extends BodyTagSupport {

	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+":doAfterBody()");

		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+":doEndTag()");
		return super.doEndTag();
	}

	@Override
	public void doInitBody() throws JspException {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+":doInitBody()");
		super.doInitBody();
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+":doStartTag()");
		try {
			pageContext.getOut().println("叼你老母啊");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	
	

}
