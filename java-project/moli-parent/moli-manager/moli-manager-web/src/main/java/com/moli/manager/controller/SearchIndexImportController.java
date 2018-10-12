package com.moli.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moli.common.pojo.MoliResult;
import com.moli.search.service.SearchItemService;

@Controller
public class SearchIndexImportController {
    @Autowired
	private SearchItemService searchItemService;
	@RequestMapping("/search/importAll")
    @ResponseBody
	public MoliResult importAllDataToSolr() {
    	try {
		searchItemService.importAllIntoSolr();
		return MoliResult.ok();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return MoliResult.build(500, "正忙");
    	}
    }
}
