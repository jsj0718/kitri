package oop2;

public class Calculator {
	/*
	 * �Ӽ� : ���ȭ�� Size
	 * ��� : ���ϱ�, ����, ���ϱ�, ������ ��
	 * 
	 */
	
	String printSize = "";
	
	// ���ϱ�
	int add(int a, int b) {
		int result = a + b;
		return result;
	}
	
	// ����
	int minus(int a, int b) {
		int result = a - b;
		return result;
	}
	
	// ���ϱ�
	int multi(int a, int b) {
		int result = a * b;
		return result;
	}
	
	// ������
	double divide(int a, int b) {
		double result = (double) a / b;
		return result;
	}
}
