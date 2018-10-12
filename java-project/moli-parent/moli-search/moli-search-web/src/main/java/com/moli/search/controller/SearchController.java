package com.moli.search.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moli.common.pojo.SearchResult;
import com.moli.search.service.SearchService;

@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;
	@RequestMapping("/search")
	public String search(String q,Integer page,Integer rows,Model model) {
		try {
		SearchResult search = searchService.search(q,page,rows);
		}catch(Exception e){
		e.printStackTrace();
		}
		return "search";
	}
}
