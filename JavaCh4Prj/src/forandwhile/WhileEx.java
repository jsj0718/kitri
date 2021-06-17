package forandwhile;

import java.util.Scanner;

public class WhileEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력1 : ");
		int input1 = sc.nextInt();
		System.out.print("입력2 : ");
		int input2 = sc.nextInt();
		
		int sum = input1 + input2;
		
		while (true) {			
			System.out.print("입력 : ");
			input1 = sc.nextInt();
			sum += input1;
			System.out.println("합계 : " + sum);
			
			if (sum > 100) {
				break;
			}
		}
		
		sc.close();
	}

}
