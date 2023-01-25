package oop1;

public class MainClass {

	public static void main(String[] args) {
		// void : 반환값이 없는 함수 타입
		// main : 자바에서 실행해주는 함수
		
		Car carA = new Car();	// Car 하나를 생성
		carA.carName = "Sonata";
		System.out.println(carA.brand);
		System.out.println(carA.carName);
		
		carA.doStartUp();
		carA.accelator();
		carA.carBreak();
		
		String info = carA.carInfo("Ford", "Explorer", 4000, "auto");
		System.out.println("브랜드\t차이름\t엔진(cc)\t기어");
		System.out.println(info);

		System.out.println("---------------");
		Car carB = new Car();
		carB.carName = "Avante";
		System.out.println(carB.brand);
		System.out.println(carB.carName);
		System.out.println(carB.engine);
		
		carB.doStartUp();
		carB.accelator();
		carB.carBreak();
	}

	public void a() {
	}
}
