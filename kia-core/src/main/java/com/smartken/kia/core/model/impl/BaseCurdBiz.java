package com.smartken.kia.core.model.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.MaskFormatter;



import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.core.enums.QueryEnum;
import com.smartken.kia.core.model.IBaseCrudBiz;
import com.smartken.kia.core.model.IMapper;


public abstract class BaseCurdBiz implements IBaseCrudBiz {
	
	private IMapper crudMapper;
	private Map<Class,IMapper> mappers=new HashMap<Class, IMapper>();
	
	public int count() throws Exception {
		// TODO Auto-generated method stub
		return this.crudMapper.count();
	}
	public ArrayList getModel(Object model, PageBounds pPage) throws Exception {
		// TODO Auto-generated method stub
		if(model==null){
			return this.crudMapper.selectAll(pPage);
		}else {
			return this.crudMapper.select(model, pPage);
		}
	}
	
	public ArrayList getModel(Object model) throws Exception {
		// TODO Auto-generated method stub
		if(model==null){
			return this.crudMapper.selectAll();
		}else {
			return this.crudMapper.select(model);
		}
	}
	
	public Object getModelEqPk(Object pk) throws Exception {
		// TODO Auto-generated method stub
		return this.crudMapper.selectEqPk(pk);
	}
	public ArrayList getModelInPk(ArrayList listPk, PageBounds pPage)
			throws Exception {
		// TODO Auto-generated method stub
		return this.crudMapper.selectInPk(listPk,pPage);
	}
	public ArrayList getModelInPk(ArrayList listPk) throws Exception {
		// TODO Auto-generated method stub
		return this.crudMapper.selectInPk(listPk);
	}
	public ArrayList getModelNotInPk(ArrayList listPk, PageBounds pPage)
			throws Exception {
		// TODO Auto-generated method stub
		return this.crudMapper.selectNotInPk(listPk,pPage);
	}
	public ArrayList getModelNotInPk(ArrayList listPk) throws Exception {
		// TODO Auto-generated method stub
		return this.crudMapper.selectNotInPk(listPk);
	}

	public int modifyModel(Object model, Object pkNew) throws Exception {
		// TODO Auto-generated method stub
		return this.crudMapper.updateOne(model, pkNew);
	}
	public int modifyModel(Object model) throws Exception {
		// TODO Auto-generated method stub
		return this.crudMapper.updateOne(model);
	}
	public int removeModelInPk(ArrayList listPk) throws Exception {
		// TODO Auto-generated method stub
		return this.crudMapper.deleteInPk(listPk);
	}
	public int removeModelNotInPk(ArrayList listPk) throws Exception {
		// TODO Auto-generated method stub
		return this.crudMapper.deleteNotInPk(listPk);
	}
	
	
	
	public int addModel(Object model) throws Exception {
		// TODO Auto-generated method stub
		return this.crudMapper.insertOne(model);
	}
	
	
	
	
	public int addOrModifyModel(Object model, Object pkNewPk) throws Exception {
		// TODO Auto-generated method stub
		int re=addModel(model);
		if(re==0){
			re=modifyModel(model,pkNewPk);
		}
		return re;
	}
	public int addOrModifyModel(Object model) throws Exception {
		// TODO Auto-generated method stub
		int re=addModel(model);
		if(re==0){
			re=modifyModel(model);
		}
		return re;
	}
	public int modifyOrAddModel(Object model, Object pkNewPk) throws Exception {
		// TODO Auto-generated method stub
		int re=modifyModel(model,pkNewPk);
		if(re==0){
			re=addModel(model);
		}
		return re;
	}
	public int modifyOrAddModel(Object model) throws Exception {
		// TODO Auto-generated method stub
		int re=modifyModel(model);
		if(re==0){
			re=addModel(model);
		}
		return re;
	}
	public void loadCrudMapper(Class c) throws NullPointerException{
		this.crudMapper=mappers.get(c);
	};
	
	
	public void setCrudMapper(IMapper crudMapper) {
		this.crudMapper = crudMapper;
	}
	public void addCrudMapper(Class c, IMapper mapper){
		// TODO Auto-generated method stub
		mappers.put(c, mapper);
	}
	
	
	


}
