package spring.di.car;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
//		������ �Լ�, �������̽��� Ȱ���Ͽ� DI Test
//		Car car = new ACar(new Tire2());	// car A, B ��ü�� tire 1, 2 ��ü�� ���� (������ �̿�)
//		car.setT(new Tire1());	// car A, b ��ü�� tire1, 2 ��ü�� ���� (setter �̿�)
		
		
//		IoC �����̳ʸ� ����Ͽ� DI Test
		
		// IoC �����̳�
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
