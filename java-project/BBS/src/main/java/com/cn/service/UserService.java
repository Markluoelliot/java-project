package com.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.dao.UserDao;
import com.cn.model.User;

@Service
public class UserService{
	@Autowired
	private UserDao userDao;
	
	public boolean register(User user)  {
	    //UserDao userDao = new UserDaoImpl();
	   
	    return userDao.save(user);
	}
	
	public User login(User user){
		//UserDao userDao = new UserDaoImpl();
		return userDao.getByAccountAndPassword(user);
	}
	

}
