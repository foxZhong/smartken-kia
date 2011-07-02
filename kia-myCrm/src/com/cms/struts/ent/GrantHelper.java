package com.cms.struts.ent;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrantHelper extends MySQLHelper {

	private String model;
	private List functons;
	
	
	public List getModsByUserId(int userid)
	{
		List mods=new ArrayList();
		this.getCon();
		try {
			String str="SELECT m_id,m_name,m_desc"+
			           " FROM users,sys_function,sys_model "+
			            "where m_id=f_mid and u_grant regexp f_grant and u_id=? group by m_id;";
			ps=con.prepareStatement(str);
			ps.setInt(1, userid);
			rs=ps.executeQuery();
			while(rs.next())
				{
				   ModelBean fb=new ModelBean();
				   fb.setMid(rs.getInt("m_id"));
				   fb.setMname(rs.getString("m_name"));
				   fb.setMdesc(rs.getString("m_desc"));
				   mods.add(fb);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{this.closeAll();}
		return mods;
	}
	
	public List getGrantList(String grant)
	{
		List grants=new ArrayList();
		this.getCon();
		String str="SELECT * FROM sys_function,sys_model";
		try {
			ps=con.prepareStatement(str);
			rs=ps.executeQuery();
			while(rs.next())
			{		
				ModelBean fb=new ModelBean();
			
				fb.setMid(rs.getInt("f_mid"));
			
				fb.setMdesc(rs.getString("m_desc"));
				grants.add(fb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{this.closeAll();}
		return grants;
	}
	
	public int updateRoleGrant(int roleid,String grant)
	{
		int re=0;
		this.getCon();
		String str="update users set u_grant=? where u_roleid=?";
		try {
			ps=con.prepareStatement(str);
			
			ps.setString(1, grant);
			ps.setInt(2, roleid);
			re=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	public int updateUserGrant(int userid,String grant)
	{
		int re=0;
		this.getCon();
		String str="update users set u_grant=? where u_id=?";
		try {
			ps=con.prepareStatement(str);
			
			ps.setString(1, grant);
			ps.setInt(2, userid);
			re=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	public static void main(String[] str)
	{
		GrantHelper gh=new GrantHelper();
//		List mods=gh.getModsByUserId(1);
//		System.out.println(mods.size());
		gh.updateRoleGrant(2, "A1/A2/B1/B2/C1/C2/C3/C4/C5/D1/D2/D3/D4");
	}
}
