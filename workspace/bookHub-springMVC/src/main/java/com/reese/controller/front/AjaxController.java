package com.reese.controller.front;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reese.domain.CategoryVO;
import com.reese.service.CategoryService;

import lombok.AllArgsConstructor;


/**
 * 
 * @RestController 
 *  - 순수한 데이터를 반환하는 형태
 *  - 다양한 포맷의 데이터(ex.json, xml 등)를 전송할 수 있다.
 *
 */

@RestController
@RequestMapping("ajax")
@AllArgsConstructor
public class AjaxController {
	
	private CategoryService categoryService; 
	
	
	@PostMapping(value = "/getCtgrTreeList", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Map<String, Object>>> getCtgrTreeList(CategoryVO categoryVO) throws Exception {
		
		//
		List<Map<String, Object>> ctgrList = categoryService.selectCtgrGridList(categoryVO);
		
		return new ResponseEntity<>(ctgrList, HttpStatus.OK);
	}
	
	
}
