package com.reese.service;

import java.util.List;

import com.reese.domain.CategoryVO;

public interface CategoryService {

	// 트리구조로 장르 목록 가져오기
	public List<CategoryVO> selectCtgrTreeList() throws Exception;
	
}
