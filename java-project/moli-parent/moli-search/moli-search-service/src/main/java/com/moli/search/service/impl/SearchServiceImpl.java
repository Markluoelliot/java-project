package com.moli.search.service.impl;


import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moli.common.pojo.SearchResult;
import com.moli.search.dao.SearchDao;
import com.moli.search.service.SearchService;
@Service
public class SearchServiceImpl implements SearchService{
    @Autowired
	private SearchDao searchDao;
	@Override
	public SearchResult search(String q, Integer page, Integer rows) throws Exception {
		// TODO Auto-generated method stub
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setStart(page-1);
		solrQuery.setRows(rows);
		solrQuery.setFields("item_keywords");
		solrQuery.setHighlight(true);
		solrQuery.addHighlightField("item_title");
		solrQuery.setHighlightSimplePre("<font class=\"skcolor_1jg\">");
		solrQuery.setHighlightSimplePost("</font>");
		
		SearchResult searchResult  = searchDao.search(solrQuery);
		searchResult.setCurPage(page);
		int pages = (int)searchResult.getRecordOunt()/rows;
		if(searchResult.getRecordOunt()%rows!=0) {
			pages++;
		}
		searchResult.setPageCount(pages);
		return searchResult;
	}

}
