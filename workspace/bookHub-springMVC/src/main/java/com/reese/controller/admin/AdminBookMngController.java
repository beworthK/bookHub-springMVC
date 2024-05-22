package com.reese.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reese.domain.CategoryVO;

import lombok.AllArgsConstructor;

/**
 * 도서 관리 컨트롤러
 */
@Controller
@RequestMapping("admin/bookMng")
@AllArgsConstructor
public class AdminBookMngController {
	
	// 목록
	@RequestMapping({"/bookMngList", ""})
	public String bookMngList(CategoryVO categoryVO, Model model) throws Exception {
		
		
		//model.addAttribute("categoryVO", new Gson().toJson(categoryVO));
		model.addAttribute("categoryVO", categoryVO);
		
		return "/admin/bookMng/bookMngList";
	}
	
	
}
