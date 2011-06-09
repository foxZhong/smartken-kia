package com.smartken.kia.web.action.admin;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.biz.IAdminBiz;
import com.smartken.kia.model.admin.MenuModel;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;
import com.smartken.kia.core.enums.DataFormatEnum;

import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.web.action.BaseAction;

public class MenuAction extends BaseAction 
 implements ModelDriven<MenuModel>{

	private String menuid;
	private String menuids;
	private MenuModel menu;
	

	
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}


	public void setMenuids(String menuids) {
		this.menuids = menuids;
	}


	
	

	public MenuModel getModel() {
		// TODO Auto-generated method stub
		//String lStrId=ObjectHelper.formatString(_req.getParameter("id"));
        return menu;
	}


	public void setMenu(MenuModel menu) {
		this.menu = menu;
	}


	public String fn_modify() {
		// TODO Auto-generated method stub
		System.out.println("save:"+menu.toJson());
		int re=0;
		try {
			re = this.adminBiz.modifyModel(menu).getRe();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeHTML(re+"");
		return NONE;
	}


	public String fn_remove() {
		// TODO Auto-generated method stub
		HttpServletRequest req=this.getRequest();
		ArrayList lListIds=new ArrayList();
		try{
	    if(menuids!=null&&req.getMethod().equalsIgnoreCase(METHOD_GET))
		{
             lListIds=StringUtil.splitToList(menuids,",");
             int re=this.adminBiz.removeModelInPk(lListIds).getRe();
             writeHTML(""+re+"");
             return NONE;
		}else if(req.getMethod().equalsIgnoreCase(METHOD_POST))
		{
	    	lListIds.add(menu.getId());
	    	this.adminBiz.removeModelInPk(lListIds);
	    	return INPUT;
		} 
		}catch(Exception e)
		{
		  e.printStackTrace();	
		}finally{return NONE;}
	}

	public String fn_search() {
		// TODO Auto-generated method stub
		//JSONArray lArrJson=adminBiz.getMenuDataGrid();
		//System.out.println(adminBiz.getMenuDataGrid().toString());
		//this.writeHTML(EasyUIHelper.toJsonDataGrid(adminBiz.getMenuDataGrid()).toString());
		return NONE;
	}



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	
	public String list_Tree() throws Exception{
		ArrayList lListToken=StringUtil.toList("root");
		List<MenuModel> lListMenu=adminBiz.getModelNotInPk(lListToken);
		JSONArray lJsonMenu=this.loadTreeNode(lListMenu,"root");
		this.writeHTML(lJsonMenu.toString());
		return NONE;
	}
	
	
	public String list_ComboTree() throws Exception{
		ArrayList lListIds=StringUtil.toList((String) menu.getId());
	    List<MenuModel> lListMenu =adminBiz.getModelNotInPk(lListIds);
	    JSONArray lJsonMenu=this.loadTreeNode(lListMenu,"");
	    this.writeHTML(lJsonMenu.toString());
		return NONE;
	}



	
	public String list_DataGrid() throws Exception {
		// TODO Auto-generated method stub
		PageBounds pb=this.getPager();
		ArrayList lListMenu=adminBiz.getModelNotInPk(StringUtil.toList("root"),pb);
		//System.out.println("list:"+lArrJson.toString());
		if(this.getDataFormat().equalsIgnoreCase(DataFormatEnum.json.toString()))
		{
		  JSONObject lJsonDg=this.loadJsonDataGrid(lListMenu);
		  this.writeHTML(lJsonDg.toString());
		  return NONE;
		}else if(this.getDataFormat().equalsIgnoreCase(DataFormatEnum.xml.toString()))
		{
			return NONE;
		}
		return NONE;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest req=this.getRequest();
		adminBiz.loadCrudMapper(MenuModel.class);
		if(req.getMethod().equalsIgnoreCase(METHOD_POST))
			return;
		String lStrId=ObjectUtil.formatString(this.menuid);
		if(lStrId.length()>0)
		{
			MenuModel m=(MenuModel) adminBiz.getModelEqPk(this.menuid);
		    this.menu=m;
		
		}else
		{
			this.clear();
		}
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.menu=new MenuModel();
		this.menuid="";
		this.menuids="";
	}
	
	
	
	
	private JSONArray loadTreeNode(List<MenuModel> pArrTreeNode,String pParentId) 
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
				json.put(EasyUiUtil.JSON_TREE_ID, mtn.getId());
				json.put(EasyUiUtil.JSON_TREE_TEXT, mtn.getName());
				json.put(EasyUiUtil.JSON_TREE_CHILDREN, loadTreeNode(pArrTreeNode, (String) mtn.getId()));
				json.put(EasyUiUtil.JSON_TREE_ICONCLS, mtn.getIcon());
	            json.put(EasyUiUtil.JSON_TREE_ATTRIBUTES, jsonAttrs);
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
		JSONArray lListMenu=ObjectUtil.toJsonArray(pListMenu);
		JSONObject lJsonDg=null;
		try {
			lJsonDg = EasyUiUtil.toJsonDataGrid(lListMenu,adminBiz.count());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lJsonDg;
	}



	
	public String to_edit() throws Exception {
		// TODO Auto-generated method stub
		return INPUT;
	}
	
	public String to_add() throws Exception {
		// TODO Auto-generated method stub
		return INPUT;
	}


	public String fn_add() throws Exception {
		// TODO Auto-generated method stub
		int re=adminBiz.addModel(menu).getRe();
		return NONE;
	}


	public boolean isGet() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isPost() {
		// TODO Auto-generated method stub
		return false;
	}


	public void setRequestAttribute(Enum en, Object obj) {
		// TODO Auto-generated method stub
		
	}


	public void setRequestAttribute(String key, Object obj) {
		// TODO Auto-generated method stub
		
	}


	public void setSessionAttribute(Enum en, Object obj) {
		// TODO Auto-generated method stub
		
	}


	public void setSessionAttribute(String key, Object obj) {
		// TODO Auto-generated method stub
		
	}


	public void writeStream(byte[] image) {
		// TODO Auto-generated method stub
		
	}

}
