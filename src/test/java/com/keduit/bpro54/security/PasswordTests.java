package com.keduit.bpro54.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordTests {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// 비밀번호 암호화 테스트
	@Test
	public void testEncodee() {
		String password = "1111"; // 임의로 비번 지정
		String enPw = passwordEncoder.encode(password);
		System.out.println("enPw : " + enPw);
		
		boolean matchResult = passwordEncoder.matches(password, enPw); // 일치하는지 확인해보기
		
		System.out.println("matchResult : " + matchResult);
				
	}
}
