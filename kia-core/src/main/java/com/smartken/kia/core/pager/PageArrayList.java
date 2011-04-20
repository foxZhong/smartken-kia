package com.smartken.kia.core.pager;

import java.util.ArrayList;
import java.util.List;

public class PageArrayList<E> extends ArrayList<E> {

    private int count;
    private int fromIndex;
    private int toIndex;

    
    public PageArrayList(){
    	super();
    	this.count=0;
    }
    
    public PageArrayList(ArrayList<E> list){
    	super();
    	if(list==null||list.size()==0){
    	  this.count=0;
    	  return;
        }
    	this.addAll(list);
    }
    
    public PageArrayList(ArrayList<E> list,PageBounds pb){
    	super();
    	if(list==null||list.size()==0){
    	  this.count=0;
    	  return;
        }
    	this.count=list.size();
    	this.calIndex(pb);
    	try{
    	List<E> page=list.subList(fromIndex, toIndex);
    	this.addAll(page);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	
    }
    
    
	public int getCount() {
		return count;
	}
	
	private void calIndex(PageBounds pb){
		if(pb==null){
    		pb=new PageBounds();
    	}
    	int offset=pb.getOffset();
    	int limit=pb.getLimit();
        this.fromIndex=offset*limit;
        this.toIndex=(offset+1)*limit;
        if(toIndex>=this.count){
        	toIndex=this.count-1;
        }
    	if(fromIndex>toIndex){
    		fromIndex=toIndex-(toIndex%limit);
    		fromIndex=fromIndex<0?0:fromIndex;
    	}
	}
	  	
}
