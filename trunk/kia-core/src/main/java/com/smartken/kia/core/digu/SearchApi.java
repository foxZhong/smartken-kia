package com.smartken.kia.core.digu;

import java.text.MessageFormat;

import com.smartken.kia.core.enums.EDataFormat;

public class SearchApi extends BaseDiguApi {

	public SearchApi(DiguClient digu) {
		super(digu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getApiRootPath() {
		// TODO Auto-generated method stub
		return "/search_";
	}
	
	public String search_user(EDataFormat edf,String q) throws NoAuthException{
		String pattern="user.{1}?q={0}";
	    String url =MessageFormat.format(pattern,
	    		q
	    		,edf		
	 	);
	 	return this.getResponseText(url);
	}
	
	public String search_statuses(EDataFormat edf,String q) throws NoAuthException{
		String pattern="/statuses.{1}?q={0}";
	    String url =MessageFormat.format(pattern,
	    		q
	    		,edf		
	 	);
	 	return this.getResponseText(url);
	}

}
