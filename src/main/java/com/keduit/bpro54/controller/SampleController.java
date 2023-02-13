package com.keduit.bpro54.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keduit.bpro54.security.dto.ClubAuthMemberDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller // 브라우저에서 화면 출력
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/sample/")
public class SampleController {

	@GetMapping("/all") 
	public void exAll() {
		log.info("exAll-----------------------------");
	}
	
	@GetMapping("/member") 
	public void exMember(@AuthenticationPrincipal ClubAuthMemberDTO clubAuthMemberDTO) { // @AuthenticationPrincipal - UserDetails 랑 비슷하게?? 생각하ㅏ래여
		log.info("exMember--------------------------");
		log.info("---------------------------------------");
		log.info("clubAuthMemberDTO : ", clubAuthMemberDTO);
	}
	
	@GetMapping("/admin")
	public void exAdmin() {
		log.info("exAdmin---------------------------");
	}
}
