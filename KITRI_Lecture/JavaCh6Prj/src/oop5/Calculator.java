package oop5;

public class Calculator {
	/*
	 * �޼ҵ� �����ε�
	 * 	- �޼ҵ���� ���� �޼ҵ带 ���� �� �ִ�.
	 * 	- ����: 1.�޼ҵ���� ����, 2.�Էº���(�Ű�����) Ÿ���� �ٸ��ų�, 3.������ �ٸ� ���
	 * 	- ����Ÿ���� ��� X
	 */
	
	// ���ϱ� �����ε�
	int add(int a, int b) {
		return a + b;
	}
	
	double add(int a, double b) {
		return a + b;
	}
	
	double add(double a, int b) {
		return a + b;
	}
	
	double add(double a, double b) {
		return a + b;
	}
	
	// ���� �����ε�
	int sub(int a, int b) {
		return a - b;
	}
	
	double sub(int a, double b) {
		return a - b;
	}
	
	double sub(double a, int b) {
		return a - b;
	}
	
	double sub(double a, double b) {
		return a - b;
	}
	
}
