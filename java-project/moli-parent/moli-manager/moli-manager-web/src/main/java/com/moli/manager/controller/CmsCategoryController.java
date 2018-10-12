package com.moli.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moli.cms.service.CmsCategoryService;
import com.moli.common.pojo.EasyUITreeNode;

@Controller
public class CmsCategoryController {
    @Autowired
	private CmsCategoryService cmsCategoryService;
	
    @RequestMapping("/content/category/list")
    @ResponseBody
	public List<EasyUITreeNode> getCmsCategoryList(@RequestParam(defaultValue="1") Long id){
        
		
		List<EasyUITreeNode> nodes = cmsCategoryService.getCmsCategoryList(id);
		return nodes;
	}
}
