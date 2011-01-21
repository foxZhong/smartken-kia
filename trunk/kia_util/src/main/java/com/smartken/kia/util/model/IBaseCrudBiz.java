package com.smartken.kia.util.model;

import java.util.ArrayList;

import com.smartken.kia.util.enums.QueryEnum;
import com.smartken.kia.util.page.PageBounds;

public interface IBaseCrudBiz<Model> {

    public ArrayList<Model> getModelWithId(ArrayList lListIds,QueryEnum pQuery,PageBounds pPage) throws Exception;
    public int addModel(Model model) throws Exception;
    public int modifyModel(Model model) throws Exception;
    public int removeModelWithId(ArrayList lListIds,QueryEnum pQuery) throws Exception;
    public void loadCrudMapper(Class c);
}
