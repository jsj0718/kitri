package spring.di.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ACar implements Car {
	@Autowired
	@Qualifier("tire2")
	private Tire t;

	// �⺻ ������
	public ACar() {
	}
	
	// �����ڸ� �̿��� DI 
	public ACar(Tire t) {
		this.t = t;
	}

	// setter�� �̿��� DI
	public void setT(Tire t) {
		this.t = t;
	}
	
	@Override
	public void turnOn() {
		System.out.println("A�ڵ��� �õ�");
	}


	@Override
	public void turnOff() {
		System.out.println("A�ڵ��� ����");
	}
	
	@Override
	public void runCar() {
//		System.out.println("A�ڵ��� �ڵ����� �޸���.");
		t.run();
	}
	
	@Override
	public void breakCar() {
//		System.out.println("A�ڵ��� �ڵ����� �����.");
		t.stop();
	}
}
