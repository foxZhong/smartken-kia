package shoes.entity;

public class DeliveryInfo {
	private int DId = 0;
	private int DUId = 0;
	private String DName = "";
	private String Tel = "";
	private String Address = "";
	
	public DeliveryInfo() {}
	
	public DeliveryInfo(int DUId, String DName, String Tel, String Address) {
		this.DUId = DUId;
		this.DName = DName;
		this.Tel = Tel;
		this.Address = Address;
	}

	public int getDId() {
		return DId;
	}

	public void setDId(int id) {
		DId = id;
	}

	public int getDUId() {
		return DUId;
	}

	public void setDUId(int uid) {
		DUId = uid;
	}

	public String getDName() {
		return DName;
	}

	public void setDName(String name) {
		DName = name;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
}
