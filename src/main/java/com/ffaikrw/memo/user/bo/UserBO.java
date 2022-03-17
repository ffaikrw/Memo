package com.ffaikrw.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffaikrw.memo.common.EncryptUtils;
import com.ffaikrw.memo.user.dao.UserDAO;
import com.ffaikrw.memo.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	// 회원가입 API
	public int addUser(
			String loginId,
			String password,
			String name,
			String email
			) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.insertUser(loginId, encryptPassword, name, email);
	}
	
	
	// 로그인 API
	public User getUser(String loginId, String password) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.selectUser(loginId, encryptPassword);
	}
	
}
