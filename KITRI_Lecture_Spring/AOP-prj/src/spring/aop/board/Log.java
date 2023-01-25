package spring.aop.board;

import org.aspectj.lang.ProceedingJoinPoint;

public class Log {
	
	// ���� ���
	public void afterLog() {
		System.out.println("-----after log ���-----");
	}
	
	public void beforeLog() {
		System.out.println("-----before log ���-----");
	}
	
	// ������ around (pom.xml�� aspectjrt �κ��� scope�� �ּ� ó���ؾ� �Ѵ�.)
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("-----around log ���-----");
		
		Object obj = pjp.proceed();
		
		System.out.println("-----around log ���-----");
		return obj;
	}
}
