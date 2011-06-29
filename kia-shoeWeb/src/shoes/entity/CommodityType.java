package shoes.entity;

public class CommodityType {
	private int TId = 0;
	private String TName = "";
	
	public CommodityType() {}

	public CommodityType(int id, String name) {
		super();
		TId = id;
		TName = name;
	}

	public int getTId() {
		return TId;
	}

	public void setTId(int id) {
		TId = id;
	}

	public String getTName() {
		return TName;
	}

	public void setTName(String name) {
		TName = name;
	}
	
}
