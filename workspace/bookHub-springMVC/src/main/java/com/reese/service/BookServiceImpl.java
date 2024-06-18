package com.reese.service;

import org.springframework.stereotype.Service;

import com.reese.domain.BookVO;
import com.reese.mapper.BookMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

	private BookMapper bookMapper;
	

	@Override
	public void insertBook(BookVO bookVO) throws Exception{
		
		bookMapper.insertBookSelectKey(bookVO);
	}

	
}
