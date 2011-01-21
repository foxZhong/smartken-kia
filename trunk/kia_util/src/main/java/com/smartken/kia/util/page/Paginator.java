package com.smartken.kia.util.page;

import org.apache.ibatis.session.RowBounds;


public class Paginator implements java.io.Serializable {
	private static final long serialVersionUID = 6089482156906595931L;
	public static final int NO_ROW_OFFSET=-2;
	public static final int NO_ROW_LIMIT=-1;
	private static final int DEFAULT_SLIDERS_COUNT = 7;
	
    
    private int               pageSize;
    
    private int               page;
   
    private int               totalItems;
	
	public Paginator(int page, int pageSize) {
		
		this.pageSize = pageSize;
		//this.totalItems = totalItems;
		this.page = computePageNo(page);
	}
    
	public Paginator(int page, int pageSize, int totalItems) {
		this.pageSize = pageSize;
		this.totalItems = totalItems;
		this.page = computePageNo(page);
	}
	
  
	public int getPage() {
		return page;
	}

	public int getPageSize() {
		return pageSize;
	}


	public int getTotalItems() {
		return totalItems;
	}


	public boolean isFirstPage() {
		return page <= 1;
	}


	public boolean isLastPage() {
		return page >= getTotalPages();
	}
	
	public int getPrePage() {
		if (isHasPrePage()) {
			return page - 1;
		} else {
			return page;
		}
	}
	
	public int getNextPage() {
		if (isHasNextPage()) {
			return page + 1;
		} else {
			return page;
		}
	}
	

    public boolean isDisabledPage(int page) {
        return ((page < 1) || (page > getTotalPages()) || (page == this.page));
    }
    

	public boolean isHasPrePage() {
		return (page - 1 >= 1);
	}	

	public boolean isHasNextPage() {
		return (page + 1 <= getTotalPages());
	}
	

	public int getStartRow() {
		if(getPageSize() <= 0 || totalItems <= 0) return 0;
		return page > 0 ? (page - 1) * getPageSize() + 1 : 0;
	}
	

	public int getEndRow() {
	    return page > 0 ? Math.min(pageSize * page, getTotalItems()) : 0; 
	}
	
	
	public int getOffset() {
		return page > 0 ? (page - 1) * getPageSize() : 0;
	}
	

    public int getLimit() {
        if (page > 0) {
            return Math.min(pageSize * page, getTotalItems()) - (pageSize * (page - 1));
        } else {
            return 0;
        }
    }

	public int getTotalPages() {
		if (totalItems <= 0) {
			return 0;
		}
		if (pageSize <= 0) {
			return 0;
		}

		int count = totalItems / pageSize;
		if (totalItems % pageSize > 0) {
			count++;
		}
		return count;
	}

	public PageBounds getPageBounds(){
		return new PageBounds(this.getOffset(),this.getLimit());
	}
	
    protected int computePageNo(int page) {
        return computePageNumber(page,pageSize,totalItems);
    }
 
    public Integer[] getSlider() {
    	return slider(DEFAULT_SLIDERS_COUNT);
    }

    public Integer[] slider(int slidersCount) {
    	return generateLinkPageNumbers(getPage(),(int)getTotalPages(), slidersCount);
    }
    
    private static int computeLastPageNumber(int totalItems,int pageSize) {
    	if(pageSize <= 0) return 1;
        int result = (int)(totalItems % pageSize == 0 ? 
                totalItems / pageSize 
                : totalItems / pageSize + 1);
        if(result <= 1)
            result = 1;
        return result;
    }
    
    private static int computePageNumber(int page, int pageSize,int totalItems) {
        if(page <= 1) {
            return 1;
        }
        if (Integer.MAX_VALUE == page
                || page > computeLastPageNumber(totalItems,pageSize)) { //last page
            return computeLastPageNumber(totalItems,pageSize);
        }
        return page;
    }
    
    private static Integer[] generateLinkPageNumbers(int currentPageNumber,int lastPageNumber,int count) {
        int avg = count / 2;
        
        int startPageNumber = currentPageNumber - avg;
        if(startPageNumber <= 0) {
            startPageNumber = 1;
        }
        
        int endPageNumber = startPageNumber + count - 1;
        if(endPageNumber > lastPageNumber) {
            endPageNumber = lastPageNumber;
        }
        
        if(endPageNumber - startPageNumber < count) {
            startPageNumber = endPageNumber - count;
            if(startPageNumber <= 0 ) {
                startPageNumber = 1;
            }
        }
        
        java.util.List<Integer> result = new java.util.ArrayList<Integer>();
        for(int i = startPageNumber; i <= endPageNumber; i++) {
            result.add(new Integer(i));
        }
        return result.toArray(new Integer[result.size()]);
    }
    
    public String toString() {
        return "page:"+page+" pageSize:"+pageSize+" totalItems:"+totalItems;
    }
    
}
