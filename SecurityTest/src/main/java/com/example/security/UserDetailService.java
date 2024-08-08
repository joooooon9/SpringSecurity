package com.example.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailService implements UserDetailsService {
	
	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		
		System.out.println(id + "@@@@@@@");
		//UserVO vo = userMapper.selectUser(id);
		
		UserEntity vo = repository.findUserByIdNativequery(id);
		
		repository.findUserAndBoard(id);
		
		if(vo == null) {
			throw new UsernameNotFoundException("유저를 찾을 수 없습니다.");
		}
		
		System.out.println(vo.getPassword());
		
		return new UserDetail(
						vo.getId(), 
						vo.getPassword(), 
						Collections.singletonList(new SimpleGrantedAuthority(vo.getRole())), 
						vo.getNickname()
					);
	}
	
}
