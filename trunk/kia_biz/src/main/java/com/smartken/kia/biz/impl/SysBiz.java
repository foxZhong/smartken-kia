package com.smartken.kia.biz.impl;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;


import org.json.*;

import com.smartken.kia.biz.ISysBiz;
import com.smartken.kia.mapper.sys.IMenuMapper;
import com.smartken.kia.model.sys.MenuModel;
import com.smartken.kia.util.EasyUIHelper;
import com.smartken.kia.util.ObjectHelper;
import com.smartken.kia.util.StringHelper;


public class SysBiz implements ISysBiz {

	private IMenuMapper iMenuMapper;

	public void setiMenuTreeNodeMapper(IMenuMapper iMenuTreeNodeMapper) {
		this.iMenuMapper = iMenuTreeNodeMapper;
	}



	private JSONArray loadTreeNode(ArrayList<MenuModel> pArrTreeNode,String pParentId) 
	{
		JSONArray lArrJson=new JSONArray();
		try
		{
		for (MenuModel mtn : pArrTreeNode) {
			if(pParentId.equalsIgnoreCase(mtn.getParentId()))
			{
				JSONObject json=new JSONObject();
				JSONObject jsonAttrs=new JSONObject();
				jsonAttrs.put("url", mtn.getUrl());
				json.put(EasyUIHelper.JSON_TREE_ID, mtn.getId());
				json.put(EasyUIHelper.JSON_TREE_TEXT, mtn.getName());
				json.put(EasyUIHelper.JSON_TREE_CHILDREN, loadTreeNode(pArrTreeNode, mtn.getId()));
				json.put(EasyUIHelper.JSON_TREE_ICONCLS, mtn.getIcon());
	            json.put(EasyUIHelper.JSON_TREE_ATTRIBUTES, jsonAttrs);
				//json.put(EASYUI_TREE_IMAGE, mtn.getName());
				lArrJson.put(json);
			}
		}
		}catch(JSONException je)
		{}
		return lArrJson;
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





	public JSONArray getMenuDataGrid() {
		// TODO Auto-generated method stub
		JSONArray lArrJsonMenu=new JSONArray();
		ArrayList<MenuModel> lArrMtn=iMenuMapper.selectNotInPk(StringHelper.strToArr("root"));
		Iterator<MenuModel> lItrMtn=lArrMtn.iterator();
		while(lItrMtn.hasNext())
		{
		  lArrJsonMenu.put(lItrMtn.next().toJson());	
		}
		return lArrJsonMenu;
	}









	public MenuModel saveMenu(MenuModel pMenuModel) {
		// TODO Auto-generated method stub
		int lIntSqlResult=0;		
		MenuModel lMtnReturn=null;
		if(StringHelper.strIsBlank(pMenuModel.getId()))
		{  return pMenuModel;}
		lIntSqlResult=iMenuMapper.updateOne(pMenuModel);  
		if(lIntSqlResult==0)
		{
			pMenuModel=this.getNewPkMenu(pMenuModel);
			lIntSqlResult=iMenuMapper.insertOne(pMenuModel);
		}
		if(lIntSqlResult>0)
		{
			lMtnReturn=(MenuModel) iMenuMapper.selectEqPk(pMenuModel.getId());
		}
		return lMtnReturn;
	}



	public MenuModel getMenu(String pStrId, int query) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		MenuModel lObjReturn=null;
		String lStrId=ObjectHelper.formatString(pStrId);
		if(lStrId.length()<1)
			return null;
		if(query==StringHelper.EQ)
		{
			lObjReturn=(MenuModel) iMenuMapper.selectEqPk(lStrId);
		}
		return lObjReturn;
	}




	public JSONArray getMenuComboxTreeWithId(ArrayList<String> lListIds,
			int query) {
		// TODO Auto-generated method stub
		ArrayList<MenuModel> lArrMtn=new ArrayList<MenuModel>();
		if(query==StringHelper.NOTIN)
		{
			lArrMtn=iMenuMapper.selectNotInPk(lListIds);
		}
        return this.loadTreeNode(lArrMtn, "");
	}



	public JSONArray getMenuTreeWithId(ArrayList<String> lListId,
			int query) {
		ArrayList<MenuModel> lArrMtn=new ArrayList<MenuModel>();
        if(query==StringHelper.IN)
        {
        	lArrMtn=iMenuMapper.selectInPk(lListId);
        }
		return this.loadTreeNode(lArrMtn, "root");
	}



	public int removeMenuWithId(ArrayList pArrIds, int query) {
		// TODO Auto-generated method stub
		int lIntReturn=0;
		if(pArrIds.size()<1)
			  return lIntReturn;
		if(query==StringHelper.IN)
		{
			lIntReturn=iMenuMapper.deleteInPk(pArrIds);
		}
		return lIntReturn;
	}

    

}
