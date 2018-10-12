package com.moli.search.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moli.common.pojo.MoliResult;
import com.moli.common.pojo.SearchItem;
import com.moli.search.mapper.ItemMapper;
import com.moli.search.service.SearchItemService;


@Service
public class SearchItemServiceImpl implements SearchItemService{
    
	@Autowired
	private ItemMapper itemMapper;
    @Autowired
	private SolrServer solrServer;
    @Override
	public MoliResult importAllIntoSolr() throws Exception {
		List<SearchItem> itemList = itemMapper.getItemList();
		
		for(SearchItem searchItem:itemList) {
			// 第二步：创建一个文档对象SolrInputDocument对象。
						SolrInputDocument document = new SolrInputDocument();
						// 第三步：向文档中添加域。每个文档对象中必须有id域，id不能重复。用到的所有的域的名称必须在schema.xml中定义。
						document.addField("id", searchItem.getId());
						document.addField("item_title", searchItem.getTitle());
						document.addField("item_sell_point", searchItem.getSell_point());
						document.addField("item_price", searchItem.getPrice());
						document.addField("item_image", searchItem);
						document.addField("item_category_name", searchItem.getCategory_name());
						document.addField("item_desc", searchItem.getItem_des());
						// 第四步：使用SolrServer把文档添加到索引库
						solrServer.add(document);

		}
		solrServer.commit();
		return MoliResult.ok();
	}
}
