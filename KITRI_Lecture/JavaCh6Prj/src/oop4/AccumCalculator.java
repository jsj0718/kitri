package oop4;

public class AccumCalculator {
	
	int totalSum = 0;	// ��������
	String log = "";
	// + ����, ��ó�� ���Ǵ� �Լ�
	int add (int a, int b) {
		totalSum = a + b;
		log = bracket(a) + "+" + bracket(b);
		return totalSum;
	}
	
	// - ����, ��ó�� ���Ǵ� �Լ�
	int sub(int a, int b) {
		totalSum = a - b;
		if (b < 0) {
			log = bracket(a) + "+" + bracket2(b);			
		} else {
			log = bracket(a) + "-" + bracket2(b);
		}
		return totalSum;
	}
	
	int add(int a) {
		totalSum += a;
		log += "+" + bracket(a);
		return totalSum;
	}
	
	int sub(int a) {
		totalSum -= a;
		if (a < 0) {
			log += "+" + bracket2(a);			
		} else {
			log += "-" + bracket2(a);
		}
		return totalSum;
	}
	
	String bracket(int a) {
		String result = "";
		if (a < 0) {
			result = "(" + a + ")";
		} else {
			result = "" + a;
		}
		
		return result;
	}
	
	String bracket2(int a) {
		String result = "";
		if (a < 0) {
			result += -a;
		} else {
			result += a;
		}
		return result;
	}
}
