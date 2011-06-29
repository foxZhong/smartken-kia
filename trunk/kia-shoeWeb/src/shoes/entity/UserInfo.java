package shoes.entity;

public class UserInfo {
	private int UId;
	private String UName;
	private String UPass;
	private String ULevel;
	
	public UserInfo(String name, String pass, String level) {
		super();
		UName = name;
		UPass = pass;
		ULevel = level;
	}

	public UserInfo() {}

	public int getUId() {
		return UId;
	}

	public void setUId(int id) {
		UId = id;
	}

	public String getULevel() {
		return ULevel;
	}

	public void setULevel(String level) {
		ULevel = level;
	}

	public String getUName() {
		return UName;
	}

	public void setUName(String name) {
		UName = name;
	}

	public String getUPass() {
		return UPass;
	}

	public void setUPass(String pass) {
		UPass = pass;
	}
	

}
