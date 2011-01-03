package com.smartken;

import java.util.ArrayList;

import com.smartken.kia.dao.sys.MenuTreeNodeDao;
import com.smartken.kia.model.sys.MenuTreeNodeModel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
  MenuTreeNodeDao dao=new MenuTreeNodeDao();
  ArrayList<MenuTreeNodeModel>  lar=dao.selectAll();
  System.out.println(lar.size());
    }
}
