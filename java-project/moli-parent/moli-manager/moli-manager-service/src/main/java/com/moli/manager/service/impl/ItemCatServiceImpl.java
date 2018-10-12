package com.moli.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moli.common.pojo.EasyUITreeNode;
import com.moli.manager.mapper.TbItemCatMapper;
import com.moli.manager.pojo.TbItemCat;
import com.moli.manager.pojo.TbItemCatExample;
import com.moli.manager.pojo.TbItemCatExample.Criteria;
import com.moli.manager.service.ItemCatService;
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
	private TbItemCatMapper tbItemCatMapper;
	@Override
	public List<EasyUITreeNode> getItemCatList(long id) {
		// TODO Auto-generated method stub
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(id);
		List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
		ArrayList<EasyUITreeNode> nodes = new ArrayList<>();
		for(TbItemCat tbItemCat:list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId().intValue());
		    node.setText(tbItemCat.getName());
		    node.setState((tbItemCat.getIsParent()==1)?"closed":"open");
		    nodes.add(node);
		}
		return nodes;
	}

	

}
