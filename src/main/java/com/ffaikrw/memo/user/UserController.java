package com.ffaikrw.memo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// 회원가입 View
	@GetMapping("/signup_view")
	public String signupView() {
		return "user/signUp";
	}
	
	// 로그인 View
	@GetMapping("/signin_view")
	public String signinView() {
		return "user/signIn";
	}
	
}
