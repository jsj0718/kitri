package ifandswitch;

import java.util.Scanner;

public class SwitchStudy {
	public static void main(String[] args) {
		/*
		 * switch-case - ���ǹ�
		 * 
		 * switch (���Ǻ���) // ���� ������ �� �� �ִ� ���� "����, ����, ���ڿ�"�� ����
		 * 		case ��1-1: ��1-2: ��1-3: ��1-4 ...
 		 * 			���๮1;
		 * 			���๮2;
		 * 			���๮3;
		 * 			...
		 * 			break;
		 * 
		 * 		case ��2:
		 * 			���๮1;
		 * 			���๮2;
		 * 			���๮3;
		 * 			...
		 * 			break;
		 * 		...
		 * 
		 * 		default:
		 * 			���๮1
		 */
		
		Scanner sc = new Scanner(System.in);
//		int score = sc.nextInt();
		
//		switch(score) {
//			case 90:
//				System.out.println("���� A");
//				break;
//			case 80:
//				System.out.println("���� B");
//				break;
//			case 70:
//				System.out.println("���� C");
//				break;
//			default:
//				System.out.println("���� F");
//		}
//		
//		System.out.println("----------------");
		
//		+, ���ϱ�, �÷���
		System.out.print("�Է°�1 : ");
		int var1 = sc.nextInt();
		System.out.print("�Է°�2 : ");
		int var2 = sc.nextInt();
		
		System.out.print("���� �Է� : ");
		String op = sc.next();
		
		int result = 0;
		switch(op) {
			case "+": case "���ϱ�": case "plus":
				result = var1 + var2;
				break;
			case "-": case "����": case "minus":
				result = var1 - var2;
				break;
			case "*": case "���ϱ�": case "multiply":
				result = var1 * var2;
				break;
			case "/": case "������": case "division":
				result = var1 / var2;
				break;
			default:
				System.out.println("��� ����");
		}
		System.out.println("�����: " + result);
		
		sc.close();
	}
}
