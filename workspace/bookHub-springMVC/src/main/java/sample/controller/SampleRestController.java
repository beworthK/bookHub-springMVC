package sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;
import sample.domain.SampleVO;

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
 * @RestController - 순수한 데이터를 반환하는 형태이므로 다양한 포맷의 데이터 전송 가능
 * 
 */
@RestController
@RequestMapping("/sample/ajax/*")
@Log4j
public class SampleRestController {

	
	/* 16.2.1 단순 문자열 반환
	 * produces 속성 - 해당 메서드가 생산하는 MIME 타입 
	 */
	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		
		// MediaType.TEXT_PLAIN_VALUE = "text/plain;"
		log.info("MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	/* 16.2.2 객체 반환
	 * SampleVO 객체 반환
	 * @GetMapping, @RequestMapping 의 produces 는 생략 가능
	 * 
	 * produces - XML 과 JSON 방식으로 데이터를 '생성' 하도록 지정
	 */
	@GetMapping(value = "/getSample", 
			produces = {
					MediaType.APPLICATION_JSON_VALUE,  //MediaType.APPLICATION_JSON_UTF8_VALUE 스프링 5.2 부터 없어짐
					MediaType.APPLICATION_XML_VALUE
			})
	public SampleVO getSample() {
		
		return new SampleVO(112, "스타", "로드");
		
		/* 하위처럼 결과 RETURN 됨
		<SampleVO>
			<mno>112</mno>
			<firstName>스타</firstName>
			<lastName>로드</lastName>
		</SampleVO>
		*/
		
		
		/* 같은 메서드를 /getSample.json 으로 호출하게되면 JOSN 타입으로 리턴된다~!!!!
		   
		   {"mno:112, "firstName":"스타","lastName":"로드"}
		 
		 */
	}
	
	/* 16.2.3 컬렉션 타입의 객체 반환
	 * 
	 */
	@GetMapping(value = "/getList")
	public List<SampleVO> getList(){
		// 1~ 10미만 까지 루프를 돌면서 sampleVO 객체를 만들어서 List<SampleVO> 에 담아서 반환  
		return IntStream.range(1, 10).mapToObj( i -> new SampleVO(i, i+"First", i+"Last") ).collect(Collectors.toList());
	}
	
	@GetMapping(value = "/getMap")
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(111, "그루트", "주니어")); // map 은 키 와 값을 가지는 객체로 간주 된다
		
		return map;
	}
	
	/* 16.2.4 ResponseEntity 타입
	 * REST 방식으로 호출하는 경우, 데이터 자체를 전송하는 방식으로 처리하므로 데이터를 요청한 쪽에서 
	 * 이 데이터가 정상적인지 비정상적인지 구분할 수 있는 확실한 방법을 제공해야 한다.
	 * 
	 * => ResponseEntity 는 데이터와 함께 HTTP 헤더의 상태 메시지 등을 같이 전달하는 용도로 사용한다.
	 *  
	 */
	@GetMapping(value = "/check", params= {"height", "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		SampleVO vo = new SampleVO(0, ""+height, ""+weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo); // 상태코드 와 에러 메시지 등을 함께 전달할 수 있다
		}
		
		return result;
	}
	
	
	/* 16.3 @RestController의 파라미터
	 * 
	 * @RestController 는 기존의 @Controller에서 사용하던 일반적인 타입이나 사용자가 정의한 타입을 사용한다
	 *  그리고 추가적으로 @PathVariable 와 @RequestBody 를 쓴다
	 */
	
	/* 16.3.1 @PathVariable
	 * REST 방식에서는 url 에 최댜한 많은 정보를 담으려고 노력한다. 
	 * @PathVariable 어노테이션을 이용해서 url 상에 경로의 일부를 파라미터로 사용할 수 있다 
	 * int, double 같은 기본 자료형은 사용할 수 없다
	 */
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid){
		return new String[] {"category:"+cat, "productid:" + pid};
	}
	
	/* 16.3.2 @RequestBody
	 * @RequestBody 는 전달된 요청(request) 의 내용(body)을 이용해서 해당 파라미터 타입으로 변환을 요구한다.
	 * 내부적으로 HttpMessageConverter 타입의 객체들을 이용해서 다양한 포맷의 입력 데이터를 변환할 수 있다.
	 * 원하는 포맷의 데이터를 보내고, 이를 해석해서 원하는 타입으로 사용하기도 한다
	 * 
	 * @RequestBody는 요청한(request) 내용(body)을 처리하기 때문에 
	 * 일반적인 파라미터 전달방식을 사용할 수 없으므로 @PostMapping 을 적용한다.
	 * 
	 */
	/*
	 * @PostMapping("/ticket") public Ticket convert(@RequestBody Ticket ticket) {
	 * log.info("convert............ticket" + ticket);
	 * 
	 * return ticket; }
	 */

}
