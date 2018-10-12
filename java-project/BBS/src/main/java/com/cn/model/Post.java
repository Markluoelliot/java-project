package com.cn.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post implements Serializable {
   private Long id;
   private String title;
   private String content;
   private Date PubDate;
   private String avatar;
   private Long authorId;
   private Long parentId;
   List<Post> children = new ArrayList<Post>();
   public Post() {
	   
   }
   
public Post(Long id, String title, String content) {
	super();
	this.id = id;
	this.title = title;
	this.content = content;
}

public List<Post> getChildren() {
	return children;
}

public void setChildren(List<Post> children) {
	this.children = children;
}

public Post(Long id, String title, String content, Date pubDate, String avatar, Long authorId, Long parentId) {
	
	this.id = id;
	this.title = title;
	this.content = content;
	PubDate = pubDate;
	this.avatar = avatar;
	this.authorId = authorId;
	this.parentId = parentId;
}
public Post(String content,Long uid, Long pid) {
	// TODO Auto-generated constructor stub
   this.content = content;
   this.authorId = uid;
   this.parentId  =pid;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getPubDate() {
	return PubDate;
}
public void setPubDate(Date pubDate) {
	PubDate = pubDate;
}
public String getAvatar() {
	return avatar;
}
public void setAvatar(String avatar) {
	this.avatar = avatar;
}
public Long getAuthorId() {
	return authorId;
}
public void setAuthorId(Long authorId) {
	this.authorId = authorId;
}
public Long getParentId() {
	return parentId;
}
public void setParentId(Long parentId) {
	this.parentId = parentId;
}
   

	

}
