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
			this.iCRUDMapper=iMenuMapper;
		}else if(c.equals(UserModel.class))
		{
		    this.iCRUDMapper=iUserMapper;	
		}
	}
	
	



	@Override
	public int addModel(Object model) throws Exception {
		// TODO Auto-generated method stub
	
		return super.addModel(model);
	}

	@Override
	public ArrayList getModelWithId(ArrayList lListIds, QueryEnum pQuery,PageBounds pPage)
			throws Exception {
		// TODO Auto-generated method stub
		return super.getModelWithId(lListIds, pQuery,pPage);
	}

	@Override
	public int modifyModel(Object model) throws Exception {
		// TODO Auto-generated method stub
		return super.modifyModel(model);
	}

	@Override
	public int removeModelWithId(ArrayList lListIds,QueryEnum pQuery)
			throws Exception {
		// TODO Auto-generated method stub
		return super.removeModelWithId(lListIds, pQuery);
	}








}




	
	

