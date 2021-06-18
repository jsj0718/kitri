package oop1;

public class Car {
	/*
	 * 변수
	 * 	- 전역변수(멤버변수)
	 * 	- 지역변수(메소드 안에 지역변수가 있다.)
	 * 
	 * 생성자 X
	 * 
	 * 메소드(기능)
	 * 	- 동작을 실행해주는 공간(박스)
	 *	- 입출력, 연산, 반복, 조건 ... 등 메소드 안에서 실행 가능
	 */
	
	String brand = "Hyundai";
	String carName = "Genesis";
	int engine = 3000;
	String gear = "auto";
	
	/*
	 * 출력타입 메소드명 (입력명수(개수 x, 타입x)) {
	 * 		실행문1;
	 * 		실행문2;
	 *		...
	 *
	 *		return 출력타입에 해당하는 변수; (void인 경우 return 없음)
	 * }
	 * 
	 */
	
	// 자동차 시동을 거는 메소드
	void doStartUp() {
		System.out.println(carName + " 시동 ON");
	}
	
	void accelator() {
		System.out.println(carName + " 악셀 가동");
	}

	void carBreak() {
		System.out.println(carName + " 브레이크 가동");
	}
	
	String carInfo(String inBrand, String inCarName, int inEngine, String inGear) {
//		this.brand = brand;
//		this.carName = carName;
//		this.engine = engine;
//		this.gear = gear;
		
//		String info = brand + ", " + carName + ", " + engine + ", " + gear;
		String info = inBrand + "\t" + inCarName + "\t" + inEngine + "\t" + inGear;
		return info;
	}
	
}
