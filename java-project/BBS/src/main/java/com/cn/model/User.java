package com.cn.model;

import java.io.Serializable;
import java.util.Date;
//javabean model 对应数据库中的表
public class User implements Serializable {
    private Long id;
    private String account;
    private String password;
    private String nickname;
    private Date birthday;
    public User(){
    	super();
    }
    
    
	public User(Long id,String account,String password,String nickname,Date birthday) {
    	this.id= id;
    	this.account = account;
    	this.birthday = birthday;
    	this.nickname = nickname;
    	this.password = password;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
    
}
