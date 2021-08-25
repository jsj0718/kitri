package spring.di.bean;

import org.springframework.stereotype.Component;

@Component
public class Singleton {
	public Singleton() {
		System.out.println("singletone 클래스 생성자");
	}
}
