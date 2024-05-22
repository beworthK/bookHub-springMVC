package sample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @AllArgsConstructor
 *  - 모든 속성을 사용하는 생성자 
 *  
 * @NoArgsConstructor
 *  - 비어있는 생성자 만들기
 *  
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleVO {

	private Integer mno;
	private String firstName;
	private String lastName;
}
