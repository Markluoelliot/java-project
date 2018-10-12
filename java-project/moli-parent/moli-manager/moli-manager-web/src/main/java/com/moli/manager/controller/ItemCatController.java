package com.moli.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moli.common.pojo.EasyUITreeNode;
import com.moli.manager.service.ItemCatService;

@Controller
public class ItemCatController {
    @Autowired
	private ItemCatService itemCatService;
	@RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(defaultValue ="0")Integer id){
		
    	List<EasyUITreeNode> itemCatList = itemCatService.getItemCatList(id);
	
        return itemCatList;
    }
}
