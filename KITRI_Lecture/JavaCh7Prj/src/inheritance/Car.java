package inheritance;

public class Car {
	String brand;
	int door;	// 문의 개수
	String engine;
	int tire;	// 타이어 사이즈
	
	void run() {
		System.out.println("차가 달린다.");
	}
	
	void stop() {
		System.out.println("차가 멈춘다.");
	}
}
