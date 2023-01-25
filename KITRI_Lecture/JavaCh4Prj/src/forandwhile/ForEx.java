package forandwhile;

import java.util.Scanner;

public class ForEx {

	public static void main(String[] args) {
//		입력값 받아서 100
//		1~100
//		홀수 합만 구하기
				
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int sum = 0;
		
		for (int i=1; i<=num; i++) {
			if (i % 2 == 1) {
				sum += i;
			}
		}
		
		System.out.println(sum);
		
		sc.close();
	}

}
