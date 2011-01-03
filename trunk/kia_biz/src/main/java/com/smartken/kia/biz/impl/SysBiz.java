package com.smartken.kia.biz.impl;

import java.util.ArrayList;


import org.json.*;

import com.smartken.kia.biz.ISysBiz;
import com.smartken.kia.mapper.sys.IMenuTreeNodeMapper;
import com.smartken.kia.model.sys.MenuTreeNodeModel;
import com.smartken.kia.util.EasyUIHelper;


public class SysBiz implements ISysBiz {

	private IMenuTreeNodeMapper iMenuTreeNodeMapper;
	
	public JSONArray getJsonEasyUITree() {
		// TODO Auto-generated method stub
		ArrayList<MenuTreeNodeModel> lArrMtn=iMenuTreeNodeMapper.selectAll();
        return this.loadTreeNode(lArrMtn, "root");
	}
	


	public IMenuTreeNodeMapper getiMenuTreeNodeMapper() {
		return iMenuTreeNodeMapper;
	}



	public void setiMenuTreeNodeMapper(IMenuTreeNodeMapper iMenuTreeNodeMapper) {
		this.iMenuTreeNodeMapper = iMenuTreeNodeMapper;
	}



	private JSONArray loadTreeNode(ArrayList<MenuTreeNodeModel> pArrTreeNode,String pParentId) 
	{
		JSONArray lArrJson=new JSONArray();
		try
		{
		for (MenuTreeNodeModel mtn : pArrTreeNode) {
			if(pParentId.equalsIgnoreCase(mtn.getParentId()))
			{
				JSONObject json=new JSONObject();
				JSONObject jsonAttrs=new JSONObject();
				jsonAttrs.put("url", mtn.getUrl());
				json.put(EasyUIHelper.JSON_TREE_ID, mtn.getId());
				json.put(EasyUIHelper.JSON_TREE_TEXT, mtn.getName());
				json.put(EasyUIHelper.JSON_TREE_CHECKED, loadTreeNode(pArrTreeNode, mtn.getId()));
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


}
