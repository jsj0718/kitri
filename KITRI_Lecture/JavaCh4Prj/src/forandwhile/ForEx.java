package forandwhile;

import java.util.Scanner;

public class ForEx {

	public static void main(String[] args) {
//		�Է°� �޾Ƽ� 100
//		1~100
//		Ȧ�� �ո� ���ϱ�
				
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
