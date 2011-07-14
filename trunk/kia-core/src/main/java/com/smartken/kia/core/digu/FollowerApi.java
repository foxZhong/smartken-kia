package com.smartken.kia.core.digu;

import java.text.MessageFormat;

import com.smartken.kia.core.enums.EDataFormat;

public class FollowerApi extends BaseDiguApi {

	public FollowerApi(DiguClient digu) {
		super(digu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getApiRootPath() {
		// TODO Auto-generated method stub
		return "/followers";
	}
	
	
	//用来获取指定的用户被跟随的用户id。
	public String ids(EDataFormat edf,String userIdOrName) throws NoAuthException{
		String pattern="/ids/{0}.{1}";
	    String url =MessageFormat.format(pattern,
	 	       userIdOrName
	    		,edf		
	 	);
	 	return this.getResponseText(url);
	}

}
