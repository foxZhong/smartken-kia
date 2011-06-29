package shoes.entity;

public class CommodityInfo {
	private int CId = 0;
	private int CTId = 0;
	private int CBId = 0;
	private String CName = "";
	private String Size = "";
	private int Style;
	private double Price;
	private String Picture = "";
	private int SalesCount = 0;
	private int StockCount = 0;
	private String AddDate = "";

	public CommodityInfo() {
		super();
	}

	public CommodityInfo(int id, int id2, int id3, String name, String size, int style, double price, String picture, int salesCount, int stockCount, String addDate) {
		super();
		CId = id;
		CTId = id2;
		CBId = id3;
		CName = name;
		Size = size;
		Style = style;
		Price = price;
		Picture = picture;
		SalesCount = salesCount;
		StockCount = stockCount;
		AddDate = addDate;
	}


	public String getAddDate() {
		return AddDate;
	}

	public void setAddDate(String addDate) {
		AddDate = addDate;
	}

	public int getCBId() {
		return CBId;
	}


	public void setCBId(int id) {
		CBId = id;
	}


	public int getCId() {
		return CId;
	}


	public void setCId(int id) {
		CId = id;
	}


	public String getCName() {
		return CName;
	}


	public void setCName(String name) {
		CName = name;
	}


	public int getCTId() {
		return CTId;
	}


	public void setCTId(int id) {
		CTId = id;
	}


	public String getPicture() {
		return Picture;
	}


	public void setPicture(String picture) {
		Picture = picture;
	}


	public double getPrice() {
		return Price;
	}

	
	public void setPrice(double price) {
		Price = price;
	}

	
	public int getSalesCount() {
		return SalesCount;
	}


	public void setSalesCount(int salesCount) {
		SalesCount = salesCount;
	}


	public String getSize() {
		return Size;
	}


	public void setSize(String size) {
		Size = size;
	}


	public int getStockCount() {
		return StockCount;
	}


	public void setStockCount(int stockCount) {
		StockCount = stockCount;
	}


	public int getStyle() {
		return Style;
	}


	public void setStyle(int style) {
		Style = style;
	}


}
