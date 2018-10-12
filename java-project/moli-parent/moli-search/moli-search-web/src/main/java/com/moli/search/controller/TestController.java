package com.moli.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moli.search.service.TestSearchService;

@Controller
public class TestController {
    @Autowired
	private TestSearchService testSearchService;
	@RequestMapping("/hello")
    @ResponseBody
	public String showIndex(String itemId) {
		return testSearchService.hello(itemId);
		
	}
	
}
