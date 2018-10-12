package com.moli.cms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moli.cms.service.CmsContentService;
import com.moli.cms.service.jedisclient.JedisClient;
import com.moli.common.pojo.EasyUIDataGridResult;
import com.moli.common.pojo.MoliResult;
import com.moli.common.utils.JsonUtils;
import com.moli.manager.mapper.TbContentMapper;
import com.moli.manager.pojo.TbContent;
import com.moli.manager.pojo.TbContentExample;
import com.moli.manager.pojo.TbContentExample.Criteria;
@Service
public class CmsContentServiceImpl implements CmsContentService {
    @Autowired
    private JedisClient jedisClient;
	
    @Value("${CMS_CONTENT_CACHE_KEY")
    private String CMS_CONTENT_CACHE_KEY;
    @Autowired
	private TbContentMapper tbContentMapper;
	@Override
	public MoliResult saveContent(TbContent content) {
		// TODO Auto-generated method stub
		Date date = new Date();
		content.setCreated(date);
		content.setUpdated(date);
		
		String picServerHost = "http://localhost:8080";
		String pic = content.getPic();
		String pic2 = content.getPic2();
		if(null!=pic&&"".equals(pic)) {
		    content.setPic(picServerHost+content.getPic());
		}
		if(null!=pic2&&"".equals(pic2)) {
		    content.setPic(picServerHost+content.getPic2());
		}
		tbContentMapper.insert(content);
		
		return MoliResult.ok();
	}
	@Override
	public EasyUIDataGridResult getContentList(Integer categoryId, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		TbContentExample example = new TbContentExample();
		Criteria ct = example.createCriteria();
		ct.andCategoryIdEqualTo(categoryId.longValue());
		PageHelper.startPage(page, rows);

		// 查询categoryid等于指定的所有content记录
		List<TbContent> list = tbContentMapper.selectByExample(example);

		PageInfo<TbContent> pageInfo = new PageInfo<>(list);

		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());

		return result;
		
	}
	public List<TbContent> getIndexSlideAD(Long categoryId){
		try {
			String jsonData = jedisClient.hget(CMS_CONTENT_CACHE_KEY, categoryId+"");
			if(null!=jsonData&&!"".equals(jsonData)) {
				List<TbContent> jsonToList = JsonUtils.jsonToList(jsonData, TbContent.class);
				return jsonToList;
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		TbContentExample example = new TbContentExample();
		 Criteria ct = example.createCriteria();
		 ct.andCategoryIdEqualTo(categoryId);
		 List<TbContent> list = tbContentMapper.selectByExample(example);
         try {
        	 String objectToJson = JsonUtils.objectToJson(list);
             jedisClient.hset(CMS_CONTENT_CACHE_KEY, categoryId+"", objectToJson);
         }catch(Exception e) {
        	 e.printStackTrace();
         }
		 //Gson gson = new Gson();
		 return list;
		
	}

}
