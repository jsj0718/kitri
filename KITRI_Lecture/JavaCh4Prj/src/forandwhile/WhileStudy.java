package forandwhile;

import java.util.Scanner;

public class WhileStudy {

	public static void main(String[] args) {
		/*
		 * while - 반복문
		 * 
		 * while (1. 조건식) { - 비교, 논리, boolean
		 * 	
		 * 		2. 실행문
		 * 
		 * }
		 * 
		 * 1(t) -> 2 -> 1(t) -> 2 -> 1 (조건식이 false일 경우 while문 종료);
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
			System.out.print("계산 여부 (1. 계산, 2. 종료) : ");
			int allow = sc.nextInt();
			if (allow == 2) {
				break;
			}
			System.out.print("입력값 1: ");
			int num1 = sc.nextInt();
			System.out.print("입력값 2: ");
			int num2 = sc.nextInt();
			System.out.println("합계 : " + (num1 + num2));
		}
		
		System.out.println("계산 종료");
		System.out.println("------------");
		
		sc.close();
	}

}
