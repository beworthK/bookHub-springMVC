package com.reese.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {


	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		log.warn("Load User By UserName : " + userName);

		// MemberVO 조회
		//MemberVO vo = memberMapper.read(userName);

		//log.warn("queried by member mapper: " + vo);
		
		// MemberVO의 인스턴스를 얻을 수 있다면 CustomUser 타입의 객체로 변환해서 반환 
		//return vo == null ? null : new CustomUser(vo);
		
		return null;
	} 

}
