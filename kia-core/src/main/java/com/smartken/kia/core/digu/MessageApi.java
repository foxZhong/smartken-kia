package com.smartken.kia.core.digu;

import java.text.MessageFormat;

import com.smartken.kia.core.enums.EDataFormat;

public class MessageApi extends BaseDiguApi {

	public MessageApi(DiguClient digu) {
		super(digu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getApiRootPath() {
		// TODO Auto-generated method stub
		return "/messages";
	}
	
	//返回发送给认证用户的消息列表
	public String messages(EDataFormat edf,String messages) throws DiguException{
		String pattern="/{0}.{1}";
	    String url =MessageFormat.format(pattern,
	    		messages
	    		,edf		
	 	);
	 	return this.doGet(edf,url);
	}
	
	public String New(EDataFormat edf,String contend,String messages,String receiveUserId) throws DiguException{
		String pattern="/handle/new.{1}";
	    String url =MessageFormat.format(pattern,
	    		messages
	    		,edf		
	 	);
	 	return this.doGet(edf,url);
	}
	
	public String destroy(EDataFormat edf,String id) throws DiguException{
		String pattern="/handle/destroy/{0}.{1}";
	    String url =MessageFormat.format(pattern,
	    		id
	    		,edf		
	 	);
	 	return this.doGet(edf,url);
	}
	


}
