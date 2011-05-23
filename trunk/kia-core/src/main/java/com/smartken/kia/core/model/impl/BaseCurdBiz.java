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
	
	
	
	public ArrayList getModel() {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		try{
			list=this.crudMapper.selectAll();
		}catch(Exception ex){
			ex.printStackTrace();
			return new ArrayList();
		}finally{
			return list;
		}
	}



	public ArrayList getModel(PageBounds pPage) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		try{
			list=this.crudMapper.selectAll(pPage);
		}catch(Exception ex){
			ex.printStackTrace();
			return new ArrayList();
		}finally{
			return list;
		}
	}
 

	public ArrayList getModel(Object model) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		try{
			if(model==null){
				list=this.crudMapper.selectAll();
			}else{
			    list= this.crudMapper.select(model);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return new ArrayList();
		}finally{
			return list;
		}
	}
	

	public PageArrayList getModel(Object model, PageBounds pPage) {
		// TODO Auto-generated method stub
          ArrayList list=this.getModel(model);
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
			return null;
		}finally{
			return obj;
		}
	}

	
	
	public ArrayList getModelInPk(ArrayList listPk)  {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		try{
			list=this.crudMapper.selectInPk(listPk);
		}catch(Exception ex){
			ex.printStackTrace();
			return new ArrayList();
		}
		return list;
	}
	public PageArrayList getModelInPk(ArrayList listPk, PageBounds pPage)
	 {
		// TODO Auto-generated method stub
		ArrayList list = this.getModelInPk(listPk);
		PageArrayList pageList = new PageArrayList(list, pPage);
		return pageList;
     }
	
	
	public PageArrayList getModelNotInPk(ArrayList listPk, PageBounds pPage) {
		// TODO Auto-generated method stub
        ArrayList list=this.getModelNotInPk(listPk);
        PageArrayList pageList=new PageArrayList(list, pPage);
        return pageList;
	}
	
	public ArrayList getModelNotInPk(ArrayList listPk)  {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		try{
			list=this.crudMapper.selectNotInPk(listPk);
		}catch(Exception ex){
			ex.printStackTrace();
			return new ArrayList();
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
	
	public int removeModelInPk(ArrayList listPk)  {
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
	public int removeModelNotInPk(ArrayList listPk) {
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
		ArrayList listModel=this.getModel(listQuery);
        PageArrayList pageList=new PageArrayList(listModel, pPage);
        return pageList;
	}



	public ArrayList getModel(List querys) {
		// TODO Auto-generated method stub
        ArrayList listModel=new ArrayList();
        try{
          listModel=  this.crudMapper.selectUnion((ArrayList) querys);
        }catch(Exception ex){
        	return new ArrayList();
        }
        return listModel;
	}








	
	
	


}
