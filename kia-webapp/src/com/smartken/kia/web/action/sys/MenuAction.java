package com.smartken.kia.web.action.sys;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.opensymphony.xwork2.ModelDriven;
import com.smartken.kia.biz.ISysBiz;
import com.smartken.kia.model.sys.MenuModel;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;
import com.smartken.kia.core.enums.DataFormatEnum;
import com.smartken.kia.core.enums.QueryEnum;
import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.web.action.BaseAction;

public class MenuAction extends BaseAction 
 implements ModelDriven<MenuModel>{

	private String menuid;
	private String menuids;
	private MenuModel menu;
	
    protected ISysBiz iSysBiz;
	
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


	public String fn_modify() {
		// TODO Auto-generated method stub
		System.out.println("save:"+menu.toJson());
		int re=0;
		try {
			re = this.iSysBiz.modifyModel(menu);
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
             int re=this.iSysBiz.removeModelInPk(lListIds);
             writeHTML(""+re+"");
             return NONE;
		}else if(req.getMethod().equalsIgnoreCase(METHOD_POST))
		{
	    	lListIds.add(menu.getId());
	    	this.iSysBiz.removeModelInPk(lListIds);
	    	return INPUT;
		} 
		}catch(Exception e)
		{
		  e.printStackTrace();	
		}finally{return NONE;}
	}

	public String fn_search() {
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
	
	
	public String list_Tree() throws Exception{
		ArrayList lListToken=StringUtil.toList("root");
		ArrayList<MenuModel> lListMenu=iSysBiz.getModelNotInPk(lListToken);
		JSONArray lJsonMenu=this.loadTreeNode(lListMenu,"root");
		this.writeHTML(lJsonMenu.toString());
		return NONE;
	}
	
	
	public String list_ComboTree() throws Exception{
		ArrayList lListIds=StringUtil.toList((String) menu.getId());
	    ArrayList<MenuModel> lListMenu =iSysBiz.getModelNotInPk(lListIds);
	    JSONArray lJsonMenu=this.loadTreeNode(lListMenu,"");
	    this.writeHTML(lJsonMenu.toString());
		return NONE;
	}



	
	public String list_DataGrid() throws Exception {
		// TODO Auto-generated method stub
		PageBounds pb=this.getPager();
		ArrayList lListMenu=iSysBiz.getModelNotInPk(StringUtil.toList("root"),pb);
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
		iSysBiz.loadCrudMapper(MenuModel.class);
		if(req.getMethod().equalsIgnoreCase(METHOD_POST))
			return;
		String lStrId=ObjectUtil.formatString(this.menuid);
		if(lStrId.length()>0)
		{
			MenuModel m=(MenuModel) iSysBiz.getModelEqPk(this.menuid);
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
			lJsonDg = EasyUiUtil.toJsonDataGrid(lListMenu,iSysBiz.count());
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
		int re=iSysBiz.addModel(menu);
		return NONE;
	}

}
