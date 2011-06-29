package shoes.entity;

public class OrderItem {

	private int itemId;
	
	private int itemCount;
	
	private int itemCid;
	
	private int itemOid;
	
	public int getItemOid() {
		return itemOid;
	}

	public void setItemOid(int itemOid) {
		this.itemOid = itemOid;
	}

	private double itemPrice;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getItemCid() {
		return itemCid;
	}

	public void setItemCid(int itemCid) {
		this.itemCid = itemCid;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
}
