package forandwhile;

public class ForStudy {
	public static void main(String args[]) {
		/*
		 * for - 반복문
		 * 
		 * for(1.[초기화식]; 2.조건식; 3.증감식) {
		 * 		- 초기화식은 생략 가능
		 * 		- 조건식은 true, false가 나옴
		 * 		- ++, -- 증감식
		 * 
		 * 		3. 실행문
		 * }
		 * 
		 * 1. 초기화식 -> 2. 조건식 -> 3. 실행문 -> 4. 증감식
		 * 진행 후 2, 3, 4가 반복된다. (2에서 false가 나오면 종료)
		 * 
		 * int i = 0;
		 * for (; i<10; i++) {
		 * 		실행문
		 * }
		 * 
		 * for(int i=0; i<10 && j<10; i++, j++) {
		 * 		실행문
		 * }
		 * 
		 * int i;
		 * for (i=1; i<10; i++) {
		 * 		실행문
		 * }
		 */
		
//		1~10까지의 합
		int sum = 0;
		for (int i=1; i<=10; i++) {
			sum += i;
		}
		System.out.println("1~10까지의 합계: " + sum);
		System.out.println("------------");
		
//		1~50까지 중 5의 배수 값만의 합계를 구하라.
		int sum1 = 0;
		
		for (int i=1; i<=50; i++) {
			if (i % 5 == 0) {
				sum1+= i;
			}
		}
		
		System.out.println("1~50까지 5의 배수 합계: " + sum1);
		
		System.out.println("-------------");
		int sum2 = 0;
		
		for (int i=0; i<=100; i+=10) {
			sum2 += i;
		}
		
		System.out.println("1~100까지 10의 배수 합계: " + sum2);
		System.out.println("-------------");
		
		// 이중 for문
		
		/*
		 * - 2중 for문은 안에 잇는 for문부터 동작을 다하고 밖에 있는 for문 동작
		 * 
		 * for (int i=0; i<=9; i++) {
		 * 		for (int k=0; k<=9; k++) {
		 * 			 실행문
		 * 			- i=0, k=0
		 * 			 실행문
		 *          - i=0, k=1 t
		 *           실행문
		 *          - i=0, k=2 t .... k=9
		 *          ---------------------
		 *           실행문
		 *          - i=1, k=0 t .... k=9
		 * 		}
		 * }
		 * 
		 */
		for (int i=2; i<=9; i++) {
			for (int j=1; j<=9; j++) {
				System.out.println(i + " X " + j + " = " + i * j);				
			}
			System.out.println("-------");
		}
		
//		5X5 별 그리기 (1)
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print("*");				
			}
			System.out.println();
		}
		System.out.println("------------");
		
//		별 그리기 (2)
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("-------------");
//		별 그리기 (3)
		for(int i=5; i>=1; i--) {
			for(int j=i; j>=1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
//		별 그리기 (4)
		for(int i=1; i<=5; i++) {
			for(int j=5; j>=i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
