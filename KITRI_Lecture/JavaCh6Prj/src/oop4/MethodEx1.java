package oop4;

public class MethodEx1 {

	public static void main(String[] args) {
		MethodEx1 me1 = new MethodEx1();
		
		me1.printOddSum(10, 20);
		me1.printEvenOddSum(10, 20);
		int sum = me1.printInputSum(20, 10);
		System.out.println(sum);
		
		int[] arr = {20, 10, 30, 50, 40};
		int max = me1.maxValue(arr);
		System.out.println(max);
		
	}
	
	// 1~10���� Ȧ���� �� ��� �޼ҵ� �����
	void printOddSum(int a, int b) {
		int sum = 0;
		for (int i=a; i<b; i++) {
			if (i % 2 == 1) {
				sum += i;				
			}
		}
		System.out.println("Ȧ���� �� : " + sum);
	}
	
	// 1~10���� ¦��, Ȧ���� �� ��� �޼ҵ� �����
	void printEvenOddSum(int a, int b) {
		int evenSum = 0;
		int oddSum = 0;
		
		for (int i=a; i<=b; i++) {
			if (i % 2 == 0) {
				evenSum += i;				
			} else {
				oddSum += i;
			}
		}
		System.out.println("¦���� �� : " + evenSum);
		System.out.println("Ȧ���� �� : " + oddSum);
	}
	
	// a, b�� �ް� ���� �� ~ ū �������� �հ� ��ȯ
	int printInputSum(int a, int b) {
		int sum = 0;
		if (a > b) {
			for (int i=b; i<=a; i++) {
				sum += i;
			}
		} else {
			for (int i=a; i<=b; i++) {
				sum += i;
			}
		}
		return sum;
	}
	
	// �Է� �迭�� �ް� �ִ밪 ���
	int maxValue(int[] array) {
		int max = array[0];
		for (int i=1; i<array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		
		return max;
	}
}
