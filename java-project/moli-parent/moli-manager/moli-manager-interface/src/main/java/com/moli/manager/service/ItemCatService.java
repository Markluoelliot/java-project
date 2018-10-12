package com.moli.manager.service;

import java.util.List;

import com.moli.common.pojo.EasyUITreeNode;

public interface ItemCatService {
    List<EasyUITreeNode> getItemCatList(long id);
}
