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

	// 기본 생성자
	public BCar() {
	}
	
	// 생성자를 이용한 DI 
	public BCar(Tire t) {
		this.t = t;
	}

	// setter를 이용한 DI
	public void setT(Tire t) {
		this.t = t;
	}
	
	@Override
	public void turnOn() {
		System.out.println("B자동차 시동");
	}
	@Override
	public void turnOff() {
		System.out.println("B자동차 시동 정지");
	}
	@Override
	public void runCar() {
//		System.out.println("B자동차가 달린다.");
		t.run();
	}
	@Override
	public void breakCar() {
//		System.out.println("B자동차가 멈춘다.");
		t.stop();
	}
}
