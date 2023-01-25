package spring.di.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ACar implements Car {
	@Autowired
	@Qualifier("tire2")
	private Tire t;

	// 기본 생성자
	public ACar() {
	}
	
	// 생성자를 이용한 DI 
	public ACar(Tire t) {
		this.t = t;
	}

	// setter를 이용한 DI
	public void setT(Tire t) {
		this.t = t;
	}
	
	@Override
	public void turnOn() {
		System.out.println("A자동차 시동");
	}


	@Override
	public void turnOff() {
		System.out.println("A자동차 정지");
	}
	
	@Override
	public void runCar() {
//		System.out.println("A자동차 자동차가 달린다.");
		t.run();
	}
	
	@Override
	public void breakCar() {
//		System.out.println("A자동차 자동차가 멈춘다.");
		t.stop();
	}
}
