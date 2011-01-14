package com.smartken.kia.biz.impl;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.management.modelmbean.ModelMBean;


import org.json.*;

import com.smartken.kia.biz.ISysBiz;
import com.smartken.kia.mapper.IMapper;
import com.smartken.kia.mapper.sys.IMenuMapper;
import com.smartken.kia.mapper.sys.IUserMapper;
import com.smartken.kia.model.sys.MenuModel;
import com.smartken.kia.model.sys.UserModel;
import com.smartken.kia.util.EasyUIHelper;
import com.smartken.kia.util.ObjectHelper;
import com.smartken.kia.util.StringHelper;


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
	
	

	private MenuModel getNewPkMenu(MenuModel pMt)
	{
	   //MenuModel lMtParent=(MenuModel) iMenuMapper.selectEqPk(pMt.getParentId());
       String lPk="";
	   if(!pMt.getParentId().equalsIgnoreCase("root"))
	   {
		   lPk=pMt.getParentId()+"-"+pMt.getId();
		   pMt.setId(lPk);
	   }
	   return pMt;
	}

	@Override
	public int addModel(T model) throws Exception {
		// TODO Auto-generated method stub
		return super.addModel(model);
	}

	@Override
	public ArrayList<T> getModelWithId(ArrayList lListIds, int query)
			throws Exception {
		// TODO Auto-generated method stub
		return super.getModelWithId(lListIds, query);
	}

	@Override
	public int modifyModel(T model) throws Exception {
		// TODO Auto-generated method stub
		return super.modifyModel(model);
	}

	@Override
	public int removeModelWithId(ArrayList lListIds, int query)
			throws Exception {
		// TODO Auto-generated method stub
		return super.removeModelWithId(lListIds, query);
	}








}




	
	

