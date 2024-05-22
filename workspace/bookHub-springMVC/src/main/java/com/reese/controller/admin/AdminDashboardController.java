package com.reese.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reese.service.CategoryService;

import lombok.AllArgsConstructor;

/**
 * 관리자 대시보드 페이지 
 * 
 * 금일 방문자 수
 * 금주 도서분류 별 대여수 순위
 * 금주 최대 대여 책 탑 5
 * 
 * 방문 경로? 
 * 검색키워드 
 * 
 */
@Controller
@RequestMapping("admin/dashboard")
@AllArgsConstructor
public class AdminDashboardController {
	
	// 금일 방문자수 ajax
	@PostMapping(value = "/getTodayVisitChart", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getTodayVisitChart(Model model) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		
		return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}
	
	
}
