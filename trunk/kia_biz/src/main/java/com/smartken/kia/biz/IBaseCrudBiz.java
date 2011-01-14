package com.smartken.kia.biz;

import java.util.ArrayList;

public interface IBaseCrudBiz<Model> {

    public ArrayList<Model> getModelWithId(ArrayList lListIds,int query) throws Exception;
    public int addModel(Model model) throws Exception;
    public int modifyModel(Model model) throws Exception;
    public int removeModelWithId(ArrayList lListIds,int query) throws Exception;
    public void loadCrudMapper(Class c);
}
