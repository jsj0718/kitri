package com.kitri.mvctest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
// 묶어주는 용도로 사용
@RequestMapping("/mapping")
public class MappingTestController {
	
	// test
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test() {
		
		return "mapping-test";
	}
	
	// test1, test2
	@RequestMapping({"test1","test2"})
	public String test12() {
		
		return "mapping-test12";
	}
	
	// PathVariable 옆에 변수명을 맞추거나, 매개변수의 변수명을 맞추면 된다.
	@RequestMapping("/test/{val}")
	public String testVal(@PathVariable("val") String value) {
		System.out.println("val : " + value);
		return "mapping-testval";
	}
	
}
