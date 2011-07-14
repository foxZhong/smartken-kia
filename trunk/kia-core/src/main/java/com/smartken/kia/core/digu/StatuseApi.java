package com.smartken.kia.core.digu;

import java.text.MessageFormat;

import com.smartken.kia.core.enums.EDataFormat;

public class StatuseApi extends BaseDiguApi {

	public StatuseApi(DiguClient digu) {
		super(digu);
		// TODO Auto-generated constructor stub
	}
	
	
	public String getPublic_timeline(EDataFormat edf){
	    String pattern="/public_timeline.{0}";
	    String url =MessageFormat.format(pattern,
	       edf		
	    );
	    return this.getString(url);
	}
	
	
	
	public static void main(String[] args){
		DiguClient diguClient=new DiguClient();
		StatuseApi statuseApi=new StatuseApi(diguClient);
		System.out.println(statuseApi.getPublic_timeline(EDataFormat.json));
	}
}
