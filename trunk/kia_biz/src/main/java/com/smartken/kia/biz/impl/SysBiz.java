package com.smartken.kia.biz.impl;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;


import org.json.*;

import com.smartken.kia.biz.ISysBiz;
import com.smartken.kia.mapper.sys.IMenuMapper;
import com.smartken.kia.mapper.sys.IUserMapper;
import com.smartken.kia.model.sys.MenuModel;
import com.smartken.kia.util.EasyUIHelper;
import com.smartken.kia.util.ObjectHelper;
import com.smartken.kia.util.StringHelper;


public class SysBiz implements ISysBiz {

	private IMenuMapper iMenuMapper;
	private IUserMapper iUserMapper;

	public void setiMenuMapper(IMenuMapper iMenuTreeNodeMapper) {
		this.iMenuMapper = iMenuTreeNodeMapper;
	}

	public void setiUserMapper(IUserMapper iUserMapper) {
		this.iUserMapper = iUserMapper;
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




	@SuppressWarnings("finally")
	public int saveMenu(MenuModel pMenuModel) {
		// TODO Auto-generated method stub
		int lIntSqlResult=0;		
		if(StringHelper.strIsBlank(pMenuModel.getId()))
		{  return lIntSqlResult;}
		try{
		lIntSqlResult=iMenuMapper.updateOne(pMenuModel);  
		if(lIntSqlResult==0)
		{
			pMenuModel=this.getNewPkMenu(pMenuModel);
			lIntSqlResult=iMenuMapper.insertOne(pMenuModel);
		}
		}catch(Exception ex)
        {
        	ex.printStackTrace();
        }finally{
        	return lIntSqlResult;
        }
	}



	@SuppressWarnings("finally")
	public MenuModel getMenu(String pStrId, int query) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		MenuModel lObjReturn=null;
		String lStrId=ObjectHelper.formatString(pStrId);
		if(lStrId.length()<1)
			return null;
		try{
		if(query==StringHelper.EQ)
		{
			lObjReturn=(MenuModel) iMenuMapper.selectEqPk(lStrId);
		}}catch(Exception ex)
		{ ex.printStackTrace();}finally{
        	return lObjReturn;
        }
	}





	@SuppressWarnings("finally")
	public ArrayList<MenuModel> getMenuWithId(ArrayList<String> pListId,
			int query) {
		ArrayList<MenuModel> lArrMtnReturn=new ArrayList<MenuModel>();
        try{
		if(query==StringHelper.IN)
        {
        	lArrMtnReturn=iMenuMapper.selectInPk(pListId);
        }else if(query==StringHelper.NOTIN){
        	lArrMtnReturn=iMenuMapper.selectNotInPk(pListId);
        }else if(query==StringHelper.LIKE){
        	lArrMtnReturn=iMenuMapper.selectLikePk(pListId.get(0).toString());
        }else if(query==StringHelper.ALL){
        	lArrMtnReturn=iMenuMapper.selectAll();
        }
		}catch(Exception ex)
        {
        	ex.printStackTrace();
        }finally{
        	return lArrMtnReturn;
        }
		
	}



	@SuppressWarnings("finally")
	public int removeMenuWithId(ArrayList pArrIds, int query) {
		// TODO Auto-generated method stub
		int lIntReturn=0;
		if(pArrIds.size()<1)
			  return lIntReturn;
		try{
		if(query==StringHelper.IN)
		{
			lIntReturn=iMenuMapper.deleteInPk(pArrIds);
		}}catch(Exception ex)
        {
        	ex.printStackTrace();
        }finally{
        	return lIntReturn;
        }
	}

    

}
