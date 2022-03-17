package com.ffaikrw.memo.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ffaikrw.memo.user.model.User;

@Repository
public interface UserDAO {
	
	// 회원가입 API
	public int insertUser(
			@Param("loginId") String loginId,
			@Param("password") String password,
			@Param("name") String name,
			@Param("email") String email
			);
	
	
	// 로그인 API
	public User selectUser(
			@Param("loginId") String loginId,
			@Param("password") String password
			);
	
}
