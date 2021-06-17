package ifandswitch;

import java.util.Scanner;

public class SwitchStudy {
	public static void main(String[] args) {
		/*
		 * switch-case - 조건문
		 * 
		 * switch (조건변수) // 조건 변수에 들어갈 수 있는 값은 "정수, 문자, 문자열"만 가능
		 * 		case 값1-1: 값1-2: 값1-3: 값1-4 ...
 		 * 			실행문1;
		 * 			실행문2;
		 * 			실행문3;
		 * 			...
		 * 			break;
		 * 
		 * 		case 값2:
		 * 			실행문1;
		 * 			실행문2;
		 * 			실행문3;
		 * 			...
		 * 			break;
		 * 		...
		 * 
		 * 		default:
		 * 			실행문1
		 */
		
		Scanner sc = new Scanner(System.in);
//		int score = sc.nextInt();
		
//		switch(score) {
//			case 90:
//				System.out.println("성적 A");
//				break;
//			case 80:
//				System.out.println("성적 B");
//				break;
//			case 70:
//				System.out.println("성적 C");
//				break;
//			default:
//				System.out.println("성적 F");
//		}
//		
//		System.out.println("----------------");
		
//		+, 더하기, 플러스
		System.out.print("입력값1 : ");
		int var1 = sc.nextInt();
		System.out.print("입력값2 : ");
		int var2 = sc.nextInt();
		
		System.out.print("연산 입력 : ");
		String op = sc.next();
		
		int result = 0;
		switch(op) {
			case "+": case "더하기": case "plus":
				result = var1 + var2;
				break;
			case "-": case "빼기": case "minus":
				result = var1 - var2;
				break;
			case "*": case "곱하기": case "multiply":
				result = var1 * var2;
				break;
			case "/": case "나누기": case "division":
				result = var1 / var2;
				break;
			default:
				System.out.println("출력 오류");
		}
		System.out.println("결과값: " + result);
		
		sc.close();
	}
}
