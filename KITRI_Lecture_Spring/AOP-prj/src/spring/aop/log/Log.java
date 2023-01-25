package spring.aop.log;

import org.aspectj.lang.ProceedingJoinPoint;

public class Log {
	
	// 공통 기능
	public void logPrint() {
		System.out.println("-----log 출력-----");
	}
	
	// 공통기능 around (pom.xml에 aspectjrt 부분의 scope를 주석 처리해야 한다.)
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("-----around log 출력-----");
		
		Object result = pjp.proceed();
		
		System.out.println("-----around log 출력-----");
		return result;
	}
}
