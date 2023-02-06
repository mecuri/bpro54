package com.keduit.bpro54.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CustomUserDetailesService implements UserDetailsService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// 인증 구현
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.info("loadUserByUsername" + username);
		
		// user 생성함
		UserDetails userDetails = User.builder().username("user1")
												.password(passwordEncoder.encode("1111"))
												.authorities("ROLE_USER")
												.build();
		
		return userDetails;
		
	}

}
