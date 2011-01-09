package com.smartken.kia.biz;

import java.util.ArrayList;

import org.json.JSONArray;

import com.smartken.kia.model.sys.MenuModel;

public interface ISysBiz {

	public JSONArray getMenuTreeWithId(ArrayList<String> lListTokens,int query);
	public JSONArray getMenuComboxTreeWithId(ArrayList<String> lListIds,int query);
	public JSONArray getMenuDataGrid();
	public MenuModel getMenu(String pStrId,int query);
	public int removeMenuWithId(ArrayList pArrId,int query);
	public MenuModel saveMenu(MenuModel pMenuModel);

}
