package shoes.entity;

public class Brand {
	private int BId;
	private String BName;
	private String BPicture;
	private String BCName;
	
	public Brand() {
		super();
	}

	public Brand(int id, String name, String picture, String name2) {
		super();
		BId = id;
		BName = name;
		BPicture = picture;
		BCName = name2;
	}



	public String getBCName() {
		return BCName;
	}

	public void setBCName(String name) {
		BCName = name;
	}

	public int getBId() {
		return BId;
	}

	public void setBId(int id) {
		BId = id;
	}

	public String getBName() {
		return BName;
	}

	public void setBName(String name) {
		BName = name;
	}

	public String getBPicture() {
		return BPicture;
	}

	public void setBPicture(String picture) {
		BPicture = picture;
	}

	
}
