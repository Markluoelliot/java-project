package com.moli.search.service;

import com.moli.common.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String q, Integer page, Integer rows) throws Exception;

}
