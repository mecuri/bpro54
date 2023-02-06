package com.keduit.bpro54.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
@RequiredArgsConstructor
public class CustomSecurityConfig {

	@Bean // 빈 등록하기(spring 2.7.8 이후부터 빈 등록해야 사용 가능해짐)
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // filterChain : 접근 가능하도록 열어줌
		
		log.info("-----------configure------------");
		
		return http.build();
	}
	
}
