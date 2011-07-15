package com.smartken.kia.core.digu;

import java.text.MessageFormat;

import com.smartken.kia.core.enums.EDataFormat;

public class RegApi extends BaseDiguApi {

	public RegApi(DiguClient digu) {
		super(digu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getApiRootPath() {
		// TODO Auto-generated method stub
		return "/reg";
	}
	
	//提交用户注册的相关信息，注册成功将返回该用户的信息，不成功，返回对应错误信息。
	//必须用Post 方法，不需要认证。
	public String reg(EDataFormat edf,String username,String nickname,String pwd,String confirmPwd,String email) throws DiguException{
		String pattern=".{0}";
	    String url =MessageFormat.format(pattern,
	    edf		
	 	);
	 	return this.doGet(edf,url);
	}
	
	//验证用户名是否已经被注册，Get 请求。
	public String check(EDataFormat edf,String username) throws DiguException{
		String pattern="/check.{1}?username={0}";
	    String url =MessageFormat.format(pattern,
	    		username
	    		,edf		
	 	);
	 	return this.doGet(edf,url);
	}

}
