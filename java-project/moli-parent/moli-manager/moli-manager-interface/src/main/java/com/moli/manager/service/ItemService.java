package com.moli.manager.service;

import com.moli.common.pojo.EasyUIDataGridResult;
import com.moli.common.pojo.MoliResult;
import com.moli.manager.pojo.TbItem;
import com.moli.manager.pojo.TbItemDesc;

public interface ItemService {
	TbItem getItemBy(Long itemId);
    EasyUIDataGridResult getItemList(int page,int rows);
	MoliResult saveItem(TbItem tbItem, TbItemDesc tbItemDesc);
	MoliResult instockItem(String ids);
}
