package com.smartken.kia.core.digu;

import java.text.MessageFormat;

import com.smartken.kia.core.enums.EDataFormat;

public class FriendApi extends BaseDiguApi {

	public FriendApi(DiguClient digu) {
		super(digu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getApiRootPath() {
		// TODO Auto-generated method stub
		return "/friends";
	}

	//用来获取指定的用户的朋友用户id。即自己跟随的人的id
	public String ids(EDataFormat edf,String userIdOrName) throws NoAuthException{
		String pattern="/ids/{0}.{1}";
	    String url =MessageFormat.format(pattern,
	 	       userIdOrName
	    		,edf		
	 	);
	 	return this.getResponseText(url);
	}
	
}
