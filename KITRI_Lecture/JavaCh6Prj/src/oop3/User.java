package oop3;

public class User {
	/*
	 * �Ӽ� : name, age, gender
	 * ��� : doPc, 
	 *       pcPowerOn, monitorPowerOn,
	 *       pcGame, pcMovie, pcInternet
	 *         
	 */
	
	String name = "";
	int age = 0;
	char gender;
	
	void pcPowerOn() {
		System.out.println("��ǻ�� ������ Ų��.");
		Computer com = new Computer();
		com.power();
	}
	
	void monitorPowerOn() {
		System.out.println("����� ������ Ų��.");
		Monitor monitor = new Monitor();
		monitor.power();
	}
	
	void pcGame() {
		System.out.println("������ �Ѵ�.");
	}
	
	void pcMovie() {
		System.out.println("��ȭ�� ����.");
	}
	
	void pcInternet() {
		System.out.println("���ͳ��� �Ѵ�.");
	}
}
