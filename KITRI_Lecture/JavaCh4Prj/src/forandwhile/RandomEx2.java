package forandwhile;

import java.util.Scanner;

public class RandomEx2 {

	public static void main(String[] args) {
		// ���� ���� �� ����
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("���� ����(1. ����, 2. ����): ");
			int allow = sc.nextInt();
			if (allow == 2) {
				break;
			}
			// ���� : 1, ���� : 2, �� : 3
			System.out.println("1.����, 2.����, 3.��");
			int input = sc.nextInt();
			int random = (int)(Math.random() * 3) + 1;
			
			String input_str = (input == 1) ? "����" : (input == 2) ? "����" : "��";
			String random_str = (random == 1) ? "����" : (random == 2) ? "����" : "��";
			
			System.out.println("���� ��: " + input_str);
			System.out.println("��ǻ���� ��: " + random_str);
			
			if (input > random) {
				if (input == 3 && random == 1) {
					System.out.println("�����ϴ�.");
				} else {
					System.out.println("�̰���ϴ�.");				
				}
			} else if (input == random) {
				System.out.println("�����ϴ�.");
			} else {
				if (input == 1 && random == 3) {
					System.out.println("�̰���ϴ�.");
				} else {
					System.out.println("�����ϴ�.");				
				}
			}
		}
		
		sc.close();
	}

}
