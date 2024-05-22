package com.reese.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.reese.domain.CategoryVO;
import com.reese.mapper.CategoryMapper;

import lombok.AllArgsConstructor;

/**
 * @Service 주로 비즈니스 영역을 담당하는 객체임을 표시
 * @AllArgsConstructor 모든 파라미터를 이용하는 생성자를 만들어줌 
 * 	- genreMapper 주입받는 생성자 만들어짐 
 */
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryMapper categoryMapper;
	
	@Override
	public List<CategoryVO> selectCtgrTreeList(CategoryVO categoryVO) throws Exception{
		
		return categoryMapper.selectCtgrTreeList(categoryVO);
	}

	@Override
	public List<Map<String, Object>> selectCtgrGridList(CategoryVO categoryVO) throws Exception {
		// TODO Auto-generated method stub
		return categoryMapper.selectCtgrGridList(categoryVO);
	}
	
	

}
