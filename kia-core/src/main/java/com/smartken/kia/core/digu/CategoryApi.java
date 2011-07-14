package com.smartken.kia.core.digu;

import java.text.MessageFormat;

import com.smartken.kia.core.enums.EDataFormat;

public class CategoryApi extends BaseDiguApi {

	public CategoryApi(DiguClient digu) {
		super(digu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getApiRootPath() {
		// TODO Auto-generated method stub
		return null;
	}

	
	//在授权用户的收藏夹中创建一个分组，必须采用POST 方法。长度不能超过10 个字符,
	//否则自动截断
	public String create(EDataFormat edf,String id) throws NoAuthException{
		String pattern="/create/{0}.{1}";
	    String url =MessageFormat.format(pattern,
	    		id
	    		,edf		
	 	);
	 	return this.getResponseText(url);
	}
	

	
	//在授权用户的收藏夹中重命名一个分组，必须采用POST 方法。长度不能超过10 个字
	//符，否则自动截断
	public String update(EDataFormat edf,String oldName,String newName) throws NoAuthException{
		String pattern="/update.{0}";
	    String url =MessageFormat.format(pattern,
	    		edf		
	 	);
	 	return this.getResponseText(url);
	}
	
	
	//在授权用户的收藏夹中根据分组名字，删除这个分组，并且该分组的那些收藏信息，也
	//将被自动解除收藏关系。
	public String show(EDataFormat edf,String category) throws NoAuthException{
		String pattern="/show.{1}?category={0}";
	    String url =MessageFormat.format(pattern,
	    		category
	    		,edf		
	 	);
	 	return this.getResponseText(url);
	}
	
	//在授权用户的收藏夹中根据分组名字，删除这个分组，并且该分组的那些收藏信息，也
	//将被自动解除收藏关系。
	public String destroy(EDataFormat edf,String category) throws NoAuthException{
		String pattern="/destroy.{1}?category={0}";
	    String url =MessageFormat.format(pattern,
	    		category
	    		,edf		
	 	);
	 	return this.getResponseText(url);
	}
	
}
