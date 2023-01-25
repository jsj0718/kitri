package spring.aop.board;

import org.aspectj.lang.ProceedingJoinPoint;

public class Log {
	
	// 공통 기능
	public void afterLog() {
		System.out.println("-----after log 출력-----");
	}
	
	public void beforeLog() {
		System.out.println("-----before log 출력-----");
	}
	
	// 공통기능 around (pom.xml에 aspectjrt 부분의 scope를 주석 처리해야 한다.)
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("-----around log 출력-----");
		
		Object obj = pjp.proceed();
		
		System.out.println("-----around log 출력-----");
		return obj;
	}
}
