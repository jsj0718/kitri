package inheritance;

public class B extends A {	// AŬ������ ��� ���� BŬ����
	/*
	 * ��� - �θ� Ŭ���� ����, �޼ҵ带 �ڽ� Ŭ�������� �� �� ����
	 * 
	 * ��) class B extends A // A: �θ�Ŭ����, B: �ڽ�Ŭ����
	 * 
	 * �������̵�(OverWriting) 
	 * - �θ�Ŭ������ �޼ҵ带 �ڽ�Ŭ�������� ��������
	 * - �޼ҵ��, �Ű����� ����/Ÿ��/����Ÿ���� ���ƾ� �Ѵ�.
	 * - �ڽ�Ŭ�������� ������ ���� ������ �θ�Ŭ���� �޼ҵ带 ȣ��
	 * 	 ������, �ڽ�Ŭ�������� �������ϸ� �ڽ�Ŭ���� �޼ҵ带 ȣ��
	 * 
	 * ��) 
	 * 	class A
	 * 		void method() {
	 * 			sysout("�θ�Ŭ���� �޼ҵ�");
	 * 		}
	 * 
	 *	class A extends B
	 * 		void method() {
	 * 			sysout("�ڽ�Ŭ���� ������ �޼ҵ�");
	 * 		}	
	 */
	
	String strB;
	
	void methodB() {
		System.out.println("method B");
	}
	
	void methodA() {
		System.out.println("method A ������");
	}
}
