package com.kitri.mvctest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form() {
		
		return "form";
	}
	
	@RequestMapping("/join")
	public String join(
//	public ModelAndView join(	// 3번 방식
			// HttpServletRequest가 Spring에서 자동 주입시켜 준다.
//			HttpServletRequest req,
//			@RequestParam("id") String id,
//			@RequestParam("pw") String pw
//			@RequestParam String id,
//			@RequestParam("pw") String pwd,
//			@RequestParam(defaultValue = "기본 사용자") String name,	// defaultValue, required가 없이 값이 넘어오면 빈 공백으로 처리된다.
//			@RequestParam(value="hobby", required=false) String hobby,
//			String address,
//			String phone,
//			String email
//			MemberVO mvo,	// mvo 내 변수와 form에서 오는 변수가 동일하면 자동으로 매핑된다.
			@ModelAttribute("mvo") MemberVO mvo,	// mvo값을 가져오자마자 바로 Model에 매핑시켜준다. (따로 적을 필요 X) -> 바로 값을 넘길 때는 이것을 이용
			Model model
//			ModelAndView mav
			) {
//		String id = req.getParameter("id");
//		String pw = req.getParameter("pw");
		
		System.out.println("id : " + mvo.getId());
		System.out.println("pw : " + mvo.getPw());
		System.out.println("name : " + mvo.getName());
		System.out.println("address : " + mvo.getAddress());
		System.out.println("phone : " + mvo.getPhone());
		System.out.println("email : " + mvo.getEmail());
		System.out.println("gender : " + mvo.getGender());
		System.out.println("hobby : " + mvo.getHobby());
		
		// 1번 방식 (HttpServletRequest 방식 이용)
//		req.setAttribute("id", mvo.getId());
//		req.setAttribute("name", mvo.getName());
		
		// 2번 방식 (Model 방식 이용) -> 주로 사용하는 방법
//		model.addAttribute("id", mvo.getId());
//		model.addAttribute("name", mvo.getName());
//		model.addAttribute("mvo", mvo);
		
		
		// 3번 방식 (ModelAndView 방식 이용)
//		mav.addObject("id", mvo.getId());
//		mav.addObject("name", mvo.getName());
//		mav.setViewName("join-ok");
		
		return "redirect:join-ok";	// redirect 방식 (view resolver(jsp로 이동)가 작동하지 않고 바로 join-ok라는 url로 이동시킴) -> 데이터 전송이 끊김
//		return "join-ok";
//		return mav;	// 3번 방식
	}
	
	@RequestMapping("/join-ok")
	public String joinOk() {
		
		return "join-ok";
	}
}
