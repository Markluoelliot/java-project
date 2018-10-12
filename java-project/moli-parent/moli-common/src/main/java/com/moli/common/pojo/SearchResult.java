package com.moli.common.pojo;

import java.io.Serializable;
import java.util.List;

public class SearchResult implements Serializable {
    
	private List<SearchItem> itemList;
	private long recordOunt;
	private int pageCount;
    private int curPage;
	public SearchResult() {
		super();
	}
	
    public SearchResult(List<SearchItem> itemList, long recordOunt, int pageCount, int curPage) {
		
		this.itemList = itemList;
		this.recordOunt = recordOunt;
		this.pageCount = pageCount;
		this.curPage = curPage;
	}

	public List<SearchItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<SearchItem> itemList) {
		this.itemList = itemList;
	}
	public long getRecordOunt() {
		return recordOunt;
	}
	public void setRecordOunt(long recordOunt) {
		this.recordOunt = recordOunt;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
    
}
