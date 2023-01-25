package oop3;

public class Monitor {
	/*
	 * 속성 : size, brand
	 * 기능 : power
	 */
	
	int size = 0;
	String brand = "";
	boolean power = false;
	
	void power() {
		power = true;
		System.out.println("모니터 화면 ON");
	}
}
