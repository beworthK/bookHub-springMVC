package com.reese.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reese.domain.BookVO;
import com.reese.domain.CategoryVO;
import com.reese.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 도서 관리 컨트롤러
 */
@Controller
@Log4j
@RequestMapping("/admin/bookMng")
@AllArgsConstructor
public class AdminBookMngController {
	
	private BookService bookService;
	
	
	// 목록
	@RequestMapping({"/bookMngList", ""})
	public String bookMngList(CategoryVO categoryVO, Model model) throws Exception {
		
		
		//model.addAttribute("categoryVO", new Gson().toJson(categoryVO));
		model.addAttribute("categoryVO", categoryVO);
		
		return "/admin/bookMng/bookMngList";
	}
	
	// 등록 페이지
	@GetMapping("/bookRegister")
	public String bookRegister(BookVO bookVO, Model model) throws Exception {
		
		return "/admin/bookMng/bookRegister";
	}
	
	
	@PostMapping("/bookRegister")
	public String bookRegister(BookVO bookVO, RedirectAttributes rttr) {
		
		try {
			
			bookService.insertBook(bookVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// addFlashAttribute - 보관된 데이터를 단 한번만 사용할 수 있게 보관된다(내부적으로는 HttpSesion을 이용해서 처리)
		rttr.addFlashAttribute("result", bookVO.getBook_id());
		
		return "redirect:/admin/bookMng/bookMngList"; //등록작업이 끝난 후 목록으로 보낸다 - 새로고침을 통해 반복적으로 등록하는 행위 방지
	}
	
}
