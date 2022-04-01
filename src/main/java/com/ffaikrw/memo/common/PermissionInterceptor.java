package com.ffaikrw.memo.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component	// Controller, Service, Repository가 아닌데 spring bean에 등록하고 싶을 때 사용하는 어노테이션.
public class PermissionInterceptor implements HandlerInterceptor {
	
	// 요청이 들어올 때
	@Override
	public boolean preHandle(
			HttpServletRequest request
			, HttpServletResponse response
			, Object handler
			) throws IOException {
		
		// /post/list_view
		String uri = request.getRequestURI();
		
		// 로그인 여부 확인
		HttpSession session = request.getSession();
		
		Integer userId = (Integer)session.getAttribute("userId");
		
		if(userId == null) { // 로그인 X
			
			// 리스트 화면 접근 X => /post/list_view
			// 글쓰기 화면 접근 X => /post/create_view
			if(uri.startsWith("/post")) { // 로그인 화면으로 이동
				response.sendRedirect("/user/signin_view");
				return false;
			}
			
		} else { // 로그인 O
			// 로그인 화면 접근 X => /user/signin_view
			// 회원가입 화면 접근 X => /user/signup_view
			if (uri.startsWith("/user")) { // 리스트 화면으로 이동
				response.sendRedirect("/post/list_view");
				return false;
			}
			
		}
		
		return true;
		
	}
	
	
	@Override
	public void postHandle(
			HttpServletRequest request
			, HttpServletResponse response
			, Object handler
			, ModelAndView modelAndView
			) {

	}
	
	
	@Override
	public void afterCompletion(
			HttpServletRequest request
			, HttpServletResponse response
			, Object handler
			, Exception ex
			) {
		
	}
	
	
}
