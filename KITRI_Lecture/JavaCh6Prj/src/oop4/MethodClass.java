package oop4;

// Ŭ���� �̸� ������ refactor -> rename���� ������ �� �ִ�.
public class MethodClass {
	
	String str = "��������";
	
	// main �޼ҵ�
	// �ڹ� ���α׷��� ó�� �������ִ� �޼ҵ�
	public static void main(String[] args) {
		/*
		 * �������� : Ŭ���� �ٷ� �Ʒ� ���̴� ���� (��������, �������, �ν��Ͻ�����)
		 * 		- Ŭ���� ������ ��� ���� (�޼ҵ� ��� X)
		 * 		- �ʱ�ȭ�� �ڵ����� �̷����
		 * �������� : �޼ҵ峪 ���ǹ�, �ݺ��� �ȿ��� ���̴� ����
		 * 			{...} �ȿ��� ����
		 * 		- �޼ҵ� ��, ���ǹ�/�ݺ��� ������ ��� ����
		 * 		- �ʱ�ȭ�� �ڵ����� �̷������ ����
		 * �޼ҵ� : Ŭ���� ������ ����� ����
		 * 		   (����, ���ǹ�, �ݺ���, ���, ���๮ ��)
		 * 
		 * 		- ��� ���
		 * 			���Ÿ��(��ȯŸ��) �޼ҵ��(�Էº���-���� x, Ÿ�� ��� x(�⺻Ÿ��, ����Ÿ��[�迭, String ��])) {
		 *          	���๮ // �߰�ȣ �ȿ��� ����
		 *          } 
		 *          
		 *          ��) ���Ÿ���� ���� �޼ҵ�, �Է� �ϳ�
		 *          	void m1(int a) {
		 *          		// return ����
		 *          	}
		 *          
		 *          	���Ÿ���� int, �Է��� �� �� (int, String)
		 *          	int m2(int a, String s) {
		 *          		// ���Ÿ���� �ִ� ��� return �ʼ�
		 *          		return intŸ���� ����
		 *          		or
		 *          		return 10;
		 *          	}
		 *          
		 *          	���Ÿ���� String, �Է��� �ϳ� (int[])
		 *          	String m3(int[] array) {
		 *          		// ���Ÿ���� �ִ� ��� return �ʼ�
		 *          		return StringŸ���� ����
		 *          		or
		 *          		return "��";
		 *          	}
		 *          
		 *          	�� ��, ����� ���� ���� ��� �迭�� �̿��Ѵ�.
		 * 
		 * static�� ���� �޼ҵ� �ȿ����� ��üȭ�� �̷������ �Ѵ�.
		 */
		
		String localStr = "��������1";
		
		MethodClass m1 = new MethodClass();	// ��üȭ
		m1.str = "�������� ����";
		System.out.println(m1.str);
		
		System.out.println(localStr);
		m1.function1();
	}
	
	void function1() {
		String localStr = "��������2";
		System.out.println(str);
		System.out.println(localStr);
	}
	
	// ��ȯŸ�� ����, �Է��� ���� �޼ҵ� (�ܼ� ���, ��� ��)
	void method1() {	// �Է��� ���� ��� �� ��ȣ
		System.out.println("method1 ���");	// ��¹�
		int a = 0;
		int b = 0;
		int sum = a + b;	// �޼ҵ� ������ ����� ������ ���๮
		
		str = "method1���� �������� ����";
	}
	
	// ��ȯ�� ����, �Է��� �ִ� �޼ҵ� 
	void method2(String s) {
		// �Է��� �޾Ƽ� ó��(���, ����) �� �� ���
		System.out.println(s + " ���ڰ� �Է�");	// �Է��� �޾� ���
		s += " ������ ���ڰ�";	// �Է°��� ����
	}
	
	// ��ȯ�� �ְ�, �Է��� �ִ� ��� �޼ҵ�
	String method3(int a, String s, int[] arr) {
		arr[0] = a;
		for (int i=0; i<10; i++) {
			System.out.println(i);
		}
		String result = s + a;
		
		return result;
	}
	
	// ��ȯ�� �ְ�, �Է��� ���� ��� �޼ҵ�
	int[] method4() {
		int[] result = new int[5];
		result[0] = 1;
		result[1] = 2;
		return result;
	}
}
