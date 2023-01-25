package forandwhile;

import java.util.Scanner;

public class RandomEx2 {

	public static void main(String[] args) {
		// 가위 바위 보 게임
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("진행 여부(1. 진행, 2. 중지): ");
			int allow = sc.nextInt();
			if (allow == 2) {
				break;
			}
			// 가위 : 1, 바위 : 2, 보 : 3
			System.out.println("1.가위, 2.바위, 3.보");
			int input = sc.nextInt();
			int random = (int)(Math.random() * 3) + 1;
			
			String input_str = (input == 1) ? "가위" : (input == 2) ? "바위" : "보";
			String random_str = (random == 1) ? "가위" : (random == 2) ? "바위" : "보";
			
			System.out.println("나의 값: " + input_str);
			System.out.println("컴퓨터의 값: " + random_str);
			
			if (input > random) {
				if (input == 3 && random == 1) {
					System.out.println("졌습니다.");
				} else {
					System.out.println("이겼습니다.");				
				}
			} else if (input == random) {
				System.out.println("비겼습니다.");
			} else {
				if (input == 1 && random == 3) {
					System.out.println("이겼습니다.");
				} else {
					System.out.println("졌습니다.");				
				}
			}
		}
		
		sc.close();
	}

}
