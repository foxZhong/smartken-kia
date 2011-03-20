package com.smartken.kia.core.model;

import java.util.ArrayList;

import com.smartken.kia.core.enums.QueryEnum;
import com.smartken.kia.core.pager.PageBounds;

public interface IBaseCrudBiz {

 
    public void loadCrudMapper(Class c) throws NullPointerException;
    public void addCrudMapper(Class c,IMapper mapper) ;
	public void setCrudMapper(IMapper crudMapper);
    public ArrayList getModel(Object model) throws Exception;
    public ArrayList getModel(Object model,PageBounds pPage) throws Exception;
    public Object getModelEqPk(Object pk) throws Exception;
    public ArrayList getModelInPk(ArrayList listPk) throws Exception;
    public ArrayList getModelInPk(ArrayList listPk,PageBounds pPage) throws Exception;
    public ArrayList getModelNotInPk(ArrayList listPk) throws Exception;
    public ArrayList getModelNotInPk(ArrayList listPk,PageBounds pPage) throws Exception;
    public int removeModelInPk(ArrayList listPk) throws Exception;
    public int removeModelNotInPk(ArrayList listPk) throws Exception;
    public int addModel(Object model) throws Exception;
    public int modifyModel(Object model) throws Exception;
    public int modifyModel(Object model,Object pkNew) throws Exception; 
    
    public int addOrModifyModel(Object model) throws Exception;
    public int addOrModifyModel(Object model,Object pkNewPk) throws Exception;
    
    public int modifyOrAddModel(Object model) throws Exception;
    public int modifyOrAddModel(Object model,Object pkNewPk) throws Exception;
    public int count() throws Exception;
}
