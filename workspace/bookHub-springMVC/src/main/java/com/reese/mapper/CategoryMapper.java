package com.reese.mapper;

import java.util.List;
import java.util.Map;

import com.reese.domain.CategoryVO;

public interface CategoryMapper {
	
	public List<CategoryVO> selectCtgrTreeList(CategoryVO categoryVO) throws Exception;

	public List<Map<String, Object>> selectCtgrGridList(CategoryVO categoryVO) throws Exception;

	
}
