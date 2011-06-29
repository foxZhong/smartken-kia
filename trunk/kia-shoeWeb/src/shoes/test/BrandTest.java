package shoes.test;

import shoes.dao.BrandDao;
import shoes.dao.impl.BrandDaoImpl;
import shoes.entity.Brand;

public class BrandTest {
	public static void main(String[] args) {
		
		Brand brand = new Brand(1,"Nike","b001","ÄÍ¿Ë");
		BrandDao bd = new BrandDaoImpl();
		int result = bd.AddBrand(brand);
		System.out.println(result);
		
//		BrandDao bd = new BrandDaoImpl();
//		int result = bd.deleteBrand(7);
//		System.out.println(result);
	}
}
