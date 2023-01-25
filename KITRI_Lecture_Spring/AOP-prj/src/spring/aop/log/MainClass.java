package spring.aop.log;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
	
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("spring/aop/config/aop-config.xml");	// AbstractApplicationContext���� load()�� ����.
		ctx.refresh();
		
		A a = ctx.getBean("a", A.class);
		a.aMethod();
		a.a1Method();
		
		ctx.close();
		
	}
}
