package com.smartken.kia.core.util;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import com.smartken.kia.core.pager.PageArrayList;

public class EasyUiUtil {


	
	public static String JSON_TREE_ID="id";
	public static String JSON_TREE_TEXT="text";
	public static String JSON_TREE_ICONCLS="iconCls";
	public static String JSON_TREE_CHILDREN="children";
	public static String JSON_TREE_ATTRIBUTES="attributes";
	public static String JSON_TREE_STATE="state";
	public static String JSON_TREE_CHECKED="checked";
	public static String JSON_DATAGRID_TOTAL="total";
	public static String JSON_DATAGRID_ROWS="rows";
	
	
	public static JSONObject toJsonDataGrid(JSONArray lArrRows)
	{
         return toJsonDataGrid(lArrRows, lArrRows.length());		
	}
	
	public static JSONObject toJsonDataGrid(JSONArray lArrRows,int pIntTotal)
	{
		JSONObject lJsonDataGrid=new JSONObject();
		try {
			lJsonDataGrid.put(JSON_DATAGRID_TOTAL, pIntTotal);
			lJsonDataGrid.put(JSON_DATAGRID_ROWS, lArrRows);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lJsonDataGrid;
		
	}
	
	
}
