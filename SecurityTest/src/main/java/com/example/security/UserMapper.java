package com.example.security;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	
	@Insert("INSERT INTO user(id, password, nickname, role)"
			+ "VALUES(#{id}, #{password}, #{nickname}, 'USER');")
	int insertUser(UserVO vo);
	
	@Select("SELECT * FROM user WHERE id = #{id}")
	UserVO selectUser(String id);
}
