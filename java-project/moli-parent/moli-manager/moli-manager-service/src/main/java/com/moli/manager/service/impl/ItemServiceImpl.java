package com.moli.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moli.common.pojo.EasyUIDataGridResult;
import com.moli.common.pojo.MoliResult;
import com.moli.common.utils.IDUtils;
import com.moli.manager.mapper.TbItemDescMapper;
import com.moli.manager.mapper.TbItemMapper;
import com.moli.manager.pojo.TbItem;
import com.moli.manager.pojo.TbItemDesc;
import com.moli.manager.pojo.TbItemExample;
import com.moli.manager.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemMapper;
	@Autowired
    private TbItemDescMapper itemDescMapper;
    @Override
	public TbItem getItemBy(Long itemId) {
		// TODO Auto-generated method stub
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		return item;
	}
	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		// TODO Auto-generated method stub
		
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(page,rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		PageInfo pageInfo = new PageInfo(list);
		EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
		easyUIDataGridResult.setRows(list);
		easyUIDataGridResult.setTotal(pageInfo.getTotal());
		return easyUIDataGridResult;
	}
	@Override
	public MoliResult saveItem(TbItem tbItem, TbItemDesc tbItemDesc) {
		// TODO Auto-generated method stub
		//商品表
		long id = IDUtils.genItemId();
		Date date = new Date();
		tbItem.setId(id);
		tbItem.setStatus((byte)1);
		tbItem.setCreated(date);
		tbItem.setUpdated(date);
		itemMapper.insert(tbItem);
		
		//商品描述
		tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);
        tbItemDesc.setItemId(id);
        
        itemDescMapper.insert(tbItemDesc);
        return MoliResult.ok();
	}
	@Override
	public MoliResult instockItem(String ids) {
		// TODO Auto-generated method stub
		String[] tokens  = ids.split(",");
		TbItem tbItem = new TbItem();
		for(String id:tokens) {
			tbItem.setId(Long.parseLong(id));
			tbItem.setStatus((byte)2);
			itemMapper.updateByPrimaryKeySelective(tbItem);
		}
		return MoliResult.ok();
	}

}
