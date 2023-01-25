package spring.di.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BCar implements Car{
//	@Resource(name="t1")
//	@Inject
//	@Named("t2")
	
	@Autowired
	@Qualifier("tire1")
	private Tire t;

	// �⺻ ������
	public BCar() {
	}
	
	// �����ڸ� �̿��� DI 
	public BCar(Tire t) {
		this.t = t;
	}

	// setter�� �̿��� DI
	public void setT(Tire t) {
		this.t = t;
	}
	
	@Override
	public void turnOn() {
		System.out.println("B�ڵ��� �õ�");
	}
	@Override
	public void turnOff() {
		System.out.println("B�ڵ��� �õ� ����");
	}
	@Override
	public void runCar() {
//		System.out.println("B�ڵ����� �޸���.");
		t.run();
	}
	@Override
	public void breakCar() {
//		System.out.println("B�ڵ����� �����.");
		t.stop();
	}
}
