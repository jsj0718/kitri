package first.test;

class Print {
	public static void main(String args[]) {
		
		/*
		 * ----------------Ŭ���� ����
		 * package : ���� �ڹ��� package ��ġ�� �ʼ��� ���´�.
		 * ��) first.test.Print.java
		 * 
		 * class : Ŭ���� ���� �տ� �ʼ��� �ۼ�
		 * Print : Ŭ������ �̸� (�տ� ���ڴ� �빮�ڿ��� �Ѵ�.), ���ϸ�� Ŭ�������� �����ؾ� �Ѵ�.
		 * public static void main(String[] args) {
		 * 	�ڹٿ��� ó�� ���๮�� �����ϱ� ���� �ʿ���
		 * }
		 * ----------------�ܼ� ��¹�
		 * System.out.print() : ��� (�������� ����)
		 * System.out.println() : ��� �� ���� ��������
		 * System.out.printf() : ���� ���
		 * 
		 * \n : ���� �������� (���๮��)
		 */
		
		System.out.print("print-test");
		System.out.println();
		System.out.println("print-test �� ���");		
		System.out.printf("%d�� ���, %s�� ���, %.1f�� ��� \n", 10, "���븸", 123.123);
		System.out.println("printf �� ���");
		
		
		/*
		 * Ŭ������ : PrintEx
		 * ������� : -------
		 * ��系�� : -------
		 * ���� : ---
		 */
	}
}
