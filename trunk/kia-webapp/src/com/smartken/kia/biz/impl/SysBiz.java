package com.smartken.kia.biz.impl;


import java.util.ArrayList;
import com.smartken.kia.biz.ISysBiz;
import com.smartken.kia.core.model.impl.BaseCurdBiz;
import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.mapper.sys.IMenuMapper;
import com.smartken.kia.mapper.sys.IUserMapper;
import com.smartken.kia.model.sys.MenuModel;
import com.smartken.kia.model.sys.UserModel;
import com.smartken.kia.core.enums.QueryEnum;


public class SysBiz extends BaseCurdBiz implements ISysBiz {

	
	
	private IMenuMapper iMenuMapper;
	private IUserMapper iUserMapper;

	public void setiMenuMapper(IMenuMapper iMenuTreeNodeMapper) {
		this.iMenuMapper = iMenuTreeNodeMapper;
	}

	public void setiUserMapper(IUserMapper iUserMapper) {
		this.iUserMapper = iUserMapper;
	}


	public void loadCrudMapper(Class c)
	{
		
		if(c.equals(MenuModel.class))
		{
			this.setCrudMapper(iMenuMapper);
		}else if(c.equals(UserModel.class))
		{
			this.setCrudMapper(iUserMapper);	
		}
	}
	
	




}




	
	

