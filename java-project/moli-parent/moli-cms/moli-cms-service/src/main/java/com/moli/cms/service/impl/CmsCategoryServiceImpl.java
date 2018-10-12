package com.moli.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moli.cms.service.CmsCategoryService;
import com.moli.common.pojo.EasyUITreeNode;
import com.moli.manager.mapper.TbContentCategoryMapper;
import com.moli.manager.pojo.TbContentCategory;
import com.moli.manager.pojo.TbContentCategoryExample;
import com.moli.manager.pojo.TbContentCategoryExample.Criteria;
@Service
public class CmsCategoryServiceImpl implements CmsCategoryService {
    @Autowired
	private TbContentCategoryMapper tbContentCategoryMapper;
	
	@Override
	public List<EasyUITreeNode> getCmsCategoryList(Long id) {
		// TODO Auto-generated method stub
		//Long id= 1L;
		TbContentCategoryExample example = new TbContentCategoryExample();
    	Criteria criteria = example.createCriteria();
    	//assertNull(criteria);
		criteria.andParentIdEqualTo(id);
		ArrayList<EasyUITreeNode> nodes = new ArrayList<>();
		List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(example);
		
		for(TbContentCategory tbContentCategory:list) {
    		EasyUITreeNode node = new EasyUITreeNode();
    		node.setId(tbContentCategory.getId().intValue());
    		node.setState((tbContentCategory.getIsParent()==1)?"closed":"open");
    	    node.setText(tbContentCategory.getName());
    	    
    	    nodes.add(node);
		}
		return nodes;
	}

	
}
