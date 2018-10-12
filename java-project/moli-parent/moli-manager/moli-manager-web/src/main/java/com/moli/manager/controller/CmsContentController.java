package com.moli.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moli.cms.service.CmsContentService;
import com.moli.common.pojo.EasyUIDataGridResult;
import com.moli.common.pojo.MoliResult;
import com.moli.manager.pojo.TbContent;
@Controller
public class CmsContentController {
    @Autowired
	private CmsContentService cmsContentService;
    
    @RequestMapping("/content/query/list")
    @ResponseBody
    public EasyUIDataGridResult getContentList(Integer categoryId,Integer page,Integer rows) {
    	EasyUIDataGridResult result = cmsContentService.getContentList(categoryId,page,rows);
        
    	return result;
    }
    
    @RequestMapping("/content/save")
    @ResponseBody
    public MoliResult saveContent(TbContent content) {
    	
    	MoliResult result = cmsContentService.saveContent(content);
    	return result;
    }
}
