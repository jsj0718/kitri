package spring.di.bean;

import org.springframework.stereotype.Component;

@Component
public class Singleton {
	public Singleton() {
		System.out.println("singletone Ŭ���� ������");
	}
}
