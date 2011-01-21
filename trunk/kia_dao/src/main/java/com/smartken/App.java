package com.smartken;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;



import com.smartken.kia.dao.TestDao;
import com.smartken.kia.mapper.sys.IMenuMapper;
import com.smartken.kia.mapper.sys.IUserMapper;
import com.smartken.kia.model.sys.MenuModel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//  MenuTreeNodeDao dao=new MenuTreeNodeDao();
//  ArrayList<MenuModel>  lar=dao.selectAll();
//  System.out.println(lar.size());
//  MenuModel m=new MenuModel();
//  m.setId("test");
//  m.setName("test2");
//  m.setParentId("root");
//  System.out.println(dao.selectSomeRegexp("系统管理"));
   TestDao td= new TestDao();
    IMenuMapper mapper= td.openSqlSession().getMapper(IMenuMapper.class);
    //IUserMapper um= td.openSqlSession().getMapper(IUserMapper.class);
   // System.out.println(mapper.selectAll().size());
    //System.out.println(um.selectAll().size());
    
    }
    
}
