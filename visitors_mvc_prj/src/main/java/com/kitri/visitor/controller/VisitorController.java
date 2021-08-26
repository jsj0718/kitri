package com.kitri.visitor.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kitri.visitor.service.VisitorService;
import com.kitri.visitor.vo.VisitorVO;

@Controller
public class VisitorController {
	@Autowired
	private VisitorService vservice;
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("/visitor")
	public String visitor(String nickname, HttpSession session) {
		
		session.setAttribute("nickname", nickname);	// 세션 유지 (JSP 파일에서 session scope 사용없이 바로 사용 가능)
		
		ArrayList<VisitorVO> vlist = vservice.searchVisitors();
		
		return "visitor";
	}
}
