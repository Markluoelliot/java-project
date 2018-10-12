package com.moli.common.pojo;

import java.io.Serializable;

public class Ad1Node implements Serializable {

	private int height;
	private int width;
	private int heightB;
	private int widthB;
	private String src;
	private String srcB;
	private String href;
	private String alt;
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
		
	}
	public void setWidth(int widht) {
		this.width = widht;
	}
	public int getHeightB() {
		return heightB;
	}
	public void setHeightB(int heightB) {
		this.heightB = heightB;
	}
	public int getWidthB() {
		return widthB;
	}
	public void setWidthB(int widthB) {
		this.widthB = widthB;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getSrcB() {
		return srcB;
	}
	public void setSrcB(String srcB) {
		this.srcB = srcB;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	
	
}
