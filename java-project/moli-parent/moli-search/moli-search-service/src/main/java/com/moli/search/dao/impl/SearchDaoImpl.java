package com.moli.search.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moli.common.pojo.SearchItem;
import com.moli.common.pojo.SearchResult;
import com.moli.search.dao.SearchDao;
@Repository
public class SearchDaoImpl implements SearchDao {
    @Autowired
	private SolrServer solrServer;
	@Override
	public SearchResult search(SolrQuery solrQuery) throws Exception {
		// TODO Auto-generated method stub
		QueryResponse response = solrServer.query(solrQuery);
	    SolrDocumentList list = response.getResults();
	    
	    long numFound = list.getNumFound();
	    
	    Map<String,Map<String,List<String>>> hignlighting =response.getHighlighting();
	    ArrayList<SearchItem> items = new ArrayList<>();
	    for(SolrDocument solrDocument:list) {
	    	SearchItem searchItem = new SearchItem();
	        searchItem.setCategory_name((String) solrDocument.get("item_category_name"));
	        searchItem.setId((Long) solrDocument.get("id"));
	        searchItem.setImage((String)solrDocument.get("item_image"));
	        searchItem.setItem_des((String)solrDocument.get("item_desc"));
	        searchItem.setPrice((Long)solrDocument.get("item_price"));
	        searchItem.setSell_point((String)solrDocument.get("item_sell_point"));
	        
	        //取高亮结果返回
	        Map<String, List<String>> highResult= hignlighting.get((Long)solrDocument.get("id"));getClass();
	        String item_title="";
	        if(highResult!=null&&highResult.size()>0) {
	        	
	        	item_title = highResult.get("item_title").get(0);
	        }else {
	        	item_title = (String)solrDocument.get("item_title");
	        }
	        searchItem.setTitle((String)solrDocument.get("item_title"));
	        items.add(searchItem);
	    }
	   SearchResult  searchResult =  new SearchResult();
	   //文档结果
	   searchResult.setItemList(items);
	   searchResult.setRecordOunt(numFound);
	  
	    return searchResult;
	}

}
