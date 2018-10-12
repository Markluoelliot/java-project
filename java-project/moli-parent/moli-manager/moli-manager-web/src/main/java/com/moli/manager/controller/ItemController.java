package com.moli.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moli.common.pojo.EasyUIDataGridResult;
import com.moli.common.pojo.MoliResult;
import com.moli.manager.pojo.TbItem;
import com.moli.manager.pojo.TbItemDesc;
import com.moli.manager.service.ItemService;

@Controller
public class ItemController {
   @Autowired
   private ItemService itemService;
   @RequestMapping("/item/{id}")
   @ResponseBody
   public TbItem getItemById(@PathVariable String id) {
       Long cid = Long.parseLong(id);
	   TbItem item = itemService.getItemBy(cid);
       //System.out.println(cid);
	   return item;
	}
   @RequestMapping("item/list")
   @ResponseBody
   public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
       
       
	   EasyUIDataGridResult itemList = itemService.getItemList(page, rows);
	  
	   return itemList;
       
   }
   
   @RequestMapping("/item/save")
   @ResponseBody
   public MoliResult saveItem(TbItem tbItem,TbItemDesc tbItemDesc) {
	   MoliResult moliResult = itemService.saveItem(tbItem,tbItemDesc);
	   return moliResult;
	   
   }
   @RequestMapping("/rest/item/instock")
   @ResponseBody
   public MoliResult instockItem(String ids) {
	   MoliResult moliResult = itemService.instockItem(ids);
       
	   return moliResult;
   }
 
}
