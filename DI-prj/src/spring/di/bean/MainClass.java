package spring.di.bean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("config/bean-config.xml");
		
		// singleton과 singleton1의 주소값은 동일 (default), 단 scope가 prototype이면 주소값이 달라지게 된다.
		Singleton singleton = context.getBean("singleton", Singleton.class);
		Singleton singleton1 = context.getBean("singleton", Singleton.class);
		
		System.out.println(singleton);
		System.out.println(singleton1);
		
		context.close();
	}
}
