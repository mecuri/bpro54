package com.keduit.bpro54.security.dto;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Setter
@ToString
// @Data - getter, setter, toString 대신 넣어도 돼
public class ClubAuthMemberDTO extends User implements OAuth2User{

	private String email;
	private String password;
	private String name;
	private boolean fromSocial;
	
	private Map<String, Object> attr;
	
	
	
	public ClubAuthMemberDTO(String username, String password, boolean fromSocial, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.password = password;
		this.email = username;
		this.fromSocial = fromSocial;
	}

	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return this.attr;
	}


	public ClubAuthMemberDTO(String username, String password, boolean fromSocial, Collection<? extends GrantedAuthority> authorities, Map<String, Object> attr) {
		this(username, password, fromSocial, authorities);
		this.attr = attr;
	}

}
