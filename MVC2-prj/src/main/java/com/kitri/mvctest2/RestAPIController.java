package com.kitri.mvctest2;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RestController // @ResponseBody가 없어도 동작하게 만듦 (기존 RequestMapping은 동작 X)
public class RestAPIController {

	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	// JSON 형태로 받기 위해 라이브러리 필요 (jackson lib, jackson은 json을 java 객체로 변환해주는 역할을 한다.)
	// JSON 형태로 Request 받는 방법은 AJAX밖에 없다.
	// String body 대신 UserVO uvo로 사용하면 자동으로 매핑되어 파싱을 따로 하지 않아도 된다.
	// RequestBody는 setter가 아닌 이름으로 매핑하므로 setter가 따로 없어도 된다.
	@RequestMapping("/reqbody")
	@ResponseBody
	public UserVO reqbody(@RequestBody UserVO uvo) {
		System.out.println(uvo.getId());
		System.out.println(uvo.getPw());
		System.out.println(uvo.getName());
		System.out.println(uvo.getEmail());
		
		return uvo;
	}
	
	@RequestMapping("/resbody")
	@ResponseBody	// 객체값을 json으로 바꿔서 리턴해주는 역할 (이렇게 response를 받으면 ajax로 처리해야 함)
	public UserVO resbody() throws IOException {
		
		// 실제로는 db에 있는 내용을 받아서 반환
		UserVO uvo = new UserVO();
		uvo.setId("user");
		uvo.setPw("123");
		uvo.setName("정대만");
		uvo.setEmail("user@naver.com");
		
		return uvo;
	}	
	// 옛날 방식
//	public void resbody(HttpServletResponse res) throws IOException {
//		PrintWriter out = res.getWriter();
//		out.print(json);
//	}
	
}
