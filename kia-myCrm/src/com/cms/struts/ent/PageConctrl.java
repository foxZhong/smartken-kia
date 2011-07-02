package com.cms.struts.ent;

public class PageConctrl {
    private int curPage=1;
    private int beginItem=0;
    private int maxItems=10;
    
   
    
	public int getBeginItem() {
		return beginItem;
	}
	public void setBeginItem(int beginItem) {
		this.beginItem = beginItem;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getMaxItems() {
		return maxItems;
	}
	public void setMaxItems(int maxItems) {
		this.maxItems = maxItems;
	}

    
    
}
