package com.kitri.mini.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kitri.mini.user.service.ImgUserService;
import com.kitri.mini.user.service.NaverUserService;
import com.kitri.mini.user.vo.ImgUserVO;
import com.kitri.mini.user.vo.NaverUserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private ImgUserService iuservice;
	
	@Autowired
	private NaverUserService nuservice;
	
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping(value="/logincheck", method=RequestMethod.POST)
	@ResponseBody
	public boolean logincheck(@RequestBody ImgUserVO iuvo, HttpSession session) {
		
		// form 태그로 처리
//		if (iuservice.loginCheckImgUser(iuvo)) {
//			session.setAttribute("id", iuvo.getId());
//			return "redirect:/main";
//		}
//		
//		return "redirect:/user/login";
		
		// ajax로 처리
		
		boolean result = iuservice.loginCheckImgUser(iuvo);
		if (result) {
			session.setAttribute("id", iuvo.getId());
		}
		return result;
	}

	@RequestMapping("/naverlogin")
	public String naverlogin() {
		
		return "naverlogin";
	}
	
	@RequestMapping("/naverlogincheck")
	@ResponseBody
	public NaverUserVO naverlogincheck(@RequestBody NaverUserVO nuvo, HttpSession session) {
		System.out.println(nuvo.getEmail() + ", " + nuvo.getName() + ", " + nuvo.getBirthday() + ", " + nuvo.getMobile());
		
		// 선택 값이 null인 경우 ""으로 처리
		if (nuvo.getBirthday() == null) {
			nuvo.setBirthday("");
		}
		if (nuvo.getMobile() == null) {
			nuvo.setMobile("");
		}
		
		// 이미 등록이 되어 있는지 조회
		NaverUserVO vo = nuservice.searchNaverUser(nuvo.getEmail());
		// 등록이 안되어있으면 등록, 되어 있으면 등록없이 로그인 진행
		if (vo == null) {
			vo = nuvo;
			nuservice.registNaverUser(vo);
		}
		
		session.setAttribute("id", vo.getEmail());

		return vo;
		
	}
	
	@RequestMapping("/signup")
	public String signup() {
		
		return "signup";
	}
	
	@RequestMapping(value="/idcheck", method=RequestMethod.POST)
	@ResponseBody	// 데이터 전송을 위해 ResponseBody로 설정
	public boolean signupCheck(String id) {
		System.out.println(id);
		return iuservice.idCheckImgUser(id);
	}
	
	@RequestMapping(value="/signup-regist", method=RequestMethod.POST)
	public String signupRegist(ImgUserVO iuvo) {
		boolean result = iuservice.registImgUser(iuvo);
		if (result) {
			return "redirect:/user/login";			
		}
		return "redirect:/user/signup";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("id") != null) {
			session.removeAttribute("id");			
		}
		
		return "redirect:/user/login";
	}
	
	
}
