package com.reese.mapper;

import java.util.List;

import com.reese.domain.CategoryVO;

public interface CategoryMapper {
	
	public List<CategoryVO> selectCtgrTreeList() throws Exception;

	
}
