package shoes.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoes.dao.*;
import shoes.entity.*;

public class CommodityInfoDaoImpl extends BaseDao implements CommodityInfoDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List findAllWare() {
		List list = new ArrayList();
		String sql = "select * from commodityinfo";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				CommodityInfo commo = new CommodityInfo();
				commo.setCId(rs.getInt("CId"));
				commo.setCTId(rs.getInt("CTId"));
				commo.setCBId(rs.getInt("CBId"));
				commo.setCName(rs.getString("CName"));
				commo.setSize(rs.getString("Size"));
				commo.setStyle(rs.getInt("Style"));
				commo.setPrice(rs.getDouble("price"));
				commo.setPicture(rs.getString("Picture"));
				commo.setSalesCount(rs.getInt("SalesCount"));
				commo.setStockCount(rs.getInt("StockCount"));
				commo.setAddDate(rs.getString("AddDate"));
				list.add(commo);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return list;
	}
	
	public List findAllWare(int current) {
		List list = new ArrayList();
		String sql = "select top 6 * from commodityinfo where cid not in (select top (6*("+current+"-1)) cid from commodityinfo)";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				CommodityInfo commo = new CommodityInfo();
				commo.setCId(rs.getInt("CId"));
				commo.setCTId(rs.getInt("CTId"));
				commo.setCBId(rs.getInt("CBId"));
				commo.setCName(rs.getString("CName"));
				commo.setSize(rs.getString("Size"));
				commo.setStyle(rs.getInt("Style"));
				commo.setPrice(rs.getDouble("price"));
				commo.setPicture(rs.getString("Picture"));
				commo.setSalesCount(rs.getInt("SalesCount"));
				commo.setStockCount(rs.getInt("StockCount"));
				commo.setAddDate(rs.getString("AddDate"));
				list.add(commo);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return list;
	}


	public List findNewWare() {
		List list = new ArrayList();
		String sql = "select Top 3 * from CommodityInfo order by AddDate desc";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			String[] parameters = null;
			rs = executeQuery(pstmt, parameters);
			while(rs.next()){
				CommodityInfo commo = new CommodityInfo();
				commo.setCId(rs.getInt("CId"));
				commo.setCTId(rs.getInt("CTId"));
				commo.setCBId(rs.getInt("CBId"));
				commo.setCName(rs.getString("CName"));
				commo.setPrice(rs.getDouble("price"));
				commo.setAddDate(rs.getString("AddDate"));
				list.add(commo);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return list;
	}
	
	public CommodityInfo findWard(int CId) {
		CommodityInfo cInfo = null;
		String sql = "select * from CommodityInfo where CId="+CId;
		try{
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = executeQuery(pstmt, null);
			while(rs.next()){
				cInfo = new CommodityInfo();
				cInfo.setCId(CId);
				cInfo.setCTId(rs.getInt("CTId"));
				cInfo.setCBId(rs.getInt("CBId"));
				cInfo.setCName(rs.getString("CName"));
				cInfo.setSize(rs.getString("Size"));
				cInfo.setStyle(rs.getInt("Style"));
				cInfo.setPrice(rs.getDouble("price"));
				cInfo.setPicture(rs.getString("Picture"));
				cInfo.setSalesCount(rs.getInt("SalesCount"));
				cInfo.setStockCount(rs.getInt("StockCount"));
				cInfo.setAddDate(rs.getString("AddDate"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return cInfo;
	}
	
	public List getComList(int ctid, int cbid, int style) {
		List coms=new ArrayList();
		this.con= getConnection();
		StringBuffer str=new StringBuffer();
		str.append("select * from commodityinfo ");
		if(ctid!=0&&cbid!=0&&style!=0)
			str.append("where ctid="+ctid+" and cbid="+cbid+"and style="+style);
		else if(ctid!=0&&cbid!=0)
			str.append("where ctid="+ctid+" and cbid="+cbid);
		else if(ctid!=0&&style!=0)
			str.append("where ctid="+ctid+"and style="+style);
		else if(cbid!=0&&style!=0)
			str.append("where cbid="+cbid+"and style="+style);
		else if(ctid!=0)
			str.append("where ctid="+ctid);
		else if(cbid!=0)
			str.append("where cbid="+cbid);
		else if(style!=0)
			str.append("where style="+style);
		System.out.println(str.toString());
		try {
			pstmt=con.prepareStatement(str.toString());
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				CommodityInfo ci=new CommodityInfo();
				ci.setCBId(rs.getInt("cbid"));
				//ci.setAddDate();
				ci.setCId(rs.getInt("cid"));
				ci.setCName(rs.getString("cname"));
				ci.setPicture(rs.getString("picture"));
				ci.setPrice(rs.getDouble("price"));
				ci.setSalesCount(rs.getInt("salescount"));
				ci.setSize(rs.getString("size"));
				ci.setStockCount(rs.getInt("stockcount"));
				//ci.setStyle(style);
				ci.setCTId(rs.getInt("ctid"));
				coms.add(ci);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			closeAll(con, pstmt, rs);
		}
		return coms;
	}
	public List getComList(int ctid, int cbid, int style, int current) {
		List coms=new ArrayList();
		this.con= getConnection();
		StringBuffer str=new StringBuffer();
		str.append("select top 6 * from commodityinfo where cid not in (select top (6*("+current+"-1)) cid from commodityinfo) ");

			
		if(ctid!=0&&cbid!=0&&style!=0)
			str.append("and ctid="+ctid+" and cbid="+cbid+"and style="+style);
		else if(ctid!=0&&cbid!=0)
			str.append("and ctid="+ctid+" and cbid="+cbid);
		else if(ctid!=0&&style!=0)
			str.append("and ctid="+ctid+"and style="+style);
		else if(cbid!=0&&style!=0)
			str.append("and cbid="+cbid+"and style="+style);
		else if(ctid!=0)
			str.append("and ctid="+ctid);
		else if(cbid!=0)
			str.append("and cbid="+cbid);
		else if(style!=0)
			str.append("and style="+style);
		System.out.println(str.toString());
		try {
			pstmt=con.prepareStatement(str.toString());
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				CommodityInfo ci=new CommodityInfo();
				ci.setCBId(rs.getInt("cbid"));
				//ci.setAddDate();
				ci.setCId(rs.getInt("cid"));
				ci.setCName(rs.getString("cname"));
				ci.setPicture(rs.getString("picture"));
				ci.setPrice(rs.getDouble("price"));
				ci.setSalesCount(rs.getInt("salescount"));
				ci.setSize(rs.getString("size"));
				ci.setStockCount(rs.getInt("stockcount"));
				//ci.setStyle(style);
				ci.setCTId(rs.getInt("ctid"));
				coms.add(ci);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			closeAll(con, pstmt, rs);
		}
		return coms;
	}
	
	public int update(int cid) {
		int result = 0;
		String sql = "update commodityinfo set salescount=salescount+1,stockcount=stockcount-1 where cid=?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cid);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(con, pstmt, rs);
		}
		return result;
	}

	public static void main(String[] args)
	{
		new CommodityInfoDaoImpl().getComList(0, 0, 0);
	}
}
