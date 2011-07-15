package com.smartken.kia.core.digu;

import java.text.MessageFormat;

import com.smartken.kia.core.enums.EDataFormat;

public class FavoriteApi extends BaseDiguApi {

	public FavoriteApi(DiguClient digu) {
		super(digu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getApiRootPath() {
		// TODO Auto-generated method stub
		return "/favorites";
	}

	//返回授权用户的最新的20 条收藏的嘀咕信息。也可以通过id 或者用户名来指定一个用
	//户，查询他最新的20 条收藏的嘀咕信息。
	public String favorites(EDataFormat edf,String userIdOrName) throws DiguException{
		String pattern="/{0}.{1}";
	    String url =MessageFormat.format(pattern,
	    		userIdOrName
	    		,edf		
	 	);
	 	return this.doGet(edf,url);
	}
	
	//收藏一条嘀咕信息POST 提交
	public String create(EDataFormat edf,String id) throws DiguException{
		String pattern="/create/{0}.{1}";
	    String url =MessageFormat.format(pattern,
	    		id
	    		,edf		
	 	);
	 	return this.doGet(edf,url);
	}
	
	
	//收藏一条嘀咕信息POST 提交
	public String destroy(EDataFormat edf,String id) throws DiguException{
		String pattern="/destroy/{0}.{1}";
	    String url =MessageFormat.format(pattern,
	    		id
	    		,edf		
	 	);
	 	return this.doGet(edf,url);
	}
}
