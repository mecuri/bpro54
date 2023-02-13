package com.keduit.bpro54.security.service;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.relation.Role;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.keduit.bpro54.entity.ClubMember;
import com.keduit.bpro54.repository.ClubMemberRepository;
import com.keduit.bpro54.security.dto.ClubAuthMemberDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClubUserDetailsService implements UserDetailsService {
	
	private final ClubMemberRepository clubMemberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("ClubUserDetailsService loadUserByUsername : " + username);
		
		Optional<ClubMember> result = clubMemberRepository.findbyEmail(username, false);
		
		if(result.isEmpty()) {
			throw new UsernameNotFoundException("이메일이나 소셜가입 여부를 확인해주세요.");
		}
		
		ClubMember clubMember = result.get();
		
		log.info("-----------------------------------");
		log.info("clubMember", clubMember);
		
		ClubAuthMemberDTO clubAuthMemberDTO 
			= new ClubAuthMemberDTO(
					clubMember.getEmail(), 
					clubMember.getPassword(), 
					clubMember.isFromSocial(), 
					clubMember.getRoleset().stream().map(Role -> new SimpleGrantedAuthority("ROLE_" + Role.name())).collect(Collectors.toSet()));
		
		clubAuthMemberDTO.setName(clubMember.getName());
		clubAuthMemberDTO.setFromSocial(clubMember.isFromSocial());
		
		return clubAuthMemberDTO;
	}

}
