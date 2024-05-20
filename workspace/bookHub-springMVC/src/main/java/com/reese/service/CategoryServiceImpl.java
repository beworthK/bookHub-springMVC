package com.reese.service;

import java.util.List;

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
	public List<CategoryVO> selectCtgrTreeList() throws Exception{
		
		return categoryMapper.selectCtgrTreeList();
	}
	
	

}
