package com.moli.portal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moli.cms.service.CmsCategoryService;
import com.moli.cms.service.CmsContentService;
import com.moli.common.pojo.Ad1Node;
import com.moli.common.utils.JsonUtils;
import com.moli.manager.pojo.TbContent;

@Controller
public class IndexPageController {
    @Autowired
	private CmsContentService cmsContentService;
	@Value("${AD1_CATEGORY_ID}")
	private String AD1_CATEGORY_ID;
	@Value("${AD1_WIDTH}")
	private String AD1_WIDTH;
	@Value("${AD1_WIDTH_B}")
	private String AD1_WIDTH_B;
	@Value("${AD1_HEIGHT}")
	private String AD1_HEIGHT;
	@Value("${AD1_HEIGHT_B}")
	private String AD1_HEIGHT_B;
	@RequestMapping("/index")
	public String showIndexPage(Model model) {
		//List<TbContent> ad1Redords= cmsContentService.getIndexSlideAD(AD1_CATEGORY_ID);
		List<TbContent> ad1Redords= cmsContentService.getIndexSlideAD(3L);
		ArrayList<Ad1Node> adNodes = new ArrayList<>();
		for (TbContent tbContent : ad1Redords) {
			
			Ad1Node node = new Ad1Node();
			node.setAlt(tbContent.getTitle());
			node.setHeight(240);
			node.setHeightB(240);
			node.setHref(tbContent.getUrl());
			node.setSrc(tbContent.getPic());
			node.setSrcB(tbContent.getPic2());
			node.setWidth(670);
			node.setWidthB(550);
			
			adNodes.add(node);
			
		}
		
		// 需要手动将对象转成json
		String json = JsonUtils.objectToJson(adNodes);
		
		model.addAttribute("ad1", json);
		return "index";
	}
}
