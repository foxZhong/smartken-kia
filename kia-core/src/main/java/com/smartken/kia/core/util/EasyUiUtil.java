package com.smartken.kia.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import com.smartken.kia.core.model.IFormatterModel;
import com.smartken.kia.core.model.impl.EasyUiModel;
import com.smartken.kia.core.model.impl.JsMapModel;
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
	public static String EDITOR_TYPE="type";
	public static String EDITOR_OPTIONS="options";
	public static String EDITOR_TYPE_TEXT="text";
	public static String EDITOR_TYPE_HIDDEN="hidden";
	public static String EDITOR_TYPE_TEXTAREA="textarea";
	public static String EDITOR_TYPE_CHECKBOX="checkbox";
	public static String EDITOR_TYPE_NUMBERBOX="numberbox";
	public static String EDITOR_TYPE_VALIDATEBOX="validatebox";
	public static String EDITOR_TYPE_DATEBOX="datebox";
	public static String EDITOR_TYPE_COMBOBOX="combobox";
	public static String EDITOR_TYPE_COMBOTREE="combotree";
	
	public static JSONObject toJsonDataGrid(List<IFormatterModel> list){
		JSONArray jarr=ObjectUtil.toJsonArray(list);
		return toJsonDataGrid(jarr);
	}
	
	public static JSONObject toJsonDataGrid(List<IFormatterModel> list,int pIntTotal){
		JSONArray jarr=ObjectUtil.toJsonArray(list);
		return toJsonDataGrid(jarr,pIntTotal);
	}
	
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
	
	public static JsMapModel createTextColumn(String field){
		return createTextColumn(field, false);
	}
	
	public static JsMapModel createTextColumn(Enum en){
		return createTextColumn(en.name(), true);
	}
	
	public static JsMapModel createTextColumn(String field,boolean isStr){
		JsMapModel column=new JsMapModel();
		column.put(EasyUiModel.DataGrid.ColumnProperties.FIELD, field,isStr);
		column.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH, 200);
		JsMapModel editor=createTextEditor(null);
		column.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,editor);
		return column;
	}
	
	public static JsMapModel createTextareaColumn(String field){
		return createTextareaColumn(field, false);
	}
	
	public static JsMapModel createTextareaColumn(Enum en){
		return createTextareaColumn(en.name(), true);
	}
	
	public static JsMapModel createTextareaColumn(String field,boolean isStr){
		JsMapModel column=new JsMapModel();
		column.put(EasyUiModel.DataGrid.ColumnProperties.FIELD, field,isStr);
		column.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH, 200);
		JsMapModel editor=createTextareaEditor(false,null);
		column.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,editor);
		return column;
	}
	
	public static JsMapModel createIntColumn(String field){
		return createIntColumn(field,false);
	}
	
	public static JsMapModel createIntColumn(Enum en){
		return createIntColumn(en.name(), true);
	}
	
	public static JsMapModel createIntColumn(String field,boolean isStr){
		JsMapModel column=new JsMapModel();
		column.put(EasyUiModel.DataGrid.ColumnProperties.FIELD, field,isStr);
		column.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH, 200);
		JsMapModel editor=createIntEditor(true, null);
		column.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,editor);
		return column;
	}
	
	public static JsMapModel createDoubleColumn(String field){
		return createDoubleColumn(field, false);
	}
	
	public static JsMapModel createDoubleColumn(Enum en){
		return createDoubleColumn(en.name(), true);
	}
	
	public static JsMapModel createDoubleColumn(String field,boolean isStr){
		JsMapModel column=new JsMapModel();
		column.put(EasyUiModel.DataGrid.ColumnProperties.FIELD, field,isStr);
		column.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH, 200);
		JsMapModel editor=createDoubleEditor(true, null);
		column.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,editor);
		return column;
	}
	
	public static JsMapModel createDateTimeColumn(String field){
		return createDateTimeColumn(field, false);
	}
	
	public static JsMapModel createDateTimeColumn(Enum en){
		return createDateTimeColumn(en.name(), true);
	}
	
	public static JsMapModel createDateTimeColumn(String field,boolean isStr){
		JsMapModel column=new JsMapModel();
		column.put(EasyUiModel.DataGrid.ColumnProperties.FIELD, field,isStr);
		column.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH, 150);
		JsMapModel editor=createDateboxEditor(true, null);
		column.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,editor);
		return column;	
	}
	
	public static JsMapModel createDateColumn(String field){
		return createDateColumn(field, false);
	}
	
	public static JsMapModel createDateColumn(Enum en){
		return createDateColumn(en.name(), true);
	}
	
	public static JsMapModel createDateColumn(String field,boolean isStr){
		JsMapModel column=new JsMapModel();
		column.put(EasyUiModel.DataGrid.ColumnProperties.FIELD, field,isStr);
		column.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH, 100);
		JsMapModel editor=createDateboxEditor(true, null);
		column.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,editor);
		return column;	
	}
	
	public static JsMapModel createCheckBoxColumn(String field){
		return createCheckBoxColumn(field, false);
	}
	
	public static JsMapModel createCheckBoxColumn(Enum en){
		return createCheckBoxColumn(en.name(), true);
	}
	
	public static JsMapModel createCheckBoxColumn(String field,boolean isStr){
		JsMapModel column=new JsMapModel();
		column.put(EasyUiModel.DataGrid.ColumnProperties.FIELD, field,isStr);
		column.put(EasyUiModel.DataGrid.ColumnProperties.CHECKBOX, true);
		//column.put(EasyUiModel.DataGrid.ColumnProperties.FORMATTER, "dateboxFormatter");
		return column;	
	}
	
	public static JsMapModel createOperaColumn(){
		JsMapModel column=new JsMapModel();
		column.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"操作",true);
		column.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,60);
		column.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,"xx",true);
		column.put(EasyUiModel.DataGrid.ColumnProperties.FORMATTER,"operaFormatter");
		return column;
	}
	
	public static JsMapModel createHiddenEditor(){
		JsMapModel editor=new JsMapModel();
		editor.put(EasyUiUtil.EDITOR_TYPE, EasyUiUtil.EDITOR_TYPE_HIDDEN,true);
		return editor;
	}
	
	public static JsMapModel createTextEditor(JsMapModel opts){
		JsMapModel editor=new JsMapModel();
		editor.put(EasyUiUtil.EDITOR_TYPE, EasyUiUtil.EDITOR_TYPE_TEXT,true);
		
		return editor;
	}
	
	public static JsMapModel createTextareaEditor(boolean required,JsMapModel opts){
		JsMapModel editor=new JsMapModel();
		editor.put(EasyUiUtil.EDITOR_TYPE, EasyUiUtil.EDITOR_TYPE_TEXTAREA,true);
		opts=opts==null?new JsMapModel():opts;
		opts.put(EasyUiModel.ValidateBox.Properties.REQUIRED,required);
		editor.put(EasyUiUtil.EDITOR_OPTIONS, opts);
		return editor;
	}
	
	public static JsMapModel createValidateboxEditor(boolean required,JsMapModel opts){
		JsMapModel editor=new JsMapModel();
		editor.put(EasyUiUtil.EDITOR_TYPE, EasyUiUtil.EDITOR_TYPE_VALIDATEBOX,true);
		opts=opts==null?new JsMapModel():opts;
		if(!opts.containsKey(EasyUiModel.ValidateBox.Properties.REQUIRED)){
			opts.put(EasyUiModel.ValidateBox.Properties.REQUIRED, required);
		}
		editor.put(EasyUiUtil.EDITOR_OPTIONS, opts);
		return editor;
	}
	
	public static JsMapModel createIntEditor(boolean required,JsMapModel opts){
		JsMapModel editor=new JsMapModel();
		editor.put(EasyUiUtil.EDITOR_TYPE,EasyUiUtil.EDITOR_TYPE_NUMBERBOX,true);
		opts=opts==null?new JsMapModel():opts;
		if(!opts.containsKey(EasyUiModel.NumberBox.Properties.PRECISION)){
			opts.put(EasyUiModel.NumberBox.Properties.PRECISION, 0);
		}
		if(!opts.containsKey(EasyUiModel.Spinner.Properties.INCREMENT)){
			opts.put(EasyUiModel.Spinner.Properties.INCREMENT, 10);
		}
		if(!opts.containsKey(EasyUiModel.NumberBox.Properties.REQUIRED)){
			opts.put(EasyUiModel.NumberBox.Properties.REQUIRED, required);
		}
		editor.put(EasyUiUtil.EDITOR_OPTIONS, opts);
		return editor;
	}
	
	public static JsMapModel createDoubleEditor(boolean required,JsMapModel opts){
		JsMapModel editor=new JsMapModel();
		editor.put(EasyUiUtil.EDITOR_TYPE,EasyUiUtil.EDITOR_TYPE_NUMBERBOX,true);
		opts=opts==null?new JsMapModel():opts;
		if(!opts.containsKey(EasyUiModel.NumberBox.Properties.PRECISION)){
			opts.put(EasyUiModel.NumberBox.Properties.PRECISION, 2);
		}
		if(!opts.containsKey(EasyUiModel.Spinner.Properties.INCREMENT)){
			opts.put(EasyUiModel.Spinner.Properties.INCREMENT, 10);
		}
		if(!opts.containsKey(EasyUiModel.NumberBox.Properties.REQUIRED)){
			opts.put(EasyUiModel.NumberBox.Properties.REQUIRED, required);
		}
		editor.put(EasyUiUtil.EDITOR_OPTIONS, opts);
		return editor;
	}
	
	public static JsMapModel createComboboxEditor(boolean required,JsMapModel opts){
		JsMapModel editor=new JsMapModel();
		editor.put(EasyUiUtil.EDITOR_TYPE,EasyUiUtil.EDITOR_TYPE_COMBOBOX,true);
		opts=opts==null?new JsMapModel():opts;
		if(!opts.containsKey(EasyUiModel.ComboBox.Properties.REQUIRED)){
			opts.put(EasyUiModel.ComboBox.Properties.REQUIRED,required);
		}
		if(!opts.containsKey(EasyUiModel.ComboBox.Properties.VALUE_FIELD)){
			opts.put(EasyUiModel.ComboBox.Properties.VALUE_FIELD,"Id",true);
		}
		if(!opts.containsKey(EasyUiModel.ComboBox.Properties.TEXT_FIELD)){
			opts.put(EasyUiModel.ComboBox.Properties.TEXT_FIELD,"Name",true);
		}
		
		editor.put(EasyUiUtil.EDITOR_OPTIONS, opts);
		return editor;
	}
	
	public static JsMapModel createComboTreeEditor(boolean required,JsMapModel opts){
		JsMapModel editor=new JsMapModel();
		editor.put(EasyUiUtil.EDITOR_TYPE,EasyUiUtil.EDITOR_TYPE_COMBOTREE,true);
		opts=opts==null?new JsMapModel():opts;
		if(!opts.containsKey(EasyUiModel.ComboTree.Properties.REQUIRED)){
			opts.put(EasyUiModel.ComboTree.Properties.REQUIRED,required);
		}
		if(!opts.containsKey(EasyUiModel.ComboBox.Properties.VALUE_FIELD)){
			opts.put(EasyUiModel.ComboBox.Properties.VALUE_FIELD,"Id",true);
		}
		if(!opts.containsKey(EasyUiModel.ComboBox.Properties.TEXT_FIELD)){
			opts.put(EasyUiModel.ComboBox.Properties.TEXT_FIELD,"Name",true);
		}
		editor.put(EasyUiUtil.EDITOR_OPTIONS, opts);
		return editor;
	}
	
	public static JsMapModel createCheckboxEditor(){
		JsMapModel editor=new JsMapModel();
		editor.put(EasyUiUtil.EDITOR_TYPE,EasyUiUtil.EDITOR_TYPE_CHECKBOX,true);
		//JsMapModel opts=new JsMapModel();
		//opts.put(EasyUiModel.NumberBox.Properties.PRECISION, 2);
		//editor.put(EasyUiUtil.EDITOR_OPTIONS, opts);
		return editor;
	}
	
	public static JsMapModel createDateboxEditor(boolean required,JsMapModel opts){
		JsMapModel editor=new JsMapModel();
		editor.put(EasyUiUtil.EDITOR_TYPE,EasyUiUtil.EDITOR_TYPE_DATEBOX,true);
		opts=opts==null?new JsMapModel():opts;
		if(!opts.containsKey(EasyUiModel.ValidateBox.Properties.REQUIRED)){
			opts.put(EasyUiModel.ValidateBox.Properties.REQUIRED,required);
		}
		editor.put(EasyUiUtil.EDITOR_OPTIONS, opts);
		return editor;
	}
	
}
