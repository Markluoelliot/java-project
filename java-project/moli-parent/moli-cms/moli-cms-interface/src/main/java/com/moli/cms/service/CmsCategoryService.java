package com.moli.cms.service;

import java.util.List;

import com.moli.common.pojo.EasyUITreeNode;

public interface CmsCategoryService {

	List<EasyUITreeNode> getCmsCategoryList(Long id);

}
