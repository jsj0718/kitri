package forandwhile;

import java.util.Scanner;

public class WhileEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�Է�1 : ");
		int input1 = sc.nextInt();
		System.out.print("�Է�2 : ");
		int input2 = sc.nextInt();
		
		int sum = input1 + input2;
		
		while (true) {			
			System.out.print("�Է� : ");
			input1 = sc.nextInt();
			sum += input1;
			System.out.println("�հ� : " + sum);
			
			if (sum > 100) {
				break;
			}
		}
		
		sc.close();
	}

}
