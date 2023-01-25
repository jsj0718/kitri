package ifandswitch;

import java.util.Scanner;

public class IfStudy {
	public static void main(String[] args) {
		/*
		 * if문 - 조건문
		 * 
		 * if (조건식) {	// 조건식에는 true, false가 나오는 boolean, 비교(> == ...), 논리(&&, ||) 등
		 * 		조건식이 true일 때 동작
		 * } 
		 * 
		 * if (조건식) {
		 * 		조건식이 true일 때 동작
		 * } else {
		 * 		조건식이 false일 때 동작
		 * }
		 * 
		 * 	- else if는 개수 제한이 없다.
		 * if (조건식1) {
		 * 		조건식1이 true일 때 동작
		 * } else if (조건식2) {
		 * 		조건식1이 false, 조건식2가 true일 때 동작
		 * } else {
		 * 		조건식1, 조건식2가 false일 떄 동작
		 * }
		 */
		
		int num = 5;
		
		if(num % 3 ==0) {
			System.out.println("3의 배수 O");
		} else {
			System.out.println("3의 배수 X");
		}		
		System.out.println("--------------");
		
		if (num % 5 == 0) 
			System.out.println("5의 배수 O");
		else 
			System.out.println("5의 배수 X");
		
		System.out.println("if else 문에 포함되지 않은 출력");
		System.out.println("--------------");
		
		// 국어, 영어, 수학 점수의 총점, 평균, 학점	
		// ctrl + shift + o : 자동 import 수행
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수 : ");
		int kor = sc.nextInt();
		System.out.print("영어 점수 : ");
		int eng = sc.nextInt();
		System.out.print("수학 점수 : ");
		int math = sc.nextInt();
				
		if (kor >= 90) {
			System.out.println("국어 학점은 A");
		} else if (kor >= 80) {
			System.out.println("국어 학점은 B");
		} else if (kor >= 70 ) {
			System.out.println("국어 학점은 C");
		} else if (kor >= 60 ) {
			System.out.println("국어 학점은 D");
		} else {
			System.out.println("국어 학점은 F");
		}
		
		if (eng >= 90) {
			System.out.println("영어 학점은 A");
		} else if (eng >= 80) {
			System.out.println("영어 학점은 B");
		} else if (eng >= 70 ) {
			System.out.println("영어 학점은 C");
		} else if (eng >= 60 ) {
			System.out.println("영어 학점은 D");
		} else {
			System.out.println("영어 학점은 F");
		}
		
		if (math >= 90) {
			System.out.println("수학 학점은 A");
		} else if (math >= 80) {
			System.out.println("수학 학점은 B");
		} else if (math >= 70 ) {
			System.out.println("수학 학점은 C");
		} else if (math >= 60 ) {
			System.out.println("수학 학점은 D");
		} else {
			System.out.println("수학 학점은 F");
		}
		
		System.out.println("총합 : " + (kor + eng + math));
		System.out.println("평균 : " + (kor + eng + math) / 3);
		
		sc.close();
	}
}
