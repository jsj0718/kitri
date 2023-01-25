package oop1;

public class Car {
	/*
	 * ����
	 * 	- ��������(�������)
	 * 	- ��������(�޼ҵ� �ȿ� ���������� �ִ�.)
	 * 
	 * ������ X
	 * 
	 * �޼ҵ�(���)
	 * 	- ������ �������ִ� ����(�ڽ�)
	 *	- �����, ����, �ݺ�, ���� ... �� �޼ҵ� �ȿ��� ���� ����
	 */
	
	String brand = "Hyundai";
	String carName = "Genesis";
	int engine = 3000;
	String gear = "auto";
	
	/*
	 * ���Ÿ�� �޼ҵ�� (�Է¸��(���� x, Ÿ��x)) {
	 * 		���๮1;
	 * 		���๮2;
	 *		...
	 *
	 *		return ���Ÿ�Կ� �ش��ϴ� ����; (void�� ��� return ����)
	 * }
	 * 
	 */
	
	// �ڵ��� �õ��� �Ŵ� �޼ҵ�
	void doStartUp() {
		System.out.println(carName + " �õ� ON");
	}
	
	void accelator() {
		System.out.println(carName + " �Ǽ� ����");
	}

	void carBreak() {
		System.out.println(carName + " �극��ũ ����");
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
