package com.luo.controller;

import com.luo.util.MailSender;
import com.luo.model.MailContentTypeEnum;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SendMail {
   
	
	@RequestMapping("/mail/{title}/{content}")
	@ResponseBody
	 public String sendMail(@PathVariable("title") String title,@PathVariable("content") String content) throws Exception {
		
	
		
      new MailSender().title(title).content(content).contentType(MailContentTypeEnum.TEXT)
                .targets(new ArrayList<String>(){{
                    add("598115455@qq.com");
                }})
                .send();
    return "success";
	}
	
	 }

