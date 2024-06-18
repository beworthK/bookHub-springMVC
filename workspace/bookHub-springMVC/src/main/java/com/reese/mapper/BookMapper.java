package com.reese.mapper;

import com.reese.domain.BookVO;

public interface BookMapper {
	
	
	//public List<BookVO> getList(BookVO bookVO) throws Exception;
	
	//public BookVO get(BookVO bookVO);
	
	public void insertBookSelectKey(BookVO bookVO);
	
	
}
