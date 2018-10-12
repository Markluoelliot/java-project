package com.moli.manager.service.bootstrap;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ManagerServiceBootStrap {
    public static void main(String[] args) throws Exception {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");		
	context.start();
	while(true) {
		Thread.sleep(Long.MAX_VALUE);
	}
    }
}
