package operator;

import java.util.Scanner;

public class OperatorEx {

	public static void main(String[] args) {
//		int num = 10;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է��ϼ���: ");
		int num = sc.nextInt();
		
		String result1 = (num % 3 == 0 && num != 0) ? "3�� ��� O" : "3�� ��� X";
		String result2 = (num % 5 == 0 && num != 0) ? "5�� ��� O" : "5�� ��� X";
		System.out.println("���� : " + num + ", " + result1 + ", " + result2);
		
		num++;
		
		String result3 = (num % 3 == 0 && num != 0) ? "3�� ��� O" : "3�� ��� X";
		String result4 = (num % 5 == 0 && num != 0) ? "5�� ��� O" : "5�� ��� X";
		System.out.println("���� : " + num + ", " + result3 + ", " + result4);
		
		sc.close();
	}

}
