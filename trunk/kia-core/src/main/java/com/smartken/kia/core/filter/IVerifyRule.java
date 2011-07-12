package com.smartken.kia.core.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IVerifyRule {

	
	public boolean doVerifyRule(HttpServletRequest req,HttpServletResponse res);
}
