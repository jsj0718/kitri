package com.kitri.mvctest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class InterceptorTest implements HandlerInterceptor {
	
	// preHandle을 가장 많이 사용(예시 : session이 없는 경우 로직을 기존과 다르게 처리 가능)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("preHandle 함수 호출");
		
//		return HandlerInterceptor.super.preHandle(request, response, handler);
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

		System.out.println("postHandle 함수 호출");
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

		System.out.println("afterCompletion 함수 호출");
		
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
