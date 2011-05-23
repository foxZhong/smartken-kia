package com.smartken.kia.core.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import com.smartken.kia.core.pager.PageArrayList;
import com.smartken.kia.core.pager.PageBounds;
import com.smartken.kia.core.pager.PageList;

public interface IBaseCrudBiz {

 
    public boolean loadCrudMapper(Class c) throws NullPointerException;
    public void addCrudMapper(Class c,IMapper mapper) ;
	public void setCrudMapper(IMapper crudMapper);
	public ArrayList getModel();
	public ArrayList getModel(PageBounds pPage);
    public ArrayList getModel(Object model)  ;
    public PageArrayList getModel(Object model,PageBounds pPage) ;
    public ArrayList getModel(List listQuery);
    public PageArrayList getModel(List listQuery,PageBounds pPage);
    public Object getModelEqPk(Object pk)  ;
    public ArrayList getModelInPk(ArrayList listPk)  ;
    public PageArrayList getModelInPk(ArrayList listPk,PageBounds pPage) ;
    public ArrayList getModelNotInPk(ArrayList listPk)  ;
    public PageArrayList getModelNotInPk(ArrayList listPk,PageBounds pPage) ;
    public int removeModelEqPk(Object pk);
    public int removeModelInPk(ArrayList listPk)  ;
    public int removeModelNotInPk(ArrayList listPk)  ;
    public int addModel(Object model)  ;
    public int modifyModel(Object model)  ;
    public int modifyModel(Object model,Object pkNew)  ; 
    
    public int addOrModifyModel(Object model)  ;
    public int addOrModifyModel(Object model,Object pkNewPk)  ;
    
    public int modifyOrAddModel(Object model)  ;
    public int modifyOrAddModel(Object model,Object pkNewPk)  ;
    public int count()  ;
}
