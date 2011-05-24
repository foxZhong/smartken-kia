package com.smartken.kia.core.model.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.text.MaskFormatter;



import com.smartken.kia.core.pager.PageArrayList;
import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.core.pager.PageList;
import com.smartken.kia.core.model.IBaseCrudBiz;
import com.smartken.kia.core.model.IMapper;


public abstract class BaseCurdBiz implements IBaseCrudBiz {
	
	private IMapper crudMapper;
	private Map<Class,IMapper> mappers=new HashMap<Class, IMapper>();
	
	public int count()  {
		// TODO Auto-generated method stub
		int count=0;
		try{
			count+=this.crudMapper.count();
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}finally{
			return count;
		}
	}
	
	
	
	public List getModel() {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectAll();
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}



	public List getModel(PageBounds pPage) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectAll(pPage);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}
 

	public List getModel(Object model) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
           list= this.crudMapper.select(model);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}
	

	public PageArrayList getModel(Object model, PageBounds pPage) {
		// TODO Auto-generated method stub
          List list=this.getModel(model);
          PageArrayList pageList=new PageArrayList(list, pPage);
          return pageList;
	}
	

	
	public Object getModelEqPk(Object pk) {
		// TODO Auto-generated method stub
		Object obj=null;
		try{
			obj=this.crudMapper.selectEqPk(pk);
		}catch(Exception ex){
			ex.printStackTrace();
			return obj;
		}finally{
			return obj;
		}
	}

	
	
	public List getModelInPk(List listPk)  {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectInPk(listPk);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
		return list;
	}
	public PageArrayList getModelInPk(List listPk, PageBounds pPage)
	 {
		// TODO Auto-generated method stub
		List list = this.getModelInPk(listPk);
		PageArrayList pageList = new PageArrayList(list, pPage);
		return pageList;
     }
	
	
	public PageArrayList getModelNotInPk(List listPk, PageBounds pPage) {
		// TODO Auto-generated method stub
        List list=this.getModelNotInPk(listPk);
        PageArrayList pageList=new PageArrayList(list, pPage);
        return pageList;
	}
	
	public List getModelNotInPk(List listPk)  {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectNotInPk(listPk);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}
		return list;
	}

	public int modifyModel(Object model, Object pkNew) {
		// TODO Auto-generated method stub
		int re=0;
		try{
			re+=this.crudMapper.updateOne(model,pkNew);
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
		return re;
	}
	public int modifyModel(Object model) {
		// TODO Auto-generated method stub
		int re=0;
		try{
			re+=this.crudMapper.updateOne(model);
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
		return re;
	}
	
	public int removeModelEqPk(Object pk) {
		// TODO Auto-generated method stub
		int re=0;
		try{
			re+=this.crudMapper.deleteEqPk(pk);
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
		return re;
	}
	
	public int removeModelInPk(List listPk)  {
		// TODO Auto-generated method stub
		int re=0;
		try{
			re+=this.crudMapper.deleteInPk(listPk);
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
		return re;
	}
	public int removeModelNotInPk(List listPk) {
		// TODO Auto-generated method stub
		int re=0;
		try{
			re+=this.crudMapper.deleteNotInPk(listPk);
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
		return re;
	}
	
	
	
	public int addModel(Object model)  {
		// TODO Auto-generated method stub
		int re=0;
		try{
			re+=this.crudMapper.insertOne(model);
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	    return re;
	}
	
	
	
	
	public int addOrModifyModel(Object model, Object pkNewPk)  {
		// TODO Auto-generated method stub
		int re=addModel(model);
		if(re==0){
			re=modifyModel(model,pkNewPk);
		}
		return re;
	}
	public int addOrModifyModel(Object model)  {
		// TODO Auto-generated method stub
		int re=addModel(model);
		if(re==0){
			re=modifyModel(model);
		}
		return re;
	}
	public int modifyOrAddModel(Object model, Object pkNewPk)  {
		// TODO Auto-generated method stub
		int re=modifyModel(model,pkNewPk);
		if(re==0){
			re=addModel(model);
		}
		return re;
	}
	public int modifyOrAddModel(Object model)  {
		// TODO Auto-generated method stub
		int re=modifyModel(model);
		if(re==0){
			re=addModel(model);
		}
		return re;
	}
	public boolean loadCrudMapper(Class c) throws NullPointerException{
		IMapper mapper=mappers.get(c);
		if(mapper==null){
			return false;
		}else{
			this.crudMapper=mappers.get(c);
			return true;
		}
	};
	
	
	public void setCrudMapper(IMapper crudMapper) {
		this.crudMapper = crudMapper;
	}
	
	
	
	public void addCrudMapper(Class c, IMapper mapper){
		// TODO Auto-generated method stub
		mappers.put(c, mapper);
	}
	public Map<Class, IMapper> getMappers() {
		return mappers;
	}



	public PageArrayList getModel(List listQuery, PageBounds pPage) {
		// TODO Auto-generated method stub
		List listModel=this.getModel(listQuery);
		PageArrayList pageList=new PageArrayList(listModel, pPage);
        return pageList;
	}



	public List getModel(List querys) {
		// TODO Auto-generated method stub
        List listModel=new ArrayList();
        try{
          listModel=  this.crudMapper.selectUnion((ArrayList) querys);
        }catch(Exception ex){
        	return new ArrayList();
        }
        return listModel;
	}



	public List getView() {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectViewAll();
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}



	public PageArrayList getView(List listQuery, PageBounds pPage) {
		// TODO Auto-generated method stub
		List list = this.getView(listQuery);
		PageArrayList pageList = new PageArrayList(list, pPage);
		return pageList;
	}



	public List getView(List listQuery) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectViewUnion(listQuery);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}



	public PageArrayList getView(Object model, PageBounds pPage) {
		// TODO Auto-generated method stub
		List list = this.getView(model);
		PageArrayList pageList = new PageArrayList(list, pPage);
		return pageList;
	}



	public List getView(Object model) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectView(model);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}



	public List getView(PageBounds pPage) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectView(pPage);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}



	public Object getViewEqPk(Object pk) {
		// TODO Auto-generated method stub
		return null;
	}



	public PageArrayList getViewInPk(List listPk, PageBounds pPage) {
		// TODO Auto-generated method stub
		List list = this.getViewInPk(listPk);
		PageArrayList pageList = new PageArrayList(list, pPage);
		return pageList;
	}



	public List getViewInPk(List listPk) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectViewInPk(listPk);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}



	public PageArrayList getViewNotInPk(List listPk, PageBounds pPage) {
		// TODO Auto-generated method stub
		List list = this.getViewNotInPk(listPk);
		PageArrayList pageList = new PageArrayList(list, pPage);
		return pageList;
	}



	public List getViewNotInPk(List listPk) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		try{
			list=this.crudMapper.selectViewNotInPk(listPk);
		}catch(Exception ex){
			ex.printStackTrace();
			return list;
		}finally{
			return list;
		}
	}








	
	
	


}
