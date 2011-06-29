package shoes.dao;

import java.util.List;

import shoes.entity.Brand;

public interface BrandDao {
	
	public int AddBrand(Brand brand);
	
	public int deleteBrand(int bid);
	
	public int updateBrand(Brand brand);
	
	public Brand findBrand(int bid);
	
	public List findAllBrand();
}
