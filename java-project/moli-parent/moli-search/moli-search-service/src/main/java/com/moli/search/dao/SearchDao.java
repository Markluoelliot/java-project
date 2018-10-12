package com.moli.search.dao;



import org.apache.solr.client.solrj.SolrQuery;

import com.moli.common.pojo.SearchResult;

public interface SearchDao {

	SearchResult search(SolrQuery solrQuery) throws Exception;

}
