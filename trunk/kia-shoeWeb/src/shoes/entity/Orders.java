package shoes.entity;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	private int OId = 0;

	private String Number = "";

	private int ODId = 0;

	private String StartTime = "";

	private String EndTime = "";

	private String OState = "";
	
	private List items=new ArrayList();
	

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}

	public Orders() {
	}

	public Orders(String Number, int ODId, int OCId, String StartTime,
			String EndTime, String OState, int BuyCount) {
		this.Number = Number;
		this.ODId = ODId;
	//	this.OCId = OCId;
		this.StartTime = StartTime;
		this.EndTime = EndTime;
		this.OState = OState;
	//	this.BuyCount = BuyCount;
	}

	public int getOId() {
		return OId;
	}

	public void setOId(int id) {
		OId = id;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public int getODId() {
		return ODId;
	}

	public void setODId(int did) {
		ODId = did;
	}

	

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public void setEndTime(String endTime) {
		EndTime = endTime;
	}

	public String getOState() {
		return OState;
	}

	public void setOState(String state) {
		OState = state;
	}
}
