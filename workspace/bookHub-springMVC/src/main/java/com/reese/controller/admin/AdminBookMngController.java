package com.reese.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reese.domain.CategoryVO;
import com.reese.service.CategoryService;

import lombok.AllArgsConstructor;

/**
 * 책 관리 컨트롤러
 * 
 *
 */
@Controller
@RequestMapping("admin/bookMng")
@AllArgsConstructor
public class AdminBookMngController {
	
	private CategoryService categoryService;
	
	
	// 목록
	@RequestMapping({"/bookMngList", ""})
	public String bookMngList(Model model) throws Exception {
		
		//
		List<CategoryVO> ctgrList = categoryService.selectCtgrTreeList();
		model.addAttribute("ctgrList", ctgrList);
		
		return "/admin/bookMng/bookMngList";
	}
	
	
}
