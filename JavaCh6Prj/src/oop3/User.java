package oop3;

public class User {
	/*
	 * 속성 : name, age, gender
	 * 기능 : doPc, 
	 *       pcPowerOn, monitorPowerOn,
	 *       pcGame, pcMovie, pcInternet
	 *         
	 */
	
	String name = "";
	int age = 0;
	char gender;
	
	void pcPowerOn() {
		System.out.println("컴퓨터 전원을 킨다.");
		Computer com = new Computer();
		com.power();
	}
	
	void monitorPowerOn() {
		System.out.println("모니터 전원을 킨다.");
		Monitor monitor = new Monitor();
		monitor.power();
	}
	
	void pcGame() {
		System.out.println("게임을 한다.");
	}
	
	void pcMovie() {
		System.out.println("영화를 본다.");
	}
	
	void pcInternet() {
		System.out.println("인터넷을 한다.");
	}
}
