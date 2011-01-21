
package com.smartken.kia.util.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


public class PageList<E> extends ArrayList<E> implements Serializable {

    private static final long serialVersionUID = 1412759446332294208L;
    
 
    private int               pageSize;
 
    private int               page;
   
    private int               totalItems;

    public PageList() {}
    
	public PageList(Collection<? extends E> c) {
		super(c);
	}

	public PageList(int page, int pageSize, int totalItems) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
    }
	
	public PageList(Collection<? extends E> c,int page, int pageSize, int totalItems) {
        super(c);
        this.page = page;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
    }

    public PageList(Paginator p) {
        this.page = p.getPage();
        this.pageSize = p.getPageSize();
        this.totalItems = p.getTotalItems();
    }
    
    public PageList(Collection<? extends E> c,Paginator p) {
        super(c);
        this.page = p.getPage();
        this.pageSize = p.getPageSize();
        this.totalItems = p.getTotalItems();
    }
    
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	

	public Paginator getPaginator() {
		return new Paginator(page,pageSize,totalItems);
	}
	
}
