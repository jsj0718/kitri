package spring.di.car;

import org.springframework.stereotype.Component;

@Component
public class Tire1 implements Tire {

	@Override
	public void run() {
		System.out.println("Tire1 �޸���");
	}

	@Override
	public void stop() {
		 System.out.println("Tire1 ���ߴ�");
	}

}
