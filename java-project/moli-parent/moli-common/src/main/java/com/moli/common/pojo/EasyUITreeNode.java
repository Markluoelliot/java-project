package com.moli.common.pojo;

import java.io.Serializable;

public class EasyUITreeNode implements Serializable {
    /*
     * "id":3
     * "text":"Node 3"
     * "state":"closed"
     */
	private int id;
	private String text;
	private String state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
    
}
