package com.moli.cms.service;

import java.util.List;

import com.moli.common.pojo.EasyUIDataGridResult;
import com.moli.common.pojo.MoliResult;
import com.moli.manager.pojo.TbContent;

public interface CmsContentService {

	MoliResult saveContent(TbContent content);

	EasyUIDataGridResult getContentList(Integer categoryId, Integer page, Integer rows);

	List<TbContent> getIndexSlideAD(Long categoryId);
}
