package spring.di.cal;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("config/cal-config.xml");
		Calculator cal = context.getBean("cal", Calculator.class);
		
		System.out.println("출력1 : " + cal.add());
		System.out.println("출력2 : " + cal.sub());
		
		context.close();
	}
}
