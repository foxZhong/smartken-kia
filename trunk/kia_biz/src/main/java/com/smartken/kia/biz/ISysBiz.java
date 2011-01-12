package com.smartken.kia.biz;

import java.util.ArrayList;

import org.json.JSONArray;

import com.smartken.kia.model.sys.MenuModel;

public interface ISysBiz {

	public ArrayList<MenuModel> getMenuWithId(ArrayList<String> lListTokens,int query);
	public MenuModel getMenu(String pStrId,int query);
	public int removeMenuWithId(ArrayList pArrId,int query);
	public int saveMenu(MenuModel pMenuModel);

}
