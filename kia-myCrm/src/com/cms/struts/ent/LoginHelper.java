package com.cms.struts.ent;

import java.sql.SQLException;

public class LoginHelper extends MySQLHelper {
	
	public UserBean checkLogin(String name,String pass)
	{
	   UserBean ub=null;
	   this.getCon();
	   String str="SELECT u_id,u_realname,u_roleid,opt_name FROM users,sys_dataoptions "+
	   "where u_name=? and u_pass=? and opt_value=u_roleid and opt_dataid=8;";
	   try {
		ps=con.prepareStatement(str);
		ps.setString(1, name);
		ps.setString(2, pass);
		rs=ps.executeQuery();
		while(rs.next())
		{  ub=new UserBean();
		   ub.setUid(rs.getInt("u_id"));
		   ub.setUrealname(rs.getString("u_realname"));
		   ub.setUroleid(rs.getInt("u_roleid"));
		   ub.setUrole(rs.getString("opt_name"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return ub;
	}
	
	public static void main(String[] args)
	{
		LoginHelper lh=new LoginHelper();
		UserBean u=lh.checkLogin("ken", "167");
		System.out.println(u.getUrole());
	}

}
