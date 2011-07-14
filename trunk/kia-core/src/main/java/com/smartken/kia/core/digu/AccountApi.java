package com.smartken.kia.core.digu;

import java.io.File;
import java.text.MessageFormat;

import com.smartken.kia.core.enums.EDataFormat;

public class AccountApi extends BaseDiguApi {

	public AccountApi(DiguClient digu) {
		super(digu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getApiRootPath() {
		// TODO Auto-generated method stub
		return "/account";
	}
	
	
	//用来验证用户账户密码是否匹配，用户账户密码信息必须通过AUTH_HTTP 方式提
	//供，返回信息中包含了用户登录名、OpenID(如果可用的话)等信息；
	public String verify(EDataFormat edf,boolean isAllInfo) throws NoAuthException{
		String pattern="/verify.{1}?isAllInfo={0}";
	    String url =MessageFormat.format(pattern,
	    		isAllInfo
	    		,edf		
	 	);
	 	return this.getResponseText(url);
	}
	
	//用来更新用户自己风格的设置。比如：背景颜色、文字颜色、链接颜色、边栏底色、边
	//栏文字颜色、边栏主菜单文字颜色、边栏主菜单背景颜色。必须使用POST 请求。注意，颜
	//色的值必须是以#开头，后面是描述颜色的字符或者六位数字的颜色
	public String update_profile_colors(EDataFormat edf) throws NoAuthException{
		String pattern="/update_profile_colors.{0}";
	    String url =MessageFormat.format(pattern,
	    		edf		
	 	);
	 	return this.getResponseText(url);
	}
	
	public String update_profile_image(EDataFormat edf,File image) throws NoAuthException{
		String pattern="/update_profile_image.{0}";
	    String url =MessageFormat.format(pattern,
	    		edf		
	 	);
	 	return this.getResponseText(url);
	}
	
	public String update_profile_bg_image(EDataFormat edf,File image) throws NoAuthException{
		String pattern="/update_profile_bg_image.{0}";
	    String url =MessageFormat.format(pattern,
	    		edf		
	 	);
	 	return this.getResponseText(url);
	}
	
	public String update_profile(EDataFormat edf) throws NoAuthException{
		String pattern="/update_profile.{0}";
	    String url =MessageFormat.format(pattern,
	    		edf		
	 	);
	 	return this.getResponseText(url);
	}


}
