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
import com.smartken.kia.model.admin.UserModel;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.util.StringUtil;
import com.smartken.kia.core.enums.DataFormatEnum;

import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.model.impl.ResultModel;
import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.web.action.BaseAction;

public class MenuAction extends BaseAction 
 implements ModelDriven<MenuModel>{

	public static String comboTreeMenuPath="admin/Menu/comboTree/menu.action";
	public static String datagridMenuPath="admin/Menu/datagrid/menu.action";
	
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


	public void do_saveMenu() {
		// TODO Auto-generated method stub
        this.adminBiz.loadCrudMapper(UserModel.class);
		ResultModel reModel=this.adminBiz.modifyOrAddModel(this.menu);
		this.writePlainText(reModel.toJson().toString());
		
	}


	public void do_removeMenu() {
		// TODO Auto-generated method stub
		HttpServletRequest req=this.getRequest();
		ArrayList lListIds=new ArrayList();
		try{
	    if(menuids!=null&&req.getMethod().equalsIgnoreCase(METHOD_GET))
		{
             lListIds=StringUtil.splitToList(menuids,",");
             int re=this.adminBiz.removeModelInPk(lListIds).getRe();
             writeHTML(""+re+"");
            
		}else if(req.getMethod().equalsIgnoreCase(METHOD_POST))
		{
	    	lListIds.add(menu.getId());
	    	this.adminBiz.removeModelInPk(lListIds);
	    	
		} 
		}catch(Exception e)
		{
		  e.printStackTrace();	
		}
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
	
	
	public String tree_menu() throws Exception{
		ArrayList lListToken=StringUtil.toList("root");
		List<MenuModel> lListMenu=adminBiz.getModelNotInPk(lListToken);
		JSONArray lJsonMenu=this.loadTreeNode(lListMenu,"root");
		this.writeHTML(lJsonMenu.toString());
		return NONE;
	}
	
	
	public void comboTree_menu() throws Exception{
		this.adminBiz.loadCrudMapper(UserModel.class);
		ArrayList lListIds=StringUtil.toList((String) menu.getId());
	    List<MenuModel> lListMenu =adminBiz.getModel();
	    JSONArray lJsonMenu=this.loadTreeNode(lListMenu,"0");
	    this.writePlainText(lJsonMenu.toString());
		
	}



	
	public void datagrid_menu() throws Exception {
		// TODO Auto-generated method stub
		PageBounds pb=this.getPager();
		ArrayList lListMenu=adminBiz.getModelNotInPk(StringUtil.toList("root"),pb);
        JSONObject datagrid=EasyUiUtil.toJsonDataGrid(lListMenu);
        this.writePlainText(datagrid.toString());
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
