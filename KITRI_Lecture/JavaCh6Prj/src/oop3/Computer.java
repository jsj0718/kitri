package oop3;

public class Computer {
	/*
	 * �Ӽ� : cpu, ram, ssd, gpu, power
	 * ��� : game, movie, internet
	 * 
	 */
	
	String cpu = "";
	int ram = 0;
	int ssd = 0;
	String gpu = "";
	boolean power = false;
	String lan = "";
	
	void power() {
		System.out.println("PC ���� ON");
		power = true;
	}
	
	void game() {
		System.out.println("���� ����");
	}
	
	void movie() {
		System.out.println("��ȭ ����");
	}
	
	void internet() {
		System.out.println("���ͳ� ����");
	}
}
