package com.example.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDetail extends User{
	
	private String nickname;

	public UserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities, String nickname) {
		super(username, password, authorities);
		this.nickname = nickname;
	}
	
	public String getNickname() {
		return nickname;
	}
	
}
