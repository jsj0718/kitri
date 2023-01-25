package oop4;

public class MethodClass2 {

	public static void main(String[] args) {
		MethodClass2 m2 = new MethodClass2();
		m2.printNumber1(10);
		m2.printNumber2(1, 50);
		// inputSum ��ȯŸ���� int�̱� ������ �� ���� �ִ� ������ int���� �Ѵ�.
		int sum = m2.inputSum(1, 20);	// 1~20 �հ� ����
	}
	
	// 1~n���� ����ϴ� �޼ҵ�
	
	void printNumber1(int n) {
		for (int i=1; i<=n; i++) {
			System.out.print(i + " ");
		}
		// ���� Ŭ���� ������ �޼ҵ� ȣ�� ��� (static�� ���ٸ� �̸� �״�� ��� ����)
		printEnter();
	}
	
	// start���� end���� ����ϴ� �޼ҵ�
	void printNumber2(int start, int end) {
		// start = 1, end = 50
		for (int i=start; i<=end; i++) {
			System.out.print(i + " ");
		}
		printEnter();
	}
	
	// ���� �������� "---------------" �������ִ� �޼ҵ�
	void printEnter() {
		System.out.println("\n-------------------");
	}
	
	// start ~ end���� �հ� ���� ��ȯ���ִ� �޼ҵ�
	int inputSum(int start, int end) {
		int sum = 0;
		for (int i=start; i<=end; i++) {
			sum += i;
		}
		return sum;
	}
}
