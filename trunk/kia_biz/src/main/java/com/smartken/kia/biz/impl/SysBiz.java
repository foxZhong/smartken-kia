package com.smartken.kia.biz.impl;


import java.util.ArrayList;
import com.smartken.kia.biz.ISysBiz;
import com.smartken.kia.util.model.impl.BaseCurdBiz;
import com.smartken.kia.util.page.PageBounds;
import com.smartken.kia.mapper.sys.IMenuMapper;
import com.smartken.kia.mapper.sys.IUserMapper;
import com.smartken.kia.model.sys.MenuModel;
import com.smartken.kia.model.sys.UserModel;
import com.smartken.kia.util.enums.QueryEnum;


public class SysBiz<T> extends BaseCurdBiz<T> implements ISysBiz<T> {

	
	
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
	public int addModel(T model) throws Exception {
		// TODO Auto-generated method stub
	
		return super.addModel(model);
	}

	@Override
	public ArrayList<T> getModelWithId(ArrayList lListIds, QueryEnum pQuery,PageBounds pPage)
			throws Exception {
		// TODO Auto-generated method stub
		return super.getModelWithId(lListIds, pQuery,pPage);
	}

	@Override
	public int modifyModel(T model) throws Exception {
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




	
	

