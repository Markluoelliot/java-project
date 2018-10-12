package com.moli.manager.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moli.manager.mapper.TbItemMapper;
import com.moli.manager.pojo.TbItem;
import com.moli.manager.pojo.TbItemExample;

public class TestPageHelper {
   
	public void testPageHelper() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	    TbItemMapper tbItemMapper = context.getBean(TbItemMapper.class);
        PageHelper.startPage(1,50);
	    TbItemExample example = new TbItemExample();
	    List<TbItem> list = tbItemMapper.selectByExample(example);
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        Long total = pageInfo.getTotal();
        System.out.println(total);
        for(TbItem tbItem:list) {
        	System.out.println(tbItem.getTitle()+""+tbItem.getPrice()+""+tbItem.getSellPoint());
        }
    }
}
