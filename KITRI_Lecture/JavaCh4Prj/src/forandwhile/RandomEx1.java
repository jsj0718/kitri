package forandwhile;

import java.util.Scanner;

public class RandomEx1 {

	public static void main(String[] args) {
		
		// ������ �ϳ��� �ް�, �� ���� ���ߴ� ����
		int random = (int)(Math.random() * 30) + 1;	// 1~30
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		System.out.println("�������� ���߼���!");
		while (true) {
			System.out.print("�Է�: ");
			int input = sc.nextInt();
			
			count++;
			if (input < random) {
				System.out.println("up");
			} else if (input > random) {
				System.out.println("down");
			} else {
				System.out.println(input + " ���� ã�ҽ��ϴ�.");
				break;
			}
		}
		
		System.out.println(count + "������ ã�ҽ��ϴ�.");
		
		sc.close();
	}

}
