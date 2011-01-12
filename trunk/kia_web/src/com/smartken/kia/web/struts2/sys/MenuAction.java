package com.smartken.kia.web.struts2.sys;


import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.biz.ISysBiz;
import com.smartken.kia.model.sys.MenuModel;
import com.smartken.kia.util.EasyUIHelper;
import com.smartken.kia.util.ObjectHelper;
import com.smartken.kia.util.StringHelper;
import com.smartken.kia.util.model.IJsonModel;
import com.smartken.kia.web.struts2.BaseAction;

public class MenuAction extends BaseAction 
 implements ModelDriven<MenuModel>{

	private String menuid;
	private String menuids;
	private ISysBiz iSysBiz;
	private MenuModel menu;
	
	
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}


	public void setMenuids(String menuids) {
		this.menuids = menuids;
	}




	public void setiSysBiz(ISysBiz iSysBiz) {
		this.iSysBiz = iSysBiz;
	}

	
	

	public MenuModel getModel() {
		// TODO Auto-generated method stub
		//String lStrId=ObjectHelper.formatString(_req.getParameter("id"));
        return menu;
	}


	public void setMenu(MenuModel menu) {
		this.menu = menu;
	}

	@Override
	public String save() {
		// TODO Auto-generated method stub
		System.out.println("save:"+menu.toJson());
		int re=this.iSysBiz.saveMenu(menu);
		writeHTML(re+"条菜单记录保存成功");
		return NONE;
	}

	@Override
	public String remove() {
		// TODO Auto-generated method stub
		System.out.println("remove:"+_req.getMethod());
		ArrayList<String> lListIds=new ArrayList<String>();
	    if(menuids!=null&&_req.getMethod().equalsIgnoreCase(METHOD_GET))
		{
             lListIds=StringHelper.strSplitArr(menuids,",");
             int re=this.iSysBiz.removeMenuWithId(lListIds,StringHelper.IN);
             writeHTML("成功删除"+re+"条记录");
             return NONE;
		}else if(_req.getMethod().equalsIgnoreCase(METHOD_POST))
		{
	    	lListIds.add(menu.getId());
	    	this.iSysBiz.removeMenuWithId(lListIds,StringHelper.IN);;
	    	return INPUT;
		}else
	      return NONE;
	}

	@Override
	public String search() {
		// TODO Auto-generated method stub
		//JSONArray lArrJson=iSysBiz.getMenuDataGrid();
		//System.out.println(iSysBiz.getMenuDataGrid().toString());
		//this.writeHTML(EasyUIHelper.toJsonDataGrid(iSysBiz.getMenuDataGrid()).toString());
		return NONE;
	}



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	@Override
	public String listTree() throws Exception{
		ArrayList lListToken=StringHelper.strToArr("root");
		ArrayList<MenuModel> lListMenu=iSysBiz.getMenuWithId(lListToken,StringHelper.NOTIN);
		JSONArray lJsonMenu=this.loadTreeNode(lListMenu,"root");
		this.writeHTML(lJsonMenu.toString());
		return NONE;
	}
	
	@Override
	public String listComboTree() throws Exception{
		ArrayList lListIds=StringHelper.strToArr("");
	    ArrayList<MenuModel> lListMenu =iSysBiz.getMenuWithId(lListIds,StringHelper.ALL);
	    JSONArray lJsonMenu=this.loadTreeNode(lListMenu,"");
	    this.writeHTML(lJsonMenu.toString());
		return NONE;
	}

	@Override
	public String edit() throws Exception {
		// TODO Auto-generated method stub
        System.out.println("edit");
		return INPUT;
	}

	@Override
	public String add() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("add");
		this.clear();
		return INPUT;
	}

	
	public String listDataGrid() throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList lListMenu=iSysBiz.getMenuWithId(StringHelper.strToArr("root"), StringHelper.NOTIN);
		//System.out.println("list:"+lArrJson.toString());
		if(format==null||format.equalsIgnoreCase(FORMAT_JSON))
		{
		  JSONObject lJsonDg=this.loadJsonDataGrid(lListMenu);
		  this.writeHTML(lJsonDg.toString());
		  return NONE;
		}else if(format.equalsIgnoreCase(FORMAT_XML))
		{
			return NONE;
		}
		return NONE;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		if(_req.getMethod().equalsIgnoreCase(METHOD_POST))
			return;
		String lStrId=ObjectHelper.formatString(this.menuid);
		if(lStrId.length()>0)
		{
			menu=iSysBiz.getMenu(this.menuid,StringHelper.EQ);
			menu=menu!=null?menu:new MenuModel();
		}else
		{
			this.clear();
		}
	}


	@Override
	protected void clear() {
		// TODO Auto-generated method stub
		this.menu=new MenuModel();
		this.menuid="";
		this.menuids="";
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
	
	private JSONObject loadJsonDataGrid(ArrayList pListMenu)
	{
		JSONArray lListMenu=ObjectHelper.toJsonArray(pListMenu);
		JSONObject lJsonDg=EasyUIHelper.toJsonDataGrid(lListMenu);
		return lJsonDg;
	}

}
