package com.reese.service;

import java.util.List;
import java.util.Map;

import com.reese.domain.CategoryVO;

public interface CategoryService {

	// 트리구조로 장르 목록 가져오기
	public List<CategoryVO> selectCtgrTreeList(CategoryVO categoryVO) throws Exception;

	public List<Map<String, Object>> selectCtgrGridList(CategoryVO categoryVO) throws Exception;
	
}
