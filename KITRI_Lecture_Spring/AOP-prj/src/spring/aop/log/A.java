package spring.aop.log;

import org.springframework.stereotype.Component;

@Component
public class A {
	// 핵심 기능
	public void aMethod() {
		System.out.println("a method 출력");
	}
	
	//핵심 기능
	public void a1Method() {
		System.out.println("a1 method 출력");
	}
	
}
