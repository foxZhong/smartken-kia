package shoes.dao;

import java.util.List;

import shoes.entity.CommodityInfo;

public interface CommodityInfoDao {

	public List findNewWare();
	
	public List findAllWare();
	
	public List findAllWare(int current);
	
	public CommodityInfo findWard(int CId);
	
	public List getComList(int ctid,int cbid,int style);
	
	public List getComList(int ctid,int cbid,int style, int current);
	
	public int update(int cid);
}
