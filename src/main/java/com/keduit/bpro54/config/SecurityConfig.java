package com.keduit.bpro54.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2

public class SecurityConfig {
	
	
	  // 비밀번호 암호화하기
	 @Bean 
	 PasswordEncoder passwordEncoder() { // BCryptPasswordEncoder() : password 암호화 해서 돌려줌
		 return new BCryptPasswordEncoder();
	 
	 }
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeRequests((auth) -> {
			auth.antMatchers("/sample/all").permitAll(); 		// permitAll() : 모든 권한
			auth.antMatchers("/sample/member").hasRole("USER"); // hasRole("USER") : USER에게만 권한
		});
		
		http.formLogin(); 		// 인가, 인증에 문제가 발생할 때 로그인 화면을 띄움
		http.csrf().disable();  // 로그인 할 때마다 csrf 토큰?이 새로 생성????하는걸 잠깐 꺼놓는 뭐?
		http.logout();
		return http.build();
	}
}