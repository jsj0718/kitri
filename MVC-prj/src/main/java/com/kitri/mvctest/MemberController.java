package com.kitri.mvctest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form() {
		
		return "form";
	}
	
	@RequestMapping("/join")
	public String join(
			// HttpServletRequest가 Spring에서 자동 주입시켜 준다.
//			HttpServletRequest req
//			@RequestParam("id") String id,
//			@RequestParam("pw") String pw
			@RequestParam String id,
			@RequestParam("pw") String pwd,
			@RequestParam(defaultValue = "기본 사용자") String name,	// defaultValue, required가 없이 값이 넘어오면 빈 공백으로 처리된다.
			@RequestParam(value="hobby", required=false) String hobby,
			String address,
			String phone,
			String email
			
			) {
//		String id = req.getParameter("id");
//		String pw = req.getParameter("pw");
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pwd);
		System.out.println("name : " + name);
		System.out.println("hobby : " + hobby);
		System.out.println("address : " + address);
		System.out.println("phone : " + phone);
		System.out.println("email : " + email);
		return "join-ok";
	}
}
