package sample.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

/**
 * 스프링 MVC - Controller(컨트롤러)
 * 	- 스프링 MVC 방식에서 컨트롤러는 기본적으론 가장 먼저 호출되도록 한다.
 * 	  나중에 View 를 교체하더라도 사용자가 호출하는 URL 자체에 변화가 없게 만들어 주기 때문. (= 로직과 화면 분리)
 *  - 컨트롤러는 데이터를 처리하는 존재를 이용해서 데이터(Model)을 처리하고 
 *    Response 할 때 필요한 데이터(Model)을 View 쪽으로 전달해준다.
 *    이에 대한 처리는 ViewResolver 를 이용하는데, ViewResolver는 반환한 결과를 어떤 View를 통해 처리해야할지를 해석한다.
 *    (ex. servlet-context.xml 에 정의된 InternalResourceViewResolver 등의 설정을 사용한다)
 *  - 즉, 컨트롤러에는 실제 Request를 처리하는 로직을 작성한다
 */

/**
 * ©Controller
 *  - servlet-context.xml 의 <context:component-scan> 태그를 통해 지정된 패키지를 조사하도록 설정되어 있다
 * 
 * @RequestMapping
 * 	- 현재 클래스의 모든 메서드들의 기본 URL 경로
 *    ex. "/sample/*" => /sample 로 시작하는 모든 경로를 처리
 *
 * @Log4j
 *  - lombok의 log4j  라이브러리를 활용.
 */
@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	
	/*
	 *  @RequestMapping 은 get, post 모든 방식을 지원하는 경우 배열처리를 통해 지정
	 *   - @GetMapping : RequestMapping 중 GET 방식만을 지원하는 경우
	 *   - @PostMapping
	 *  @RequestParam("파라미터명")
	 *   - request.getParameter() 역할. 컨트롤러는 파라미터를 자동으로 수집해주는데,
	 *     @RequestParam 을 통해 파라미터의 타입에 맞게 따로 선언해서 받아올 수 있다.
	 */
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name: " + name);
		log.info("age: "+ age);
		
		return "ex02";
	}
	
	/*
	 * binding(바인딩) - 파라미터 수집의 다른용어
	 *  - 파라미터를 변환 처리해야 하는 경우, 
	 *    스프링 컨트롤러에서 파라미터를 바인딩할 때 자동으로 호출되는 @InitBinder을 이용해서 변환을 처리한다.
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		// Date 타입의 파라미터가 "yyyy-MM-dd" 문자열 형태로 들어오는 경우, 바인딩을 통해 date 타입으로 형변환 처리
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor( java.util.Date.class, new CustomDateEditor(dateFormat, false) );
	}
	
	/*
	 * @ModelAttribute
	 *  - 전달받은 파라미터를 강제로 model에 담아서 전달할 때 사용
	 *    타입과 관계 없이 무조건 model에 담아서 전달된다.
	 */
	@GetMapping("/ex04")
	public String ex04(@ModelAttribute("page") int page) {
			log.info("page: " + page);
			
			return "/sample/exOA";
	}

}
