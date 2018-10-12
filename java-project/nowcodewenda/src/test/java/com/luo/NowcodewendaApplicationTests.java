package com.luo;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.luo.dao.UserDAO;
import com.luo.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NowcodewendaApplicationTests {
    @Autowired
	UserDAO userDAO;
	@Test
	public void contextLoads() {
		
	        Random random = new Random();
	        for (int i = 0; i < 11; ++i) {
	            User user = new User();
	            user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
	            user.setName(String.format("USER%d", i));
	            user.setPassword("");
	            user.setSalt("");
	            userDAO.addUser(user);

	            user.setPassword("newpassword");
	            userDAO.updatePassword(user);
	}

	}
	}
