package spring.di.car;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
//		생성자 함수, 인터페이스를 활용하여 DI Test
//		Car car = new ACar(new Tire2());	// car A, B 객체에 tire 1, 2 객체를 주입 (생성자 이용)
//		car.setT(new Tire1());	// car A, b 객체에 tire1, 2 객체를 주입 (setter 이용)
		
		
//		IoC 컨테이너를 사용하여 DI Test
		
		// IoC 컨테이너
		AbstractApplicationContext context = new GenericXmlApplicationContext("config/config.xml");
		
		// Acar acar = new Acar();
		// Tire1 tire1 = new Tire1();
//		Tire tire = context.getBean("tire", Tire.class);
		Car car = context.getBean("ACar", Car.class);
//		car.setT(tire);
		
		car.turnOn();
		car.turnOff();
		car.runCar();
		car.breakCar();	
		
		context.close();
	}
}
