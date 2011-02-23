package com.smartken.kia.model.sys;

import com.smartken.kia.core.model.impl.BaseMenuModel;
import com.smartken.kia.core.model.impl.BaseModel;

public class MenuModel extends BaseMenuModel {

	
	public static void main(String[] args){
	   	MenuModel mm1=new MenuModel();
	   	MenuModel mm2=new MenuModel();
	   	try {
		  	mm1.eval("id", "tata");
		  	mm1.eval("parma", "tatadfsfasfd");
		  	mm1.eval("descp", "dadfda");
		  	mm1.eval("seqno",8556);

			 String str= (String) mm1.eval("id");
			 System.out.println("mm1"+mm1.toJson());
		   mm2.from(mm1.toJson());
			 System.out.println("mm2"+mm2.toJson());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
