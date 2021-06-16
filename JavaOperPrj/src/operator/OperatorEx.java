package operator;

import java.util.Scanner;

public class OperatorEx {

	public static void main(String[] args) {
//		int num = 10;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력하세요: ");
		int num = sc.nextInt();
		
		String result1 = (num % 3 == 0 && num != 0) ? "3의 배수 O" : "3의 배수 X";
		String result2 = (num % 5 == 0 && num != 0) ? "5의 배수 O" : "5의 배수 X";
		System.out.println("숫자 : " + num + ", " + result1 + ", " + result2);
		
		num++;
		
		String result3 = (num % 3 == 0 && num != 0) ? "3의 배수 O" : "3의 배수 X";
		String result4 = (num % 5 == 0 && num != 0) ? "5의 배수 O" : "5의 배수 X";
		System.out.println("숫자 : " + num + ", " + result3 + ", " + result4);
	}

}
