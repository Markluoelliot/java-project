package com.moli.search.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moli.manager.mapper.TbItemMapper;
import com.moli.manager.pojo.TbItem;
import com.moli.manager.pojo.TbItemExample;
import com.moli.manager.pojo.TbItemExample.Criteria;
import com.moli.search.service.TestSearchService;
@Service
public class TestSearchServiceImpl implements TestSearchService {
    @Autowired
	private TbItemMapper tbItemMapper;
    @Override
    public String hello(String itemId ) {
    	TbItemExample example = new TbItemExample();
    	Criteria ct = example.createCriteria();
    	ct.andIdEqualTo(Long.parseLong(itemId));
    	//TbItem item = tbItemMapper.selectByPrimaryKey(Long.parseLong(itemId));
        List<TbItem> list = tbItemMapper.selectByExample(example);
        
        return list.get(0).getTitle();
    }
}
