package ifandswitch;

import java.util.Scanner;

public class IfStudy {
	public static void main(String[] args) {
		/*
		 * if�� - ���ǹ�
		 * 
		 * if (���ǽ�) {	// ���ǽĿ��� true, false�� ������ boolean, ��(> == ...), ��(&&, ||) ��
		 * 		���ǽ��� true�� �� ����
		 * } 
		 * 
		 * if (���ǽ�) {
		 * 		���ǽ��� true�� �� ����
		 * } else {
		 * 		���ǽ��� false�� �� ����
		 * }
		 * 
		 * 	- else if�� ���� ������ ����.
		 * if (���ǽ�1) {
		 * 		���ǽ�1�� true�� �� ����
		 * } else if (���ǽ�2) {
		 * 		���ǽ�1�� false, ���ǽ�2�� true�� �� ����
		 * } else {
		 * 		���ǽ�1, ���ǽ�2�� false�� �� ����
		 * }
		 */
		
		int num = 5;
		
		if(num % 3 ==0) {
			System.out.println("3�� ��� O");
		} else {
			System.out.println("3�� ��� X");
		}		
		System.out.println("--------------");
		
		if (num % 5 == 0) 
			System.out.println("5�� ��� O");
		else 
			System.out.println("5�� ��� X");
		
		System.out.println("if else ���� ���Ե��� ���� ���");
		System.out.println("--------------");
		
		// ����, ����, ���� ������ ����, ���, ����	
		// ctrl + shift + o : �ڵ� import ����
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ���� : ");
		int kor = sc.nextInt();
		System.out.print("���� ���� : ");
		int eng = sc.nextInt();
		System.out.print("���� ���� : ");
		int math = sc.nextInt();
				
		if (kor >= 90) {
			System.out.println("���� ������ A");
		} else if (kor >= 80) {
			System.out.println("���� ������ B");
		} else if (kor >= 70 ) {
			System.out.println("���� ������ C");
		} else if (kor >= 60 ) {
			System.out.println("���� ������ D");
		} else {
			System.out.println("���� ������ F");
		}
		
		if (eng >= 90) {
			System.out.println("���� ������ A");
		} else if (eng >= 80) {
			System.out.println("���� ������ B");
		} else if (eng >= 70 ) {
			System.out.println("���� ������ C");
		} else if (eng >= 60 ) {
			System.out.println("���� ������ D");
		} else {
			System.out.println("���� ������ F");
		}
		
		if (math >= 90) {
			System.out.println("���� ������ A");
		} else if (math >= 80) {
			System.out.println("���� ������ B");
		} else if (math >= 70 ) {
			System.out.println("���� ������ C");
		} else if (math >= 60 ) {
			System.out.println("���� ������ D");
		} else {
			System.out.println("���� ������ F");
		}
		
		System.out.println("���� : " + (kor + eng + math));
		System.out.println("��� : " + (kor + eng + math) / 3);
		
		sc.close();
	}
}
