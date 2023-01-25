package oop3;

public class Computer {
	/*
	 * 속성 : cpu, ram, ssd, gpu, power
	 * 기능 : game, movie, internet
	 * 
	 */
	
	String cpu = "";
	int ram = 0;
	int ssd = 0;
	String gpu = "";
	boolean power = false;
	String lan = "";
	
	void power() {
		System.out.println("PC 전원 ON");
		power = true;
	}
	
	void game() {
		System.out.println("게임 실행");
	}
	
	void movie() {
		System.out.println("영화 실행");
	}
	
	void internet() {
		System.out.println("인터넷 실행");
	}
}
