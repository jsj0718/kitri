package forandwhile;

import java.util.Scanner;

public class WhileStudy {

	public static void main(String[] args) {
		/*
		 * while - �ݺ���
		 * 
		 * while (1. ���ǽ�) { - ��, ��, boolean
		 * 	
		 * 		2. ���๮
		 * 
		 * }
		 * 
		 * 1(t) -> 2 -> 1(t) -> 2 -> 1 (���ǽ��� false�� ��� while�� ����);
		 */
		
		int i = 1;
		int sum = 0;
		while (i <= 10) {
			i++;
			sum += i;
		}
		System.out.println(sum);
		System.out.println("-----------");
		
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("��� ���� (1. ���, 2. ����) : ");
			int allow = sc.nextInt();
			if (allow == 2) {
				break;
			}
			System.out.print("�Է°� 1: ");
			int num1 = sc.nextInt();
			System.out.print("�Է°� 2: ");
			int num2 = sc.nextInt();
			System.out.println("�հ� : " + (num1 + num2));
		}
		
		System.out.println("��� ����");
		System.out.println("------------");
		
		sc.close();
	}

}
