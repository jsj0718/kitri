package spring.di.car;

import org.springframework.stereotype.Component;

@Component
public class Tire2 implements Tire {

	@Override
	public void run() {
		System.out.println("Tire2 달리다");
	}

	@Override
	public void stop() {
		 System.out.println("Tire2 멈추다");
	}


}
