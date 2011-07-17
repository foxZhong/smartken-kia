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
	
	public String search_user(EDataFormat edf,String q) throws DiguException{
		String pattern="user.{0}";
	    String url =MessageFormat.format(pattern,
	    		edf		
	 	);
	    this.setQ(q);
	 	return this.doGet(edf,url);
	}
	
	public String search_statuses(EDataFormat edf,String q) throws DiguException{
		String pattern="statuses.{0}";
	    String url =MessageFormat.format(pattern,
	    		edf		
	 	);
	    this.setQ(q);
	 	return this.doGet(edf,url);
	}
	
	
	
	public static void main(String[] args){
		String user="smartken";
		String pwd="chipchina";
		DiguClient digu=new DiguClient(user,pwd);
		SearchApi api=new SearchApi(digu);
		StringBuffer sbr=new StringBuffer("");
		try {
			
			api.setCount(1);
			sbr.append("search_statuses:").append(api.search_statuses(EDataFormat.json,"勋章")).append("\n");
			api.clear();
			sbr.append("search_user:").append(api.search_user(EDataFormat.json,"龟")).append("\n");
			api.clear();
			//sbr.append("destroy:").append(api.destroy(EDataFormat.json,"42746817")).append("\n");
			api.clear();

			//测试完成
			System.out.print(sbr.toString());
		} catch (DiguException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
