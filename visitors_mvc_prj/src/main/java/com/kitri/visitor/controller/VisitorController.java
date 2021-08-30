package com.kitri.visitor.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// sendRedirect를 이용하여 session 등록 후 페이지 이동
	@RequestMapping("/session")
	public String session(String nickname, HttpSession session) {
		session.setAttribute("nickname", nickname);
		
		return "redirect:/visitor";
	}
	
	@RequestMapping("/visitor")
	public String visitor(Model model) {		
		List<VisitorVO> vlist = vservice.searchVisitors();
		model.addAttribute("vlist", vlist);	// model에 담아서 데이터 전송

		return "visitor";
	}
	
	// sendRedirect로 데이터 등록 후 페이지 이동
	@RequestMapping("/regist")
	public String regist(VisitorVO vvo) {
		int result = vservice.registVisitor(vvo);
		
		return "redirect:/visitor";
	}
	
	@RequestMapping("/update")
	public String update(VisitorVO vvo) {
		int result = vservice.updateVisitor(vvo);
		
		return "redirect:/visitor";
	}
	
	@RequestMapping("/delete")
	// RequestParam("")을 추가하는 것이 정석 (값을 하나만 받아오는 경우)
	public String update(@RequestParam("vno") int vno) {
		int result = vservice.deleteVisitor(vno);
		
		return "redirect:/visitor";
	}
}
